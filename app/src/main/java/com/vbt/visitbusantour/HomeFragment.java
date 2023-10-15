package com.vbt.visitbusantour;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vbt.visitbusantour.activity.AttractionDetailActivity;
import com.vbt.visitbusantour.activity.FestivalDetailActivity;
import com.vbt.visitbusantour.activity.FoodDetailActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    // Attraction
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ArrayList<RecyclerViewItem> mList;

    // Festival
    private RecyclerView mRecyclerView2;
    private RecyclerViewAdapter2 mRecyclerViewAdapter2;
    private ArrayList<RecyclerViewItem2> mList2;

    // Food
    private RecyclerView mRecyclerView3;
    private RecyclerViewAdapter3 mRecyclerViewAdapter3;
    private ArrayList<RecyclerViewItem3> mList3;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        StrictMode.enableDefaults();

        // Attraction
        mRecyclerView = view.findViewById(R.id.recyclerView1);
        mList = new ArrayList<>();
        mRecyclerViewAdapter = new RecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        mRecyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                RecyclerViewItem selectedItem = mList.get(position);
                // 클릭한 아이템의 위치(position) 정보를 Intent에 추가하여 다른 Activity로 전달

                RecyclerViewItem item = new RecyclerViewItem();

                item.setMainText(selectedItem.getMainText());
                item.setImgName(selectedItem.getImgName());
                item.setHldyInfo(selectedItem.getHldyInfo());
                item.setmGugunNM(selectedItem.getmGugunNM());
                item.setmAddr(selectedItem.getmAddr());
                item.setmUsageTime(selectedItem.getmUsageTime());
                item.setmCntctTel(selectedItem.getmCntctTel());
                item.setmTrfcInfo(selectedItem.getmTrfcInfo());

                Intent intent = new Intent(getActivity(), AttractionDetailActivity.class);
                intent.putExtra("itemInfo", item);
                startActivity(intent);
            }
        });

        // Festival
        mRecyclerView2 = view.findViewById(R.id.recyclerView2);
        mList2 = new ArrayList<>();
        mRecyclerViewAdapter2 = new RecyclerViewAdapter2(mList2);
        mRecyclerView2.setAdapter(mRecyclerViewAdapter2);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        mRecyclerViewAdapter2.setOnItemClickListener(new RecyclerViewAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                RecyclerViewItem2 selectedItem = mList2.get(position);
                // 클릭한 아이템의 위치(position) 정보를 Intent에 추가하여 다른 Activity로 전달

                RecyclerViewItem2 item = new RecyclerViewItem2();

                item.setPlace(selectedItem.getPlace());
                item.setImgName(selectedItem.getImgName());
                item.setHldyInfo(selectedItem.getHldyInfo());
                item.setGugunNM(selectedItem.getGugunNM());
                item.setAddr(selectedItem.getAddr());
                item.setUsageTime(selectedItem.getUsageTime());
                item.setCntctTel(selectedItem.getCntctTel());
                item.setAmount(selectedItem.getAmount());
                item.setMiddleSizeRM(selectedItem.getMiddleSizeRM());
                item.setTrfcInfo(selectedItem.getTrfcInfo());

                Intent intent = new Intent(getActivity(), FestivalDetailActivity.class);
                intent.putExtra("itemInfo", item);
                startActivity(intent);
            }
        });

        // Food
        mRecyclerView3 = view.findViewById(R.id.recyclerView3);
        mList3 = new ArrayList<>();
        mRecyclerViewAdapter3 = new RecyclerViewAdapter3(mList3);
        mRecyclerView3.setAdapter(mRecyclerViewAdapter3);
        mRecyclerView3.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        mRecyclerViewAdapter3.setOnItemClickListener(new RecyclerViewAdapter3.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                RecyclerViewItem3 selectedItem = mList3.get(position);
                // 클릭한 아이템의 위치(position) 정보를 Intent에 추가하여 다른 Activity로 전달

                RecyclerViewItem3 item = new RecyclerViewItem3();

                item.setPlace(selectedItem.getPlace());
                item.setImgName(selectedItem.getImgName());
                item.setGugunNM(selectedItem.getGugunNM());
                item.setAddr(selectedItem.getAddr());
                item.setUsageTime(selectedItem.getUsageTime());
                item.setCntctTel(selectedItem.getCntctTel());
                item.setMainTitle(selectedItem.getMainTitle());
                item.setRprsntvMenu(selectedItem.getRprsntvMenu());
                item.setItemCntnts(selectedItem.getItemCntnts());

                Intent intent = new Intent(getActivity(), FoodDetailActivity.class);
                intent.putExtra("itemInfo", item);
                startActivity(intent);
            }
        });

        AttractionData();
        FestivalData();
        FoodData();

        return view;
    }

    // Attraciton API
    private void AttractionData() {

        String serviceKey = getString(R.string.service_key);

        boolean inCntctTel = false, inMainImgNormal = false, inHldyInfo = false;
        boolean inPlace = false, inUsageDayWeekAndTime = false;
        boolean inGugunNM = false, inAddr1 = false, inTrfcInfo = false;

        String cntctTel = null, mainImgNormal = null;
        String hldyInfo = null, place = null, usageDayWeekAndTime = null;
        String gugunNm = null, addr1 = null, trfcInfo = null;

        try {
            for (int i = 255; i <= 270; i++) {
                URL url = new URL("https://apis.data.go.kr/6260000/AttractionService/getAttractionEn?" + "&pageNo=1&numOfRows=15&UC_SEQ=" + i + "&serviceKey=" + serviceKey);

                XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
                XmlPullParser parser = parserCreator.newPullParser();
                parser.setInput(url.openStream(), null);

                int parserEvent = parser.getEventType();

                while (parserEvent != XmlPullParser.END_DOCUMENT) {
                    switch (parserEvent) {
                        case XmlPullParser.START_TAG:
                            if (parser.getName().equals("PLACE")) {
                                inPlace = true;
                            }
                            if(parser.getName().equals("HLDY_INFO")) {
                                inHldyInfo = true;
                            }
                            if(parser.getName().equals("GUGUN_NM")) {
                                inGugunNM = true;
                            }
                            if(parser.getName().equals("MAIN_IMG_NORMAL")) {
                                inMainImgNormal = true;
                            }
                            if(parser.getName().equals("USAGE_DAY_WEEK_AND_TIME")) {
                                inUsageDayWeekAndTime = true;
                            }
                            if(parser.getName().equals("CNTCT_TEL")) {
                                inCntctTel = true;
                            }
                            if(parser.getName().equals("TRFC_INFO")) {
                                inTrfcInfo = true;
                            }
                            break;
                        case XmlPullParser.TEXT:
                            if(inPlace) {
                                place = parser.getText();
                                inPlace = false;
                            }
                            if(inHldyInfo) {
                                hldyInfo = parser.getText();
                                inHldyInfo = false;
                            }
                            if(inGugunNM) {
                                gugunNm = parser.getText();
                                inGugunNM = false;
                            }
                            if(inAddr1) {
                                addr1 = parser.getText();
                                inAddr1 = false;
                            }
                            if(inUsageDayWeekAndTime) {
                                usageDayWeekAndTime = parser.getText();
                                inUsageDayWeekAndTime = false;
                            }
                            if(inCntctTel) {
                                cntctTel = parser.getText();
                                inCntctTel = false;
                            }
                            if(inMainImgNormal) {
                                mainImgNormal = parser.getText();
                                inMainImgNormal = false;
                            }
                            if(inTrfcInfo) {
                                trfcInfo = parser.getText();
                                inTrfcInfo = false;
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            if(parser.getName().equals("item")) {
                                RecyclerViewItem item = new RecyclerViewItem();
                                item.setImgName(mainImgNormal);
                                item.setMainText(place);
                                item.setHldyInfo(hldyInfo);
                                item.setmGugunNM(gugunNm);
                                item.setmAddr(addr1);
                                item.setmUsageTime(usageDayWeekAndTime);
                                item.setmCntctTel(cntctTel);
                                item.setmTrfcInfo(trfcInfo);

                                mList.add(item);
                                mRecyclerViewAdapter.notifyDataSetChanged();
                            }
                            break;
                    }
                    parserEvent = parser.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Festival info
    private void FestivalData() {

        String serviceKey = getString(R.string.service_key);

        boolean inCntctTel = false, inMainImgNormal = false, inHldyInfo = false;
        boolean inPlace = false, inUsageDayWeekAndTime = false, inUsageAmount = false;
        boolean inGugunNM = false, inAddr1 = false, inTrfcInfo = false, inMiddleSizeRm = false;

        String cntctTel = null, mainImgNormal = null, usageAmount = null;
        String hldyInfo = null, place = null, usageDayWeekAndTime = null;
        String gugunNm = null, addr1 = null, trfcInfo = null, middleSizeRm = null;

        try {
            URL url = new URL("https://apis.data.go.kr/6260000/FestivalService/getFestivalEn?" + "&pageNo=1&numOfRows=15" + "&serviceKey=" + serviceKey);

            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("PLACE")) {
                            inPlace = true;
                        }
                        if(parser.getName().equals("HLDY_INFO")) {
                            inHldyInfo = true;
                        }
                        if(parser.getName().equals("ADDR1")) {
                            inAddr1 = true;
                        }
                        if(parser.getName().equals("GUGUN_NM")) {
                            inGugunNM = true;
                        }
                        if(parser.getName().equals("MAIN_IMG_NORMAL")) {
                            inMainImgNormal = true;
                        }
                        if(parser.getName().equals("USAGE_DAY_WEEK_AND_TIME")) {
                            inUsageDayWeekAndTime = true;
                        }
                        if(parser.getName().equals("USAGE_AMOUNT")) {
                            inUsageAmount = true;
                        }
                        if(parser.getName().equals("CNTCT_TEL")) {
                            inCntctTel = true;
                        }
                        if(parser.getName().equals("MIDDLE_SIZE_RM1")) {
                            inMiddleSizeRm = true;
                        }
                        if(parser.getName().equals("TRFC_INFO")) {
                            inTrfcInfo = true;
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if(inPlace) {
                            place = parser.getText();
                            inPlace = false;
                        }
                        if(inHldyInfo) {
                            hldyInfo = parser.getText();
                            inHldyInfo = false;
                        }
                        if(inGugunNM) {
                            gugunNm = parser.getText();
                            inGugunNM = false;
                        }
                        if(inAddr1) {
                            addr1 = parser.getText();
                            inAddr1 = false;
                        }
                        if(inUsageDayWeekAndTime) {
                            usageDayWeekAndTime = parser.getText();
                            inUsageDayWeekAndTime = false;
                        }
                        if(inUsageAmount) {
                            usageAmount = parser.getText();
                            inUsageAmount = false;
                        }
                        if(inCntctTel) {
                            cntctTel = parser.getText();
                            inCntctTel = false;
                        }
                        if(inMainImgNormal) {
                            mainImgNormal = parser.getText();
                            inMainImgNormal = false;
                        }
                        if(inMiddleSizeRm) {
                            middleSizeRm = parser.getText();
                            inMiddleSizeRm = false;
                        }
                        if(inTrfcInfo) {
                            trfcInfo = parser.getText();
                            inTrfcInfo = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")) {
                            RecyclerViewItem2 item = new RecyclerViewItem2();
                            item.setImgName(mainImgNormal);
                            item.setPlace(place);
                            item.setHldyInfo(hldyInfo);
                            item.setMiddleSizeRM(middleSizeRm);
                            item.setAmount(usageAmount);
                            item.setGugunNM(gugunNm);
                            item.setAddr(addr1);
                            item.setUsageTime(usageDayWeekAndTime);
                            item.setCntctTel(cntctTel);
                            item.setTrfcInfo(trfcInfo);

                            mList2.add(item);
                            mRecyclerViewAdapter2.notifyDataSetChanged();
                        }
                        break;
                }
                parserEvent = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Food info
    private void FoodData() {

        String serviceKey = getString(R.string.service_key);

        boolean inPlace = false, inUsageDayWeekAndTime = false, inGugunNM = false, inMainImgNormal = false;
        boolean inAddr1 = false, inMainTitle = false, inCntctTel = false;
        boolean inRprsntvMenu = false, inItemCntnts = false;

        String place = null, usageDayWeekAndTime = null, gugunNm = null, mainImgNormal = null;
        String addr1 = null, mainTitle = null, cntctTel = null;
        String rprsntvMenu = null, itemCntnts = null;

        try {
            URL url = new URL("https://apis.data.go.kr/6260000/FoodService/getFoodEn?" + "&pageNo=1&numOfRows=15" + "&serviceKey=" + serviceKey);

            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("PLACE")) {
                            inPlace = true;
                        }
                        if(parser.getName().equals("USAGE_DAY_WEEK_AND_TIME")) {
                            inUsageDayWeekAndTime = true;
                        }
                        if(parser.getName().equals("GUGUN_NM")) {
                            inGugunNM = true;
                        }
                        if(parser.getName().equals("MAIN_IMG_NORMAL")) {
                            inMainImgNormal = true;
                        }
                        if(parser.getName().equals("ADDR1")) {
                            inAddr1 = true;
                        }
                        if(parser.getName().equals("MAIN_TITLE")) {
                            inMainTitle = true;
                        }
                        if(parser.getName().equals("CNTCT_TEL")) {
                            inCntctTel = true;
                        }
                        if(parser.getName().equals("RPRSNTV_MENU")) {
                            inRprsntvMenu = true;
                        }
                        if(parser.getName().equals("ITEMCNTNTS")) {
                            inItemCntnts = true;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if(inPlace) {
                            place = parser.getText();
                            inPlace = false;
                        }
                        if(inUsageDayWeekAndTime) {
                            usageDayWeekAndTime = parser.getText();
                            inUsageDayWeekAndTime = false;
                        }
                        if(inGugunNM) {
                            gugunNm = parser.getText();
                            inGugunNM = false;
                        }
                        if(inMainImgNormal) {
                            mainImgNormal = parser.getText();
                            inMainImgNormal = false;
                        }
                        if(inAddr1) {
                            addr1 = parser.getText();
                            inAddr1 = false;
                        }
                        if(inMainTitle) {
                            mainTitle = parser.getText();
                            inMainTitle = false;
                        }
                        if(inCntctTel) {
                            cntctTel = parser.getText();
                            inCntctTel = false;
                        }
                        if(inRprsntvMenu) {
                            rprsntvMenu = parser.getText();
                            inRprsntvMenu = false;
                        }
                        if(inItemCntnts) {
                            itemCntnts = parser.getText();
                            inItemCntnts = false;
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")) {
                            RecyclerViewItem3 item = new RecyclerViewItem3();

                            item.setPlace(place);
                            item.setUsageTime(usageDayWeekAndTime);
                            item.setGugunNM(gugunNm);
                            item.setImgName(mainImgNormal);
                            item.setAddr(addr1);
                            item.setMainTitle(mainTitle);
                            item.setCntctTel(cntctTel);
                            item.setRprsntvMenu(rprsntvMenu);
                            item.setItemCntnts(itemCntnts);

                            mList3.add(item);
                            mRecyclerViewAdapter3.notifyDataSetChanged();
                        }
                        break;
                }
                parserEvent = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}