
演示api gateway，通过Zuul实现。  

http://localhost:8888/user-feign/1  路由访问的对应ip为： http://localhost:8084/user-feign/1

配置接口2种方式，建议使用serviceId，更换 ip 不影响服务
1.serviceId指定服务名
2.url指定服务地址
