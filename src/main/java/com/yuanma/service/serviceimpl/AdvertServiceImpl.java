package com.yuanma.service.serviceimpl;

import com.yuanma.mapper.AdvertMapper;
import com.yuanma.model.Advert;
import com.yuanma.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertMapper advertMapper;

    @Override
    public List<Advert> selectAll() {
        return advertMapper.selectAll();
    }

    @Override
    public Advert selectAdvertById(int id) {
        return advertMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveOrUpdateAdvert(Advert advert) {
        if (advert.getId()!=-1) {
            return advertMapper.updateByPrimaryKeySelective(advert);
        }else {
            advert.setId(null);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            try {
                Date parse = simpleDateFormat.parse(format);
                advert.setCreatetime(parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return advertMapper.insertSelective(advert);
        }
    }

    @Override
    public int deleteAdvertById(int id) {
        return advertMapper.deleteByPrimaryKey(id);
    }
}
