package com.example.calculadoragrados

class TemperatureConverter {
    fun toFahrenheit(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    fun toKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    fun toRankine(celsius: Double): Double {
        return (celsius * 9 / 5) + 491.67
    }
}