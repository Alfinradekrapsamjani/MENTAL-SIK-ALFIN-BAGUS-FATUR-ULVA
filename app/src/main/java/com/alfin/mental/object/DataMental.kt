package com.alfin.mental.`object`

import com.alfin.mental.data.Mental
import com.dendi.organ.R

object DataMental {
    private val mentalNames = arrayOf(
        "Kecemasan",
        "PTSD",
        "Bipolar",
        )

    private val mentalImages = arrayOf( R.drawable.kecemasan,
         R.drawable.ptsd,
         R.drawable.bipolar,
         R.drawable.npd,
        )
    private val mentalDetails = arrayOf(
        "Gangguan kecemasan umum (GAD) adalah kondisi kesehatan mental yang menyebabkan rasa takut, perasaan kewalahan yang terus-menerus, dan kekhawatiran berlebihan tentang hal-hal sehari-hari. Kondisi ini dapat memengaruhi anak-anak dan orang dewasa, dan dapat ditangani dengan terapi bicara dan/atau pengobatan."
        ,

        "Post-Traumatic Stress Disorder (PTSD) adalah gangguan kesehatan mental yang dapat terjadi pada seseorang setelah mengalami atau menyaksikan peristiwa traumatis. PTSD dapat memengaruhi orang dari segala usia, jenis kelamin, dan latar belakang sosial. "
        ,

        "Gangguan bipolar, atau juga dikenal sebagai gangguan afektif bipolar, adalah gangguan mental yang menyebabkan perubahan suasana hati secara drastis. Penderita gangguan bipolar akan mengalami episode mania atau hipomania yang bergantian dengan depresi."
        ,

        " NPD adalah gangguan kepribadian yang ditandai dengan harga diri yang sangat tinggi, kebutuhan untuk dikagumi, dan kurangnya empati.\n" +
                "\n" +
                "Orang dengan NPD secara berlebihan merasa dirinya penting dan sering membanggakan kemampuannya. Gejala-gejala gangguan ini biasanya muncul sejak usia dewasa awal.\n" +
                "\n" +
                "NPD memiliki potensi merugikan diri sendiri secara psikologis dan kualitas interaksi sosial dengan orang lain. Oleh karena itu, kesadaran tentang ciri-ciri NPD perlu dipahami bersama untuk kesehatan mental yang lebih baik."
        ,



        "Hati merupakan sebuah kelenjar yang \"terbesar\" di dalam tubuh manusia, " +
            "ini terletak dalam rongga perut sebelah kanan, tepatnya di bawah diafragma. " +
            "Berdasarkan fungsinya, hati juga termasuk sebagai alat ekskresi. " +
            "Hal ini dikarenakan hati membantu fungsi ginjal dengan cara memecah beberapa senyawa " +
            "yang bersifat racun dan menghasilkan amonia, urea, dan asam urat dengan memanfaatkan nitrogen dari asam amino. " +
            "Proses pemecahan senyawa racun oleh hati disebut proses detoksifikasi."
        ,
    )


    val listData: ArrayList<Mental>
        get() {
            val list = arrayListOf<Mental>()
            for (position in mentalNames.indices) {
                val hero = Mental()
                hero.name = mentalNames[position]
                hero.detail = mentalDetails[position]
                hero.photo = mentalImages[position]

        list.add(hero)
    }

            return list
        }
}