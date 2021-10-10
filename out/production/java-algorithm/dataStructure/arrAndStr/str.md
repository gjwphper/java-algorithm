字符串简介
维基百科：字符串是由零个或多个字符组成的有限序列。一般记为 s = a1a2...an。它是编程语言中表示文本的数据类型。

 
为何单独讨论字符串类型
我们知道，字符串与数组有很多相似之处，比如使用 名称[下标] 来得到一个字符。那么我们为什么要单独讨论字符串呢？原因主要有：

1.字符串的基本操作对象通常是字符串整体或者其子串

例如有这样一个字符串序列：I like leetcode 现在你想把这句话反向输出，可能会变成这样：

edocteel ekil I

这是我们想要的结果吗？你可能会回答不是，因为它没有任何意义。我们通常希望单词仍然维持原来的顺序，这样反向输出之后就是：

Leetcode like I

这样的结果对于我们来讲是不是更满意呢？维持单词本身的顺序使得我们方便进行更多操作，这里的每个单词就叫做字符串的「子串」，通常，我们的操作对象更多情况下是这些子串。

2. 字符串操作比其他数据类型更复杂（例如比较、连接操作）

对于不同的编程语言，字符串的某些操作会有所不同。下面我们将从字符串的「比较」和「连接」操作两个方面分别进行讲解。

 

比较函数
字符串有它自己的比较函数（我们将在下面的代码中向你展示比较函数的用法）。

然而，存在这样一个问题：

我们可以用 “==” 来比较两个字符串吗？

这取决于下面这个问题的答案：

我们使用的语言是否支持运算符重载？

如果答案是 yes （例如 C++、Python）。我们可以使用 == 来比较两个字符串；
如果答案是 no （例如 Java），我们可能无法使用 == 来比较两个字符串。当我们使用 == 时，它实际上会比较这两个对象是否是同一个对象。
你可以运行下面的例子来比较结果：
连接操作
对于不同的编程语言中，字符串可能是可变的，也可能是不可变的。不可变意味着一旦字符串被初始化，你就无法改变它的内容。

在某些语言（如 C ++）中，字符串是可变的。 也就是说，你可以像在数组中那样修改字符串。
在其他一些语言（如 Java、Python）中，字符串是不可变的。
你可以通过测试修改操作来确定你喜欢的语言中的字符串是否可变。这里有一个示例：
在 字符串不可变 的语言中，进行字符串的连接操作则会带来一些问题。

显然，不可变字符串无法被修改。哪怕你只是想修改其中的一个字符，也必须创建一个新的字符串。我们以 Java 为例，来看一个在 for 循环中重复进行字符串连接的例子：
我们发现在 C++ 中，进行字符串连接并没有明显的性能影响。

然而，对于 Java来说，由于字符串是不可变的，因此在连接时首先为新字符串分配足够的空间，复制旧字符串中的内容并附加到新字符串。

因此，总时间复杂度将是：

5+5×2+5×3+…+5×n=5×(1+2+3+…+n)=5×n×(n+1)/25 + 5 × 2 + 5 × 3 + … + 5 × n = 5 × (1 + 2 + 3 + … + n) = 5 × n × (n + 1) / 25+5×2+5×3+…+5×n=5×(1+2+3+…+n)=5×n×(n+1)/2 即 O(N2)O(N^2)O(N 
2
 )。

针对 Java 中出现的此问题，我们提供了以下解决方案：

如果你确实希望你的字符串是可变的，则可以使用 toCharArray 将其转换为字符数组。
如果你经常必须连接字符串，最好使用一些其他的数据结构，如 StringBuilder 。



https://blog.csdn.net/qq_43576028/article/details/90347117

Java中“==”、“compareTo()”和“equals()”的区别

在比较两个对象或者数据大小的时候，经常会用到==、compareTo()和equals(),尤其是在接入了Comparable接口后重写compareTo方法等场景，所以我们来理一下这三个的区别。

1.等号——"=="：
等号是最简单也最容易理解的，如果等号的两边是基本数据类型，比如int，double，那么等号就用来单纯的比较他们的数值大小
如果等号两边放的是两个对象，那么就会比较他们在内存当中的地址。
例如：

	   String a="abc";
		String b="abc";
		System.out.println(a==b);

答案是：true
因为相同的字符串内容，在地址上是一样。在Java中，String是有一个String pool的，里面存放了可以共享的字符串对象，在声明一个String对象后，会首先去找是否存在相同的String内容，如果有的话是不会创建新的对象的。在这里b实际上是引用了a的对象的值，他自己并没有创建对象，所以这里的答案是true。

