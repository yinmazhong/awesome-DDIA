# Roadmap Index (R0)（路线图索引）

This roadmap is a learning + delivery path for building data-intensive systems (DDIA) with a Data Engineering stack: Kafka + Flink + ClickHouse + Spark + Hive/Lakehouse.（这是一条“学习 + 交付”的主线，用于构建数据密集型系统）

## Prerequisites (Basics)（基础能力）

- Algorithms & Data Structures（算法与数据结构）
- Operating Systems（计算机操作系统）
- Computer Networks（计算机网络）
- Computer Architecture（计算机组成与原理）

## How to use（使用方式）

- Read one module, then produce artifacts (notes + runnable demos + checklists).（学一模块，产出一批可复用资产）
- Prefer writing（优先沉淀到这些目录）:
  - Concept cards in [`02-concepts/`](../02-concepts/)（概念卡）
  - Patterns in [`03-patterns/`](../03-patterns/)（工程模式/套路）
  - System runbooks in [`04-systems/`](../04-systems/) `<system>/`（系统手册/排障）
  - ADRs in [`05-architecture/adr/`](../05-architecture/adr/)（架构决策记录）
  - Postmortems in [`11-postmortems/`](../11-postmortems/)（事故复盘）

## Modules（模块）

- R1: Foundations (DDIA)（基础） → [`R1-foundations-ddia.md`](R1-foundations-ddia.md)
- R2: Kafka & event streaming（消息与事件流） → [`R2-kafka-streaming.md`](R2-kafka-streaming.md)
- R3: Flink & stateful stream processing（流处理） → [`R3-flink-stream-processing.md`](R3-flink-stream-processing.md)
- R4: Spark batch & lakehouse ingestion（批处理与湖仓） → [`R4-spark-batch-lakehouse.md`](R4-spark-batch-lakehouse.md)
- R5: ClickHouse OLAP serving（分析服务） → [`R5-clickhouse-olap-serving.md`](R5-clickhouse-olap-serving.md)
- R6: Platform engineering & governance（平台化与治理） → [`R6-platform-governance.md`](R6-platform-governance.md)

## Definition of “done” (per module)（完成标准）

- Notes（笔记）:
  - 3-8 concept cards（概念卡）
  - 1-3 patterns（模式卡/套路卡）
- Demo（示例）:
  - A minimal runnable example (or a reproducible config)（最小可运行 demo 或可复现配置）
- Ops（运维）:
  - A short runbook section: “signals → diagnosis → fix”（信号 → 定位 → 修复）
- Decision（决策）:
  - 1 ADR for a real trade-off you faced（记录一次真实取舍）

## Portfolio projects (suggested)（建议作品集项目）

- P1: Kafka → Flink real-time metric aggregation → ClickHouse serving（实时指标：采集→计算→服务）
- P2: Spark batch backfill pipeline for the same metric table (reconciliation with streaming)（离线补数 + 与实时对账）
- P3: Data quality gates + alerting + replay/backfill playbook（质量门禁 + 告警 + 回放/补数手册）

## Personal focus areas (fill in)（个人关注点）

- Primary domain（业务领域）: <ads / ecommerce / risk / observability / ...>
- Primary pain points（主要痛点）: <late data / correctness / cost / ...>
- Current skill gaps（能力缺口）: <...>
