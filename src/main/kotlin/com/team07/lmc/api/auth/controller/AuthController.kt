package com.team07.lmc.api.auth.controller

import com.team07.lmc.api.auth.service.AuthService
import com.team07.lmc.common.domain.member.auth.dto.SignDto
import com.team07.lmc.api.util.responseEntity
import com.team07.lmc.common.domain.member.auth.dto.SignInDto
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
	private val authService: AuthService
) {

	@PostMapping("/signup")
	fun signUp(@RequestBody @Valid signDto: SignDto) = responseEntity(HttpStatus.CREATED) {
		authService.signUp(signDto)
	}

	@GetMapping("/signin")
	fun signIn(@RequestBody @Valid signDto: SignInDto) = responseEntity(HttpStatus.OK) {
		authService.signIn(signDto)
	}
}