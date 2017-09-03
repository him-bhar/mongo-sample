import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    MongoClient mongo = new MongoClient("192.168.1.5", 27017);
    MongoDatabase database = mongo.getDatabase("himanshu_temp");
    MongoCollection<Document> myCol = database.getCollection("mycol");

    System.out.println(myCol.count());
    Document document = new Document();
    Document document2 = new Document();
    document2.put("$gte", 100);
    document.put("likes", document2);
    FindIterable<Document> result =  myCol.find(document);
    int i = 1;

    // Getting the iterator
    Iterator<Document> it = result.iterator();

    while (it.hasNext()) {
      System.out.println(it.next().toJson());
      i++;
    }
  }
}
