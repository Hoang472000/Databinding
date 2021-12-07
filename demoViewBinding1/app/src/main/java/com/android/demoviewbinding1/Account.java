package com.android.demoviewbinding1;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Account extends BaseObservable {
    private String username, password;
    private String number, profileImage;
    private int padding;

    public Account(String username, String password, String number, String profileImage, int padding) {
        this.username = username;
        this.password = password;
        this.number = number;
        this.profileImage = profileImage;
        this.padding = padding;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
        notifyPropertyChanged(BR.number);
    }


    @BindingAdapter("android:profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .error(R.drawable.ic_launcher_background)
                /*.apply(RequestOptions.circleCropTransform())*/
                .into(view);
    }

    @Bindable
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);
    }


    @BindingAdapter("android:HoangCV")
    public static void setPaddingleft(View view, int paddingleft){
        view.setPadding(paddingleft,
                view.getPaddingTop(),
                view.getPaddingRight(),
                view.getPaddingBottom());
    }
    @Bindable
    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
        notifyPropertyChanged(BR.padding);
    }
}