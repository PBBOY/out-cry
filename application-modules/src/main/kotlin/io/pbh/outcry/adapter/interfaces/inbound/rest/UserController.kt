package io.pbh.outcry.adapter.interfaces.inbound.rest

import io.pbh.user.domain.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String): ResponseEntity<Void> {
        return ResponseEntity.ok().build()
    }
}