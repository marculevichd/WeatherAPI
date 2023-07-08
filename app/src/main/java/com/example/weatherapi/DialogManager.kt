package com.example.weatherapi

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText

object DialogManager {

    fun locationSettingsDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Enable Location")
        dialog.setMessage("Location disabled, do you want enable location?")
        dialog.setButton(
            AlertDialog.BUTTON_POSITIVE, "OK"
        ) { _, _ ->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(
            AlertDialog.BUTTON_NEGATIVE, "Cansel"
        ) { _, _ ->
            dialog.dismiss()
        }
        dialog.show()
    }


    fun searchByNameDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val edName: EditText = EditText(context)
        builder.setView(edName)

        val dialog = builder.create()
        dialog.setTitle("City name")
        dialog.setButton(
            AlertDialog.BUTTON_POSITIVE, "OK"
        ) { _, _ ->
            listener.onClick(edName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(
            AlertDialog.BUTTON_NEGATIVE, "Cansel"
        ) { _, _ ->
            dialog.dismiss()
        }
        dialog.show()
    }


    interface Listener {
        fun onClick(name:String?)
    }

}