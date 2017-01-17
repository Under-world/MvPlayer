package application.itheima.com.mvplayer.factory;

import android.support.v4.app.Fragment;

import application.itheima.com.mvplayer.R;
import application.itheima.com.mvplayer.ui.fragment.HomeFragment;
import application.itheima.com.mvplayer.ui.fragment.MVFragment;
import application.itheima.com.mvplayer.ui.fragment.VbangFragment;
import application.itheima.com.mvplayer.ui.fragment.YuDanFragment;

/**
 * Created by Administrator on 2017/1/17 0017.
 * 工厂模式,添加不同条件,不同的输入,生产出不同的对象
 */

public class FragmentFactory {
    //单例模式, 一个app中只维护一个实例(对象)
    private static FragmentFactory sFragmentFactory;
    //内存缓存 类的成员变量,存在内存当中
    private HomeFragment mHomeFragment;
    private        MVFragment      mMVFragment;
    private VbangFragment mVbangFragment;
    private YuDanFragment mYuDanFragment;
    public static FragmentFactory getInstance(){
        if (sFragmentFactory==null){
            synchronized (FragmentFactory.class){
                if (sFragmentFactory==null){
                    sFragmentFactory = new FragmentFactory();
                }
            }
        }
        return sFragmentFactory;
    }
    public Fragment getFragment(int tabId){
        switch (tabId){
            case R.id.tab_home:
                return getHomeFragment();
            case R.id.tab_mv:
                return getMVFragment();
            case R.id.tab_vbang:
                return getVbangFragment();
            case R.id.tab_yudan:
                return getYuDanFragment();
        }
        return null;
    }

    private Fragment getHomeFragment() {
        if (mHomeFragment==null){
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }

    private Fragment getMVFragment() {
        if (mMVFragment ==null){
            mMVFragment = new MVFragment();
        }
        return mMVFragment;
    }

    private Fragment getVbangFragment() {
        if (mVbangFragment == null){
            mVbangFragment = new VbangFragment();
        }
        return mVbangFragment;
    }
    private Fragment getYuDanFragment() {
        if (mYuDanFragment == null){
            mYuDanFragment = new YuDanFragment();
        }
        return mYuDanFragment;
    }
}
