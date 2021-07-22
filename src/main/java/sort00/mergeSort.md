归并排序
约翰·冯·诺伊曼在 1945 年提出了归并排序。在讲解归并排序之前，我们先一起思考一个问题：如何将两个有序的列表合并成一个有序的列表？

将两个有序的列表合并成一个有序的列表
这太简单了，笔者首先想到的思路就是，将两个列表拼接成一个列表，然后之前学的冒泡、选择、插入、希尔、堆、快排都可以派上用场了。

觉得太暴力了一点？那我们换个思路。

既然列表已经有序了，通过前几章的学习，我们已经知道，插入排序的过程中，被插入的数组也是有序的。这就好办了，我们将其中一个列表中的元素逐个插入另一个列表中即可。

但是按照这个思路，我们只需要一个列表有序就行了，另一个列表不管是不是有序的，都会被逐个取出来，插入第一个列表中。那么，在两个列表都已经有序的情况下，还可以有更优的合并方案吗？

深入思考之后，我们发现，在第二个列表向第一个列表逐个插入的过程中，由于第二个列表已经有序，所以后续插入的元素一定不会在前面插入的元素之前。在逐个插入的过程中，每次插入时，只需要从上次插入的位置开始，继续向后寻找插入位置即可。这样一来，我们最多只需要将两个有序数组遍历一次就可以完成合并。

思路很接近了，如何实现它呢？我们发现，在向数组中不断插入新数字时，原数组需要不断腾出位置，这是一个比较复杂的过程，而且这个过程必然导致增加一轮遍历。

但好在我们有一个替代方案：只要开辟一个长度等同于两个数组长度之和的新数组，并使用两个指针来遍历原有的两个数组，不断将较小的数字添加到新数组中，并移动对应的指针即可。

根据这个思路，我们可以写出合并两个有序列表的代码：

Java

// 将两个有序数组合并为一个有序数组
private static int[] merge(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int index1 = 0, index2 = 0;
    while (index1 < arr1.length && index2 < arr2.length) {
        if (arr1[index1] <= arr2[index2]) {
            result[index1 + index2] = arr1[index1];
            index1++;
        } else {
            result[index1 + index2] = arr2[index2];
            index2++;
        }
    }
    // 将剩余数字补到结果数组之后
    while (index1 < arr1.length) {
        result[index1 + index2] = arr1[index1];
        index1++;
    }
    while (index2 < arr2.length) {
        result[index1 + index2] = arr2[index2];
        index2++;
    }
    return result;
}
这份代码的实现思路和我们分析的一模一样：首先开辟了一个新数组 result，长度等同于 arr1 和 arr2 的长度之和，然后使用 index1 记录 arr1 数组的下标，index2 记录 arr2 数组的下标。再将两个数组中较小的值不断添加到 result 中。其中，result 的当前下标等同于 index1 和 index2 之和。

如果你对 ++ 运算符用得熟练的话：

Java

result[index1 + index2] = arr1[index1];
index1++;
可以简写成：

Java

result[index1 + index2] = arr1[index1++];
这样代码看起来会更简洁一些。

合并有序数组的问题解决了，但我们排序时用的都是无序数组，那么上哪里去找这两个有序的数组呢？

答案是 —— 自己拆分，我们可以把数组不断地拆成两份，直到只剩下一个数字时，这一个数字组成的数组我们就可以认为它是有序的。

然后通过上述合并有序列表的思路，将 1 个数字组成的有序数组合并成一个包含 2 个数字的有序数组，再将 2 个数字组成的有序数组合并成包含 4 个数字的有序数组...直到整个数组排序完成，这就是归并排序（Merge Sort）的思想。

将数组拆分成有序数组
拆分过程使用了二分的思想，这是一个递归的过程，归并排序使用的递归框架如下：

Java

public static void mergeSort(int[] arr) {
    if (arr.length == 0) return;
    int[] result = mergeSort(arr, 0, arr.length - 1);
    // 将结果拷贝到 arr 数组中
    for (int i = 0; i < result.length; i++) {
        arr[i] = result[i];
    }
}

