package com.example.dagger1.di

import com.example.dagger1.bean.People
import dagger.Module
import dagger.Provides

@Module
class PeopleModule {


    @Provides
    fun providePeople(): People {
        return People()
    }
}