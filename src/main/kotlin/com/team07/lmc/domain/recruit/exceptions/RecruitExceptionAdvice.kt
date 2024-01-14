package com.team07.lmc.domain.recruit.exceptions

import com.team07.lmc.api.util.responseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackages = ["com.team07.lmc.api.recruit"])
class RecruitExceptionAdvice {


	@ExceptionHandler(ClosedException::class)
	fun closedError(error: ClosedException) = responseEntity(HttpStatus.NOT_ACCEPTABLE) {
		error.message
	}

	@ExceptionHandler(NoOptionException::class)
	fun noOptionException(error: NoOptionException) = responseEntity(HttpStatus.BAD_REQUEST) {
		error.message
	}

	@ExceptionHandler(ProceededException::class)
	fun proceededError(error: ProceededException) = responseEntity(HttpStatus.BAD_REQUEST) {
		error.message
	}

	@ExceptionHandler(DuplicatedException::class)
	fun duplicatedException(error: DuplicatedException) = responseEntity(HttpStatus.BAD_REQUEST) {
		error.message
	}
}