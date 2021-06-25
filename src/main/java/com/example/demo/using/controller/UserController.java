package com.example.demo.using.controller;


import com.example.demo.using.entity.User;
import com.example.demo.using.service.UserServiceImpl;
import com.example.demo.using.support.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value="logon",method = RequestMethod.POST)
    @ResponseBody
    public String logon(@RequestBody User user){
        int count = userService.insertUser(user);
        if (count != 0) {
            return "添加成功";
        }
        return "不能添加该用户";

    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password){
        User user=userService.findUserByNameAndPassword(username, DigestUtils.md5DigestAsHex(password.getBytes()));
        if (user==null||user.getName()==null){
            return "用户不存在或用户名、密码错误";
        }
        String sign = JWTUtil.sign(user, 60L * 1000L * 30L);
        return "hello" + user.getName() + "token:" + sign;
    }

    @RequestMapping(value = "find_name", method = RequestMethod.GET)
    @ResponseBody
    public String registry(@RequestParam String username) {
        User userByName = userService.findUserByName(username);
        if (userByName != null) {
            return userByName.getName();
        }
        return "未找到该用户";
    }


    @RequestMapping(value = "find_id", method = RequestMethod.GET)
    @ResponseBody
    public String findById(@RequestParam int id) {
        User userById = userService.findById(id);
        if (userById != null) {
            return userById.getName();
        }
        return "未找到该用户";
    }


    @RequestMapping(value = "update_name", method = RequestMethod.POST)
    @ResponseBody
    public String updateName(@RequestBody User user) {
        int count = userService.updateUserName(user);
        if (count != 0) {
            return "更新成功";
        }
        return "未找到该用户";
    }
}
