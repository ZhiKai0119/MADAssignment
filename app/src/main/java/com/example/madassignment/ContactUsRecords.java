package com.example.madassignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.model.contactUsAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactUsRecords extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private contactUsAdapter adapter;
    private Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_records);

        member = new Member();
        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference().child("Member");
        mRef.keepSynced(true);

        recyclerView = (RecyclerView) findViewById(R.id.contact_us_linear);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Member> options = new FirebaseRecyclerOptions.Builder<Member>().setQuery(mRef, Member.class).setLifecycleOwner(this).build();

        adapter = new contactUsAdapter(options);
        recyclerView.setAdapter(adapter);
    }

//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        super.onContextItemSelected(item);
//
//        switch (item.getItemId()){
//            case 101:
//                Snackbar.make(findViewById(R.id.rootId), "The record was deleted.", Snackbar.LENGTH_SHORT).show();
//                mRef.child("Member").removeValue();
//                adapter.RemoveItem(item.getGroupId());
//                return true;
//            case 20:
//                Snackbar.make(findViewById(R.id.rootId), "No Changes", Snackbar.LENGTH_SHORT).show();
//                return true;
//        }
//        return true;
//    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}