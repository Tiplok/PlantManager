package com.example.nico.plantmanager.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

import java.util.ArrayList;

public class EditPlantActivity extends AppCompatActivity {
    Plant plant;
    int plantId;
    EditText plantnameEditText;
    EditText plantwaterdayEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plant);

        // On recupère l'id de la plante sur laquelle on a cliqué
        Bundle b = getIntent().getExtras();
        plantId = -1;
        if(b != null)
            plantId = b.getInt("plantId");

        // On recupère la plante selon l'id
        ArrayList<Plant> plantArrayList = DatabaseManager.getInstance().getAllPlants();
        for (int i = 0; i < plantArrayList.size(); i++) {
            if(plantArrayList.get(i).getId() == plantId){
                plant = plantArrayList.get(i);
            }
        }

        // Initialisation de la base de données
        DatabaseManager.init(this);

        // Récupération des élements graphiques
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        Button cancelButton = (Button) findViewById(R.id.button_cancel);
        Button modifButton = (Button) findViewById(R.id.button_modifiate);
        Button deleteButton = (Button) findViewById(R.id.button_delete);
        plantnameEditText = (EditText) findViewById(R.id.editText_plantname);
        plantwaterdayEditText = (EditText) findViewById(R.id.editText_plantwaterday);

        // Initialise notre Toolbar R.id.my_toolbar comme ActionBar pour cette activité
        setSupportActionBar(myToolbar);

        // On affiche les infos de la plante
        plantnameEditText.setText(plant.getName());
        plantwaterdayEditText.setText(String.valueOf(plant.getDaysBetweenWater()));

        // On ferme l'activité si on appuie sur le bouton ANNULER
        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        // Si on appuie sur le bouton MODIFIER
        modifButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                // On vérifie les informations modifiées
                if(!plantnameEditText.getText().toString().matches("")){
                    if(!plantwaterdayEditText.getText().toString().matches("") && Integer.parseInt(plantwaterdayEditText.getText().toString()) > 1){

                        // Si c'est bon, on modifie la plante en question
                        plant.setName(plantnameEditText.getText().toString());
                        plant.setDaysBetweenWater(Integer.parseInt(plantwaterdayEditText.getText().toString()));
                        DatabaseManager.getInstance().updatePlant(plant);
                        finish();

                    } else {
                        Toast.makeText(EditPlantActivity.this, "Il faut saisir un nombre de jours supérieur à 1.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditPlantActivity.this, "Il faut saisir un nom de plante.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Si on appuie sur le bouton "SUPPRIMER"
        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                // On génère une alerte pour demander une confirmation de suppression
                new AlertDialog.Builder(EditPlantActivity.this)
                        .setTitle("Suppression")
                        .setMessage("Êtes-vous sûr de vouloir supprimer cette plante ?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                // On supprime la plante si on clique sur OK
                                DatabaseManager.getInstance().deletePlant(plantId);
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // On ne fait rien si on clique sur ANNULER
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

    }
}
