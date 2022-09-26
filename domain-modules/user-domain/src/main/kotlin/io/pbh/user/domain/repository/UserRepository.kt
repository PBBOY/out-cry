package io.pbh.user.domain.repository

import io.pbh.user.domain.model.User

interface UserRepository {
    fun save(user: User): User
    fun findById(id: String): User?
    fun findByEmail(email: String): User?
    fun findAll(): List<User>
}