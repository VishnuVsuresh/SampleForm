package form.com.sampleform.app;

import android.app.Application;
import android.content.Context;

import form.com.sampleform.BuildConfig;
import form.com.sampleform.di.component.AppComponent;
import form.com.sampleform.di.component.DaggerAppComponent;
import form.com.sampleform.di.module.AppModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by Visitor on 1/11/2018.
 */

public class FormApp extends Application{


    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
        
        initRealm();
    }

    public static FormApp getAppInstance(Context context) {
        return (FormApp) context.getApplicationContext();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder()
                        .name(BuildConfig.DATA_BASE_NAME)
                        .schemaVersion(BuildConfig.DATA_BASE_VESRION)
                        .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
