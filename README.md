# Assignment 2: Algorithmic Analysis and Peer Code Review

This project implements and analyzes the **Boyer–Moore Majority Vote Algorithm** with performance tracking, benchmarking, and peer review.

---

## Repository Structure
```
├── pom.xml
├── docs
│   ├── analysis-report.md
│   └── performance-plots/
│       └── majority_benchmark.csv
└── src
    ├── main/java/org/tastemir/
    │   ├── algorithms/BoyerMooreMajority.java
    │   ├── metrics/PerformanceTracker.java
    │   └── cli/BenchmarkRunner.java
    └── test/java/org/tastemir/algorithms/
        └── BoyerMooreMajorityTest.java
```

---

## Branches
| Branch | Purpose |
|--------|----------|
| `feature/algorithm` | Main algorithm |
| `feature/metrics` | Performance tracking |
| `feature/testing` | Unit tests |
| `feature/cli` | CLI benchmark |
| `feature/optimization` | Optimized version |
| `main` | Final merged release |

---

## Build & Run
```bash
mvn clean package
java -jar target/assignment2-1.0.0.jar
```

---

## Output Example
```
n,hasMajority,timeNs,comparisons,arrayAccesses,assignments
100,false,63792,200,200,125
1000,false,564750,2000,2000,1241
```

---

## Report
All analysis and results:  
`docs/analysis-report.md`

**Author:** Akerke Tastemir  
**Version:** v1.0