# CS5570---2PL-GROUP-PROJECT

A. The purpose of the experiment

1. Master the two-stage locking protocol and the construction of a simple concurrent control system.
2. Understand the non-serialization caused by concurrent transaction access
3. Use technology that guarantees serialization.

B. The content of the experiment

Build a lock-based concurrency control system, including:

1. Randomly generate 4 concurrently executed transactions, each transaction is the following sequence of operations T={begin-transaction}r(x1)w(x1, Val1) r(x2)w(x2, Val2)...{commit }. Among them, Val1, Val2, etc. are randomly generated integers; the objects of transaction read and write operations x1, x2... come from the database DB={x1, x2, x3, …}.√√√√√√

2. Customize the database size, which is 6 in this experiment. When each transaction specifically operates, those data objects will also be randomly generated. Please note: not every transaction will access every data item in the database.√√√√√√

3. Execute 4 randomly generated transactions, each transaction is executed in sequence, and the 24 final database states are recorded. √√√√√√ [YIMIN UPLAODED IT IN TESTLOG]

4. Execute transactions according to the given order and test.××××××[HAN & ZEKAI]

5. Use a two-stage locking mechanism for concurrency control to check whether the state of the database after the transaction is executed is consistent with a certain sequential execution state. ?????? [Yimin tried to run original 2pl method part codes but failed. (Program was terminated immediately.) I guess because we generate 4 transactions instead of 3 in the original one. Some more codes should be edited but got no idea.]

6. Forms of deadlock prevention.××××××[HAN & ZEKAI]

7. Try to implement different isolation levels.××××××[ALL]

一、实验目的

掌握两段加锁协议和简单并发控制系统的构建；理解事务并发访问造成的不可串行化和如何保证可串行化的技术。

二、实验内容

构建一个基于锁的并发控制系统，具体包括：

1. 随机生成若干4个并发执行的事务，每个事务为如下的操作序列T={begin-transaction}r(x1)w(x1, Val1) r(x2)w(x2, Val2)…{commit}。
其中Val1，Val2等为随机生成的整数；事务读写操作的对象x1, x2…来自于数据库DB={x1, x2, x3, …}。

2. 数据库大小自定义，本实验中为6。当每个事务具体操作时，那些数据对象也会随机生成。请注意：不是每个事务都会访问数据库内的每个数据项。

3. 执行随机生成的4个事务，每个事务内部按照顺序执行，记录下全排列的24种最终数据库状态。[已上传至testlog文档]

4. 根据给定次序执行事务，进行测试。

5. 使用两段加锁机制进行并发控制，查看事务执行后数据库的状态和某种顺序执行状态是否一致。

6. 死锁的预防形式。

7. 尝试执行不同的隔离等级。
