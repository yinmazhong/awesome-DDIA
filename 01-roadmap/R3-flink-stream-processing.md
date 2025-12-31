# R3: Flink Stream Processing

## Goal

Master stateful streaming: event time, state, checkpointing, and correctness under failures.

## Key topics

- Operator state vs keyed state
- Checkpointing, exactly-once in Flink (and boundaries)
- Watermarks, late data, allowed lateness
- Backpressure, state size, and performance tuning

## Deliverables

- System notes
  - `04-systems/flink/overview.md`
- Concept cards
  - event-time vs processing-time
  - watermark strategy
  - state TTL and correctness trade-off
  - backpressure signals and mitigation
- Patterns
  - streaming aggregation (sliding/tumbling/session windows)
  - streaming join with dimension table (broadcast / async IO)

## Hands-on

- Implement:
  - late data handling strategy (drop vs update vs side output)
  - checkpoint + restart test (kill task manager and validate results)

## Exit checklist

- [ ] Can describe what “exactly-once” means end-to-end, not only inside Flink
- [ ] Can interpret backpressure metrics and locate bottlenecks
- [ ] Can reason about state growth and TTL impact
