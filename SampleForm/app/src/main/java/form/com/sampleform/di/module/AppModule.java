package form.com.sampleform.di.module;


import android.content.Context;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import javax.inject.Singleton;


import dagger.Module;
import dagger.Provides;
import form.com.sampleform.app.FormApp;
import form.com.sampleform.db.RealmManager;


/**
 * Created by Vishnu on 7/28/2017.
 *
 * class for getting formfilling.com.sampleformfilling.app class objects
 */
@Module
public class AppModule {


    private FormApp mApp;

    public AppModule(FormApp app) {
        mApp = app;
    }



    @Provides
    @Singleton
    RealmManager provideRealManager() {
        return new RealmManager();
    }


    @Provides
    @Singleton
    Context provideContext() {
        return mApp;
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        Gson gson = new GsonBuilder().create();
        return gson;
    }

    @Provides
    @Singleton
    public Glide provideGlide() {

        return Glide.get(mApp.getApplicationContext());
    }
    @Provides
    @Singleton
    public ImageLoader provideImageLoader() {
        return new ImageLoader(mApp);
    }


}
