package com.xsl.riders.me;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.xsl.riders.R;

import net.datafans.android.common.helper.LogHelper;
import net.datafans.android.timeline.controller.TimelineViewController;
import net.datafans.android.timeline.item.LineCommentItem;
import net.datafans.android.timeline.item.LineItemType;
import net.datafans.android.timeline.item.LineLikeItem;
import net.datafans.android.timeline.item.TextImageLineItem;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/3/4,Time:13:12
 * Description:
 */

public class FriendCircleActivity extends TimelineViewController {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        addItems();

        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_back);
        LogHelper.init("## timeline ##", true);

        setHeader();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.friendcicle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_send_trends:
                break;
            case R.id.item_send_video:
                break;
            case R.id.item_send_register:
                break;
        }
        return true;
    }

    @Override
    protected int getStatusBarColor() {
        return 0x9DDD3EFF;
    }

    @Override
    protected String getNavTitle() {
        return "我的圈子";
    }

    private void setHeader() {
        String coverUrl = "http://lc-3xagb7rq.cn-n1.lcfile.com/4e3083c3967609329673.jfif";
        setCover(coverUrl);

        String userAvatarUrl = String.format("http://img4.imgtn.bdimg.com/it/u=1373411777,3992091759&fm=27&gp=0.jpg", userAvatarSize, userAvatarSize);
        setUserAvatar(userAvatarUrl);


        setUserNick("Allen");

        setUserSign("梦想还是要有的 万一实现了呢");

        setUserId(123456);
    }


    private TextImageLineItem textImageItem3;

    private void addItems() {


        TextImageLineItem textImageItem = new TextImageLineItem();

        textImageItem.itemId = 1;
        textImageItem.itemType = LineItemType.TextImage;
        textImageItem.userId = 10086;
        textImageItem.userAvatar = "http://wx1.sinaimg.cn/thumb150/743cb2f0gy1fnicguy1cjj20qo0qodhg.jpg";
        textImageItem.userNick = "Allen";
        textImageItem.title = "";
        textImageItem.text = "你是我的小苹果 小苹果 我爱你 就像老鼠爱大米 18680551720 [亲亲]";

        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");


        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        textImageItem.srcImages.add("http://lc-3xagb7rq.cn-n1.lcfile.com/b5edd31b0d5f46524072.jpg");
        ;

        textImageItem.location = "中国 • 广州";
        textImageItem.ts = System.currentTimeMillis() - 10 * 60 * 1000;


        LineLikeItem likeItem1_1 = new LineLikeItem();
        likeItem1_1.userId = 10086;
        likeItem1_1.userNick = "Allen";
        textImageItem.likes.add(likeItem1_1);


        LineLikeItem likeItem1_2 = new LineLikeItem();
        likeItem1_2.userId = 10088;
        likeItem1_2.userNick = "奥巴马";
        textImageItem.likes.add(likeItem1_2);


        LineCommentItem commentItem1_1 = new LineCommentItem();
        commentItem1_1.commentId = 1000;
        commentItem1_1.userId = 10086;
        commentItem1_1.userNick = "习大大";
        commentItem1_1.text = "精彩 大家鼓掌";
        textImageItem.comments.add(commentItem1_1);


        LineCommentItem commentItem1_2 = new LineCommentItem();
        commentItem1_2.commentId = 100980;
        commentItem1_2.userId = 10088;
        commentItem1_2.userNick = "奥巴马";
        commentItem1_2.text = "欢迎来到美利坚";
        commentItem1_2.replyUserId = 10086;
        commentItem1_2.replyUserNick = "习大大";
        textImageItem.comments.add(commentItem1_2);


        LineCommentItem commentItem1_3 = new LineCommentItem();
        commentItem1_3.commentId = 456567;
        commentItem1_3.userId = 10010;
        commentItem1_3.userNick = "神雕侠侣";
        commentItem1_3.text = "呵呵";
        textImageItem.comments.add(commentItem1_3);

        addItem(textImageItem);


        TextImageLineItem textImageItem2 = new TextImageLineItem();
        textImageItem2.itemId = 2;
        textImageItem2.itemType = LineItemType.TextImage;
        textImageItem2.userId = 10088;
        textImageItem2.userAvatar = "http://wx1.sinaimg.cn/thumb150/006tlvGoly1fjj7ewvut6g30dw07hqv6.gif";
        textImageItem2.userNick = "奥巴马";
        textImageItem2.title = "发表了";
        textImageItem2.text = "京东JD.COM-专业的综合网上购物商城，销售超数万品牌、4020万种商品，http://jd.com 囊括家电、手机、电脑、服装、图书、母婴、个护、食品、旅游等13大品类。秉承客户为先的理念，京东所售商品为正品行货、全国联保、机打发票。@刘强东";


        LineLikeItem likeItem2_1 = new LineLikeItem();
        likeItem2_1.userId = 10086;
        likeItem2_1.userNick = "Allen";
        textImageItem2.likes.add(likeItem2_1);

        LineCommentItem commentItem2_1 = new LineCommentItem();
        commentItem2_1.commentId = 31000;
        commentItem2_1.userId = 10088;
        commentItem2_1.userNick = "奥巴马";
        commentItem2_1.text = "欢迎来到美利坚";
        commentItem2_1.replyUserId = 10086;
        commentItem2_1.replyUserNick = "习大大";
        textImageItem2.comments.add(commentItem2_1);

        LineCommentItem commentItem2_2 = new LineCommentItem();
        commentItem2_2.commentId = 166000;
        commentItem2_2.userId = 10010;
        commentItem2_2.userNick = "神雕侠侣";
        commentItem2_2.text = "大家好";
        textImageItem2.comments.add(commentItem2_2);


        addItem(textImageItem2);


        textImageItem3 = new TextImageLineItem();
        textImageItem3.itemId = 3;
        textImageItem3.itemType = LineItemType.TextImage;
        textImageItem3.userId = 10088;
        textImageItem3.userAvatar = "http://wx2.sinaimg.cn/thumb150/005uWJqNly1fnkpiiy3esj30u00u00w3.jpg";
        textImageItem3.userNick = "奥巴马";
        textImageItem3.title = "发表了";
        textImageItem3.text = "京东JD.COM-专业的综合网上购物商城";

        textImageItem3.srcImages.add("http://ac-c8h5pfqx.clouddn.com/2bd13733ed2422c19b91.jpg");

        textImageItem3.thumbImages.add("http://ac-c8h5pfqx.clouddn.com/2bd13733ed2422c19b91.jpg");


        textImageItem3.width = 640;
        textImageItem3.height = 360;

        textImageItem3.location = "广州信息港";

        addItem(textImageItem3);
    }


    @Override
    public void onRefresh() {
        super.onRefresh();
        addItem(textImageItem3);
        onEnd();

    }


    @Override
    public void onLoadMore() {
        super.onLoadMore();


        addItem(textImageItem3);

        onEnd();

    }

    @Override
    protected void onCommentCreate(long itemId, long commentId, String text) {

        LineCommentItem commentItem = new LineCommentItem();
        commentItem.commentId = System.currentTimeMillis();
        commentItem.userId = 10014;
        commentItem.userNick = "我";
        commentItem.text = text;
        addCommentItem(commentItem, itemId, commentId);
    }

    @Override
    protected void onLikeCreate(long itemId) {
        LineLikeItem likeItem = new LineLikeItem();
        likeItem.userId = 1001188;
        likeItem.userNick = "我";
        addLikeItem(likeItem, itemId);
    }


    @Override
    protected void onUserClick(int userId) {
    }
}
