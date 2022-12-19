
Java中多态其实是一种运行期的状态。为了实现运行期的多态，或者说是动态绑定，需要满足三个条件：

有类继承或者接口实现
子类要重写父类的方法
父类的引用指向子类的对象
单一职责原则（Single-Responsibility Principle）
开放封闭原则（Open-Closed principle）
里氏替换原则（Liskov-Substitution Principle）
依赖倒置原则（Dependecy-Inversion Principle）
接口隔离原则（Interface-Segregation Principle）


重载：指的是在同一个类中，多个函数或者方法有同样的名称，但是参数列表不相同的情形，这样的同名不同参数的函数或者方法之间，互相称之为重载函数或者方法。

重写：指的是在Java的子类与父类中有两个名称、参数列表都相同的方法的情况。由于他们具有相同的方法签名，所以子类中的新方法将覆盖父类中原有的方法。


继承指的是一个类（称为子类、子接口）继承另外的一个类（称为父类、父接口）的功能，并可以增加它自己的新功能的能力。所以，继承的根本原因是因为要复用，而实现的根本原因是需要定义一个标准。
另外，在接口中只能定义全局常量（static final）和无实现的方法（Java 8以后可以有default方法）；而在继承中可以定义属性方法，变量，常量等。


继承是一种is-a关系。
组合(Composition)体现的是整体与部分、拥有的关系，即has-a的关系。
多用组合、少用继承



类变量、成员变量和局部变量
Java中共有三种变量，分别是类变量、成员变量和局部变量。他们分别存放在JVM的方法区、堆内存和栈内存中。

    /**
     * @author Hollis
     */
    public class Variables {
    
        /**
         * 类变量
         */
        private static int a;
    
        /**
         * 成员变量
         */
        private int b;
    
        /**
         * 局部变量
         * @param c
         */
        public void test(int c){
            int d;
        }
    }
复制ErrorOK!
上面定义的三个变量中，变量a就是类变量，变量b就是成员变量，而变量c和d是局部变量。

a作为类变量，他存放在方法区中；b作为成员变量，和对象一起存储在堆内存中（不考虑栈上分配的情况）；c和d作为方法的局部变量，保存在栈内存中。

之所以要在这一章节重点介绍下这三种变量类型，是因为很多人因为不知道这三种类型的区别，所以不知道他们分别存放在哪里，这就导致不知道那些变量需要考虑并发问题。

关于并发问题，目前本书《基本篇》还不涉及，会在下一本《并发篇》中重点介绍，这里先简单说明一下：

因为只有共享变量才会遇到并发问题，所以，变量a和b是共享变量，变量c和d是非共享变量。所以如果遇到多线程场景，对于变量a和b的操作是需要考虑线程安全的，而对于线程c和d的操作是不需要考虑线程安全的。



所以，Java之所以可以做到跨平台，是因为Java虚拟机充当了桥梁。他扮演了运行时Java程序与其下的硬件和操作系统之间的缓冲角色。


这里我们来举一个形象的例子。再来深入理解一下传值调用和传引用调用：

你有一把钥匙，当你的朋友想要去你家的时候，如果你直接把你的钥匙给他了，这就是引用传递。

这种情况下，如果他对这把钥匙做了什么事情，比如他在钥匙上刻下了自己名字，那么这把钥匙还给你的时候，你自己的钥匙上也会多出他刻的名字。

你有一把钥匙，当你的朋友想要去你家的时候，你复刻了一把新钥匙给他，自己的还在自己手里，这就是值传递。

这种情况下，他对这把钥匙做什么都不会影响你手里的这把钥匙。


值传递和引用传递最大的区别是传递的过程中有没有复制出一个副本来，如果是传递副本，那就是值传递，否则就是引用传递。

在Java中，其实是通过值传递实现的参数传递，只不过对于Java对象的传递，传递的内容是对象的引用。


8种基本数据类型
Java中有8种基本数据类型分为三大类。

字符型
char

布尔型
boolean

数值型
1.整型：byte、short、int、long

2.浮点型：float、double

String不是基本数据类型，是引用类型。


整型中byte、short、int、long的取值范围
Java中的整型主要包含byte、short、int和long这四种，表示的数字范围也是从小到大的，之所以表示范围不同主要和他们存储数据时所占的字节数有关。

先来个简单的科普，1字节=8位（bit）。java中的整型属于有符号数。

先来看计算中8bit可以表示的数字：

最小值：10000000 （-128）(-2^7)

最大值：01111111（127）(2^7-1)

整型的这几个类型中，

　　byte：byte用1个字节来存储，范围为-128(-2^7)到127(2^7-1)，在变量初始化的时候，byte类型的默认值为0。

　　short：short用2个字节存储，范围为-32,768 (-2^15)到32,767 (2^15-1)，在变量初始化的时候，short类型的默认值为0，一般情况下，因为Java本身转型的原因，可以直接写为0。

　　int：int用4个字节存储，范围为-2,147,483,648 (-2^31)到2,147,483,647 (2^31-1)，在变量初始化的时候，int类型的默认值为0。

　　long：long用8个字节存储，范围为-9,223,372,036,854,775,808 (-2^63)到9,223,372,036, 854,775,807 (2^63-1)，在变量初始化的时候，long类型的默认值为0L或0l，也可直接写为0。

上面说过了，整型中，每个类型都有一定的表示范围，但是，在程序中有些计算会导致超出表示范围，即溢出。如以下代码：

    int i = Integer.MAX_VALUE;
    int j = Integer.MAX_VALUE;

    int k = i + j;
    System.out.println("i (" + i + ") + j (" + j + ") = k (" + k + ")");
复制ErrorOK!
输出结果：i (2147483647) + j (2147483647) = k (-2)

这就是发生了溢出，溢出的时候并不会抛异常，也没有任何提示。所以，在程序中，使用同类型的数据进行运算的时候，一定要注意数据溢出的问题。


十进制整数转换为二进制整数采用"除2取余，逆序排列"法

十进制小数转换成二进制小数采用"乘2取整，顺序排列"法。

具体做法是：

用2乘十进制小数，可以得到积
将积的整数部分取出，再用2乘余下的小数部分，又得到一个积
再将积的整数部分取出，如此进行，直到积中的小数部分为零，此时0或1为二进制的最后一位。或者达到所要求的精度为止。


