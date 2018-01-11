package form.com.sampleform.di.module;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * Created by Ribin on 11/24/2017.
 * class used for image loading
 */


public class ImageLoader {


    private Context mContext;


    public ImageLoader(Context context) {
        this.mContext = context;
    }


//    public void loadImageRoundedCorner(ImageView view, String url) {
//        RequestOptions options = getRequestOptions();
//        Glide.with(mContext).load(url).apply(options).into(view);
//    }

    public void loadImage(ImageView view, String url) {
        Glide.with(mContext).load(url).into(view);
    }


//    private RequestOptions getRequestOptions() {
//        return new RequestOptions()
//                .centerCrop()
//                .transform(new RoundedCorners((int) mContext.getResources().getDimension(R.dimen.)));
//    }


}
