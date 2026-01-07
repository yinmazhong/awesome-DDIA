# 系统：Kafka

## 概览

Kafka 是事件流（event streaming）的骨干系统，用于数据接入、解耦生产者/消费者，并支持重放（replay）。

## 核心概念

- Topic / Partition：顺序边界（ordering boundary）
- Consumer group：并行度 + 高可用（HA）
- Offset：消费进度指针（commit 策略决定语义）
- Retention vs compaction：按时间保留 vs 日志压缩
- Producer 幂等与事务（EOS 边界）

- 消息：Record。Kafka 是消息引擎嘛，这里的消息就是指 Kafka 处理的主要对象。
- 主题：Topic。主题是承载消息的逻辑容器，在实际使用中多用来区分具体的业务。
- 分区：Partition。一个有序不变的消息序列。每个主题下可以有多个分区。
- 消息位移：Offset。表示分区中每条消息的位置信息，是一个单调递增且不变的值。
- 副本：Replica。Kafka 中同一条消息能够被拷贝到多个地方以提供数据冗余，这些地方就是所谓的副本。副本还分为领导者副本和追随者副本，各自有不同的角色划分。副本是在分区层级下的，即每个分区可配置多个副本实现高可用。
- 生产者：Producer。向主题发布新消息的应用程序。
- 消费者：Consumer。从主题订阅新消息的应用程序。
- 消费者位移：Consumer Offset。表征消费者消费进度，每个消费者都有自己的消费者位移。
- 消费者组：Consumer Group。多个消费者实例共同组成的一个组，同时消费多个分区以实现高吞吐。
- 重平衡：Rebalance。消费者组内某个消费者实例挂掉后，其他消费者实例自动重新分配订阅主题分区的过程。Rebalance 是 Kafka 消费者端实现高可用的重要手段。

## 架构

- Broker、Controller/Quorum、Log Segment
- Producer → Broker（acks）→ Consumer（poll）

## 投递语义（实践视角）

- 至少一次（at-least-once）通常是默认现实；在重试（retries）/重平衡（rebalance）时很容易出现重复。
- 恰好一次（exactly-once）只有在边界明确时才有意义（transactions + 幂等 sink，或 transactional sink）。

## 分区键策略

- 分区键选择关注：
  - 顺序要求
  - 负载分布（避免 hot key）
  - 消费端扩展性

## 运维与容量规划

- 容量规划
  - 吞吐：produce/consume 峰值 MB/s
  - 分区数：足够支撑并行度，但不要过多以免 controller 开销过大
  - 保留：磁盘容量 * 安全系数
- 常用高影响配置
  - `acks`, `retries`, `enable.idempotence`
  - `min.insync.replicas`、replication factor
  - `max.poll.interval.ms`, `session.timeout.ms`
  - `fetch.max.bytes`, `max.partition.fetch.bytes`

## 排障手册（Playbook）

- Lag 持续上升
  - 检查：consumer 吞吐、下游 backpressure、rebalance 频率
  - 处理：扩容 consumer、降低单条处理耗时、调整 fetch/batch、隔离热点分区
- Rebalance 风暴
  - 检查：处理时间过长导致未及时 poll、GC pauses、`max.poll.interval.ms`
  - 处理：增大 interval、优化处理逻辑、启用 cooperative rebalancing
- 重复（Duplicates）
  - 根因：retries / rebalance / 非幂等 sink
  - 修复：幂等键（idempotency key）、dedup store、transactional sink（可行时）

## 可观测性（黄金信号）

- Broker：under-replicated partitions、ISR shrink、request handler idle、disk usage
- Topic/Partition：bytes in/out、log end offset、retention
- Consumer：lag、rebalance count、commit latency、processing latency

## 参考

- Tags: #system #kafka #streaming


https://time.geekbang.org/column/intro/100029201?utm_campaign=geektime_search&utm_content=geektime_search&utm_medium=geektime_search&utm_source=geektime_search&utm_term=geektime_search&tab=catalog