单精度浮点数在计算机存储器中占用4个字节（32 bits），利用“浮点”（浮动小数点）的方法，可以表示一个范围很大的数值。

比起单精度浮点数，双精度浮点数(double)使用 64 位（8字节） 来存储一个浮点数。


为什么不能用浮点型表示金额？
由于计算机中保存的小数其实是十进制的小数的近似值，并不是准确值，所以，千万不要在代码中使用浮点数来表示金额等重要的指标。

建议使用BigDecimal或者Long（单位为分）来表示金额。



基本数据类型有什么好处
我们都知道在 Java 语言中，new 一个对象是存储在堆里的，我们通过栈中的引用来使用这些对象；所以，对象本身来说是比较消耗资源的。

对于经常用到的类型，如 int 等，如果我们每次使用这种变量的时候都需要 new 一个 Java 对象的话，就会比较笨重。所以，和 C++ 一样，Java 提供了基本数据类型，这种数据的变量不需要使用 new 创建，他们不会在堆上创建，而是直接在栈内存中存储，因此会更加高效。

包装类均位于 java.lang 包，包装类和基本数据类型的对应关系如下表所示

基本数据类型	包装类
byte	Byte
boolean	Boolean
short	Short
char	Character
int	Integer
long	Long
float	Float
double	Double



  Integer i = 10;  //自动装箱
    int b = i;     //自动拆箱
    
    
    
自动装箱都是通过包装类的 valueOf() 方法来实现的.自动拆箱都是通过包装类对象的 xxxValue() 来实现的。

    

我们知道，Java 中的集合类只能接收对象类型，那么以下代码为什么会不报错呢？

如果一个变量 p 的值是：

-128 至 127 之间的整数 (§3.10.1)
true 和 false 的布尔值 (§3.10.3)
\u0000 至 \u007f 之间的字符 (§3.10.4)
范围内的时，将 p 包装成 a 和 b 两个对象时，可以直接使用 a == b 判断 a 和 b 的值是否相等。

自动拆装箱带来的问题
当然，自动拆装箱是一个很好的功能，大大节省了开发人员的精力，不再需要关心到底什么时候需要拆装箱。但是，他也会引入一些问题。

包装对象的数值比较，不能简单的使用 ==，虽然 -128 到 127 之间的数字可以，但是这个范围之外还是需要使用 equals 比较。

前面提到，有些场景会进行自动拆装箱，同时也说过，由于自动拆箱，如果包装类对象为 null ，那么自动拆箱时就有可能抛出 NPE。

如果一个 for 循环中有大量拆装箱操作，会浪费很多资源。



这里建议我们使用包装类型，原因是什么呢？

举一个扣费的例子，我们做一个扣费系统，扣费时需要从外部的定价系统中读取一个费率的值，我们预期该接口的返回值中会包含一个浮点型的费率字段。当我们取到这个值得时候就使用公式：金额*费率=费用 进行计算，计算结果进行划扣。

如果由于计费系统异常，他可能会返回个默认值，如果这个字段是Double类型的话，该默认值为null，如果该字段是double类型的话，该默认值为0.0。

如果扣费系统对于该费率返回值没做特殊处理的话，拿到null值进行计算会直接报错，阻断程序。拿到0.0可能就直接进行计算，得出接口为0后进行扣费了。这种异常情况就无法被感知。

这种使用包装类型定义变量的方式，通过异常来阻断程序，进而可以被识别到这种线上问题。如果使用基本数据类型的话，系统可能不会报错，进而认为无异常。

以上，就是建议在POJO和RPC的返回值中使用包装类型的原因。

但是关于这一点，作者之前也有过不同的看法：对于布尔类型的变量，我认为可以和其他类型区分开来，作者并不认为使用null进而导致NPE是一种最好的实践。因为布尔类型只有true/false两种值，我们完全可以和外部调用方约定好当返回值为false时的明确语义。

后来，作者单独和《阿里巴巴Java开发手册》、《码出高效》的作者——孤尽 单独1V1(qing) Battle(jiao)了一下。最终达成共识，还是尽量使用包装类型。

但是，作者还是想强调一个我的观点，尽量避免在你的代码中出现不确定的null值。



String在Java中特别常用，而且我们经常要在代码中对字符串进行赋值和改变他的值，但是，为什么我们说字符串是不可变的呢？

首先，我们需要知道什么是不可变对象？

不可变对象是在完全创建后其内部状态保持不变的对象。这意味着，一旦对象被赋值给变量，我们既不能更新引用，也不能通过任何方式改变内部状态。

可是有人会有疑惑，String为什么不可变，我的代码中经常改变String的值啊，如下：

String s = "abcd";
s = s.concat("ef");
复制ErrorOK!
这样，操作，不就将原本的"abcd"的字符串改变成"abcdef"了么？

但是，虽然字符串内容看上去从"abcd"变成了"abcdef"，但是实际上，我们得到的已经是一个新的字符串了。



replace、replaceAll和replaceFirst是Java中常用的替换字符的方法,它们的方法定义是：

replace(CharSequence target, CharSequence replacement) ，用replacement替换所有的target，两个参数都是字符串。

replaceAll(String regex, String replacement) ，用replacement替换所有的regex匹配项，regex很明显是个正则表达式，replacement是字符串。

replaceFirst(String regex, String replacement) ，基本和replaceAll相同，区别是只替换第一个匹配项。

可以看到，其中replaceAll以及replaceFirst是和正则表达式有关的，而replace和正则表达式无关。

replaceAll和replaceFirst的区别主要是替换的内容不同，replaceAll是替换所有匹配的字符，而replaceFirst()仅替换第一次出现的字符

用法例子
String string = "abc123adb23456aa";
System.out.println(string);//abc123adb23456aa

//使用replace将a替换成H
System.out.println(string.replace("a","H"));//Hbc123Hdb23456HH
//使用replaceFirst将第一个a替换成H
System.out.println(string.replaceFirst("a","H"));//Hbc123adb23456aa
//使用replace将a替换成H
System.out.println(string.replaceAll("a","H"));//Hbc123Hdb23456HH

//使用replaceFirst将第一个数字替换成H
System.out.println(string.replaceFirst("\\d","H"));//abcH23adb23456aa
//使用replaceAll将所有数字替换成H