// 对 arr 的 [start, end] 区间归并排序
private static int[] mergeSort(int[] arr, int start, int end) {
    // 只剩下一个数字，停止拆分，返回单个数字组成的数组
    if (start == end) return new int[]{arr[start]};
    int middle = (start + end) / 2;
    // 拆分左边区域
    int[] left = mergeSort(arr, start, middle);
    // 拆分右边区域
    int[] right = mergeSort(arr, middle + 1, end);
    // 合并左右区域
    return merge(left, right);
}
其中， mergeSort(int[] arr) 函数是对外暴露的公共方法，内部调用了私有的mergeSort(int[] arr, int start, int end) 函数，这个函数用于对 arr 的 [start, end] 区间进行归并排序。

可以看到，我们在这个函数中，将原有数组不断地二分，直到只剩下最后一个数字。此时嵌套的递归开始返回，一层层地调用merge(int[] arr1, int[] arr2)函数，也就是我们刚才写的将两个有序数组合并为一个有序数组的函数。

这就是最经典的归并排序，只需要一个二分拆数组的递归函数和一个合并两个有序列表的函数即可。

但这份代码还有一个缺点，那就是在递归过程中，开辟了很多临时空间，接下来我们就来看下它的优化过程。

归并排序的优化：减少临时空间的开辟
为了减少在递归过程中不断开辟空间的问题，我们可以在归并排序之前，先开辟出一个临时空间，在递归过程中统一使用此空间进行归并即可。

代码如下：

Java

public static void mergeSort(int[] arr) {
    if (arr.length == 0) return;
    int[] result = new int[arr.length];
    mergeSort(arr, 0, arr.length - 1, result);
}

// 对 arr 的 [start, end] 区间归并排序
private static void mergeSort(int[] arr, int start, int end, int[] result) {
    // 只剩下一个数字，停止拆分
    if (start == end) return;
    int middle = (start + end) / 2;
    // 拆分左边区域，并将归并排序的结果保存到 result 的 [start, middle] 区间
    mergeSort(arr, start, middle, result);
    // 拆分右边区域，并将归并排序的结果保存到 result 的 [middle + 1, end] 区间
    mergeSort(arr, middle + 1, end, result);
    // 合并左右区域到 result 的 [start, end] 区间
    merge(arr, start, end, result);
}

// 将 result 的 [start, middle] 和 [middle + 1, end] 区间合并
private static void merge(int[] arr, int start,  int end, int[] result) {
    int middle = (start + end) / 2;
    // 数组 1 的首尾位置
    int start1 = start;
    int end1 = middle;
    // 数组 2 的首尾位置
    int start2 = middle + 1;
    int end2 = end;
    // 用来遍历数组的指针
    int index1 = start1;
    int index2 = start2;
    // 结果数组的指针
    int resultIndex = start1;
    while (index1 <= end1 && index2 <= end2) {
        if (arr[index1] <= arr[index2]) {
            result[resultIndex++] = arr[index1++];
        } else {
            result[resultIndex++] = arr[index2++];
        }
    }
    // 将剩余数字补到结果数组之后
    while (index1 <= end1) {
        result[resultIndex++] = arr[index1++];
    }
    while (index2 <= end2) {
        result[resultIndex++] = arr[index2++];
    }
    // 将 result 操作区间的数字拷贝到 arr 数组中，以便下次比较
    for (int i = start; i <= end; i++) {
        arr[i] = result[i];
    }
}
在这份代码中，我们统一使用 result 数组作为递归过程中的临时数组，所以merge 函数接收的参数不再是两个数组，而是 result 数组中需要合并的两个数组的首尾下标。根据首尾下标可以分别计算出两个有序数组的首尾下标 start1、end1、start2、end2，之后的过程就和之前合并两个有序数组的代码类似了。

这份代码还可以再精简一下，我们可以去掉一些不会改变的临时变量。比如 start1 始终等于 start，end2 始终等于 end，end1 始终等于 middle。并且分析可知，resultIndex 的值始终等于 start 加上 index1 和 index2 移动的距离。即：

Java

resultIndex = start + (index1 - start1) + (index2 - start2)
将 start1 == start 代入，化简得：

Java

resultIndex = index1 + index2 - start2
所以最终的归并排序代码如下：

Java

public static void mergeSort(int[] arr) {
    if (arr.length == 0) return;
    int[] result = new int[arr.length];
    mergeSort(arr, 0, arr.length - 1, result);
}

