//package com.Project.MealBoxOnlineOrderingApp.Service;
//
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//@Transactional
//@Service
//public class OrderService {
//    @Autowired
//    private OrderRepository OrderRepository;
//
//    public MyOrder addToMyOrder(MyOrder myOrder) {
//        return myOrderRepository.save(myOrder);
//    }
//    public List<MyOrder> myOrders(String username){
//        return myOrderRepository.findByCustomerUsername(username);
//    }
//    public void remove(Long id) {
//        myOrderRepository.deleteById(id);
//    }
//
//
//}