package com.hfs.libcommon.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author HuangFusheng
 * @date 2018/12/13
 * @description EventBusBean
 */
public class EventBusBean implements Parcelable {
    private String eventName;


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.eventName);
    }

    public EventBusBean() {
    }

    protected EventBusBean(Parcel in) {
        this.eventName = in.readString();
    }

    public static final Parcelable.Creator<EventBusBean> CREATOR = new Parcelable.Creator<EventBusBean>() {
        @Override
        public EventBusBean createFromParcel(Parcel source) {
            return new EventBusBean(source);
        }

        @Override
        public EventBusBean[] newArray(int size) {
            return new EventBusBean[size];
        }
    };
}
