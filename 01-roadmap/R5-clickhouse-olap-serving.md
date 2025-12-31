# R5: ClickHouse OLAP Serving

## Goal

Serve metrics and analytics with predictable latency and maintainability.

## Key topics

- Table engines (MergeTree family), primary key vs sorting key
- Partitioning, TTL, merges, and ingestion patterns
- Aggregations, materialized views, and pre-aggregation design
- Query optimization and concurrency

## Deliverables

- System notes
  - `04-systems/clickhouse/overview.md`
- Concept cards
  - data model for metrics (facts, dimensions, granularity)
  - late arriving data handling in OLAP
- Patterns
  - streaming ingest → staging → final tables
  - dedup in ClickHouse (ReplacingMergeTree vs app-level dedup)

## Hands-on

- Implement a minimal metric store:
  - raw events table
  - aggregated table (minute/hour)
  - one dashboard query workload

## Exit checklist

- [ ] Can pick partition + sorting key and justify it
- [ ] Can explain merge behavior impact on freshness and cost
- [ ] Can build a safe ingestion plan with retries
