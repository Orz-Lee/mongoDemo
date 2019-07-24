import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MongoDemo3 {

    public static void main(String[] args) {

        MongoCollection<Document> spit = MongoUtil.getCollection("spit");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("content","我要吐槽");
        map.put("userid","9999");
        map.put("visits",123);
        map.put("publishtime",new Date());
        Document document = new Document(map);
        spit.insertOne(document);
        MongoUtil.close();
    }

}
