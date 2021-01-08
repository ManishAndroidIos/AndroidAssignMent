package com.app.smsipltest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Resp_testAPI {

    @Expose
    @SerializedName("seat_map")
    private List<SeatMapEntity> mSeatMap;
    @Expose
    @SerializedName("status")
    private int mStatus;

    public List<SeatMapEntity> getSeatMap() {
        return mSeatMap;
    }

    public void setSeatMap(List<SeatMapEntity> mSeatMap) {
        this.mSeatMap = mSeatMap;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public static class SeatMapEntity {
        @Expose
        @SerializedName("SeatRow1")
        private String mSeatrow1;

        public String getSeatrow1() {
            return mSeatrow1;
        }

        public void setSeatrow1(String mSeatrow1) {
            this.mSeatrow1 = mSeatrow1;
        }



       /* @Expose
        @SerializedName("SeatRow2")
        private String SeatRow2;

        public String getSeatRow2() {
            return SeatRow2;
        }

        public void setSeatRow2(String seatRow2) {
            SeatRow2 = seatRow2;
        }*/
    }






/*    @Expose
    @SerializedName("seat_map")
    private List<SeatMapEntity> mSeatMap;
    @Expose
    @SerializedName("status")
    private int mStatus;

    public List<SeatMapEntity> getSeatMap() {
        return mSeatMap;
    }

    public void setSeatMap(List<SeatMapEntity> mSeatMap) {
        this.mSeatMap = mSeatMap;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public static class SeatMapEntity {
        @Expose
        @SerializedName("SeatRow1")
        private String mSeatrow1;

        public String getSeatrow1() {
            return mSeatrow1;
        }

        public void setSeatrow1(String mSeatrow1) {
            this.mSeatrow1 = mSeatrow1;
        }
    }*/
}
