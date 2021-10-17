package com.example.myapplication
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var  isNop = true
    var oldNumber = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.landscape)
            Toast.makeText(this,"your are in lanScape",Toast.LENGTH_LONG).show()
        }
        fun numberEvent(view: android.view.View) {
            if(isNop)
                txt.setText("")
            isNop = false
            var buClick : String = txt.text.toString()
            var buSelect : Button = view as Button
            when(buSelect.id){
                btn1.id -> {
                    buClick += "1"}
                btn2.id -> {
                    buClick += "2"}
                btn3.id -> {
                    buClick += "3"}
                btn4.id -> {
                    buClick += "4"}
                btn5.id -> {
                    buClick += "5"}
                btn6.id -> {
                    buClick += "6"}
                btn7.id -> {
                    buClick += "7"}
                btn8.id -> {
                    buClick += "8"}
                btn9.id -> {
                    buClick += "9"}
                btn0.id -> {
                    buClick += "0"}

            }
            txt.setText(buClick)


        }

    }
    fun operaterEvent(view: android.view.View) {
        isNop =true
        oldNumber = txt.text.toString()
        var buselect:Button = view as Button
        when(buselect.id){
            multiply.id ->{
                op = "*"
            }
            Divide.id ->{
                op = "/"
            }
            btnPlus.id ->{
                op = "+"
            }
            multiply.id ->{
                op = "*"
            }
            btn_ac.id ->{
                op = "-"
            }
        }
        editText.setText(op)

    }

    fun equalEvent(view: android.view.View) {
        var newNumber :String =editText.text.toString()
        var result =0.0
        when(op){
            "+"->{result =oldNumber.toDouble() + newNumber.toDouble()}
            "-"->{result =oldNumber.toDouble() - newNumber.toDouble()}
            "/"->{result =oldNumber.toDouble() / newNumber.toDouble()}
            "*"->{result =oldNumber.toDouble() * newNumber.toDouble()}

        }
        editText.setText(result.toString())
    }

    fun Clear(view: android.view.View) {
        editText.setText("")
    }

}