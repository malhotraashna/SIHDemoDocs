package SIH;

import java.util.ArrayList;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*; // weired 
import static com.mongodb.client.model.Sorts.*;

public class RestDemoBean {
	  MongoClientURI uri  = new MongoClientURI("mongodb://sjsidjain:sjsidjain@ds145359.mlab.com:45359/testhack"); 
      MongoClient client = new MongoClient(uri);
      MongoDatabase db = client.getDatabase(uri.getDatabase());
      MongoCollection <Document> tc = db.getCollection("testcol");
    FindIterable <Document> docParser = tc.find();
      String name;
      String username;
      String ID;
      Document doc;
    String bio;
      public ArrayList connection()
	{
		    ArrayList al = new ArrayList();
	        al.add(db);
	        al.add(tc);
	return al;
	}
    
      public Document getDocument(String id)
    {
    	FindIterable<Document> doc = tc.find(eq("username",id));
        for(Document d : doc)
	        this.doc=d;
        
    	return this.doc;
    }
    
    public String getName()
    {   
    	return doc.getString("name");
    }
    public void setName(String name)
    {
    	tc.updateOne(eq("username",ID),new Document("$set", new Document("name",name)));
    }
    
    public String getBio()
    {   
    	return doc.getString("bio");
    }
    public void setBio(String bio)
    {
    	tc.updateOne(eq("username",ID),new Document("$set", new Document("bio",bio)));
    }
    
    public String getUsername()
    {   
    	return doc.getString("username");
    }
    public void setUsername(String username)
    {
    	tc.updateOne(eq("username",ID),new Document("$set", new Document("username",username)));
    }
    
    public void setContactInformation(String Phoneno,String email,String Country,String City,String State,String zipcode)
    {
    	tc.updateOne(eq("username",ID),new Document("$set", new Document("zipcode",zipcode))
    			.append("Email id", email)
    			.append("Country", Country)
    			.append("City", City)
    			.append("State", State)
    			);    	
    }
    
    @SuppressWarnings("unchecked")
	public JSONObject getContactInformation()
    {
    	 JSONObject obj = new JSONObject();
         Document innerdoc = (Document) doc.get("Contact_Information");
    	 obj.put("Phone no",innerdoc.get("Phone no"));
         obj.put("Email id",innerdoc.getString("Email id"));
         obj.put("Country", innerdoc.getString("Country"));
         obj.put("State",innerdoc.getString("State"));
         obj.put("City",innerdoc.getString("City")); 
         obj.put("Zipcode",innerdoc.get("Zipcode"));
         return obj;
    }


}
