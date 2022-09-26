package io.pbh.infrastructure.jpa

import io.pbh.infrastructure.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SpringJpaUserRepository : JpaRepository<UserEntity, String>