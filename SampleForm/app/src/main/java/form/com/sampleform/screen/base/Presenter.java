package form.com.sampleform.screen.base;


import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Vishnu on 5/12/2016
 */


public abstract class Presenter<T extends BaseView> {

    protected AtomicBoolean isViewAlive = new AtomicBoolean();
    private WeakReference<T> view;

    public T getView() {
        return view.get();
    }

    public void setView(T view) {
        this.view = new WeakReference<>(view);
    }

//    public void initialize(Bundle extras) {
//    }

    public void start() {
        isViewAlive.set(true);
    }

    public void finalizeView() {
        isViewAlive.set(false);
    }

}
