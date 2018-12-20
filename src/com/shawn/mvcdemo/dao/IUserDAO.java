package com.shawn.mvcdemo.dao;

import com.shawn.mvcdemo.vo.User;

public interface IUserDAO{
    //现在完成的是登录验证，那么登录操作只有两种返回结果
    public boolean findLogin(User user) throws Exception;
}
