package com.team07.lmc.api.util

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


fun <T> responseEntity(status: HttpStatus, func: () -> T): ResponseEntity<T> {
	func.invoke().also { return ResponseEntity.status(status).body(it) }
}