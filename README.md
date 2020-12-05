# Java

* Java 语言的三个特征: 封装、继承、多态

* Java 致力于检查程序在编译和运行时的错误

* Java 自己操纵内存减少了内存出错的可能性

* 指令 javac 的作用: 将源程序编译成字节码

* Java 实现了真数组, 避免了覆盖数据的可能

  > **注意, 是避免数据覆盖的可能, 而不是数据覆盖类型**
  >
  > 数据被覆盖是指在计算机中因粘贴使原有数据被现有数据所占有, 就称被覆盖, 使原有数据消失
  >
  > Java 数组元素在内存中是一个接着一个线性存放的, 通过第一个元素就能访问随后的元素, 这样的数组称之为"真数组", 实现了真数组为 Java 语言健壮性的特点之一

* 运算符优先级与结合性

  > 括号、一元运算符、乘除模加减、位运算、关系运算符、逻辑运算符、三元运算符、赋值运算符
  >
  > 一元乘除位关系, 逻辑三元后赋值

  | 优先级 |                       运算符                       |  结合性  |
    | :----: | :------------------------------------------------: | :------: |
  |   1    |                     ()、[]、{}                     | 从左向右 |
  |   2    |                 !、+、-、~、++、--                 | 从右向左 |
  |   3    |                      *、/、%                       | 从左向右 |
  |   4    |                        +、-                        | 从左向右 |
  |   5    |                    <<、>>、>>>                     | 从左向右 |
  |   6    |              <、<=、>、>=、instanceof              | 从左向右 |
  |   7    |                       ==、!=                       | 从左向右 |
  |   8    |                         &                          | 从左向右 |
  |   9    |                         ^                          | 从左向右 |
  |   10   |                         \|                         | 从左向右 |
  |   11   |                         &&                         | 从左向右 |
  |   12   |                        \|\|                        | 从左向右 |
  |   13   |                         ?:                         | 从右向左 |
  |   14   | =、+=、-=、*=、/=、&=、\|=、^=、~=、<<=、>>=、>>>= | 从右向左 |

## 变量

* Java 变量存储位置

  > 类中的成员变量存放在堆区
  >
  > 方法中的局部变量存放在栈区

  * 堆区: 只存放类对象, 线程共享
  * 方法区(静态存储区): 存放 class 文件和静态数据, 线程共享
  * 栈区: 存放方法局部变量, 基本类型变量区、执行环境上下文、操作指令区, 线程不共享

* 栈内存: 存储局部变量, 变量作用域一旦结束, 空间自动释放, 构造函数也会进栈

* 堆内存: 数组和对象(new)都是放在堆里面(都有首地址, 所示数组默认会有值)

  > 数组的变量名(引用变量)存放着数组实体的首地址(相当于指针), 数组变量名可以指向 null(空)
  >
  > 当数组实体没有变量指向时(垃圾), 堆里面会不定时自动清理

* 问: static 关键字的作用是什么?**(重要)**

  * 修饰成员变量: 因为类加载进==方法区==, 内存分配一次, 所以类的所有对象共享
* 修饰方法: 无需建立对象, 直接用"类名.方法()"调用
  * 修饰代码块: 只会在类被初次加载时执行一次, 可用于初始化等操作
  * 修饰内部类: 可以直接使用静态内部类来建立对象, 并可以调用静态内部类的方法

> 一般方法可以访问静态方法, 静态方法必须访问静态

* final 关键字**(重要)**

  * 修饰变量, 该变量只能被赋值一次且无法改变

    > 对于 static final 成员变量, 必须在声明时初始化
    >
    > 对于非静态成员变量, 必须在声明时或者构造方法中赋值

  * 修饰方法的形参, 在变量的生存期中它的值不能被改变

  * 修饰方法, 该方法无法被重写

  * 修饰类, 该类无法被继承, 如果类是 final 的, 则类中的方法自动为 final

* 成员变量和局部变量

  * 成员变量定义在类中, 整个类可以访问, 成员变量随着对象的建立而建立, 存在于对象所在的==堆内存==, 成员变量有默认初始化值
  * 局部变量只定义在局部范围内, 如函数内, 语句内等, 存在于==栈内存==中, 作用域结束, 变量空间会自动释放, 没有默认初始化值

## 方法

* 构造方法: 在一个类中, 方法名与类名相同, 多个重载方法存在, 用来给对象初始化

  > 如果没有带参数的构造函数, 则默认为参数为空的构造函数

* Java 中方法的参数传递机制都是==传递副本==**(重要)**

  > 问: 当一个对象被当做参数传递到一个方法后, 此方法可改变这个对象的属性, 并返回变化后的结果, 那这里到底是值传递还是引用传递?

  * **Java 只有值传递参数**
  * 如果参数是==基本数据类型==, 那传的就是这个参数的副本, 也就是这个参数的值, 此时在方法中修改形参的值不会影响原来的实参
  * 如果参数是==引用类型==, 那传的就是这个引用参数的副本, 副本存放的是参数的地址, 如果方法中没有改变副本的地址, 而是改变了地址中的值, 那方法内的改动会影响原参数(==浅拷贝==); 如果在方法中改变了副本的地址, 如`object = new Object()`也就是使用了 new 并赋值, 此时副本指向了新的地址, 方法内的改动不会影响原参数(==深拷贝==)

  > 总结: 不管传递什么参数, 都是传递副本, 基本类型是传递值的副本, 引用类型是传递地址的副本, 如果在方法内修改了地址指向的内容, 则会影响原参数, 如果在方法内让副本指向新的内容, 则不会影响原参数

* 重载和重写(多态的体现)**(重要)**

  > Java 三大特性: 封装、继承、多态

  * 重载(Overload): 同一类中同名的方法, 具有不同参数个数或类型, 是类的多态性的体现, 由静态类型确定, 在类加载的时候就确定, 属于==静态分配==
  * 重写(Override): 子类中的与父类相同方法名、返回类型、形参列表的方法, 是在继承中多态性的体现,  属于==动态分配==

  > 方法的重载和重写都是多态性的体现, 区别是重载实现==编译时的多态性==, 后者实现==运行时的多态性==
  >
  > 重载发生在一个类中, 重写发生在子类与父类之间
  >
  > 重载方法必须至少有形参个数或类型的不同, 重写则必须有相同的形参和兼容的返回类型
  >
  > 重写方法还需注意: 要比父类方法更好访问, 不能比父类方法声明更多的异常(里氏替换原则)

* 装箱: 自动将基本数据类型转换为包装器类型

  > 调用方法: Integer.valueOf(int)

  拆箱: 自动将包装器类型转换为基本数据类型

  > 调用方法: Integer.intValue()

* == 与 equals() **(重要)**

  * ==: 基本数据类型直接比较值, 引用类型**比较地址**

    > 问: == 什么时候会自动拆箱?
    >
    > 包装类 == 运算在不遇到算术运算的情况下不会自动拆箱, **即只有遇到运算符才会自动拆箱**

  * equals() 继承自 Object 类, 可重写, 查看源码可知它的实现也是**对对象的地址进行比较**, 本质就是 ==

    > Java 中有一些类重写了 equals(), 比较规则为"如果两个对象的**类型一致, 并且内容一致**则返回 true", 诸如 java.io.File, java.util.Date, java.lang.String, 包装类等

  > 总结
  >
  > 如果类未重写 equals(), 则调用之与使用 == 没差别, 都是判断地址
  >
  > 如果类重写了 equals(), 则按开发者自定义, 一般是比较内容是否相同

  > **看似奇怪的结果: 两个数值为127的包装类对象用 == 判断返回true, 但是127换成128则返回false**
  >
  > 查看Integer类, 会找到IntegerCache这个内部私有类, 它为-128到127之间的所有整数对象提供缓存
  >
  > 为什么会为-128到127之间的所有整数设置缓存?
  >
  > 因为在这个范围内的小数值整数在日常的使用频率要比其它大得多
  >
  > 多次使用相同的底层对象这一特性可以通过该设置进行有效的内存优化
  >
  > 通过反编译`Integer integer127 = 127`
  >
  > 可以看到`Integer integer127 = Integer.valueOf(127)`
  >
  > valueOf()会根据数据大小, 如果是-128到127则会从缓存中取对象
  >
  > 所以==比较地址时会返回true, 不在这个范围内的数则为不同对象, 返回false

  ```java
  public static void main(String[] args) {
      Integer integer1 = 1;
      Integer integer2 = 2;
      Integer integer3 = 3;
      Integer integer1_1 = 1;
      System.out.println(integer1 == integer1_1); // true
      System.out.println(integer1.equals(integer1_1)); // true
      System.out.println(integer1 + integer2 == 3); // true(==遇到运算符自动拆箱)
      System.out.println(new Integer(integer1 + integer2) == integer3); // false
      Integer integer127 = 127;
      Integer integer127_1 = 127;
      System.out.println(integer127 == integer127_1); // true
      System.out.println(integer127.equals(integer127_1)); // true
      Integer integer128 = 128;
      Integer integer128_1 = 128;
      System.out.println(integer128 == integer128_1); // false
      System.out.println(integer128.equals(integer128_1)); // true
      Long long127 = 127L;
      Long long127_1 = 127L;
      System.out.println(long127 == long127_1); // true
      Long long128 = 128L;
      Long long128_1 = 128L;
      System.out.println(long128 == long128_1); // false
  }
  ```

* 问: Object 类有哪些方法?

  * clone(): 保护方法, 实现对象的浅拷贝, 只有实现了 Cloneable 接口才能调用, 否则抛出 CloneNotSupportedException, 方法传参数时不希望改动原参数, 可以利用 clone()

  * getClass(): final, 获得**运行时类型**

  * toString(): 将对象转为字符串表示, 一般子类都会重写该方法

  * finalize(): 该方法用于释放资源, 因为无法确定何时被调用, 所以很少用

    > 为什么不能直接显示调用finalize()?
    >
    > 该方法在**垃圾回收**时一定会执行, 如果在此之前显示执行, 也就是执行两次, 第一次执行时资源已经释放, 第二次执行则会报错, 因此该方法访问权限和父类保持一致为 protected

  * **equals()**: Object 中的该方法等同于 ==, 比较地址

  * **hashCode()**: 该方法用于哈希查找, 可以减少在查找中使用 equals()的次数, 重写了 equals()一般都要重写 hashCode(), 该方法在一些具有哈希功能的 Collection 中用到

  * wait()

    > 神仙问题: 为什么操作线程的方法会放在 Object 中?

    > 该方法使**当前线程等待该对象的锁**, 当前线程必须是该对象的拥有者, 也就是拥有该对象的锁
    >
    > wait()一直等待, 直到获得锁或者被中断
    >
    > wait(long timeout)设定一个超时间隔, timeout时间内没有获得锁就返回

  * notify(): 该方法唤醒在该对象上等待的某个线程

  * notifyAll(): 该方法唤醒在该对象上等待的所有线程

* Java 虚函数

  > 虚函数存在是为了多态

  > Java 中其实并没有虚函数的概念, Java 普通函数==相当于==C++ 的虚函数
  >
  > 动态绑定是 Java 中的默认行为, 如果不希望某个函数具有虚函数特性, 用 final 修饰成为非虚函数

## 类与对象

* 什么是类? 类包括属性和行为

  * 属性就是**成员变量**(实例的变量), 在整个类中可以被使用
  * 行为就是**成员函数**(实例的方法), 代表这个类可以进行哪些操作

* 如何判断两个对象相等?

  1. 首先明确 equals()和 == 的作用及区别

  2. 明确 hashCode()的作用以及与 equals()的关系

     > 对于利用 hash 进行存储对象的集合, 比如 HashMap、HashSet 等, 还要重写 hashCode(), 比如 Set 判断两个元素相等, 会判断 hashCode() 和 equals()

  * 两个对象, 如果`a.equals(b)`为`true`, 则两者内容一致, 但地址不一定相同
  * 两个对象, 如果 hashCode()一致, equals()也可能返回false

  > 总结, 对于两个对象
  >
  > equals()返回 true, 则 hashCode()一定相等
  >
  > equals()返回 false, 则 hashCode()一定不相等
  >
  > hashCode()不相等, 则 equals()返回 false
  >
  > hashCode()相等, 则 equals()返回结果未知

* 程序初始化顺序: 请问 new B()会发生什么

  ```java
  class B extends A ...
  new B();
  ```

  1. 父类的静态代码块
  2. 子类的静态代码块
  3. 父类的普通代码块
  4. 父类的构造方法
  5. 子类的普通代码块
  6. 子类的构造方法

* 匿名内部类不可以定义构造方法

  > 构造方法必须与类名同名, 匿名类没有类名

* 对于外部类来说只有两种修饰, public 和默认(default), 因为外部类放在包中只有两种可能, 包可见和包不可见

  对于内部类来说可以有所有的修饰(四种), 因为内部类放在外部类中, 与成员变量的地位一致

* 类之间的关系

  * **USES-A: **依赖关系, A 类会用到 B 类, 这种关系具有偶然性, 临时性, 但 B 类的变化会影响 A 类, 这种在代码中的体现为 A 类方法中的参数包含了B类
  * **关联关系: **A 类会用到 B 类, 这是一种强依赖关系, 是长期的并非偶然, 在代码中的表现为 A 类的成员变量中含有B类
  * **HAS-A: **聚合关系, 拥有关系, 是**关联关系**的一种特例, 是整体和部分的关系, 比如鸟群和鸟的关系是聚合关系, 鸟群中每个部分都是鸟
  * **IS-A: **表示继承, 父类与子类

* 浅拷贝: 拷贝对象时只对基本类型进行拷贝, 而引用类型只是引用传递, 没有创建新的对象

* 深拷贝: 拷贝对象时创建了新的对象并复制其内的成员变量

* clone(): 对当前对象进行**浅拷贝**

  > 问: 如何进行深拷贝?
  >
  > 1. 序列化(Serialization)这个对象, 再反序列化, 就可以得到这个新的对象
  > 2. 继续利用 clone(), 对内部引用类型的变量再进行一次 clone()

* 序列化: 将对象写入 IO 流中

  反序列化: 从 IO 流中恢复对象

  > 意义: 序列化机制允许将实现序列化的 Java 对象转换为字节序列, 这些字节序列可以保存在磁盘上, 或通过网络传输, 以到达后恢复成原来的对象, **使得对象可以脱离程序的运行而独立存在**

  > 使用场景: 所有可以在网络上传输的对象必须是序列化的(引申: HDFS 的 RPC 机制), 比如 RMI(Remote Method Invoke, 远程方法调用)、RPC 调用, 传入的参数或返回的对象都是可序列化的, 否则会出错; 所有保存到磁盘的 Java 对象都必须是可序列化的

  * 类在序列化时会默认计算一个 serialVersionUID, 类改变时序列号也会改变
  * 但是可以自己控制序列号, 自己定义后序列号就是固定的
  * 关键字 transient 修饰变量, 使其不被序列化(静态数据本来就**不**写入序列化)

* String、StringBuffer、StringBuilder**(很重要)**

  * String 是不可变字符串对象(固定的 char[])

  * StringBuffer(线程安全)和 StringBuilder 是可变字符串对象(内部的 char[]长度可变)

    > StringBuffer 用了 synchronized 修饰方法

  > 底层区别在于是否用 final 修饰 char[]

  * 当字符串相加操作或者改动少, 推荐使用 String
  * 反之, 建议使用 StringBuilder, 如果用了多线程, 则用 StringBuffer

  * 为什么 String 是 final 修饰的?

    > 为了实现字符串池, 因为只有字符串是不可变的, 字符串常量池才有可能实现
    >
    > 为了线程安全
    >
    > 为了实现 String 可以创建 hashCode 不可变性, 因为字符串不可变所以创建时 hashCode 就被缓存了, 无需计算

### 继承

* 继承就是子类继承父类的特征和行为, 使得子类对象(实例)具有父类的实例域和方法

* 或子类从父类继承方法, 使得子类具有父类相同的行为

* 成员变量

  * 子类存在就不找父类, 子类不能直接访问父类的私有变量(但可以间接使用get()访问)
  * super 关键字: 相对于 this 来说, this 是指向自身类变量, super 是指向父类变量
  * 对于父类 private 修饰的变量, 子类不能继承, 但是在创建子类对象时, 堆中会出现这些变量, 但是不能直接初始化, 只能通过父类的 this 对其初始化

* 成员方法

  * 当子父类中出现成员方法一模一样时, 会运行子类的函数, 这叫方法覆盖(重写)
  * 重写的注意事项
    * 子类权限必须大于等于父类权限
    * 静态只能被静态重写
  * 什么时候采用重写操作? 当对一个类中的方法进行扩展时, 可以建立一个子类对其方法进行扩展, 相当于更新操作

* 构造方法

  * **子类不能继承父类的构造方法**, 但**父类的构造方法带有参数的**则必须在子类的构造方法中显示地通过 super 调用父类构造方法, 并配以适当的参数列表, 且 super 必须在构造方法第一行

    ```java
    class A {
        public A(int a) {
    
        }
    }
    
    class B extends A {
        public B(int a) {
            super(a);
        }
    }
    ```

  * 如果父类有**无参构造器方法**, 则在子类的构造方法中用 super 调用父类构造方法不是必须的, 如果没有使用 super 关键字, 系统会**自动**调用父类的无参构诰方法(隐藏了super())

  * 子类的成员变量是在父类构造方法和变量进行初始化后, 才会去初始化子类的成员变量

    > 子类出生后, 第一件事是找父亲, 找到父亲再忙自己的事

### 抽象类

* 抽象类是对类的抽象, 里面可以包含抽象方法(只有声明, 没有具体的实现), 也可以包含正常类的变量

* 抽象类不能实例化, 抽象类是为了子类继承而存在的, 子类必须继承父类的抽象方法

* 子类必须重写抽象类中的所有抽象方法, 才能进行实例化

  > 否则子类里面还有继承父类的抽象方法, 所以子类是抽象类, 不能实例化

* 抽象类有构造函数吗? 有, 可以用来给子类进行初始化

* **抽象类可以不存在抽象方法吗? 可以, 目的是不让该类创建对象**

* 抽象关键字不可以和哪些关键字共存?

  * private, 如果方法都私有了, 子类怎么继承?
  * static, 不能和 abstract 一次修饰方法, 一个要求有具体实现, 一个要求不能有具体实现, 但是可以一起修饰类
  * final, 修饰的方法不能重写, 类不能被继承
  * 抽象类一定是父类, 因为抽象类想被使用则必须有类继承并重写其方法, 子类才能进行实例化

### 接口

* 接口是对行为的抽象

* 接口中的变量被隐性制定为 public static final, 方法被制定为 public abstract, 所以方法是不具体实现的

* 类可以实现多个接口, 这叫"多实现"

* 接口不能实例化, 只有实现类重写了接口中的所有抽象方法, 子类才能进行实例化对象, 否则这个实现类一定是个抽象类(因为里面有抽象方法)

* 本质上是提高子类的扩展性, 让子类可以实现更多功能的方法

* **接口之间可以多继承** ???

  > **因为不能多继承的本质是容易造成方法体的不确定性, 但是接口内没有方法体, 只有方法, 所以不存在不确定性**)

* 接口具有对外暴露的规则, 功能扩展, 降低耦合性, 多实现

* 抽象类和接口

  * 语法层面的区别

    * 抽象类可以提供成员方法的实现细节, 而接口中只能存在 public abstract 方法(接口更加抽象)

    * 抽象类中的成员变量可以是各种类型的, 而接口中的成员变量只能是 public static final

    * 接口中不能含有静态代码块以及静态方法(Java 8中可以了), 而抽象类可以有静态代码块和静态方法

      > 抽象类中可以有**包含方法体的静态方法**和**静态代码块**, 接口中可以有**包含方法体的静态方法**

    * 一个类只能继承一个抽象类, 而一个类可以实现多个接口

  * 设计层面对的区别

    * 抽象类是对一种事物的抽象, 即对类抽象, 而接口是对行为的抽象, 抽象类是对类整体进行抽象, 包括属性、行为, 接口是对类局部(行为)进行抽象

    * 抽象类作为很多子类的父类, 它是一种模板式设计, 而接口是一种行为规范
      >
      >继承是一个"是不是"的关系(共性关系), 而接口实现则是"有没有"的关系(额外功能)
      >
      >如果一个类继承了某个抽象类, 则子类必定是抽象类的种类, 而接口实现则是有没有、具备不具备的关系

