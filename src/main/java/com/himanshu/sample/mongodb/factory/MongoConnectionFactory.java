package com.himanshu.sample.mongodb.factory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnectionFactory {
  private final MongoClient client;
  private final String databaseName;
  private final MongoDatabase mongoDatabase;

  public MongoConnectionFactory(String hostname, int port, String databaseName) {
    this.databaseName = databaseName;
    client = new MongoClient(hostname, port);
    mongoDatabase = client.getDatabase(databaseName);
  }

  public MongoDatabase getMongoDatabase() {
    return mongoDatabase;
  }
}
