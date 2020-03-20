package com.yuanma.service.serviceimpl;

import com.common.util.DateUtil;
import com.yuanma.mapper.UserMapper;
import com.yuanma.model.User;
import com.yuanma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        try {
            int age = DateUtil.getAge(user.getEntrytime());
            user.setWorktime(age + "年");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user.getId()!= -1) {
            return userMapper.updateByPrimaryKeySelective(user);
        } else {
            user.setId(null);
            return userMapper.insertSelective(user);
        }

    }

    @Override
    public User selectUserById(int parseInt) {
        return userMapper.selectByPrimaryKey(parseInt);
    }
}
