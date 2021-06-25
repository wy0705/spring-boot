package com.example.demo.using.entity;

public class UserAndC {
    private int id;
    private int uid;
    private int admin_cid;

    public UserAndC(int uid, int admin_cid) {
        this.uid = uid;
        this.admin_cid = admin_cid;
    }

    public UserAndC() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAdmin_cid() {
        return admin_cid;
    }

    public void setAdmin_cid(int admin_cid) {
        this.admin_cid = admin_cid;
    }
}
