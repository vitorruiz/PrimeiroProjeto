package com.example.logonrmlocal.primeiroprojeo.extension

import android.widget.EditText

fun EditText.meuClear() = this.setText("")

fun EditText.value() = this.text.toString()