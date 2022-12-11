# allo_re
## 项目基本结构

### app - 

#### 	com.live.allo - 

##### 		business -      业务相关代码

###### 			api -             网络请求接口相关信息

###### 			models -     请求对应的bean类

​				request -     请求数据model

​				response -  收到数据model

##### 		data - 			  相关数据代码

##### 		database -      数据库相关代码

###### 			dao -							数据库orm相关接口

###### 			databasebean - 	   数据库对应的bean类

##### 		di -					Module类

##### 		net -				 网络核心

##### 		repository -    数据仓库

##### 		ui - 				   ui相关 views

##### 		util -				 工具类

##### 		works -		    workManager 后台任务

​		

### buildSrc - 

#### 	com.live.allo.buildsrc.dependencies.kt  // gradle 配置相关

