# 邪恶计算器

# 一、这是什么

ladp弹计算器，用于复现、验证JNDI漏洞。

# 二、使用方式

修改配置文件`src/main/resources/application.properties`：

```properties
# http协议监听的端口 
http.port=10086
# ladp协议监听的端口
ladp.port=10010
```

注意端口不要与机器上已经存在的冲突，不然会启动失败。



启动`cc11001100.evil.server.EvilServer`这个类，控制台上打印：


# 三、修改编译EvilCalc

如果你需要修改反序列化时要执行的命令的话，重新编译`src/main/java/cc11001100/evil/calc/EvilCalc.java`这个类，注意目标JDK版本不要太高，不然客户端可能无法反序列化：
```bash
cd src/main/java/cc11001100/evil/calc/
javac -source 1.8 -target 1.8 EvilCalc.java
```

把编译好的`EvilCalc.class`放到`src/main/resources/public`下。

# 四、JEP-269无法反序列化 

复现反序列化测试时高版本JDK手动打开限制：

```java
System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
```

关于RMI绕过请参考组织下的其它仓库，不在此仓库的讨论范围内。

# 五、TODO

- 提供远程的evil.jar包加载
- 支持rmi
