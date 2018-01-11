package form.com.sampleform.db.dao;

import android.support.annotation.NonNull;

import form.com.sampleform.db.entity.FormData;
import form.com.sampleform.db.entity.User;
import io.realm.Realm;

/**
 * Created by Visitor on 1/11/2018.
 */

public class FormDao {
    private final Realm mRealm;

    /**
     * Initialise realm instance
     */
    public FormDao(@NonNull Realm realm) {
        mRealm = realm;
    }

    /**
     * Persist the user object in realm database
     */
    public void save(final FormData data) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(data);
            }
        });
    }

    /**
     * Returns user object for the specified id
     */
    @NonNull
    public FormData loadBy(long id) {
        return mRealm.where(FormData.class).findFirst();
    }
}
