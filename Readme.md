私人版本
https://www.cnblogs.com/ukzq/ <<问题留言
-----------SQL-----------
sql文件在根目录sql---文件夹下
也可以在项目中flyway模块运行main执行sql文件的自动导入
-------------------------
先要更改sql连接密码 \test1\src\main\resources\application.properties
>>>> 后台登录需要redis配置好并开启
>>>> 后台测试账号 zhang3 12345
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

与搜索table一致,前端echarts显示根据选定时间区间进行搜索b_time,e_time.
公有货品controller完善

##### 2019-2-26
- 1. 加入对会员登录的判定,当没登录时,不予展示数据,并再加入ajax的获取数据失败的提示.√
- 2. 完善录入规则,加入区间字段的判定.
- 3. 完善会员登录页面.
- 4. 待将会员操作日志加入展示层ui中.
- 5. 待将admin查询货品调用的controller改为统一接口. OK (还待增强)

##### 2019-2-27
- 1. 让easyui界面更加简洁清新.'指标查询'应该改为'条件搜索' OK
- 2. GoodsController中对搜索传入指标字符串的判定,
     以及更改Mapper中SQL按比较符号搜索.(多条件查询SQL更改) OK,
     还差几个字段的模糊查询和拆分查询如anode的size 
- 3. 已经加入了admin登录后的对menu的redis存储.key为user+userRoleList
- 4. 

##### 2019-3-11
- 1. 项目前端页面暂时未完善,先做solomo信息库,在jee_solomo项目.

##### 2019-3-18
- 1. 将encrypt密码加密做了外部参数配置
- 2. 将member会有的邀请码做了外部参数配置

##### 2019-3-25
- 1. 整体动态文章的中英文转换?有相关接口么?

##### 2019-4-11
- 1. 加入自定义404配置类ErrorConfigurar : https://blog.csdn.net/trusause/article/details/84299886

##### 2019-4-15
- 1. 

##### 2019-4-21
- 1. 单表还原要再参考fhbootm中的去做

##### 2019-4-24
- 1. 用户后台登录过于延迟 redis又改善了.
- 2. 还需要改善:用户被管理员修改了权限之后能够及时(在线)生效.
- 3. actuator(还需要加入shiroConfiguration进行拦截)

##### 2019-5-6
- 1. 加入server监控,暂时不可用,使用原来github看到的那种图形化监控https://github.com/deadzq/JavaMonitor <桌面有 TODO
##### 2019-5-7
- 1. 改质沥青需要改变搜索样式标准化 OK
- 2. 加入服务器监控路径 (TODO页面还未添加样式)

##### 2019-5-8
- 1. √ 待加入数据库表自动生成组件flyway用于部署项目后向数据库写入数据表(参考hope-boot)
- 2. 待加入在线人数查看
- 3. 待将JXC版本的easyui(主要使用后面齿轮状按钮)和现货品的easyui进行融合,美化+https://github.com/deadzq/AdminLTE
- 4. 待分包微服务.

##### 2019-5-9
- 1. 加入devtools热部署,可即时看到程序效果更改.
- 1. shiro在线踢出,冻结功能 前后端鉴权
- 2. properties转yml

##### 2019-5-10
- 1. 前后端分离部署
- 2. redis的使用

##### 2019-5-11
- 1. 数据库表的完善
- 2. actuator端点拦截或关闭或使用
- 3. 参考ruoyi使用lambda语法(箭头语法)

##### 2019-5-14
- 1. 整理了印象笔记中对应的笔记


