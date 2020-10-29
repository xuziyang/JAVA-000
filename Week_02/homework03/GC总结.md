测试环境 ubuntu18 4核 8g内存

测试程序
```
import java.util.Random;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.atomic.LongAdder;

/*

演示GC日志生成与解读

*/

public class GCLogAnalysis {

    private static Random random = new Random();

    public static void main(String[] args) {

        // 当前毫秒时间戳

        long startMillis = System.currentTimeMillis();

        // 持续运行毫秒数; 可根据需要进行修改

        long timeoutMillis = TimeUnit.SECONDS.toMillis(1);

        // 结束时间戳

        long endMillis = startMillis + timeoutMillis;

        LongAdder counter = new LongAdder();

        System.out.println("正在执行...");

        // 缓存一部分对象; 进入老年代

        int cacheSize = 2000;

        Object[] cachedGarbage = new Object[cacheSize];

        // 在此时间范围内,持续循环

        while (System.currentTimeMillis() < endMillis) {

            // 生成垃圾对象

            Object garbage = generateGarbage(100*1024);

            counter.increment();

            int randomIndex = random.nextInt(2 * cacheSize);

            if (randomIndex < cacheSize) {

                cachedGarbage[randomIndex] = garbage;

            }

        }

        System.out.println("执行结束!共生成对象次数:" + counter.longValue());

    }



    // 生成对象

    private static Object generateGarbage(int max) {

        int randomSize = random.nextInt(max);

        int type = randomSize % 4;

        Object result = null;

        switch (type) {

            case 0:

                result = new int[randomSize];

                break;

            case 1:

                result = new byte[randomSize];

                break;

            case 2:

                result = new double[randomSize];

                break;

            default:

                StringBuilder builder = new StringBuilder();

                String randomString = "randomString-Anything";

                while (builder.length() < randomSize) {

                    builder.append(randomString);

                    builder.append(max);

                    builder.append(randomSize);

                }

                result = builder.toString();

                break;

        }

        return result;

    }

}
```
每种GC，在4种堆内存设置下，跑10次，取平均值，得到以下数据：

生成对象数
Xmx   | Serival | parallel | CMS |    G1 |
---   |   :--:  | :---:    | :---: | ---:
512m  |   9718  |   7592   |  10158 |  9923
1024m |   12420 |  11050   | 12762 | 13554 |
2g    |   12095  |   15175   |  12841 | 13003 |
4g    |   9829  |   14077   |  12031 | 16270 |


最小停顿时间 / 最大停顿时间 / 总停顿时间
Xmx   | Serival | parallel |
---   |   :--:  | :---:    
512m  |   10 ms /  50 ms / 600 ms  |   0ms / 50ms / 630ms   | 
1024m |   10 ms/ 60 ms / 440ms     |   0ms / 300ms / 550ms |  |
2g    |   70 ms / 90 ms / 370ms    |   20ms / 40ms / 310ms   | 
4g    |   110ms / 140ms / 250ms    |   40ms / 50ms / 140ms   |  

最小停顿时间 / 最大停顿时间 / 平均停顿时间
Xmx   |          CMS |    G1  |
---   | :---:        | ---:
512m  |  0ms / 60ms / 13.3ms  |  0ms / 40ms / 3.83ms
1024m |  0ms / 50ms / 20ms  |  0ms / 20ms / 5.11ms
2g    |  20ms/ 50ms / 37.5ms|  0ms / 10ms / 5.83ms
4g    |  20ms/ 50ms /42.5ms |  10ms / 30ms / 15.3ms

从以上数据看：

1. SerailGC 和 PrallectGC 随着内存的增大，吞吐量先增大，后变小。  
   从512m内存到1g内存，吞吐量变大是因为内存增大后，GC次数变少，每次GC更有效率。  
   从2g到4g内存，总GC时间短了，但是吞吐量下来了还挺奇怪的
2. ParalleGC 在小内存的时（512m, 1g）的表现不如SerialGC； 
3. 2g内存时，ParallelGC的吞吐量最大
4. 4g内存时，G1的吞吐量超过了ParallelGC，还挺意外的
5. 512m、1g、2g内存时，CMS和G1的吞吐量相差不大；4g内存时，G1的吞吐量明显大于CMS
6. 在这4种规格堆内存设置下，G1的延迟都比CMS要低




使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar 示例。结果差距不大，没啥参考意义。x