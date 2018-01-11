package form.com.sampleform.db.entity;

import io.realm.RealmObject;

/**
 * Created by Visitor on 1/11/2018.
 */

public class FormData extends RealmObject{
    public FormData() {
    }

    private String imageUri;

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
