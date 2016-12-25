namespace scala com.xiaotunza.thrift

service EchoService {
   string echo(1: string msg);
   i64 getCnt();
}
