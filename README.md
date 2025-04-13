# ScIceberg

A Scala-native library to interact with [Apache Iceberg](https://iceberg.apache.org/) tables—no Spark or Flink required.

> ⚠️ Early stage project — built for learning, exploration, and Scala ecosystem growth.

## 💡 Motivation

While Apache Iceberg has great support through Java and Python (via PyIceberg), a lightweight Scala-native toolkit is missing. `ScIceberg` aims to fill that gap by:

- Providing idiomatic Scala APIs to explore and work with Iceberg tables
- Supporting catalog loading, metadata inspection, and manifest parsing
- Enabling tools and CLIs for Iceberg-based data lakes

## 📦 Features (Planned)

- [ ] Load table metadata and schema from file-based catalog
- [ ] Parse manifest lists and data file metadata
- [ ] Implement snapshot history and rollback inspection
- [ ] Support partition transforms and pruning
- [ ] Add support for reading small datasets (e.g., Parquet)
- [ ] Optional: CLI for quick metadata exploration

## 🛠 Getting Started

```bash
git clone https://github.com/chanukyapekala/sciceberg.git
cd sciceberg
sbt compile
```

📚 Learning Goals
This project is also an educational journey into:

- Iceberg internals (manifests, metadata files, schemas)
- Scala data handling and effectful IO
- JVM-based data lake tooling

🪪 License
MIT

Inspiration
- Inspired by PyIceberg and the Apache Iceberg community.
