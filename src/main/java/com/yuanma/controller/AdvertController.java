package com.yuanma.controller;

import com.common.resultmodel.Result;
import com.common.resultmodel.ResultUtil;
import com.yuanma.model.Advert;
import com.yuanma.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/advert")
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @GetMapping("/selectAll")
    @ResponseBody
    public Result selectAll() {
        return ResultUtil.success(advertService.selectAll());
    }

    @GetMapping("/selectAdvertById")
    @ResponseBody
    public Result selectAdvertById(String id) {
        return ResultUtil.success(advertService.selectAdvertById(Integer.parseInt(id)));
    }

    @DeleteMapping("/saveOrUpdateAdvert")
    @ResponseBody
    public Result saveOrUpdateAdvert(@RequestBody Advert Advert) {
        return ResultUtil.success(advertService.saveOrUpdateAdvert(Advert));
    }

    @RequestMapping("/deleteAdvertById")
    @ResponseBody
    public Result deleteAdvertById(String id) {
        return ResultUtil.success(advertService.deleteAdvertById(Integer.parseInt(id)));
    }
}
