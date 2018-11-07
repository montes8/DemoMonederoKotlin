package com.example.tayler_gabbi.demo_monedero

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class GraficoActivity : AppCompatActivity() {

    lateinit var chart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico)

        chart=findViewById<LineChart>(R.id.chart)

        //aGREGA UN ALUINEA DE LIMITES AL GRAFICO
        val vpper_limit= LimitLine(65f,"Danger")
        vpper_limit.lineWidth=4f
        vpper_limit.enableDashedLine(10f,10f,0f)
        vpper_limit.labelPosition= LimitLine.LimitLabelPosition.RIGHT_TOP
        vpper_limit.textSize=15f
        val lower_limit= LimitLine(65f,"Danger")
        lower_limit.lineWidth=4f
        lower_limit.enableDashedLine(10f,10f,0f)
        lower_limit.labelPosition= LimitLine.LimitLabelPosition.RIGHT_TOP
        lower_limit.textSize=15f
        val leftAxis=chart.axisLeft
        leftAxis.removeAllLimitLines()
        leftAxis.addLimitLine(vpper_limit)
        leftAxis.addLimitLine(lower_limit)
        leftAxis.axisMaximum=100f
        leftAxis.axisMinimum=25f
        leftAxis.setDrawLimitLinesBehindData(true)
        chart.axisRight.isEnabled=false
        chart.onChartGestureListener


        chart.isDragEnabled
        chart.setScaleEnabled(false)
////////////////////////////////////////////////////////////
        val ingresos:ArrayList<Entry> = ArrayList<Entry>()
        ingresos.add(Entry(0F,60f))
        ingresos.add(Entry(1F,50f))
        ingresos.add(Entry(2F,70f))
        ingresos.add(Entry(3F,30f))
        ingresos.add(Entry(4F,60f))
        val linea1= LineDataSet(ingresos,"Ingresos")
        linea1.color= Color.GREEN
        linea1.lineWidth= 3F
        linea1.valueTextSize=12f
        linea1.fillAlpha=110

/////////////////////////////////////////////////////////
        val egresos:ArrayList<Entry> = ArrayList<Entry>()
        egresos.add(Entry(0F,50f))
        egresos.add(Entry(1F,40f))
        egresos.add(Entry(2F,60f))
        egresos.add(Entry(3F,20f))
        egresos.add(Entry(4F,50f))

        val linea2= LineDataSet(egresos,"Gastos")
        linea2.color= Color.RED
        linea2.valueTextSize=12f
        linea2.lineWidth= 3F
        linea2.fillAlpha=110


        val dataSet=java.util.ArrayList<ILineDataSet>()
        dataSet.add(linea1)
        dataSet.add(linea2)
        val datas: LineData = LineData(dataSet)
        chart.data=datas
    }
}
