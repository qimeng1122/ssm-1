package com.yuanma.service;

import com.yuanma.model.Advert;

import java.util.List;

public interface AdvertService {
    List<Advert> selectAll();

    Advert selectAdvertById(int id);

    int saveOrUpdateAdvert(Advert advert);

    int deleteAdvertById(int id);
}