还是这样一段代码。我们把他生成的字节码进行反编译，看看结果。

String wechat = "Hollis";
String introduce = "每日更新Java相关技术文章";
String hollis = wechat + "," + introduce;
复制ErrorOK!
反编译后的内容如下，反编译工具为jad。

String wechat = "Hollis";
String introduce = "\u6BCF\u65E5\u66F4\u65B0Java\u76F8\u5173\u6280\u672F\u6587\u7AE0";//每日更新Java相关技术文章
String hollis = (new StringBuilder()).append(wechat).append(",").append(introduce).toString();
复制ErrorOK!
通过查看反编译以后的代码，我们可以发现，原来字符串常量在拼接过程中，是将String转成了StringBuilder后，使用其append方法进行处理的。

那么也就是说，Java中的+对字符串的拼接，其实现原理是使用StringBuilder.append。



本文介绍了什么是字符串拼接，虽然字符串是不可变的，但是还是可以通过新建字符串的方式来进行字符串的拼接。

常用的字符串拼接方式有五种，分别是使用+、使用concat、使用StringBuilder、使用StringBuffer以及使用StringUtils.join。

由于字符串拼接过程中会创建新的对象，所以如果要在一个循环体中进行字符串拼接，就要考虑内存问题和效率问题。

因此，经过对比，我们发现，直接使用StringBuilder的方式是效率最高的。因为StringBuilder天生就是设计来定义可变字符串和字符串的变化操作的。

但是，还要强调的是：

1、如果不是在循环体中进行字符串拼接的话，直接使用+就好了。

2、如果在并发场景中进行字符串拼接的话，要使用StringBuffer来代替StringBuilder。



总结
本文介绍了Java 8中提供的可变字符串类——StringJoiner，可以用于字符串拼接。

StringJoiner其实是通过StringBuilder实现的，所以他的性能和StringBuilder差不多，他也是非线程安全的。

如果日常开发中中，需要进行字符串拼接，如何选择？

1、如果只是简单的字符串拼接，考虑直接使用"+"即可。

2、如果是在for循环中进行字符串拼接，考虑使用StringBuilder和StringBuffer。

3、如果是通过一个List进行字符串拼接，则考虑使用StringJoiner。




我们有三种方式将一个int类型的变量变成一个String类型，那么他们有什么区别？

1.int i = 5;
2.String i1 = "" + i;
3.String i2 = String.valueOf(i);
4.String i3 = Integer.toString(i);
复制ErrorOK!
第三行和第四行没有任何区别，因为String.valueOf(i)也是调用Integer.toString(i)来实现的。

第二行代码其实是String i1 = (new StringBuilder()).append(i).toString();，首先创建一个StringBuilder对象，然后再调用append方法，再调用toString方法。



其实switch只支持一种数据类型，那就是整型，其他数据类型都是转换成整型之后再使用switch的。



字面量
前面说过，Class常量池中主要保存的是字面量和符号引用，那么到底什么字面量？

在计算机科学中，字面量（literal）是用于表达源代码中一个固定值的表示法（notation）。几乎所有计算机编程语言都具有对基本值的字面量表示，诸如：整数、浮点数以及字符串；而有很多也对布尔类型和字符类型的值也支持字面量表示；还有一些甚至对枚举类型的元素以及像数组、记录和对象等复合类型的值也支持字面量表示法。

以上是关于计算机科学中关于字面量的解释，并不是很容易理解。说简单点，字面量就是指由字母、数字等构成的字符串或者数值。

字面量只可以右值出现，所谓右值是指等号右边的值，如：int a=123这里的a为左值，123为右值。在这个例子中123就是字面量。

int a = 123;
String s = "hollis";
复制ErrorOK!
上面的代码事例中，123和hollis都是字面量。

本文开头的HelloWorld代码中，Hollis就是一个字面量。

符号引用
常量池中，除了字面量以外，还有符号引用，那么到底什么是符号引用呢。

符号引用是编译原理中的概念，是相对于直接引用来说的。主要包括了以下三类常量： * 类和接口的全限定名 * 字段的名称和描述符 * 方法的名称和描述符

