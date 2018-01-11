package form.com.sampleform.db;

import javax.inject.Singleton;


import form.com.sampleform.db.dao.FormDao;
import form.com.sampleform.db.dao.UserDao;
import form.com.sampleform.db.entity.User;
import io.realm.Realm;

/**
 * Created by Vishnu on 11/15/2017.
 * <p>
 * class for data base configuration
 */

@Singleton
public class RealmManager {
    private Realm mRealm;

    /**
     * Open Realm instance
     *
     * @return Realm default instance
     */
    public Realm open() {
        mRealm = Realm.getDefaultInstance();
        return mRealm;
    }

    /**
     * Init user dao to manage user entity
     *
     * @return user dao
     */
    public UserDao createUserDao() {
        checkForOpenRealm();
        return new UserDao(mRealm);
    }

    public FormDao createFormDao() {
        checkForOpenRealm();
        return new FormDao(mRealm);
    }

    /**
     * Close realm instance
     */
    public void close() {
        if (mRealm != null) {
            mRealm.close();
        }
    }


    /**
     * Wipe out tables
     */
    public void clear() {
        checkForOpenRealm();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //TODO Clear rest of your dao classes
                realm.delete(User.class);


            }
        });
    }

    private void checkForOpenRealm() {
        if (mRealm == null || mRealm.isClosed()) {
            throw new IllegalStateException("RealmManager: Realm is closed, call open() method first");
        }
    }
}
