package com.czbix.v2ex.model;

import android.os.Parcel;

import com.czbix.v2ex.network.RequestHelper;

public class Tab extends Page {
    public static final Tab[] ALL_TABS = {
            new Tab("技术", "/?tab=tech"),
            new Tab("创意", "/?tab=creative"),
            new Tab("好玩", "/?tab=play"),
            new Tab("Apple", "/?tab=apple"),
            new Tab("酷工作", "/?tab=jobs"),
            new Tab("交易", "/?tab=deals"),
            new Tab("城市", "/?tab=city"),
            new Tab("问与答", "/?tab=qna"),
            new Tab("最热", "/?tab=hot"),
            new Tab("全部", "/?tab=all"),
            new Tab("R2", "/?tab=r2"),
            //new Tab("", "/?tab=nodes"), // why it empty?
            new Tab("关注", "/?tab=members"),
    };
    public static final Tab TAB_ALL = ALL_TABS[9];

    private final String mTitle;
    private final String mUrl;

    Tab(String title, String url) {
        mTitle = title;
        mUrl = url;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public String getUrl() {
        return RequestHelper.BASE_URL + mUrl;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mUrl);
    }

    public static final Creator<Tab> CREATOR = new Creator<Tab>() {
        @Override
        public Tab createFromParcel(Parcel source) {
            return new Tab(source.readString(), source.readString());
        }

        @Override
        public Tab[] newArray(int size) {
            return new Tab[size];
        }
    };
}
