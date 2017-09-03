import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.himanshu.sample.mongodb.domain.Message;
import com.himanshu.sample.mongodb.factory.MongoConnectionFactory;
import com.mongodb.CursorType;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    /*MongoClient mongo = new MongoClient("192.168.1.5", 27017);
    MongoDatabase database = mongo.getDatabase("himanshu_temp");
    MongoCollection<Document> myCol = database.getCollection("mycol");

    System.out.println(myCol.count());
    Document findQuery = new Document();
    Document innerFindQuery = new Document();
    innerFindQuery.put("$gte", 100);
    findQuery.put("likes", innerFindQuery);

    Document selectQuery = new Document();
    selectQuery.put("title", 1);

    FindIterable<Document> result =  myCol.find(findQuery).projection(selectQuery);
    int i = 1;

    // Getting the iterator
    Iterator<Document> it = result.iterator();

    while (it.hasNext()) {
      System.out.println(it.next().toJson());
      i++;
    }*/
    MongoConnectionFactory connectionFactory = new MongoConnectionFactory("192.168.1.7", 27017, "himanshu_temp");
    MongoDatabase mongoDatabase = connectionFactory.getMongoDatabase();
    MongoCollection collection = mongoDatabase.getCollection("messages");
    Document doc = new Document();
    doc.put("from", "Himanshu");

    FindIterable<Document> result = collection.find(doc).cursorType(CursorType.TailableAwait);
    // Getting the iterator
    Iterator<Document> it = result.iterator();

    Gson gson = new GsonBuilder().create();

    while (it.hasNext()) {
      System.out.println(gson.fromJson(it.next().toJson(), Message.class));
    }
  }
}
