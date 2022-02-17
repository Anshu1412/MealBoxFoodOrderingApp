package com.Project.MealBoxOnlineOrderingApp.Service;

import com.Project.MealBoxOnlineOrderingApp.Entity.Hotel;
import com.Project.MealBoxOnlineOrderingApp.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> hotelList() {
        return hotelRepository.findAll();
    }
    public void addHotel(Hotel hotel){
        hotelRepository.save(hotel);
    }
    public Hotel getByHotelId(Long id){
        return hotelRepository.getById(id);
    }

    public void removeHotelById(Long id) {
        hotelRepository.deleteById(id);
    }

}
