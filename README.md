## letou Spring Cloud    

|project|desc|  
|---|---|   
|[lecloud-eureka-server](lecloud-eureka-server/README.md)|Eureka服务注册中心|  
|[lecloud-rest-api](lecloud-rest-api/README.md)|数据库增删改查<br>Spring Data JPA、Spring Data REST、H2、the HAL Browser等|  
|[lecloud-feign-client](lecloud-feign-client/README.md)|Feign客户端|  
|[lecloud-api-gateway](lecloud-api-gateway/README.md)|Zuul服务网关|  
|[lecloud-monitor-server](lecloud-monitor-server/README.md)|监控基于eureka的应用| 
|[lecloud-swagger2-apiInfo](lecloud-swagger2-apiInfo/README.md)|Swagger2 api info|  
|...|...|  

> 启动顺序：  
> 1. 服务端（lecloud-eureka-server \ lecloud-monitor-server）  
> 2. 客户端（lecloud-rest-api \ lecloud-feign-client ）  
> 3. 服务网关（lecloud-api-gateway）  
> 4. 接口文档 (lecloud-swagger2-apiInfo)

> 项目启动：
> mvn spring-boot:run

``` 
Maven 使用阿里云的 jar 仓库:
    <mirror>
        <id>nexus-aliyun</id>
        <mirrorOf>*</mirrorOf>
        <name>Nexus aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
``` 


