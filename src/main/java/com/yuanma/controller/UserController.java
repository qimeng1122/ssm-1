package com.yuanma.controller;

import com.common.resultmodel.Result;
import com.common.resultmodel.ResultEnum;
import com.common.resultmodel.ResultUtil;
import com.yuanma.model.User;
import com.yuanma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired(required=true)
    private UserService userService;

    @GetMapping("/selectUserByName")
    @ResponseBody
    public Result selectUserByName(@PathVariable("name") String name) {
        User user = userService.selectUserByName(name);
        if (user == null) {
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(), ResultEnum.USER_NOT_EXIST.getMsg());
        }
        return ResultUtil.success();
    }

    @GetMapping("/selectAllUser")
    @ResponseBody
    public Result selectAllUser(HttpServletRequest request, HttpServletResponse response){
        List<User> list = userService.selectAll();
        System.out.println(list);
        return ResultUtil.success(list);
    }

    @PutMapping("/updateUser")
    @ResponseBody
    public Result updateUser(@RequestBody User user){
        int i = userService.updateUser(user);
        if (i == 0) {
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg() );
        }
        return ResultUtil.success();
    }

    @DeleteMapping("/deleteUserById")
    @ResponseBody
    public Result deleteUserById(String id){
        int i = userService.deleteUserById(Integer.parseInt(id));
        if (i == 0) {
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST.getCode(),ResultEnum.USER_NOT_EXIST.getMsg() );
        }
        return ResultUtil.success();
    }

    @PostMapping("/saveOrUpdateUser")
    @ResponseBody
    public Result addUser(@RequestBody User user){
        int i = userService.addUser(user);
        if (i == 0) {
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(),ResultEnum.USER_IS_EXISTS.getMsg() );
        }
        return ResultUtil.success();
    }

    @GetMapping("/selectUserById")
    @ResponseBody
    public Result selectUserById(String id) {
        return ResultUtil.success(userService.selectUserById(Integer.parseInt(id)));
    }
}
