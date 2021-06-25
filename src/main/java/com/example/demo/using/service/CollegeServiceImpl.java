package com.example.demo.using.service;


import com.example.demo.using.dao.CollegeDao;
import com.example.demo.using.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class CollegeServiceImpl {
    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public College findByCollege(int cid){
        return collegeDao.findByCollege(cid);
    }

    public List<Integer> findByAddress(String address){
        return collegeDao.findByAddress(address);
    }

    public List<Integer> findByType(String type){
        return collegeDao.findByType(type);
    }

    public List<Integer> findByFeature(String feature){
        return collegeDao.findByFeature(feature);
    }

    public College findByName(String name){
        return collegeDao.findByName(name);
    }

    public int insertCollege(College college){
        return collegeDao.insertCollege(college);
    }

    public int updateCollege(College college){
        return collegeDao.updateCollege(college);
    }
}
