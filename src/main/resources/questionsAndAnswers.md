##常见问题及解决方案：
问题1.Action:
  
  Consider the following:
  	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
  	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).

解决方案：配置数据库连接

问题2. test package 下类引用不到 [2.2 & 2.2 之前的不同]

解决方案：pom 文件引入对应的jar

问题3.创建时间 & 修改时间

解决方案：选择 timestamp 默认值： CURRENT_TIMESTAMP   	
  	