这也就可以印证前面的常量池中还包含一些com/hollis/HelloWorld、main、([Ljava/lang/String;)V等常量的原因了。


运行时常量池、Class常量池、字符串常量池的区别与联系
虚拟机启动过程中，会将各个Class文件中的常量池载入到运行时常量池中。

所以， Class常量池只是一个媒介场所。在JVM真的运行时，需要把常量池中的常量加载到内存中，进入到运行时常量池。

字符串常量池可以理解为运行时常量池分出来的部分。加载时，对于class的静态常量池，如果字符串会被装到字符串常量池中。

 上一章
Class常量池



代码中可以看出，当参数类型为String，并且长度大于等于65535的时候，就会导致编译失败。

运行期限制
上面提到的这种String长度的限制是编译期的限制，也就是使用String s= “”;这种字面值方式定义的时候才会有的限制。

那么。String在运行期有没有限制呢，答案是有的，就是我们前文提到的那个Integer.MAX_VALUE ，这个值约等于4G，在运行期，如果String的长度超过这个范围，就可能会抛出异常。(在jdk 1.9之前）





简单点说，就是被transient修饰的成员变量，在序列化的时候其值会被忽略，在被反序列化后， transient 变量的值被设为初始值， 如 int 型的是 0，对象型的是 null。

instanceof 是 Java 的保留关键字。它的作用是测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型。

以下实例创建了 displayObjectClass() 方法来演示 Java instanceof 关键字用法：

public static void displayObjectClass(Object o) {
  if (o instanceof Vector)
     System.out.println("对象是 java.util.Vector 类的实例");
  else if (o instanceof ArrayList)
     System.out.println("对象是 java.util.ArrayList 类的实例");
  else
    System.out.println("对象是 " + o.getClass() + " 类的实例");
复制ErrorOK!
}




Set如何保证元素不重复?
在Java的Set体系中，根据实现方式不同主要分为两大类。HashSet和TreeSet。

1、TreeSet 是二叉树实现的，TreeSet中的数据是自动排好序的，不允许放入 null值
2、HashSet 是哈希表实现的，HashSet中的数据是无序的，可以放入 null值，但只能放入一个null，两者中的值都不能重复，就如数据库中的唯一约束

在HashSet中，基本的操作都是由HashMap底层实现的，因为HashSet底层是用HashMap存储数据的。当向HashSet中添加元素的时候，首先计算元素的hashCode值，然后通过扰动计算和按位与的方式计算出这个元素的存储位置，如果这个位置为空，就将元素添加进去；如果不为空，则用equals方法比较元素是否相等，相等就不添加，否则找一个空位添加。

TreeSet的底层是TreeMap的keySet()，而TreeMap是基于红黑树实现的，红黑树是一种平衡二叉查找树，它能保证任何一个节点的左右子树的高度差不会超过较矮的那棵的一倍。

TreeMap是按key排序的，元素在插入TreeSet时compareTo()方法要被调用，所以TreeSet中的元素要实现Comparable接口。TreeSet作为一种Set，它不允许出现重复元素。TreeSet是用compareTo()来判断重复元素的。

 上一章
 
 
 
 
 HashMap、HashTable、ConcurrentHashMap区别
 HashMap和HashTable有何不同？
 线程安全：
 
 HashTable 中的方法是同步的，而HashMap中的方法在默认情况下是非同步的。在多线程并发的环境下，可以直接使用HashTable，但是要使用HashMap的话就要自己增加同步处理了。
 
 继承关系： HashTable是基于陈旧的Dictionary类继承来的。 HashMap继承的抽象类AbstractMap实现了Map接口。
 
 允不允许null值： HashTable中，key和value都不允许出现null值，否则会抛出NullPointerException异常。 HashMap中，null可以作为键，这样的键只有一个；可以有一个或多个键所对应的值为null。
 
 默认初始容量和扩容机制： HashTable中的hash数组初始大小是11，增加的方式是 old*2+1。HashMap中hash数组的默认大小是16，而且一定是2的指数。原因参考全网把Map中的hash()分析的最透彻的文章，别无二家。-HollisChuang's Blog
 
 哈希值的使用不同 ： HashTable直接使用对象的hashCode。 HashMap重新计算hash值。
 
 遍历方式的内部实现上不同 ： Hashtable、HashMap都使用了 Iterator。而由于历史原因，Hashtable还使用了Enumeration的方式 。 HashMap 实现 Iterator，支持fast-fail，Hashtable的 Iterator 遍历支持fast-fail，用 Enumeration 不支持 fast-fail
 
 HashMap 和 ConcurrentHashMap 的区别？
 ConcurrentHashMap和HashMap的实现方式不一样，虽然都是使用桶数组实现的，但是还是有区别，ConcurrentHashMap对桶数组进行了分段，而HashMap并没有。
 
 ConcurrentHashMap在每一个分段上都用锁进行了保护。HashMap没有锁机制。所以，前者线程安全的，后者不是线程安全的。
 
 
 
 HashMap中size表示当前共有多少个KV对，capacity表示当前HashMap的容量是多少，默认值是16，每次扩容都是成倍的。loadFactor是装载因子，当Map中元素个数超过loadFactor* capacity的值时，会触发扩容。loadFactor* capacity可以用threshold表示。
 
 
 HashMap 的数据结构
 在Java中，保存数据有两种比较简单的数据结构：数组和链表。数组的特点是：寻址容易，插入和删除困难；而链表的特点是：寻址困难，插入和删除容易。上面我们提到过，常用的哈希函数的冲突解决办法中有一种方法叫做链地址法，其实就是将数组和链表组合在一起，发挥了两者的优势，我们可以将其理解为链表的数组。
 
 
 
 因为位运算直接对内存数据进行操作，不需要转成十进制，所以位运算要比取模运算的效率更高，所以HashMap在计算元素要存放在数组中的index的时候，使用位运算代替了取模运算。之所以可以做等价代替，前提是要求HashMap的容量一定要是2^n 。
 
 
 
 总结
 HashMap是一种K-V结构，为了提升其查询及插入的速度，底层采用了链表的数组这种数据结构实现的。
 
 但是因为在计算元素所在的位置的时候，需要使用hash算法，而HashMap采用的hash算法就是链地址法。这种方法有两个极端。
 
 如果HashMap中哈希冲突概率高，那么HashMap就会退化成链表（不是真的退化，而是操作上像是直接操作链表），而我们知道，链表最大的缺点就是查询速度比较慢，他需要从表头开始逐一遍历。
 
 所以，为了避免HashMap发生大量的哈希冲突，所以需要在适当的时候对其进行扩容。
 
 而扩容的条件是元素个数达到临界值时。HashMap中临界值的计算方法：
 
 临界值（threshold） = 负载因子（loadFactor） * 容量（capacity）
 复制ErrorOK!
 其中负载因子表示一个数组可以达到的最大的满的程度。这个值不宜太大，也不宜太小。
 
 loadFactory太大，比如等于1，那么就会有很高的哈希冲突的概率，会大大降低查询速度。
 
 loadFactory太小，比如等于0.5，那么频繁扩容，就会大大浪费空间。
 
 所以，这个值需要介于0.5和1之间。根据数学公式推算。这个值在log(2)的时候比较合理。
 
 另外，为了提升扩容效率，HashMap的容量（capacity）有一个固定的要求，那就是一定是2的幂。
 
 所以，如果loadFactor是3/4的话，那么和capacity的乘积结果就可以是一个整数。
 
 所以，一般情况下，我们不建议修改loadFactory的值，除非特殊原因。
 
 比如我明确的知道我的Map只存5个kv，并且永远不会改变，那么可以考虑指定loadFactory。
 
 但是其实我也不建议这样用。我们完全可以通过指定capacity达到这样的目的
 
 
 Arrays.asList获得的List使用时需要注意什么
 asList 得到的只是一个 Arrays 的内部类，一个原来数组的视图 List，因此如果对它进行增删操作会报错
 
 用 ArrayList 的构造器可以将其转变成真正的 ArrayList
 
 
 
 Copy-On-Write
 在了解了CopyOnWriteArrayList之后，不知道大家会不会有这样的疑问：他的add/remove等方法都已经加锁了，还要copy一份再修改干嘛？多此一举？同样是线程安全的集合，这玩意和Vector有啥区别呢？
 
 Copy-On-Write简称COW，是一种用于程序设计中的优化策略。其基本思路是，从一开始大家都在共享同一个内容，当某个人想要修改这个内容的时候，才会真正把内容Copy出去形成一个新的内容然后再改，这是一种延时懒惰策略。
 
 CopyOnWrite容器即写时复制的容器。通俗的理解是当我们往一个容器添加元素的时候，不直接往当前容器添加，而是先将当前容器进行Copy，复制出一个新的容器，然后新的容器里添加元素，添加完元素之后，再将原容器的引用指向新的容器。
 
 CopyOnWriteArrayList中add/remove等写方法是需要加锁的，目的是为了避免Copy出N个副本出来，导致并发写。
 
 但是，CopyOnWriteArrayList中的读方法是没有加锁的。
 
 public E get(int index) {
     return get(getArray(), index);
 }
 复制ErrorOK!
 这样做的好处是我们可以对CopyOnWrite容器进行并发的读，当然，这里读到的数据可能不是最新的。因为写时复制的思想是通过延时更新的策略来实现数据的最终一致性的，并非强一致性。
 
 所以CopyOnWrite容器是一种读写分离的思想，读和写不同的容器。而Vector在读写的时候使用同一个容器，读写互斥，同时只能做一件事儿。
 
 
 
 
 ConcurrentSkipListMap
 ConcurrentSkipListMap是一个内部使用跳表，并且支持排序和并发的一个Map，是线程安全的。一般很少会被用到，也是一个比较偏门的数据结构。
 
 简单介绍下跳表
 
 跳表是一种允许在一个有顺序的序列中进行快速查询的数据结构。
 
 在普通的顺序链表中查询一个元素，需要从链表头部开始一个一个节点进行遍历，然后找到节点。如图1。
 
 跳表可以解决这种查询时间过长，其元素遍历的图示如图2，跳表是一种使用”空间换时间”的概念用来提高查询效率的链表。
 复制ErrorOK!
 ConcurrentSkipListMap 和 ConcurrentHashMap 的主要区别： a.底层实现方式不同。ConcurrentSkipListMap底层基于跳表。ConcurrentHashMap底层基于Hash桶和红黑树。 b.ConcurrentHashMap不支持排序。ConcurrentSkipListMap支持排序。
 

 通过反编译代码我们可以看到，public final class T extends Enum，说明，该类是继承了Enum类的，同时final关键字告诉我们，这个类也是不能被继承的。
 
 当我们使用enmu来定义一个枚举类型的时候，编译器会自动帮我们创建一个final类型的类继承Enum类，所以枚举类型不能被继承。
 
 
 都是static类型的，因为static类型的属性会在类被加载之后被初始化，我们在深度分析Java的ClassLoader机制（源码级别）和Java类的加载、链接和初始化两个文章中分别介绍过，当一个Java类第一次被真正使用到的时候静态资源被初始化、Java类的加载和初始化过程都是线程安全的。所以，创建一个enum类型是线程安全的。
 
 枚举的序列化和反序列化是有特殊定制的。这就可以避免反序列化过程中由于反射而导致的单例被破坏问题。
 
 
 
 
 字符流、字节流
 字节与字符
 Bit最小的二进制单位 ，是计算机的操作部分。取值0或者1
 
 Byte（字节）是计算机操作数据的最小单位由8位bit组成 取值（-128-127）
 
 Char（字符）是用户的可读写的最小单位，在Java里面由16位bit组成 取值（0-65535）
 
 字节流
 操作byte类型数据，主要操作类是OutputStream、InputStream的子类；不用缓冲区，直接对文件本身操作。
 
 字符流
 操作字符类型数据，主要操作类是Reader、Writer的子类；使用缓冲区缓冲字符，不关闭流就不会输出任何内容。
 
 互相转换
 整个IO包实际上分为字节流和字符流，但是除了这两个流之外，还存在一组字节流-字符流的转换类。
 
 OutputStreamWriter：是Writer的子类，将输出的字符流变为字节流，即将一个字符流的输出对象变为字节流输出对象。
 
 InputStreamReader：是Reader的子类，将输入的字节流变为字符流，即将一个字节流的输入对象变为字符流的输入对象。
 
 
 同步、异步
 同步与异步描述的是被调用者的。
 
 如A调用B：
 
 如果是同步，B在接到A的调用后，会立即执行要做的事。A的本次调用可以得到结果。
 
 如果是异步，B在接到A的调用后，不保证会立即执行要做的事，但是保证会去做，B在做好了之后会通知A。A的本次调用得不到结果，但是B执行完之后会通知A。
 
 同步，异步 和 阻塞，非阻塞之间的区别
 同步，异步，是描述被调用方的。
 
 阻塞、非阻塞，是描述调用方的。
 
 同步不一定阻塞，异步也不一定非阻塞。没有必然关系。
 
 举个简单的例子，老张烧水。 1 老张把水壶放到火上，一直在水壶旁等着水开。（同步阻塞） 2 老张把水壶放到火上，去客厅看电视，时不时去厨房看看水开没有。（同步非阻塞） 3 老张把响水壶放到火上，一直在水壶旁等着水开。（异步阻塞） 4 老张把响水壶放到火上，去客厅看电视，水壶响之前不再去看它了，响了再去拿壶。（异步非阻塞）
 
 1和2的区别是，调用方在得到返回之前所做的事情不一样。 1和3的区别是，被调用方对于烧水的处理不一样。
 
 
 各自适用场景
 BIO方式适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4以前的唯一选择，但程序直观简单易理解。
 
 NIO方式适用于连接数目多且连接比较短（轻操作）的架构，比如聊天服务器，并发局限于应用中，编程比较复杂，JDK1.4开始支持。
 
 AIO方式适用于连接数目多且连接比较长（重操作）的架构，比如相册服务器，充分调用OS参与并发操作，编程比较复杂，JDK7开始支持。
 
 
 
 Serializable 和 Externalizable 有何不同
 Java中的类通过实现 java.io.Serializable 接口以启⽤其序列化功能。 未实现此接口的类将⽆法使其任何状态序列化或反序列化。
 
 可序列化类的所有⼦类型本⾝都是可序列化的。
 
 序列化接口没有⽅法或字段， 仅⽤于标识可序列化的语义。
 
 当试图对⼀个对象进⾏序列化的时候， 如果遇到不⽀持Serializable 接口的对象。 在此情况下， 将抛NotSerializableException。
 
 如果要序列化的类有⽗类， 要想同时将在⽗类中定义过的变量持久化下来， 那么⽗类也应该集成java.io.Serializable接口。
 
 Externalizable继承了Serializable， 该接口中定义了两个抽象⽅法：writeExternal()与readExternal()。 当使⽤Externalizable接口来进⾏序列化与反序列化的时候需要开发⼈员重写writeExternal()与readExternal()⽅法。
 
 如果没有在这两个⽅法中定义序列化实现细节， 那么序列化之后， 对象内容为空。
 
 实现Externalizable接口的类必须要提供⼀个public的⽆参的构造器。
 
 所以， 实现Externalizable， 并实现writeExternal()和readExternal()⽅法可以指定序列化哪些属性。
 
 
 总结
 serialVersionUID是用来验证版本一致性的。所以在做兼容性升级的时候，不要改变类中serialVersionUID的值。
 
 如果一个类实现了Serializable接口，一定要记得定义serialVersionUID，否则会发生异常。可以在IDE中通过设置，让他帮忙提示，并且可以一键快速生成一个serialVersionUID。
 
 之所以会发生异常，是因为反序列化过程中做了校验，并且如果没有明确定义的话，会根据类的属性自动生成一个。
 
 
 
 
 如果一个类中包含writeObject 和 readObject 方法，那么这两个方法是怎么被调用的?
 
 答：在使用ObjectOutputStream的writeObject方法和ObjectInputStream的readObject方法时，会通过反射的方式调用。
 
 总结
 1、如果一个类想被序列化，需要实现Serializable接口。否则将抛出NotSerializableException异常，这是因为，在序列化操作过程中会对类型进行检查，要求被序列化的类必须属于Enum、Array和Serializable类型其中的任何一种。
 
 2、在变量声明前加上该关键字，可以阻止该变量被序列化到文件中。
 
 3、在类中增加writeObject 和 readObject 方法可以实现自定义序列化策略
 
 
 
 
 所以。到目前为止，也就可以解释，为什么序列化可以破坏单例了？
 
 答：序列化会通过反射调用无参数的构造方法创建一个新的对象。
 
 那么，接下来我们再看刚开始留下的问题，如何防止序列化/反序列化破坏单例模式。
 
 
 先给出解决方案，然后再具体分析原理：
 
 只要在Singleton类中定义readResolve就可以解决该问题：
 
 
 元注解有六个:@Target（表示该注解可以用于什么地方）、@Retention（表示再什么级别保存该注解信息）、@Documented（将此注解包含再javadoc中）、@Inherited（允许子类继承父类中的注解）、@Repeatable（1.8新增，允许一个注解在一个元素上使用多次）、@Native（1.8新增，修饰成员变量，表示这个变量可以被本地代码引用，常常被代码生成工具使用）。
 
 
 
 
 Spring常用注解
 @Configuration把一个类作为一个IoC容器，它的某个方法头上如果注册了@Bean，就会作为这个Spring容器中的Bean。
 
 @Scope注解 作用域
 
 @Lazy(true) 表示延迟初始化
 
 @Service用于标注业务层组件
 
 @Controller用于标注控制层组件@Repository用于标注数据访问组件，即DAO组件。
 
 @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 
 @Scope用于指定scope作用域的（用在类上）
 
 @PostConstruct用于指定初始化方法（用在方法上）
 
 @PreDestory用于指定销毁方法（用在方法上）
 
 @DependsOn：定义Bean初始化及销毁时的顺序
 
 @Primary：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
 
 @Autowired 默认按类型装配，如果我们想使用按名称装配，可以结合@Qualifier注解一起使用。如下： @Autowired @Qualifier("personDaoBean") 存在多个实例配合使用
 
 @Resource默认按名称装配，当找不到与名称匹配的bean才会按类型装配。
 
 @PostConstruct 初始化注解
 
 @PreDestroy 摧毁注解 默认 单例 启动就加载
 
 
 
 
 如何自定义一个注解？
 在Java中，类使用class定义，接口使用interface定义，注解和接口的定义差不多，增加了一个@符号，即@interface，代码如下：
 
 public @interface EnableAuth {
 
 }
 复制ErrorOK!
 注解中可以定义成员变量，用于信息的描述，跟接口中方法的定义类似，代码如下：
 
 public @interface EnableAuth {
     String name();
 }
 复制ErrorOK!
 还可以添加默认值：
 
 public @interface EnableAuth {
     String name() default "猿天地";
 }
 复制ErrorOK!
 上面的介绍只是完成了自定义注解的第一步，开发中日常使用注解大部分是用在类上，方法上，字段上，示列代码如下：
 
 @Target(ElementType.METHOD)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 public @interface EnableAuth {
 
 }
 复制ErrorOK!
 Target
 
 用于指定被修饰的注解修饰哪些程序单元，也就是上面说的类，方法，字段
 
 Retention
 
 用于指定被修饰的注解被保留多长时间，分别SOURCE（注解仅存在于源码中，在class字节码文件中不包含）,CLASS（默认的保留策略，注解会在class字节码文件中存在，但运行时无法获取）,RUNTIME（注解会在class字节码文件中存在，在运行时可以通过反射获取到）三种类型，如果想要在程序运行过程中通过反射来获取注解的信息需要将Retention设置为RUNTIME
 
 Documented
 
 用于指定被修饰的注解类将被javadoc工具提取成文档
 
 Inherited
 
 用于指定被修饰的注解类将具有继承性
 
 
 
 
 五、总结
 1.虚拟机中没有泛型，只有普通类和普通方法,所有泛型类的类型参数在编译时都会被擦除,泛型类并没有自己独有的Class类对象。比如并不存在List<String>.class或是List<Integer>.class，而只有List.class。 2.创建泛型对象时请指明类型，让编译器尽早的做参数检查（Effective Java，第23条：请不要在新代码中使用原生态类型） 3.不要忽略编译器的警告信息，那意味着潜在的ClassCastException等着你。 4.静态变量是被泛型类的所有实例所共享的。对于声明为MyClass<T>的类，访问其中的静态变量的方法仍然是 MyClass.myStaticVar。不管是通过new MyClass<String>还是new MyClass<Integer>创建的对象，都是共享一个静态变量。 5.泛型的类型参数不能用在Java异常处理的catch语句中。因为异常处理是由JVM在运行时刻来进行的。由于类型信息被擦除，JVM是无法区分两个异常类型MyException<String>和MyException<Integer>的。对于JVM来说，它们都是 MyException类型的。也就无法执行与异常对应的catch语句。
 
 
 
 
 泛型中K T V E ？ object等的含义
 E - Element (在集合中使用，因为集合中存放的是元素)
 
 T - Type（Java 类）
 
 K - Key（键）
 
 V - Value（值）
 
 N - Number（数值类型）
 
 ？ - 表示不确定的java类型（无限制通配符类型）
 
 S、U、V - 2nd、3rd、4th types
 
 Object - 是所有类的根类，任何类的对象都可以设置给该Object引用变量，使用的时候可能需要类型强制转换，但是用使用了泛型T、E等这些标识符后，在实际用之前类型就已经确定了，不需要再进行类型强制转换。
 
 
 
 限定通配符和非限定通配符
 限定通配符对类型进⾏限制， 泛型中有两种限定通配符：
 
 表示类型的上界，格式为：<？ extends T>，即类型必须为T类型或者T子类 表示类型的下界，格式为：<？ super T>，即类型必须为T类型或者T的父类
 
 泛型类型必须⽤限定内的类型来进⾏初始化，否则会导致编译错误。
 
 ⾮限定通配符表⽰可以⽤任意泛型类型来替代，类型为<T>
 
 
 
 List<?> 是一个未知类型的List，而List<Object> 其实是任意类型的List。你可以把List<String>, List<Integer>赋值给List<?>，却不能把List<String>赋值给 List<Object>。
 
 
 
 接口和抽象类有什么区别
 他们都不能实例化对象，都可以包含抽象方法，而且抽象方法必须被继承的类全部实现。
 
 区别：
 
 1、抽象类和接口都不能直接实例化，如果要实例化，抽象类变量必须指向实现所有抽象方法的子类对象，接口变量必须指向实现所有接口方法的类对象。
 
 2、抽象类要被子类继承，接口要被类实现。
 
 3、接口只能做方法申明，抽象类中可以做方法申明，也可以做方法实现
 
 4、接口里定义的变量只能是公共的静态的常量，抽象类中的变量是普通变量。
 
 5、抽象类里的抽象方法必须全部被子类所实现，如果子类不能全部实现父类抽象方法，那么该子类只能是抽象类。同样，一个实现接口的时候，如不能全部实现接口方法，那么该类也只能为抽象类。
 
 6、抽象方法只能申明，不能实现，接口是设计的结果 ，抽象类是重构的结果
 
 7、抽象类里可以没有抽象方法
 
 8、如果一个类里有抽象方法，那么这个类只能是抽象类
 
 9、抽象方法要被实现，所以不能是静态的，也不能是私有的。
 
 10、接口可继承接口，并可多继承接口，但类只能单根继承。
 
 
 
 受检异常
 对于受检异常来说， 如果⼀个⽅法在声明的过程中证明了其要有受检异常抛出：
 
 public void test() throw new Exception{ }
 复制ErrorOK!
 那么，当我们在程序中调⽤他的时候， ⼀定要对该异常进⾏处理（ 捕获或者向上抛出） ， 否则是⽆法编译通过的。 这是⼀种强制规范。
 
 这种异常在IO操作中⽐较多。 ⽐如FileNotFoundException ， 当我们使⽤IO流处理⼀个⽂件的时候， 有⼀种特殊情况， 就是⽂件不存在， 所以， 在⽂件处理的接⼜定义时他会显⽰抛出FileNotFoundException， ⽬的就是告诉这个⽅法的调⽤者，我这个⽅法不保证⼀定可以成功， 是有可能找不到对应的⽂件 的， 你要明确的对这种情况做特殊处理哦。
 
 所以说， 当我们希望我们的⽅法调⽤者， 明确的处理⼀些特殊情况的时候， 就应该使⽤受检异常。
 
 非受检异常
 对于⾮受检异常来说， ⼀般是运⾏时异常， 继承⾃RuntimeException。 在编写代码的时候， 不需要显⽰的捕获，但是如果不捕获， 在运⾏期如果发⽣异常就会中断程序的执⾏。
 
 这种异常⼀般可以理解为是代码原因导致的。 ⽐如发⽣空指针、 数组越界等。 所以， 只要代码写的没问题， 这些异常都是可以避免的。 也就不需要我们显⽰的进⾏处理。
 
 试想⼀下， 如果你要对所有可能发⽣空指针的地⽅做异常处理的话， 那相当于你的所有代码都需要做这件事。
 
 正确处理异常
 异常的处理⽅式有两种。 1、 ⾃⼰处理。 2、 向上抛， 交给调⽤者处理。
 
 异常， 千万不能捕获了之后什么也不做。 或者只是使⽤e.printStacktrace。
 
 具体的处理⽅式的选择其实原则⽐较简明： ⾃⼰明确的知道如何处理的， 就要处理掉。 不知道如何处理的， 就交给调⽤者处理。
 
 
 ⾃定义异常就是开发⼈员⾃⼰定义的异常， ⼀般通过继承Exception的⼦类的⽅式实现。
 
 编写⾃定义异常类实际上是继承⼀个API标准异常类， ⽤新定义的异常处理信息覆盖原有信息的过程。
 
 这种⽤法在Web开发中也⽐较常见， ⼀般可以⽤来⾃定义业务异常。 如余额不⾜、 重复提交等。 这种⾃定义异常有业务含义， 更容易让上层理解和处理
 
 
 从Java 7开始，jdk提供了一种更好的方式关闭资源，使用try-with-resources语句，改写一下上面的代码，效果如下：
 
 public static void main(String... args) {
     try (BufferedReader br = new BufferedReader(new FileReader("d:\\ hollischuang.xml"))) {
         String line;
         while ((line = br.readLine()) != null) {
             System.out.println(line);
         }
     } catch (IOException e) {
         // handle exception
     }
 }
 
 
 
 
 但是return前执行的finally块内，对数据的修改效果对于引用类型和值类型会不同
 
 // 测试 修改值类型
 static int f() {
     int ret = 0;
     try {
         return ret;  // 返回 0，finally内的修改效果不起作用
     } finally {
         ret++;
         System.out.println("finally执行");
     }
 }
 
 // 测试 修改引用类型
 static int[] f2(){
     int[] ret = new int[]{0};
     try {
         return ret;  // 返回 [1]，finally内的修改效果起了作用
     } finally {
         ret[0]++;
         System.out.println("finally执行");
     }
 }
 
 
 
 CET
 欧洲中部时间（英語：Central European Time，CET）是比世界标准时间（UTC）早一个小时的时区名称之一。它被大部分欧洲国家和部分北非国家采用。冬季时间为UTC+1，夏季欧洲夏令时为UTC+2。
 
 UTC
 协调世界时，又称世界标准时间或世界协调时间，简称UTC，从英文“Coordinated Universal Time”／法文“Temps Universel Cordonné”而来。台湾采用CNS 7648的《资料元及交换格式–资讯交换–日期及时间的表示法》（与ISO 8601类似）称之为世界统一时间。中国大陆采用ISO 8601-1988的国标《数据元和交换格式信息交换日期和时间表示法》（GB/T 7408）中称之为国际协调时间。协调世界时是以原子时秒长为基础，在时刻上尽量接近于世界时的一种时间计量系统。
 
 GMT
 格林尼治标准时间（旧译格林尼治平均时间或格林威治标准时间；英语：Greenwich Mean Time，GMT）是指位于英国伦敦郊区的皇家格林尼治天文台的标准时间，因为本初子午线被定义在通过那里的经线。
 
 CST
 北京时间，China Standard Time，又名中国标准时间，是中国的标准时间。在时区划分上，属东八区，比协调世界时早8小时，记为UTC+8，与中华民国国家标准时间（旧称“中原标准时间”）、香港时间和澳门时间和相同。當格林威治時間為凌晨0:00時，中國標準時間剛好為上午8:00。
 



在Java中，可以使用SimpleDateFormat的format方法，将一个Date类型转化成String类型，并且可以指定输出格式。

// Date转String
Date data = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String dataStr = sdf.format(data);
System.out.println(dataStr);
复制ErrorOK!
以上代码，转换的结果是：2018-11-25 13:00:00，日期和时间格式由"日期和时间模式"字符串指定。如果你想要转换成其他格式，只要指定不同的时间模式就行了。

在Java中，可以使用SimpleDateFormat的parse方法，将一个String类型转化成Date类型。

// String转Data
System.out.println(sdf.parse(dataStr));





总结
本文介绍了SimpleDateFormat的用法，SimpleDateFormat主要可以在String和Date之间做转换，还可以将时间转换成不同时区输出。同时提到在并发场景中SimpleDateFormat是不能保证线程安全的，需要开发者自己来保证其安全性。

主要的几个手段有改为局部变量、使用synchronized加锁、使用Threadlocal为每一个线程单独创建一个等。

希望通过此文，你可以在使用SimpleDateFormat的时候更加得心应手。


LocalTime 和 LocalDate的区别？
LocalDate表⽰⽇期， 年⽉⽇， LocalTime表⽰时间， 时分 秒

获取当前时间
在Java8中，使用如下方式获取当前时间：

LocalDate today = LocalDate.now();
int year = today.getYear();
int month = today.getMonthValue();
int day = today.getDayOfMonth();
System.out.printf("Year : %d Month : %d day : %d t %n", year,month, day);
复制ErrorOK!
创建指定日期的时间
LocalDate date = LocalDate.of(2018, 01, 01);
复制ErrorOK!
检查闰年
直接使⽤LocalDate的isLeapYear即可判断是否闰年

LocalDate nowDate = LocalDate.now();
//判断闰年
boolean leapYear = nowDate.isLeapYear();
复制ErrorOK!
计算两个⽇期之间的天数和⽉数
在Java 8中可以⽤java.time.Period类来做计算。

Period period = Period.between(LocalDate.of(2018, 1, 5),LocalDate.of(2018, 2, 5));

所以，当我们要表示日期的时候，一定要使用 yyyy-MM-dd 而不是 YYYY-MM-dd ，这两者的返回结果大多数情况下都一样，但是极端情况就会有问题了。


URL编解码
网络标准RFC 1738做了硬性规定 :只有字母和数字[0-9a-zA-Z]、一些特殊符号“$-_.+!*'(),”[不包括双引号]、以及某些保留字，才可以不经过编码直接用于URL;

除此以外的字符是无法在URL中展示的，所以，遇到这种字符，如中文，就需要进行编码。

所以，把带有特殊字符的URL转成可以显示的URL过程，称之为URL编码。

反之，就是解码。

URL编码可以使用不同的方式，如escape，URLEncode，encodeURIComponent。


当我们使用enum来定义一个枚举类型的时候，编译器会自动帮我们创建一个final类型的类继承Enum类，所以枚举类型不能被继承。



BigDecimal是一个非常好用的表示高精度数字的类，其中提供了很多丰富的方法。

但是，他的equals方法使用的时候需要谨慎，因为他在比较的时候，不仅比较两个数字的值，还会比较他们的标度，只要这两个因素有一个是不相等的，那么结果也是false、

如果读者想要对两个BigDecimal的数值进行比较的话，可以使用compareTo方法。



总结
因为计算机采用二进制处理数据，但是很多小数，如0.1的二进制是一个无线循环小数，而这种数字在计算机中是无法精确表示的。

所以，人们采用了一种通过近似值的方式在计算机中表示，于是就有了单精度浮点数和双精度浮点数等。

所以，作为单精度浮点数的float和双精度浮点数的double，在表示小数的时候只是近似值，并不是真实值。

所以，当使用BigDecimal(Double)创建一个的时候，得到的BigDecimal是损失了精度的。

而使用一个损失了精度的数字进行计算，得到的结果也是不精确的。

想要避免这个问题，可以通过BigDecimal(String)的方式创建BigDecimal，这样的情况下，0.1就会被精确的表示出来。

其表现形式是一个无标度数值1，和一个标度1的组合。