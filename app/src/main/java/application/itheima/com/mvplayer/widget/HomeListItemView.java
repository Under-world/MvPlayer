package application.itheima.com.mvplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import application.itheima.com.mvplayer.R;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class HomeListItemView extends RelativeLayout {
    public HomeListItemView(Context context) {
        this(context,null);
    }
//xml里面解析view时会找带两个参数构造方法创建view创建view后才能通过findViewByid找到
    public HomeListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //初始化布局
        LayoutInflater.from(getContext()).inflate(R.layout.view_home_list_item,this);
    }
}
