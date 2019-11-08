package com.example.simplecaculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity(), View.OnClickListener{

    private var flag=""
    private var num:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_clear.setOnClickListener(this)
        btn_point.setOnClickListener(this)
        btn_add.setOnClickListener(this)
        btn_reduce.setOnClickListener(this)
        btn_mul.setOnClickListener(this)
        btn_divide.setOnClickListener(this)
        btn_del.setOnClickListener(this)
        btn_equal.setOnClickListener(this)
    }
    override fun onClick(v:View) {
        doClick(""+(v as Button).text)
    }
    private fun doClick(value:String){
        if(value.isNotEmpty()){
            if(value.equals("DEL")){
                var s:String=show.getText().toString()
                num=s.substring(0,s.length-1)
                show.text=num
            }
            else if(value.equals("=")) {
                var s:String=show.text.toString()
                doCount(s)
            }
            else if(value.equals("C")){
                num=""
                show.text=""
                flag = ""
            }
            else {
                num = num + value
                show.text=num
            }
        }
    }
    private fun doCount(flag:String){
        var result:Double = 0.0
        var w:Array<String>
        var op:Int=flag.indexOf("+")
        if(op!=-1){
            w= flag.split("+").toTypedArray()
            result=w[0].toDouble()+w[1].toDouble()
        }
        var op1:Int=flag.indexOf("－")
        if(op1!=-1){
            w= flag.split("－").toTypedArray()
            result=w[0].toDouble()-w[1].toDouble()
        }
        var op2:Int=flag.indexOf("÷")
        if(op2!=-1){
            w= flag.split("÷").toTypedArray()
            var cs:Double=w[1].toDouble()
            if(cs!=0.0) {
                result = w[0].toDouble() / w[1].toDouble()
            }
            else{
                num=""
                show.text="除数不能为0"
                return
            }
        }
        var op3:Int=flag.indexOf("×")
        if(op3!=-1){
            w= flag.split("×").toTypedArray()
            result=w[0].toDouble()*w[1].toDouble()
        }
        num=result.toString()
        show.text=result.toString()
    }
}
