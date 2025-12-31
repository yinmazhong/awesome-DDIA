# System: ClickHouse

## Overview

ClickHouse is a columnar OLAP database optimized for fast analytical queries and high ingestion.

## Key concepts

- MergeTree family engines
- Primary key vs sorting key (order by)
- Partition key (for pruning + TTL management)
- Parts, merges, TTL
- Materialized views (for pre-aggregation)

## Architecture

- Shards + replicas (when clustered)
- Ingestion: batch inserts, async inserts, Kafka engine (optional)

## Data modeling

- Choose grain (event / minute / hour)
- Avoid unbounded high-cardinality dimensions in primary sorting unless necessary
- Plan for late data: update strategy and dedup

## Operations

- Capacity planning
  - Data volume per day, retention, compression
  - Merge overhead and write amplification
- Common knobs (high impact)
  - insert batch sizing
  - merge settings and background pool
  - TTL policies

## Troubleshooting playbook

- Queries slow
  - Check: primary index usage, reading too many parts, bad sorting key
  - Actions: change ORDER BY, add projections/materialized views, pre-aggregate
- Inserts slow / too many parts
  - Check: small batch inserts, merge backlog
  - Actions: batch inserts, async insert, tune merges, compaction strategy
- Duplicate rows
  - Root cause: at-least-once ingestion
  - Fix: ReplacingMergeTree with version, or app-level idempotency

## Observability (golden signals)

- Merge backlog, parts count, mutation queue
- Query latency (p95/p99), read bytes, CPU
- Disk usage, replication lag (if replicated)

## References

- Tags: #system #clickhouse #olap
