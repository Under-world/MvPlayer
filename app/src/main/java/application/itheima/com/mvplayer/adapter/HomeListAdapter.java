package application.itheima.com.mvplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import application.itheima.com.mvplayer.widget.HomeListItemView;

/**
 * Created by Administrator on 2017/1/17 0017.
 */

public class HomeListAdapter extends RecyclerView.Adapter {
    private Context mContext;
    public HomeListAdapter(Context context){
        mContext = context;
    }
    //创建viewHolder, return返回RecyclerView定义的viewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeListItemViewHolder(new HomeListItemView(mContext));
    }

    @Override//绑定viewholder,拿到position对应位置的数据来刷新holder
    //position  item的位置
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override//返回item个数,通ListView getCount
    public int getItemCount() {
        return 30;
    }
    public class HomeListItemViewHolder extends  RecyclerView.ViewHolder{

        public HomeListItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
