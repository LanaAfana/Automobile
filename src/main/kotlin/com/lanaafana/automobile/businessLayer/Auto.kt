package com.lanaafana.automobile.businessLayer

//import com.google.gson.Gson
//
//fun <T> toJson(obj: T): String {
//    return Gson().toJson(obj); - плохая пркактика создавать каждый раз объект, только для того чтобы вызвать "toJson(obj):
//}
data class Auto(
//    private var id: Long,  - зачем тут private(мы не увидим этих свойств на фронте)  и мутабельные свойства(var),
//    private var brand: String,
//    private var model: String,
//    private var color: String,
//    private var engineNumber: String

    val id: Long,
    val brand: String,
    val model: String,
    val color: String,
    val engineNumber: String
)

data class Test(
    val id: Long,
    val engineNumber: String
)
