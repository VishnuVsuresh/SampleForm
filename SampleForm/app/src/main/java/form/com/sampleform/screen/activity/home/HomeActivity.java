package form.com.sampleform.screen.activity.home;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import javax.inject.Inject;

import form.com.sampleform.R;
import form.com.sampleform.app.FormApp;
import form.com.sampleform.screen.base.BaseActivity;

/**
 * Created by Visitor on 1/11/2018.
 */

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @Inject
    HomePresenter mHomePresenter;
    private static int RESULT_LOAD_IMG = 1;
    @Inject
    Glide glide;

    private ImageView image;
    private String picturePath;

    @Override
    public void onSuccess(Object response, int apiCode) {

    }

    @Override
    public void onError(String message, int apiCode) {

    }

    @Override
    protected void initializeDagger() {
        FormApp app = FormApp.getAppInstance(this);
        app.getAppComponent().inject(this);
    }

    @Override
    protected void initializePresenter() {
        mPresenter = mHomePresenter;
        mHomePresenter.setView(HomeActivity.this);
    }

    @Override
    protected void initComponent() {
        image = findViewById(R.id.image);
        findViewById(R.id.pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMG);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMG) {
            Uri selectedImage = data.getData();
            Glide.with(this)
                    .load(new File(selectedImage.getPath())) // Uri of the picture
                    .into(image);
        }
    }
}
