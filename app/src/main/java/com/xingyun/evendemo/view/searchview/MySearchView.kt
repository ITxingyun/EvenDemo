package com.xingyun.evendemo.view.searchview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.SearchView
import com.xingyun.evendemo.R

class MySearchView : SearchView {
    private var searchKey = ""

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        queryHint = context.getString(R.string.menu_search)
    }

    override fun setQuery(query: CharSequence?, submit: Boolean) {
        if (!query.isNullOrEmpty()) {
            super.setQuery(query, submit)
            searchKey = query.toString()
        }
    }

    override fun onActionViewExpanded() {
        super.onActionViewExpanded()
        setQuery(searchKey, false)
    }

    override fun onActionViewCollapsed() {
        super.onActionViewCollapsed()
        setQuery(searchKey, false)
    }

}