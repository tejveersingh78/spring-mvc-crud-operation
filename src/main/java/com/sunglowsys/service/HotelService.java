package com.sunglowsys.service;

import com.sunglowsys.domain.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    Hotel update(Hotel hotel, Long id);

    List<Hotel> findAll();

    Hotel findById(Long id);

    void delete(Long id);

}
