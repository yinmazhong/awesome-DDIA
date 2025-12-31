# Roadmap Index (R0)

This roadmap is a learning + delivery path for building data-intensive systems (DDIA) with a Data Engineering stack: Kafka + Flink + ClickHouse + Spark + Hive/Lakehouse.

## How to use

- Read one module, then produce artifacts (notes + runnable demos + checklists).
- Prefer writing:
  - Concept cards in `02-concepts/`
  - Patterns in `03-patterns/`
  - System runbooks in `04-systems/<system>/`
  - ADRs in `05-architecture/adr/`
  - Postmortems in `11-postmortems/`

## Modules

- R1: Foundations (DDIA) → `R1-foundations-ddia.md`
- R2: Kafka & event streaming → `R2-kafka-streaming.md`
- R3: Flink & stateful stream processing → `R3-flink-stream-processing.md`
- R4: Spark batch & lakehouse ingestion → `R4-spark-batch-lakehouse.md`
- R5: ClickHouse OLAP serving → `R5-clickhouse-olap-serving.md`
- R6: Platform engineering & governance → `R6-platform-governance.md`

## Definition of “done” (per module)

- Notes:
  - 3-8 concept cards
  - 1-3 patterns
- Demo:
  - A minimal runnable example (or a reproducible config)
- Ops:
  - A short runbook section: “signals → diagnosis → fix”
- Decision:
  - 1 ADR for a real trade-off you faced

## Portfolio projects (suggested)

- P1: Kafka → Flink real-time metric aggregation → ClickHouse serving
- P2: Spark batch backfill pipeline for the same metric table (reconciliation with streaming)
- P3: Data quality gates + alerting + replay/backfill playbook

## Personal focus areas (fill in)

- Primary domain: <ads / ecommerce / risk / observability / ...>
- Primary pain points: <late data / correctness / cost / ...>
- Current skill gaps: <...>
