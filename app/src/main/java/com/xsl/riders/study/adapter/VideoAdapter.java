package com.xsl.riders.study.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.xsl.riders.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/22,Time:20:03
 * Description:
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    private Context mContext;
    private int page;

    public VideoAdapter(Context context, int page) {
        this.mContext = context;
        this.page = page;
    }

    private String[] videoTitles = {"坡道定点停车起步", "侧方位停车", "直角转弯", "曲线行驶", "倒车入库"};
    private String[] videoUrls = {"http://maiche.hynews.net/2017-12-25/733169b487184428b936963ec66721a9.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/7394f926fe514a5080c39f8b3ddafaa1.middle.mp4",
            "http://maiche.hynews.net/2017-12-21/0965cded111749d2887de590a6826f03.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/42697fc6a43948d8a88b56ebcf0e5980.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/97f4f93d287d4e5a9675b34a916abcde.middle.mp4"};
    private String[] videoThumbs = {"http://www.baixinxueche.com/Public/video/img/pdqb.png",
            "http://www.baixinxueche.com/Public/video/img/cfwtc.png", "http://www.baixinxueche.com/Public/video/img/zzzw.png",
            "http://www.baixinxueche.com/Public/video/img/wdxs.png",
            "http://www.baixinxueche.com/Public/video/img/dcrk.png"};


    private String[] videoTitles1 = {"科目三路考全程", "模拟夜间场景灯光使用"
            , "上车准备", "起步", "直线行驶", "变更车道", "通过路口", "加减档操作"
            , "路口左转弯", "路口右转弯", "会车", "超车", "掉头", "靠边停车"
            , "通过人行横道", "通过学校区域", "通过公共汽车站", "夜间行驶"};
    private String[] videoUrls1 = {
            "http://maiche.hynews.net/2017-12-25/6f0d0353eb074709a9987015beac45ce.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/e4a462983511407990a87045cc96b38b.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/3cd73e0719c84a7e8c322c6e776a1971.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/c10fd289b0c4493c8d64ae7c882b64ea.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/46f6feb7b4e244a6bb5c10df479bd665.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/f2febfb5ec82407f8cb819979ebdae3c.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/be65c1e39121430f9197d8f05ce24767.middle.mp4",
            "http://maiche.hynews.net/2016-12-06/3f7078cb37a046c297d23c34c1465f86.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/4609a90ac33546269012583eefc29b39.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/107c57987393433a8e9fc471d9f69c60.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/f77d20b872bd47c9af8001491b263e25.middle.mp4",
            "http://maiche.hynews.net/2016-12-06/f5ca9bb7d91b40be94d95bade46c08c2.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/b7123c45d5c14d05a5920cf2acba5c0a.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/93759969e5fc44cf8c308cb83481bc4c.middle.mp4",
            "http://maiche.hynews.net/2016-12-06/b622bf692f2e45cd83b038d8de2da49f.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/fc2baa132d85492f950cd00663a05cf1.middle.mp4",
            "http://maiche.hynews.net/2017-12-25/d994522e071a4a769b97910145f6881a.middle.mp4",
            "http://maiche.hynews.net/2016-12-06/541715024097443d819446a954b98403.middle.mp4",
            "http://maiche.hynews.net/2016-12-06/541715024097443d819446a954b98403.middle.mp4"
    };


    private String[] videoThumbs1 = {"http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/acc6963417784e1bb83f2aaaac0a0565.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2017/03/20/15/da5f35876cd546b4a972ca6dd542d070.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2017/03/20/15/3baf37c879154adb935b4b367b140a76.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/07/14/132af37b50e946a3b52a6a834d0a51cb.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/98f642a11c644e8ab752a80e83b43a7a.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/16/c90700a163fd47da836922ebaa7ad1af.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/813deda188fa40819d51263fd3993502.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/07/14/de1538e52236466e8aedd8dd42660004.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2017/03/20/15/67a5eebd4abb4ca197497cd35aa9505a.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/ecbebe846ee24359ac0f8a64f17006a2.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/6236455b180641479937fd7bbc72e4f4.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/4056357d1ade49fe876d3725a12d3bb7.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/6130527d664f42f799861dea5f90a89c.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/16/c5f089d5b6374808b44c957b946a3018.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/b677fe88e31b4e66bce7eb4934abbd84.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/076b3352c8674c4593c4f28431816f74.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/07e041e20f3b4a7898cc295807a484cd.jpeg",
            "http://exam-room.image.mucang.cn/exam-room/2016/12/08/17/2309bb601fa54fe4ab2ac0f4525fa0f1.jpeg",
    };


    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_videoview, parent, false);
        VideoHolder videoHolder = new VideoHolder(view);
        return videoHolder;
    }

    @Override
    public void onBindViewHolder(VideoHolder videoHolder, int position) {

        if (page == 1) {
            videoHolder.jcVideoPlayer.setUp(
                    videoUrls[position], JCVideoPlayer.SCREEN_LAYOUT_LIST,
                    videoTitles[position]);
            Picasso.with(mContext)
                    .load(videoThumbs[position])
                    .into(videoHolder.jcVideoPlayer.thumbImageView);
        } else {
            videoHolder.jcVideoPlayer.setUp(
                    videoUrls1[position], JCVideoPlayer.SCREEN_LAYOUT_LIST,
                    videoTitles1[position]);
            Picasso.with(mContext)
                    .load(videoThumbs1[position])
                    .into(videoHolder.jcVideoPlayer.thumbImageView);
        }

    }

    @Override
    public int getItemCount() {
        return page == 1 ? videoTitles.length : videoTitles1.length;
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        JCVideoPlayerStandard jcVideoPlayer;

        public VideoHolder(View itemView) {
            super(itemView);
            jcVideoPlayer = (JCVideoPlayerStandard) itemView.findViewById(R.id.videoplayer);
        }
    }
}
