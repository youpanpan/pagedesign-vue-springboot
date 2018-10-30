# 在线页面设计工具后台服务（SpringBoot）

> 该项目是在线页面设计工具的后台服务，前端项目地址：[在线页面设计工具前端项目](https://github.com/youpanpan/pagedesign-vue)  
> 项目使用的开发工具是：Eclipse

## 项目结构

- 1.micro-service
> 该项目作为父POM项目，用来管理子模块的版本及共有的依赖

- 2.micro-common
> 该项目是一个公共类的Maven模块项目，用来定义一些工具类及基础Model

- 3.micro-service-api
> 该项目是定义业务实体Bean的模块，被服务提供方和消费者依赖，避免写两套相同的代码

- 4.micro-service-provider-pagedesign
> 该项目是服务提供方，与mybatis结合，操作底层数据库

- 5.micro-service-consumer-pagedesign
> 该项目是前端项目直接交互的客户端，即服务消费者，使用RestTemplate请求服务接口地址

## 数据库结构
> 项目依赖数据库(本人使用的是mysql数据)，具体配置实在micro-service-provider-pagedesign项目下，对应的建表语句在src/main/resources下

## 版本说明
### V1.0
- 提供基础的存储、查询服务
- 提供基础的Basic认证