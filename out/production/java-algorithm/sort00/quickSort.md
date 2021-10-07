快速排序
快速排序算法由 C. A. R. Hoare 在 1960 年提出。它的时间复杂度也是 O(nlogn)O(nlogn)，但它在时间复杂度为 O(nlogn)O(nlogn) 级的几种排序算法中，大多数情况下效率更高，所以快速排序的应用非常广泛。再加上快速排序所采用的分治思想非常实用，使得快速排序深受面试官的青睐，所以掌握快速排序的思想尤为重要。

快速排序算法的基本思想是：

从数组中取出一个数，称之为基数（pivot）
遍历数组，将比基数大的数字放到它的右边，比基数小的数字放到它的左边。遍历完成后，数组被分成了左右两个区域
将左右两个区域视为两个数组，重复前两个步骤，直到排序完成
事实上，快速排序的每一次遍历，都将基数摆到了最终位置上。第一轮遍历排好 1 个基数，第二轮遍历排好 2 个基数（每个区域一个基数，但如果某个区域为空，则此轮只能排好一个基数），第三轮遍历排好 4 个基数（同理，最差的情况下，只能排好一个基数），以此类推。总遍历次数为 logn～n 次，每轮遍历的时间复杂度为 O(n)O(n)，所以很容易分析出快速排序的时间复杂度为 O(nlogn)O(nlogn) ～ O(n^2)O(n 
2
 )，平均时间复杂度为 O(nlogn)O(nlogn)。

动图演示


快速排序递归框架
根据我们分析出的思路，先搭出快速排序的架子：

Java

public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
}
public static void quickSort(int[] arr, int start, int end) {
    // 将数组分区，并获得中间值的下标
    int middle = partition(arr, start, end);
    // 对左边区域快速排序
    quickSort(arr, start, middle - 1);
    // 对右边区域快速排序
    quickSort(arr, middle + 1, end);
}
public static int partition(int[] arr, int start, int end) {
    // TODO: 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
}
partition 意为“划分”，我们期望 partition 函数做的事情是：将 arr 从 start 到 end 这一区间的值分成两个区域，左边区域的每个数都比基数小，右边区域的每个数都比基数大，然后返回中间值的下标。

只要有了这个函数，我们就能写出快速排序的递归函数框架。首先调用 partition 函数得到中间值的下标 middle，然后对左边区域执行快速排序，也就是递归调用 quickSort(arr, start, middle - 1)，再对右边区域执行快速排序，也就是递归调用 quickSort(arr, middle + 1, end)。

现在还有一个问题，何时退出这个递归函数呢？

退出递归的边界条件
很容易想到，当某个区域只剩下一个数字的时候，自然不需要排序了，此时退出递归函数。实际上还有一种情况，就是某个区域只剩下 0 个数字时，也需要退出递归函数。当 middle 等于 start 或者 end 时，就会出现某个区域剩余数字为 0。

所以我们可以通过这种方式退出递归函数：

Java

public static void quickSort(int[] arr, int start, int end) {
    // 将数组分区，并获得中间值的下标
    int middle = partition(arr, start, end);
    // 当左边区域中至少有 2 个数字时，对左边区域快速排序
    if (start != middle && start != middle - 1) quickSort(arr, start, middle - 1);
    // 当右边区域中至少有 2 个数字时，对右边区域快速排序
    if (middle != end && middle != end - 1) quickSort(arr, middle + 1, end);
}
在递归之前，先判断此区域剩余数字是否为 0 个或者 1 个，当数字至少为 2 个时，才执行这个区域的快速排序。因为我们知道 middle >= start && middle <= end 必然成立，所以判断剩余区域的数字为 0 个或者 1 个也就是指 start 或 end 与 middle 相等或相差 1。

我们来分析一下这四个判断条件：

当 start == middle 时，相当于 quickSort(arr, start, middle - 1) 中的 start == end + 1
当 start == middle - 1 时，相当于 quickSort(arr, start, middle - 1) 中的 start == end
当 middle == end 时，相当于 quickSort(arr, middle + 1, end) 中的 start == end + 1
当 middle == end -1 时，相当于 quickSort(arr, middle + 1, end) 中的 start == end
综上，我们可以将此边界条件统一移到 quickSort 函数之前：

