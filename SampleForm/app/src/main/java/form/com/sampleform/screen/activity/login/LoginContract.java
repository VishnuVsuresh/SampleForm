package form.com.sampleform.screen.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;


import java.util.List;

import form.com.sampleform.screen.base.BaseView;

/**
 * Created by Vishnu on 11/16/2017.
 */

public class LoginContract {
    public interface View extends BaseView {

    }


    interface Presenter {
        void doSignIn(String userNmae,String password ,int apiType);


    }
}
