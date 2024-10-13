package com.example.lab1
import kotlinx.serialization.*


@Serializable
data class Valute(val ID: String, val NumCode: String, val CharCode: String, val Nominal: Int, val Name: String, val Value: Double, val Previous: Double) {
}