Java

public static void quickSort(int[] arr, int start, int end) {
    // 如果区域内的数字少于 2 个，退出递归
    if (start == end || start == end + 1) return;
    // 将数组分区，并获得中间值的下标
    int middle = partition(arr, start, end);
    // 对左边区域快速排序
    quickSort(arr, start, middle - 1);
    // 对右边区域快速排序
    quickSort(arr, middle + 1, end);
}
更进一步，由上文所说的 middle >= start && middle <= end 可以推出，除了start == end || start == end + 1这两个条件之外，其他的情况下 start 都小于 end。所以我们可以将这个判断条件再次简写为：

Java

public static void quickSort(int[] arr, int start, int end) {
    // 如果区域内的数字少于 2 个，退出递归
    if (start >= end) return;
    // 将数组分区，并获得中间值的下标
    int middle = partition(arr, start, end);
    // 对左边区域快速排序
    quickSort(arr, start, middle - 1);
    // 对右边区域快速排序
    quickSort(arr, middle + 1, end);
}
这样我们就写出了最简洁版的边界条件，我们需要知道，这里的 start >= end 实际上只有两种情况：

start == end: 表明区域内只有一个数字
start == end + 1: 表明区域内一个数字也没有
不会存在 start 比 end 大 2 或者大 3 之类的。

分区算法实现
快速排序中最重要的便是分区算法，也就是 partition 函数。大多数人都能说出快速排序的整体思路，但实现起来却很难一次写对。主要问题就在于分区时存在的各种边界条件，需要读者亲自动手实践才能加深体会。

上文已经说到，partition 函数需要做的事情就是将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标。那么首先我们要做的事情就是选择一个基数，基数我们一般称之为 pivot，意为“轴”。整个数组就像围绕这个轴进行旋转，小于轴的数字旋转到左边，大于轴的数字旋转到右边。（所谓的双轴快排就是一次选取两个基数，将数组分为三个区域进行旋转，关于双轴快排的内容我们将在后续章节讲解。）

基数的选择
基数的选择没有固定标准，随意选择区间内任何一个数字做基数都可以。通常来讲有三种选择方式：

选择第一个元素作为基数
选择最后一个元素作为基数
选择区间内一个随机元素作为基数
选择的基数不同，算法的实现也不同。实际上第三种选择方式的平均时间复杂度是最优的，待会分析时间复杂度时我们会详细说明。

本文通过第一种方式来讲解快速排序：

Java

// 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
public static int partition(int[] arr, int start, int end) {
    // 取第一个数为基数
    int pivot = arr[start];
    // 从第二个数开始分区
    int left = start + 1;
    // 右边界
    int right = end;
    // TODO
}
最简单的分区算法
分区的方式也有很多种，最简单的思路是：从 left 开始，遇到比基数大的数，就交换到数组最后，并将 right 减一，直到 left 和 right 相遇，此时数组就被分成了左右两个区域。再将基数和中间的数交换，返回中间值的下标即可。

按照这个思路，我们敲出了如下代码：

Java

