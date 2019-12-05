package com.restapis.connections;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbConnection {
  
  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );  
  MongoDatabase db = mongoClient.getDatabase("javatpoint");  
  MongoCollection<Document> table = db.getCollection("employee");  

}
