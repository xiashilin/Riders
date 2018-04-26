package com.xsl.riders.pe.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.xsl.riders.R;
import com.xsl.riders.common.PeSchoolBean;
import com.xsl.riders.pe.PeSchoolDetailActivity;
import com.xsl.riders.utils.PicassoImageLoader;

import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/22,Time:13:16
 * Description:
 */

public class PeSchoolAdapter extends RecyclerView.Adapter<PeSchoolAdapter.PeSchoolHolder> {

    private List<PeSchoolBean.DataBean.ItemListBean> mItemList;
    private Context mContext;

    public PeSchoolAdapter(Context context, List<PeSchoolBean.DataBean.ItemListBean> itemList) {
        this.mContext = context;
        this.mItemList = itemList;
    }

    @Override
    public PeSchoolHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pe_school_item, parent, false);
        PeSchoolHolder peSchoolHolder = new PeSchoolHolder(view);
        return peSchoolHolder;
    }

    @Override
    public void onBindViewHolder(PeSchoolHolder holder, int position) {
        final PeSchoolBean.DataBean.ItemListBean peSchoolBean = mItemList.get(position);
        new PicassoImageLoader().displayImage(mContext, peSchoolBean.getLogo(), holder.schoolIcon);
        holder.schoolName.setText(peSchoolBean.getName());
        holder.schoolStar.setRating(Float.parseFloat(peSchoolBean.getScore() + ""));
        holder.schoolScore.setText(peSchoolBean.getScore() + "分");
        holder.schoolPrice.setText("￥" + peSchoolBean.getPrice() + " |  规模指数:" + peSchoolBean.getIndex().getCityIndex());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PeSchoolDetailActivity.class);
                intent.putExtra("logo", peSchoolBean.getLogo());
                intent.putExtra("name", peSchoolBean.getName());
                intent.putExtra("price", peSchoolBean.getPrice() + "");
                intent.putExtra("student", peSchoolBean.getStudentCount());
                intent.putExtra("school", peSchoolBean.getCountyName());
                intent.putExtra("address", peSchoolBean.getCityName() + peSchoolBean.getAddress());
                intent.putExtra("zh_rating", Float.parseFloat(peSchoolBean.getScoreDetail().getScore1() + ""));
                intent.putExtra("jx_rating", Float.parseFloat(peSchoolBean.getScoreDetail().getScore2() + ""));
                intent.putExtra("fw_rating", Float.parseFloat(peSchoolBean.getScoreDetail().getScore3() + ""));
                intent.putExtra("desc", peSchoolBean.getIntroduction());
                intent.putExtra("phone",peSchoolBean.getPhoneList().get(0));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public void setList(List<PeSchoolBean.DataBean.ItemListBean> itemList) {
        this.mItemList = itemList;
    }

    public class PeSchoolHolder extends RecyclerView.ViewHolder {
        View rootView;
        ImageView schoolIcon;
        TextView schoolName;
        RatingBar schoolStar;
        TextView schoolScore;
        TextView schoolPrice;

        public PeSchoolHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            schoolIcon = itemView.findViewById(R.id.school_icon);
            schoolName = itemView.findViewById(R.id.school_name);
            schoolStar = itemView.findViewById(R.id.school_star);
            schoolScore = itemView.findViewById(R.id.school_score);
            schoolPrice = itemView.findViewById(R.id.school_price);
        }
    }
}
