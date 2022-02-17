package com.Project.MealBoxOnlineOrderingApp.Controller;

import com.Project.MealBoxOnlineOrderingApp.Entity.Food;
import com.Project.MealBoxOnlineOrderingApp.Global.GlobalData;
import com.Project.MealBoxOnlineOrderingApp.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class CartController {
    @Autowired
    FoodService foodService;
    //@RequestMapping("/addToCart/{id}")
//    public String addToCart(Principal principal, @PathVariable Long id, Model model)
//    {
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//        }
//        GlobalData.cart.add(foodService.getProductById(id).get());
//        model.addAttribute("cartCount",GlobalData.cart.size());
//        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Food::getPrice).sum());
//        model.addAttribute("cart",GlobalData.cart);
//        return "cart";
//    }
    @RequestMapping("/addToCart/{id}")
    public String addToCart(Principal principal, @PathVariable Long id, Model model)
    {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        GlobalData.cart.add(foodService.getProductById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Food::getPrice).sum());
        model.addAttribute("cart",GlobalData.cart);
        return "cart";
    }
    @GetMapping("/cart")
    public String cartGet(Model model,Principal principal)
    {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Food::getPrice).sum());
        model.addAttribute("cart",GlobalData.cart);
        return "cart";
    }
    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index,Principal principal,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        GlobalData.cart.remove(index);
        return "redirect:/cart";

    }
    @RequestMapping("/payments")
    public String payment(Model model,Principal principal){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Food::getPrice).sum());
        return "payments";

    }
    @PostMapping("/feedback")
    public String feedback(){
        return "feedback";
    }
}