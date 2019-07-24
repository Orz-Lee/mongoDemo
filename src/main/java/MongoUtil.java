import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoUtil {

    public static MongoClient mongoClient = null;
    public static MongoDatabase spitdb = null;
    public static MongoCollection<Document> spit = null;

    public static MongoClient getMongoClient(){
        if (mongoClient != null){
            return mongoClient;
        }else{
            //创建连接
            return new MongoClient("192.168.170.128");
        }
    }

    public static MongoDatabase getSpitdb(){
        if (spitdb != null){
            return spitdb;
        }else{
            //打开数据库
            return getMongoClient().getDatabase("spitdb");
        }
    }

    public static MongoCollection<Document> getCollection(String db){
        if (spit != null){
            return spit;
        }else{
            //获取集合
            return getSpitdb().getCollection(db);
        }
    }

    public static void close(){
        if (mongoClient != null){
            mongoClient.close();
        }
    }

}
