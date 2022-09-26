package io.pbh.outcry.application.model

import io.pbh.user.domain.enums.RoleType
import io.pbh.user.domain.model.User

data class OAuthAttributes(
    val attributes: Map<String, Any>,
    val nameAttributeKey: String,
    val name: String,
    val email: String,
    val picture: String,
    val registrationId: String
) {
    companion object {
        fun of(registrationId: String, userNameAttribute: String, attributes: Map<String, Any>): OAuthAttributes {
            return OAuthAttributes(
                attributes = attributes,
                name = attributes["name"] as String,
                email = attributes["email"] as String,
                picture = attributes["picture"] as String,
                nameAttributeKey = userNameAttribute,
                registrationId = registrationId
            )
        }
    }

    fun of() : User {
        return User(
            id = registrationId,
            email = email,
            verifiedEmail = null,
            givenName = name,
            familyName = null,
            picture = picture,
            locale = null,
            role = RoleType.GUEST
        ).also {
            it.name = name
        }
    }
}