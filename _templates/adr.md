# ADR: <title>
<!-- 标题：用一句话概括架构/设计决策，例如 "Use Kafka for event ingestion" / "采用 Redis 做频控" -->

- Date: <YYYY-MM-DD>
<!-- 日期：决策首次成文/进入评审的日期；如后续重大变更可新开 ADR 并互相链接 -->
- Status: Proposed | Accepted | Deprecated
<!-- 状态：Proposed=提议中/待评审；Accepted=已决策并执行；Deprecated=废弃（说明替代方案与迁移计划） -->

## Context
<!-- 写清楚：
  - 背景/问题：为什么要做这个决策，当前痛点是什么（最好有数据/现象）
  - 约束：技术/成本/时限/合规/团队能力等
  - 非目标：明确不解决什么，防止范围膨胀
  - 相关链接：PRD、RFC、指标看板、事故复盘、竞品调研等
-->

<background, constraints, non-goals>

## Decision
<!-- 我们决定做什么：
  - 选择的方案（要点化写）
  - 关键参数/默认值/边界条件
  - 影响范围：哪些系统/数据/团队需要配合
  - 决策理由：对应 Context 的约束逐条解释
-->

<what we decided>

## Options considered
<!-- 列出备选方案（含“不做/维持现状”）；每个方案最好包含：实现思路、依赖、成本、风险、落地周期 -->

1. <option A>
2. <option B>

## Pros/Cons
<!-- 对比维度建议：正确性/一致性、可用性、延迟、扩展性、复杂度、运维成本、可观测性、安全合规、可迁移性 -->

- Option A
  - Pros: <...>
  - Cons: <...>
- Option B
  - Pros: <...>
  - Cons: <...>

## Consequences
<!-- 结论影响与后续动作：
  - 需要做哪些代码/数据/流程改造
  - 对现有用户/系统的破坏性变更（如有）
  - Owner 与里程碑（可选但强烈建议）
-->

- Risks: <...>
<!-- 风险：技术风险/业务风险/迁移风险/性能风险/一致性风险等，尽量可量化 -->
- Mitigations: <...>
<!-- 缓解：监控、降级、限流、灰度、双写、回放校验、数据修复预案等 -->
- Rollout/rollback: <...>
<!-- 发布/回滚：灰度策略、开关、回滚条件（SLO/错误率/成本）、回滚步骤与数据回滚方案 -->

## Validation
<!-- 如何证明这个决策是对的：
  - 正确性：对账、回放、采样核对、E2E 测试
  - 稳定性：SLO 达标、错误预算
  - 性能/成本：压测结果、资源成本预估与实际对比
-->

- SLO / correctness checks: <...>
- Load test / cost check: <...>
