package com.Project.MealBoxOnlineOrderingApp.Service;

import com.Project.MealBoxOnlineOrderingApp.Entity.Food;

import com.Project.MealBoxOnlineOrderingApp.Repository.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public void addMenu(Food menu) {
        foodRepository.save(menu);
    }

    public List<Food> foodList(Long id) {
        return foodRepository.findByHotelId(id);
    }

    public Food getById(Long id) {
        return foodRepository.getById(id);
    }

    public Optional<Food> getProductById(long id) {
        return foodRepository.findById(id);
    }

    public void removeHotelById(Long id) {
        foodRepository.deleteById(id);
    }

}
