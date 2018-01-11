package form.com.sampleform.di.component;



import javax.inject.Singleton;


import dagger.Component;

import form.com.sampleform.app.FormApp;
import form.com.sampleform.db.RealmManager;
import form.com.sampleform.di.module.AppModule;
import form.com.sampleform.screen.activity.home.HomeActivity;
import form.com.sampleform.screen.activity.home.HomeContract;
import form.com.sampleform.screen.activity.login.LoginActivity;

/**
 * Created by Vishnu on 7/28/2017.
 * <p>
 * interface for injecting all views
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(FormApp app);
    void inject(HomeActivity app);
    void inject(LoginActivity app);



    RealmManager getRealmManager();
}
