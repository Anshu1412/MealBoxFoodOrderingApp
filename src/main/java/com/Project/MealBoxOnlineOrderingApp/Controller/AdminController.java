package com.Project.MealBoxOnlineOrderingApp.Controller;


import com.Project.MealBoxOnlineOrderingApp.Entity.Food;
import com.Project.MealBoxOnlineOrderingApp.Entity.Hotel;
import com.Project.MealBoxOnlineOrderingApp.Service.FoodService;
import com.Project.MealBoxOnlineOrderingApp.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class AdminController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private FoodService foodService;


//    @PostMapping("/adminHome")
//    public String adminLogin(HttpServletRequest request, Model model) {
//        String adminUserName = request.getParameter("adminuserName");
//        String adminPassword = request.getParameter("adminpassword");
//        if (adminUserName.equals("admin@123") && adminPassword.equals("admin")) {
//            return "adminHome";
//        } else {
//            model.addAttribute("message", "Invalid Credentials");
//            return "admin";
//        }
//
//    }

    @RequestMapping("/viewHotels")
    public String viewHotels(Principal principal,HttpServletRequest request, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("viewHotels", hotelService.hotelList());
        return "viewHotels";
    }

    @RequestMapping("/viewHotels/add")
    public String addhotels(Principal principal,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("hotel",new Hotel());
        return "addHotel";
    }

    @PostMapping("viewHotels/add")
    public String addhotel(Principal principal,@ModelAttribute("hotel") Hotel hotel,Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        hotelService.addHotel(hotel);
        return "redirect:/viewHotels";
    }

    @GetMapping("/viewHotels/delete/{id}")
    public String deleteHotel(Principal principal,Model model,@PathVariable Long id){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        hotelService.removeHotelById(id);
        return "redirect:/viewHotels";
    }

//    @RequestMapping("/updateMenu/{id}")
//    public String updateMenu(Principal principal,@PathVariable String id, Model model){
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//        }
//        model.addAttribute("food",id);
//        model.addAttribute("menu",new Food());
//        return "updateMenu";
//    }
//    @PostMapping("/updateMenu/{id}")
//    public String updateMenu(Principal principal,Model model,@ModelAttribute("menu") Food menu){
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//        }
//        foodService.addMenu(menu);
//        return "redirect:/viewHotels";
//    }



    @RequestMapping("/updateMenu/{id}")
    public String updateMenu(Principal principal,@PathVariable String id, Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("food",id);
        model.addAttribute("menu",new Food());
        return "updateMenu";
    }
    @PostMapping("/updateMenu/{id}")
    public String updateMenu(Principal principal,Model model,@ModelAttribute("menu") Food menu){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        foodService.addMenu(menu);
        return "redirect:/viewHotels";
    }
    @RequestMapping("/viewMenu/{id}")
    public String viewMenu(Principal principal,@PathVariable Long id, HttpServletRequest request, Model model) {
        if (principal != null) {
            String username = principal.getName();

            model.addAttribute("username", username);
        }
//      model.addAttribute("hotelName",hotelService.getByHotelId(String name =principle.getNAme()));
    model.addAttribute("menu",id);
        model.addAttribute("adminMenu", foodService.foodList(id));
        return "viewMenu";
    }
    @GetMapping("/viewMenu/delete/{id}")
    public String deleteMenu(Principal principal,Model model,@PathVariable Long id){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        foodService.removeHotelById(id);
        return "redirect:/viewMenu";
    }
}


