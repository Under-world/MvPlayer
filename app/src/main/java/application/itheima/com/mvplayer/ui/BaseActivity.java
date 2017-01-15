package application.itheima.com.mvplayer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/15 0015.
 * 封装ACTIVITY的通用功能,相当于一个activity的小框架
 */

public abstract class BaseActivity extends AppCompatActivity {
    private int mLayoutResId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        init();
    }
//子类如果要做初始化,可以复写该方法
    protected void init(){

    }

    //子类必须去实现该方法,返回一个布局的资源
    public abstract int getLayoutResId();
}
