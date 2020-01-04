package com.example.toasttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        createNotificationChannel();

        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Signed in as David", Snackbar.LENGTH_LONG);
        snackbar.setAction("Back", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        snackbar.show();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "ch1" )
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Notification")
                .setStyle(new NotificationCompat.BigPictureStyle()
                    .setBigContentTitle("Content Title"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1001, builder.build());

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel1";
            String description = "First Notification Channel";
            NotificationChannel channel = new NotificationChannel( "ch1", name, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
