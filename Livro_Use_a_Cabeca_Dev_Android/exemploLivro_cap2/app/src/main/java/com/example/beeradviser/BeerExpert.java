package com.example.beeradviser;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

    public List<String> getBrands(String color){
        List<String> brands = new ArrayList<>();

        switch(color){
            case "light":
                brands.add("Bud Light");
                brands.add("Amstel Light");
            break;
            case "amber":
                brands.add("Study Hall");
                brands.add("90 Shilling");
            break;
            case "brown":
                brands.add("Honey Brown");
                brands.add("Trappistes Rochefort 6");
            break;
            case "dark":
                brands.add("Trappistes Rochefort 6");
                brands.add("Smoked Porter");
            break;
            default:
                brands.add("Error!!");
            break;
        }

        return brands;
    }
}
