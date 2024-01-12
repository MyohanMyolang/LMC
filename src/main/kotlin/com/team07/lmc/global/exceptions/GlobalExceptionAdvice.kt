package com.team07.lmc.global.exceptions

import com.team07.lmc.api.util.responseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionAdvice {

	@ExceptionHandler(MethodArgumentNotValidException::class)
	fun dtoValidateError(error: MethodArgumentNotValidException) = responseEntity(HttpStatus.BAD_REQUEST) {
		val errorMap = mutableMapOf<String, String>()

		error.bindingResult.fieldErrors.forEach {
			errorMap[it.field] = it.defaultMessage ?: "정의되지 않은 에러"
		}

		errorMap
	}

	@ExceptionHandler(NotFoundTargetException::class)
	fun notFoundTargetError(error: NotFoundTargetException) = responseEntity(HttpStatus.NOT_FOUND) {
		error.message
	}


}