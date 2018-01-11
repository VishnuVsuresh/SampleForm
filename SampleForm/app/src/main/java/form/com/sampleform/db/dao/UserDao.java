package form.com.sampleform.db.dao;

import android.support.annotation.NonNull;

import form.com.sampleform.db.entity.User;
import io.realm.Realm;


/**
 * Created by Visitor on 1/11/2018.
 */

public class UserDao {

    private final Realm mRealm;

    /**
     * Initialise realm instance
     */
    public UserDao(@NonNull Realm realm) {
        mRealm = realm;
    }

    /**
     * Persist the user object in realm database
     */
    public void save(final User user) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(User.class);
                realm.copyToRealmOrUpdate(user);
            }
        });
    }

    /**
     * Returns user object for the specified id
     */
    @NonNull
    public User loadBy(long id) {
        return mRealm.where(User.class).findFirst();
    }
}
