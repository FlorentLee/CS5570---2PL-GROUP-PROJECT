# CS5570---2PL-GROUP-PROJECT

SCHEDULE:

A. The purpose of the experiment

1. Master the two-stage locking protocol and the construction of a simple concurrent control system.
2. Understand the non-serialization caused by concurrent transaction access
3. Use technology that guarantees serialization.

B. The content of the experiment

Build a lock-based concurrency control system, including:

1. Randomly generate 3 concurrently executed transactions, each transaction is the following sequence of operations T={begin-transaction}r(x1)w(x1, Val1) r(x2)w(x2, Val2)...{commit }. Among them, Val1, Val2, etc. are randomly generated integers; the objects of transaction read and write operations x1, x2... come from the database DB={x1, x2, x3, …}.√√√√√√

2. Customize the database size, which is 6 in this experiment. When each transaction specifically operates, those data objects will also be randomly generated. Please note: not every transaction will access every data item in the database.√√√√√√

3. UPDATE: We still need to execute 3 randomly generated transactions and each transaction is executed in sequence. KYLE is gonna make the testlog with screen captures of all the 6 results just like the ones in that original project. (You can refer to my uploaded testlog of 24 final database states corresponding to 4 transactions.)

4. Execute transactions according to the given order and test.××××××[HAN & ZEKAI] It seems not function well according to ZEKAI'S attempt.

5. UPDATE: Use a two-stage locking mechanism for concurrency control to check whether the state of the database after the transaction is executed is consistent with a certain sequential execution state. As for the case of 4 transactions, Yimin tried to run original 2pl codes but failed. (Program was terminated immediately.) Since now we switch back to 3 transactions and it should be fine. Kyle can help try it again and record the testlog as well.

6. Forms of deadlock prevention.××××××[HAN & ZEKAI] It should be easier right now. Zekai has added some codes and now is improving them.

7. Try to implement different isolation levels.××××××[ALL]

DUE DATE: DEC, 11

NEXT MEETING TIME TO WRITE THE REPORT TOGETHER: TBD, NEXT WEEKEND
