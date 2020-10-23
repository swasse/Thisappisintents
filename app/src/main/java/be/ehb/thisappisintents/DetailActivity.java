package be.ehb.thisappisintents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import be.ehb.thisappisintents.model.Persoon;

public class DetailActivity extends AppCompatActivity {

    private Persoon geselecteerdPersoon;

    private View.OnClickListener homepageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri page = Uri.parse(geselecteerdPersoon.getHomepage());
            Intent intent = new Intent(Intent.ACTION_VIEW, page);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    };

    private View.OnClickListener callListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            call(geselecteerdPersoon.getTel());
        }
    };

    //voor zaken die potentieel de privacy schenden moet je expliciet toestemming van de gebruiker vragen
    private void call(String telNr) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            askPermission();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri tel = Uri.parse(telNr);// ^ telNR
        intent.setData(tel);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void askPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE}, 1000 );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvNaam = findViewById(R.id.tv_naam);
        Button btnCall = findViewById(R.id.btn_call);
        Button btnHomepage = findViewById(R.id.btn_homepage);

        //persoon uit intent halen
        geselecteerdPersoon = (Persoon) getIntent().getSerializableExtra("persoon");


        //waarden gebruiken
        tvNaam.setText(geselecteerdPersoon.getNaam());
        //listener aan knop hangen!!!!
        btnHomepage.setOnClickListener(homepageListener);
        btnCall.setOnClickListener(callListener);

        askPermission();
    }


}
