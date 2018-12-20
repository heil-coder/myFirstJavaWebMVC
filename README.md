# myFirstJavaWebMVC
# JSP + JavaBean + Servlet实现MVC设计模式

# 参考
[JSP + JavaBean + Servlet实现MVC设计模式](https://www.cnblogs.com/ShawnYang/p/7443528.html "JSP + JavaBean + Servlet实现MVC设计模式")
[Java Web 项目目录规范](https://www.cnblogs.com/scown/p/5561677.html)

[JavaWeb工程 目录结构](http://www.cnblogs.com/zhanghengscnc/p/8449894.html)

[最全的 eclipse web 项目目录结构](https://www.jianshu.com/p/91050dfcbe33)

# 流程图
![流程图](https://github.com/heil-coder/myFirstJavaWebMVC/blob/master/flowChart.jpg?raw=true)


# 目录结构
~~~
项目目录
├─src                                           java源代码
│  ├─com                                        package路径
│  │  ├─shawn                                   应该使用原作者的名字命名的路径
│  │  │  ├─mvcdemo                              mvc+demo命名
│  │  │  │  ├─dao                               Data Access Object（数据访问对象）
│  │  │  │  │  ├─impl                           impl 
│  │  │  │  │  │   └─UserDAOImpl.java
│  │  │  │  │  ├─proxy                          代理
│  │  │  │  │  │   └─UserDaoProxy.java          
│  │  │  │  │  └─IUserDAO.java
│  │  │  │  ├─dbc                               Database connection（数据库连接）
│  │  │  │  │  └─DatabaseConnection.java
│  │  │  │  ├─factory                           工厂类
│  │  │  │  │  └─DAOFactory.java
│  │  │  │  ├─servlet                           servlet
│  │  │  │  │  └─LoginServlet.java
│  │  │  │  ├─vo                                vo	
│  │  │  │  │  └─User.java
│  │  │  │  └─ ...                              更多类库目录
│  │  │  └─ ...                                 更多类库目录
│  │  └─ ...                                    更多类库目录
│  └─ ...                                       更多类库目录
├─build                eclipse默认类编译目录
├─WebContent           项目访问默认路径
│  ├─common            用来存放公用的 JSP，JS，CSS，图片等文件。
│  ├─META-INF          存放一些 meta information 相关的文件的这么一个文件夹
│  ├─WEB-INF           Web 容器要求在你的应用程序中必须有 WEB-INF 目录
│  │  ├─classes        编译后的 Java类
│  │  └─lib            项目运行需要使用的jar包的集合
│  └─web.xml           应用程序配置
├─login.jsp            登录页面
├─README.md            README 文件
└─ ...                 更多
~~~

# 主要目录、文件功能说明
|NO|名称|类型|描述|
|---|---|---|---|
|1|/src|目录|java源代码|
|2|/build|目录|eclipse新建的 Dynamic web project 默认是将类编译在 build 文件夹下。可以在本地的项目名\build\classes 下查看|
|3|/WebContent|目录|项目访问默认路径，也就是工程的发布文件夹，发布时把该文件夹发布到tomcat的webapps里。Eclipse创建Web Project时生成此目录，MyEclipse创建Web Project则为WebRoot。|
|4|/WebContent/META-INF|目录|存放一些 meta information 相关的文件的这么一个文件夹, 一般来说尽量不要自己手工放置文件到这个文件夹。|
|5|/WebContent/WEB-INF|目录|一个专用区域， 容器不能把此目录中的内容提供给用户。这个目录下的文件只供容器使用，里面包含不应该由客户直接下载的资源。Web 容器要求在你的应用程序中必须有 WEB-INF 目录。WEB-INF 中包含着发布描述符（也就是 web.xml 文件）, 一个 classes 目录和一个 lib目录, 以及其它内容。注意： 如果你的 Web 应用程序中没有包含这个目录, 它可能将无法工作 。|
|6|/WebContent/WEB-INF/classes|目录|编译后的 Java类,这个文件夹是可选的。有一些配置文件需要放到 WEB-INF 的 classes 文件夹下，所以，通常的做法是手动在工程的 WEB-INF 文件夹下建立 classes 文件夹。如果不在工程的 WEB-INF 下手动建立 classes，发布到 tomcat 时 tomcat 里的WEB-INF 中也会有 classes 文件夹。|
|7|/WebContent/WEB-INF/lib|目录|该目录中的 jar 包是运行时环境下使用的 jar 包, 所谓运行时环境下使用的 jar 包,就是说你在运行你的项目的时候所需要使用的 jar 包的集合。|
|8|/WebContent/WEB-INF/web.xml|xml|发布描述符(deployment descriptors)是 J2EE Web 应用程序不可分割的一部分(也就是说是它的最小部分, 必不可缺的一部分)。它们在应用程序发布之后帮助管理 Web 应用程序的配置。|


# 代码清单

|NO|页面名称|文件类型|描述|
|---|---|---|---|
|1|User|JavaBean|用户登陆的VO操作类|
|2|DatabaseConnection|JavaBean|负责数据库的连接和关闭操作|
|3|IUserDAO|JavaBean|定义登录操作的DAO接口|
|4|UserDAOImpl|JavaBean|DAO接口的真实实现类，完成具体的登录验证|
|5|UserDaoProxy|JavaBean|定义代理操作，负责数据库的打开和关闭并且调用真实主题|
|6|DAOFactory|JavaBean|工厂类，取得DAO接口的实例|
|7|LoginServlet|Servlet|接收请求参数，进行参数验证，调用DAO完成具体的登录验证，并根据DAO的验证结果返回登录信息|
|8|login.jsp|JSP|提供用户输入的表单、可以显示用户登录成功或失败的信息|

# 数据库安装代码

```
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES ('admin', 'administrator', 'admin');
```

# 项目编译

## com.shawn.mvcdemo.vo.User编译

```
/项目目录$javac -encoding utf-8 -d ./WebContent/WEB-INF/classes src/com/shawn/mvcdemo/vo/User.java
```
### 编译说明

> -encoding utf-8		设置编码格式为utf-8
> -d ./WebContent/WEB-INF/classes		设置编译后的class文件保存路径
> src/com/shawn/mvcdemo/vo/User.java	设置编译源文件
