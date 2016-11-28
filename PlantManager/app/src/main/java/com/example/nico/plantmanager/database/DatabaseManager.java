package com.example.nico.plantmanager.database;


import android.content.Context;

import com.example.nico.plantmanager.model.Plant;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseManager {

    private static DatabaseManager instance;
    private DatabaseHelper helper;

    public static void init(Context ctx) {
        if (null == instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    public DatabaseHelper getHelper() {
        return helper;
    }

    /**
     * Get all customer in db
     *
     * @return
     */
    public ArrayList<Plant> getAllPlants() {
        ArrayList<Plant> plants = null;
        try {
            plants = (ArrayList<Plant>) getHelper().getPlantsDAO().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plants;
    }

    public void addPlant(Plant plant) {
        try {
            getHelper().getPlantsDAO().create(plant);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refreshPlant(Plant plant) {
        try {
            getHelper().getPlantsDAO().refresh(plant);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePlant(Plant wishList) {
        try {
            getHelper().getPlantsDAO().update(wishList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlant (int plantId) {
        try {
            DeleteBuilder<Plant, Integer> deleteBuilder = getHelper().getPlantsDAO().deleteBuilder();
            deleteBuilder.where().eq("id", plantId);
            deleteBuilder.delete();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}