package com.shawn.mvcdemo.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.shawn.mvcdemo.factory.*;
import com.shawn.mvcdemo.vo.*;

public class LoginServlet extends HttpServlet{

    public void doGet(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        String path = "login.jsp";
        String userID = req.getParameter("userID");
        String password = req.getParameter("password");
        List<String> info = new ArrayList<String>();//收集错误信息
        if(userID == null || "".equals(userID)){
            info.add("用户id不能为空！");
        }
        if(password == null || "".equals(password)){
            info.add("密码不能为空！");
        }
        if(info.size() == 0){//里面没有记录任何的错误
            User user = new User();
            user.setUserID(userID);
            user.setPassword(password);
            try{
                if(new DAOFactory().getIUserDAOInstance().findLogin(user)){
                    info.add("用户登陆成功，欢迎" + user.getName() + "光临！");
                    System.out.println(1);
                } else {
                    info.add("用户登录失败，错误的用户名和密码！");
                    System.out.println(2);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        req.setAttribute("info",info);
        req.getRequestDispatcher(path).forward(req,resp);
    }

    public void doPost(HttpServletRequest req,HttpServletResponse resp)
        throws ServletException,IOException{
        this.doGet(req,resp);
    }

}
