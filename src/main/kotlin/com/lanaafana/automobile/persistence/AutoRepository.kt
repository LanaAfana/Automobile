package com.lanaafana.automobile.persistence

import com.lanaafana.automobile.businessLayer.Auto
import com.lanaafana.automobile.businessLayer.Test
import com.lanaafana.automobile.domain.Tables
import org.jooq.*
import org.springframework.stereotype.Repository

@Repository
class AutoRepository (
    private val dslContext: DSLContext)
{
    private val auto = Tables.AUTO
    private val brand = Tables.BRAND
    private val model = Tables.MODEL
    private val color = Tables.COLOR

    fun selectAllAuto(): List<Auto>  { //Result<Record3<Int!, String!, String!>>
        return dslContext
                .select(auto.ID, brand.NAME, model.NAME, color.COLOR_, auto.ENGINE_NUMBER)
                .from(auto)
                .join(brand).on(brand.ID.eq(auto.BRAND_ID))
                .join(model).on(model.ID.eq(auto.MODEL_ID))
                .join(brand).on(color.ID.eq(auto.COLOR_ID))
                .fetch() //Records.mapping(Auto::new))
                .map { it.into(Auto::class.java) }

    }

    fun selectAllTest(): Result<Record2<Int, String>> {
        return dslContext
                .select(auto.ID, auto.ENGINE_NUMBER)
                .from(auto)
                .fetch()


    }
}