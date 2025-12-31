# R6: Platform Engineering & Governance

## Goal

Make the data system operable at scale: quality, lineage, contracts, access control, and SLO.

## Key topics

- Data contracts: schema + semantics + SLO
- Ownership model: datasets as products
- Observability: data freshness, completeness, correctness
- Governance: access control, auditing, PII handling

## Deliverables

- One data contract template (for a key dataset)
- A quality gate checklist (pre-merge + pre-release)
- A monitoring dashboard spec (what metrics, what alerts, who oncall)

## Hands-on

- Pick one critical pipeline and define:
  - input contract
  - output contract
  - quality metrics and alert thresholds
  - replay/backfill procedure

## Exit checklist

- [ ] Can describe dataset ownership and change management process
- [ ] Can prevent breaking schema changes with compatibility checks
- [ ] Can run a controlled backfill with audit trail
