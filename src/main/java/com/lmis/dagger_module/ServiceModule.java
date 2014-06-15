package com.lmis.dagger_module;

import android.content.Context;

import com.fizzbuzz.android.dagger.InjectingService;
import com.fizzbuzz.android.dagger.Injector;
import com.lmis.services.OrgSyncService;
import com.lmis.services.SyncAdapterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chengdh on 14-6-15.
 */
@Module(complete = false,
        library = true,
        injects = {OrgSyncService.class})

public class ServiceModule {

    android.app.Service mService;
    Injector mInjector;

    public ServiceModule(android.app.Service service, Injector injector) {
        mService = service;
        mInjector = injector;

    }

    @Provides
    @Singleton
    @InjectingService.InjectingServiceModule.Service
    public Context provideServiceContext() {
        return (Context) mService;
    }

    @Provides
    @Singleton
    @InjectingService.InjectingServiceModule.Service
    public SyncAdapterImpl provideSyncAdapterImpl(@InjectingService.InjectingServiceModule.Service Context context) {
        return new SyncAdapterImpl(context);
    }
}