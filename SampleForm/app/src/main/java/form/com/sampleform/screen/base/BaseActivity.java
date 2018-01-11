package form.com.sampleform.screen.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;



/**
 * Created by Vishnu on 7/3/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected Presenter mPresenter;

    protected abstract void initializeDagger();

    protected abstract void initializePresenter();

    protected abstract void initComponent();

    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        initializeDagger();
        initializePresenter();
        initComponent();
        // initToolBar(true);

    }


    protected void startActivity(Class<? extends Activity> activity, Bundle bundle, boolean isFinishParent) {

        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (isFinishParent) {
            supportFinishAfterTransition();
        }
    }

    protected void startActivityForResult(Class<? extends Activity> activity, Bundle bundle, int requestCode) {

        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void hideKeyBoard() {

        try {
            View view = getCurrentFocus();
            if (view != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        hideKeyBoard();
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.finalizeView();
        }
    }

    @Override
    public void onSessionOut() {

    }


    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }
}

