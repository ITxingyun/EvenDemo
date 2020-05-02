package com.xingyun.evendemo.view.shareelement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xingyun.evendemo.databinding.FragmentShareElementBinding

class ShareElementFragment : Fragment() {
    private lateinit var binding: FragmentShareElementBinding
    private lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        text = arguments?.getString("share") ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentShareElementBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.image.transitionName = text
    }

    companion object {
        fun newInstance(text: String): ShareElementFragment =
                ShareElementFragment().apply {
                    arguments = Bundle().apply {
                        putString("share", text)
                    }
                }
    }
}