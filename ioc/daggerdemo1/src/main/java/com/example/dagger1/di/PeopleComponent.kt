package com.example.dagger1.di

import com.example.dagger1.SecondActivity
import dagger.Subcomponent

@Subcomponent(modules = [PeopleModule::class])
interface PeopleComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PeopleComponent
    }

    fun inject(secondActivity: SecondActivity)

}