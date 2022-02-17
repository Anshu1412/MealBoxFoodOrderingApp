package com.Project.MealBoxOnlineOrderingApp.Controller;



import com.Project.MealBoxOnlineOrderingApp.Entity.User;
import com.Project.MealBoxOnlineOrderingApp.Service.FoodService;
import com.Project.MealBoxOnlineOrderingApp.Service.HotelService;
import com.Project.MealBoxOnlineOrderingApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private FoodService foodService;

    //Home
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    //admin
    @RequestMapping("/adminHome")
    public String admin(){
        return "adminHome";
    }

    //Registration- after registering user will go to login page
    @GetMapping("/register")
    public String registrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registration(HttpServletRequest request) {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String phoneNumber=request.getParameter("phoneNumber");
        User user;
        if(username.equals("admin")){
            user = new User(username, name, address, password,phoneNumber,"ROLE_ADMIN");
        }
        else {
            user = new User(username, name, address, password,phoneNumber,"ROLE_USER");
        }

        userService.createUser(user);
        return "login";
    }



//@PostMapping("/register")
//public String registration(HttpServletRequest request, Model model) {
//    String username = request.getParameter("username");
//    String name = request.getParameter("name");
//    String address = request.getParameter("address");
//    String password = request.getParameter("password");
//    String phoneNumber=request.getParameter("phoneNumber");
//    User user;
//    if(username.equals("admin")){
//        user = new User(username, name, address, password,phoneNumber,"ROLE_ADMIN");
//    }
//    else {
//        user = new User(username, name, address, password,phoneNumber,"ROLE_USER");
//    }
//    if(!userService.existsById(username)){
//        userService.createUser(user);
//    }
//    else
//    {
//        model.addAttribute("error","This username exists, Please try another username!!!");
//        return "register";
//    }
//    model.addAttribute("message", "Registration Successfull!!!!!!");
//    return "login";
//}

    //Login - after login user will go to the list of hotels page
    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/hotels")
    public String hotels(Model model){
        model.addAttribute("hotels",hotelService.hotelList());
        return "hotels";
    }

    @GetMapping("/success")
    public String login(Principal principal) {
        String username = principal.getName();
        if (username.equals("admin")){
            return "redirect:/viewHotels";
        }
        return "redirect:/hotels";
    }
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        Customer customer;
//        if (customerService.existsById(userName)) {
//            customer = customerService.findCustomerByUserName(userName);
//            if (password.equals(customer.getPassword())) {
//                model.addAttribute("userName", userName);
//                model.addAttribute("hotels", hotelService.hotelList() );
//            } else {
//                model.addAttribute("message", "Wrong Password");
//                return "login";
//                //return "redirect:/login";
//            }
//        } else {
//            model.addAttribute("message", "Please enter valid User Name");
//            return "login";
//            //return "redirect:/login";
//        }
//        return "hotels";
//
//    @RequestMapping("/updateUserProfile")
//    public String updateUserDetails(Principal principal, Model model){
//        if (principal != null) {
//            String username = principal.getName();
//            model.addAttribute("username", username);
//        }
//        model.addAttribute("user",userService.findById(principal.getName()));
//        return "updateUserProfile";
//    }

//



    @RequestMapping("/updateProfile")
    public String updateProfile(Principal principal,Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("userName", username);
        }
        model.addAttribute("user", userService.findUserByUsername(principal.getName()));
        return "updateProfile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(Principal principal, HttpServletRequest req, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        User user= userService.findUserByUsername(principal.getName());
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        String password=req.getParameter("password");
        String phoneNumber=req.getParameter("phoneNumber");

        user.setName(name);
        user.setAddress(address);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        userService.createUser(user);
        model.addAttribute("user", userService.findUserByUsername(principal.getName()));
        model.addAttribute("message","Updated Successfully");
        return "updateProfile";
    }

    @RequestMapping("/menu/{id}")
    public String viewMenu(Principal principal, @PathVariable Long id, HttpServletRequest request, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("menu",id);
        model.addAttribute("usermenu", foodService.foodList(id));
        return "menu";
    }
}