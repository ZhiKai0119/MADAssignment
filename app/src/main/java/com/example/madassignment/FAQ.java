package com.example.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FAQ extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        listView=findViewById(R.id.listview);
        String[]values=new String[]{
                "Delivery","Ordering Inquiries", "Payment Inquiries",
                "Promotion And Vouchers","Return & Refund"
        };

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0){
                    Intent intent=new Intent (view.getContext(),Faq_delivery.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent (view.getContext(),Faq_OrderingInquiries.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent=new Intent (view.getContext(),Faq_PaymentInquiries.class);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent=new Intent (view.getContext(),Faq_voucher.class);
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent=new Intent (view.getContext(),Faq_return.class);
                    startActivity(intent);
                }
            }
        });
    }
}