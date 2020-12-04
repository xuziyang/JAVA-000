主从复制

1，启动docker-compose
   docker-compose -f docker-compose-mysql-cluster.yml up -d

2, 配置主从同步

   在主库创建同步用户
   create user repl;
   GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%' IDENTIFIED BY 'repl';

   查看主库当前log文件以及位置
   show master status

   从库配置master参数
    CHANGE MASTER TO
    ->   MASTER_HOST='mysql-master',
    ->   MASTER_USER='repl',
    ->   MASTER_PASSWORD='repl',
    ->   MASTER_LOG_FILE='mysql-bin.000003',
    ->   MASTER_LOG_POS=635;

    启动slave服务
    start slave；