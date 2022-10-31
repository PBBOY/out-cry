package io.pbh.outcry.application.usecase

import io.pbh.infrastructure.repository.JpaUserRepository
import io.pbh.outcry.application.usecase.model.OAuthAttributes
import io.pbh.outcry.application.usecase.model.SessionUser
import io.pbh.user.domain.model.User
import io.pbh.user.domain.repository.UserRepository
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.HttpSession

@Service
class CustomOAuth2Service(
    val userRepository: JpaUserRepository,
    val httpSession: HttpSession
) : OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {
        val delegate = DefaultOAuth2UserService()
            .loadUser(userRequest)

        val registrationId = userRequest?.clientRegistration?.registrationId!!
        val userNameAttribute = userRequest.clientRegistration?.clientName!!

        with(OAuthAttributes.of(registrationId, userNameAttribute, delegate.attributes)) {
            upsert(attributes = this).let { user ->
                httpSession.setAttribute("user", SessionUser(user.name!!, user.email, user.picture))
                return DefaultOAuth2User(
                    Collections.singleton(SimpleGrantedAuthority(user.role.name)),
                    this.attributes,
                    this.nameAttributeKey
                )
            }
        }
    }

    private fun upsert(attributes: OAuthAttributes): User {
        return with(userRepository) {
            this.findByEmail(attributes.email)?.let {
                this.save(it)
            } ?: this.save(attributes.of())
        }
    }
}