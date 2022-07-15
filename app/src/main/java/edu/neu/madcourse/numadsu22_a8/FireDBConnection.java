package edu.neu.madcourse.numadsu22_a8;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import edu.neu.madcourse.numadsu22_a8.utils.Utils;

public class FireDBConnection {
    private static final String SERVER_KEY = "key=AAAAuqkZ0v4:APA91bEuftlK6bcSKv7W5OpyKjGuWAYZsBJCXW-0Kzikv9_2e0avTtiDeOneAlpfFBVQLMOJpajMmGls7yoTY4YHNriQ8ez0DElAEiG7kn78CSqHM4Ytmiczd1-gLHK2JKj5Uz5QzLc-";

    public static void sendMessageToDeviceWithNewThread( User receiver, User sender, Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sendMessageToDevice(receiver, sender, context);
            }
        }).start();
    }

    static void sendMessageToDevice(User receiver, User sender, Context context) {
        // Prepare data
        JSONObject jPayload = new JSONObject();
        JSONObject jNotification = new JSONObject();
        JSONObject jdata = new JSONObject();
        try {
            jNotification.put("title", "A New Sticker");
            jNotification.put("body", "User "+ sender.username
                    + " Send a sticker to user "
                    + receiver.username);
            jNotification.put("sound", "default");
            jNotification.put("badge", "1");

            jdata.put("title", "A New Sticker is Received");
            jdata.put("content", "Come and check you received sticker");

            jPayload.put("to", receiver.token);

            jPayload.put("priority", "high");
            jPayload.put("notification", jNotification);
            jPayload.put("data", jdata);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String resp = Utils.fcmHttpConnection(SERVER_KEY, jPayload);
        //Utils.postToastMessage("Status from Server: " + resp, context);
    }
}
