package com.lei.json

import org.json4s.JsonAST.{JField, JString}
import org.json4s.NoTypeHints
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

/**
  * Created by Lei on 2016/12/7.
  */
object BuindInParser {
  def main(args: Array[String]): Unit = {
    //    val s = """ {"@version":"1","@timestamp":"2016-12-04T18:31:35.000Z","ip":"47.9.239.143","remote_user":"\"-\"","method":"POST","url":"/v1/logs/","status":"200","request_time":"25","http_referer":"\"-\"","http_user_agent":"\"Dalvik/2.1.0 (Linux; U; Android 6.0; Micromax Q352 Build/MRA58K)\"","http_x_forwarded_for":"\"-\"","data":[{"aid":"5842be9d450b7b3b08a22619","refresh_id":"3888077f2802e375415a438f4290b072","category":"rec","list_pos":358,"article_type":"article","type":"load","ts_ms":1480876180646},{"aid":"58426047450b7b3b0c412447","refresh_id":"3888077f2802e375415a438f4290b072","category":"rec","list_pos":359,"article_type":"article","type":"load","ts_ms":1480876187118},{"aid":"5842971f450b7b3b0c4132ed","refresh_id":"3888077f2802e375415a438f4290b072","category":"rec","list_pos":360,"article_type":"article","type":"load","ts_ms":1480876187218},{"aid":"5842c714450b7b3b04cc35bd","refresh_id":"3888077f2802e375415a438f4290b072","category":"rec","list_pos":361,"article_type":"article","type":"load","ts_ms":1480876187432},{"aid":"58444b91450b7b3b0c4167e5","refresh_id":"3888077f2802e375415a438f4290b072","category":"rec","list_pos":362,"article_type":"article","type":"load","ts_ms":1480876188309},{"aid":"5842b943450b7b3b0c413b5e","refresh_id":"3888077f2802e375415a438f4290b072","category":"rec","list_pos":363,"article_type":"article","type":"load","ts_ms":1480876188461}],"size":"4.59","resolution":"1280*720","model":"Micromax+Q352","timezone":"GMT%2B05%3A30","os":"android","app_mode":"lite","os_v":"23","app_v":"2.0.8.1","channel":"GooglePlay","lng":"0.0","lat":"0.0","did":"6fe2f2a1f0d31497ab4947ac7fc559d8","imei":"911519400038219","imsi":"405806192348534","mac":"02:00:00:00:00:00","android_id":"916e4eb7527f367e","lv":"1","u_type":"device","net":"WIFI","lang":"hi","ts":"1480876188"}"""
    //    val map = JSON.parseFull("""{"ts":1480876180646}""")
    //    val b = map.get.asInstanceOf[Map[String, _]].get("ts_ms").get.asInstanceOf[Double]
    //    println(BigDecimal(b))
    implicit val serializerFormats = Serialization.formats(NoTypeHints)
    val isPartner = true
    val json = """{"preview":"0","img_url":"http://image.newsdog.today/origin_f39bbce32a19426ce7e71b7bcbf5e193","language":"en","news":[{"title":"Mexico fireworks market blast: 29 dead, 70 injured","top_images":[{"origin":"http://image.newsdog.today/origin_f39bbce32a19426ce7e71b7bcbf5e193","thumb_height":114,"thumb":"http://image.newsdog.today/thumb_f39bbce32a19426ce7e71b7bcbf5e193","thumb_width":200,"source":"http://www.thehansindia.com/assets/6591_mexico-market-blast.jpg","height":341,"width":600}],"related_images":[{"origin":"http://image.newsdog.today/origin_f39bbce32a19426ce7e71b7bcbf5e193","thumb_height":114,"thumb":"http://image.newsdog.today/thumb_f39bbce32a19426ce7e71b7bcbf5e193","thumb_width":200,"width":600,"height":341,"source":"http://www.thehansindia.com/assets/6591_mexico-market-blast.jpg"}],"source":"Hans India","seq_id":210130860,"source_url":"http://www.thehansindia.com/posts/index/International/2016-12-21/Mexico-fireworks-market-blast-29-dead-70-injured/269720","site_url":"www.thehansindia.com","id":"585a03e412907172872814d8","type":"article"}],"push_id":1482296757,"bigger":true,"title":"Mexico fireworks market blast: 29 dead, 70 injured","type":"article","pop_up":false}"""
    val jValue = List(parse(json))
    val part = parse(s"""{"isPartner":${isPartner}}""")
    println(write(jValue.head merge part))
    println(remove(json, "news"))

  }

  def remove(str: String, fieldToRemove: String) = {
    implicit val serializerFormats = Serialization.formats(NoTypeHints)
    val jValue = parse(str)
    val t = jValue removeField {
      case (k, v) => k == fieldToRemove
    }
    pretty(render(t))
  }
}
