package com.xsl.riders.pe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xsl.riders.R;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/22,Time:11:49
 * Description:
 */

public class PeCommentAdapter extends RecyclerView.Adapter<PeCommentAdapter.CommentViewHolder> {
    private Context mContext;

    public PeCommentAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.comment_item, parent, false);
        CommentViewHolder commentViewHolder = new CommentViewHolder(view);
        return commentViewHolder;
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        public CommentViewHolder(View itemView) {
            super(itemView);
        }
    }
}
