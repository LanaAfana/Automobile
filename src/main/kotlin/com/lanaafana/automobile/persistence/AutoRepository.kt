package com.lanaafana.automobile.persistence

import com.lanaafana.automobile.businessLayer.Auto
import com.lanaafana.automobile.businessLayer.Test
import com.lanaafana.automobile.jooq.Tables
import org.jooq.*
import org.springframework.stereotype.Repository

@Repository
class AutoRepository(
    private val dslContext: DSLContext,
) {
    private val auto = Tables.AUTO
    private val brand = Tables.BRAND
    private val model = Tables.MODEL
    private val color = Tables.COLOR

    fun selectAllAuto(): List<Auto> { //Result<Record3<Int!, String!, String!>>
        return dslContext
            .select(
                auto.ID,
                brand.NAME.`as`("brand"), // если явно не указать имена свойствам,
                model.NAME.`as`("model"), // то ничего не смапиться автоматом, так как имена в дата класе не совпадают с именами свойст в запросе
                color.COLOR_.`as`("color"), // + еще "name" повторяется 2-раза
                auto.ENGINE_NUMBER
            )
            .from(auto)
            .join(brand).on(brand.ID.eq(auto.BRAND_ID))
            .join(model).on(model.ID.eq(auto.MODEL_ID))
            .join(color).on(color.ID.eq(auto.COLOR_ID))
            // .join(brand).on(color.ID.eq(auto.COLOR_ID)) // "джойнится" второй раз таблица брендов
            // .fetch() //Records.mapping(Auto::new))
            // .map { it.into(Auto::class.java) }
            .fetchInto(Auto::class.java) // лучше использовать маппер который предастовляет jooq
    }

    fun selectAllTest(): List<Test> { // Result<Record2<Int, String>>  - плохая практика передавать результат в сыром виде, с учетом того, что для результата есть уже обертка
        return dslContext
            .select(auto.ID, auto.ENGINE_NUMBER)
            .from(auto)
            .fetchInto(Test::class.java) // лучше использовать маппер который предастовляет jooq
    }
}
