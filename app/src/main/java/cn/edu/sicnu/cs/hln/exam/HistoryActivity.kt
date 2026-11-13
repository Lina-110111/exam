package cn.edu.sicnu.cs.hln.exam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        title = "历史记录"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // 设置布局管理器（让列表垂直排列的）
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 把我们在单例里存的数据拿过来，传给 Adapter
        val adapter = HistoryAdapter(HistoryManager.historyList)
        recyclerView.adapter = adapter
    }
}