# miaosha
秒杀系统 springboot+mybatis+Redis+kafka+zookeeper

本项目是模拟秒杀系统的demo，目前还不完整，会持续更新

## 大概思路
秒杀开始会有倒计时，这个存在Redis缓存中，目前是手动添加

数据库中的商品设定为100个。
所以在开始秒杀之后，用Redis的原子自增计算请求的数量，
超过500个之后的所有请求都会被挡住

请求成功之后提交到kafka消息队列
考虑到以后会做分布式（多实例和kafka集群）在消费请求的时候加入了乐观锁，即shangpin表中有个字段vision

## 步骤

### 环境准备

jdk8 + mysql + Redis + kafka（里面有zookeeper）

### 配置文件
在application.yml中修改mysql、Redis、kafka的连接地址和密码

### 启动项目


## 未做事项（先挖坑）

1、多实例部署、kafka集群

2、增加界面，可以手动设置倒计时和允许进行秒杀的请求数量

3、在前端可以真实的参与秒杀，和机器人竞争

4、.....
