package com.example.dagger1.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetModule::class, SubComponentModule::class])
interface ApplicationComponent {

//    fun inject(activity: MainActivity)

    fun retrofit(): Retrofit

    fun factory(): PeopleComponent.Factory

}