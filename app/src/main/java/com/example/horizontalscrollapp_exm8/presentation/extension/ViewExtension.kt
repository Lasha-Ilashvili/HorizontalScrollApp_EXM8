package com.example.horizontalscrollapp_exm8.presentation.extension

import android.view.View
import android.widget.Toast

fun View.showToast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}