<%@ page contentType="text/html" pageEncoding="utf-8" import="java.util.*"%>
<html>
    <head>
        <title>MyFirstJavaWebMVC</title>
        <%
            request.setCharacterEncoding("utf-8");
        %>
        <%
            List<String> info = (ArrayList<String>)request.getAttribute("info");
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
        %>
        <script>
            window.onload = function(){
                var objForm = document.getElementById("form1");

                objForm.onsubmit = function(){
                    if(!(/^\w{5,15}$/.test(this.userID.value))){
                        alert("用户ID必须是5~15位！");
                        this.userID.focus();
                        return false;
                    }
                    
                    if(!(/^\w{5,15}$/.test(this.password.value))){
                        alert("密码必须是5~15位！");
                        this.password.focus();
                        return false;
                    }
                }

            }
            
        </script>
    </head>
    
    <body>
        <form id="form1" action="login" method="post">
            用户ID：<input type="text" name="userID" value="<%= (userID == null) ? "" : userID %>" /><br>
            密&nbsp;&nbsp;码：<input type="password" name="password" value="<%= (password == null) ? "" : password %>" /><br>
            <input type="submit" value="登录" />
            <input type="reset" value="重置" />
        </form>
        <%
            if(info != null){
                for(String str : info){
        %>
            <h3><%=str %></h3>
        <%
                }
            }
        %>
    </body>
</html>
