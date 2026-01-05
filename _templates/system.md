# System: <Kafka/Flink/ClickHouse/Spark/Hive/...>

<!-- 系统名：你要记录的具体组件/中间件/存储，例如 Kafka、Flink、ClickHouse；建议一个文件一个系统 -->

## Overview

<!-- 概览：用最短文字回答“它是什么、用来干什么、为什么选它”；可补一句与你们业务的关系 -->
- What it is: <...>
- Core use cases: <...>

## Key concepts

<!-- 关键概念：列出 5-10 个必须理解的术语（如 partition、watermark、checkpoint、merge tree） -->
- <concept>: <definition>

## Architecture

<!-- 架构：建议画一张图并说明数据面/控制面；写清组件职责与关键依赖 -->
- Components: <...>
- Data path: <...>
- Control path: <...>

## Operations

<!-- 运维：容量规划、关键配置、升级/兼容性、备份恢复、常见故障处理步骤 -->
- Capacity planning: <throughput/storage/retention>
- Common configs: <...>
- Upgrade notes: <...>

## Troubleshooting

<!-- 排障：按“现象->原因->检查->修复”格式沉淀；最好附命令/看板链接/Runbook 链接 -->
- Symptom -> likely cause -> checks -> fix

## Observability

<!-- 可观测：黄金指标（延迟/错误/吞吐/饱和度）+ 业务 KPI；写清告警阈值与处理指引 -->
- Golden signals / KPIs

## References

<!-- 参考：官方文档、最佳实践、你们内部 ADR/事故复盘/压测报告 -->
- <links>
