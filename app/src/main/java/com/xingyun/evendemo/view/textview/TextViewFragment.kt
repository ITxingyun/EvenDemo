package com.xingyun.evendemo.view.textview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentTextViewBinding

class TextViewFragment : BaseFragment() {
    private lateinit var binding: FragmentTextViewBinding

    override val toolbarTitle: String = "TextView"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentTextViewBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTest.isSelected = true

        val dp20 = context?.resources?.getDimension(R.dimen.dp_20)?.toInt() ?: 50
        binding.tvImage.setImageAndText(dp20, dp20,
                StringType(StringType.Typo.TYPE_STRING, R.string.tab_view),
                StringType(StringType.Typo.TYPE_IMAGE, R.drawable.bg_yao),
                StringType(StringType.Typo.TYPE_STRING, R.string.tab_view)
        )

        context?.let {
            binding.tvImageText.text =
                    CustomSpannableStringBuilder()
                            .addString("MultipleSpannableString: ")
                            .addImage(it, R.drawable.bg_muscle, dp20, dp20)
                            .addString("String")
        }
    }


}