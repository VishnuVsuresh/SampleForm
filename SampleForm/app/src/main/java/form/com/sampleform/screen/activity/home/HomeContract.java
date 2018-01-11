package form.com.sampleform.screen.activity.home;

import form.com.sampleform.screen.base.BaseView;

/**
 * Created by Visitor on 1/11/2018.
 */

public class HomeContract {
    public interface View extends BaseView {

    }


    interface Presenter {
        void saveImage(String data,int apiType);


    }
}
