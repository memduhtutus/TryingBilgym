package com.memduhtutus.tryingbilgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.view.View;

public class AvailableEventScreen extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser mUser;
    private TextView txtAvailableEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_event_screen);
        mAuth = FirebaseAuth.getInstance();

    }

    public void showEventsClicked(View view){
        mDatabase = FirebaseDatabase.getInstance().getReference("Events");
        DatabaseHandler dh = new DatabaseHandler(mDatabase, mAuth);
        mUser = dh.getmAuth().getCurrentUser();
        dh.getmDatabase().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String result = "";
                txtAvailableEvents = findViewById(R.id.textViewAvailableEvents);
                int i = 1;
                for(DataSnapshot snp : snapshot.getChildren()){
                    result += "          " + "Event " + i + "\n";
                    String values = snp.getValue().toString();
                    String[] valuesArr = values.split(",");

                    for(String val : valuesArr){
                        result += "          " + val + "\n";
                    }
                    i++;
                    result += "\n\n";
                }
                txtAvailableEvents.setText(result);
                txtAvailableEvents.setMovementMethod(new ScrollingMovementMethod());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AvailableEventScreen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}