* Comparable 和 Comparator

  > 实现 Comparable 接口的类对对象进行整体排序, 如果创建一个类时具有排序的属性, 最好实现 Comparable 接口
  >
  > 如果一个类已经没办法修改, 则可以采用比较器 Comparator, 在外部排序时指定排序规则

  ```java
  static class Person implements Comparable<Person> {
      private int age;
      @Override
      public int compareTo(Person o) {
          // 按年龄, 该方法返回负数则 this < o
          return this.age - o.age;
      }
  }
  
  public static void main(String[] args) {
      ArrayList<Person> list = new ArrayList<>();
      Collections.sort(list, new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
              // 按年龄, 该方法返回负数则 this < o
              return o1.age - o2.age;
          }
      });
  }
  ```

* 抽象类和接口**(重要)**

  * 抽象类(为了继承而存在)

    > 抽象方法必须为 public 或 protected(如果是 private 则无法继承并实现), 缺省时为 **public**
    >
    > 抽象类不能用来创建对象
    >
    > 一个类继承一个抽象类, 必须实现抽象类的抽象方法, 如果有未实现的抽象方法, 子类必须也声明为抽象类

  * 接口(更加抽象)

    > 变量只能定义为 public static final
    >
    > 方法只能是抽象的

  * 语法区别

    > 抽象类可以提供成员方法的具体实现, 接口只能提供方法定义
    >
    > 抽象类的成员变量类型无限制, 接口只能是 public static final
    >
    > 抽象类可以有静态代码块和静态方法, 接口不可以
    >
    > 一个类只能继承一个抽象类, 但可以实现多个接口

  * 设计区别

    > 抽象类是 is 关系, 接口是 has 关系
    >
    > 抽象类作为很多子类的父类, 是一种模板式设计, 接口是**行为规范**, 是一种辐射式设计

### 多态

* 一个对象对应着不同的类型, 比如猫既具备着猫的形态, 又具备着动物的形态

* 代码体现: 父类或者接口的引用指向子类对象(一种对象两种形态, 子类和父类的形态)

  ```java
  List<Integer> result = new LinkedList<>();
  ```

* 多态存在为了什么?

  > 简单的例子, 有一个方法, 就是动物吃饭的方法, 多态的存在, 就可以让只要是动物就可以调用, 比如猫、狗等, 不需要单独去制作猫吃饭的方法, 提高了代码的扩展性, 比如后来有个猪, 也可以直接去调用动物的吃饭方法

* 使用前提

  * 有关系, 继承或实现
  * 要有覆盖

* 向上转型: 前期定义的内容不能调用后期子类的特有内容

  > 对于猫来说, 相当于把猫类型提升到动物类型(向上转型), 所以只能使用动物所有的方法, 不能再去用猫的特有方法(抓老鼠), 向上转型限制功能, 转型之后, 只能使用子类和父类共有的方法, 那就是父类方法了

* 向下转型: 向上转型后, 如果想实现子类特有功能, 可以实现向下转型(把猫从动物类中转型为原来的子类猫), 转型后不仅能使用父类的方法, 还能使用自己特有方法

* 本质上在程序中只有一个子类对象, 子类向上转型成父类, 子类从父类向下转型成子类

* 多态的判断 Instanceof: 判断一个引用数据类型是什么, 比如判断这个动物是不是猫, 一般用在向下转型时, 增强程序健壮性

* 多态中的成员变量: 简单说, 都参考左边(父类)的类型(变量又没有覆盖, 该是谁的就是谁的)

* 多态中成员方法(非静态): 简单说, **编译看左边引用变量, 运行看右边的对象**

* 多态中静态方法: 静态方法相当于一个类, 不需要实例对象可以直接调用, 静态方法就是固定绑定在所属类中

### 内部类

* 访问特点: **内部类可以直接访问外部类的内容**, 但是外部类要想访问内部类必须建立内部类的对象

* 内部类修饰符: 内部类可以修饰为static, 那里面访问外部类变量必须是 static 的

  * 若内部类不加 static, 则相当于外部类的成员

    ```java
    Out.In a = new Out().new In();
    ```

  * 若内部类加上 static, 外部类就不需要建立对象进行访问了

    ```java
    Out.In b = new Out.In()
    ```

  * 若内部类中的方法是 static, 则内部类必须是static, 那内部类和外部类都不需要建立对象了

    ```java
    Out.In.function();
    ```

* 如果在外部类和内部类有同名的变量, 则想在内部调用外部的变量, 需要使用外部类名.this.

* 内部类在局部位置上只能访问局部中被 final 修饰的局部变量(内部类在外部类的成员方法中, 被称作局部位置)

* 匿名内部类: 如果内部类存在继承父类或者实现接口, 可以不用内部类去创建对象, 直接将所需的功能转化为匿名内部类

### 字符串

#### String

* **字符串对象一旦初始化就不会被改变**(是指等号右边)

  ```java
  String s = "abc"; // 创建一个字符串对象"abc"在常量池中
  String sl = new String("abc"); // 创建两个对象, 一个new对象和一个字符串对象在堆内存中
  ```

* 常见方法(只列举了之前很少用过的, 因为大部分常用方法都是见名知意的)
  * s.intern(): 如果字符串常量池中有 s 同内容的, 直接返回池中字符串, 没有则创建一个
  * s.concat(): 字符串连接
  * s.compareTo(): 比较字符串大小
  * ...

#### StringBuffer

* 长度可变, 可对字符串修改
* 常见方法
  * append(data): 从尾部追加
  * insert(index, data): 在指定位置插入
  * delete(start, end): 删除字符串中索引区间为[start, end)的内容
  * deleteCharAt(index): 删除指定位置
  * indexOf(data): 找出指定字符位置
  * charAt(index): 找出指定位置的字符
  * setLength(newLength): 设定缓冲区长度
  * reverse(): 逆序
  * ...
* 如果事先知道数据长度, 则可以在创建 StringBuffer 之前指定缓冲区大小, 相对于需要延长的会提高效率

* 与 StringBuilder
  * StringBuilder 没有同步方法, 通常用于单线程, 提高效率
  * StringBuffer 有同步方法, 多线程下安全, 效率相对较低
  * 除了同步问题, 其他没差别

#### 正则表达式

* 存在原因: 用于匹配任意格式的字符串

* 匹配: matches()

* 切割: split()

* 替换: replaceAll()

  > ==捕获组==的概念, 正则表达式中一个括号为一组, $1表示第一组, \$2表示第二组

  ```java
  String tel = "13690076383";
  String s = tel.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$3");
  System.out.println(s); // 136****6383
  ```

* 获取

  ```java
  Pattern pattern = Pattern.compile("a*b");
  Matcher matcher = pattern.matcher("aaaaaaab");
  boolean result = matcher.matches();
  ```

### 枚举

* 当需要用一个对象来表示各个信息, 就可以使用枚举类

* 枚举本质上是一个类, 枚举中的每个元素本质上就是类的一个实例

  ```java
  enum EnumDemo {
      BOSS, // EnumDemo BOSS = new EnumDemo();
      WORKER; // EnumDemo WORKER = new EnumDemo();
  }
  ```

* 如果要重写构造方法, 必须私有构造方法, 并放在实例对象下面

  ```java
  enum EnumDemo {
      BOSS("wang", 30), 
      WORKER("lia", 20);
      private String name;
      private int age;
      private EnumDemo(String name, int age) {
          this.name = name;
          this.age = age;
      }
  }
  ```

* 如果枚举的类有抽象方法, 实例对象必须重写

### 其他常用API

* System

  * currentTimeMillis(): 获取当前时间, 从1970.01.01-00:00:00到现在经过的毫秒数
  * getProperties(): 返回系统设置, 存储键值对<String, String>

* RunTime, 没有构造方法, 只有一个静态方法提供返回对象(单例), 用来打开程序、杀死进程

