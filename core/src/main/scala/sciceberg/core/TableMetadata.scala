package sciceberg.core

import java.time.Instant

final case class TableMetadata(
                                formatVersion: Int,
                                tableUuid: String,
                                location: String,
                                lastUpdatedMillis: Long,
                                lastColumnId: Int,
                                schema: Schema,
                                partitionSpec: PartitionSpec,
                                currentSnapshotId: Option[Long],
                                snapshots: List[Snapshot],
                                manifestListLocation: Option[String]
                              ) {
  def lastUpdated: Instant = Instant.ofEpochMilli(lastUpdatedMillis)
}

final case class Schema(
                         schemaId: Int,
                         fields: List[Field]
                       )

final case class Field(
                        id: Int,
                        name: String,
                        fieldType: String, // You could replace this with an ADT later
                        required: Boolean
                      )

final case class PartitionSpec(
                                specId: Int,
                                fields: List[PartitionField]
                              )

final case class PartitionField(
                                 sourceId: Int,
                                 fieldId: Int,
                                 name: String,
                                 transform: String // e.g., "identity", "bucket[16]", etc.
                               )

final case class Snapshot(
                           snapshotId: Long,
                           parentSnapshotId: Option[Long],
                           sequenceNumber: Long,
                           timestampMillis: Long,
                           operation: String,
                           manifestList: String
                         )

