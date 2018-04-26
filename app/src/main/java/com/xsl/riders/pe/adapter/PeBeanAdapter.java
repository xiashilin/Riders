package com.xsl.riders.pe.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.xsl.riders.R;
import com.xsl.riders.common.PeBean;
import com.xsl.riders.pe.PeDetailActivity;
import com.xsl.riders.utils.PicassoImageLoader;
import com.xsl.riders.widget.CircleImageView;

import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/21,Time:18:18
 * Description:
 */

public class PeBeanAdapter extends RecyclerView.Adapter<PeBeanAdapter.PeViewHolder> {
    private Context mContext;
    List<PeBean.DataBean.ItemListBean> mItemList;
    private String mTitle;

    public PeBeanAdapter(Context context, List<PeBean.DataBean.ItemListBean> itemList, String title) {
        this.mContext = context;
        this.mItemList = itemList;
        this.mTitle = title;
    }

    public void setList(List<PeBean.DataBean.ItemListBean> itemList) {
        this.mItemList = itemList;
    }

    @Override
    public PeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pe_item, parent, false);
        PeViewHolder peViewHolder = new PeViewHolder(view);
        return peViewHolder;
    }

    @Override
    public void onBindViewHolder(PeViewHolder holder, final int position) {
        final PeBean.DataBean.ItemListBean peBean = mItemList.get(position);
        if (!TextUtils.isEmpty(peBean.getAvatar())) {
            new PicassoImageLoader().displayImage(mContext, peBean.getAvatar(), holder.icon);
        }

        if (mTitle.equals("私教团队详情")) {
            holder.peName.setText(peBean.getName() + "团队");
            holder.pePrice.setText("￥" + peBean.getPrice());
        } else {
            holder.peName.setText(peBean.getName());
            holder.pePrice.setText(peBean.getPeilianInfo().getPeilianPrice() + "元/小时");
        }
        holder.peSeniority.setText(peBean.getAge() + "年教龄");
        holder.pe_School.setText(peBean.getJiaxiaoName());
        holder.pe_score.setText(peBean.getScore() + "分");
//        holder.pe_distance.setText(peBean.getName());
        holder.ratingBar.setRating(Float.parseFloat(peBean.getScore() + ""));
        holder.peRating.setText(peBean.getDesc());

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PeDetailActivity.class);
                intent.putExtra("icon", peBean.getAvatar());
                intent.putExtra("name", peBean.getName());
                intent.putExtra("title", mTitle);
                intent.putExtra("price", peBean.getPeilianInfo().getPeilianPrice() + "");
                intent.putExtra("student", peBean.getStudentCount());
                intent.putExtra("school", peBean.getJiaxiaoName());
                intent.putExtra("address", peBean.getCityName() + peBean.getAddress());
                intent.putExtra("zh_rating", Float.parseFloat(peBean.getScoreDetail().getScore1() + ""));
                intent.putExtra("jx_rating", Float.parseFloat(peBean.getScoreDetail().getScore2() + ""));
                intent.putExtra("fw_rating", Float.parseFloat(peBean.getScoreDetail().getScore3() + ""));
                intent.putExtra("desc", peBean.getIntroduction());
                intent.putExtra("phone",peBean.getPhone());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class PeViewHolder extends RecyclerView.ViewHolder {
        View rootView;
        CircleImageView icon;
        TextView peName;
        TextView peSeniority;
        TextView pe_School;
        TextView pe_score;
        TextView pe_distance;
        TextView peRating;
        TextView pePrice;
        RatingBar ratingBar;


        public PeViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            icon = itemView.findViewById(R.id.icon);
            peName = itemView.findViewById(R.id.peName);
            peSeniority = itemView.findViewById(R.id.peSeniority);
            pe_School = itemView.findViewById(R.id.pe_School);
            pe_score = itemView.findViewById(R.id.pe_score);
            ratingBar = itemView.findViewById(R.id.peStar);
            pe_distance = itemView.findViewById(R.id.pe_distance);
            peRating = itemView.findViewById(R.id.peRating);
            pePrice = itemView.findViewById(R.id.pePrice);
        }
    }

}