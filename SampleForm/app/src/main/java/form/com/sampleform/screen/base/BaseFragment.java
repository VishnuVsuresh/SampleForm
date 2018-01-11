package form.com.sampleform.screen.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;



/**
 * Created by Vishnu on 7/3/2017.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    protected FragmentManager fragmentManager;
    protected Presenter presenter;
    private View view;


    protected abstract void initializeDagger();

    protected abstract void initializePresenter();

    protected abstract void initializeView(View view);

    public abstract int getLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getActivity().getSupportFragmentManager();
        initializeDagger();
        initializePresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        initializeView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.finalizeView();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }




    public void hideKeyBoard() {

        try {
            View view = getActivity().getCurrentFocus();
            if (view != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
