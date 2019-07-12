package com.github.soisearach;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Objects;

public class MyNotifListener extends NotificationListenerService {

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        MyNotification myNotification = new MyNotification();
        Notification sbnNotification = sbn.getNotification();
        if (sbnNotification.tickerText != null) {
            myNotification.setTickerText(sbnNotification.tickerText.toString());
        }


        Bundle extras = sbnNotification.extras;

        if (extras.containsKey("android.text")) {
            if (extras.getCharSequence("android.text") != null) {
                String text = Objects.requireNonNull(extras.getCharSequence("android.text")).toString();
                myNotification.setText(text);
            }
        }
        if (extras.containsKey("android.title")) {
            myNotification.setTitle(extras.getString("android.title"));
        }

        RetrofitInterface.getApi().putData(myNotification).enqueue(new Callback<List<AnswerData<String>>>() {
            @Override
            public void onResponse(Call<List<AnswerData<String>>> call, Response<List<AnswerData<String>>> response) {

            }

            @Override
            public void onFailure(Call<List<AnswerData<String>>> call, Throwable t) {
            }
        });

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // Implement what you want here
    }
}