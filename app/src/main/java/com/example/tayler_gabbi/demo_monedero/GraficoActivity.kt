package com.example.tayler_gabbi.demo_monedero

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart

class GraficoActivity : AppCompatActivity() {

    lateinit var chart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico)

        chart=findViewById<LineChart>(R.id.chart)
    }
}
