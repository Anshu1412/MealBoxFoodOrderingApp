package com.Project.MealBoxOnlineOrderingApp.Repository;

import com.Project.MealBoxOnlineOrderingApp.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findByHotelId(Long id);
}
