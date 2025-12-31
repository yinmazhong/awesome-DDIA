# R1: Foundations (DDIA)

## Goal

Build a correct mental model for replication, partitioning, transactions, consistency, and failure handling in distributed data systems.

## Key questions

- What consistency model is actually needed for a given use case?
- What is the failure model (crash, retry, duplication, reordering) and how do we design for it?
- How do we reason about time (event time vs processing time) and ordering?

## Deliverables

- Concept cards (suggested)
  - `consistency models` (linearizability, serializability, snapshot isolation)
  - `replication` (leader/follower, quorum)
  - `partitioning` (hash/range, hot keys)
  - `exactly-once` as a system property vs application property
  - `idempotency` and deduplication
- Patterns (suggested)
  - Idempotent consumer
  - Retry with backoff + DLQ
- One ADR
  - “At-least-once + idempotency” vs “EOS transaction” trade-off in your org

## Hands-on

- Create a small demo that intentionally introduces duplicates and out-of-order events.
- Write the application-level invariants that must hold after replay/backfill.

## Exit checklist

- [ ] Can explain trade-offs between at-most-once / at-least-once / effectively-once
- [ ] Can articulate what needs to be stable across retries (ids, keys, offsets)
- [ ] Can list the top 5 failure modes for your pipelines
