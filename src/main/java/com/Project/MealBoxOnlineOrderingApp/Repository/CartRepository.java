package com.Project.MealBoxOnlineOrderingApp.Repository;

import com.Project.MealBoxOnlineOrderingApp.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    public List<Cart> findByUserUsername(String username);

}
