package com.example.madassignment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PaymentDetail extends AppCompatActivity {
    private EditText Card_Name,bank_text,card_number,expDate,ccv_text;
    private Button Btnconfirm;
    private DatabaseReference reff;
    private Member1 member1;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    public long maxId = 0;
    private final String CHANNEL_ID = "simple_notification";
    private final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);

        Card_Name = (EditText) findViewById(R.id.Card_Name);
        bank_text = (EditText) findViewById(R.id.bank_text);
        card_number = (EditText) findViewById(R.id.card_number);
        expDate = (EditText) findViewById(R.id.expDate);
        ccv_text = (EditText) findViewById(R.id.ccv_text);
        Btnconfirm = (Button) findViewById(R.id.Btnconfirm);
        member1 = new Member1();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        reff = FirebaseDatabase.getInstance().getReference().child("Payment");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxId = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
                builder.setSmallIcon(R.drawable.lacclogo);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.id.lacclogo));
                builder.setContentTitle("LACC Fashion");
                builder.setContentText("Thank You For Purchasing and Hope You Can Purchase Our Product Next Time.");
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

                final String name = Card_Name.getText().toString().trim();
                final String BankName = bank_text.getText().toString().trim();
                int number= Integer.parseInt(card_number.getText().toString().trim());
                final String date = expDate.getText().toString().trim();
                int ccvNum= Integer.parseInt(ccv_text.getText().toString().trim());

                member1.setName(name);
                member1.setBankName(BankName);
                member1.setNumber(number);
                member1.setDate(date);
                member1.setCcvNum(ccvNum);
                reff.child("Payment"+ String.valueOf(maxId+1)).setValue(member1);
                Toast.makeText(PaymentDetail.this,"Order completed",Toast.LENGTH_LONG).show();

                Card_Name.setText("");
                bank_text.setText("");
                card_number.setText("");
                expDate.setText("");
                ccv_text.setText("");

                startActivity(new Intent(PaymentDetail.this, MainPage.class));
            }
        });


    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name = "LACC Fashion";
            String description = "Thank You For Purchasing and Hope You Can Purchase Our Product Next Time.";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}