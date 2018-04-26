package com.xsl.riders.study;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2017/11/29,Time:20:24
 * Description:
 */

public class ItemData {
    private String name;
    private int mImgId;

    public ItemData(String name, int mImgId) {
        this.name = name;
        this.mImgId = mImgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return mImgId;
    }

    public void setImgId(int mImgId) {
        this.mImgId = mImgId;
    }
}
