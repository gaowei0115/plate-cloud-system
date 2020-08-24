1. SpringConfig配置中心服务端
    采用consul注册中心
    需要启动consul服务。
    先安装consul软件，配置环境变量
    启动脚本：consul agent -dev -client 0.0.0.0 -ui &
    
    可以采用eureka注册中心
    
    
    验证config-server配置成功
    https://github.com/gaowei0115/cloud-config.git
    
    
2. 配置中心配置要求
    
    与SpringCloud Config相关配置需配置到bootstrap.yml配置文件中
    与SpringBoot服务相关配置需配置到application.yml配置文件中
    
3. 动态刷新客户端获取配置文件信息
    1. 原生态刷新技术
        在引用类配置@RefreshScope注解
        此方式同时还要修改@Value注解内容为@Value("${info:error}")，因为刷新的时候需要配置信息有默认值，否则会报错。
        
        
        SpringBoot2.x 后续版本
        需要引入
        <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-actuator</artifactId>
                </dependency>
        配置需要开启refresh
        management:
          endpoints:
            web:
              base-path: /actuator
              exposure:
                # 打开部分
                include: refresh,health,info
                # 打开全部
                #include: *
          server:
            port: 8081
        
        通过postman  
            post请求http://localhost:8081/actuator/refresh
        
        
    2. 通过消息队列刷新
    
    通过rabbitmq整合实现消息总线
    引入jar
    <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-bus-amqp</artifactId>
            </dependency>
    
    配置文件中引入rabbitmq连接配置
    spring:
      rabbitmq:
        host: 10.4.3.170
        port: 5672
        username: root
        password: 123456
    management:
      endpoints:
        web:
          base-path: /actuator
          exposure:
            # 打开全部
            include: "*"
            
    通过访问post  http://localhost:8081/actuator/bus-refresh 
            刷新配置