// Generated by Dagger (https://dagger.dev).
package com.example.tutorial5_1dagger_android;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

  private final Provider<DummyDependency> dummyDependencyProvider;

  public MainActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<DummyDependency> dummyDependencyProvider) {
    this.androidInjectorProvider = androidInjectorProvider;
    this.dummyDependencyProvider = dummyDependencyProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<DummyDependency> dummyDependencyProvider) {
    return new MainActivity_MembersInjector(androidInjectorProvider, dummyDependencyProvider);}

  @Override
  public void injectMembers(MainActivity instance) {
    DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(instance, androidInjectorProvider.get());
    injectDummyDependency(instance, dummyDependencyProvider.get());
  }

  public static void injectDummyDependency(MainActivity instance, DummyDependency dummyDependency) {
    instance.dummyDependency = dummyDependency;
  }
}