# study_springboot

8760 config
8761 eureka
8762 user
8763 finance
8764 pay
8765 zuul
8766 admin

#访问地址
##http://localhost:8761/    Eureka
##http://localhost:15672/   RabbitMQ
##http://localhost:8766/    SpringBootAdmin
##http://localhost:8767/    Zipkin

SpringBoot
SpringCore
SpringMVC
SpringCloud

Shiro

MyBatis
SpringJDBC

Maven
Git

Redis
MySQL
Oracle

Transaction
Restful
RestTemplate
RedisTemplate
Logback
Cache
    @Cacheable，@CachePut，@CacheEvict
@Aspect
@EnableScheduling @Scheduled
@LoadBalance

mvn install:install-file -Dfile=D:\ojdbc6\11.2.0\ojdbc6-11.2.0.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar

SpringCloud和SpringBoot针对JSP页面的目录结构是不一样的。Cloud：main\resources\META-INF\resources\WEB-INF。Boot：main\webapp\WEB-INF

fallback与fallbackFactory区别，fallback只是出错运行你指定的方法，拿不到错误信息，fallbackFactory可以拿到错误信息。
调用远程需要借助单独的类和接口，feign是编写一个接口，而ribbon是编写一个类，在这个类中我们就可以通过resttemplate来调
用远程服务。

Eureka
Feign
Ribbon
Hystrix
Zuul
Config
Config Bus
Sleuth
Zipkin

Config支持我们使用的请求的参数规则为：
/ { 应用名 } / { 环境名 } [ / { 分支名 } ]
/ { 应用名 } - { 环境名 }.yml
/ { 应用名 } - { 环境名 }.properties
/ { 分支名 } / { 应用名 } - { 环境名 }.yml
/ { 分支名 } / { 应用名 } - { 环境名 }.properties

yml和properties文件是一样的原理，且一个项目上要么yml或者properties，二选一的存在。
bootstrap.yml（bootstrap.properties）先加载 application.yml（application.properties）后加载

Config服务，git使用远程会自动更新，使用native需要手动重启服务。http://localhost:8760/configService/actuator/bus-refresh

问题：Config服务，客户端通过service-id无法访问服务端，uri可以。

zuul自动创建服务的默认路由http://localhost:8765/zuulService/user-service/userService/*

问题：JSP与Thymeleaf的html共存，只有html生效。

swagger2.2.2 与 spring cloud feign有冲突 ，换成swagger 2.7.0后可解决

security: 添加此设置后，actuator/bus-refresh会失败，需要登录。

问题：配置servlet: context-path后，SpringBootAdmin的访问，会缺失需要参数的展示。