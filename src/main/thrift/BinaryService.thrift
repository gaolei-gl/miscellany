namespace scala com.xiaotunza.service.thrift

service BinaryService {
  binary fetchBlob(1: i64 id)
}