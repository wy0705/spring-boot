package com.example.demo.using.controller;


import com.example.demo.using.entity.College;
import com.example.demo.using.service.CollegeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CollegeController {
    @Autowired
    private CollegeServiceImpl collegeService;
    //insert学校
    @RequestMapping(value = "insert_college",method = RequestMethod.POST)
    @ResponseBody
    public String insertcollege(@RequestBody College college){
        int count=collegeService.insertCollege(college);
        if (count!=0){
            return "添加成功";
        }
        return "未添加成功";
    }

    //查看大学信息
    @RequestMapping(value = "find_name", method = RequestMethod.GET)
    @ResponseBody
    public String registry(@RequestParam String collegename) {
        College college = collegeService.findByName(collegename);
        if (college != null) {
            return college.getName();
        }
        return "未找到该用户";
    }
    //update学校信息
    //计算某学校今年的分数线

}
