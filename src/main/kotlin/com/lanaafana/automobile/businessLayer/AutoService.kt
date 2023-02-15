package com.lanaafana.automobile.businessLayer

import com.lanaafana.automobile.persistence.AutoRepository
import org.jooq.Record2
import org.jooq.Result
import org.springframework.stereotype.Service

@Service
class AutoService(private val autoRepository: AutoRepository) {

    fun findAllAuto(): List<Auto> {
        return autoRepository.selectAllAuto().also {
            println(it.joinToString())
        }
    }

    fun findAllTest(): Result<Record2<Int, String>> {
        return autoRepository.selectAllTest().also {
            println(it.joinToString())
        }
    }
}