package io.pbh.user.domain.model

class User(
    val id: String,
    val email: String,
    val verifiedEmail: String,
    val givenName: String,
    val familyName: String,
    val picture: String,
    val locale: String
) {
    var name: String? = null
}