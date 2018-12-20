package com.shawn.mvcdemo.dao.impl;

import java.sql.*;

import com.shawn.mvcdemo.vo.User;
import com.shawn.mvcdemo.dbc.*;
import com.shawn.mvcdemo.dao.*;

public class UserDAOImpl implements IUserDAO{
    private Connection conn = null;

    private PreparedStatement pstmt = null;

    public UserDAOImpl(Connection conn){
        this.conn = conn;
    }

    public boolean findLogin(User user) throws Exception{
        boolean flag = false;
        String sql = "select name from user where userid = ? and password = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,user.getUserID());
        this.pstmt.setString(2,user.getPassword());
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            user.setName(rs.getString("name"));
            flag = true;
        }
        this.pstmt.close();
        return flag;
    }
}
