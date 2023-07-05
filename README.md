# 邪恶计算器

ladp弹计算器，用于复现、验证JNDI漏洞。

重新编译计算器类：
```bash
javac -source 1.5 -target 1.5 EvilCalc.java
```

高版本JDK手动打开限制：
```java
System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
```




