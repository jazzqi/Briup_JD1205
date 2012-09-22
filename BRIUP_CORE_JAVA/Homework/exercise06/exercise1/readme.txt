使用接口和抽象类
练习目标：

建立一个动物的层次结构，以抽象类Animal为根，几个动物类将实现接口Pet。

类结构如下：

Animal--abstract	

Pet<<interface>>

#legs:int		
+getName()：String
#Animal(legs:int)	
+setName(name:String)
+walk()		        
+play()
+eat()--abstract	

Cat			

Spider

-name:String		
+Spider() 
		

+Cat(name:String)		
+eat()

+Cat() 				

+getName()：String

+setName(name:String)

+play()

+eat()



Fish

-name:String

+Fish() 				

+getName()：String

+setName(name:String)

+play()

+walk()

+eat()



任务1：创建Animal类，它是所有动物类的抽象超类
任务2：创建Spider类，继承Animal类
任务3：创建Pet接口
任务4：创建Cat类，继承Animal类并实现Pet接口
任务5：创建Fish类，继承Animal类并实现Pet接口
任务6：使用TestAnimals类测试代码
