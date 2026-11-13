package cn.edu.sicnu.cs.hln.exam

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var tvResult: TextView
    private lateinit var rgOperator: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNum1 = findViewById(R.id.et_num1)
        etNum2 = findViewById(R.id.et_num2)
        tvResult = findViewById(R.id.tv_result)
        rgOperator = findViewById(R.id.rg_operator)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val btnHistory = findViewById<Button>(R.id.btn_history)

        // 1. 计算按钮的点击事件
        btnCalculate.setOnClickListener {
            val num1Str = etNum1.text.toString()
            val num2Str = etNum2.text.toString()

            if (num1Str.isEmpty() || num2Str.isEmpty()) {
                Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val num1 = num1Str.toDouble()
            val num2 = num2Str.toDouble()
            val calc = Calculator()
            var result = 0.0
            var operatorStr = ""

            when (rgOperator.checkedRadioButtonId) {
                R.id.rb_add -> { result = calc.add(num1, num2); operatorStr = "+" }
                R.id.rb_sub -> { result = calc.subtract(num1, num2); operatorStr = "-" }
                R.id.rb_mul -> { result = calc.multiply(num1, num2); operatorStr = "*" }
                R.id.rb_div -> { result = calc.divide(num1, num2); operatorStr = "/" }
            }

            val resultStr = result.toString()
            tvResult.text = "$num1 $operatorStr $num2 = $resultStr"

            // 存入历史记录
            HistoryManager.historyList.add(HistoryItem("$num1 $operatorStr $num2", resultStr))
        }

        // 2. 历史记录按钮的点击事件
        btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    // 横竖屏切换保存数据
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("result_text", tvResult.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedResult = savedInstanceState.getString("result_text")
        tvResult.text = savedResult
    }
}