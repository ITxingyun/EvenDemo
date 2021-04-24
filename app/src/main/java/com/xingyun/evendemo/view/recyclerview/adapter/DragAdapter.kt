package com.xingyun.evendemo.view.recyclerview.adapter

import android.util.Log
import com.xingyun.evendemo.view.recyclerview.IItemTouchHelperAdapter
import java.util.*

class DragAdapter(private val data: MutableList<String>): SimpleTextAdapter(data), IItemTouchHelperAdapter {

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        Collections.swap(data, fromPosition, toPosition)
        Log.e("chenyiwen", "onItemMove: fromPosition = $fromPosition  toPosition = $toPosition")
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        data.removeAt(position)
        Log.e("chenyiwen", "onItemDismiss: position = $position")
        notifyItemRemoved(position)
    }
}