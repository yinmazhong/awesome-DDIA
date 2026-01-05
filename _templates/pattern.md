# Pattern: <name>

<!-- 模式名：一个可复用的工程套路/架构模式，例如 "Outbox" / "Saga" / "CQRS" / "Idempotent Consumer" -->

## When to use

<!-- 适用场景：用 2-5 条说明在什么业务/技术约束下使用它（触发条件、规模、SLO、一致性要求等） -->
- <scenario>

## When NOT to use

<!-- 不适用：典型反例/反模式，说明为什么不合适（复杂度、成本、不满足一致性/延迟等） -->
- <anti-scenario>

## Solution sketch

<!-- 方案草图：建议用“组件 + 数据流”两部分把最小闭环画出来（可加一张简单图的链接） -->
- <components>
- <data flow>

## Implementation notes

<!-- 实现细节：这里强调数据密集型系统常踩坑：幂等、重试、失败补偿、Schema 演进、时钟/时间语义 -->
- Idempotency key / dedup key: <...>
- Retry/backoff: <...>
- Failure handling (DLQ/compensation): <...>

## Failure modes & observability

<!-- 失败模式与可观测：列出最可能出问题的点，以及能用哪些信号第一时间发现 -->
- Metrics: <...>
- Logs: <...>
- Alerts: <...>

## Alternatives

<!-- 替代方案：说明与其他模式的取舍维度（延迟/一致性/实现复杂度/运维成本/可迁移性） -->
- <alternative> vs <alternative>

## Related

<!-- 关联：链接到对应 ADR、概念、系统笔记、事故复盘；标签可追加领域如 #streaming #storage -->
- Tags: #pattern
