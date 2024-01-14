package com.team07.lmc.domain.recruit.exceptions

class DuplicatedException(override val message: String) : RuntimeException(message) {
}