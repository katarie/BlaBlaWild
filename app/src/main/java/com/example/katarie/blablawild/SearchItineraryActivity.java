package com.example.katarie.blablawild;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText depart = (EditText) findViewById(R.id.textdepart);
        final EditText destination = (EditText) findViewById(R.id.textdestination);
        EditText date = (EditText) findViewById(R.id.textdate);
        Button rechercher = (Button) findViewById(R.id.buttonsearch);

        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (depart.getText().toString().isEmpty()
                        || destination.getText().toString().isEmpty()){
                    Context context = getApplicationContext();
                    CharSequence text = "Remplissez Départ et destination !";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    String departstring = depart.getText().toString();
                    String destinationstring = destination.getText().toString();

                    Intent intent = new Intent(SearchItineraryActivity.this,
                           ViewSearchItineraryResultsListActivity.class);
                    intent.putExtra("Depart",  departstring);
                    intent.putExtra("Destination", destinationstring);

                    SearchItineraryActivity.this.startActivity(intent);

                }

            }
        });

    }
}
