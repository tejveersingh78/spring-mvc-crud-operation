package com.sunglowsys.resource;



import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelResource {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Hotel hotel){
        Hotel result = hotelService.createHotel(hotel);
        return ResponseEntity.ok().body("Hotel is Created Successfully : " + result);
    }

    @GetMapping
    public List<Hotel> getAll(){
        List<Hotel> result1 = hotelService.findAll();
        return result1;
    }

    @GetMapping("get/{id}")
    public Hotel getById(@PathVariable("id") Long id){
        return hotelService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Hotel hotel,@PathVariable("id") Long id){
        hotelService.update(hotel,id);
        return ResponseEntity.ok().body("Hotel is updated successfully :" + id);
    }

    @DeleteMapping("delete/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") Long id){
        hotelService.delete(id);
        return ResponseEntity.ok().body("Hotel is deteleted successfully on this id :" + id);
    }
}
