package com.xingyun.evendemo.view.searchview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.view.CollapsibleActionView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.LayoutTransactionalSearchBinding

class TransactionalSearchView : ConstraintLayout, CollapsibleActionView {
    constructor(context: Context?) : super(context) {
        initAttribute(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initAttribute(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttribute(attrs)
    }

    private lateinit var binding: LayoutTransactionalSearchBinding
    private var isActionViewExpanded = false
    private var collapsedImeOptions = 0

    private val onClickListener = OnClickListener {
        when (it) {
            binding.ivFilter ->
                onFilter()
            binding.ivSearch ->
                onActionViewExpanded()
            binding.ivClose ->
                onCloseClicked()
        }
    }

    private fun initAttribute(attrs: AttributeSet?) {
        DataBindingUtil.inflate<LayoutTransactionalSearchBinding>(LayoutInflater.from(context), R.layout.layout_transactional_search, this, true)
                .also { binding = it }
                .apply {
                    etSearch.addTextChangedListener(object : TextWatcher {
                        override fun afterTextChanged(s: Editable?) {
                        }

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        }

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                        }
                    })

                    ivClose.setOnClickListener(onClickListener)
                    ivFilter.setOnClickListener(onClickListener)
                    ivSearch.setOnClickListener(onClickListener)
                }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (!isActionViewExpanded) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }

        val maxWidth = Int.MAX_VALUE
        var widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var width = MeasureSpec.getSize(widthMeasureSpec)

        when (widthMode) {
            MeasureSpec.AT_MOST ->
                width = maxWidth.coerceAtMost(width)
            MeasureSpec.EXACTLY ->
                width = maxWidth.coerceAtMost(width)
            MeasureSpec.UNSPECIFIED ->
                width = maxWidth
        }
        widthMode = MeasureSpec.EXACTLY
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, widthMode), heightMeasureSpec)
    }


    override fun onActionViewCollapsed() {
        isActionViewExpanded = false
        binding.isActionViewExpanded = true
        binding.etSearch.imeOptions = collapsedImeOptions
    }

    override fun onActionViewExpanded() {
        if (isActionViewExpanded) return

        isActionViewExpanded = true
        binding.isActionViewExpanded = true
        collapsedImeOptions = binding.etSearch.imeOptions
        binding.etSearch.imeOptions = collapsedImeOptions.and(EditorInfo.IME_FLAG_NO_FULLSCREEN)
        binding.etSearch.requestFocus()
        setImeVisibility(true)
    }

    private fun updateCloseButton() {

    }

    private fun updateFilter() {

    }

    private fun onCloseClicked() {
        if (binding.etSearch.text.isNullOrEmpty()) {
            clearFocus()
        } else {
            binding.etSearch.setText("")
            binding.etSearch.requestFocus()
            setImeVisibility(true)
        }
    }

    private fun onFilter() {

    }

    private fun setImeVisibility(visible: Boolean) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (!visible) {
            imm.hideSoftInputFromWindow(windowToken, 0)
            return
        }

        if (imm.isActive(this)) {
            imm.showSoftInput(this, 0)
            return
        }
    }

    override fun clearFocus() {
        super.clearFocus()
        binding.etSearch.clearFocus()
    }
}