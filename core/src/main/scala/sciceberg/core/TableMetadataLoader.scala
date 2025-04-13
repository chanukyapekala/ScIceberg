package sciceberg.core

import io.circe._
import io.circe.generic.semiauto._
import io.circe.parser._

import scala.io.Source
import java.io.File

object TableMetadataLoader {

  // Circe decoders
  implicit val fieldDecoder: Decoder[Field] = deriveDecoder
  implicit val schemaDecoder: Decoder[Schema] = deriveDecoder
  implicit val partitionFieldDecoder: Decoder[PartitionField] = deriveDecoder
  implicit val partitionSpecDecoder: Decoder[PartitionSpec] = deriveDecoder
  implicit val snapshotDecoder: Decoder[Snapshot] = deriveDecoder
  implicit val tableMetadataDecoder: Decoder[TableMetadata] = deriveDecoder

  def fromJsonFile(file: File): Either[Error, TableMetadata] = {
    val content = Source.fromFile(file).getLines().mkString
    decode[TableMetadata](content)
  }
}
