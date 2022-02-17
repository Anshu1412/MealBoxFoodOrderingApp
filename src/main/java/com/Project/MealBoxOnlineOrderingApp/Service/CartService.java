package com.Project.MealBoxOnlineOrderingApp.Service;


import com.Project.MealBoxOnlineOrderingApp.Entity.Cart;
import com.Project.MealBoxOnlineOrderingApp.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> myCart(String username){
        return cartRepository.findByUserUsername(username);
    }

    public void remove(Long id) {
        cartRepository.deleteById(id);
    }
}

