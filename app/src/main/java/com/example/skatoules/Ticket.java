package com.example.skatoules;

import android.os.Parcel;
import android.os.Parcelable;

public class Ticket implements Parcelable {
    private  String ticketId;
    private  String startDate;
    private  String endDate;
    private  String startTime;
    private  String endTime;
    private  String parkingName;
    private  String totalFee;

    public Ticket(String startDate, String endDate, String startTime, String endTime, String parkingName, String totalFee) {
        this.ticketId = java.util.UUID.randomUUID().toString();
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parkingName = parkingName;
        this.totalFee = totalFee;
    }

    protected Ticket(Parcel in) {
        ticketId = in.readString();
        startDate = in.readString();
        endDate = in.readString();
        startTime = in.readString();
        endTime = in.readString();
        parkingName = in.readString();
        totalFee = in.readString();
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ticketId);
        parcel.writeString(startDate);
        parcel.writeString(endDate);
        parcel.writeString(startTime);
        parcel.writeString(endTime);
        parcel.writeString(parkingName);
        parcel.writeString(totalFee);
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getParkingName() {
        return parkingName;
    }

    public String getTotalFee() {
        return totalFee;
    }
}