但是如果我们接着
String c=new String(“abc”);
再
System.out.println(a==c);
那答案就是false，因为这二者的地址并不是一致的。

2.compareTo()
在Java里观察compareTo()的源码

public int compareTo(String anotherString) {
        int len1 = value.length;
        int len2 = anotherString.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

可以观察出，这里实际上是获取的字符串（也可以是其他对象）的长度，然后作减法，这里的减法就是ASCII码的减法，所以compareTo()会返回数字，如果两个字符串内容相同，会返回0，字符串a大于字符串b，会返回相差的ASCII码的正数，字符串a小于字符串b，会返回相差的ASCII码的负数。

所以 System.out.println(a.compareTo(b))的答案是：0

3.equals()
依旧是来观察Java中equals()的源码

public boolean equals(Object anObject) {
  if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}

可以观察出，equals是先用等号（==）直接来比较两个对象在内存当中的地址，如果相等会直接返回true，如果这两个对象的地址不一样，就会考虑这两个对象是不是String类型的,如果是String类型的，那先比较两个字符串长度是否一样，如果长度不一致，那100%不相等，直接返回false。长度一致则逐个比较

4.compareTo()和equals的区别
compareTo()会返回二者的差值，即返回的是一个数字；而equals就简单一些，只返回true或者false。
最后，compareTo()和equals()都可以判断其他基本数据类型，比如说Integer，Java的源码中对这两者方法都做了一些重载，可以根据参数的类型去自动匹配相应的方法，他们的原理也非常简单，只是一些简单的减法或者（？：）这类判断。






String
  String类是不可变类，即一旦一个String对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。

  这个是String类的解释，之前小咸儿看到这个情况，不能理解上述的解释，如下

String a = "123";
a = "456";
// 打印出来的a为456
System.out.println(a)
1
2
3
4
  看到这里，小咸儿不明白了，这不是明明已经对他进行修改了吗？为什么还说他是一个不可变类呢？

  经过小咸儿和小伙伴们的学习，明白String类不可变在哪里体现出来的，接下来就看一张上述a对象的内存存储空间图


  可以看出来，再次给a赋值时，并不是对原来堆中实例对象进行重新赋值，而是生成一个新的实例对象，并且指向“456”这个字符串，a则指向最新生成的实例对象，之前的实例对象仍然存在，如果没有被再次引用，则会被垃圾回收。

StringBuffer
  StringBuffer对象则代表一个字符序列可变的字符串，当一个StringBuffer被创建以后，通过StringBuffer提供的append()、insert()、reverse()、setCharAt()、setLength()等方法可以改变这个字符串对象的字符序列。一旦通过StringBuffer生成了最终想要的字符串，就可以调用它的toString()方法将其转换为一个String对象。

StringBuffer b = new StringBuffer("123");
b.append("456");
// b打印结果为：123456
System.out.println(b);
1
2
3
4
  在看一下b对象的内存空间图：


  所以说StringBuffer对象是一个字符序列可变的字符串，它没有重新生成一个对象，而且在原来的对象中可以连接新的字符串。

StringBuilder
  StringBuilder类也代表可变字符串对象。实际上，StringBuilder和StringBuffer基本相似，两个类的构造器和方法也基本相同。不同的是：StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。

StringBuffer是如何实现线程安全的呢？
StringBuffer类中实现的方法：



StringBuilder类中实现的方法：



  由此可见，StringBuffer类中的方法都添加了synchronized关键字，也就是给这个方法添加了一个锁，用来保证线程安全。




双指针技巧 —— 情景一
在上一章中，我们通过迭代数组来解决一些问题。通常，我们只需要一个指针进行迭代，即从数组中的第一个元素开始，最后一个元素结束。然而，有时我们会使用两个指针进行迭代。


 

示例
让我们从一个经典问题开始：

反转数组中的元素。比如数组为 ['l', 'e', 'e', 't', 'c', 'o', 'd', 'e']，反转之后变为 ['e', 'd', 'o', 'c', 't', 'e', 'e', 'l']。

使用双指针技巧，其思想是分别将两个指针分别指向数组的开头及末尾，然后将其指向的元素进行交换，再将指针向中间移动一步，继续交换，直到这两个指针相遇。


以下代码可以供你参考：


 
小结
我们来总结一下，使用双指针的典型场景之一是你想要

从两端向中间迭代数组。

这时你可以使用双指针技巧：

一个指针从头部开始，而另一个指针从尾部开始。

这种技巧经常在排序数组中使用。

