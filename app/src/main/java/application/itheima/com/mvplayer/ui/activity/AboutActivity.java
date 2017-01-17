package application.itheima.com.mvplayer.ui.activity;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import application.itheima.com.mvplayer.R;

/**
 * Created by Administrator on 2017/1/17 0017.
 */
public class AboutActivity extends BaseActivity{
    @Override
    public int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    protected void init() {
        super.init();
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(R.string.about);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
