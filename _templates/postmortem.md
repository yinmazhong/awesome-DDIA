# Postmortem: <incident title>

<!-- 事故标题：一句话描述“什么系统 + 什么症状 + 影响”，例如 "Flink job checkpoint 失败导致指标延迟 2h" -->

- Date: <YYYY-MM-DD>
<!-- 日期：事故发生日期（或开始日期）；如跨天可在 Impact 里补充时间范围 -->
- Severity: SEV1/2/3
<!-- 级别：建议在团队内有统一定义（影响范围/金额/持续时间/SLO 破坏程度） -->
- Owner: <...>
<!-- 负责人：复盘 owner（推动行动项关闭的人），不一定是当班处理人 -->

## Impact

<!-- 影响：尽量量化（用户数、请求量、金额、数据延迟/丢失条数、SLO 破坏分钟数） -->
- User/business impact: <...>
- Data impact (loss/duplication/delay): <...>
- Duration: <...>

## Timeline

<!-- 时间线：按时间顺序记录关键事件（检测到->定位->缓解->修复->恢复），用于找出流程与协作问题 -->
- <time> <event>

## Root cause

<!-- 根因：区分技术根因与流程根因；建议写“触发条件 + 缺陷 + 为什么没提前发现/阻止” -->
- Technical: <...>
- Process: <...>

## Detection

<!-- 发现：如何发现（告警/用户反馈/看板）；缺失的信号用于补监控与告警阈值 -->
- How detected: <...>
- What signals were missing: <...>

## Resolution

<!-- 处置：
  - 立即止血（降级、回滚、限流、切流）
  - 长期修复（代码/配置/容量/流程）
  - 数据修复要写清：范围、幂等、回放校验与对账方式
-->
- Immediate fix: <...>
- Data repair (replay/backfill/dedup): <...>

## Prevent recurrence

<!-- 防再发：把行动项归类到监控、护栏、Runbook、演练；要求每条可验收且有 owner/due -->
- Monitoring/alerting: <...>
- Guardrails (idempotency, schema contract, rate limit): <...>
- Runbooks: <...>

## Action items

<!-- 行动项：必须可执行、可验收；建议包含优先级与验收标准；复盘后要跟踪关闭率 -->
- [ ] <item> (owner, due)
