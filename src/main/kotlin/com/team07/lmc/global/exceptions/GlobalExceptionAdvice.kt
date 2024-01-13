package com.team07.lmc.global.exceptions

import com.team07.lmc.api.util.responseEntity
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
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

	@ExceptionHandler(UnauthorizedException::class)
	fun unauthorizedError(error: UnauthorizedException) = responseEntity(HttpStatus.UNAUTHORIZED) {
		error.message
	}

	@ExceptionHandler(AlreadyHasMember::class)
	fun alreadyHasMemberError(error: AlreadyHasMember) = responseEntity(HttpStatus.CONFLICT) {
		error.message
	}

	@ExceptionHandler(AccessAuthException::class)
	fun accessAuthError(error: AccessAuthException) = responseEntity(HttpStatus.FORBIDDEN) {
		error.message
	}

	@ExceptionHandler(HttpMessageNotReadableException::class)
	fun unusualRequestError(error: HttpMessageNotReadableException) = responseEntity(HttpStatus.BAD_REQUEST) {
		"정상적이지 않은 JSON 요청을 가지고 있습니다."
	}
}