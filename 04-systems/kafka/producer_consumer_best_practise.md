# Best Practise

kafka想解决现实问题硬件业务问题，达成的目标是：可靠性高、吞吐量高、延迟低
削峰填谷
order回传链路使用内存队列+redis实现削峰填谷


## kafka的三层消息架构串联
1. 第一层是主题层，每个主题可以配置 M 个分区，而每个分区又可以配置 N 个副本。
2. 第二层是分区层，每个分区的 N 个副本中只能有一个充当领导者角色，对外提供服务；其他 N-1 个副本是追随者副本，只是提供数据冗余之用。
3. 第三层是消息层，分区中包含若干条消息，每条消息的位移从 0 开始，依次递增。
4. 最后，客户端程序只能与分区的领导者副本进行交互。

## 消费者模板

### 消费者组 Kafka Consumer Group
使用消费者组的概念来
1. 可扩展性：方便扩展消费程序的并行度，提高吞吐量，
2. 容错性：重平衡时保证消息的顺序及完整性

GroupID协调组内所有的Consumer来订阅消费Topic的所有partition, 每个partition限制由一个Consumer来消费，因此避免重复消费的问题

Kafka 仅仅使用 Consumer Group 这一种机制，却同时实现了传统消息引擎系统的两大模型：
如果所有实例都属于同一个 Group，那么它实现的就是消息队列模型；如果所有实例分别属于不同的 Group，那么它实现的就是发布 / 订阅模型。

```java

public class KafkaConsumerRunner implements Runnable {
     private final AtomicBoolean closed = new AtomicBoolean(false);
     private final KafkaConsumer consumer;


     public void run() {
         try {
             consumer.subscribe(Arrays.asList("topic"));
             while (!closed.get()) {
      ConsumerRecords records = 
        consumer.poll(Duration.ofMillis(10000));
                 //  执行消息处理逻辑
             }
         } catch (WakeupException e) {
             // Ignore exception if closing
             if (!closed.get()) throw e;
         } finally {
             consumer.close();
         }
     }


     // Shutdown hook which can be called from a separate thread
     public void shutdown() {
         closed.set(true);
         consumer.wakeup();
     }



```java
private final KafkaConsumer<String, String> consumer;
private ExecutorService executors;
...


private int workerNum = ...;
executors = new ThreadPoolExecutor(
  workerNum, workerNum, 0L, TimeUnit.MILLISECONDS,
  new ArrayBlockingQueue<>(1000), 
  new ThreadPoolExecutor.CallerRunsPolicy());


...
while (true)  {
  ConsumerRecords<String, String> records = 
    consumer.poll(Duration.ofSeconds(1));
  for (final ConsumerRecord record : records) {
    executors.submit(new Worker(record));
  }
}
..

```



## 生产者模板


## 为什么kafka不允许读follower副本，像mysql那样

为了消息准确性，也就是不丢失数据
mysql在某些一致性语义下允许读follower副本，但kafka没有这样的语义


