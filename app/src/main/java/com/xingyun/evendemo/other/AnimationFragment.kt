package com.xingyun.evendemo.other

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import com.xingyun.evendemo.R
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.databinding.FragmentAnimationBinding

/**
 * 参考：https://developer.android.com/guide/topics/resources/animation-resource#Property
 * 1.补间动画
 * 2.帧动画
 * 3.属性动画
 *
 */
class AnimationFragment : BaseFragment() {
    private lateinit var binding: FragmentAnimationBinding

    override val toolbarTitle: String = "动画"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            FragmentAnimationBinding.inflate(inflater, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvStart.setOnClickListener {
            startTweenAnimation(R.anim.top_and_fade_in)
        }

        binding.tvEnd.setOnClickListener {
            startTweenAnimation(R.anim.bottom_fade_out)
        }

        binding.tvStartObjectAnimation.setOnClickListener {
            startObjectAnimator()
        }

        binding.ivShowDialog.setOnClickListener {

        }
    }

    /**
     * 启动补间动画
     */
    private fun startTweenAnimation(@AnimRes animRes: Int) {
        AnimationUtils.loadAnimation(context, animRes).also { binding.ivYao.startAnimation(it) }
    }

    private fun startObjectAnimator() {
        ValueAnimator.ofFloat(0f, 100f)
                .apply {
                    duration = 1000
                    addUpdateListener { updatedAnimation ->
                        binding.ivMuscle.translationX = updatedAnimation.animatedValue as Float
                    }
                    start()
                }
    }

}