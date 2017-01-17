package application.itheima.com.mvplayer.ui;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import application.itheima.com.mvplayer.R;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override//创建菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        //解析菜单布局,添加到menu当中
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override//处理菜单按钮的点击事件
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
