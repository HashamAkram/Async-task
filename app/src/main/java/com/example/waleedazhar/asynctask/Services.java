package com.example.waleedazhar.asynctask;

/**
 * Created by Waleed Azhar on 1/13/2018.
 */
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
public class Services extends Service {
    public static boolean isRunning = false;
    public Services() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int limit = intent.getIntExtra("limit",0);
        Async task = new Async();
        task.execute(limit,startId);
        Toast.makeText(this, "MyService Started.", Toast.LENGTH_SHORT).show();
        return START_STICKY;
}
