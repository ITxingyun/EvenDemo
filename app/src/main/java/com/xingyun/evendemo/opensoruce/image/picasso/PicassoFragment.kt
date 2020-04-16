package com.xingyun.evendemo.opensoruce.image.picasso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.xingyun.evendemo.common.ui.BaseFragment
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.FragmentPicassoBinding

class PicassoFragment : BaseFragment() {
    private lateinit var binding: FragmentPicassoBinding

    override val toolbarTitle: String = "Picasso"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentPicassoBinding>(inflater, R.layout.fragment_picasso, container, false)
            .also { binding = it }
            .root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val imageUrls = listOf(
//            "https://www.google.com/imgres?imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D444042255679543&imgrefurl=https%3A%2F%2Fwww.facebook.com%2F%25E6%25AD%25A3%25E5%25A6%25B9%25E7%25BE%258E%25E5%25A5%25B3%25E5%2588%2586%25E4%25BA%25AB%25E5%259C%2598-444042255679543%2F&docid=0cvFLx0nlHWctM&tbnid=GbRaMh4NbhwylM%3A&vet=10ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgpKAAwAA..i&w=640&h=640&bih=789&biw=1920&q=%E7%BE%8E%E5%A5%B3&ved=0ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgpKAAwAA&iact=mrc&uact=8",
//            "https://www.google.com/imgres?imgurl=http%3A%2F%2Fpuui.qpic.cn%2Fvcover_vt_pic%2F0%2Fgozy3av1tsva9swt1469187012.jpg%2F0&imgrefurl=https%3A%2F%2Fv.qq.com%2Fdetail%2Fg%2Fgozy3av1tsva9sw.html&docid=PufgVOwQV9VkdM&tbnid=UMFzTwPE4R3AVM%3A&vet=10ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgqKAEwAQ..i&w=770&h=1079&bih=789&biw=1920&q=%E7%BE%8E%E5%A5%B3&ved=0ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgqKAEwAQ&iact=mrc&uact=8",
//            "https://www.google.com/imgres?imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D484591328217765&imgrefurl=https%3A%2F%2Fwww.facebook.com%2F90sBeauties%2F&docid=AZGQq97mstb8CM&tbnid=y9_LPMwWwOYNEM%3A&vet=10ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgrKAIwAg..i&w=721&h=960&bih=789&biw=1920&q=%E7%BE%8E%E5%A5%B3&ved=0ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgrKAIwAg&iact=mrc&uact=8",
//            "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.chinatimes.com%2Fnewsphoto%2F2019-09-10%2F900%2F20190910001877.jpg&imgrefurl=https%3A%2F%2Fwww.chinatimes.com%2Frealtimenews%2F20190910001856-260404&docid=Q4PlqTBNL8m4rM&tbnid=Xjrvy04jJoPYUM%3A&vet=10ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgsKAMwAw..i&w=900&h=589&bih=789&biw=1920&q=%E7%BE%8E%E5%A5%B3&ved=0ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgsKAMwAw&iact=mrc&uact=8",
//            "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.chinatimes.com%2Fnewsphoto%2F2019-09-10%2F900%2F20190910001877.jpg&imgrefurl=https%3A%2F%2Fwww.chinatimes.com%2Frealtimenews%2F20190910001856-260404&docid=Q4PlqTBNL8m4rM&tbnid=Xjrvy04jJoPYUM%3A&vet=10ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgsKAMwAw..i&w=900&h=589&bih=789&biw=1920&q=%E7%BE%8E%E5%A5%B3&ved=0ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgsKAMwAw&iact=mrc&uact=8",
//            "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimg.gq.com.tw%2F_rs%2F645%2Fuserfiles%2Fsm%2Fsm1024_images_A1%2F38274%2F2018122756058309.jpg&imgrefurl=https%3A%2F%2Fwww.gq.com.tw%2Fwomen%2Fgirl%2Fcontent-38274.html&docid=CfVcnjUPqPTJkM&tbnid=xq-NLUXP7-bgqM%3A&vet=10ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgvKAUwBQ..i&w=645&h=645&bih=789&biw=1920&q=%E7%BE%8E%E5%A5%B3&ved=0ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwgvKAUwBQ&iact=mrc&uact=8",
//            "https://www.google.com/imgres?imgurl=http%3A%2F%2Fwww.instyle.tw%2Fuploads%2Farticle%2F934%2F4.JPG&imgrefurl=http%3A%2F%2Fwww.instyle.tw%2Fcelebrity%2Farticle.php%3Fi%3D934&docid=2vg2TFSU8zFKEM&tbnid=FzPGF3K3Xg_8nM%3A&vet=10ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwg0KAowCg..i&w=477&h=594&bih=789&biw=1920&q=%E7%BE%8E%E5%A5%B3&ved=0ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwg0KAowCg&iact=mrc&uact=8",
//            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVxlW7Qt2UZienca-85h1zO98pRW2EfJXKUCcJi37drgWQ-S5XSA",
//            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiccxUVcS_n8Nf0OLTZh3QHl6GTywayl1iPjF7HGHgkSU2PwHD",
                "https://www.google.com/imgres?imgurl=http%3A%2F%2Fimg.qiniutu.com%2F%25E7%25BE%258E%25E5%25A5%25B3%25E7%25B4%25A0%25E6%259D%2590201712%2520(9).jpg&imgrefurl=http%3A%2F%2Fwww.mys360.com%2Fsucai%2F109575.html&docid=hpQNtyR9tDgaZM&tbnid=ueYaDzHgrt091M%3A&vet=10ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwg4KA4wDg..i&w=600&h=800&bih=789&biw=1920&q=%E7%BE%8E%E5%A5%B3&ved=0ahUKEwil2J-R78rkAhUCPnAKHfALDnQQMwg4KA4wDg&iact=mrc&uact=8"
        )

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = PicassoAdapter(imageUrls)
        }
    }

}