# tc
spring boot + postgresql + jooq + freemarker

### Ubuntu环境配置安装
- Ubuntu 更新
```aidl
sudo apt-get dist-upgrade
```
- 安装postgresql
```aidl
sudo apt-get install postgresql 
// 切换角色
sudo su postgres 
// 执行到sql
psql postgres  
// 修改postgres 密码
ALTER USER postgres with PASSWORD 'zcj19921123'
// 退出
\q
///etc/postgresql/9.6/main 编辑配置文件
/etc/postgresql/9.6/main 目录下执行以下命令
udo service postgresql restart 重启服务
```
- 安装redis
```aidl
sudo apt-get install redis-server  
redis-server 
// 查看是否启动
redis-cli  
// 重启等
/etc/init.d/redis-server stop
/etc/init.d/redis-server start
/etc/init.d/redis-server restart
```

- nginx 安装
```aidl
sudo apt-get install nginx
// 修改配置文件
sudo /etc/init.d/nginx start

```
- jdk 安装
```aidl
sudo apt-get install python-software-properties

sudo add-apt-repository ppa:webupd8team/java

sudo apt-get update

sudo apt-get install oracle-java8-installer
// 查看java 版本
java -version

```
- 部署项目
```aidl
jar 放入到服务器中
nohup java -jar tiancai-0.0.1-SNAPSHOT.jar > tc.log

```
