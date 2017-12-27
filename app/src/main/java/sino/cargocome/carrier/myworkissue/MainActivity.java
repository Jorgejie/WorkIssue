package sino.cargocome.carrier.myworkissue;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (ImageView) findViewById(R.id.iv_pic1);

        Glide.with(this)
                .load("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2625155098,2810056817&fm=27&gp=0.jpg")
                .fitCenter()
                .into(mView);
    }

    public void gotoPicActivity(View view) {
        Intent intent = new Intent(MainActivity.this, PicActivity.class);
        ViewCompat.setTransitionName(mView, "shareImageView");
        Pair pair = Pair.create(mView, "shareImageView");
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair).toBundle();
        ActivityCompat.startActivity(MainActivity.this, intent, bundle);
    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }
}
