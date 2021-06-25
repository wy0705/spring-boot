package com.example.demo.using.service;


import com.example.demo.using.dao.UserDao;
import com.example.demo.using.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public User findUserByName(String username){
        return userDao.findByNname(username);
    }

    public User findUserByNameAndPassword(String username,String password){
        return userDao.findByNameAndPassword(username,password);
    }

    public boolean register(User user){
        //用户重名校验
        User userByName=findUserByName(user.getName());
        if (userByName!=null&&userByName.getName()!=null&&userByName.getName().equals(user.getName())){
            return true;
        }
        //对用户密码进行MD5，目的是，数据库中的敏感数据，不要存储明文。
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userDao.insertUser(user) != 0;
    }
    @Cacheable(cacheNames = "user", key = "#id")
    public User findById(int id) {
        return userDao.findByUser(id);
    }

    //CachePut会无条件的将方法的返回值写入指定的key中
//    @CachePut(cacheNames = "user", key = "#user.id")
    //CacheEvict按指定的key,清除缓存
    @CacheEvict(cacheNames = "user", key = "#user.id")
    public int updateUserName(User user) {
        return userDao.updateUser(user);
    }

    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    public int updateUser(User user){
        return userDao.updateUser(user);
    }



}
