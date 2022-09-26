package io.pbh.user.domain.model

import io.pbh.user.domain.enums.RoleType

data class User(
    var id: String,
    val email: String,
    val verifiedEmail: String?,
    val givenName: String,
    val familyName: String?,
    val picture: String,
    val locale: String?,
    val role: RoleType
) {

    var name: String? = null
}