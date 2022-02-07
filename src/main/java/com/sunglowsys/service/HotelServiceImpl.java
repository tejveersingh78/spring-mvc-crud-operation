package com.sunglowsys.service;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel, Long id) {
        Hotel hotel1 = hotelRepository.getById(id);
       if(hotel.getCode() != null){
           hotel1.setCode(hotel.getCode());
       }
       if(hotel.getName() != null){
           hotel1.setName(hotel.getName());
        }
       if(hotel.getHotel_type() !=null){
           hotel1.setHotel_type(hotel.getHotel_type());
       }
       if(hotel.getEmail() !=null){
           hotel1.setEmail(hotel.getEmail());
       }
       if(hotel.getMobile() !=null){
           hotel1.setMobile(hotel.getMobile());
       }
       return hotelRepository.save(hotel1);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Long id) {
        Optional<Hotel> optional = hotelRepository.findById(id);
        Hotel hotel = null;
        if(optional.isPresent()){
            hotel = optional.get();
        }
        else{
            throw new RuntimeException("hotel not found for id : " + id);
        }
        return hotel;
    }

    @Override
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
}
