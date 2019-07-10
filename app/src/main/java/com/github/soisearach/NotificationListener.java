package com.github.soisearach;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class NotificationListener extends NotificationListenerService {

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        Notification notification = new Notification();
        notification.setTickerText(sbn.getNotification().tickerText.toString());


        Bundle extras = sbn.getNotification().extras;

        if (extras.containsKey("android.text")) {
            if (extras.getCharSequence("android.text") != null) {
                String text = extras.getCharSequence("android.text").toString();
                notification.setText(text);
            }
        }
        if (extras.containsKey("android.title")) {
            notification.setTitle(extras.getString("android.title"));
        }

        RetrofitInterface.getApi().putData(notification).enqueue(new Callback<List<AnswerData<String>>>() {
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
