package com.lanaafana.automobile.businessLayer

import com.google.gson.Gson

fun <T> toJson(obj: T): String {
    return Gson().toJson(obj);
}
data class Auto(
    private var id: Long,
    private var brand: String,
    private var model: String,
    private var color: String,
    private var engineNumber: String


)

data class Test(
        private var id: Long,
        private var engineNumber: String
)