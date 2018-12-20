package com.shawn.mvcdemo.dao.proxy;

import java.sql.*;

import com.shawn.mvcdemo.vo.User;
import com.shawn.mvcdemo.dbc.*;
import com.shawn.mvcdemo.dao.*;
import com.shawn.mvcdemo.dao.impl.*;

public class UserDAOProxy implements IUserDAO{
    private DatabaseConnection dbc = null;
    private IUserDAO dao = null;

    public UserDAOProxy(){
        try{
            this.dbc = new DatabaseConnection();
        } catch(Exception e){
            e.printStackTrace();
        }
        this.dao = new UserDAOImpl(this.dbc.getConnection());
    }

    public boolean findLogin(User user) throws Exception{
        boolean flag = false;
        try{
            flag = this.dao.findLogin(user);    //调用真实主题，完成操作
        } catch(Exception e){
            throw e;
        } finally{
            this.dbc.close();
        }
        return flag;
    }


}
