package com.xingyun.frame.hilt

import android.os.Bundle
import javax.inject.Inject

class HiltUnSupportActivity : BaseHiltActivity() {
    @Inject
    lateinit var user: User

    @Inject
    lateinit var userProfile: UserProfile


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user
        userProfile
    }




}