// 对 arr 的 [start, end] 区间归并排序
private static void mergeSort(int[] arr, int start, int end, int[] result) {
    // 只剩下一个数字，停止拆分
    if (start == end) return;
    int middle = (start + end) / 2;
    // 拆分左边区域，并将归并排序的结果保存到 result 的 [start, middle] 区间
    mergeSort(arr, start, middle, result);
    // 拆分右边区域，并将归并排序的结果保存到 result 的 [middle + 1, end] 区间
    mergeSort(arr, middle + 1, end, result);
    // 合并左右区域到 result 的 [start, end] 区间
    merge(arr, start, end, result);
}

// 将 result 的 [start, middle] 和 [middle + 1, end] 区间合并
private static void merge(int[] arr, int start, int end, int[] result) {
    int end1 = (start + end) / 2;
    int start2 = end1 + 1;
    // 用来遍历数组的指针
    int index1 = start;
    int index2 = start2;
    while (index1 <= end1 && index2 <= end) {
        if (arr[index1] <= arr[index2]) {
            result[index1 + index2 - start2] = arr[index1++];
        } else {
            result[index1 + index2 - start2] = arr[index2++];
        }
    }
    // 将剩余数字补到结果数组之后
    while (index1 <= end1) {
        result[index1 + index2 - start2] = arr[index1++];
    }
    while (index2 <= end) {
        result[index1 + index2 - start2] = arr[index2++];
    }
    // 将 result 操作区间的数字拷贝到 arr 数组中，以便下次比较
    while (start <= end) {
        arr[start] = result[start++];
    }
}
牺牲了一些可读性，代码变得精简了不少。动图演示如下：



原地归并排序？
现在的归并排序看起来仍"美中不足"，那就是仍然需要开辟额外的空间，能不能实现不开辟额外空间的归并排序呢？好像是可以做到的。在一些文章中，将这样的归并排序称之为 In-Place Merge Sort，直译为原地归并排序。

代码实现思路主要有两种：

Java

public static void mergeSort(int[] arr) {
    if (arr.length == 0) return;
    mergeSort(arr, 0, arr.length - 1);
}

// 对 arr 的 [start, end] 区间归并排序
private static void mergeSort(int[] arr, int start, int end) {
    // 只剩下一个数字，停止拆分
    if (start == end) return;
    int middle = (start + end) / 2;
    // 拆分左边区域
    mergeSort(arr, start, middle);
    // 拆分右边区域
    mergeSort(arr, middle + 1, end);
    // 合并左右区域
    merge(arr, start, end);
}

// 将 arr 的 [start, middle] 和 [middle + 1, end] 区间合并
private static void merge(int[] arr, int start, int end) {
    int end1 = (start + end) / 2;
    int start2 = end1 + 1;
    // 用来遍历数组的指针
    int index1 = start;
    int index2 = start2;
    while (index1 <= end1 && index2 <= end) {
        if (arr[index1] <= arr[index2]) {
            index1++;
        } else {
            // 右边区域的这个数字比左边区域的数字小，于是它站了起来
            int value = arr[index2];
            int index = index2;
            // 前面的数字不断地后移
            while (index > index1) {
                arr[index] = arr[index - 1];
                index--;
            }
            // 这个数字坐到 index1 所在的位置上
            arr[index] = value;
            // 更新所有下标，使其前进一格
            index1++;
            index2++;
            end1++;
        }
    }
}
这段代码在合并 arr 的 [start, middle] 区间和 [middle + 1, end] 区间时，将两个区间较小的数字移动到 index1 的位置，并且将左边区域不断后移，目的是给新插入的数字腾出位置。最后更新两个区间的下标，继续合并更新后的区间。

第二种实现思路：

Java

public static void mergeSort(int[] arr) {
    if (arr.length == 0) return;
    mergeSort(arr, 0, arr.length - 1);
}

// 对 arr 的 [start, end] 区间归并排序
private static void mergeSort(int[] arr, int start, int end) {
    // 只剩下一个数字，停止拆分
    if (start == end) return;
    int middle = (start + end) / 2;
    // 拆分左边区域
    mergeSort(arr, start, middle);
    // 拆分右边区域
    mergeSort(arr, middle + 1, end);
    // 合并左右区域
    merge(arr, start, end);
}

