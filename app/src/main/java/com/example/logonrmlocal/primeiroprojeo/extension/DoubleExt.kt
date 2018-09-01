package com.example.logonrmlocal.primeiroprojeo.extension

fun Double.format(digits: Int) = String.format("%.${digits}f", this)