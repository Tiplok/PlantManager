package com.example.nico.plantmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nico.plantmanager.R;
import com.example.nico.plantmanager.database.DatabaseManager;
import com.example.nico.plantmanager.model.Plant;

public class AddPlantActivity extends AppCompatActivity {
    Plant plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        // Initialisation de la base de données
        DatabaseManager.init(this);

        // Récupération des élements graphiques
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        Button cancelButton = (Button) findViewById(R.id.button_cancel);
        Button validateButton = (Button) findViewById(R.id.button_validate);
        final EditText plantnameEditText = (EditText) findViewById(R.id.editText_plantname);
        final EditText plantwaterdayEditText = (EditText) findViewById(R.id.editText_plantwaterday);

        // Initialise notre Toolbar R.id.my_toolbar comme ActionBar pour cette activité
        setSupportActionBar(myToolbar);

        // On ferme l'activité si on appuie sur le bouton ANNULER
        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        // Si on appuie sur le bouton VALIDER
        validateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                // On vérifie les informations modifiées
                if(!plantnameEditText.getText().toString().matches("")){
                    if(!plantwaterdayEditText.getText().toString().matches("") && Integer.parseInt(plantwaterdayEditText.getText().toString()) > 1){

                        // Si c'est bon, on ajoute la plante
                        plant = new Plant();
                        plant.setName(plantnameEditText.getText().toString());
                        plant.setDaysBetweenWater(Integer.parseInt(plantwaterdayEditText.getText().toString()));
                        plant.setDaysSinceLastWater(0);
                        DatabaseManager.getInstance().addPlant(plant);
                        finish();

                    } else {
                        Toast.makeText(AddPlantActivity.this, "Il faut saisir un nombre de jours supérieur à 1.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddPlantActivity.this, "Il faut saisir un nom de plante.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
