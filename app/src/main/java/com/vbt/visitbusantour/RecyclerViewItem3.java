package com.vbt.visitbusantour;

import java.io.Serializable;

public class RecyclerViewItem3 implements Serializable {
    private String ImgName;
    private String Place;
    private String UsageTime;

    private String GugunNM;
    private String Addr;
    private String MainTitle;
    private String CntctTel;
    private String RprsntvMenu;
    private String ItemCntnts;

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

    public String getMainTitle() {
        return MainTitle;
    }

    public void setMainTitle(String mainTitle) {
        MainTitle = mainTitle;
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

    public String getRprsntvMenu() {
        return RprsntvMenu;
    }

    public void setRprsntvMenu(String rprsntvMenu) {
        RprsntvMenu = rprsntvMenu;
    }

    public String getItemCntnts() {
        return ItemCntnts;
    }

    public void setItemCntnts(String itemCntnts) {
        ItemCntnts = itemCntnts;
    }
}
