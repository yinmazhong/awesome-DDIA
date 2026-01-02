# awesome-DDIA（中文）

一个面向 **数据密集型应用 / 数据开发（Data Engineering）** 的个人知识库，主线参考 DDIA，并结合常用工程栈：Kafka + Flink + ClickHouse + Spark + Hive/Lakehouse。
目标：当面对问题或者需求时，可以下意识的知道由哪一部分知识做支撑，然后脑海中浮现出骨骼框架，具体的肌肉细节可以查阅本知识库及扩展文档。
当然这里不开思考方法，推荐笛卡尔思考法
> 笛卡尔思考法：
> 📜 核心方法论原则
> 下表清晰地概述了该方法的四条核心原则：

> 原则	核心内容	实际应用启示
> 第一原则：普遍怀疑，追求确定	不接受任何未经明确证实为真的东西，只接受清晰明白、无可怀疑的观念-4-6-7。	对信息保持审慎，避免先入为主和轻率判断。
> 第二原则：分析分解	将复杂难题尽可能分解为多个更小的、易于解决的部分-4-6-7。	化整为零，将大问题拆解为可操作的具体任务。
> 第三原则：综合有序	从最简单、最容易认识的对象开始，循序渐进，逐步认识更复杂的对象-4-6-7。	工作遵循由易到难的顺序，设定处理次序。
> 第四原则：全面审查	进行全面考察和普遍复查，确保毫无遗漏-4-6-7。	对工作和解决方案进行全面复查与总结。
> 💡 重要补充：三条行为准则
> 除了方法论，笛卡尔还提出了三条指导生活的行为准则，以保障理性思考得以顺利进行：
> 遵守社会规范：服从法律习俗，笃守宗教信仰，在生活中信持中道-4-7。
> 决策果断坚定：在行动上尽可能坚决，一旦采纳某种意见，就坚定不移地遵循-4-7。
> 专注于自我：只求克服自己，不求战胜命运；只求改变自己的愿望，而非世界的秩序-4-7。
> 综上所述，笛卡尔思考工作法是一个从质疑开始，通过分解、有序重构和全面审查来解决问题的完整流程。其核心追求是思维的清晰与确定。

- English: [README.md](README.md)

## 从这里开始（Start Here）

- [`01-roadmap/`](01-roadmap/)：学习路径与里程碑
  - 入口：[`01-roadmap/R0-index.md`](01-roadmap/R0-index.md)
- [`02-concepts/`](02-concepts/)：概念卡（定义 / why / pitfalls）
- [`03-patterns/`](03-patterns/)：工程模式（幂等 / Outbox / 回放…）
- [`04-systems/`](04-systems/)：系统与组件（Kafka / Flink / ClickHouse / Spark / Hive & Lakehouse）
  - Kafka：[`04-systems/kafka/overview.md`](04-systems/kafka/overview.md)
  - Flink：[`04-systems/flink/overview.md`](04-systems/flink/overview.md)
  - ClickHouse：[`04-systems/clickhouse/overview.md`](04-systems/clickhouse/overview.md)
  - Spark：[`04-systems/spark/overview.md`](04-systems/spark/overview.md)
  - Hive/Lakehouse：[`04-systems/hive-lakehouse/overview.md`](04-systems/hive-lakehouse/overview.md)
- [`05-architecture/`](05-architecture/)：架构方法与 ADR（决策记录）、容量规划、SLO、演进
- [`07-reliability/`](07-reliability/)：正确性与可靠性（回放/补数/对账/数据质量）
- [`08-observability/`](08-observability/)：可观测性（metrics/logs/tracing/lineage）

## 导航（Navigation）

- [`00-inbox/`](00-inbox/)：临时收集，后续归档
- [`06-data-modeling/`](06-data-modeling/)：数据建模（OLTP/OLAP、指标体系、维度建模）
- [`09-security-governance/`](09-security-governance/)：安全与治理（权限、审计、脱敏、合规、元数据）
- [`10-engineering/`](10-engineering/)：工程化（测试、CI/CD、发布、工具化）
- [`11-postmortems/`](11-postmortems/)：事故复盘（Postmortem）
- [`12-notes/`](12-notes/)：读书/论文/文章笔记
- [`13-snippets/`](13-snippets/)：可复用代码片段/SQL/配置
- [`14-glossary/`](14-glossary/)：术语表（中英对照）

## 模板（Templates）

模板在 [`_templates/`](_templates/)：

- `concept.md`：概念卡
- `pattern.md`：模式卡
- `system.md`：系统卡
- `adr.md`：架构决策记录（ADR）
- `postmortem.md`：事故复盘

-- 

这个 awesome-DDIA 知识库的“架构目标”
你的主线是数据密集型应用/数据开发，知识库建议同时服务 3 类场景：

快速查阅：遇到一致性、分区、幂等、回放、延迟飙升、数据质量等问题时，5 分钟能定位解法。
体系化成长：从 DDIA 出发，把分布式系统 + 数据工程 + 平台工程串成“主线课程”。
可复用资产：把你做过的方案（设计决策、踩坑、复盘、代码片段、指标面板）沉淀为模板。
组织原则建议用一句话概括：
“主线驱动 + 主题索引 + 案例复盘 + 可执行清单”。

