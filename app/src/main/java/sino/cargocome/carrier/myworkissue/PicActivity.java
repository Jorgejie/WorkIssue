package sino.cargocome.carrier.myworkissue;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class PicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
        supportPostponeEnterTransition();//网络图片加载的话需要加上,目的是等资源准备好之后再展示次大图片,让共享动画看起来更加流畅
        final ImageView mIvPic2 = (ImageView) findViewById(R.id.iv_pic2);
        ViewCompat.setTransitionName(mIvPic2, "shareImageView");
        Glide.with(this)
                .load("https://sinostoragedev.blob.core.chinacloudapi.cn/avatar-container/201712211017377762.png")
                .centerCrop()
                .listener(new RequestListener<String, GlideDrawable>() {

                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        mIvPic2.setImageDrawable(resource);
                        PicActivity.this.supportStartPostponedEnterTransition();
                        return false;
                    }
                })
                .into(mIvPic2);

    }

}
