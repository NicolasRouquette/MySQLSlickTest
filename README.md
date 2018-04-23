# MySQLSlickTest

Slick test w/ MySQLProfile

# SQL statements executed when creating the database tables:

`mysql.slick.database.test.Create_CaesarSlickService_Tables`

```
DEBUG [main] (Logging.scala:40) - #1: [fused] andThen
      1: schema.create [create table `mysql_slick`.`A` (`Id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,`Script` VARCHAR(500) NOT NULL); create table `mysql_slick`.`B` (`Id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,`AId` INTEGER NOT NULL); alter table `mysql_slick`.`B` add constraint `fkA_B` foreign key(`AId`) references `mysql_slick`.`A`(`Id`) on update NO ACTION on delete NO ACTION]
      2: success ()
DEBUG [db.test-1] (Logging.scala:40) - Preparing statement: create table `mysql_slick`.`A` (`Id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,`Script` VARCHAR(500) NOT NULL)
DEBUG [db.test-1] (Logging.scala:40) - Execution of prepared statement took 44ms
DEBUG [db.test-1] (Logging.scala:40) - Preparing statement: create table `mysql_slick`.`B` (`Id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,`AId` INTEGER NOT NULL)
DEBUG [db.test-1] (Logging.scala:40) - Execution of prepared statement took 20ms
DEBUG [db.test-1] (Logging.scala:40) - Preparing statement: alter table `mysql_slick`.`B` add constraint `fkA_B` foreign key(`AId`) references `mysql_slick`.`A`(`Id`) on update NO ACTION on delete NO ACTION
DEBUG [db.test-1] (Logging.scala:40) - Execution of prepared statement took 53ms
```

# SQL statements executed when dropping the databse tables:

## Without the fix `val slickVersion = "3.2.3"`

`mysql.slick.database.test.Drop_CaesarSlickService_Tables`


```
DEBUG [main] (Logging.scala:40) - #1: [fused] andThen
      1: schema.drop [ALTER TABLE `B` DROP FOREIGN KEY `fkA_B`; drop table `mysql_slick`.`B`; drop table `mysql_slick`.`A`]
      2: success ()
DEBUG [db.test-1] (Logging.scala:40) - Preparing statement: ALTER TABLE `B` DROP FOREIGN KEY `fkA_B`
 INFO [main] (HikariPool.java:204) - db.test - Close initiated...
DEBUG [main] (HikariPool.java:378) - db.test - Before closing stats (total=20, active=0, idle=20, waiting=0)
...
DEBUG [main] (HikariPool.java:378) - db.test - After closing stats (total=0, active=0, idle=0, waiting=0)
 INFO [main] (HikariPool.java:241) - db.test - Closed.
Exception in thread "main" java.sql.SQLException: No database selected
	at com.mysql.jdbc.SQLError.createSQLException(SQLError.java:1073)
	at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3609)
	at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3541)
	at com.mysql.jdbc.MysqlIO.sendCommand(MysqlIO.java:2002)
	at com.mysql.jdbc.MysqlIO.sqlQueryDirect(MysqlIO.java:2163)
	at com.mysql.jdbc.ConnectionImpl.execSQL(ConnectionImpl.java:2624)
	at com.mysql.jdbc.PreparedStatement.executeInternal(PreparedStatement.java:2127)
	at com.mysql.jdbc.PreparedStatement.execute(PreparedStatement.java:1362)
	at com.zaxxer.hikari.pool.ProxyPreparedStatement.execute(ProxyPreparedStatement.java:44)
	at com.zaxxer.hikari.pool.HikariProxyPreparedStatement.execute(HikariProxyPreparedStatement.java)
	at slick.jdbc.LoggingPreparedStatement.$anonfun$execute$5(LoggingStatement.scala:153)
	at scala.runtime.java8.JFunction0$mcZ$sp.apply(JFunction0$mcZ$sp.java:12)
	at slick.jdbc.LoggingStatement.logged(LoggingStatement.scala:84)
	at slick.jdbc.LoggingPreparedStatement.execute(LoggingStatement.scala:153)
	at slick.jdbc.JdbcActionComponent$SchemaActionExtensionMethodsImpl$$anon$7.$anonfun$run$9(JdbcActionComponent.scala:299)
	at slick.jdbc.JdbcActionComponent$SchemaActionExtensionMethodsImpl$$anon$7.$anonfun$run$9$adapted(JdbcActionComponent.scala:299)
	at slick.jdbc.JdbcBackend$SessionDef.withPreparedStatement(JdbcBackend.scala:386)
	at slick.jdbc.JdbcBackend$SessionDef.withPreparedStatement$(JdbcBackend.scala:381)
	at slick.jdbc.JdbcBackend$BaseSession.withPreparedStatement(JdbcBackend.scala:448)
	at slick.jdbc.JdbcActionComponent$SchemaActionExtensionMethodsImpl$$anon$7.$anonfun$run$8(JdbcActionComponent.scala:299)
	at slick.jdbc.JdbcActionComponent$SchemaActionExtensionMethodsImpl$$anon$7.$anonfun$run$8$adapted(JdbcActionComponent.scala:299)
	at scala.collection.Iterator.foreach(Iterator.scala:929)
	at scala.collection.Iterator.foreach$(Iterator.scala:929)
	at scala.collection.AbstractIterator.foreach(Iterator.scala:1417)
	at scala.collection.IterableLike.foreach(IterableLike.scala:71)
	at scala.collection.IterableLike.foreach$(IterableLike.scala:70)
	at scala.collection.AbstractIterable.foreach(Iterable.scala:54)
	at slick.jdbc.JdbcActionComponent$SchemaActionExtensionMethodsImpl$$anon$7.run(JdbcActionComponent.scala:299)
	at slick.jdbc.JdbcActionComponent$SchemaActionExtensionMethodsImpl$$anon$7.run(JdbcActionComponent.scala:297)
	at slick.jdbc.JdbcActionComponent$SimpleJdbcProfileAction.run(JdbcActionComponent.scala:30)
	at slick.jdbc.JdbcActionComponent$SimpleJdbcProfileAction.run(JdbcActionComponent.scala:27)
	at slick.dbio.DBIOAction$$anon$4.$anonfun$run$3(DBIOAction.scala:239)
	at scala.collection.Iterator.foreach(Iterator.scala:929)
	at scala.collection.Iterator.foreach$(Iterator.scala:929)
	at scala.collection.AbstractIterator.foreach(Iterator.scala:1417)
	at scala.collection.IterableLike.foreach(IterableLike.scala:71)
	at scala.collection.IterableLike.foreach$(IterableLike.scala:70)
	at scala.collection.AbstractIterable.foreach(Iterable.scala:54)
	at slick.dbio.DBIOAction$$anon$4.run(DBIOAction.scala:239)
	at slick.dbio.DBIOAction$$anon$4.run(DBIOAction.scala:237)
	at slick.basic.BasicBackend$DatabaseDef$$anon$2.liftedTree1$1(BasicBackend.scala:275)
	at slick.basic.BasicBackend$DatabaseDef$$anon$2.run(BasicBackend.scala:275)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
```

## With the fix: `val slickVersion = "3.3.0-SNAPSHOT"`

```
DEBUG [main] (Logging.scala:40) - #1: [fused] andThen
      1: schema.drop [ALTER TABLE `mysql_slick`.`B` DROP FOREIGN KEY `fkA_B`; drop table `mysql_slick`.`B`; drop table `mysql_slick`.`A`]
      2: success ()
DEBUG [db.test-1] (Logging.scala:40) - Preparing statement: ALTER TABLE `mysql_slick`.`B` DROP FOREIGN KEY `fkA_B`
DEBUG [db.test-1] (Logging.scala:40) - Execution of prepared statement took 61ms
DEBUG [db.test-1] (Logging.scala:40) - Preparing statement: drop table `mysql_slick`.`B`
DEBUG [db.test-1] (Logging.scala:40) - Execution of prepared statement took 18ms
DEBUG [db.test-1] (Logging.scala:40) - Preparing statement: drop table `mysql_slick`.`A`
DEBUG [db.test-1] (Logging.scala:40) - Execution of prepared statement took 16ms
 INFO [main] (HikariDataSource.java:347) - db.test - Shutdown initiated...
DEBUG [main] (HikariPool.java:403) - db.test - Before shutdown stats (total=20, active=0, idle=20, waiting=0)
```

No exceptions; the database tables have been dropped, incl. foreign keys.
