# R2: Kafka & Event Streaming

## Goal

Design reliable event ingestion and consumption with correct delivery semantics and operability.

## Key topics

- Partitioning, ordering, and hot partitions
- Consumer groups, rebalances, commit strategies
- Producer idempotence, transactions (when they help / when they don’t)
- Backpressure and lag management

## Deliverables

- System notes
  - `04-systems/kafka/overview.md`
- Concept cards
  - offset/commit model
  - delivery semantics in practice
  - compaction vs retention
  - schema evolution (Avro/Protobuf/JSON + compatibility)
- Patterns
  - Outbox pattern
  - Deduplication (key design + state store)
  - Poison pill handling + DLQ

## Hands-on

- Build a minimal producer + consumer that supports:
  - manual commit
  - retry with backoff
  - DLQ
  - idempotency key
- Record “lag playbook” (what metrics, thresholds, actions).

## Exit checklist

- [ ] Can explain why rebalances cause duplicates
- [ ] Can implement safe offset commit with idempotent writes
- [ ] Can propose partition key strategies and spot hot key risks
