package com.example.demo.using.controller;


import com.example.demo.using.entity.College;
import com.example.demo.using.entity.User;
import com.example.demo.using.entity.UserAndC;
import com.example.demo.using.service.CollegeServiceImpl;
import com.example.demo.using.service.UserAndCServiceImpl;
import com.example.demo.using.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserAndCController {
    @Autowired
    private UserAndCServiceImpl userAndCService;

    @Autowired
    private CollegeServiceImpl collegeService;

    @Autowired
    private UserServiceImpl userService;
    //预测报考人数增加（UserAndC表增加信息,College表中大学的eeNumber的人数加一）
    //设定本学校今年招生人数
    //查看报考难度
    //查看某学生报考院校有哪些

    //将大学加入模拟报考院校列表
    @RequestMapping(value="add_admin_college",method = RequestMethod.POST)
    @ResponseBody
    public String addAdminCollege(int uid,int cid){
        int count=userAndCService.insertUandC(new UserAndC(uid,cid));

        College college=collegeService.findByCollege(cid);
        if (college.getEeNumber()>=college.getEeNumberMax()){
            college.setDifficulty(false);
        }else {
            college.setEeNumber(college.getEeNumber() + 1);
        }
        int count1=collegeService.updateCollege(college);
        if (count1==0){
            return "信息同步失败";
        }

        User user=userService.findById(uid);
        if (user.getAdmin_college()>=9){
            return "用户目标大学已满";
        }else {
            user.setAdmin_college(user.getAdmin_college()+1);
        }
        int count2=userService.updateUser(user);
        if (count2==0){
            return "信息同步失败";
        }

        if (count != 0) {
            return "添加成功";
        }
        return "不能添加该信息";
    }

}
