package com.Project.MealBoxOnlineOrderingApp.Global;


import com.Project.MealBoxOnlineOrderingApp.Entity.Food;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Food> cart;
    static {
        cart = new ArrayList<Food>();

    }
}