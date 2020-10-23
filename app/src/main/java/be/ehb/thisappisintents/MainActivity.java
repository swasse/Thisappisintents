package be.ehb.thisappisintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import be.ehb.thisappisintents.model.Persoon;
import be.ehb.thisappisintents.model.PersoonDAO;

public class MainActivity extends AppCompatActivity {

    private Spinner spiPersonen;
    private Button btnDetails;

    private View.OnClickListener detailListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Persoon geselecteerd = (Persoon) spiPersonen.getSelectedItem();

            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("persoon", geselecteerd);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //verwijzingen naar wat in scherm zit
        spiPersonen = findViewById(R.id.spi_personen);
        btnDetails = findViewById(R.id.btn_details);

        //spinner opvullen
        //aanmaken adapter, dit bevat de layout voor rijen en array met gegevens
        ArrayAdapter<Persoon> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                PersoonDAO.getInstance().getPersonen());
        //adapter aan spinner vasthangen
        spiPersonen.setAdapter(adapter);

        //listener voor button
        btnDetails.setOnClickListener(detailListener);
    }
}