* Math

  * 取整操作: ceil(向上)、floor(向下)、round(四舍五入
  * 比较: max()、min()
  * 次方: pow(base, power)
  * 随机数: random() 取出[0.0, 1.0)的数

* Date

  * new Date(long date): 将毫秒数转为日期对象
  * setTime(long time)
  * getTime(): 将日期转为毫秒数
  * compareTo(Date another): 比较两个日期的顺序

* DateFormat

  * 日期对象转成日期格式字符串

    ```java
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateStr = format.format(new Date());
    ```

  * 将日期格式字符串转为日期对象

    ```java
    try {
        Date date = format.parse("2020-12-04 14:25:02");
    } catch (ParseException e) {
        e.printStackTrace();
    }
    ```

* Calendar

  * getInstance()

  * set(year, month, date, hour, minute, second)

  * get(日历字段)

    ```java
    calendar.get(Calendar.YEAR);
    ```

  * add(Calendar.DAY_OF_YEAR, 天数): 往前往后位移天数

## 集合

![image-20201203203740189](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201203203740189.png)

* 对对象进行存储, 如果对象个数不确定, 就出现了==集合容器==进行存储

* 用于存储对象的容器, 集合的长度是可以变化的

* 集合中不可以存储基本数据类型值

* 集合框架的顶层就是 Collection 接口

* Collection 的常见方法

  * boolean add(Object o)
  * boolean addAll(Collection coll)
  * remove(o)
  * removeAll(coll): 删除二者的交集
  * clear()
  * contains(o)
  * containsAll(coll)
  * isEmpty()
  * size()
  * iterator()
  * retainAll(coll): 取交集
  * ...

* 迭代器

  > 原理: 每一个容器内部的数据结构不同, 所以该迭代器对象应该是在容器内部实现的
  >
  > 对于使用容器而言, 具体的实现不重要, 只要通过容器获取到该实现的迭代器对象即可
  >
  > 也就是 iterator()
  >
  > Iterator 接口是对所有 Collection 进行元素取出的公共接口

### Map

* 存储键值对, 必须保证键的唯一性

* 常用方法 返回类型 方法名 K, V

  * V put(key, value): 如果 Map 中已经有键对应的值则将该值返回然后设置新值, 没有则直接设置新值并返回 null
  * void clear(): 清空集合
  * V remove(key): 根据键删除值, 如果键存在则返回值, 否则返回 null
  * boolean containsKey(key)
  * boolean containsValue(value)
  * boolean isEmpty()
  * V get(key)
  * int size()
  * keySet(): 获取所有键的集合
  * valueSet(): 获取所有值的集合
  * entrySet(): 获取所有键值对的集合

* Map 的常用子类

  * HashTable: 底层是哈希表, 同步, 不能空键空值

    > Properties 继承自 HashTable

  * HashMap: 底层是哈希表, 不同步, 可以空键空值

    > 子类 LinkedHashMap 是有序的

  * TreeMap: 底层是二叉树, 不同步, 可以对 key 进行排序

* JDK 1.5 新特性

  * for (类型 变量 : 数组或集合)

    > 不能直接用这种 for 语句遍历 map, 需要转为 set

  * 函数可变参数: 返回类型 函数名(类型... 变量)

    > 也就是用类似于 int... arr 代替 int[] arr, 好处是不用传递数组, 而可以直接传递数组元素

#### HashMap

> **很重要**

* 原理及内部数据结构

  > HashMap 内部存储结构是**数组和链表**的结合(Java 8之后加入红黑树, 时间开销O(log n)到 O(n))

  * 实例化一个 HashMap 时, 系统会创建一个长度为 capacity(容量) 的 entry 数组
  * 在这个数组中可以存放元素的位置称为 bucket(桶)
  * 每个桶都有自己的索引, 系统根据索引快速查找桶中的元素
  * 每个桶存储一个元素(一个 entry)
  * 每个 entry 可以带一个引用变量, 指向下一个元素, 因此桶中可能有 entry 链

* put(key, value)

  * 对 key 求哈希值然后计算索引(下标)
  * 如果没有==哈希冲突==(哈希碰撞)则直接放入桶中
  * 如果发生了冲突则以链表的形式链接上
  * 如果链表长度超过阈值(默认是8)就把链表转为==红黑树==
  * 如果节点已存在则是替换旧值
  * 如果桶满了(容量 * 加载因子), 就需要 resize()

  > 首先算得 key 的 hashCode, 然后跟数组长度 - 1做与运算(&)
  >
  > 比如数组长度是2的4次方, 那么 hashCode 就会和2的4次方-1做与运算

  ```java
  static int indexFor(int h, int length) {  
      return h & (length - 1);  
  }
  ```

  > 为什么要 & (length - 1)?
  >
  > 长度为2的次幂时, length - 1 所有位为1, 此时只要输入 hashCode 本身均匀, 哈希算法的结果就均匀, 结果等同于 hashCode 的后几位数, 此外, 位运算也比取模运算快

  > **为什么 HashMap 的数组初始化大小是2的次方大小时效率最高?**
  >
  > 以2的4次方举例, 看下图，左边两组数组长度为16(2的4次方), 右边为15
  >
  > 两组的 hashCode 均为8和9, 但是很明显, 当它们和1110与的时候, 产生了相同结果, 也就是它们会定位到数组中的同一个位置产生碰撞, 8和9会被放到同一个链表上, 那么查询时就需要遍历这个链表得到8或者9, 降低查询效率
  >
  > 同时也可以发现, 当数组长度为15的时候 hashCode 会与14(1110)进行与, 最后一位永远是0, 0001, 0011, 0101, 1001, 1011, 0111, 1101 这几个位置永远都不能存放元素, 空间浪费大, 更糟的是这种情况数组可使用的位置比数组长度小了很多, 意味着进一步增加碰撞几率, 减慢查询效率
  >
  > ![点击查看原始大小图片](http://dl.iteye.com/upload/attachment/177481/4b3732d6-fb5f-369b-b50d-e8b8325c69d4.jpg)
  >
  >
  >
  > 当 HashMap 的元素越来越多, 碰撞几率越来越高(因为数组的长度是固定的), 为了提高查询效率, 要对数组进行扩容, 这个操作也会出现在 ArrayList 中, 所以是一个通用操作
  >
  > 在 HashMap 数组扩容后, 最耗性能的点出现了: 原数组中的数据必须重新计算在新数组中的位置并放进去, 这就是 resize
  >
  > **那 HashMap 什么时候扩容?**
  >
  > 当 HashMap 中元素个数超过(**数组大小 * loadFactor**)时就会进行数组扩容, loadFactor 默认值为0.75, 也就是默认情况下, 数组大小为16, 当 HashMap 元素个数超过 16 * 0.75 = 12 时, 就把数组的大小扩展为2 * 16 = 32, 即扩大一倍, 然后重新计算每个元素在数组中的位置, 这是非常消耗性能的操作, 所以如果已经预知 HashMap 中元素的个数, 那么预设元素个数能够有效提高 HashMap 的性能
  >
  > 比如, 有1000个元素 new HashMap(1000), 但是理论上来讲 new HashMap(1024)更合适, 不过即使是1000, HashMap 也自动会将其设置为1024, 但是new HashMap(1024)还不是更合适的, 因为0.75 * 1000 < 1000, 为了让0.75 * size > 1000, 必须new HashMap(2048)才最合适, 既考虑了位运算问题, 也避免了 resize 问题

* **问: HashMap 的哈希函数是如何实现的? 还有什么哈希算法?**

  > \>>> 表示==无符号右移==, 逻辑右移, 即**右移后高位补0**

  ```java
  static final int hash(Object key) {
      int h;
      return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }
  ```

  > hashCode()高16位不变, 低16位和高16位做异或获得哈希值, 然后((数组长度 - 1) & h)得到下标

  * 直接定址法: 直接以 key 或者 key 加上常数作为哈希地址
  * 数字分析法: 提取 key 中取值比较均匀的数作为哈希地址
  * 除留余数法: 用 key 除以某个不大于哈希表长度的数, 余数作为哈希地址
  * 分段叠加法: 按照哈希表地址位数将 key 分成位数相等的几部分, 最后一部分可以比较短, 然后这几部分相加, 舍去最高位进位后的结果作为哈希地址
  * 平方取中法: 求出 key 的平方, 按需求取出中间几位作为哈希地址
  * 伪随机数法: 采用一个伪随机数作为哈希地址

* 如何解决哈希冲突?

  * HashMap 使用==链地址法==, 将所有哈希地址相同的记录都链接在同一链表中(同一桶的链表)
  * 开放地址法: 查找数组的空位, 将数值填充进去,而不用哈希函数得到的下标
  * 再哈希法: 二次哈希, 使用哈希函数不同
  * 建立公共溢出区: 把冲突的都放在另一个地方, 不在表里面

* HashMap 的线程并发安全问题

  * 如果**多个线程同时使用 put()添加元素并且发生了哈希冲突**(根据哈希计算后将放入同个桶), HashMap 会将其加到同个位置, **最终其中一个线程 put()的数据被覆盖**
  * 如果多个线程同时检测到元素个数超过数组大小 * loadFactor, 就会发生多个线程同时对数组进行扩容, 都在重新计算元素位置以及复制数据, 但最终只有一个线程扩容后的数组会赋给表, 也就是其他线程的会丢失, 并且各自线程 put()的数据也会丢失

  > 如何实现并发安全的 HashMap?

* HashMap 底层使用了红黑树, 简述红黑树的五大特征(几何操作的时间复杂度均为O(log n))

  * 节点要么为红色, 要么为黑色
  * 根节点为黑色
  * 叶节点为黑色
  * 每个红色节点的左右子节点都是黑色(保证从根节点到叶节点不会连续出现两个红色节点)
  * 从任意节点到其每个叶节点的所有路径, 都包含相同数目的黑色节点

  > 4和5是使红黑树是平衡树的关键

* 红黑树和AVL(自平衡二叉查找树)

  * 红黑树不追求完全平衡, 只要求部分平衡, 降低对旋转的要求, 提高性能
  * 红黑树的算法时间复杂度和AVL相同, 但统计性能比AVL高
  * 针对插入和删除节点导致失衡后的 rebalance, 红黑树最多只需要旋转3次, O(1)
  * 实际应用中, 如果搜索的次数远大于插入和删除, 则选择AVL, 如果差不多则选择红黑树

* HashMap、LinkedHashMap、TreeMap

  * LinkedHashMap 拥有 HashMap 所有特性, 比 HashMap 多维护了一个双向链表, 因此可以按照插入的顺序从头或尾迭代, 且内存比 HashMap 大, 性能差一些
  * TreeMap 底层是红黑树, 在需要有序 Map 集合时采用

* HashMap 扩容

  * JDK 1.7时扩容会重新计算哈希值, key % 新长度, 会有大量重复计算

  * JDK 1.8优化, 不需要重新计算, 只需要看原来的哈希值新增的那个 bit 是1还是0, 是0的话索引不变, 是1的话索引变为"原索引 + oldCap", 并且引入红黑树, 重构长度大于一定值时就会转为红黑树

    > 会将原来的链表同过计算 hash & oldCavp == 0 分成两条链表, 再将两条链表散列到新数组的不同位置上
    >
    > 扩容前数组长度为8, 扩容为2倍即16, 原来有一条链表在tab[2]的位置, 扩容后仍然有一条链在 tab[2]的位置, 另外一条链在 tab[2 + 8]即 tab[10]

    ![image-20201128153231484](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201128153231484.png)

* HashSet 本质还是 HashMap

### List

* Collection 的子类接口

* 有序, 即存入和取出的顺序一致, 有索引, 元素可重复(Set 不可重复)

* 相对于 Collection, 除了增删查, 扩展了位置索引和修改数据(set())

* 有自己特定的 listIterator()

  > 普通迭代器不允许在遍历时修改或添加数据, listIterator()则可以

* List 实现类

  * Vector: 底层是数组, 是同步的, 最老版本的, 几乎不用了
  * ArrayList: 底层是数组, 不同步, 替代了 Vector, 查询速度快
  * LinkedList: 底层是链表, 不同步, 增删速度快

* ArrayList 和 LinkedList

  * ArrayList 是实现了基于动态数组的数据结构, LinkedList 是基于链表的数据结构
  * 对于随机访问 get()和 set(), ArrayList 优于 LinkedList, 因为 LinkedList 要移动指针
  * 对于新增和删除操作 add()和 remove(), LinkedList 更优, 因为 ArrayList 要移动数据

### Set

* Set 是 Collection 的子类接口, 元素不可重复, 无序

* HashSet 底层是哈希表, 不同步

* LinkedHashSet 是 HashSet 的子类, 有序

* 哈希表判断元素是否相同

  1. 先通过 hashCode() 得出哈希值, 哈希值不同则元素不同
  2. 若哈希值相同, 则需要 equals() 判断

* TreeSet 是 Set 的子类接口, 可以对元素进行排序, 不同步, 元素以二叉树形式存放

  > 排序方法
  >
  > 让 TreeSet 元素的类实现 Comparable 接口以及 compareTo()
  >
  > 或者直接给 TreeSet 构造方法传入比较器对象 Comparator

### 工具类

* Collections

  * sort()

  * swap(list, i, j)

  * binarySearch(List<? extends Comparable<? super T>> list, T key)

  * \<T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)

  * max(), min()

  * replaceAll()

  * reverseOrder(): 返回一个比较器, 强硬逆转实现了 Comparable 接口的对象 collection 的自然顺序

    ```java
    Comparator<Object> reverseOrder = Collections.reverseOrder();
    ```

  * shuffle(list): 对元素进行随机排列

  * synchronizedCollection(coll): 返回指定集合支持的线程安全的集合对象

* Arrays

  * binarySearch()
  * \<T> T[] copyOf(T[] original, int newLength)
  * equals(arr1, arr2)
  * sort()
  * asList(): 将数组转为列表
    * 数组元素是基本数据类型时, 将数组作为集合元素存储
    * 数组元素是对象时, 将数组的元素作为集合元素存储

## 泛型

* 将运行时期的问题(类型转换异常)转到了编译时期, 避免了强制转换的麻烦

* **泛型技术是给编译器使用的技术, 用于编译时期, 确保类型安全, 运行时会将泛型去掉**

* 产生的 class 文件中不带泛型, 这叫==泛型的擦除==

  > 为什么擦除? 为了兼容类加载器

* 泛型补偿: 在运行时通过获取元素的类型进行转换动作, 不需要使用者强制转换

  > 个人理解: 泛型就用一个符号或者具体对象指定了各种集合或比较器等中所操作的元素类型, 编译时就能检测操作对象是否符合泛型的指定, 提高了安全性

* <> 的作用: 就是一个用于接受具体引用数据类型的参数范围

  > 在程序中, 只要用到了带有<>类或者接口, 就要确定引用数据类型

* 泛型类: 当类中的操作的引用数据类型不确定的时候, 就使用泛型来表示

  ```java
  class Tool<T> {}
  ```

* 泛型方法: 在方法上定义泛型, 可以接受所有类型的对象

  ```java
  public <T> void method(T t) {}
  ```

* 泛型接口: 在接口声明后定义泛型, 在实现接口时或者实例化对象时指明泛型具体类型

* 泛型的通配符<?>和泛型上下限定

  > 一般存储元素都是指定上限, 这样取出的元素按上限运算不会出现类型安全问题
  >
  > 一般取出数据时用 super

  ```java
  public void method(List<? extends Person>) {}
  public void method(List<? super Person>) {}
  ```

## IO

### 常见流

* 字节流和字符流

  > 字节流: 以字节为单位的输入输出流
  >
  > 字符流: 字节流在读取文字字节数据后不直接操作而是查询指定编码表获取相应文字, 也就是字节流 + 编码表

  * 字节流可用于任何类型的对象, 包括二进制对象
  * 字符流只能处理字符或者字符串
  * 字节流提供了处理任何类型的IO操作功能, 但它不能直接处理 Unicode 字符, 而字符流可以
  * 字节流的顶层父类: InputStream、OutputStream
  * 字符流的顶层父类: Reader、Writer

* 字符流操作

  * FileWriter

    * write(data)

    * flush(): 刷洗缓冲区

      > 如果**中途调用`close()`**, **输出区还是有数据**, 在缓冲区遗留了一部分
      >
      > 如果**先调用`flush()`**, 就会**强制把数据输出**, 缓存区清空, 最后再关闭读写流调用 close() 就OK

    * close()

  * FileReader

    * read(): 按单个字符读取
    * read(char[]): 按字符数组读取

* BufferedWriter(运用了装饰器模式)

  > 借助缓冲区将数据缓存, 提高数据读写效率

  ```java
  new BufferedWriter(new FileWriter("hello.txt")).newLine(); // 写入一个换行符
  ```

* BufferedReader

  ```java
  try {
      BufferedReader reader = new BufferedReader(new FileReader("hello.txt"));
      reader.readLine(); // 读取新的一行, 不包含换行符, 结尾时返回null
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  }
  ```

* 流操作和缓冲区

  * 流操作: 直接将内存和硬盘建立连接
  * 缓冲区: 以读数据为例, 将数据从硬盘中通过流操作读入到内存缓冲区, 然后通过缓冲区方法区处理缓冲区的数据
  * 利用缓冲区效率更高

* 编码

  * 编码规则发展历史

    > 计算机是美国发明的, 最初是用1个字节表达英文字母和符号(ASCII), 后来中国开始使用计算机, 先是对 ASCII 进行了扩充, 用2个字节表示一个汉字, 先后出现了GB2312(常用简体)、GBK(包括繁体和生僻字)、GB18030(少数名族)编码格式, 后来世界各地都有了自己的编码格式, 之间没法互相交流了
    >
    > 所以 ISO 国际标准组织开始统一世界编码, 最初是 UNICODE(所有字符都是2个字节, 英文就浪费存储资源了), 长时间很难推广, 直到互联网出现了, 网络传输 UTF-8 和 UTF-16 对 UNICODE 进行了算法转换, 采用可变字节的编码方式, 比如字母就是一个字节, 汉字是3个字节
    >
    > 但是中国一般还是使用 GBK, 用来处理汉字; 在 IDEA 中默认编码是 UTF-8

  * 如果想要指定编码格式, 必须使用转换流(从字符数据到字节数据中间存在一个编码表)

    > 不能直接用 FileWriter 等, 因为使用的是本地编码

    ```java
    try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("hello.txt"), StandardCharsets.UTF_8));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    ```

### File

* getName(): 文件名

* getPath(): 相对路径

* getAbsolutePath(): 绝对路径

* length(): 长度

* lastModify(): 最近修改时间

* File.listRoots(): 系统根目录

* getTotalSpace(): 磁盘容量

* list(): 返回由此抽象路径名所表示的目录中的文件和目录的名称所组成字符串数组

* listFiles(): 返回表示此抽象路径名所表示目录中的文件和目录的**抽象路径名数组**

* 过滤器, list(new 过滤器())

  ```java
  String[] list = new File("E:/").list((dir, name) -> name.endsWith(".mp3"));
  ```

* 自己实现递归删除目录下的所有文件 removeAll(File file)

  ```java
  public void removeAll(File file) {
      File[] files = file.listFiles();
      for (File f : files) {
          if (f.isDirectory()) {
              removeAll(f);
          } else {
              f.delete();
          }
      }
      // 来到这里时这层目录都删除了
      file.delete(); // 将自己删除
  }
  ```

### Properties

* HashTable 的子类, 键值类型都是 String

* 持久化 store()

  ```java
  new Properties().store(new FileOutputStream("prop.txt"), "注释");
  ```

* 读取配置信息

  ```java
  new Properties().load(new FileInputStream("prop.txt"));
  ```

### 与NIO

> 重要

* 标准 IO 基于字节流和字符流进行操作

* NIO 基于 Channel 和 Buffer 操作, 数据从通道读到缓冲区, 或者从缓冲区写入通道

* 异步IO: Java NIO 可以让我们异步地使用 IO, 线程从通道读取数据到缓冲区时, 线程可以进行其他操作

* NIO 引入了 Selector, 用于监听多个通道的事件(比如连接打开、数据到达), 因此单个线程可以监听多个通道

* IO 与 NIO

  * 面向流与面向缓冲区

    > 面向流意味着每次从流中读取字节直到读完, 没有缓存的地方, 也不能前后移动流中的数据

    > 面向缓冲区意味着将数据读到一个稍后处理的缓冲区, 需要时可在缓冲区前后移动, 增加处理的灵活性, 但是需要检查缓冲区是否包含需要的数据, 且需要确保更多数据读入缓冲区时不会覆盖尚未处理的数据

  * 阻塞与非阻塞

    > IO 是阻塞的, 当一个线程调用 read()或 write()时阻塞, 直到有一些数据被读取或者写入完全, 期间无法做其他操作

    > NIO 是非阻塞的, 使一个线程从某通道发送请求读取数据, 但是仅能得到目前可用的数据

  * Selector

    > NIO 的选择器允许一个单独的线程来监听多个输入通道, 可以注册多个通道使用一个选择器, 然后用单独的线程来选择通道, 使一个单独的线程容易管理多个通道

## 异常

* 异常: 在运行时期发生的不正常的情况

* 异常类: 描述不正常的类

* 将各个异常类的共性向上抽取, 形成异常体系

* 最终不正常的情况就分为两个类

  ![image-20201202213620027](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201202213620027.png)

* Throwable: 将问题抛出让调用者知道并处理, 凡是 throw/throws 关键字可以操作的类或对象就具有可抛性

* Error(一般不可处理)和 Exception(可以处理的)

* Error: 由 JVM 抛出的严重性问题, 一般不针对性修改, 直接修改程序

* 异常体系

  > 一个父类 Throwable, 下面有两个子类 Error、Exception, 每个子类下面还有很多子类

* 异常的原理

  > 当出现异常时, JVM 会建立相关对象并将异常信息抛给调用者, 如果该调用者没有对信息进行处理, 则继续将信息抛给 JVM, 最终 JVM 将信息打印在控制台

* 异常的抛出

  * throw new 类: 将指定类的内容抛出
  * throws 在方法形参列表后使用, throw 在方法体中使用
  * throws 用来抛出一个或多个异常类, throw 用来抛出异常对象

* 自定义异常

  1. 创建自定义异常类
  2. 在方法中通过 throw 关键字抛出异常对象
  3. 如果在当前抛出异常的方法中处理异常, 可以使用 try-catch 语句捕获并处理; 否则在方法的声明处通过 throws 关键字指明要抛出给方法调用者的异常, 继续进行下一步操作
  4. 在出现异常方法的调用者中捕获并处理异常

* 异常分类: Java 编译器先检查语法错误, 再进行异常等问题检测

  * 编译时异常(可查异常): Exception 的子类(除去 RuntimeException 体系), 这种问题希望在编译时进行检测, 进行对应的处理方式(必须使用 try-catch 捕获或者 throws 抛出)

  * 运行时异常(不可查异常之一): RuntimeException 和其子类

    > 这种问题无法让功能进行继续, 这种问题编译器不会检查, 运行时让调用者调用程序强制停止, 让调用者修改程序, 不需要 throws 进行声明, 也不需要捕获, 但是可以进行捕获
    >
    > 总体来说, Java 规定: 允许忽略不可查的 RuntimeException 和 Error

* finally 中的代码一定会执行, 就算 catch 里有 return 也会执行, 但是当 System.exit(0) 会退出虚拟机, 则不会执行

* 异常转换: 将一个内部异常转化为对方可以理解的异常, 也叫做异常封装, 对外不暴露出内部的异常, 转换出外面可以处理的异常

* 注意事项

  * 子类重写父类方法时, 如果父类方法抛出异常, 子类方法只能抛出父类的异常或者该异常的子类
  * 如果父类抛出多个异常, 子类只能抛出父类异常的子类

  > 总之子类重写父类只能抛出父类异常或子类或子集, 如果父类方法没有抛出异常, 子类一定不能抛, 只能 try

* finally 代码块在 return 中间执行, return 的值会被放入临时空间, 然后执行 finally 代码块

  如果 finally 中有 return, 会刷新临时空间的值, 方法结束返回临时空间值

  > 以下代码输出: 1, 3, 2

  ```java
  public static void main(String[] args) {
      System.out.println(test());
  }
  
  private static int test() {
      int temp = 1;
      try {
          System.out.println(temp);
          return ++temp;
      } catch (Exception e) {
          System.out.println(temp);
          return ++temp;
      } finally {
          System.out.println(++temp);
      }
  }
  ```

## 包(Package)

* 概念: 如果两个类名称一样, 可以使用包的概念, 多层命名空间, 类的全称: 包名.类名(相当于文件夹内放了一个类)

* 建立包: 放在内容的第一行, package 包名(包名一般全小写)

* 包与包之间的访问

  * 包中类和方法必须是 public(继承有 protected 修饰方法)
  * 使用或者访问时要带上包名.类名
  * 包与包之间进行继承, 父类必须带上包名, 或者 import
  * 继承权限 protected 修饰方法, 只能有其子类进行访问, 其他不能访问

* 权限关键字问题

  > default 这不是一个存在的权限关键字, 而是空着不写代表 default
  >
  > "子类中"的意思是在不同包之间的继承关系

  |          | public | protected | default | private |
    | :------: | :----: | :-------: | :-----: | :-----: |
  | 同一类中 | 可访问 |  可访问   | 可访问  | 可访问  |
  | 同一包中 | 可访问 |  可访问   | 可访问  |         |
  |  子类中  | 可访问 |  可访问   |         |         |
  | 不同包中 | 可访问 |           |         |         |

* import: 在包与包之间访问时, 可以在内容开始时用 import 导入包中的类文件, 在使用该类时就不用在类名前写包名, 简化类名

## 反射

* 反射就是在**运行时**能够知道一个类的所有属性和方法, 能够调用一个对象的所有方法和属性(且能修改属性)

* Class.forName(className)和 ClassLoader.getSystemClassLoader().loadClass(className)
  * forName()除了将类的.class 文件加载到 JVM 中之外, 还会对类进行解释, 执行类中的静态部分, forName()得到的类已经是初始化完成的
  * loadClass()只将类的.class 文件加载到 JVM 中, 只在 newInstance()时才会执行静态部分
  * 最重要的区别是 forName()会初始化 Class, loadClass()不会
  * **如果要求加载时类的静态变量被初始化或静态代码块被执行就只能用 forName()**

* 内部原理

  * 有一个类名为 ==Class==, 可以读出一个类文件的字节码文件的内容
  * 反射依靠这个 Class 类完成, 只要获取字节码文件, 通过 Class 类就可以获取其中的内容, 如字段、方法等

* 获取字节码文件对象三种方法

  * Object 类的 getClass()
  * 任何数据类型都有一个静态属性 .class 获取对应的 Class 对象
  * 给定类的全限命名, 通过 Class.forName(className) 获取 Class 对象

* 获取字节码文件的构造方法(把构造方法封装成了对象 Constructor)

  * 根据空参构造方法创建对象, 如果字节码中类没有空参构造方法则会发生 InstantiationException

    ```java
    Object obj = clazz.newInstance();
    ```

  * 获取指定参数的构造方法并创建对象

    ```java
    Constructor constructor = clazz.getConstructor(String.class, int.class);
    Object obj = constructor.newInstance("小明", 20);
    ```

* 获取字节码文件中的字段(类 Field)

  ```java
  Field field = clazz.getDeclaredField("age"); // 可获取所有字段包括私有
  // getField(fieldName) 不能获取私有字段
  field.setAccessible(true); // 暴力访问, 取消私有化权限, 之后可以获取指定字段的值
  field.get(obj); // 获取obj的field值
  ```

* 获取字节码文件中的方法(类 Method)

  ```java
  Method method = clazz.getDeclaredMethod("getName", null);
  Object name = method.invoke(obj, null); // 相当于 obj.method(null)
  ```

## 多线程

* 进程: 正在进行的程序(本质上, 在内存里面开辟了一片运行空间
* 多线程: **线程是进程中的一个负责程序执行的运作单位**, 有多个就叫多线程(一个进程当中至少有一个线程)
* 任务: 每一个线程都有自己运行的内容, 这个内容就是线程要执行的任务
* 多线程的优劣
  * 一方面, 解决了多个部分同时运行的问题, 实际上是 CPU 在多个线程之间切换完成的, 这个切换是随机的
  * 另一方面, 线程太多会使效率降低
* **JVM 中多线程解析: 虚拟机存在多线程, 至少有两个, 一个主线程, 一个负责==垃圾回收==的线程**

### 创建方式

* 多线程的第一种创建方式: 继承 Thread 类

  1. 定义一个类继承 Thread 类
  2. 重写 Thread 类中的 run()
  3. 直接创建 Thread 的子类对象创建线程
  4. 直接调用 start() 来开启线程并调用线程的任务 run(), 调用 start() 自动会去执行 run()

  > 注意: 直接调用 start() 和直接调用 run() 的区别
  >
  > start()是开启一个线程, 会自动运行 run() 中的任务
  >
  > 但如果直接调用 run(), 并没有开启一个线程, 只是简单调用一个类中的方法, 线程仍然是主线程

* 线程名称

  * 可以使用 getName()来获取当前线程的名字, 默认名字编号是 Thread-序号
  * Thread.currentThread()获取当前线程的对象
  * Thread 有带字符串参数的构造函数, 可以对线程的对象进行命名, 子类用 super 进行调用

* 多线程的运行栈内存情况

  > 当开启多个线程时, **每个线程在栈内存中都开辟一个单独的栈区**(一条单独的路, 用于该线程中方法的进栈出栈), 多个线程就有多个栈区(多条路)
  >
  > 其中如果一个线程出现问题了, 只是当前问题线程的栈区弹出总栈区, 其他线程仍然在栈内(一条路不通了其他路还在继续)

* CPU 的执行资格: 可以被 CPU 处理, 在处理队列中排队; CPU 的执行权: 正在被 CPU 处理

  * sleep(time): 带有时间的冻结, 到了时间就会进入运行或者临时阻塞(排队)状态
  * wait() 和 notify(): 不带时间的冻结, 冻结之后, 人为去唤醒才行, 之后进入运行或者临时阻塞(排队)状态

* 线程的生命周期

  * 出生状态: 用户在创建线程时所处的状态, 在用户使用该线程实例调用 start() 方法之前, 线程都处于出生状态

  * 就绪状态: 也称可执行状态, 当用户调用 start() 方法之后, 线程处于就绪状态

  * 运行状态: 当线程**得到系统资源**后进入运行状态

  * 等待状态: 当处于运行状态下的线程调用 Thread 的 wait() 时, 该线程就进入等待状态

    > 进入等待状态的线程必须调用 Thread 的 notify() 方法才能被唤醒
    >
    > notifyAll() 将所有处于等待状态下的线程唤醒

  * 休眠状态: 当线程调用 Thread 的 sleep() 时, 则进入休眠状态

  * 阻塞状态: 如果一个线程在运行状态下发出 IO 请求, 该线程将进入阻塞状态, 在 IO 结束时, 线程进入就绪状态

    > 对阻塞的线程来说, 即使系统资源关闭, 线程依然不能回到运行状态

  * 死亡状态: 当线程的 run() 执行完毕, 线程进入死亡状态

* 多线程的第二种创建方式: 实现 Runnable 接口

  > 如果想要仅仅实现类中的一部分任务进行多线程, 则使用该方式
  >
  > 所以, 使用接口将这段任务进行了对象封装

  1. 定义类实现 Runnable 接口

  2. 重写接口的 run(), 将任务代码封装到 run()

  3. 通过 Thread 类创建对象, 并将 Runnable 接口的实现类对象作为 Thread 类中构造方法的参数进行传递

     > 为什么要这样? 是为了将定义类中的 run()与 Thread 类中 run()建立联系

  4. 调用线程对象的 start() 开启线程

  > 实现 Runnable 接口的好处: 将线程的任务从线程的子类中分离出来, 进行单独的封装(面向对象的思想, 将任务封装成了对象); 避免了单继承的局限性

### 线程安全问题

* 产生的原因: 多个线程在操作共享的数据, 操作共享数据的代码有多条

* 同步代码块解决安全隐患

  * 思想: 就是将多条操作共享数据的代码封装起来, 当一个线程处理这些封装代码时其他线程不得参与运算, 必须当前线程执行完之后才可以执行其他的线程

  * 同步的前提: 必须有多个线程并且使用同一个对象锁

  * 同步的弊端: 相对效率低, 因为同步外的线程都会判断同步锁

    > 对象锁住后, 其他线程也会取得执行权, 并会不断判断同步锁的状态

* 同步方法解决安全隐患

  * 方法: 直接在方法名前加上修饰符 synchronized
  * 同步方法的锁就是 this

* 同步方法锁是固定 this, 同步代码块锁是任意的对象

* 静态同步方法的锁是该方法所属字节码文件对象, 可以用 this.getClass()获取, 也可以用类名.class表示

* 多线程==死锁==

  * 原因: 同步锁的嵌套是导致死锁的原因之一
  * 死锁代码分析: 两个线程 A 和 B, A 需要锁1和锁2, B 需要锁2和锁1, 如果 A 拿到锁1等待锁2, B 拿到锁2等待锁1, 则此时双方都占有对方需要的锁, 且都等对方释放资源


### 多线程通信

> 等待唤醒机制

* 涉及的方法

  * wait(): 让线程处于冻结状态, 被 wait 的线程会被存储到线程池中
  * notify(): 唤醒线程池中的一个线程(任意)
  * notiyAll(): 唤醒线程池中的所有线程

* 以上涉及的方法都必须定义在同步内

* 因为这些方法都是用于操作线程的状态, 必须要明确到底是**操作哪个锁上的线程**

* 为什么操作线程的方法是定义在 Object 类中?

  > 因为这些方法是监视器的方法, 其实就是锁的方法, 也就是任意对象的方法, 所以定义在 Object 类中

* 多生产者多消费者

  * while 判断标记, 解决了线程获取执行权后, 是否要运行(if 判断只有一次, 会导致不该运行的线程运行了, 出现数据错误)
  * notifyAll() 解决了本方线程一定会唤醒对象线程, notify()只唤醒一个线程, 如果唤醒了本方线程, 并使用 while 判断的话, 就会导致线程死锁

* JDK 1.5 新特性

  * Lock: 用面向对象的思想, 用 lock 对象显性锁替换了原来的 synchronized 的隐性锁

    ```java
    Lock lock = new ReentrantLock();
    lock.lock(); // 获得锁
    try {
        // 同步代码
    } finally {
        lock.unlock(); // 必须释放锁
    }
    ```

  * Condition: 三个方法, await()、singal()、singalAll(), 相当于 Object 中的唤醒方法, 但是这些方法是和 Lock 对象通过其方法 newCondition 绑定在一起的

    ```java
    Condition condition = lock.newCondition();
    try {
        condition.await();
        condition.signal();
        condition.signalAll();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    ```

  * 一个对象(Object)锁对应一个监视器, 监视器唤醒是所有同步线程中随机一个
  * 锁(Lock)与同步方法中基本一致, 但是每个锁可以创建多个监视器, 每个监视器有自己的唤醒方法 await()、singal()、singalAll()

* 多线程中 wait() 和 sleep()

  * wait()可以指定时间, 也可以不指定; sleep()必须指定时间
  * 在同步中, **wait()之后释放执行权、释放锁; sleep()释放执行权, 不释放锁**

* 如果在同步中, 三个线程都被 wait(), 如果又同时被 notifyAll(), 会不会造成问题?

  > 不会, 因为**同一时间只会有一个线程获得执行权**, 然后获得同步中的锁去向下执行程序, 其他线程只有在当前线程释放锁之后, 才有可能执行

* 线程停止方式

  * stop()可以停止线程, 但是很不安全
  * run()结束: 一般 run()中有循环结构, 只要控制住循环就可以结束任务, 定义标记, 让循环在一定条件下结束
  * 强制唤醒: 可以使用 interrupt()将线程从冻结状态恢复到运行状态, 但是会发生 InterrupttedException
  * 守护线程: setDaemon(), 也叫做后台线程, 只要其他所有线程结束, 后台就会自动消失

* 多线程的其他方法

  * join(): 临时加入一个线程运算时可以使用, 加入到当前线程的话, 当前线程会进入冻结状态, 等加入的线程执行完后才结束冻结状态
  * yield(): 暂停当前线程

* 线程优先级: 1-10, 默认是5

* **CountDownLatch** 允许一个线程或多个线程等待特定情况, 同步完成线程中其他任务

* **CyclicBarrier** 和 CountDownLatch 一样都可以协同多个线程, 让指定数量的线程等待其它所有线程都满足某些条件之后才继续执行

* Java 中的线程安全, 就是线程同步的意思

  > 就是当一个程序对一个线程安全的方法或者语句进行访问时, 其他线程不能再对它进行操作, 必须等到这次访问结束以后
  >
  > 什么叫线程安全: 如果你的代码所在的进程中有多个线程同时运行, 而这些线程可能会同时运行这段代码, 如果每次运行结果和单线程运行的结果是一样的, 而且其他变量的值也和预期的是一样的, 就是线程安全的
  >
  > 或者说, 一个类或者程序所提供的接口对于线程来说是==原子操作==, 或者多个线程之间的切换不会导致该接口的执行结果存在二义性, 也就是说不用考虑同步的问题
  >
  > 线程安全问题都是由全局变量及静态变量引起的, 若每个线程中对全局变量、静态变量只有读操作而无写操作, 一般来说这个全局变量是线程安全的; 若多个线程同时执行写操作, 一般都需要考虑线程同步, 否则可能影响线程安全

* 生产者消费者模式

  * 用 synchronized 对存储加锁, 然后用 Object 的 wait()和 notify()做同步
  * 用 JUC 的 Lock 加锁, condition 的 await()和 signal()做同步
  * 使用 BlockingQueue
  * 使用 PipedInputStream / PipedOutputStream
  * 使用信号量 semaphore

  ```java
  public class ProducerAndConsumer {
      private final int MAX_LEN = 10;
      private Queue<Integer> queue = new LinkedList<>();
  
      class Producer extends Thread {
          @Override
          public void run() {
              produce();
          }
  
          private void produce() {
              while (true) {
                  synchronized (queue) {
                      while (queue.size() == MAX_LEN) {
                          queue.notify(); // 通知消费者来消费
                          System.out.println("当前产品队列已满");
                          try {
                              queue.wait(); // 生产者等待
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                      queue.add(1); // 生产一个产品
                      queue.notify(); // 通知消费者来消费
                      System.out.println("生产者生产一个产品, 当前队列长度" + queue.size());
                      try {
                          Thread.sleep(500);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
          }
      }
  
      class Consumer extends Thread {
          @Override
          public void run() {
              consume();
          }
  
          private void consume() {
              while (true) {
                  synchronized (queue) {
                      while (queue.size() == 0) {
                          queue.notify(); // 通知生产者生产
                          System.out.println("当前队列为空");
                          try {
                              queue.wait(); // 消费者等待
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                      queue.poll(); // 消费一个产品
                      queue.notify(); // 通知生产者生产
                      System.out.println("消费者消费一个产品, 当前队列长度" + queue.size());
                      try {
                          Thread.sleep(500);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
          }
      }
  
      public static void main(String[] args) {
          ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
          Producer producer = producerAndConsumer.new Producer();
          Consumer consumer = producerAndConsumer.new Consumer();
          producer.start();
          consumer.start();
      }
  }
  ```

## JVM

> 难是真的难...

* Java 虚拟机的功能

  * 通过 ClassLoader 寻找和装载 class 文件
  * 解释字节码成为指令并执行, 提供 class 文件的运行环境
  * 进行运行期间垃圾回收
  * 提供与硬件交互的平台

* Java 虚拟机进程有哪些线程启动?

  > 拼多多

  * -main 主线程: 执行指定启动类的 main()
  * -Reference Handler 处理引用的线程, 用于处理引用对象本身(软、弱、虚引用)的 GC 问题
  * -Finalizer: 调用对象的 finalize() 的线程, 也就是垃圾回收的线程
  * -Signal Dispatcher: 分发处理发送给 JVM 信号的线程
  * -Attach Listener: 负责接受外部的命令的线程

### 启动模式

> 蚂蚁集团

* 指定 JVM 启动模式: 启动时通过 -server 或 -client 参数指定启动模式

* cilent 模式与 server 模式

  * 编译器方面

    > 当虚拟机运行在 client 模式时, 使用的是一个代号为 c1 的轻量级编译器, 而 server 模式启动时, 虚拟机采用的是相对重量级, 代号为 c2 的编译器
    >
    > c2 编译器比 c1 编译器编译的相对彻底, 服务起来之后性能更高

  * GC 方面

    > client 模式下的新生代(Serial 收集器)和老年代(Serial Old)选择的是串行 GC
    >
    > server 模式下的新生代选择并行回收 GC, 老年代选择并行 GC

  * 启动方面

    > client 模式启动快, 编译快, 内存占用少, 针对桌面应用程序设计, 优化客户端环境的启动时间
    >
    > server 模式启动慢, 编译更完全, 编译期自适应编译器, 效率高, 针对服务端应用设计, 优化服务器环境的最大化程序执行速度

  > 注: 一般来说系统应用选择有两种方式, 吞吐量优先和停顿时间优先, 对于吞吐量优先的采用 server 默认的并行 GC(Parallel Scavenge), 对于时间优先的选择并发 GC(CMS)

### 垃圾回收

#### 内存区域

> **运行时数据区(很重要)**

<img src="C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201129164347560.png" alt="image-20201129164347560" style="zoom: 75%;" />

<img src="C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201129164909386.png" alt="image-20201129164909386" style="zoom: 80%;" />

* 注意: JVM 内存中堆和方法区是**线程共享**的, 其他是隔离的

* 堆

  * **Java 堆用来存放实例对象和数组对象**, 由于存在逃逸分析技术, 也可以分布在栈上, 随着出栈而销毁

    > 逃逸是指在某个方法之内创建的对象, 在方法体外被其它变量引用, 带来的后果是在该方法执行完后, 该方法中创建的对象将无法被回收, 即成为逃逸
    >
    > 逃逸分析技术即是分析对象是否被其他方法或线程调用

  * 同时 **Java 堆也是垃圾回收的主要区域**, 由于现在垃圾收集器基本采用==分代垃圾收集算法==, 所以 Java 堆可以细分为新生代和老年代

  * Java 堆在物理上可以不连续, 只需逻辑连续

  * 在堆上分配对象的方法: 指针碰撞、空闲列表

    > 指针碰撞是在堆**内存规整**的情景下, 所有用过和空闲的内存中间有**明确的分界线**
    >
    > 空闲列表则是用空闲列表记录内存使用情况, 规整是由垃圾回收器是否压缩整理决定
    >
    > 空间不足抛出 OutOfMemoryError

  * 堆上对象的访问方式: 通过栈上的 reference 数据来操作堆上的具体对象

    > 目前主流访问方式有使用句柄和直接指针两种
    >
    > 句柄: Java 堆中将划出一块内存来作为**句柄池**, reference 中存储的就是对象的句柄地址, 而**句柄包含了对象实例数据与类型数据各自的具体地址信息**
    >
    > 直接指针: reference 中**存储的是对象的地址**
    >
    > **句柄稳定, 直接指针效率高**

* 方法区

  * 存储已被 JVM 加载的类信息、常量、静态变量、编译器编译后的代码、运行时常量池等数据

  * 其中运行时常量池存放编译生成的各种字面量和符号引用

    > 字面量: 文本字符串、八种基本类型的值、final 常量
    >
    > 符号引用: 类的方法和全限命名、字段的名称和描述符、方法的名称和描述符

  * 运行时常量池相对于 Class 常量池具有动态性, 可以在运行期间利用 intern()将常量放入池中

    > 空间不足抛出 OutOfMemoryError

* 虚拟机栈

  * 是 Java 方法执行的内存模型, 线程私有
  * 每个方法执行都会创建一个栈帧, 用于存储**局部变量表、操作数栈**、动态链接和方法出口等信息
  * 每个方法从调用直至执行结束, 就对应一个栈帧从虚拟机栈中入栈到出栈的过程
  * StackOverflowError: 线程请求的栈深度大于虚拟机所允许的深度
  * OutOfMemoryError: 如果虚拟机栈可以动态扩展, 而扩展时无法申请到足够内存

* 本地方法栈: JVM 调用本地方法(可以为其他语言提供接口)

* 程序计数器

  * 记录当前线程所执行到的字节码的行号
  * 每个线程都有一个程序计数器
  * 唯一没有 OutOfMemoryError 的内存区域

* **运行时内存区域外规定的堆外内存**: 使用 Native 函数库直接分配堆外内存, 然后通过一个存储在 Java 堆中的 DirectByteBuffer 对象作为这块内存的引用进行操作, 这样可以在某些场景显著提高性能, 因为**避免了在 Java 堆和 Native 堆之间来回复制数据**

#### 永久代

> PermGen**(很重要)**

* ==永久代==是方法区在 HotSpot 的一种具体实现

* 由于方法区主要存储类的相关信息, 所以对动态生成类的情况比较容易出现永久代**内存溢出*

  > java.lang.OutOfMemoryError: PermGen space

* 为了避免这类问题, JDK 1.7 中永久代中存储的部分数据已经开始转移到 Java Heap 或者 Native Memory

  > 比如符号引用(Symbols)转移到了 Native Memory
  >
  > 字符串常量池(Interned String)转移到了 Java Heap
  >
  > 类的静态变量(class statics)转移到了 Java Heap

* 在 Java 8 中, HotSpot 取消了永久代, ==元空间==登上舞台

#### 元空间

> Metaspace**(很重要)**

* 方法区同样存在于元空间, 但是元空间不再与堆连续, 而是存在于==本地内存(Native Memory)==

* 本地内存也称 C-Heap, 是供 JVM 自身进程使用的

* 当 Java Heap 空间不足时会触发 GC, 但是本地内存空间不足不会触发 GC

* 但是默认情况下, 元空间可以无限使用本地内存, 不过 JVM 提供了参数来限制大小

* **扩展: 为什么使用元空间替代永久代?**

  * 字符串存在永久代中, 容易出现性能问题和内存溢出

  * 类及方法的信息等比较难确定其大小, 因此对于永久代的大小较难指定

    > 太小容易永久代溢出, 太大容易老年代溢出
    >
    > 另外, 使用 PermSize 和 MaxPermSize 设置永久代决定了永久代的上限, 但是动态生成类加载容易出现 OOM 错误
    >
    > 所以当使用元空间时, 可以加载多少类的大小不由 MaxPermSize 控制, 而由系统实际可用空间来控制

  * 永久代会为 GC 带来不必要的复杂度, 并且回收效率低

  * Oracle 可能会将 HotSpot 与 JRockit 合二为一

    > JRockit 没有所谓的永久代, 并且运行良好, 不用担心运行性能

#### 对象死亡判定

> **很重要**

* 引用计数法

  > 每当有一个地方引用它, 计数器 + 1, 每当引用失效, 计数器 - 1, 任何时候计数器为 0 的对象不可能再被使用; 目前主流的虚拟机并没有选择这个算法来管理内存, 主要原因是它很难解决对象之间==循环依赖==的问题

* 可达性分析法

  > 基本思想是通过一系列的称为==GC Roots==的对象作为起点, 从这些节点开始向下搜索, 节点所走过的路径称为==引用链==, 当一个对象到 GC Roots 没有任何引用链相连的话, 则证明此对象不可用
  >
  > 可以作为 GC ROOT 的对象包括虚拟机栈中引用对象、方法区中类静态属性引用的对象、方法区中常量引用对象、本地方法中引用对象

* 真的死了?

  > 即使在可达性分析法中不可达的对象, 也并非是非死不可的, 这时候它们暂时处于"缓刑阶段", **要真正宜告一个对象死亡, 至少要经历两次标记过程**; 可达性分析法中不可达的对象被第一次标记并且进行一次筛选, 筛选的条件是此对象是否有必要执行 finalize(), 当对象没有覆盖 finalize(), 或 finalize() 已经被虚拟机调用过时, 虚拟机将这两种情况视为没有必要执行, 被判定为需要执行的对象将会被放在一个队列中进行**第二次标记**, 除非这个对象与引用链上的任何一个对象建立关联, 否则就会被真的回收

#### 四种引用

> **重要**

* 强引用

  > **如果一个对象具有强引用, 垃圾回收器绝不会回收它**, 当内存空间不足, Java 虚拟机宁愿抛出 OutOfMemoryError 使程序异常终止

* 软引用

  > 如果内存空间足够, 垃圾回收器就不会回收它, 如果空间不足就会回收这些对象的内存, 只要垃圾回收器没有回收它, 该对象就可以被程序使用, **软引用可用来实现内存敏感的高速缓存**

* 弱引用

  > 相对于软引用, 弱引用关联的对象只能生存到下一次垃圾回收之前

* 虚引用

  > 如果一个对象仅持有虚引用, 那么它和没有任何引用一样, 在任何时候都可能被垃圾回收, 虚引用主要用来跟踪对象被垃圾回收器回收的活动, 虚引用与软引用和弱引用的一个区别在于: 虚引用必须和==引用队列(ReferenceQueue)==联合使用, 当垃圾回收器准备回收一个对象时, 如果发现它还有虚引用, 就会在回收对象的内存之前, 把这个虚引用加入到与之关联的引用队列中, 这样就可以通过判断引用队列中是否已经加入了虚引用来了解被引用的对象是否将要被垃回收, 可以做一些在回收之前的必要行动

  > 虚与软、弱引用的区别
  >
  > 软、弱引用都是在引用对象被垃圾回收后, Java 虚拟机才把引用加入到与之关联的引用队列中(后)
  >
  > 而虚引用对象在垃圾回收前, Java 虚拟机把引用加入到与之关联的引用队列中(前)

#### 垃圾回收算法

* 标记-清除算法: 首先标记出所有需要回收的对象, 在标记完成后统一回收所有被标记的对象

  > 最基础的收集算法, 会带来两个明显的问题: 效率问题和空间问题(标记清除后会产生大量不连续的碎片)

* 复制算法(强行设置边界): 将内存分为大小相同的两块, 每次使用其中的一块, 当这一块的内存使用完后, 就将还存活的对象复制到另一块去, 然后再把使用的空间一次清理掉

  > 这样就使每次的内存回收都是对内存区间的一半进行回收, 但是为了收集垃圾, 将内存使用量降低为一半, 成本较高, 所以一般不会1:1划分边界, 可以分一块较大的 Eden 空间和两块较小的 Survivor 空间, 每次使用 Eden 空间和其中一块 Survivor, 当回收时, 将 Eden 和 Survivor 中还存活的对象一次性复制到另一块 Survivor 上, 最后清理 Eden 和 Survivor 空间, 大小比例一般是8:1:1, 每次浪费10%的 Survivor 空间
  >
  > 但是这里有一个问题就是如果存活的大于10%怎么办? 这里采用一种分配担保策略: 多出来的对象直接进入老年代

  <img src="C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201205143814626.png" alt="image-20201205143814626" style="zoom: 80%;" />

* 标记-整理算法(整理出边界): 标记过程仍然与"标记-清除"算法一样, 但后续不是直接对可回收对象回收, 而是让所有存活的对象向一段移动, 然后直接清理掉端边界以外的内存

* 分代收集算法(结合以上方法): 一般将 Java 堆分为新生代和老年代, 这样就可以根据各个年代的特点选择合适的垃圾收集算法

  > 比如在新生代中, 每次收集都会有大量对象死去, 所以可以选择复制算法, 只需要付出少量对象的复制成本就可以完成垃圾收集
  >
  > 而老年代的对象存活几率是比较高的, 所以可以选择"标记-清理"或"标记-整理"算法进行垃圾收集

#### 常见垃圾回收器

> **很重要**

* 如果说收集算法是内存回收的方法论, 那么垃圾收集器就是内存回收的具体实现

* 垃圾收集器主要有: Serial、Serial Old、ParNew、Parallel Scavenge、Parallel Old、CMS、G1

* Serial 收集器: **单线程**收集器, 不仅仅意味着它只会使用一条垃圾收集线程去完成工作, 重要的是它在进行垃圾收集工作的时候必须暂停其他所有的工作线程("Stop The World")直到它收集结束

* ParNew 收集器其实就是 Serial 收集器的多线程版本, 随着CPU增加可以显示出优势(并行)

  > 并行(Parallel): 指多条垃圾收集线程并行工作, 但此时用户线程仍然处于等待状态
  >
  > 并发(Concurrent): 指用户线程与垃圾收集线程同时执行(但不一定是并行, 可能会交替执行), 用户程序在继续运行, 而垃圾收集器运行在另一个CPU上

* Parallel Scavenge 收集器是一个新生代收集器, 使用**复制算法**, **并行的多线程收集器**, 与 ParNew 类似, 但是侧重点是吞吐量(CPU 运行用户代码时间 / CPU 消耗的总时间)

  > 可以设置参数来调整最大垃圾收集停顿时间和吞吐量的大小

> 以上是新生代收集器, 一般采用复制算法

* Serial Old 是 Serial 收集器的老年代版本, 同样是一个单线程收集器

* Parallel Old 收集器, 是 Parallel Scavenge 收集器的老年代版本, 使用多线程和"标记-整理"算法, 在注重**吞吐量以及 CPU 资源配合**的场合, 都可以优先考虑 Parallel Scavenge 收集器和 Parallel Old 收集器

* ==CMS(Concurrent Mark Sweep)==, 老年代收集器, 采用标记-清除算法, 是一种以获取**最短回收停顿时间为目标**的收集器, 非常符合在注重用户体验的应用上使用

  ![image-20201205152946879](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201205152946879.png)

  > 整个过程有四个步骤: 初始标记、并发标记、重新标记和并发清除(Spark Streaming 采用这个, 最少停顿)
  >
  > https://blog.csdn.net/zy1994hyq/article/details/102495305

  1. 初始标记: 暂停所有的其他线程, 并记录下直接与 GC Root 相连的对象, 速度很快
  2. 并发标记: 同时开启 GC 和用户线程, 从 GC Root 继续向下进行标记, 但是用户线程会继续更新对象的引用域
  3. 重新标记: 此阶段是为了修正**并发标记**期间因为用户程序继续运行而导致标记产生变动的那一部分对象的标记记录, 这个阶段的停顿时间一般会比初始标记阶段的时间稍长, 远远比并发标记阶段时间短
  4. 并发清除: 开启用户线程, 同时 GC 线程开始对未标记的区域做清扫

  > 优点是并发清除、低延迟
  >
  > 缺点
  >
  > * 采用标记-清除, 会产生碎片
  > * 无法处理浮动垃圾, 在并发清除过程中, 用户线程还在继续执行, 还会不断垃圾, 这部分只能等到下次 GC 时处理
  > * 对 CPU 特别敏感, 由于并发标记和并发清除是和用户线程并发执行, 所以会导致用户程序变慢, 总的吞吐量降低

* G1收集器: **唯一**同时可用于年轻代和老年代的垃圾收集器, 采用标记-整理算法, 避免碎片, 该收集器将堆内存分为不同大小相等的 region, 并维护了一个==优先列表==, 每次根据允许的收集时间, 优先选择回收价值最大的 Region, 把内存化整为零, 但是由于引用关系的存在, 仍然存在如何避免全局扫描问题, 这里采用每一个 region 用一个 remembered Set 进行记录引用关系, 避免可达性分析阶段的全区域垃圾扫描

  > 大致分为四个步骤: 初始标记、并发标志、最终标记、筛选回收

  * 初始标记、并发标志和 CMS 相似
  * 最终标记: 将并发阶段对象变化记录在线程 Remenbered Set Logs 里面, 最终把 Remembered Set Logs 的数据合并到 Remembered Set 中, 这一阶段需要停顿线程, 但可并行执行
  * 筛选回收: 对每一个 region 的价值和成本进行筛选, 根据用户期望的 GC 停顿时间, 得到最好的回收方案并回收

  > 特点: 并发性强、分代收集、标记整理进行空间整合, 可以预测停顿时间

* 吞吐量优先和响应优先的垃圾收集器如何选择?

  * 吞吐量优先: 新生代采用 Parallel Scavenge, 老年代采用 Parallel Old, 并配置多个线程进行回收, 设置参数来调整最大垃圾收集停顿时间和吞吐量的大小
  * 响应时间优先: 设置老年代的收集器是 CMS(最短时间, Spark Streaming 采用这个), 年轻代是 ParNew(多线程)

#### 内存分配与回收策略

> 对象何时进入老年代?**(重要)**

* 大多数情况下, 对象在新生代中 Eden 区分配, 当 Eden 区没有足够空间进行分配时, 虚拟机将发起一次 Minor GC

* Minor GC 和 Full GC 有什么不同?

  * Minor GC: 指发生新生代的垃圾收集动作, Minor GC 非常频繁, 回收速度一般比较快
  * Major GC: 指发生在老年代的 GC, 比 Minor GC 慢10倍以上
  * Full GC: 清理整个空间包括年轻代和老年代

  > 下面两种一般很难区分, 许多 Major GC 是由 Minor GC 触发的

* 什么时候对象进入老年代?

  * 大对象(需要大量内存连续的)直接进行老年代

  * 空间分配担保

    > 新生成的对象放在 Eden, 当 Eden 被填满后, 垃圾回收后存活的对象复制放入 From(其中一个 survivor), 当 From 满了, 回收后存活的对象被复制到 To 区域, Eden 存活的也直接进入 To 区域, 原 From 区域被清空, 当 To 被填满后, 如果之间存活的对象还活着, 直接进行老年代(空间分配担保)

  * 年龄判定

    > 年龄计数器会为对象记录年龄, 每次经过一次 GC 仍然存活的, 年龄加一, 当超过设定值, 直接进入老年代, 或者动态对象年龄判定, 当如果 Survivor 空间中相同年龄所有对象大小的总和大于 Survivor 空间的一半, 大于等于该年龄的对象就可直接进入老年代, 无需达到要求的年龄

* 空间分配担保

  * 安全的 Minor GC: 老年代中最大可用的连续空间大于新生代所有对象的空间
  * 冒险的 Minor GC: 老年代中最大可用的连续空间大于历代晋升到老年代的平均水平且允许担保失败; 如果小于平均值, 则直接进行Full GC, 让老年代腾出空间

#### 如何优化GC

> **(重要)**蚂蚁集团

* 属于较为开放题目, 结合自己项目实战出发, 体现 JVM 调优

1. 可以先说下 GC 是什么, 说到垃圾回收算法、收集器等
2. 然后优化方向
  1. 将进入老年代的对象数量降到最低
  2. 减少 Full GC 的执行时间
  3. 优化 JVM 参数, 比如堆和栈大小, 设置垃圾收集器的模式
3. 最后, 从实际程序出发: 大对象、置空、对象重用等

### 监控和故障处理工具

> **重要**

* jps: JVM Process Status Tool, 显示指定系统内所有的 HotSpot 虚拟机进程
* jstat: JVM Statistics Monitoring Tool, 用于收集 HotSpot 虚拟机各方面的运行数据
* jinfo: Configuration lnfo for Java, 显示虚拟机配置信息
* jmap: Memory Map for Java, 生成虚拟机的内存转储快照(heapdump文件)
* jhat: JVM Heap Dump Browser, 用于分析 heapdump 文件, 它会建立一个 HTTP/HTML 服务器, 让用户在浏览器上查看分析结果
* jstack: Stack Trace for Java: 显示虚拟机的线程快照

> 以上是命令行模式的

* jvisualvm: 可视化来监控 Java 应用程序性能和跟踪

### 类的加载

#### class文件结构

* class 文件是 Java 虚拟机执行引擎的数据入口, 也是 Java 技术体系的基础构成之一
* 包括: 魔数和版本号、常量池(注意和运行时常量池的区别)、访问标志(类定义标志)、类索引、父类索引和接口索引的集合(确定一个类的继承关系)、字段表集合、方法表集合、属性表
* 字段表包含什么信息?(就是平时定义一个字段的格式)
  * 字段的作用域(public, private, protected 修饰符)
  * 是实例变量还是类变量(static)、可变性(final)、并发可见性(volatile, 是否强制从主内存读写)
  * 可否被序列化(transient 修饰符)
  * 字段数据类型、字段名称

#### 类加载机制

> **重要**

* **虚拟机把描述类的数据从 class 文件加载到内存, 并对数据进行校验、转换解析和初始化**
* 类加载过程: 加载、验证、准备、解析和初始化

1. 加载

   > 通过类型的完全限定名, 产生一个代表该类型的二进制数据流, 解析这个二进制数据流的**静态存储结构转化为方法区内的运行时数据结构**, 创建一个表示该类型的 java.lang.Class 类实例, 作为方法区这个类的各种数据的访问入口

2. 验证

   > 为了确保 class 文件的字节流中包含的信息符合当前虚拟机的要求, 并且不会危害虚拟机安全

3. 准备

   > 正式为类变量(static 修饰的)分配内存并设置初始值的阶段, 这些变量所使用的内存都将在方法区中进行分配
   >
   > 对于 public static int value = 123; 变量 value 在准备阶段过后的初始值为0而不是123, 这时候尚未开始执行任何 Java 方法, 把 value 赋值为123的动作将在初始化阶段才会被执行

4. 解析

   > 虚拟机将常量池内的符号引用替换为直接引用的过程, 主要对类或接口、字段、类方法、接口方法的解析, 主要是静态链接, 方法主要是静态方法和私有方法

5. 初始化

   > 开始真正执行定义的 Java 代码, 执行 clinit(), 该方法会收集所有类变量的赋值动作和静态语句合并产生, 首先会执行父类

#### 类加载器

> **很重要**

* 启动类加载器(Bootstrap ClassLoader)

  > 这个类加载器负责将存放在 lib 目录中的, 或者被 -Xbootclasspath 参数所指定的路径中的, 并且是虚拟机识别的(仅按照文件名识别, 如 rt.jar, 名字不符合的类库即使放在 lib 目录中也不会被加载)类库加载到虚拟机内存中

* 扩展类加载器(Extension ClassLoader)

  > 这个加载器由 sun.misc.Launcher$ExtClassLoader实现, 它负责加载 /lib/ext 目录中的, 或者被 java.ext.dirs 系统变量所指定的路径中的所有类库, 开发者可以直接使用扩展类加载器

* 应用程序类加载器(Application ClassLoader)

  > 这个类加载器由 sun.misc.Launcher$AppClassLoader 实现, 由于这个类加载器是 ClassLoader 中的 getSystemClassLoader() 的返回值, 所以一般也称它为系统类加载器, 它负责加载用户类路径(ClassPath)上所指定的类库, 开发者可以直接使用这个类加载器, 要求除了顶层的启动类加载器外, 其余的类加载器都应该有自己的父类加载器, 这里父子关系通常是子类通过组合关系而不是继承关系来复用父加载器的代码

#### 双亲委派模型

> **很重要**

* 如果一个类加载器收到了类加载的请求, 先把这个请求委派给父类加载器去完成

  > 所以所有的加载请求最终都应该传送到顶层的启动类加载器中

* 只有当父加载器反馈自己无法完成加载请求时, 子加载器才会尝试自己去加载

  > 原因是如果用户自己编写了一个称为 java.lang.Object 的类, 并放在程序的 ClassPath 中, 那系统中将会出现多个不同的 Object 类, Java 类型体系中最基础的行为也就无法保证, 应用程序也将会变得一片混乱

* 如果自己写一个 java.lang.String 会被加载吗?

  > 答案是否定的, 我们不能实现, 因为双亲委托机制是可以打破的, 你完全可以自己写一个 ClassLoader 来加载自己写的 java.lang.String 类, 但是你会发现也不会加载成功, 因为针对 java.* 开头的类, JVM 的实现中已经保证了必须由 Bootstrap 来加载
  >
  > 但是双亲委派也可以破坏掉, 比如自定义一个 String 类但是包名不是 java.*, 可以放在用户目录下进行加载

#### 静态分配与动态分配

> 引申: 重载与重写

* 静态分派: 依赖静态类型定位方法的分派, 发生在编译期, 典型应用为==方法重载==

  > 重载的参数是通过静态类型确定的, 直接调用父类

* 动态分配: 在运行时期根据实际类型来确定方法的分派, 发生在程序运行时, 典型应用是==方法重写==, 也是多态的一种体现, 根据转型来确定调用父类还是子类的方法

* **非虚方法**(所有 static 方法 + final/private 方法)通过 invokespecial 指令调用, 对这个非虚方法的符号引用将转为对应的直接引用, 即转为直接引用方法, 在编译完成时就确定唯一的调用方法

* **虚方法**是通过 invokevirtual 指令调用, 且会有**静态或者动态分派**, 具体先根据编译期方法接收者和方法参数的静态类型来分派, 再在运行期只根据方法接收者的实际类型来分派



# 算法

## 位运算

## 双指针

## 二分法

## 动态规划

* Fibonacci 数列

  ```java
  public int fibonacci(int n) {
      if (n <= 1) { // 0, 1, 1, 2, 3, 5, 8
          return n;
      }
      return fibonacci(n - 1) + fibonacci(n - 2);
  }
  ```

  ```java
  public int fibonacci(int n) {
      if (n <= 1) { // 0, 1, 1, 2, 3, 5, 8
          return n;
      }
      int a = 0;
      int b = 1;
      int result = 0;
      for (int i = 2; i <= n; i++) {
          result = a + b;
          a = b;
          b = result;
      }
      return result;
  }
  ```

## 贪心算法

## 回溯算法

* 常见排序算法

  | 算法 | 最好时间 | 最坏时间 | 平均时间 | 额外空间 | 稳定性 |
  | :--: | :------: | :------: | :------: | :------: | :----: |
  |      |          |          |          |          |        |

# 设计模式

* 创建型模式(5种): **单例模式、工厂方法模式、抽象工厂模式**、建造者模式、原型模式
* 结构型模式(7种): **适配器模式、装饰器模式、代理模式、外观模式**、桥接模式、组合模式、享元模式
* 行为型模式(11种): **策略模式、模板方法模式、观察者模式、责任链模式**、迭代子模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式

* 六大原则

  * 开闭原则 Open Close Principle: **对扩展开放, 对修改关闭**

    > 想达到效果, 需要使用接口和抽象类

  * 里氏代换原则 Liskov Substitution Principle: 任何基类可以出现的地方，子类一定可以出现

    > LSP 是继承复用的基石, 只有当派生类可以替换掉基类, 且软件单位的功能不受到影响时, 基类才能真正被复用, 而派生类也能够在基类的基础上增加新的行为

  * 依赖倒转原则 Dependence Inversion Principle: 针对接口编程, **依赖于抽象而不依赖于具体**

  * 接口隔离原则 Interface Segregation Principle: 使用多个隔离的接口, 比使用单个接口要好

    > 另外一个意思: 降低类之间的耦合度
    >
    > 由此可见, 设计模式从大型软件架构出发、便于升级维护的设计思想, **强调降低依赖, 降低耦合**

  * 迪米特法则(最少知道原则)Demeter Principle: 一个实体应当尽量少地与其他实体发生相互作用, 使系统功能模块相对独立
  * 合成复用原则 Composite Reuse Principle: 尽量使用合成/聚合的方式, 而不是使用继承

## 创建型模式

### 单例模式

> **很重要**

* 定义: 保证一个类**仅有一个**实例, 并提供一个访问它的**全局**访问点

* 主要解决一个全局使用的类频繁地创建与销毁的问题(如数据库连接池、线程池)

* 步骤

  1. **构造方法私有化**
  2. 类中创建一个**私有静态的本类对象**
  3. 定义一个**公有静态方法**将该对象返回

* 单例模式的内存情况: 在堆中只有一个对象, 方法区保存着构造方法和公有方法

* 懒汉式: **延迟加载**对象, 对象在公有方法中创建, 存在线程安全问题

  > 用双重检验保证线程安全

  ```java
  public class Singleton {
      private static Singleton instance = null;
      private Singleton() {}
      public static Singleton getInstance() {
          if (instance == null) {
              synchronized ("s") {
                  if (instance == null) {
                      instance = new Singleton();
                  }
              }
          }
          return instance;
      }
  }
  ```

* 饿汉式: 加载类时就创建了对象(开发时用的多)

  ```java
  public class Singleton {
      private static Singleton instance = new Singleton();
      private Singleton() {}
      public static Singleton getInstance() {
          return instance;
      }
  }
  ```

### 工厂方法模式

* 定义: 用一个创建对象的接口, 让其子类自己决定实例化哪一个工厂类

* 工厂方法模式使其创建过程延迟到子类进行

* 步骤

  1. 创建一个接口, 抽象产品(Product)角色

     ```java
     /**
      * 首先无论是做馒头还是挂面，他们都有一个加工方法，可以抽象出来
      * Machine：机器
      */
     public interface MachineApi {
         //process：加工, material:材料
         public void process(String material);
     }
     ```

  2. 创建实现接口的实体类, 具体产品

     ```java
     // 馒头机器
     public class SteamedBunMachine implements MachineApi {
         @Override
         public void process(String material) {
             System.out.println("我把" + material + "加工成了馒头");
         }
     }
     ```

     ```java
     // 面条机器
     public class BoodleMachine implements MachineApi {
         @Override
         public void process(String material) {
             System.out.println("我把" + material + "加工成了面条");
         }
     }
     ```

  3. 抽象工厂角色

     ```java
     public abstract class Factory {
         // 让子类(具体工厂)来实例化具体对象(机器)
         public abstract MachineApi newMachine();
         // 加工材料
         public void process(String material){
             MachineApi machine = newFileApi();
             machine.process(material);
         }
     }
     ```

  4. 具体工厂

     ```java
     // 馒头工厂
     public class SteamedBunFactory extends Factory{
         // 馒头工厂, 只需要提供馒头机器就行
         @Override
         public MachineApi newMachine() {
             return new SteamedBunMachine();
         }
     }
     ```

     ```java
     // 面条工厂
     public class NoodleFactory extends Factory{
         // 面条工厂, 只需要提供面条机器就行
         @Override
         public MachineApi newMachine() {
             return new BoodleMachine();
         }
     }
     ```

  5. 使用该工厂, 通过传递类型信息来获取实体类的对象

     ```java
     public static void main(String[] args) {
         SteamedBunFactory mSteamedBunFactory  = new SteamedBunFactory();
         mSteamedBunFactory.process("面粉"); // 我把面粉加工成了馒头
     }
     ```

### 抽象工厂模式

* 定义: 提供一个创建一系列相关或相互依赖对象的接口, 而无需指定它们具体的类

  > 有点像将工厂方法组合起来

* 何时使用: 系统产品有多于一个的产品族, 而系统只消费其中某一族的产品

* 以数据库连接工具为例子

  > 不同数据库连接工具的共同特点: 提供连接、提供命令执行

  1. 数据库连接工具需要的连接接口、命令接口

     ```java
     interface Connection {
         void connect();
     }
     interface Command {
         void command();
     }
     ```

  2. 将两个接口组合起来的数据库连接工具"产品"工厂

     ```java
     public interface Database {
         Connection getConnection();
         Command getCommand();
     }
     ```

  3. 具体产品的接口实现类

     ```java
     class MySQLConnection implements Connection {
         @Override
         public void connect() {
             System.out.println("获取MySQL连接");
         }
     }
     class MySQLCommand implements Command {
         @Override
         public void command() {
             System.out.println("MySQL发送命令");
         }
     }
     ```

  4. 具体产品

     ```java
     public class MySQLDatabase implements Database {
         @Override
         public Connection getConnection() {
             return new MySQLConnection();
         }
         @Override
         public Command getCommand() {
             return new MySQLCommand();
         }
     }
     ```

  5. 创建产品

     ```java
     public static void main(String[] args) {
         Database database = new MySQLDatabase();
         Connection connection = database.getConnection();
         connection.connect();
         Command command = database.getCommand();
         command.command();
     }
     ```

* 根据例子概括, 对于接口 Database, 抽象了两个相关或相互依赖对象的接口 Connection 和 Command

  > 如果只有其中一个, 则可以看成是工厂方法模式

* 上述例子中如果要增加 Oracle 的实现, 则要写 OracleConnection、OracleCommand、OracleDatabase

## 结构型模式

### 适配器模式

* 定义: 将一个类的接口转换成客户希望的另外一个接口

* 适配器模式使得原本由于**接口不兼容**而不能一起工作的那些类可以一起工作

  > 生活中的充电器就是适配器, 将220V的电压转为充电电器所支持的电压

* 对象适配器: 通过"组合"的方式, **将被适配者传给适配器**, 通过适配器的转换将目标结果输出

  ```java
  public class AdapterV1Demo {
      public static void main(String[] args) {
          Adapter adapter = new Adapter(new Source());
          adapter.output5V();
      }
  
      static class Source { // 电源
          public int output220V() {
              return 220;
          }
      }
  
      interface Target { // 目标电压
          int output5V();
      }
  
      static class Adapter implements Target {
          private Source source;
          public Adapter(Source source) {
              this.source = source;
          }
          @Override
          public int output5V() {
              int output220V = source.output220V();
              System.out.println("原始电压: " + output220V + "V");
              // 转换...
              System.out.println("转换后电压: 5V");
              return 5;
          }
      }
  }
  ```

* 类适配器: 通过"继承"的方式, **适配器继承自被适配者**, 然后经过转换将目标结果输出

  > 这种方式不符合"单一职责", 可以看到适配器对象可以调用输出220V的方法, 显然不符合预期

  ```java
  public class AdapterV2Demo {
      public static void main(String[] args) {
          Adapter adapter = new Adapter();
          adapter.output5V();
      }
  
      static class Source { // 电源
          public int output220V() {
              return 220;
          }
      }
  
      interface Target {
          int output5V();
      }
  
      static class Adapter extends Source implements Target {
          @Override
          public int output5V() {
              int output220V = output220V();
              System.out.println("原始电压: " + output220V + "V");
              // 转换...
              System.out.println("转换后电压: 5V");
              return 5;
          }
      }
  }
  ```

### 装饰器模式

* 定义: 向一个现有的对象添加新的功能, 同时不改变其结构, 动态地给一个对象添加一些额外的职责

* 就增加功能来说, 装饰器模式相比生成子类更为灵活

* 被装饰对象, 基础功能"拍照"

  ```java
  interface Component {
      void operation();
  }
  
  static class ConcreteComponent implements Component {
      @Override
      public void operation() {
          System.out.println("拍照");
      }
  }
  ```

* 装饰器, 实现被装饰对象接口并持有被装饰对象

  ```java
  static abstract class Decorator implements Component {
      Component component;
      public Decorator(Component component) {
          this.component = component;
      }
  }
  ```

* "美颜"装饰器, 继承自装饰器基类, 在被装饰的方法中添加新功能

  ```java
  static class ConcreteDecorator extends Decorator {
      public ConcreteDecorator(Component component) {
          super(component);
      }
  
      @Override
      public void operation() {
          component.operation();
          System.out.println("添加美颜效果");
      }
  }
  ```

* 再添加一个"滤镜"装饰器

  ```java
  static class ConcreteDecorator2 extends Decorator {
      public ConcreteDecorator2(Component component) {
          super(component);
      }
  
      @Override
      public void operation() {
          component.operation();
          System.out.println("添加滤镜效果");
      }
  }
  ```

* 调用, 因为装饰器本身也是"被装饰者", 所以可以嵌套装饰

  > 典型应用在 Java IO 中的文件缓存输入输出流

  ```java
  public static void main(String[] args) {
      Component component = new ConcreteComponent();
      Decorator decorator = new ConcreteDecorator2(new ConcreteDecorator(component));
      decorator.operation();
  }
  ```

### 代理模式

* 定义: 为其他对象提供一种代理以控制对这个对象的访问

* 被代理对象

  ```java
  interface Subject {
      void doWork();
  }
  
  static class RealSubject implements Subject {
      @Override
      public void doWork() { 
          // ... 
      }
  }
  ```

* 代理类

  > 被代理对象可以是传参进去, 也可以通过反射获得

  ```java
  static class RealSubjectProxy implements Subject {
      private RealSubject subject;
      public RealSubjectProxy() {
          try {
              this.subject = (RealSubject) this.getClass().getClassLoader().loadClass("com.donkey.interview.designpatterns.proxy.ProxyDemo.RealSubject").newInstance();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  
      public void connect() { System.out.println("连接"); }
  
      public void log() { System.out.println("日志"); }
  
      @Override
      public void doWork() {
          connect();
          log();
      }
  }
  ```

### 外观模式

* 定义: 为子系统的一组接口提供一个一致的界面, 外观模式定义了一个高层接口, 使得子系统更加容易使用

* 子系统有多个类

  ```java
  static class SubFlow1 {
      boolean isTrue() {
          return true;
      }
  }
  
  static class SubFlow2 {
      boolean isOk() {
          return true;
      }
  }
  ```

* 外观类, 给外部提供 prove()来忽略复杂的内部

  ```java
  static class Facade {
      SubFlow1 subFlow1 = new SubFlow1();
      SubFlow2 subFlow2 = new SubFlow2();
      boolean prove() {
          return subFlow1.isTrue() && subFlow2.isOk();
      }
  }
  ```

* 调用

  ```java
  new Facade().prove();
  ```

* 外观模式不符合开闭原则, 当子系统拓展时, 外观类必须修改

## 行为型模式

### 策略模式

* 定义: 定义一系列的算法, 把它们一个个封装起来, 并且使它们可**相互替换**

* 例子: 僵尸有很多种类, 每个种类有共性, 但共性的表现方式不一

* 攻击和移动接口

  ```java
  interface Moveable {
      void move();
  }
  interface Attackable {
      void attack();
  }
  ```

* 僵尸抽象类, 其中组合了攻击和移动接口

  ```java
  abstract class Zombie {
      Moveable moveable;
      Attackable attackable;
      public abstract void display();
      abstract void move();
      abstract void attack();
      
      public Zombie(Moveable moveable, Attackable attackable) {
          this.moveable = moveable;
          this.attackable = attackable;
      }
      // getter and setter
  }
  ```

* 具体移动实现类

  ```java
  class StepByStep implements Moveable {
      @Override
      public void move() {
          System.out.println("一步一步");
      }
  }
  class Jump implements Moveable {
      @Override
      public void move() {
          System.out.println("跳");
      }
  }
  ```

* 具体攻击实现类

  ```java
  class HitAttack implements Attackable {
      @Override
      public void attack() {
          System.out.println("打");
      }
  }
  static class BiteAttack implements Attackable {
      @Override
      public void attack() {
          System.out.println("咬");
      }
  }
  ```

* 具体僵尸实现类

  ```java
  class FlagZombie extends Zombie {
      public NormalZombie() {
          this(new StepByStep(), new BiteAttack());
      }
      
      public NormalZombie(Moveable moveable, Attackable attackable) {
          super(moveable, attackable);
      }
  
      @Override
      public void display() {
          System.out.println("普通");
          move();
          attack();
      }
  
      @Override
      void move() {
          moveable.move();
      }
  
      @Override
      void attack() {
          attackable.attack();
      }
  }
  ```

* 调用, 可随时通过新建接口来改变僵尸的攻击方式

  ```java
  public static void main(String[] args) {
      Zombie zombie = new FlagZombie();
      zombie.display(); // 原来是咬
      // 更换攻击方式
      zombie.setAttackable(new HitAttack()); // 改为打
      zombie.display();
  }
  ```

### 模板方法模式

* 定义: 定义一个操作中的算法的**骨架**, 而将一些步骤延迟到子类中
* 模板方法使得子类可以不改变一个算法的结构即**可重定义该算法的某些特定步骤**

* 示例, 抽象类中 operation()定义好了骨架, 然后调用一个抽象方法 templateMethod()由子类实现

  ```java
  public static void main(String[] args) {
      new SubClass().operation();
  }
  
  abstract class Template {
      public void operation() {
          System.out.println("step 1");
          templateMethod();
          System.out.println("step n");
      }
      abstract protected void templateMethod();
  }
  
  class SubClass extends Template {
      @Override
      protected void templateMethod() {
          System.out.println("子类完成的操作");
      }
  }
  ```

### 观察者模式

* 定义: 定义对象间的一种一对多的依赖关系, 当一个对象的状态发生改变时, 所有依赖于它的对象都得到通知并被自动更新

* 观察者

  ```java
  interface Observer {
      void update(Object object);
  }
  
  class Task implements Observer {
      @Override
      public void update(Object object) {
          System.out.println("received: " + object);
      }
  }
  ```

* 被观察者

  ```java
  class Subject {
      private List<Observer> container = new ArrayList<>();
  
      public void addObserver(Observer observer) {
          container.add(observer);
      }
  
      public void removeObserver(Observer observer) {
          container.remove(observer);
      }
  
      public void notifyObserver(Object object) {
          for (Observer observer : container) {
              observer.update(object);
          }
      }
  }
  ```

* 调用

  ```java
  public static void main(String[] args) {
      Task task = new Task();
      Subject subject = new Subject();
      subject.addObserver(task);
      subject.notifyObserver("数据");
  }
  ```

### 责任链模式

* 定义: 为请求创建一个接收者对象的链
* 避免请求发送者与接收者耦合在一起, 让多个对象都有可能接收请求, 将这些对象连接成一条链, 并且沿着这条链传递请求, 直到有对象处理它为止
* 可以控制执行顺序
* 符合开闭原则、单一职责原则

* 经典应用: 拦截请求

* 请求

  ```java
  class Request {
      boolean frequent;
      boolean logged;
      
      // ...构造方法 getter setter
  
      boolean isFrequent() {
          return frequent;
      }
  
      boolean isLogged() {
          return logged;
      }
  }
  ```

* 抽象接受者, 接受者中组合了下一个接受者, 也就是链表的形式

  ```java
  abstract class Handler {
      Handler next;
      
      // ...构造方法 getter setter
      
      abstract boolean process(Request request);
  }
  ```

* 接受者实现类, 完成业务之后判断是否有后续节点, 有则向后传递

  ```java
  class RequestFrequentHandler extends Handler {
      // ...构造方法
  
      @Override
      boolean process(Request request) {
          System.out.println("拦截请求频率过高的请求");
          if (request.isFrequent()) {
              Handler next = getNext();
              if (next == null) { // 如果已经没有后续
                  return true;
              } else { // 有后续则
                  return next.process(request);
              }
          } else {
              return false;
          }
      }
  }
  
  class LoginHandler extends Handler {
      // ...构造方法
  
      @Override
      boolean process(Request request) {
          System.out.println("拦截未登录的请求");
          if (request.isLogged()) {
              Handler next = getNext();
              if (next == null) {
                  return true;
              } else {
                  return next.process(request);
              }
          } else {
              return false;
          }
      }
  }
  ```

# 数据库

* ACID 特性**(很重要)**

  * 原子性 Atomicity

    > 事务被视为不可分割的最小单元, 事务的所有操作要么全部提交成功, 要么全部失败回滚, 回滚可以利用回滚日志来实现, 回滚日志记录着事务所执行的修改操作, 在回滚时反向执行这些操作即可

  * 一致性 Consistency

    > 数据库在事务执行前后保持一致性状态, 在事务开始前和结束后, 数据库的完整性约束没有被破坏
    >
    > 典型例子: 银行转账, 两个账户总金额不变

  * 隔离性 Isolation

    > 一个事务所做的修改在最终提交以前, 对其它事务是不可见的

  * 持久性 Durability

    > 一旦事务提交, 其对数据库的改变是永久的, 即使系统崩溃, 事务执行的结果也不能丢失
    >
    > 使用重做日志来保证持久性

* 四大隔离级别**(很重要)**

  * Read Uncommitted 读未提交: 最低级别, 任何情况都可能发生
  * Read Committed 读已提交: 可避免脏读
  * **Repeatable Read 可重复读**: 可避免脏读、不可重复读(MySQL的默认隔离级别)
  * Serializable 串行化: 避免脏读、不可重复读、幻读

* 事务问题**(很重要)**

  * Dirty Read 脏读: 事务 A 读取事务 B 尚未提交的更改数据, 如果 B 回滚, 则 A 读到的数据根本不是合法的

    > 在 Oracle 中由于有 version 控制, 不会出现脏读

  * Unrepeatable Read 不可重复读: 事务 A 读取了事务 B 已经提交的**更改或删除**的数据

    > 比如 A 第一次读取数据, 然后 B 更改数据并提交, A 再次读取发现两次的数据不一致

  * Phantom Read 幻读: 事务 A 读取了事务 B 已经提交的**新增**数据

    > 应对不可重复读和幻读的策略不一样, 对不可重复读只需用**行级锁**防止该记录被更改或删除, 对幻读则必须加表级锁, 防止在这个表新增数据

* 锁的粒度: 行级锁和表级锁

  > 选择锁时需要在开销和并发度之间权衡, 尽量只锁定需要修改的那部分数据
  >
  > 锁定的数据越少, 发生锁争用的可能性越小, 系统的并发度越高
  >
  > 但是加锁需要消耗资源, 锁的各种操作(获取、释放、检查状态)都会增加系统开销
  >
  > **锁粒度越小, 系统开销越大**

* 悲观锁和乐观锁

  * 悲观锁: 对数据被外界(包括本系统当前的其他事务, 以及来自外部系统的事务处理)修改保持保守态度, **在整个数据处理过程将数据锁定**, 往往依靠数据库提供的锁机制来实现

  * 乐观锁: 其认为数据一般情况下不会造成冲突, 所以只会在数据进行提交更新时才会正式对数据的冲突与否进行检测, 如果冲突了, 则返回用户错误的信息, 让用户决定如何做

    > 乐观锁的实现依靠"版本号"
    >
    > 当提交更新时, 判断数据库表对应记录的 version 与第一次取出来的 version 比较, 版本号一致则予以更新, 否则认为是过期数据, 实际就是并发控制中的==CAS理论==

# 计算机网络

## 分层

> **重要**

![image-20201201150149397](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201150149397.png)

* OSI模型
  * 物理层: 各种传输介质, **传输比特流**, 将数字信号转成电信号进行传输, 到达目的地再转成数字信号

  * 数据链路层: 将从物理层接收的数据进行 MAC 地址的封装与解封, **传输帧**, 设备为交换机

  * 网络层: 将下层的数据进行 IP 地址的封装与解封, **传输数据包**, 设备为路由器

  * 传输层: 为进程提供通用数据传输服务

    > 由于应用层协议很多, 定义通用的传输层协议就可以支持不断增多的应用层协议
    >
    > 运输层包括两种协议: 传输控制协议 TCP、用户数据报协议 UDP

    * TCP 提供==面向连接==、可靠的数据传输服务, 数据单位为报文段, 主要提供完整性服务
    * UDP 提供无连接、尽最大努力的数据传输服务, 数据单位为用户数据报, 主要提供及时性服务

  * 会话层: 设备之间相互认识

  * 表示层: 将数据进行解析(把计算机数据转为人能认识的信息)

  * 应用层: 为特定的应用程序提供数据传输服务, 如 HTTP、DNS 等协议, 数据单位为报文

* TCP/IP模型: 将 OSI 模型进行合并

* 应用层 -> 物理层 为封装, 物理层 -> 应用层 为解封

* 集线器工作在物理层, 交换机工作在数据链路层, 路由器工作在网络层

* 网络要素

  * IP 地址: 计算机上网的网络标识, 有 Ipv4(4部分, 每个部分为0-255), 有 Ipv6(地址不够, 加上了字母)

    > IP 地址不好记, 后用主机域名描述

  * 端口号: 有效端口 0-65535, 其中 0-1024系统保留, **端口号用于标识进程的逻辑地址**

    > 发送数据给某个软件, 需要知道软件的端口值

  * 传输协议

## TCP

### 与UDP的区别

> **重要**

* 用户数据报协议 User Datagram Protocol

  * 是无连接的, 尽最大可能交付

  * 没有==拥塞控制==

  * 面向报文, 大小限制64KB, 对于应用程序传下来的报文不合并也不拆分, 只是添加 UDP 首部

  * 支持一对一、一对多、多对一和多对多的交互通信

* 传输控制协议 Transmission Control Protocol

  * 面向连接, 提供可靠交付

  * 有流量控制, 拥塞控制

  * 提供==全双工通信==

  * 面向==字节流==, 把应用层传下来的报文看成字节流, 把字节流组织成大小不等的数据块

  * 每条 TCP 连接只能是一对一的

  * TCP 报文结构: 源目的地址、序列号、确认序列号、窗口大小、校验和、数据

* 如果是发送消息、浏览网页之类的场景, 要确保用户消息不丢失, 要使用 TCP

* 如果是视频聊天、看直播, 可以采用 UDP, 因为即使几个画面丢失对用户影响不大

### 头部结构

> **重要**

![image-20201201153259850](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201153259850.png)

* 端口号(16位): 标识该段报文来自哪里(源端口)以及要传给哪个上层协议或者应用程序(目的端口)

* 序号(32位): 发送数据包(分片)中的第一个字节在源数据(完整数据)中是第几字节

  > 假定主机 A 和 B 进行 TCP 通信, A 传给 B 一个 TCP 报文段中序号值被系统初始化为某一个随机值 ISN, 那么在该传输方向上(A -> B)后续的所有 TCP 报文段中的序号值都会被设定为 ISN 加上该报文段所携带数据的第一个字节在整个字节流中的偏移
  >
  > 例如某个 TCP 报文段传送的数据是字节流中的第1025-2028字节, 那该报文段序号值就是 ISN + 1025

* 确认号(32位): 用作对另一方发送的 TCP 报文段的响应, 值为收到对方的报文段序号值 + 1

  > 接收方发送给发送方, 告知发送方应该发送从第几字节开始的数据报
  >
  > 比如发送方发送了9个字节的数据, 并且接收方已成功接收
  >
  > 则接收方反馈给发送方的确认号为 10
  >
  > A 和 B 通信, 则 A 发出的 TCP 报文段不但带有自己的序号, 也包含对 B 发送的报文段的确认号

* 头部长度(4位): 表示 TCP 首部有多少个"单位", **一个单位表示4字节**

  > 值是TCP首部(包括选项)长度除以4, 最大值是 (16 - 1) * 4 = 60 字节(最大 TCP 首部长度)

* URG(1位): 置1时，表明紧急指针字段有效

* ACK(1位): 置1时表示确认号合法, 为0时表示数据报不包含确认信息, 确认号被忽略

* PSH(1位): 置1时请求的数据报在接收方得到后就可直接送到应用程序, 而不必等到缓冲区满时才传送

  > 提示接收端应用程序应该立即从 TCP 接收缓冲区中读走数据, 为后续接收的数据让出空间

* RST(1位): 用于复位因某种原因引起的错误连接, 也用来拒绝非法数据和请求

  > 表示要求对方重新建立连接; 如果接收到RST位时候, 通常发生了某些错误

* SYN(1位): 用来建立连接

  > 在连接请求中, SYN=1, ACK=0, 连接响应时, SYN=1, ACK=1, 即SYN和ACK来区分连接请求和连接响应

* FIN(1位): 表示告知对方本端要关闭连接, 表明发送方已经没有数据发送

![image-20200621215422177](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20200621215422177.png)

* 窗口大小(16位): 值是[0, $2^{16}-1$]之间的整数, **窗口指的是发送方的接收窗口**(不是自己的发送窗口)

  > 是 TCP 流量控制的一个手段, 这里的窗口指接收通告窗口, 告诉对方本端 TCP 接收缓冲区还能容纳多少字节数据, **使对方控制发送数据的速度**
  >
  > 窗口值告诉对方, 从本报文段首部中的确认号算起, 接收方目前允许对方发送的数据量(字节为单位), 之所以要有这个限制, 是因为接收方的数据缓存空间有限, 总之, 窗口值作为接收方让发送方设置其发送窗口的依据

* 检验和(16位): **检验和字段检验的范围包括首部和数据两部分**

  > 由发送端填充, 接收端对 TCP 报文段执行 CRC 算法以检验 TCP 报文段在传输过程中是否损坏
  >
  > 和UDP一样, 计算检验和时, 要在TCP报文段前面加上12字节的伪首部
  >
  > 伪首部的格式和UDP用户数据报的伪首部一样, 但应把伪首部第4个字段中的17改为6(TCP的协议号是6), 把第5字段中的UDP中的长度改为TCP长度
  >
  > 接收方收到此报文段后, 仍要加上这个伪首部来计算检验和, 若使用IPv6, 则相应的伪首部也要改变

* 紧急指针(16位): 紧急指针仅在URG=1时有意义

  > 是一个正的偏移量, 和序号字段的值相加表示最后一个紧急数据的下一字节的序号
  >
  > 因此这个字段是紧急指针相对当前序号的偏移量, 发送紧急数据时会用到
  >
  > 它指出本报文段中的紧急数据的字节数(紧急数据结束后就是普通数据)
  >
  > 因此, 在紧急指针指出了紧急数据的末尾在报文段中的位置
  >
  > 当所有紧急数据都处理完时, TCP就告诉应用程序恢复到正常操作
  >
  > 值得注意的是, 即使窗口为0时也可以发送紧急数据

* MSS(选项): TCP最初只规定了一种选项, 即最大报文段长度MSS(Maximum Segment Szie)

  > MSS是每一个TCP报文段中的**数据字段的最大长度**, 数据字段加上TCP首部才等于整个的TCP报文段
  >
  > 所以MSS并不是整个TCP报文段的最大长度, 而是"TCP报文段长度减去TCP首部长度"

### 三次握手

> **很重要**

![image-20201201170758327](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201170758327.png)

* 第一次握手: 主机 A 发送标志位码为 SYN=1, 随机产生 SeqNumber=1234567 的数据包到服务器, 主机 B 由 SYN=1 知道 A 要求建立联机
* 第二次握手: 主机 B 收到请求后要确认联机信息, 向 A 发送 AckNumber=(主机A的seq+1), SYN=1, ACK=1, 随机产生 seq=7654321 的包
* 第三次握手: 主机 A 收到后检查 AckNumber 是否正确, 即第一次发送的 seq number+1, 及标志位码 ACK 是否为1, 若正确, 主机 A 会再发送 seq number、ack number=(主机B的seq+1)和 ACK=1, 主机 B 收到后确认 seq 值与 ACK=1 则连接建立成功
* 完成三次握手, 主机A与主机R开始传送数据

> 为什么要三次握手?

* **主要为了防止已失效的连接请求报文段突然又传送到了B, 因而产生错误**
* 如 A 发出连接请求, 但因连接请求报文丢失而未收到确认, 于是A再重传一次连接请求
* 后来收到了确认, 建立了连接, 数据传输完毕后, 就释放了连接
* A 一共出了两个连接请求报文段, 其中第一个丢失, 第二个到达了B, 但**是第一个丢失的报文段只是在某些网络结点长时间滞留了, 延误到连接释放以后的某个时间才到达 B**, 此时 B 误认为 A 又发出一次新的连接请求, 于是就向A发出确认报文段, 同意建立连接
* 不采用三次握手, 只要 B 发出确认, 就建立新的连接了, 此时 A 不理睬 B 的确认且不发送数据, 则 B 一直等待 A 发送数据, 浪费资源

### 四次挥手

![image-20201201173352883](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201173352883.png)

1. 首先客户端想释放连接, 向服务端发送 TCP 报文, 标记位 FIN=1, 表示请求释放连接, 序号为 Seq=U, 随后客户端进入 FIN-WAIT-1 阶段, 即半关闭阶段, 并且停止在客户端到服务器端方向上发送数据, 但是客户端仍能接收从服务端传输过来的数据

   > 注意: 这里不发送的是正常连接时传输的数据(非确认报文), 而不是一切数据, 所以客户端仍然能发送 ACK 确认报文

2. 服务端接收到从客户端发出的 TCP 报文后, 确认了客户端想要释放连接, 随后服务端结束 ESTABLISHED 阶段, 进入 CLOSE-WAIT 阶段(半关闭状态), 并返回一段 TCP 报文, 标记位 ACK=1, 表示接收到客户端发送的释放连接的请求, 序号为 Seq=V, 确认号 Ack=U+1, 表示是在收到客户端报文的基础上, 将其序号 Seq+1 作为本段报文确认号Ack的值, 随后服务端开始准备释放服务端到客户端方向上的连接, 客户端收到从服务器端发出的 TCP 报文后, 确认了服务端收到了客户端发出的释放连接请求, 随后客户端结束 FIN-WAIT-1 阶段, 进入 FIN-WAIT-2 阶段

   > 前"两次挥手"既让服务端知道了客户端想要释放连接, 也让客户端知道了服务端了解了自己想要释放连接的请求, 于是, 可以确认关闭客户端到服务端方向上的连接了

3. 服务端自从发出 ACK 确认报文后, 经过 CLOSED-WAIT 阶段, 做好了释放服务端到客户端方向上的连接准备, 再次向客户端发出一段 TCP 报文, 标记位 FIN=1, ACK=1, 表示已经准备好释放连接了

   > 注意: 这里的 ACK 并不是确认收到服务端报文的确认报文, 序号为Seq=W, 确认号为Ack=U+1, 表示是在收到客户端报文的基础上将其序号 Seq 值加1作为本段报文确认号 Ack 的值, 随后服务端结束 CLOSE-WAIT 阶段, 进入 LAST-ACK 阶段, 并且停止在服务端到客户端的方向上发送数据, 但是服务端仍然能够接收从客户端传输过来的数据

4. 客户端收到从服务端发出的 TCP 报文, 确认了服务端已做好释放连接的准备, 结束 FIN-WAIT-2 阶段, 进入 TIME-WAIT 阶段, 并向服务端发送一段报文, 标记位 ACK=1, 表示接收到服务器准备好释放连接的信号, 序号为 Seq=U+1 表示是在收到了服务器端报文的基础上, 将其确认号 Ack 值作为本段报文序号的值, 确认号为 Ack=W+1, 表示是在收到了服务器端报文的基础上, 将其序号 Seq+1 值作为本段报文确认号的值, 随后客户端开始在 TIME-WAIT 阶段等待 2MSL

> 为什么要四次挥手?**(很重要)**

* 因为当 Server 端收到 Client 端的 SYN 连接请求报文后, 可以直接发送 SYN + ACK 报文, 其中 ACK 报文是用来应答的, SYN 报文是用来同步的
* 但是关闭连接时, 当 Server 端收到 FIN 报文时, 很可能不会立即关闭 SOCKET, 所以只能先回复一个 ACK 报文, 告诉 Client 端, "你发的 FIN 报文我收到了", 只有等到我 Server 端所有的报文都发送完了, 我才能发送 FIN 报文, 因此不能一起发送, 故需要四次挥手
* 客户端发送了 FIN 连接释放报文之后, 服务端收到了这个报文, 就进入了 CLOSE-WAIT 状态, 这个状态是为了让服务端发送还未传送完的数据, 传送完后, 服务端会发送 FIN 连接释放报文

> TIME-WAIT**(几乎必问)**

* 客户端接收到服务端的 FIN 报文后进入此状态, 此时不是直接进入 CLOSED 状态, 还需要等待一个时间计时器设置的时间 2MSL, 这么做有两个理由

  > MSL: 最大报文段生存时间

1. 确保最后一个确认报文能够到达, 如果 B 没收到 A 发送来的确认报文, 那就会重新发送连接释放请求报文, A 等待一段时间就是为了处理这种情况的发生

2. 等待一段时间是为了让本连接持续时间内所产生的所有报文都从网络中消失, 使下一个新连接不会出现旧连接请求报文

   > 2MSL等待的原因: 报文段有生存时间, 当连接关闭时有可能收到迟到的报文段, 这时若立马就建立新连接(同一端口)那么新连接就会接收迟到报文, 误以为是发给自己的

### 传输可靠性

> TCP 如何保证传输可靠性**(很重要)**

* 校验和

* 确认应答与序列号

* 超时重传: 发送方在发送完数据后等待一个时间, 时间到达还没接收到 ACK 报文, 那么对刚才发送的数据进行重新发送

* 连接管理: 三次握手与四次挥手

* 流量控制: TCP 根据接收端对数据的处理能力, 决定发送端的发送速度

  > TCP 报头信息中有一个16位字段的窗口大小, 发送方根据 ACK 报文里的窗口大小的值的改变进而改变自己的发送速度

* **拥塞控制**: 慢开始、拥塞避免、快重传、快恢复

  ![image-20201201194136972](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201194136972.png)

  ![image-20201201194335810](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201194335810.png)

  * 慢开始算法的思路就是, 不要一始就发送大量数据, 先探测一下网络的拥塞程度, 也就是说由小到大逐渐增加拥塞窗口的大小
  * 拥塞避免算法让拥塞窗口缓慢增长, 即每经过一个往返时间 RTT 就把发送方的拥塞窗口 cwnd加1而不是加倍, 这样拥塞窗口按线性规律缓慢增长
  * 快重传和快恢复: 发送方只要一连收到三个重复确认就应当立即重传对方尚未收到的报文段, 而不必继续等待设置的重传计时器时间到期



## IP数据报首部

> IP数据报 = 首部 + 数据
>
> 首部: 固定20字节 + 可选字段

![image-20200620193419735](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20200620193419735.png)

* 版本号(4位): IPv4 或 IPv6

* 首部长度(4位): IP数据报首部的长度

  > **首部长度占4位, 可表示最大值是$2^4-1=15$个单位, 一个单位4字节**
  >
  > **因此IP数据报首部长度最大值是60字节**

* 区分服务(8位): 服务类型

  > 包含一个4位优先权字段: 最小延时, 最大吞吐量, 最高可靠性, 最小费用

* 总长度(16位): (首部 + 数据)的长度

  > 单位为字节, 因此数据报最大长度$=2^{16}-1=65535$ 字节
  >
  > 总长度不得超过**最大传送单元(MTU)**

* 标识(16位): 计数器, 产生数据报的标识(不是序号), 每产生一个数据报就 + 1

* 标志(3位): 目前只有前2位有意义

  * 最低位是MF(More Fragment): 1表示"还有分片", 0表示"是最后一分片"

  * 中间位是DF(Don't Fragment): = 0 时才表示允许分片

    > DF = 1时禁止分片, 所以如果数据报太大则发送失败

* 片偏移(13位): 某分片在原分组中的相对位置, **片偏移以8字节为偏移单位**

  > 规定 一个偏移量 = 偏移了8字节

  ![image-20200620210556273](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20200620210556273.png)

* 生存时间(8位): TTL, 数据报在网络中可通过的路由器数的最大值, 每经过一个路由器就-1, 为0时丢弃

* 协议(8位): 指出此数据报携带的数据使用何种协议, 以便目的主机的IP层将数据部分上交给哪个处理过程

  > 区分上层协议, ICMP 为 1, TCP 为 6, UDP 为 17

  ![image-20200620213058067](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20200620213058067.png)

* 首部校验和(16位): 用 CRC 算法检验数据报首部是否在传输时损坏

  ![image-20200620213249676](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20200620213249676.png)

* 端口地址(32位): 标识该段报文来自哪里(源地址)以及要发送到哪里(目的地址)

## DNS

> Domain Name Server 域名服务器

* DNS 占用53号端口, 同时使用 TCP 和 UDP 协议
* DNS 区域传输的时候使用 TCP 协议
  1. 辅域名服务器会定时(一般3小时)向主域名服务器进行查询以便了解数据是否有变动, 如有变动, 会执行一次区域传送, 进行数据同步, 区域传送使用 TCP 而不是 UDP, 因为数据同步传送的数据量比一个请求应答的数据量要多得多
  2. TCP是一种可靠连接, 保证了数据的准确性
* 域名解析时使用 UDP 协议
  * 客户端向 DNS 服务器查询域名, 一般返回的内容都不超过512字节, 用 UDP 传输即可, 不用经过三次握手, 这样 DNS 服务器负载更低, 响应更快
  * 理论上说客户端也可以指定向 DNS 服务器查询时用 TCP, 但事实上很多 DNS 服务器进行配置的时候, 仅支持 UDP 查询包
* **访问域名时, 先访问本地 DNS 解析文件, 然后再去 DNS 服务器进行域名解析, 解析后访问对应 IP 地址服务器**

## HTTP

### 报文结构和状态码

> **重要**

* 请求格式: 请求行、请求头、空行、请求数据

  ![image-20201201200000558](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201200000558.png)

  ![image-20201201195904563](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201195904563.png)

* 返回格式(状态码): 状态行、消息报头、响应正文

  ![image-20201201200914912](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201200914912.png)

  ![image-20201201201018114](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201201018114.png)

  | 状态码 |             类别              | 含义                       |
    | :----: | :---------------------------: | :------------------------- |
  |  1XX   |  Informational 信息性状态码   | 接收的请求正在处理         |
  |  2XX   |      Success 成功状态码       | 请求正常处理完毕           |
  |  3XX   |   Redirection 重定向状态码    | 需要进行附加操作以完成请求 |
  |  4XX   | Client Error 客户端错误状态码 | 服务器无法处理请求         |
  |  5XX   | Server Error 服务端错误状态码 | 服务器处理请求出错         |

* 常见状态码

  * 200 OK: 客户端请求成功

  * 301 Moved Permanently: 永久性重定向

  * 302 Found: 临时性重定向

  * 400 Bad Request: 客户端请求有语法错误, 不能被服务器所理解

  * 401 Unauthorized: 请求未经授权, 这个状态码必须和 WwW-Authenticate 报头域一起使用

  * 403 Forbidden: 服务器收到请求, 但是拒绝提供服务

  * 404 Not Found: 请求资源不存在, 举个例子: 输入了错误的URL

  * 500 Internal Server Error: 服务器发生不可预期的错误

  * 503 Server Unavailable: 服务器当前不能处理客户端的请求, 一段时间后可能恢复正常

    > 举个例子: HTTP/1.1200 OK(CRLF)  CRLF = 回车换行

* HTTP 1.1新特性, 默认是长连接

  * 支持流水线
  * 支持同时打开多个 TCP 连接
  * 新增状态码100: 目前为止都很正常, 客户端可以继续发送请求或者忽略这个响应
  * 支持分块传输编码: 可以把数据分割成多块, 让浏览器逐步显示页面
  * 新增缓存处理指令 max-age: 通过有效期来指定 cookie 的持久性问题

* 缓存策略

  > Etag = Entity tag

  ![image-20201201202347476](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201201202347476.png)

### GET与POST

> **重要**

* 作用

  * GET 用于获取资源
  * POST 用于传输实体主体

* 参数: GET 和 POST 的请求都能使用额外的参数

  * GET 的参数是以查询字符串出现在 URL 中
  * POST 的参数存储在实体主体中

* 修改性: HTTP 方法不会改变服务器状态, GET 方法是安全的, 而 POST 不是

  > 因为 POST 的目的是传送实体主体内容, 这个内容可能是用户上传的表单数据, 上传成功之后, 服务器可能把这个数据存储到数据库中, 因此状态也就发生了改变

* 幂等性

  * GET/pageX HTTP/1.1 是幂等的, 连续调用多次, 客户端接收到的结果都是一样的
  * POST/add_row HTTP/1.1 不是幂等的, 如果调用多次就会增加多行记录

* 可缓存

  * GET 可缓存(响应状态码和 Cache-Control 保证是可缓存)
  * POST 不可缓存

* 底层

  * 对于 GET 请求, 浏览器会把 http header 和 data 一并发送出去, 服务器响应200(返回数据)
  * 对于 POST 请求, 浏览器先发送 header, 服务器响应100 continue, 浏览器再发送data, 服务器响应200 ok(返回数据)

* **浏览器与服务器通信原理**

  * 在浏览器输入主机名, 先访问本地 DNS 解析文件尝试进行 IP 地址解析

  * 上一步如果无果, 则再去 DNS 服务器进行域名解析, 解析后访问对应 IP 地址服务器

  * 浏览器根据 IP 地址连接到服务器后, 就是用 HTTP 协议向服务器发送请求

  * 发送请求过程中浏览器会向服务器以**流**的形式传输数据, 告诉服务器要访问哪个资源

    > HTTP 协议就是浏览器和服务器之间定义的协议, 互相可以理解对方的表达

  * 浏览器等待 web 服务器把想要访问的资源传输给浏览器

  * 服务器收到浏览器传输的数据, 解析数据, 例如解析"GET /1.jsp HTTP/1.1"得知浏览器想访问1.jsp

  * 于是服务器去读取该资源的内容, 再以流的形式传输给浏览器

  * 浏览器接收到服务器数据后, 对其解析并显示在页面上

### URL

> 统一资源定位符

* URI 是根据某个协议方案表示的资源定位符, HTTP是其中一种

  > 此外, 标准协议还有 FTP, Mailto, Telnet, File 等30多种

* URI 和 URL 的差别在于 identifer 和 locator 上, URL 是 URI 的子集, URI 是抽象的, 高层次概念, URL 和 URN 则是具体的资源标识方式

  > identifer 标记, 告诉你有个东西叫什么
  >
  > locator 查询地址, 不仅告诉你有个东西叫什么, 还精确定位到具体位置

* URL 类: Java 中根据一个 URL 对象可获取 URL 的一系列信息, 比如主机名、端口、要访问的文件等, 并且可以建立输入流, 读取从服务器传送下来的数据

### Cookie与Session

> **重要**

* Cookie 是服务器发送到用户浏览器并保存在本地的一小块数据

  * 它会在浏览器之后向同一服务器再次发起请求时被携带上, 用于告知服务端两个请求是否来自同一浏览器
  * 可用作会话状态管理(如用户登录状态、购物车、游戏分数或其它需要记录的信息)、个性化设置(如用户自定义设置、主题等)、浏览器行为跟踪(如跟踪分析用户行为等)
  * 可能被浏览器禁用

* Session 存储在服务端, 存储在服务器端的信息更加安全

  > 使用 Session 维护用户登录状态的过程如下(需要 cookie 作为传输机制)

  * 用户进行登录时, 用户提交包含用户名和密码的表单, 放入 HTTP 请求报文中
  * 服务器验证该用户名和密码, 如果正确则把用户信息存储到 Redis 中, 它在 Redis 中的 Key 称为 Session ID
  * 服务器返回的响应报文的 Set-Cookie 首部字段包含了这个 Session ID, 客户端收到响应报文之后将该 Cookie 值存入浏览器中
  * 客户端之后对同一个服务器进行请求时会包含该 Cookie, 服务器收到之后提取出 Session ID, 从 Redis 中取出用户信息, 继续之前的业务操作

* 区别: 都是会话技术

  * **Cookie 只能存储 ASCII 码字符串, 而 Session 则可以存取任何类型的数据**, 因此在考虑数据复杂性时首选 Session
  * Cookie 存储在浏览器中, 容易被恶意查看, 如果非要将一些隐私数据存在 Cookie 中, 可以将 Cookie 进行加密, 然后在服务器进行解密
  * 对于大型网站, 如果用户所有的信息都存储在 Session 中, 开销是非常大的, 因此不建议将所有用户信息都存储到 Session 中
* 存在的位置
  * Cookie 存在于客户端, 临时文件夹
  * Session 存在于服务器端
  * 安全性
    * Cookie 有安全隐患, 通过拦截或者本地文件得到 Cookie 进行攻击
    * Session 相对比较安全
  * 大小限制
    * Cookie 有大小限制, 单个不超过4K, 浏览器中 Cookie 个数也有限制
    * Session 没有大小限制, 和服务器内存有关
  * 生命周期
    * Cookie 生命周期可以设置, 默认是一次会话的时间
    * Session 生命周期是间隔的, 关闭服务器会造成周期结束

### 短连接、长连接、流水线

* 当浏览器访问一个包含多张图片的 HTML 页面时, 除了请求访问 HTML 页面资源, 还会请求图片资源

* 如果每进行一次 HTTP 通信就要新建一个 TCP 连接, 开销会很大

* **长连接只需要建立一次 TCP 连接就能进行多次 HTTP 通信**

* 从 HTTP/1.1 开始默认是长连接的, 如果要断开连接, 需要由客户端或者服务器端提出断开, 使用 Connection: close

* 在 HTTP/1.1 之前默认是短连接的, 如果需要使用长连接则使用 Connection: Keep-Alive

* 流水线

  > 默认情况下, HTTP 请求是按顺序发出的, 下一个请求只有在当前请求收到响应之后才会被发出, 由于会受到网络延迟和带宽的限制, 在下一个请求被发送到服务器之前, 可能需要等待很长时间
  >
  > 流水线是在同一条长连接上发出连续的请求, 而不用等待响应返回, 这样可以避免连接延迟

### 安全性问题

* 使用明文进行通信, 内容可能会被窃听

* 不验证通信方的身份, 通信方的身份有可能遭遇伪装

* 无法证明报文的完整性, 报文有可能遭篡改

* 通过使用 SSL, HTTPS 具有了加密(防窃听)、认证(防伪装)和完整性保护(防篡改)

* HTTPS 采用混合的加密机制, 使用非对称密钥加密用于传输对称密钥来保证传输过程的安全性, 之后使用对称密钥加密进行通信来保证通信过程的效率

* HTTPS 加密过程

  1. 客户使用 https 的 URL 访问 Web 服务器, 要求与 Web 服务器建立 SSL 连接
  2. Web 服务器收到客户端请求后, 会将网站的证书信息(证书中包含公钥)传送份给客户端
  3. 客户端的浏览器与 Web 服务器开始协商 SSL 连接的安全等级, 也就是信息加密的等级
  4. 客户端的浏览器根据双方同意的安全等级, 建立会话密钥, 然后利用网站的公钥将会话密钥加密, 并传送给网站
  5. Web 服务器利用自己的私钥解密出会话密钥
  6. Web 服务器利用会话密钥加密与客户端之间的通信

  * 缺点: 因为需要进行加密解密等过程, 因此速度会更慢; 需要支付证书授权的高额费用

### HTTP与FTP

* 相同点
  * 都是应用层协议
  * 都使用 TCP(而不是UDP)作为其支撑的运输层协议
* 不同点
  * HTTP 是超文本传输协议, 面向网页; FTP是文件传输协议, 面向文件
  * FTP 的控制信息是带外(out-of-band)传送的, 而 HTTP 的控制信息是带内(in-band)传送的
  * FTP 服务器必须在整个会话期间保留用户的状本(state)信息, 而 HTTP 是无状态的
  * FTP 使用两个并行的 TCP 连接来传输文件, 一个是控制连接(control connection), 一个是数据连接(data connection), FTP 的控制连接是持久连接, 数据连接是非持久连接; 而 HTTP 既可以使用非持久连接, 也可以使用持久连接

### 输入网址后发生的事

> **很重要**

> https://www.cnblogs.com/yushuo1990/p/5984232.html

* 回答该问题可以把每个环节尽量说详细最好, 是属于比较开放的, 但是大致流程如下

1. 浏览器查找该域名的 IP 地址

   > DNS 域名解析, 浏览器缓存, 系统缓存, 路由器缓存, ISP DNS 服务器, 根域名服务器
   >
   > 如果用到 CDN 内容分发网络, 本质是在现有网络结构中增加了一层(客户端 + CDN + 服务器), CDN 包括高速缓存和整体负载均衡(GSLB), 主要缓存**静态资源**
   >
   > 理解: 当发送一个网址时, 先去 DNS 域名解析到 CDN 负载均衡系统, 然后把响应最快的 IP 缓存节点服务器(第一次访问, 得向源服务器请求内容, 进行缓存)返回给用户

2. 浏览器根据解析得到的 IP 地址向 web 服务器发送一个 HTTP 请求

> 就是建立 Socket 通信的过程
>
> HTTP 请求的协议: 请求行、请求头、请求体、状态码

3. 服务器收到请求并进行处理

   > 负载均衡: 对工作任务进行平衡, 如图片服务器、应用服务器, 分为链路负载均衡、集群负载均衡、操作系统负载均衡
   >
   > 反向代理

4. 服务器返回一个响应(响应状态码)

5. 浏览器对该响应进行解码, 渲染显示

6. 页面显示完成后, 浏览器发送异步请求, 持续更新一些页面信息

### 心跳机制

> 大数据中用到心跳机制的关键点

* YARN 中, RM 和 AM, RM 和 NM 之间都有心跳机制
* ZooKeeper 当中会话激活
* Storm 调度框架
* HBase 客户端和 HMaster 之间

# 操作系统

## 进程、线程、协程

* 进程、线程、协程**(很重要)**

  > 直白地讲, 进程就是应用程序的启动实例, 比如运行一个游戏, 打开一个软件, 就是开启一个进程
  >
  > 进程拥有代码和打开的文件资源、数据资源、独立的内存空间
  >
  > 线程从属于进程, 是程序的实际执行者, 一个进程至少包含一个主线程, 也可以有更多的子线程
  >
  > 线程拥有自己的栈空间
  >
  > **对操作系统来说, 线程是最小的执行单元, 进程是最小的资源管理单元**

  * 进程 Process 是计算机中的程序关于某数据集合上的一次运行活动, **是系统进行资源分配和调度的基本单位**
  * 线程 Thread 是**操作系统能够进行运算调度的最小单位**, 被包含在进程中, **是进程中的实际运作单位**
  * 协程 Coroutine 比线程更轻量级, 如一个进程可拥有多个线程一样, 一个线程可拥有多个协程, 协程不是被操作系统内核所管理的, 而完全由程序所控制, 也就是在用户态执行, 性能大幅度提升, 因为不会像线程切换那样消耗资源, 协程不是进程也不是线程, 而是一个特殊的函数, 这个函数可以在某个地方挂起, 并且可以重新在挂起处外继续运行, 所以协程与进程、线程并不是一个维度的概念

  ![image-20201128213612903](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201128213612903.png)

* 线程与进程**(很重要)**

  * **进程是资源分配的基本单位**, 线程可以访问隶属进程的资源但是不拥有资源
  * **线程是独立调度的基本单位**, 进程的一个执行流, 是 CPU 调度和分派的基本单位, 比进程更小的能独立运行的基本单位
  * 创建或撤销进程时, 系统要分配或回收资源(如内存空间、IO设备), 所付出的开销远大于创建撤销线程; 在进行进程切换时, 涉及当前执行进程 CPU 环境的保存以及新调度进程 CPU 环境的设置, 而线程切换只需保存和设置少量寄存器内容, 开销很小
  * 线程间通过直接读写同一进程中的数据进行通信, 而进程间要借助 IPC

* 协程和进程**(很重要**)

  * **协程是一种用户态的轻量级线程**, 协程的调度完全由用户控制
  * 协程拥有自己的寄存器上下文和栈, 协程调度切换时, 将寄存器上下文和栈保存到其他地方, 切回来时恢复先前保存的寄存器上下文和栈, 直接操作栈则基本没有内核切换的开销, 可以不加锁的访问全局变量, 所以上下文切换快
  * 一个线程可以有多个协程, 一个进程也可以单独拥有多个协程
  * 线程进程都是同步机制, 而协程是异步
  * 协程能保留上一次调用时的状态, 每次过程重入时, 就相当于进入上一次调用的状态

* 进程间通信方式**(很重要)**

  > 消息队列、共享内存、无名管道、命名管道、信号量、Socket

  * 父子进程关系管道 Pipe 是一种半双工通信方式, 数据单向流动, 而且只能在有**亲缘关系**的进程间使用(亲缘关系指的是父子进程关系)
  * **命名管道 Named Pipe** 有名管道也是半双工通信方式, 但允许**无亲缘关系**进程间的通信
  * **消息队列 Message Queue 是消息的链表, 存放在内核中并由消息队列标识符标识, 克服了信号传递少、管道只能承载无格式字节流以及缓冲区大小受限等缺点**
  * **共享内存 Shared Memory** 就是映射一段能被其他其他进程所访问的内存, 这段共享内存由一个进程创建, 多个进程访问, 共享内存最快的方式是 IPC, 它是针对其他进程间通信方式运行效率低而设计的, 往往与其他通信机制如信号量配合使用来实现进程间的同步和通信
  * **信号量 Semaphore**: 信号量是一个计数器, 用来控制多个进程对共享资源的访问, 常作为一种锁机制来防止某进程正在访问共享资源时, 其他资源也访问该资源, 因此主要作为进程间以及同一进程内不同线程间的同步手段
  * **套接字 Socket 可用于不同机器间的进程通信**
  * 信号 Signal 是比较复杂的通信方式, 用于**通知**接收进程**某个事件已经发生**

## 死锁

> **重要**

* 必要条件(Java 死锁也是如此)
  * 互斥: 每个资源要么已经分配给一个进程, 要么是可用的
  * 占有和等待: 已经得到了某个资源的进程可以再请求新的资源
  * 不可抢占: 已经分配给一个进程的资源不能强制性地被抢占, 该资源只能被占有它的进程显示地释放
  * 环路等待: 有两个或以上的进程组成一条环路, 该环路的每个进程都在等待下一个进程释放资源
* 处理方法
  * 鸵鸟策略: 处理死锁问题的办法仅仅是忽略它
  * 死锁检测与死锁恢复: 不试图阻止死锁, 而是检测到死锁发生时, 采取措施进行恢复, 利用抢占恢复、回滚恢复、通过杀死进程恢复
  * 死锁预防: 破坏死锁必要条件
  * 死锁避免: 程序运行期间避免死锁
* 什么是活锁?
  * 与死锁恰恰相反, 死锁是大家都占用着对方的资源, **活锁是拿到资源却相互释放不执行**
  * 当多线程中出现互相谦让, 都主动将资源释放给别的线程使用, 资源在多个线程间跳动却得不到执行

## 内存管理

> **很重要**

### Linux虚拟内存

* 操作系统将内存抽象成虚拟的地址空间, 每个程序拥有自己的地址空间

* 这个地址空间被分割成多个块, 每一块称为一页, 这些页被映射到物理内存(==页框==)

* 页码和存放该页映像的页框填入一个叫做==页表==的表项中

* 页表的表项中设置一些访问控制字段, 用于指明对应页面中的内容允许何种操作, 从而禁止非法访问

* ==内存管理单元(MMU)==管理着虚拟内存的地址和物理内存的转换, 其中的页表存储着页和页框的映射表

  > 页: 程序地址空间
  >
  > 页框: 物理内存空间

* 虚拟内存的作用

  * 内存完整性: 每个进程都认为自己获取的内存是一块连续的地址

  * 安全: 操作系统在页表的各个项目上添加各种==访问权限标识符==, 就可以实现内存的权限控制

  * 数据共享: 通过虚拟内存更容易实现内存和数据的共享

  * ==SWAP==: 虚拟内存可以帮进程"扩充"内存

    > Linux 提出 SWAP 的概念, Linux 中可以使用 SWAP 分区, 在分配物理内存但可用内存不足时, 将暂时不用的内存数据先放到磁盘上, 让有需要的进程先使用, 等进程需要使用这些数据时再将这些数据加载到内存中, 通过这种"交换"技术, Linux 可以让进程使用更多内存

* 请页

  * 当处理器试图访问一个虚存页面时, 首先到页表中查询该页是否已映射到物理页框并记录在页表中
  * 如果在, MMU 会把页码转换成页框码
  * 如果不在, MMU就会通知操作系统"发生了一个页面访问错误(页面错误)"
  * 接下来操作系统会启动"请页"机制, 即调用系统操作函数, 判断该虚拟地址是否为有效地址
  * 如果是有效地址, 就从虚拟内存中将该地址指向的页面读入到内存中的一个**空闲**页框, 并在页表中添加相应的表项, 最后处理器将从发生页面错误的地方重新开始运行
  * 如果是无效地址, 则表明进程试图访问一个不存在的虚拟地址, 此时操作系统终止此次访问

* SWAP

  * 请页成功后, 如果没有空闲物理页框, 则启动"交换"机制, 即调用内核操作函数, 在物理页框中寻找一个不再使用或者近期可能不会用到的页面所占据的页框
  * 找到后把其中的页移出, 以装载新的页面
  * 如果该页未被修改过, 则删除它
  * 如果该页曾被修改过("脏"页), 则系统必须将该页写回磁盘

* 页面置换算法

  > 目的是选出一个最合适的物理页框, 将其淘汰或者存储的磁盘, 使得置换效率最高

  * 最佳置换算法 OPT
  * 先进先出算法 FIFO
  * ==近期最久未使用过算法 LRU==(最常问)
  * CLOCK 置换算法 NRU
  * 页面缓冲算法 PBA
  * 近期最少使用算法 LFU

  > 和缓存淘汰策略类似, 可以将内存看成磁盘的缓存, 在缓存系统中大小有限, 当新缓存到达时, 需要淘汰一部分已经存在的缓存, 才有空间存放新的数据
  >
  > **为了实现 LRU, 需要在内存中维护一个所有页面的链表, 当一个页面被访问时将其移到链表头, 这样就保证链表尾部是最近最久未访问的**

* 加快分页进程

  > 如何提高虚拟和物理地址映射速度?(快表)

  * 系统一旦访问了某一页, 那么系统就会在一段时间内稳定工作在这个页上
  * 为了提高访问页表的速度, 系统还配备了一组正好容纳一个页表的==硬件寄存器==
  * 这样当系统再访问虚拟内存时, 就首先到这组硬件寄存器中去访问, 提高效率
  * 这组存放当前页表的寄存器叫做==快表==

  > 如果页表很大如何解决?
  >
  > 采用多级页表, 对页表也进行分页存储, 在程序运行时只把需要的页复制到内存中, 而暂时不需要的页就留在辅存中


### 分页与分段

* 对程序员的透明性: 分页透明, 但分段需要程序员显示划分每个段

* 地址空间的维度: 分页是一维地址空间, 分段是二维的

  > 程序员在标识一个地址时, 既需要给出段名又要给出段内地址

* 大小是否可变: 页的大小不可变, 段的大小可动态改变

* 出现原因

  * 分页主要用于实现虚拟内存, 从而获得更大空间
  * 分段主要为了使程序和数据可以被划分为**逻辑上独立的地址空间并且有助于共享和保护**

## IO管理

> **很重要**

### IO模型

> 第一步通常涉及等待数据从网络中到达, 当所等待数据到达时, 它被复制到内核中的某个缓冲区
>
> 第二步就是把数据从内核缓冲区复制到应用进程缓冲区

* 阻塞式IO: 应用进程被阻塞, 直到数据从内核缓冲区复制到应用进程缓冲区才返回
* 非阻塞式IO: 应用进程可以继续执行, 但是需要不断的执行系统调用来获知IO是否完成(polling 轮询)
* IO复用(select, poll, epoll): 单个进程具有处理多个IO事件的能力
* 信号驱动式IO(SIGIO): 内核在数据到达时向应用进程发送 SIGIO 信号
* 异步IO(AIO): 内核完成所有操作后向应用进程发送信号

### IO复用技术

> 多个描述符的IO操作都能在一个线程内并发交替地顺序完成, 这就是"IO多路复用"
>
> 这里的复用指的是复用同一个进程或线程

* int select(int n, fd_set *readset, fd_set *writeset, fd_set *exceptset, struct timeval *timeout);

  > 有三种描述符类型: readset、writeset、exceptset, 分别对应读、写、异常条件的描述符集合, 底层是数组实现

* int poll(struct pollfd *fds, unsigned int nfds, int timeout);

  > pollfd 是链表实现

* 以上两者区别

  * 都采用轮询方式处理
  * 本质区别是对于描述符的数据结构的定义, select 是用三个事件类型, 一个数组, poll 只有一个链表, 每个节点含有描述和事件定义
  * select 的描述符是用数组实现, FD_SIZE 大小默认为1024, 因此默认只能监1024个描述符
  * 而 poll 的描述符类型使用了链表实现, 没有描述符数量的限制
  * poll 提供了更多的事件类型, 并且对描述符的重复利用上比 select 高

* epoll

  * poll_ctl()用于向内核注册新的描述符或者是改变某个文件描述符的状态

  * 已注册的描述符在内核中会被维护在一棵红黑树上, 通过回调函数内核会将IO准备好的描述符加入到一个链表中管理, 进程调用 epoll_wait()可以得到事件完成的描述符

  * 工作模式

    > LT(电平触发): 当 epoll_wait()检测到描述符事件到达时, 将此事件通知进程, 进程可以不立即处理该事件, 下次调用 epoll_wait()会再次通知进程

    > ET(边沿触发): 通知之后进程必须立即处理事件, 减少了同一事件的触发次数, 效率更高, 相对于 select 和 poll, epoll 最大优势是采用回调的方式检测就绪实现, 无需遍历, 时间复杂度O(1)

# Linux

* 如何找回root用户的密码

  * 进入到单用户模式

    > 单用户不需要密码就可以登录root

* 百度: 列举6个Linux常用命令

  * netstat: 显示网络状态

  * top: 实时显示进程的动态

  * lsblk: 列出所有可用块设备的信息, 显示他们之间的依赖关系

    > 块设备有硬盘, 闪存盘, cd-ROM等等

  * find: 在指定目录下查找文件

  * ps: 显示当前进程的状态

  * chkconfig: 检查, 设置系统的各种服务

* 瓜子二手车: Linux查看内存、磁盘储存、IO读写、端口占用、进程等命令

  * top

## 文件系统原理

> 特别是 inode 和 block

### 文件系统主要组成

* inode: 一个文件占用一个 inode, 记录文件的属性, 同时记录此文件的内容所在的 block 编号

  > 区别目录: 建立一个目录时, 会分配一个 inode 与至少一个 block, block 记录的内容是目录下所有文件的 inode 编号以及文件名

* block: 记录文件的内容, 文件太大时会占用多个 block

### inode

> inode 具体包含以下信息

* 权限(read/write/excute)
* 拥有者与群组(owner/group)
* 容量
* 建立或状态改变的时间(ctime)
* 最近一次的读取时间(atime)
* 最近修改的时间(mtime)
* 定义文件特性的旗标(flag), 如 SetUID
* 该文件真正内容的指向 pointer
* 特点
  * 每个 inode 大小均固定为 128 byte(新的 ext4 与 xfs 可设定到 256 byte)
  * 每个文件都仅会占用一个 inode

## 硬链接与软链接

> **重要**

* 硬链接(hard link): A 是 B 的硬链接(A 和 B 都是文件名), 则 A 的目录项中的 inode 节点号与 B 的目录项中的 inode 节点号相同

  > 即一个 inode 节点对应两个不同的文件名, 两个文件名指向同一个文件
  >
  > A 和 B 对系统来说完全平等
  >
  > 不能跨越文件系统, 不能对目录进行链接

* 软链接(soft link): A 是 B 的软链接, A 的目录项中的 inode 节点号与 B 的目录项中的 inode 节点号不同

  > A 和 B指向不同的 inode, 继而指向两块不同的数据块
  >
  > 但是 A 的数据块存放的只是 B 的路径名(可以根据这个找到 B 的目录项)

## 异常进程

### 孤儿进程

* 一个父进程退出, 而它的一个或多个子进程还在运行, 那么这些子进程成为"孤儿进程"
* 孤儿进程将被 init 进程(进程号为1)所收养, 并由 init 进程对它们完成状态收集工作

### 僵尸进程

* 一个子进程的进程描述符在子进程退出时不会释放

* 只有当父进程通过 wait()或 waitpid()获取了子进程信息后才会释放

* 如果子进程退出, 而父进程并没有调用 wait()或 waitpid(), 那么子进程的进程描述符仍保存在系统中

  > 这种进程称为"僵尸进程"

* 僵尸进程通过 ps 命令显示出来的状态为 Z(Zombie)

* 要消灭系统中大量的僵尸进程, 只需要将其父进程杀死, 此时僵尸进程变为孤儿进程, 被 init 进程收养

## 常用命令

> **很重要**

* tail -n 1000: 显示最后1000行

* tail -n +1000: 显示从1000行到末尾

* tail -f: 动态显示文件

* head -n 1000: 显示最前1000行

* sed -n '5,10p' filename 查看文件的第5到10行

  > 使用 sed 查看中间几行

* more 和 less

* top: 动态显示总的 CPU 和内存情况以及每个进程的 CPU 和内存占用率

* ps: 查看当前运行的进程

* netstat: 观察端口占用, 加上 grep 过滤端口

  ```bash
  netstat -apn | grep 8080
  ```

* df: 查看所有磁盘使用情况

* du: 查看当前指定文件或目录占用磁盘空间大小(会递归显示子目录)

* lsof: 查看一个进程打开了哪些文件

* 查找命令

  * which: 可执行文件
  * whereis: 用于程序名的搜索, 而且只搜索二进制文件
  * locate: 从本机数据库中搜索
  * find: 全盘扫描

# MySQL

* MySQL引擎
* InnoDB底层原理
* 索引
* 索引优化

# Redis

# Web

* 网站是如何进行访问的?
  1. 输入域名, 回车
  2. 检查本机的 C:\Windows\System32\drivers\etc\hosts 配置文件下有没有该域名的映射
    1. 找的到就直接返回对应IP地址, 访问该web
    2. 找不到就去DNS服务器找
      1. 找得到就返回对应IP地址并访问
      2. 找不到则返回"无法访问此网站"

* 浏览器从输入地址按下回车到显示页面, 经历了什么?

1.

* 重定向和请求转发的区别

  * 相同点: 网页都会跳转
  * 不同点:
    * 请求转发时URL不会变化
    * 重定向时URL会变化



# Spring



# MyBatis



# Hadoop



# Kafka



# Flink



# HBase



# 其他

* leader面、总监面、HR面不能不准备的经典问题: https://mp.weixin.qq.com/s?__biz=MzU5MDQ3ODIwMA==&mid=2247489148&idx=1&sn=64ffc0240ca2aafacf3112829b238d67&source=41#wechat_redirect

