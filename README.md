# Java

* Java 语言的三个特征: 封装、继承、多态

* Java 致力于检查程序在编译和运行时的错误

* Java 自己操纵内存减少了内存出错的可能性

* Java 虚函数

  > 虚函数存在是为了多态

  > Java 中其实并没有虚函数的概念, Java 普通函数==相当于==C++ 的虚函数
  >
  > 动态绑定是 Java 中的默认行为, 如果不希望某个函数具有虚函数特性, 用 final 修饰成为非虚函数

* 指令 javac 的作用: 将源程序编译成字节码

* 问: static 关键字的作用是什么? **(重要)**

  * 修饰成员变量: 因为类加载进==方法区==, 所以类的所有对象共享
  * 修饰方法: 无需建立对象, 直接用"类名.方法()"调用
  * 修饰代码块: 只会在类被初次加载时执行一次, 可用于初始化等操作
  * 修饰内部类

  > 一般方法可以访问静态方法, 静态方法必须访问静态

## 数据类型

* Java 实现了真数组, 避免了覆盖数据的可能

  > **注意, 是避免数据覆盖的可能, 而不是数据覆盖类型**
  >
  > 数据被覆盖是指在计算机中因粘贴使原有数据被现有数据所占有, 就称被覆盖, 使原有数据消失
  >
  > Java 数组元素在内存中是一个接着一个线性存放的, 通过第一个元素就能访问随后的元素, 这样的数组称之为"真数组", 实现了真数组为 Java 语言健壮性的特点之一

## 变量

* Java 变量存储位置

  > 类中的成员变量存放在堆区
  >
  > 方法中的局部变量存放在栈区

  * 堆区: 只存放类对象, 线程共享
  * 方法区(静态存储区): 存放 class 文件和静态数据, 线程共享
  * 栈区: 存放方法局部变量, 基本类型变量区、执行环境上下文、操作指令区, 线程不共享
  
* final 关键字**(重要)**

  * 修饰变量, 该变量只能被赋值一次且无法改变

    > 对于 static final 成员变量, 必须在声明时初始化
    >
    > 对于非静态成员变量, 必须在声明时或者构造方法中赋值

  * 修饰方法的形参, 在变量的生存期中它的值不能被改变

  * 修饰方法, 该方法无法被重写

  * 修饰类, 该类无法被继承

## 方法

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

## 类与对象

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



## 接口

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

## 集合

### HashMap

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

* ArrayList 和 LinkedList
  * ArrayList 是实现了基于动态数组的数据结构, LinkedList 是基于链表的数据结构
  * 对于随机访问 get()和 set(), ArrayList 优于 LinkedList, 因为 LinkedList 要移动指针
  * 对于新增和删除操作 add()和 remove(), LinkedList 更优, 因为 ArrayList 要移动数据

## IO

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

## 反射

* 反射就是在**运行时**能够知道一个类的所有属性和方法, 能够调用一个对象的所有方法和属性(且能修改属性)
* Class.forName(className)和 ClassLoader.getSystemClassLoader().loadClass(className)
  * forName()除了将类的.class 文件加载到 JVM 中之外, 还会对类进行解释, 执行类中的静态部分, forName()得到的类已经是初始化完成的
  * loadClass()只将类的.class 文件加载到 JVM 中, 只在 newInstance()时才会执行静态部分
  * 最重要的区别是 forName()会初始化 Class, loadClass()不会
  * **如果要求加载时类的静态变量被初始化或静态代码块被执行就只能用 forName()**

## 多线程

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

* Java 虚拟机的功能

  * 通过 ClassLoader 寻找和装载 class 文件
  * 解释字节码成为指令并执行, 提供 class 文件的运行环境
  * 进行运行期间垃圾回收
  * 提供与硬件交互的平台

### 内存区域

> **运行时数据区(很重要)**

![image-20201129164347560](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201129164347560.png)

![image-20201129164909386](C:\Users\84564\AppData\Roaming\Typora\typora-user-images\image-20201129164909386.png)

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





# 算法

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

  1. 构造方法私有化
  2. 类中创建一个私有静态的本类对象
  3. 定义一个公有静态方法将该对象返回

* 懒汉式: 延迟加载对象, 对象在公有方法中创建, 存在线程安全问题

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

* 定义: 定义一系列的算法, 把它们一个个封装起来, 并且使它们可相互替换

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

# 操作系统

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

# MySQL

* MySQL引擎
* InnoDB底层原理
* 索引
* 索引优化



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



# Linux

1. 如何找回root用户的密码

   * 进入到单用户模式

     > 单用户不需要密码就可以登录root

2. 百度: 列举6个Linux常用命令

   * netstat: 显示网络状态

   * top: 实时显示进程的动态

   * lsblk: 列出所有可用块设备的信息, 显示他们之间的依赖关系

     > 块设备有硬盘, 闪存盘, cd-ROM等等

   * find: 在指定目录下查找文件

   * ps: 显示当前进程的状态

   * chkconfig: 检查, 设置系统的各种服务

3. 瓜子二手车: Linux查看内存、磁盘储存、IO读写、端口占用、进程等命令

   * top





# Hadoop



# Kafka



# Flink



# Redis



# HBase



# 其他

* leader面、总监面、HR面不能不准备的经典问题: https://mp.weixin.qq.com/s?__biz=MzU5MDQ3ODIwMA==&mid=2247489148&idx=1&sn=64ffc0240ca2aafacf3112829b238d67&source=41#wechat_redirect

