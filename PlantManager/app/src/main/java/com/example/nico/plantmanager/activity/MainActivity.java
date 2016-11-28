package com.example.nico.plantmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nico.plantmanager.R;
import com.example.nico.plantmanager.adapter.ItemAdapter;
import com.example.nico.plantmanager.database.DatabaseManager;
import com.example.nico.plantmanager.model.Plant;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;
    ListView myListView;
    TextView notice;
    ArrayList<Plant> plantsList;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation de la base de données
        DatabaseManager.init(this);

        // Récupération des élements graphiques
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        notice = (TextView)findViewById(R.id.notice);
        myListView = (ListView) findViewById(R.id.my_list_view);

        plantsList = new ArrayList<>();

        // Initialisation de notre Toolbar R.id.my_toolbar comme ActionBar pour cette activité
        setSupportActionBar(myToolbar);

        // Spécification d'un adapter
        adapter = new ItemAdapter(this, plantsList);
        myListView.setAdapter(adapter);
        myListView.setLongClickable(true);


        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View convertView, int position, long id) {

                // On remet à 0 le nombre de jours sans être arroser
                Plant plant = (Plant) myListView.getItemAtPosition(position);
                plant.setDaysSinceLastWater(0);
                DatabaseManager.getInstance().updatePlant(plant);

                Toast.makeText(MainActivity.this, plant.getName()+" vient d'être arroser !",
                        Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main", "resume");
        getDataFromDB();
    }

    // Ajout des éléments définis avec le fichier res/menu/my_toolbar.xml dans l'ActionBar de l'activité
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_toolbar, menu);
        return true;
    }

    // Configuration des actions des différents boutons de l'ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_plant:
                // Ouverture de l'écran d'ajout d'une plante
                Intent add_plant = new Intent(this, AddPlantActivity.class);
                startActivity(add_plant);
                return true;

            case R.id.action_fixtures:
                // L'utilisateur a cliqué sur le menu Fixtures
                Intent fixtures = new Intent(this, FixturesActivity.class);
                startActivity(fixtures);
                return true;

            case R.id.action_exit:
                // Fermeture de l'application
                finish();
                return true;

            default:
                // Si on arrive là, l'action de l'utilisateur n'a pas été reconnu, on invoque la superclasse pour gérer ça
                return super.onOptionsItemSelected(item);

        }
    }

    public void getDataFromDB() {
        if (plantsList != null) plantsList.clear();

        // Recupère toutes les plantes de la DB
        ArrayList<Plant> plantArrayList = DatabaseManager.getInstance().getAllPlants();

        if(plantArrayList != null) {
            for (int i = 0; i < plantArrayList.size(); i++) {
                plantsList.add(plantArrayList.get(i));
            }

            Log.d("DBCheck", "Nombre de plante(s) dans la DB = " + plantsList.size());

            if (plantsList.size() == 0) {
                // Aucune donnée dans la base
                myListView.setVisibility(View.GONE);
                notice.setText("Aucune plante trouvée.\nUtilisez le + en haut à droite pour en ajouter une.");
                notice.setVisibility(View.VISIBLE);
            } else {
                adapter.notifyDataSetChanged();
                notice.setVisibility(View.GONE);
                myListView.setVisibility(View.VISIBLE);
            }
        } else {
            notice.setText("Problème avec la base de donnée");
            notice.setVisibility(View.VISIBLE);
        }
    }

}
