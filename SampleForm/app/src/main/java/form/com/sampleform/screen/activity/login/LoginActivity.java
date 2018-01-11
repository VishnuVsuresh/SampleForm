package form.com.sampleform.screen.activity.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatImageView;
import android.text.Html;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;



import javax.inject.Inject;

import form.com.sampleform.R;
import form.com.sampleform.app.FormApp;
import form.com.sampleform.screen.activity.home.HomeActivity;
import form.com.sampleform.screen.base.BaseActivity;

/**
 * Created by Vishnu on 11/15/2017.
 * <p>
 * Code back Login screen
 */

public class LoginActivity extends BaseActivity implements LoginContract.View, View.OnClickListener {

    @Inject
    LoginPresenter loginPresenter;


    private TextInputEditText passwordTxt, emailTxt;
    private TextInputLayout passwordTL, emailTL;


    @Override
    protected void initializeDagger() {
        FormApp app = FormApp.getAppInstance(this);
        app.getAppComponent().inject(this);
    }

    @Override
    protected void initializePresenter() {
        mPresenter = loginPresenter;
        loginPresenter.setView(LoginActivity.this);
    }

    @Override
    protected void initComponent() {
        emailTxt = findViewById(R.id.etUserName);
        emailTL = findViewById(R.id.tilUserName);
        passwordTL = findViewById(R.id.tilPassword);
        passwordTxt = findViewById(R.id.etPassword);
        passwordTxt.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordTxt.setTypeface(emailTxt.getTypeface());

        findViewById(R.id.login).setOnClickListener(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void onSuccess(Object response, int apiCode) {

startActivity(HomeActivity.class,null,true);
    }

    @Override
    public void onError(String message, int apiCode) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                if (validateFiled()) {
                    loginPresenter.doSignIn(getMail(),getPassword(), LoginPresenter.LOGIN);
                }
                break;


        }
    }

    private boolean validateFiled() {
        boolean status = true;
        if (!isValidEmail(getMail())) {
            emailTL.setError(getString(R.string.error_enter_email));
            status = false;
        } else if (TextUtils.isEmpty(getPassword())) {
            passwordTxt.setSelected(true);
            passwordTL.setError(getString(R.string.error_enter_pswd));
            status = false;
        }
        return status;
    }

    @NonNull
    private String getPassword() {
        return passwordTxt.getText().toString();
    }

    @NonNull
    private String getMail() {
        return emailTxt.getText().toString();
    }

    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