public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
}
public static void quickSort(int[] arr, int start, int end) {
    // 如果区域内的数字少于 2 个，退出递归
    if (start >= end) return;
    // 将数组分区，并获得中间值的下标
    int middle = partition(arr, start, end);
    // 对左边区域快速排序
    quickSort(arr, start, middle - 1);
    // 对右边区域快速排序
    quickSort(arr, middle + 1, end);
}
// 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
public static int partition(int[] arr, int start, int end) {
    // 取第一个数为基数
    int pivot = arr[start];
    // 从第二个数开始分区
    int left = start + 1;
    // 右边界
    int right = end;
    // left、right 相遇时退出循环
    while (left < right) {
        // 找到第一个大于基数的位置
        while (left < right && arr[left] <= pivot) left++;
        // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
        if (left != right) {
            exchange(arr, left, right);
            right--;
        }
    }
    // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
    if (left == right && arr[right] > pivot) right--;
    // 将基数和中间数交换
    if (right != start) exchange(arr, start, right);
    // 返回中间值的下标
    return right;
}
private static void exchange(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
因为我们选择了数组的第一个元素作为基数，并且分完区后，会执行将基数和中间值交换的操作，这就意味着交换后的中间值会被分到左边区域。所以我们需要保证中间值的下标是分区完成后，最后一个比基数小的值，这里我们用 right 来记录这个值。

这段代码有一个细节。首先，在交换 left 和 right 之前，我们判断了 left != right，这是因为如果剩余的数组都比基数小，则 left 会加到 right 才停止，这时不应该发生交换。因为 right 已经指向了最后一个比基数小的值。

但这里的拦截可能会拦截到一种错误情况，如果剩余的数组只有最后一个数比基数大，left 仍然加到 right 停止了，但我们并没有发生交换。所以我们在退出循环后，单独比较了 arr[right] 和 pivot。

实际上，这行单独比较的代码非常巧妙，一共处理了三种情况：

一是刚才提到的剩余数组中只有最后一个数比基数大的情况
二是 left 和 right 区间内只有一个值，则初始状态下， left == right，所以 while (left < right) 根本不会进入，所以此时我们单独比较这个值和基数的大小关系
三是剩余数组中每个数都比基数大，此时 right 会持续减小，直到和 left 相等退出循环，此时 left 所在位置的值还没有和 pivot 进行比较，所以我们单独比较 left 所在位置的值和基数的大小关系
双指针分区算法
除了上述的分区算法外，还有一种双指针的分区算法更为常用：从 left 开始，遇到比基数大的数，记录其下标；再从 right 往前遍历，找到第一个比基数小的数，记录其下标；然后交换这两个数。继续遍历，直到 left 和 right 相遇。然后就和刚才的算法一样了，交换基数和中间值，并返回中间值的下标。

代码如下：

Java

public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
}
public static void quickSort(int[] arr, int start, int end) {
    // 如果区域内的数字少于 2 个，退出递归
    if (start >= end) return;
    // 将数组分区，并获得中间值的下标
    int middle = partition(arr, start, end);
    // 对左边区域快速排序
    quickSort(arr, start, middle - 1);
    // 对右边区域快速排序
    quickSort(arr, middle + 1, end);
}
// 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
public static int partition(int[] arr, int start, int end) {
    // 取第一个数为基数
    int pivot = arr[start];
    // 从第二个数开始分区
    int left = start + 1;
    // 右边界
    int right = end;
    while (left < right) {
        // 找到第一个大于基数的位置
        while (left < right && arr[left] <= pivot) left++;
        // 找到第一个小于基数的位置
        while (left < right && arr[right] >= pivot) right--;
        // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
        if (left < right) {
            exchange(arr, left, right);
            left++;
            right--;
        }
    }
    // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
    if (left == right && arr[right] > pivot) right--;
    // 将基数和轴交换
    exchange(arr, start, right);
    return right;
}
private static void exchange(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
同样地，我们需要在退出循环后，单独比较 left 和 right 的值。

从代码实现中可以分析出，快速排序是一种不稳定的排序算法，在分区过程中，相同数字的相对顺序可能会被修改。

时间复杂度 & 空间复杂度
快速排序的时间复杂度上文已经提到过，平均时间复杂度为 O(nlogn)O(nlogn)，最坏的时间复杂度为 O(n^2)O(n 
2
 )，空间复杂度与递归的层数有关，每层递归会生成一些临时变量，所以空间复杂度为 O(logn)O(logn) ~ O(n)O(n)，平均空间复杂度为 O(logn)O(logn)。

回到前文提到的那个问题，为什么说随机选择剩余数组中的一个元素作为基数的方案平均复杂度是最优的呢？要理清这个问题，我们先来看一下什么情况下快速排序算法的时间复杂度最高，一共有两种情况。

数组为正序：

数组为逆序：

理想中的快速排序在第 k 轮遍历中，可以排好 2^{k-1}2 
k−1
  个基数。但从图中我们发现，当数组原本为正序或逆序时，我们将第一个数作为基数的话，每轮分区后，都有一个区域是空的，也就是说数组中剩下的数字都被分到了同一个区域！这就导致了每一轮遍历只能排好一个基数。所以总的比较次数为 (n - 1) + (n - 2) + (n - 3) + ... + 1 次，由等差数列求和公式可以计算出总的比较次数为 n(n - 1)/2 次，此时快速排序的时间复杂度达到了 O(n^2)O(n 
2
 ) 级。

有的读者可能会疑惑，既然数组已经有序了，为什么还要再对其排序呢？这个操作看起来毫无意义。但事实可能让你大吃一惊，因为在实际工作中，这种重复排序的需求非常常见。

设想一个场景，前端程序员从第三方平台提供的接口中获取一列数据，并且产品部门要求前端必须保证这一列数据在展示给用户时是有序的。在测试环境下，前端程序员发现从第三方平台获取到的数据总是有序的，但为了保险起见，他还是不得不对收到的数据再次进行排序。因为第三方平台提供的数据是不可控的，他不能选择相信后台，否则万一哪天后台提供的数据变成了无序的，给用户展示数据时就会出现问题。于是这里就发生了重复排序，此时如果直接使用快速排序就可能出现排序速度很慢，拖慢程序性能的问题。

如何解决这样的问题呢？其实思路也很简单，只要我们每轮选择的基数不是剩余数组中最大或最小的值就可以了。具体方案有很多种，其中较常用的有三种。

快速排序的优化思路
第一种就是我们在前文中提到的，每轮选择基数时，从剩余的数组中随机选择一个数字作为基数。这样每轮都选到最大或最小值的概率就会变得很低了。所以我们才说用这种方式选择基数，其平均时间复杂度是最优的

第二种解决方案是在排序之前，先用洗牌算法将数组的原有顺序打乱，以防止原数组正序或逆序。

Java 已经将洗牌算法封装到了集合类中，即 Collections.shuffle() 函数。洗牌算法由 Ronald A.Fisher 和 Frank Yates 于 1938 年发明，思路是每次从未处理的数据中随机取出一个数字，然后把该数字放在数组中所有未处理数据的尾部。 Collections.shuffle() 函数源码如下：

Java

private static final int SHUFFLE_THRESHOLD = 5;

public static void shuffle(List<?> list, Random rnd) {
    int size = list.size();
    if (size < SHUFFLE_THRESHOLD || list instanceof RandomAccess) {
        for (int i=size; i>1; i--)
            swap(list, i-1, rnd.nextInt(i));
    } else {
        Object arr[] = list.toArray();
        // Shuffle array
        for (int i=size; i>1; i--)
            swap(arr, i-1, rnd.nextInt(i));
        // Dump array back into list
        // instead of using a raw type here, it's possible to capture
        // the wildcard but it will require a call to a supplementary
        // private method
        ListIterator it = list.listIterator();
        for (int i=0; i<arr.length; i++) {
            it.next();
            it.set(arr[i]);
        }
    }
}

public static void swap(List<?> list, int i, int j) {
    // instead of using a raw type here, it's possible to capture
    // the wildcard but it will require a call to a supplementary
    // private method
    final List l = list;
    l.set(i, l.set(j, l.get(i)));
}

private static void swap(Object[] arr, int i, int j) {
    Object tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
从源码中可以看出，对于数据量较小的列表（少于 5 个值），shuffle 函数直接通过列表的 set 方法进行洗牌，否则先将 list 转换为 array，再进行洗牌，以提高交换效率，洗牌完成后再将 array 转成 list 返回。

还有一种解决方案，既然数组重复排序的情况如此常见，那么我们可以在快速排序之前先对数组做个判断，如果已经有序则直接返回，如果是逆序则直接倒序即可。在 Java 内部封装的 Arrays.sort() 的源码中就采用了此解决方案。

关于 Arrays.sort() 函数的更多细节，我们将在后续章节讲解。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/eul7hm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。