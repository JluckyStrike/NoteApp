package com.itfun.noteapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Note implements Parcelable {
    @StringRes
    private int title;
    @StringRes
    private int description;
    @StringRes
    private int date;


    public Note(int title, int description, int date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    protected Note(Parcel in) {
        title = in.readInt();
        description = in.readInt();
        date = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public int getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(title);
        parcel.writeInt(description);
        parcel.writeInt(date);
    }
}
