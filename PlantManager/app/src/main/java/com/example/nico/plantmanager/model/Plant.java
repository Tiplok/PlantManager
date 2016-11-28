package com.example.nico.plantmanager.model;

import com.example.nico.plantmanager.R;
import com.j256.ormlite.field.DatabaseField;

public class Plant {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "daysBetweenWater")
    private int daysBetweenWater;

    @DatabaseField(columnName = "currentDay")
    private int daysSinceLastWater;

    public String getName() {
        return name;
    }

    public int getDaysBetweenWater() {
        return daysBetweenWater;
    }

    public int getDaysSinceLastWater() {
        return daysSinceLastWater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDaysBetweenWater(int daysBetweenWater) {
        this.daysBetweenWater = daysBetweenWater;
    }

    public void setDaysSinceLastWater(int daysSinceLastWater) {
        this.daysSinceLastWater = daysSinceLastWater;
    }

    public int getResourceColor(){
        if(this.getDaysSinceLastWater() == this.getDaysBetweenWater() || this.getDaysSinceLastWater() == this.getDaysBetweenWater()-1) {
            return R.drawable.shape_orange;
        } else if(this.getDaysSinceLastWater() > this.getDaysBetweenWater()){
            return R.drawable.shape_red;
        }
        return R.drawable.shape_green;
    }

    public String toString(){
        int daysBeforeWater;

        daysBeforeWater = this.getDaysBetweenWater()-this.getDaysSinceLastWater();

        // Si on voudrait faire sans nombre négatif qui indique le retard de l'arrosage
        /*if(this.getDaysBetweenWater()-this.getCurrentDay() < 0){
            daysBeforeWater = 0;
        } else {
            daysBeforeWater = this.getDaysBetweenWater()-this.getCurrentDay();
        }*/

        return this.name+" ("+daysBeforeWater+")";
    }
}
