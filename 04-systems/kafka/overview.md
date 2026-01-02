# 系统：Kafka

## 概览

Kafka 是事件流（event streaming）的骨干系统，用于数据接入、解耦生产者/消费者，并支持重放（replay）。

## 核心概念

- Topic / Partition：顺序边界（ordering boundary）
- Consumer group：并行度 + 高可用（HA）
- Offset：消费进度指针（commit 策略决定语义）
- Retention vs compaction：按时间保留 vs 日志压缩
- Producer 幂等与事务（EOS 边界）

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