// 将 arr 的 [start, middle] 和 [middle + 1, end] 区间合并
private static void merge(int[] arr, int start, int end) {
    int end1 = (start + end) / 2;
    int start2 = end1 + 1;
    // 用来遍历数组的指针
    int index1 = start;
    while (index1 <= end1 && start2 <= end) {
        if (arr[index1] > arr[start2]) {
            // 将 index1 和 start2 下标的数字交换
            exchange(arr, index1, start2);
            if (start2 != end) {
                // 调整交换到 start2 上的这个数字的位置，使右边区域继续保持有序
                int value = arr[start2];
                int index = start2;
                // 右边区域比 arr[start2] 小的数字不断前移
                while (index < end && arr[index + 1] < value) {
                    arr[index] = arr[index + 1];
                    index++;
                }
                // 交换到右边区域的这个数字找到了自己合适的位置，坐下
                arr[index] = value;
            }
        }
        index1++;
    }
}

private static void exchange(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
这段代码在合并区间时，同样是将两个区间中较小的数字移到 index1 的位置，不过采用的是两个区间的首个数字直接交换的思路，交换完成后，将交换到右边区间的数字不断后移，以使得右边区间继续保持有序。

这两种思路看起来都很美好，但这真的实现了原地归并排序吗？

分析代码可以看出，这样实现的归并本质上是插入排序！前文已经说到，在插入排序中，腾出位置是一个比较复杂的过程，而且这个过程必然导致增加一轮遍历。在这两份代码中，每一次合并数组时，都使用了两层循环，目的就是不断腾挪位置以插入新数字，可以看出这里合并的效率是非常低的。这两种排序算法的时间复杂度都达到了 O(n^2)O(n 
2
 ) 级，不能称之为归并排序。它们只是借用了归并排序的递归框架而已。

也就是说，所谓的原地归并排序事实上并不存在，许多算法书籍中都没有收录这种算法。它打着归并排序的幌子，卖的是插入排序的思想，实际排序效率比归并排序低得多。

时间复杂度 & 空间复杂度
归并排序的复杂度比较容易分析，拆分数组的过程中，会将数组拆分 logn 次，每层执行的比较次数都约等于 n 次，所以时间复杂度是 O(nlogn)O(nlogn)。

空间复杂度是 O(n)O(n)，主要占用空间的就是我们在排序前创建的长度为 n 的 result 数组。

分析归并的过程可知，归并排序是一种稳定的排序算法。其中，对算法稳定性非常重要的一行代码是：

Java

if (arr[index1] <= arr[index2]) {
    result[index1 + index2 - start2] = arr[index1++];
}
在这里我们通过arr[index1] <= arr[index2]来合并两个有序数组，保证了原数组中，相同的元素相对顺序不会变化，如果这里的比较条件写成了arr[index1] < arr[index2]，则归并排序将变得不稳定。

总结起来，归并排序分成两步，一是拆分数组，二是合并数组，它是分治思想的典型应用。分治的意思是“分而治之”，分的时候体现了二分的思想，“一尺之棰，日取其半，logn 世竭”，治是一个滚雪球的过程，将 1 个数字组成的有序数组合并成一个包含 2 个数字的有序数组，再将 2 个数字组成的有序数组合并成包含 4 个数字的有序数组...如《活着》一书中的经典名句：“小鸡长大了就变成了鹅；鹅长大了，就变成了羊；羊再长大了，就变成了牛...”

由于性能较好，且排序稳定，归并排序应用非常广泛，Arrays.sort() 源码中的 TimSort就是归并排序的优化版。

单选题
归并排序在极端情况下的时间复杂度是多少？

A
归并排序最好时间复杂度为 O(nlogn)O(nlogn)，最坏时间复杂度为 O(n^2)O(n 
2
 )

B
归并排序最好时间复杂度和最坏时间复杂度都是 O(nlogn)O(nlogn)

C
归并排序最好时间复杂度为 O(n)O(n)，最坏时间复杂度为 O(nlogn)O(nlogn)

D
归并排序最好时间复杂度为 O(n)O(n)，最坏时间复杂度为 O(n^2)O(n 
2
 )


重做

提交
答案 正确，正确答案是 B
正确率 67.86%
解析

归并排序需要递归 logn 次拆分数组，拆分的每层都需要将 n 个数据遍历一次，最好和最坏的时间复杂度都是 O(nlogn)O(nlogn)。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/sort-algorithms/euivj1/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。