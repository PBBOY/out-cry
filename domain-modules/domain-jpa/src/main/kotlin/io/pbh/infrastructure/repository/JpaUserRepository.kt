package io.pbh.infrastructure.repository

import io.pbh.infrastructure.entity.UserEntity
import io.pbh.infrastructure.jpa.SpringJpaUserRepository
import io.pbh.user.domain.model.User
import io.pbh.user.domain.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class JpaUserRepository(
    private val springJpaUserRepository: SpringJpaUserRepository
) : UserRepository {
    override fun save(user: User): User {
        return springJpaUserRepository.save(UserEntity.of(user)).to()
    }

    override fun findById(id: String): User? {
        return springJpaUserRepository.findByIdOrNull(id)?.to()
    }

    override fun findByEmail(email: String): User? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<User> {
        return springJpaUserRepository.findAll().map { it.to() }
    }
}