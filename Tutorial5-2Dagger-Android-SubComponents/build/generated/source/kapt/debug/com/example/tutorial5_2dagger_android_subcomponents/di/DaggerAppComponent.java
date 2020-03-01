// Generated by Dagger (https://dagger.dev).
package com.example.tutorial5_2dagger_android_subcomponents.di;

import android.app.Application;
import android.content.SharedPreferences;
import com.example.tutorial5_2dagger_android_subcomponents.MainActivity;
import com.example.tutorial5_2dagger_android_subcomponents.MainActivity_MembersInjector;
import com.example.tutorial5_2dagger_android_subcomponents.MyApplication;
import com.example.tutorial5_2dagger_android_subcomponents.ToastMaker;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private Provider<ToastMakerSubComponent.Builder> toastMakerSubComponentBuilderProvider;

  private Provider<Application> applicationProvider;

  private Provider<SharedPreferences> provideSharedPreferencesProvider;

  private DaggerAppComponent(Application applicationParam) {

    initialize(applicationParam);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(
      ) {
    return Collections.<Class<?>, Provider<AndroidInjector.Factory<?>>>singletonMap(MainActivity.class, (Provider) toastMakerSubComponentBuilderProvider);}

  private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
    return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());}

  @SuppressWarnings("unchecked")
  private void initialize(final Application applicationParam) {
    this.toastMakerSubComponentBuilderProvider = new Provider<ToastMakerSubComponent.Builder>() {
      @Override
      public ToastMakerSubComponent.Builder get() {
        return new ToastMakerSubComponentBuilder();}
    };
    this.applicationProvider = InstanceFactory.create(applicationParam);
    this.provideSharedPreferencesProvider = DoubleCheck.provider(AppModule_ProvideSharedPreferencesFactory.create(applicationProvider));
  }

  @Override
  public void inject(MyApplication arg0) {
    injectMyApplication(arg0);}

  private MyApplication injectMyApplication(MyApplication instance) {
    DaggerApplication_MembersInjector.injectAndroidInjector(instance, getDispatchingAndroidInjectorOfObject());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public AppComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new DaggerAppComponent(application);
    }
  }

  private final class ToastMakerSubComponentBuilder extends ToastMakerSubComponent.Builder {
    private MainActivity seedInstance;

    @Override
    public void seedInstance(MainActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }

    @Override
    public ToastMakerSubComponent build() {
      Preconditions.checkBuilderRequirement(seedInstance, MainActivity.class);
      return new ToastMakerSubComponentImpl(seedInstance);
    }
  }

  private final class ToastMakerSubComponentImpl implements ToastMakerSubComponent {
    private Provider<MainActivity> seedInstanceProvider;

    private Provider<ToastMaker> provideToastMakerProvider;

    private ToastMakerSubComponentImpl(MainActivity seedInstanceParam) {

      initialize(seedInstanceParam);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final MainActivity seedInstanceParam) {
      this.seedInstanceProvider = InstanceFactory.create(seedInstanceParam);
      this.provideToastMakerProvider = DoubleCheck.provider(ToastMakerModule_ProvideToastMakerFactory.create((Provider) seedInstanceProvider));
    }

    @Override
    public void inject(MainActivity arg0) {
      injectMainActivity(arg0);}

    private MainActivity injectMainActivity(MainActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(instance, DaggerAppComponent.this.getDispatchingAndroidInjectorOfObject());
      MainActivity_MembersInjector.injectSharedPreferences(instance, DaggerAppComponent.this.provideSharedPreferencesProvider.get());
      MainActivity_MembersInjector.injectToastMaker(instance, provideToastMakerProvider.get());
      return instance;
    }
  }
}