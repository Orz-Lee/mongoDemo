import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDemo1 {

    public static void main(String[] args) {

        MongoCollection<Document> spit = MongoUtil.getCollection("spit");
        // 构建查询条件
        BasicDBObject bson = new BasicDBObject("userid", "1013");
        //查询记录获取结果集合
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
