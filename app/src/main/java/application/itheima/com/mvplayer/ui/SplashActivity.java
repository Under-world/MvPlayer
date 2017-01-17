package application.itheima.com.mvplayer.ui;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import application.itheima.com.mvplayer.R;
import butterknife.BindView;

/**
 * Created by Administrator on 2017/1/15 0015.
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.splash_image)
    ImageView mSplashImage;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        super.init();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        animation.setAnimationListener(mAnimationListener);
        mSplashImage.startAnimation(animation);
    }
    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }
        //动画结束跳转到主界面
        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            //动画带有淡入淡出的效果
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

}
