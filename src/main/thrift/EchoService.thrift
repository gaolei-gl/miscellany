namespace scala com.xiaotunza.thrift

service EchoService {
   string echo(string msg);
   i64 getCnt();
}