package com.yuanma.mapper;

import com.yuanma.model.Advert;

import java.util.List;

public interface AdvertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advert record);

    int insertSelective(Advert record);

    Advert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advert record);

    int updateByPrimaryKey(Advert record);

    List<Advert> selectAll();
}