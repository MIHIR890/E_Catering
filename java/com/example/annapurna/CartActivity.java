package com.example.annapurna;

import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    TextView usernameTV;
    TextView DescriptionTV;
    Button orderbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        orderbtn = findViewById(R.id.confirmbutton);
        usernameTV = findViewById(R.id.usernameTV);
        Intent intentp3 = getIntent();
        String receivedValuep3 = intentp3.getStringExtra("PASSENGER_NAME");
        usernameTV.setText(receivedValuep3);
        DescriptionTV = (TextView) findViewById(R.id.descriptionTV);
        Intent intentf3 = getIntent();
        String receivedValuef3 = intentf3.getStringExtra("FOOD_NAME");
        DescriptionTV.setText(receivedValuef3);

    }

    public void headsUpNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(CartActivity.this,Utils.CHANNEL_ID)

                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(Utils.NOTI_TITLE)
                .setContentText(Utils.NOTI_DESC)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(CartActivity.this);
        notificationManagerCompat.notify(Utils.NOTI_ID,builder.build());
    }
}