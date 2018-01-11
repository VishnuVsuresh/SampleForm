package form.com.sampleform.screen.activity.home;

import android.content.Context;

import javax.inject.Inject;

import form.com.sampleform.db.RealmManager;
import form.com.sampleform.screen.base.BaseView;
import form.com.sampleform.screen.base.Presenter;

/**
 * Created by Visitor on 1/11/2018.
 */

public class HomePresenter extends Presenter<HomeContract.View> implements HomeContract.Presenter{


    private final Context mContext;
    private final RealmManager mRealmManager;

    @Inject
    HomePresenter(Context mContext, RealmManager mRealmManager) {
        this.mContext = mContext;

        this.mRealmManager = mRealmManager;
    }
    @Override
    public void saveImage(String data, int apiType) {

    }
}
