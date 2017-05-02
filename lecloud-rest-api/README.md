1. 使用Spring Data JPA进行数据持久化
2. 通过Spring Data Rest将Spring Data JPA的Repository自动转换成REST服务 
3. 引入the HAL Browser，便于可视化测试

http://localhost:8082/api   返回接口清单  
http://localhost:8082/h2    访问h2 web控制台

启动后，控制台测试新建一个对象 
curl -i -X POST -H "Content-Type:application/json" -d '{"name":"qiaohui", "address":"beijin"}' http://localhost:8082/api/user