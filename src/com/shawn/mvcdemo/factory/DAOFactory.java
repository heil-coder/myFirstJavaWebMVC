package com.shawn.mvcdemo.factory;

import com.shawn.mvcdemo.dao.*;
import com.shawn.mvcdemo.dao.proxy.*;

public class DAOFactory{
    public static IUserDAO getIUserDAOInstance(){
        return new UserDAOProxy();
    }
}
