package com.Project.MealBoxOnlineOrderingApp.Repository;

import com.Project.MealBoxOnlineOrderingApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
