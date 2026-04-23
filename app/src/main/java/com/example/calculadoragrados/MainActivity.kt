package com.example.calculadoragrados

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/** Victor Rivas 8-1017-778 */
class MainActivity : AppCompatActivity() {
    private lateinit var converter: TemperatureConverter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        converter = TemperatureConverter()
        val inputCelsius = findViewById<EditText>(R.id.editTextNumber)
        val btnFht = findViewById<Button>(R.id.btn_fht)
        val btnKvl = findViewById<Button>(R.id.btn_kvl)
        val btnRkn = findViewById<Button>(R.id.btn_rkn)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        // Botón Fahrenheit
        btnFht.setOnClickListener {
            val celsius = getCelsiusValor(inputCelsius)
            if (celsius != null) {
                val result = converter.toFahrenheit(celsius)
                txvResultado.text = "$result °F"
            }
        }

        // Botón Rankine
        btnRkn.setOnClickListener {
            val celsius = getCelsiusValor(inputCelsius)
            if (celsius != null) {
                val result = converter.toRankine(celsius)
                txvResultado.text = "$result °R"
            }
        }

        // Botón Kelvin
        btnKvl.setOnClickListener {
            val celsius = getCelsiusValor(inputCelsius)
            if (celsius != null) {
                val result = converter.toKelvin(celsius)
                txvResultado.text = "$result K"
            }
        }
    }


    private fun getCelsiusValor(editText: EditText): Double? {
        val text = editText.text.toString()
        return if (text.isNotEmpty()) {
            text.toDoubleOrNull()
        } else {
            Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
            null
        }
    }
}