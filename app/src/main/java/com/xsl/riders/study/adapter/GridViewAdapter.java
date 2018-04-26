package com.xsl.riders.study.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xsl.riders.R;
import com.xsl.riders.study.ItemData;

import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/12/22,Time:17:00
 * Description:
 */

public class GridViewAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {

    private List<ItemData> itemDatas;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener = null;

    public GridViewAdapter(List<ItemData> datas, Context context) {
        this.itemDatas = datas;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.one_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
        holder.name.setText(itemDatas.get(position).getName());
        Picasso.with(mContext).load(itemDatas.get(position).getImgId()).into(holder.mImgId);
    }

    @Override
    public int getItemCount() {
        return itemDatas.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }


    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}

class ViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public ImageView mImgId;

    public ViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.item_name);
        mImgId = itemView.findViewById(R.id.item_img);
    }
}