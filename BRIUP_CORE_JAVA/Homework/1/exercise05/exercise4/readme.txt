��ṹ���£�
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

1. ����ṹ�Դ�����ʽ��ʾ�����Է����͹������ṩ�����ʵ�֡�
2. ʹ��TestBanking��Դ�����в���