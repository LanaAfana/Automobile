package com.lanaafana.automobile.presentation

import com.lanaafana.automobile.businessLayer.Auto
import com.lanaafana.automobile.businessLayer.AutoService
import com.lanaafana.automobile.businessLayer.Test
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AutoController(private val autoService: AutoService) {
    @GetMapping("/auto")
    fun getAllAuto(): List<Auto> {
        return autoService.findAllAuto()
    }

    @GetMapping("/test")
    fun getAllTest(): List<Test> {
        return autoService.findAllTest()
    }
}
