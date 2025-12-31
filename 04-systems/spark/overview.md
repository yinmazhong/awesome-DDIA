# System: Spark

## Overview

Spark is the batch (and sometimes streaming) compute engine used for ETL, backfill, and large-scale data processing.

## Key concepts

- Driver / Executor
- DAG, stages, shuffle
- Partitioning and skew
- Cache/persist

## Architecture

- Driver plans execution
- Executors run tasks; shuffle moves intermediate data

## Data engineering practices

- Prefer idempotent outputs (overwrite partition / merge semantics)
- Backfill strategy: date-range, reprocess windows, reconciliation checks

## Operations

- Capacity planning
  - shuffle size, executor memory, cores
  - parallelism (partitions) and file sizes
- Common knobs (high impact)
  - shuffle partitions
  - broadcast join thresholds
  - dynamic allocation (if enabled)

## Troubleshooting playbook

- Slow jobs
  - Check: shuffle read/write, skewed partitions, GC
  - Actions: repartition, salting for skew, optimize joins, increase parallelism
- Small files problem
  - Root cause: too many output partitions
  - Fix: coalesce, compaction jobs, tune partitioning

## Observability (golden signals)

- Stage/task duration, shuffle read/write
- Executor utilization, GC time
- Data skew indicators (max/median task time)

## References

- Tags: #system #spark #batch
