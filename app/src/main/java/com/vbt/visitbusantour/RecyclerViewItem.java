package com.vbt.visitbusantour;

import java.io.Serializable;

public class RecyclerViewItem implements Serializable {
    private String mImgName;
    private String mMainText;

    private String mHldyInfo;
    private String mGugunNM;
    private String mAddr;
    private String mUsageTime;
    private String mCntctTel;
    private String mTrfcInfo;

    public String getImgName() {
        return mImgName;
    }

    public void setImgName(String imgName) {
        this.mImgName = imgName;
    }

    public String getMainText() {
        return mMainText;
    }

    public void setMainText(String mainText) {
        this.mMainText = mainText;
    }

    public String getHldyInfo() {
        return mHldyInfo;
    }

    public void setHldyInfo(String hldyText) {
        this.mHldyInfo = hldyText;
    }

    public String getmGugunNM() {
        return mGugunNM;
    }

    public void setmGugunNM(String mGugunNM) {
        this.mGugunNM = mGugunNM;
    }

    public String getmAddr() {
        return mAddr;
    }

    public void setmAddr(String mAddr) {
        this.mAddr = mAddr;
    }

    public String getmUsageTime() {
        return mUsageTime;
    }

    public void setmUsageTime(String mUsageTime) {
        this.mUsageTime = mUsageTime;
    }

    public String getmCntctTel() {
        return mCntctTel;
    }

    public void setmCntctTel(String mCntctTel) {
        this.mCntctTel = mCntctTel;
    }

    public String getmTrfcInfo() {
        return mTrfcInfo;
    }

    public void setmTrfcInfo(String mTrfcInfo) {
        this.mTrfcInfo = mTrfcInfo;
    }
}
