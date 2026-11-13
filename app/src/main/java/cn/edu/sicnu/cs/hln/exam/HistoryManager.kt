package cn.edu.sicnu.cs.hln.exam

object HistoryManager {
    // 创建一个列表来存历史记录，其他 Activity 都可以访问它
    val historyList = mutableListOf<HistoryItem>()
}