# Java高并发秒杀系统

本代码对应到[慕课网](https://www.imooc.com)的《Java高并发秒杀》免费课程。
代码由本人根据课程中的内容编写，并且把原课程中用到的普通Spring框架替换成了SpringBoot框架，优化了项目中的配置，适合初学者学习。

整个架构分成3个部分<br>
## DAO层
MyBatis的通过配置文件XML访问数据库
通过Redis缓存减少数据库的访问
通过存储过程优化减少客户端和数据库的交互次数，提高并发度

## Service层
使用Spring MVC框架处理Restful请求

## Web层
使用Jsp，通过Cookie保存秒杀请求的手机号码





