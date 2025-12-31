# awesome-DDIA（中文）

一个面向 **数据密集型应用 / 数据开发（Data Engineering）** 的个人知识库，主线参考 DDIA，并结合常用工程栈：Kafka + Flink + ClickHouse + Spark + Hive/Lakehouse。

- English: `README.md`

## 从这里开始（Start Here）

- `01-roadmap/`：学习路径与里程碑
  - 入口：`01-roadmap/R0-index.md`
- `02-concepts/`：概念卡（定义 / why / pitfalls）
- `03-patterns/`：工程模式（幂等 / Outbox / 回放…）
- `04-systems/`：系统与组件（Kafka / Flink / ClickHouse / Spark / Hive & Lakehouse）
  - Kafka：`04-systems/kafka/overview.md`
  - Flink：`04-systems/flink/overview.md`
  - ClickHouse：`04-systems/clickhouse/overview.md`
  - Spark：`04-systems/spark/overview.md`
  - Hive/Lakehouse：`04-systems/hive-lakehouse/overview.md`
- `05-architecture/`：架构方法与 ADR（决策记录）、容量规划、SLO、演进
- `07-reliability/`：正确性与可靠性（回放/补数/对账/数据质量）
- `08-observability/`：可观测性（metrics/logs/tracing/lineage）

## 导航（Navigation）

- `00-inbox/`：临时收集，后续归档
- `06-data-modeling/`：数据建模（OLTP/OLAP、指标体系、维度建模）
- `09-security-governance/`：安全与治理（权限、审计、脱敏、合规、元数据）
- `10-engineering/`：工程化（测试、CI/CD、发布、工具化）
- `11-postmortems/`：事故复盘（Postmortem）
- `12-notes/`：读书/论文/文章笔记
- `13-snippets/`：可复用代码片段/SQL/配置
- `14-glossary/`：术语表（中英对照）

## 模板（Templates）

模板在 `_templates/`：

- `concept.md`：概念卡
- `pattern.md`：模式卡
- `system.md`：系统卡
- `adr.md`：架构决策记录（ADR）
- `postmortem.md`：事故复盘
