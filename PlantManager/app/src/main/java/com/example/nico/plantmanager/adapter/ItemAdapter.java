package com.example.nico.plantmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.nico.plantmanager.R;
import com.example.nico.plantmanager.activity.EditPlantActivity;
import com.example.nico.plantmanager.model.Plant;



/**
 * Created by Nico on 19/11/2016.
 */

public class ItemAdapter extends ArrayAdapter<Plant> {

    public ItemAdapter(Context context, ArrayList<Plant> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Récupère l'item à un position précise
        final Plant plant = getItem(position);

        // Vérifie s'il existe une view, si oui récupère la vue de la ligne pour l'item
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        // Déclare les différents champs de la vue
        final TextView plantName = (TextView) convertView.findViewById(R.id.name);

        // Met les éléments demandés dans les champs (NB : cela doit être une string)
        plantName.setText(plant.toString());

        convertView.setBackgroundResource(plant.getResourceColor());

        // Ajouter une action quand on clique sur une ligne de la liste
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEditPlantActivity(plant.getId());
            }
        });

        // Retourne la vue de la ligne
        return convertView;
    }

    private void goToEditPlantActivity(int plantId) {
        Intent edit_plant = new Intent(this.getContext(), EditPlantActivity.class);

        // On envoie l'id de la plante sur laquelle on a cliqué
        Bundle b = new Bundle();
        b.putInt("plantId", plantId);
        edit_plant.putExtras(b);

        this.getContext().startActivity(edit_plant);
    }

}
