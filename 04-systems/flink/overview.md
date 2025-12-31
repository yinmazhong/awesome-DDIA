# System: Flink

## Overview

Flink is the stateful stream processing engine for low-latency computations with checkpoint-based fault tolerance.

## Key concepts

- Job / Task / Operator
- Keyed state vs operator state
- Event time vs processing time
- Watermark: progress of event time
- Checkpoint & savepoint
- Backpressure

## Architecture

- JobManager (coordination) + TaskManagers (execution)
- Source → operators → sink

## Correctness model

- Flink can provide exactly-once *state consistency* via checkpoints.
- End-to-end exactly-once also depends on:
  - source offset management (e.g., Kafka)
  - sink behavior (transactional sink / idempotent sink)

## Operations

- Capacity planning
  - State size and growth (RocksDB vs heap)
  - Checkpoint duration and interval
  - Parallelism and slot planning
- Common configs (high impact)
  - checkpoint interval/timeout, max concurrent checkpoints
  - state backend & incremental checkpoints
  - restart strategy

## Troubleshooting playbook

- Backpressure
  - Check: busy time per operator, network buffers, sink latency
  - Actions: scale parallelism, optimize serialization, tune sink batching
- Checkpoint failures
  - Check: checkpoint duration, timeouts, state backend I/O
  - Actions: increase timeout, reduce state, enable incremental, fix slow sinks
- Late data
  - Decide: drop / update / side output
  - Track: late event ratio

## Observability (golden signals)

- Job: end-to-end latency, throughput, restart count
- Checkpoint: duration, size, failure count
- Backpressure: operator backpressured time
- State: size, RocksDB compaction, managed memory

## References

- Tags: #system #flink #streaming
