//package com.Project.MealBoxOnlineOrderingApp.Controller;
//
//import com.Project.MealBoxOnlineOrderingApp.Entity.Food;
//import com.Project.MealBoxOnlineOrderingApp.Entity.User;
//import com.Project.MealBoxOnlineOrderingApp.Service.FoodService;
//
//import com.Project.MealBoxOnlineOrderingApp.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import javax.servlet.http.HttpServletRequest;
//import java.security.Principal;
//
//@Controller
//public class OrderController{
//    @Autowired
//    private OrderService myOrderService;
//    @Autowired
//    private FoodService foodService;
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/buy/{id}")
//    public String buy(Principal principal,Model model, @PathVariable Long id){
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//        }
//        model.addAttribute("dress",foodService.getById(id));
//        model.addAttribute("customer",userService.findUserByUserName(principal.getName()));
//        return "pay";
//    }
//    @GetMapping("/pay/{id}")
//    public String pay(Principal principal, @PathVariable Long id, Model model, HttpServletRequest request) {
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//
//        }
//        Food food = foodService.getById(id);
//        User customer = userService.findUserByUserName(principal.getName());
//        model.addAttribute("Menu", food);
//        String deliveringAddress = request.getParameter("address");
//
//        myOrder.setUser(user);
//        myOrderService.addToMyOrder(myOrder);
//        return "redirect:/successfullyBooked";
//    }
//    @GetMapping("/successfullyBooked")
//    public String booked(Principal principal, Model model){
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//        }
//        User user = userService.findUserByUserName(principal.getName());
//        model.addAttribute("name", user.getName());
//        return "booked";
//    }
//    @GetMapping("/myOrder")
//    public String myOrder(Principal principal, Model model){
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//        }
//        model.addAttribute("orders",myOrderService.myOrders(principal.getName()));
//        return "myOrder";
//    }
//
//    @GetMapping("/order/{id}")
//    public String cancelOrder(@PathVariable Long id,Model model, Principal principal){
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//        }
//        myOrderService.remove(id);
//        return "redirect:/myOrder";
//    }
//
//}