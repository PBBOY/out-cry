package io.pbh.infrastructure.entity

import io.pbh.user.domain.enums.RoleType
import io.pbh.user.domain.model.User
import javax.persistence.*

@Entity
@Table(name = "tb_user")
class UserEntity(
    @Id
    @Column(name = "user_id")
    val id: String,
    val email: String,
    val verifiedEmail: String?,
    val givenName: String,
    val familyName: String?,
    val picture: String,
    val locale: String?,
    @Enumerated(EnumType.STRING)
    val role: RoleType,
    val userName: String?
) {
    companion object {
        fun of(user: User): UserEntity {
            return UserEntity(
                id = user.id,
                email = user.email,
                verifiedEmail = user.verifiedEmail,
                givenName = user.givenName,
                familyName = user.familyName,
                picture = user.picture,
                locale = user.locale,
                role = user.role,
                userName = user.name
            )
        }
    }
    fun to(): User {
        return User(
            id = id,
            email = email,
            verifiedEmail = verifiedEmail,
            givenName = givenName,
            familyName = familyName,
            picture = picture,
            locale = locale,
            role = role
        ).also { u ->
            u.name = userName
        }
    }
}