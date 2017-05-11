暂时使用 zipkin 来分布式服务追踪分析，目前直接存放内存，重启丢失，且直接使用 http 会影响性能。

http://localhost:9001

feign-client 调用 rest-api 接口链路可以清晰追踪及分析

sleuth 有一个默认0.1的采样率的概念，并不会发送所有的数据，可以通过配置 spring.sleuth.sampler.percentage 指定数据采样的百分比

接下来考虑使用spring-cloud-sleuth-zipkin-stream，增加 MQ 及 ES，解决存储及性能问题。