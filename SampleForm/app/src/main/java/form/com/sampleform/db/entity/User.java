package form.com.sampleform.db.entity;

import io.realm.RealmObject;

/**
 * Created by Visitor on 1/11/2018.
 */

public class User extends RealmObject {

    public User() {
    }

    private String uName;
    private String uPassword;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
}
