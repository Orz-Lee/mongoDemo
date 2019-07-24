import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class MongoDemo2 {

    public static void main(String[] args) {

        MongoCollection<Document> spit = MongoUtil.getCollection("spit");
        //构建查询条件
        //BasicDBObject bson = new BasicDBObject("visits", new BasicDBObject("$gte",1023));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("visits", new BasicDBObject("$gte",1023));
        map.put("nickname", "小红红");
        BasicDBObject bson = new BasicDBObject(map);
        FindIterable<Document> documents = spit.find(bson);
        for (Document document : documents) {
            System.out.print("内容：" + document.getString("content"));
            System.out.print("---用户ID:" + document.getString("userid"));
            System.out.print("---用户姓名:" + document.getString("nickname"));
            System.out.println("---浏览量：" + document.getInteger("visits"));
        }
        MongoUtil.close();

    }

}
