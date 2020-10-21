-Xms 用来设置堆空间初始大小
     -X 非标准参数
     ms memory start

-Xmx 用来设置堆空间最大值

默认情况下，初始内存大小：物理内存 / 64
          最大内存大小：物理内存 / 4


配置新生代与老年代在堆结构占比
- 默认 -XX:NewRatio=2,表示新生代占1，老年代占2， 新生代占整个堆的1/3
- 可以修改 -XX:NewRatio=4, 表示新生代占1，老年代占4，新生代占整个堆的1/5  
  
-XX:SurvivorRatio: 设置新生代中Eden区与Survivor区的比例，默认8  
-XX:+UseAdaptiveSizePolicy: 自适应的内存分配策略  
-Xmn: 设置新生代的空间的大小 （不一般不设置）  


  
