# System: Kafka

## Overview

Kafka is the event streaming backbone for ingestion, decoupling producers/consumers, and enabling replay.

## Key concepts

- Topic / Partition: ordering boundary
- Consumer group: parallelism + HA
- Offset: progress pointer (commit strategy defines semantics)
- Retention vs compaction
- Producer idempotence & transactions (EOS boundary)

## Architecture

- Brokers, controller/quorum, log segments
- Producer → broker (acks) → consumer (poll)

## Delivery semantics (practical)

- At-least-once is the default reality; duplicates happen on retries/rebalances.
- Exactly-once is only meaningful with clear boundaries (transactions + idempotent sink or transactional sink).

## Partitioning strategy

- Choose key for:
  - ordering requirement
  - load distribution (avoid hot keys)
  - consumer scaling

## Operations

- Capacity planning
  - Throughput: peak produce/consume MB/s
  - Partitions: enough for parallelism, not too many for controller overhead
  - Retention: disk * safety margin
- Common configs (high impact)
  - `acks`, `retries`, `enable.idempotence`
  - `min.insync.replicas`, replication factor
  - `max.poll.interval.ms`, `session.timeout.ms`
  - `fetch.max.bytes`, `max.partition.fetch.bytes`

## Troubleshooting playbook

- Lag increasing
  - Check: consumer throughput, backpressure downstream, rebalance频率
  - Actions: scale consumers, reduce processing time, tune fetch/batch, isolate hot partitions
- Rebalance storms
  - Check: long processing without poll, GC pauses, `max.poll.interval.ms`
  - Actions: increase interval, optimize processing, cooperative rebalancing
- Duplicates
  - Root cause: retries / rebalance / non-idempotent sink
  - Fix: idempotency key, dedup store, transactional sink (when feasible)

## Observability (golden signals)

- Broker: under-replicated partitions, ISR shrink, request handler idle, disk usage
- Topic/Partition: bytes in/out, log end offset, retention
- Consumer: lag, rebalance count, commit latency, processing latency

## References

- Tags: #system #kafka #streaming
