

[TOC]



## 开始

### 1.Dos命令

​			* cd.. : 退回到上一级目录

​			* cd\  : 退回到根目录

​			* cd tools: 进入tools文件夹

​			* d:   : 回车	盘符切换

​			* cd d:\234 :进入d盘的234文件夹,再切换盘符(d:)才能进入d:\234

​			* dir  : 列出当前目录下的文件以及文件夹

​			* cls  : 清除屏幕

​			* ipconfig: 查看本机的相关网络配置

### 2.Java关键字

![Java关键字](.\images\Java关键字.png)





## 数据结构

### 1.数组

Java的数组只是`引用类型`的变量，`它并不是数组对象本身`，只要让数组变量指向有效的数组对象

```java
int[] nums = new int[] {3,5,20,12};
int[] prices;
//让prices数组指向nums所引用的数组
prices = nums;

//输出prices数组
for(int i = 0;i<prices.length;i++){
  System.out.println(prices[i]);
}
//将prices数组的第三个元素赋值34
prices[2] = 34;

//再访问nums数组的第三个元素
System.out.println(nums[i]);
//输出  34 

```

> 首先要明确2个概念：
>
> 1.数组对象：保存在堆内存中的连续内存空间（所以要初始化它就必须给初始化数量）
>
> 2.数组变量：只是一个引用变量（不需要初始化数量）

![数组1](.\images\数组1.jpg)

### 2.速度





