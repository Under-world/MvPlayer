package application.itheima.com.mvplayer.ui.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import application.itheima.com.mvplayer.R;
import application.itheima.com.mvplayer.factory.FragmentFactory;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    private FragmentManager mFragmentManager;

    @Override
    public int getLayoutResId() {

        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        mFragmentManager = getSupportFragmentManager();
        //监听bottomBar切换事件
        mBottomBar.setOnTabSelectListener(mOnTabSelectListener);
    }
    private OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {
        @Override//bottomBar tab点击的回调
        public void onTabSelected(@IdRes int tabId) {
            //开启一个事务
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, FragmentFactory.getInstance().getFragment(tabId));
            fragmentTransaction.commit();
        }
    };

    @Override//创建菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        //解析菜单布局,添加到menu当中
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override//处理菜单按钮的点击事件
    public boolean onOptionsItemSelected(MenuItem item) {
        //通过id来区分不同菜单按钮的点击事件
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
