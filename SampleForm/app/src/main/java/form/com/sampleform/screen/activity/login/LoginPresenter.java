package form.com.sampleform.screen.activity.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;



import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import form.com.sampleform.db.RealmManager;
import form.com.sampleform.screen.base.Presenter;


/**
 * Created by Vishnu on 11/16/2017.
 */

public class LoginPresenter extends Presenter<LoginContract.View> implements LoginContract.Presenter {

    public static final int LOGIN = 11;
    private final Context mContext;
    private final RealmManager mRealmManager;

    @Inject
    LoginPresenter(Context mContext, RealmManager mRealmManager) {
        this.mContext = mContext;
        this.mRealmManager = mRealmManager;
    }


    @Override
    public void doSignIn(String userNmae, String password, int apiType) {
getView().onSuccess(null,0);
    }
}