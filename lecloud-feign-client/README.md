演示Feign、Hystrix的Eureka客户端。  

_FeignClient方式调用接口_  
http://localhost:8084/user-feign/1                      |根据ID获取User [db-rest]|  
http://localhost:8084/user-feign/getUserByName/张三      |根据name获取User [db-rest]|  
http://localhost:8084/user-feign/getUserByAddress/test  |根据地址获取User [db-rest]|  


_RestTemplate方式调用接口_ 
http://localhost:8084/user-rest/1                       |根据ID获取User [db-rest]|  


_Hystrix Dashboard监控_     
http://localhost:8084/hystrix                           |查看仪表盘|  
http://localhost:8084/hystrix.stream                    |在仪表盘中查看监控|  
