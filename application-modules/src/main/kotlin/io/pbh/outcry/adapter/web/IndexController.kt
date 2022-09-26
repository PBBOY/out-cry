package io.pbh.outcry.adapter.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpSession

data class SessionUser(
    val name: String,
    val email: String,
    val picture: String
)

@Controller
class IndexController(
    private val httpSession: HttpSession
) {

    @GetMapping("/")
    fun index(model: Model): String {
        val user = httpSession.getAttribute("user")
        if (user != null) {
            val sessionUser = user as SessionUser
            model.addAttribute("userName", sessionUser.name)
        }

        return "index"
    }
}