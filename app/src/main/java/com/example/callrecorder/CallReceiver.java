package com.example.callrecorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class CallReceiver extends BroadcastReceiver {
    private static boolean isRecording = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) {
            if (!isRecording) {
                Intent serviceIntent = new Intent(context, RecorderService.class);
                context.startService(serviceIntent);
                isRecording = true;
            }
        } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(state)) {
            if (isRecording) {
                Intent serviceIntent = new Intent(context, RecorderService.class);
                context.stopService(serviceIntent);
                isRecording = false;
            }
        }
    }
}
