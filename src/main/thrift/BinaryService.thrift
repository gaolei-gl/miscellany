namespace scala com.xiaotunza.thrift

service BinaryService {
  binary fetchBlob(1: i64 id)
}