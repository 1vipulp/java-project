package com.restapis.connections;

import org.bson.Document;
import com.restapis.beans.Student;
import com.restapis.connections.DbConnection;

public class DbOperations {
  DbConnection dbConnection = new DbConnection();
  
  public Boolean insertDocument(Student document) {
    Document doc = new Document();
    doc.put("name", document.getUsername());
    doc.put("address", document.getAddress());
    doc.put("age", document.getAge());
    dbConnection.table.insertOne(doc);
    return true;
  }
}
