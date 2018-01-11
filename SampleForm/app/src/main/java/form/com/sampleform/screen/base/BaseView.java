package form.com.sampleform.screen.base;

/**
 * Created by Vishnu on 04-07-2017.
 */

public interface BaseView {

    void onSessionOut();

    void onSuccess(Object response, int apiCode);

    void onError(String message, int apiCode);

    void showLoading();

    void hideLoading();

    void hideKeyBoard();
}
