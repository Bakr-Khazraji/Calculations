package com.example.addtwonumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button =findViewById(R.id.btn)
        val edtxt1:EditText =findViewById(R.id.num1)
        val edtxt2:EditText =findViewById(R.id.num2)
        val ans:TextView =findViewById(R.id.resultText)
        val headr:TextView =findViewById(R.id.headText)
        var flag: String="sum"
        val spinvariable: Spinner=findViewById(R.id.spinid)
        var operations=arrayOf("Sum","Multiply")
        headr.text="Select operation"
        button.text="Calculate"
        ans.text="RESULT"
        button.setOnClickListener{view ->
            var x:Int =edtxt1.text.toString().toInt()
            var y:Int =edtxt2.text.toString().toInt()
            if(flag=="Sum") {
                ans.text = "The result is " + sum(x, y).toString()
            }
            else {
                ans.text = "The result is " + mult(x, y).toString()
            }
        }
        spinvariable.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,operations)
        spinvariable.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag=operations.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}

public fun sum(a: Int,b: Int):Int{
    return a+b
}
public fun mult(a: Int,b: Int):Int{
    return a*b
}