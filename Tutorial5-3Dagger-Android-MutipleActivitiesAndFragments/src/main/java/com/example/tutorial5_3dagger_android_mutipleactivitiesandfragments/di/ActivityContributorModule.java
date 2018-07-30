package com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.di;


import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.MainActivity;
import com.example.tutorial5_3dagger_android_mutipleactivitiesandfragments.second.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityContributorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentContributorModule.class})
    abstract MainActivity contributeMainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {SecondActivityModule.class})
    abstract SecondActivity contributeSecondActivity();


}
