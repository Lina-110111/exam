package cn.edu.sicnu.cs.hln.exam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter 是连接数据和 RecyclerView 的桥梁
class HistoryAdapter(private val dataList: List<HistoryItem>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    // 绑定 item 布局
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvExpression: TextView = view.findViewById(R.id.tv_history_expression)
        val tvResult: TextView = view.findViewById(R.id.tv_history_result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.tvExpression.text = "算式: ${item.expression}"
        holder.tvResult.text = "结果: ${item.result}"
    }

    override fun getItemCount(): Int = dataList.size
}