顶层目录框架（推荐）
下面这个结构适合 Git + Markdown（也非常适合 Obsidian）。你可以直接照着建目录：

awesome-DDIA/
  README.md                    # 总导航：主线 + 索引入口
  00-inbox/                    # 临时收集、待归类（定期清空）
  01-roadmap/                  # 主线学习路径（你要走的“课程大纲”）
  02-concepts/                 # 概念卡：一句话定义 + 要点 + 适用/误区
  03-patterns/                 # 设计模式/套路：幂等、Outbox、CQRS、SAGA...
  04-systems/                  # 组件与系统：Kafka/Flume/Flink/Spark/OLAP...
  05-architecture/             # 架构方法：分层、演进、容量规划、SLO/成本
  06-data-modeling/            # 数据建模：OLTP/OLAP、维度建模、湖仓建模
  07-reliability/              # 可靠性：一致性、容灾、回放、补数、质量
  08-observability/            # 可观测性：指标/日志/链路/数据血缘/数据质量指标
  09-security-governance/      # 安全与治理：权限、审计、脱敏、合规、元数据
  10-engineering/              # 工程化：测试、CI/CD、数据回归、灰度、工具脚本
  11-postmortems/              # 事故复盘：现象-根因-修复-预防-指标
  12-notes/                    # 读书/文章/会议笔记（DDIA/论文/博客）
  13-snippets/                 # 可复用代码片段/SQL/配置
  14-glossary/                 # 术语表（中英对照、你自己的定义）
  _templates/                  # 笔记模板（复制即用）
  _assets/                     # 图片、架构图、导出的面板截图等
你会发现它有两条“访问路径”：

按主线走：01-roadmap/ 把你要学要做的东西串起来
按主题查：concepts/patterns/systems/reliability/observability…
01-roadmap/ 主线（数据密集型数据开发路线图）
建议把主线拆成 6 个阶段，每阶段都能对应“可落地的产出”。

R1. 数据密集型基础（DDIA骨架）
核心问题：复制、分区、事务、一致性、容错、负载
产出：每章 1 张“决策表”（何时用什么方案）
R2. 事件流与消息（Kafka / Pulsar）
核心问题：至少一次/恰好一次语义、重放、顺序、积压、幂等
产出：一套“消费端可靠性清单”（offset、DLQ、重试、去重）
R3. 流处理（Flink为主）
核心问题：状态/一致性、checkpoint、watermark、迟到数据、回压
产出：3 个范式：实时明细、实时聚合、实时维表关联
R4. 批处理与湖仓（Spark + Lakehouse）
核心问题：分区/小文件、数据布局、增量、回填、成本
产出：一套“离线任务稳定性 & 成本优化”套路
R5. OLAP 与 Serving（ClickHouse/Druid/Trino/ES）
核心问题：建模、预聚合、物化视图、冷热分层、查询治理
产出：一个指标体系的端到端方案（采集->计算->服务->看板）
R6. 平台化与治理（数据平台工程）
核心问题：元数据、血缘、质量、权限、SLO、Data Contract
产出：数据产品的“契约化交付流程”（schema 变更、回归、发布）
笔记模板（建议放到 _templates/）
只给你最常用的 5 类，足够覆盖 80% 沉淀。

1) 概念卡（Concept）
文件名：02-concepts/<领域>/<概念>.md
结构：
定义（1-2 句）
为什么重要（解决什么问题）
关键要点（3-7条）
常见误区（2-5条）
相关模式/系统链接
2) 模式卡（Pattern）
文件名：03-patterns/<模式>.md
结构：
适用场景/不适用场景
方案结构图（可选）
实现要点（含幂等键/重试/补偿）
失败模式（Failure Modes）与监控指标
替代方案对比
3) 系统卡（System / Component）
文件名：04-systems/<系统名>/overview.md
结构：
核心概念（topic/partition/segment…）
关键配置（以及“错误配置的后果”）
运维与排障（常见告警->定位路径）
容量规划（吞吐、存储、保留策略）
4) 设计决策（ADR：Architecture Decision Record）
文件名：05-architecture/adr/ADR-YYYYMMDD-xxx.md
结构：
背景
决策
备选方案对比
风险与缓解
验收指标（SLO/成本/复杂度）
5) 事故复盘（Postmortem）
文件名：11-postmortems/YYYY/<事件>.md
结构：
影响范围（业务/数据/时长）
时间线
根因（技术 + 流程）
修复（短期/长期）
预防（监控、限流、回放、演练）
复发检查清单
标签与元数据（轻量但长期有效）
建议每篇开头加一小段元数据（不需要复杂系统）：

领域：#streaming #storage #olap #governance
性质：#concept #pattern #adr #postmortem
关键属性：#consistency #idempotency #backpressure #schema_evolution
这样你在 Obsidian/Git grep 都能快速检索。

