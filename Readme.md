##### 2019-1-10
- 1.controller: ShowPageController页面展示.
- 2.展示暂时有resources/templdates/[index,about,services,contact]
- 3.新导入依赖有pagehelper,MySQL连接,thymeleaf,lombok,starter-mail,shiro-spring,shiro-web,shiro&thymeleaf
- four.[前端页面选型](https://startbootstrap.com/template-overviews/modern-business/)
- 5.[shiro待完善+后端页面](https://blog.csdn.net/qq_19301269/article/details/78627792)

##### 2019-1-12
- 1.创建了新数据库表.使用了mybatis-generator.
- 2.需要加入admin2后台页面+easyui.
- 3.需要加入excel表的导入导出.
- 4.加入新的依赖mybatis-generator,mybatis-spring.
- 5.更改了后台路径为/admin/**之类.
- 6.将thymeleaf取消,需将buycard中的css等加入到static.

##### todo list:
- 1. 将数据转换为图表展示.(初步完成)
- 2. shiro整合.

##### 2019-1-15 do & todo list
- 1. 加入了高并发下的redis(PetroleumCokeController)
- 2. config,RedisService
- 3. 加强图表展示
- 4. 石油焦文档学习
- 5. shiro加入(权限(基础)/单点登录)
- 6. 网站布局,面向用户,盈利模式,为用户带来价值 商业模型建立.

##### 2019-1-23 
- 1. echart0与echarts01一个适合参数比较一个适合价格比较
##### Todo list
- 1. 前端页面布局 1/3 1/3 1/3
- 2. shiro整合

##### Todo list 2019-1-27
- 1. 前端shiro整合 

##### TODO 2019-1-31
- 1. shiroFilterFactoryBean的重写

##### 2019-02-08
- 1. 该项目作为管理系统单独供后端使用,不再加入前端网页.
- 2. 前端网页作为仍然使用权限分级,避免与当前项目混淆,并减少阻力.

##### 2019-02-11
- 1. goods新增几个货品,改善指标多条件查询.

##### 2019-02-13
- 1. 调整了jsp和thymeleaf的共存后,静态cssjs文件被放到了webapp下.否则无效

##### 2019-02-14
- 1. 权限页面设置 需要后期完善的记录到了https://www.cnblogs.com/ukzq/p/10366049.html
- 2. 调整admin/main.html 融合到test1系统.(用户登录退出改变位置,图片更改)
- 3.

##### 2019-02-15
- 1. 权限的继续完善  多角色 单角色 217
- 2. member权限完善
- 3. easyui整合 roleconfig路径调整

##### 2019-02-17
- 1. hope-plus整理(layui前端页面)
- 2. 数据库表

##### 2019-02-21
- 1. 对系统日志进行记录,对后端角色分配调整成功后,需要进行录入数据测试.
- 2. 需要根据搜索条件(如区间,小于大于)进行搜索调整,需要加入需要模糊查询SQL调整.
- 3. 加入时间选取区间插件,查询数据时间区间.

##### 2019-02-22
- 1. 增加了member的Mapper Service后,之后编写MemberController
- 2. 通过登录member后返回member_level,在前端展示该显示哪些数据/数据量
- 3. 根据前端选择的图表的时间年份/月份/日期进行按日期查询(更改selectAll(条件))
