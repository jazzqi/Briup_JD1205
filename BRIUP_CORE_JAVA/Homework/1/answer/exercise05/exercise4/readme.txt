类结构如下：
==============================================
Account
----------------------------------------------
#balance:double
----------------------------------------------
+Account(double:balance)
+getBalance():double
+deposit(double:amount):boolean
+withdraw(double:amount):boolean
==============================================
SavingAccount(extends Account)
----------------------------------------------
-rate:double
----------------------------------------------
+SavingAccount(double:balance, double rate)
==============================================
CheckingAccount(extends Account)
----------------------------------------------
-overdraft:double
----------------------------------------------
+CheckingAccount(double:balance, double overdraft)
+CheckingAccount(double:balance)
+withdraw(double:amount):boolean
+getOverdraft():double
==============================================
Customer
----------------------------------------------
-account:Account
-name:String
----------------------------------------------
+Customer(String:name)
+getAccount():Account
+setAccount(Account:account):void
+getName():String
==============================================
Bank
----------------------------------------------
-customers:Customer[]
-custNum:int
----------------------------------------------
+Bank()
+addCustomer(Customer:customer):void
+getCustomer(int:index):Customer
+getCustomerNum():int
==============================================

1. 将类结构以代码形式表示，并对方法和构造器提供合理的实现。
2. 使用TestBanking类对代码进行测试