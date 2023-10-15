package com.vbt.visitbusantour;

import java.io.Serializable;

public class RecyclerViewItem2 implements Serializable {
    private String ImgName;
    private String Place;

    private String HldyInfo;
    private String GugunNM;
    private String Addr;
    private String UsageTime;
    private String CntctTel;
    private String Amount;
    private String MiddleSizeRM;
    private String TrfcInfo;

    public String getImgName() {
        return ImgName;
    }

    public void setImgName(String imgName) {
        this.ImgName = imgName;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        this.Place = place;
    }

    public String getHldyInfo() {
        return HldyInfo;
    }

    public void setHldyInfo(String hldyText) {
        this.HldyInfo = hldyText;
    }

    public String getGugunNM() {
        return GugunNM;
    }

    public void setGugunNM(String gugunNM) {
        this.GugunNM = gugunNM;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        this.Addr = addr;
    }

    public String getUsageTime() {
        return UsageTime;
    }

    public void setUsageTime(String usageTime) {
        this.UsageTime = usageTime;
    }

    public String getCntctTel() {
        return CntctTel;
    }

    public void setCntctTel(String cntctTel) {
        this.CntctTel = cntctTel;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        this.Amount = amount;
    }

    public String getMiddleSizeRM() {
        return MiddleSizeRM;
    }

    public void setMiddleSizeRM(String middleSizeRM) {
        this.MiddleSizeRM = middleSizeRM;
    }

    public String getTrfcInfo() {
        return TrfcInfo;
    }

    public void setTrfcInfo(String trfcInfo) {
        this.TrfcInfo = trfcInfo;
    }
}
