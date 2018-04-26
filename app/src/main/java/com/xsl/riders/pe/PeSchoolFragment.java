package com.xsl.riders.pe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.wang.avi.AVLoadingIndicatorView;
import com.xsl.riders.R;
import com.xsl.riders.common.Constant;
import com.xsl.riders.common.PeSchoolBean;
import com.xsl.riders.net.Api;
import com.xsl.riders.net.HttpManager;
import com.xsl.riders.pe.adapter.PeSchoolAdapter;
import com.xsl.riders.study.LazyFragment;
import com.xsl.riders.utils.SnackBarUtils;
import com.xsl.riders.utils.ioc.CheckNet;
import com.xsl.riders.widget.EmptyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/12/30,Time:16:02
 * Description:
 */

public class PeSchoolFragment extends LazyFragment {
    private static PeSchoolFragment mInstance;
    private Context mContext;
    private EmptyRecyclerView mRecyclerView;
    private PeSchoolAdapter mPeSchoolAdapter;
    private List<PeSchoolBean.DataBean.ItemListBean> mItemList;
    private Disposable mDisposable;
    private View mEmptyView;
    private SwipeRefreshLayout mRefreshLayout;
    private AVLoadingIndicatorView mAvi;
    private AVLoadingIndicatorView mAviLoadMore;
    private int mPage = 1;
    private LinearLayout mLayoutLoadMore;
    private boolean mIsLoadMore = true;//是否可以加载更多

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public static PeSchoolFragment newInstance() {
        synchronized (PeSchoolFragment.class) {
            if (mInstance == null) {
                mInstance = new PeSchoolFragment();
            }
            return mInstance;
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fg_pes;
    }

    @Override
    protected void initView(View view) {
        init(view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mItemList = new ArrayList<>();
        mPeSchoolAdapter = new PeSchoolAdapter(mContext, mItemList);
        mRecyclerView.setAdapter(mPeSchoolAdapter);
        mRecyclerView.setmEmptyView(mEmptyView);
        mRecyclerView.hideEmptyView();
        showLoading();
        getDataFromServer(Constant.GET_DATA_TYPE_NOMAL);
    }

    @Override
    public void initData() {
    }

    private void init(View view) {
        mRecyclerView = (EmptyRecyclerView) view.findViewById(R.id.pe_fragment_recyclerview);
        mEmptyView = view.findViewById(R.id.empty_view);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshlayout);
        mAvi = (AVLoadingIndicatorView) view.findViewById(R.id.avi);
        mAviLoadMore = (AVLoadingIndicatorView) view.findViewById(R.id.avi_loadmore);
        mLayoutLoadMore = (LinearLayout) view.findViewById(R.id.layout_loadmore);
        //设置下拉刷新样式
        mRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新事件
                mPage = 1;
                mIsLoadMore = true;
                getDataFromServer(Constant.GET_DATA_TYPE_NOMAL);
            }
        });
        //监听上拉加载更多
        mRecyclerView.addOnScrollListener(new RecyclerViewScrollListener());
    }
    @CheckNet
    public void getDataFromServer(final int type) {
        Api api = HttpManager.getInstance().getApiService(Constant.PEURL);
        api.getPeSchoolBean(mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PeSchoolBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull PeSchoolBean schoolBean) {
                        //更新界面数据
                        if (Constant.GET_DATA_TYPE_NOMAL == type) {
                            //正常模式下，清空之前数据，重新加载
                            mItemList.clear();
                            mItemList = schoolBean.getData().getItemList();
                        } else {
                            //加载更多模式
                            mItemList.addAll(schoolBean.getData().getItemList());
                        }

                        //如果获取的数据不足一页，代表当前已经没有更过数据，关闭加载更多
                        if (schoolBean.getData().getItemList().size() < 10) {
                            mIsLoadMore = false;
                        }
                        mPeSchoolAdapter.setList(mItemList);
                        mPeSchoolAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        SnackBarUtils.show(mContext, "木有更多数据了...");
                        stopRefresh();
                        hideLoading();
                        stopLoadingMore();
                    }

                    @Override
                    public void onComplete() {
                        stopRefresh();
                        hideLoading();
                        stopLoadingMore();
                    }
                });
    }

    /**
     * 开启加载中动画
     */
    public void showLoading() {
        mAvi.smoothToShow();
    }

    /**
     * 关闭加载中动画
     */

    public void hideLoading() {
        if (mAvi.isShown()) {
            mAvi.smoothToHide();
        }
    }

    public void stopRefresh() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    public void stopLoadingMore() {
        mLayoutLoadMore.setVisibility(View.GONE);
        mAviLoadMore.smoothToHide();
    }

    /**
     * 开启加载更多动画
     */
    public void startLoadingMore() {
        mLayoutLoadMore.setVisibility(View.VISIBLE);
        mAviLoadMore.smoothToShow();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 退出的时候不在回调更新界面
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    /**
     * RecyclerView 滑动监听器
     */
    class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (mItemList.size() < 1) {
                return;
            }
            //如果正在下拉刷新则放弃监听状态
            if (mRefreshLayout.isRefreshing()) {
                return;
            }
            //当前RecyclerView显示出来的最后一个的item的position,默认为-1
            int lastPosition = -1;
            //当前状态为停止滑动状态SCROLL_STATE_IDLE时
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //分别判断三种类型
                lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                // 判断是否可以向下滑动，如果不能就代表已经到底部
                if (!recyclerView.canScrollVertically(1)) {
                    recyclerView.smoothScrollToPosition(lastPosition);
                    if (!mIsLoadMore) {
                        SnackBarUtils.show(mContext, "木有更多数据了...");
                        return;
                    }
                    //此时需要请求更多数据，显示加载更多界面
                    mPage++;
                    startLoadingMore();
                    getDataFromServer(Constant.GET_DATA_TYPE_LOADMORE);
                }
            }
        }
    }
}
