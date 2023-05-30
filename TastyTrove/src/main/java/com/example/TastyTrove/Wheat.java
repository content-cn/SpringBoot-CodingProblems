package com.example.TastyTrove;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Wheat implements Ingredients {
    private boolean isChinese = false;
    private boolean isNorthIndian = false;
    private boolean isSouthIndian = false;

    private List<String> chineseWheatRecipe = new ArrayList<>();
    private List<String> northIndianWheatRecipe = new ArrayList<>();
    private List<String> southIndianWheatRecipe = new ArrayList<>();

    @PostConstruct
    public void createIngredients() {
        Collections.addAll(chineseWheatRecipe, "Wheat", "Water", "Sugar", "Yeast", "salt");
        Collections.addAll(northIndianWheatRecipe, "Onions", "Green Chillies", "Water", "Chana Dal");
        Collections.addAll(southIndianWheatRecipe, "Wheat", "Moong Dal", "Water", "salt");
    }

    @Override
    public void setIngredient(String ingredient) {
        if(ingredient.equals("Chinese")) this.isChinese = true;
        if(ingredient.equals("NorthIndian")) this.isNorthIndian = true;
        if(ingredient.equals("SouthIndian")) this.isSouthIndian = true;
    }

    @Override
    public String getDishDetail() {
        if(isNorthIndian) return "Upma";
        else if(isSouthIndian) return "Pongal";
        else return "Wheat Buns";
    }
    @Override
    public List<String> getIngredientsDetail(){
        if(isNorthIndian) return northIndianWheatRecipe;
        else if(isSouthIndian) return southIndianWheatRecipe;
        else return chineseWheatRecipe;
    }

}
