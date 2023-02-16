package com.lanaafana.automobile.businessLayer

import com.lanaafana.automobile.persistence.AutoRepository
import org.springframework.stereotype.Service

@Service
class AutoService(private val autoRepository: AutoRepository) {
    fun findAllAuto(): List<Auto> {
        return autoRepository.selectAllAuto().also {
            println(it.joinToString())
        }
    }

    fun findAllTest(): List<Test> {
        return autoRepository.selectAllTest().also {
            println(it.joinToString())
        }
    }
}
