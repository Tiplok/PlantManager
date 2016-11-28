package com.example.nico.plantmanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nico.plantmanager.R;
import com.example.nico.plantmanager.database.DatabaseManager;
import com.example.nico.plantmanager.model.Plant;

import java.util.ArrayList;

public class FixturesActivity extends AppCompatActivity {
    String[][] plantSet = new String[][]{
            { "Yucca", "3" },
            { "Dracéna", "2" },
            { "Dieffenbachia", "6" },
            { "Schefflera", "5" },
            { "Poinsettia", "4" },
            { "Chlorophytum", "4" },
            { "Herbe de la pampa", "2" },
            { "Crassula", "6" },
            { "Beaucarnea", "3" },
            { "Ficus", "2" },
            { "Aréca", "4" },
            { "Pothos", "3" },
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        // Initialisation de la base de données
        DatabaseManager.init(this);

        // Récupération des élements graphiques
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        Button createSetPlantsButton = (Button) findViewById(R.id.button_create_set_plants);
        if(createSetPlantsButton == null){
            Log.d("dam", "joke");
        }
        Button advanceTimeButton = (Button) findViewById(R.id.button_advance_time);
        Button deleteAllPlantsButton = (Button) findViewById(R.id.button_delete_all_plants);
        final EditText advancedayEditText = (EditText) findViewById(R.id.editText_advanceday);

        // Initialise notre Toolbar R.id.my_toolbar comme ActionBar pour cette activité
        setSupportActionBar(myToolbar);

        // On ajoute un ensemble prédéfini de plantes si on appuie sur le bouton correspondant
        createSetPlantsButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Plant plant;

                for(int i = 0; i < plantSet.length; i++) {
                    plant = new Plant();
                    plant.setName(plantSet[i][0]);
                    plant.setDaysBetweenWater(Integer.parseInt(plantSet[i][1]));
                    plant.setDaysSinceLastWater(0);
                    DatabaseManager.getInstance().addPlant(plant);
                }

                finish();
            }
        });

        // On avance de X jours si on appuie sur le bouton AVANCER LE TEMPS
        advanceTimeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                // On vérifie le champ de texte
                if(!advancedayEditText.getText().toString().matches("")){
                    if(!advancedayEditText.getText().toString().matches("") && Integer.parseInt(advancedayEditText.getText().toString()) > 0){

                        // On incrémente chaque plante du nombre de jours
                        ArrayList<Plant> plantArrayList = DatabaseManager.getInstance().getAllPlants();
                        for (int i = 0; i < plantArrayList.size(); i++) {
                            plantArrayList.get(i).setDaysSinceLastWater(plantArrayList.get(i).getDaysSinceLastWater()+Integer.parseInt(advancedayEditText.getText().toString()));
                            DatabaseManager.getInstance().updatePlant(plantArrayList.get(i));
                        }
                        finish();

                    } else {
                        Toast.makeText(FixturesActivity.this, "Il faut saisir un nombre de jours supérieur à 0.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(FixturesActivity.this, "Il faut saisir un nombre de jours à avancer.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // On supprime toutes les plantes si on appuie sur le bouton correspondant
        deleteAllPlantsButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                ArrayList<Plant> plantArrayList = DatabaseManager.getInstance().getAllPlants();
                for (int i = 0; i < plantArrayList.size(); i++) {
                    DatabaseManager.getInstance().deletePlant(plantArrayList.get(i).getId());
                }
                finish();
            }
        });

    }
}
