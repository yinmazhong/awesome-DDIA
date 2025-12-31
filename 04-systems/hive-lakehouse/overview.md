# System: Hive / Lakehouse

## Overview

Hive (and lakehouse storage formats) provide the storage layer for batch analytics, backfills, and shared datasets.

## Key concepts

- Table formats: Parquet/ORC; lakehouse formats (e.g., Iceberg/Hudi/Delta)
- Metastore & schema
- Partitioning and file layout
- Compaction (small files)
- Schema evolution & compatibility

## Architecture

- Storage (HDFS/S3/OSS) + Metastore + Compute (Spark/Trino)

## Data layout strategy

- Partition by time first (day/hour), then consider secondary clustering/bucketing
- Keep file sizes in a healthy range (avoid too many small files)

## Operations

- Capacity planning
  - retention policy, storage tiering
  - compaction frequency
- Change management
  - schema evolution policy
  - data contract for critical tables

## Troubleshooting playbook

- Query slow
  - Check: partition pruning, file count, statistics
  - Actions: optimize partitions, compaction, compute engine tuning
- Backfill correctness issues
  - Root cause: partial overwrite, non-idempotent writes
  - Fix: overwrite partition atomically (or use table format with ACID/merge)

## Observability (golden signals)

- Freshness (data delay), completeness (row counts), correctness (reconciliation)
- File count per partition, average file size

## References

- Tags: #system #hive #lakehouse
