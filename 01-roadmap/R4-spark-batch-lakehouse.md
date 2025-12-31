# R4: Spark Batch & Lakehouse (Hive)

## Goal

Build a robust batch pipeline and lakehouse storage layer for backfill, reconciliation, and cost-efficient processing.

## Key topics

- Data layout: partitions, bucketing, file size, compaction
- Incremental processing and backfill strategy
- Schema evolution and compatibility
- Cost and performance: shuffle, skew, small files

## Deliverables

- System notes
  - `04-systems/spark/overview.md`
  - `04-systems/hive-lakehouse/overview.md`
- Concept cards
  - small files problem
  - partition design (time + high-cardinality keys)
  - data freshness vs cost
- Patterns
  - backfill playbook
  - reconciliation between streaming and batch

## Hands-on

- Build a backfill job that can:
  - reprocess a day/hour range
  - be idempotent (overwrite partition safely or merge)
  - emit quality metrics

## Exit checklist

- [ ] Can design partitioning for both read & write paths
- [ ] Can explain why skew happens and mitigation options
- [ ] Can run a “recompute + compare” reconciliation
