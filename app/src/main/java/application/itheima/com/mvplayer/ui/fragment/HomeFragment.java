package application.itheima.com.mvplayer.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;

import application.itheima.com.mvplayer.R;
import application.itheima.com.mvplayer.adapter.HomeListAdapter;
import application.itheima.com.mvplayer.utils.URLProviderUtils;
import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class HomeFragment extends BaseFragment {
    private static final String TAG = "HomeFragment";
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    //RecyclerView类似ListView,更加强大,瀑布流
    //list LinerLayoutManager 线性布局管理器
    //grid GridLayoutManager 网格布局管理器
    //StaggeredGridLayoutManager瀑布流式布局管理器
    private HomeListAdapter mHomeListAdapter;
    @Override
    public int getLayoutResId() {

        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        super.init();
        initRecyclerView();
        loadDataList();
    }

    private void loadDataList() {
        String url = URLProviderUtils.getHomeUrl(0,10);
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().get().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    String result = response.body().string();
                Log.d(TAG,"onResponse: " + result);
            }
        });
    }

    //初始化RecyclerView
    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);//RecyclerView的大小,如果是固定的,需要设置,内部会做相应的优化
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));//设置布局管理器
        mHomeListAdapter = new HomeListAdapter(getContext());
        mRecyclerView.setAdapter(mHomeListAdapter);
    }
}
