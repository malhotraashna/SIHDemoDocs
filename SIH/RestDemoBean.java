package SIH;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*; // weired 
//import static com.mongodb.client.model.Sorts.*;

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
    @SuppressWarnings({ "rawtypes", "unchecked" })
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
    
    //UPSERT DOCUMENTS
      public boolean insertUsername(String username)
      {
      	tc.insertOne(new Document("username","hello2").append("bio",""));
      return true;
      }
      public boolean upsertContactInformation(String Phoneno,String email,String Country,String City,String State,String zipcode)
      {

    	  Document doc=new Document("Phone no",Phoneno);
    	  doc.append("Email id",email);
    	  doc.append("Country",Country);
    	  doc.append("City",City);
    	  doc.append("State",State);
    	  tc.updateOne(eq("username","hello"),new Document("$set",doc));
    	  return true;	  
      }
      public boolean upsertFavouriteTag(ArrayList<String> tags)
      {
    	  for(String s:tags)
    	  tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Favourite_Tags",s)));
    	  return true; 
      }
      public boolean upsertName(String name)
      {
      	tc.updateOne(eq("username",ID),new Document("$set", new Document("name",name)));
        return true; 
      }
      
      public boolean upsertBio(String bio)
      {
      tc.updateOne(eq("username",ID),new Document("$set", new Document("bio",bio)));
       return true;
      }
      public boolean upsertSurfingHistory(ArrayList<String> Tags,ArrayList<String> User,ArrayList<String> Problem,ArrayList<String> Project)
      {
       if(Tags!=null&&Tags.size()>0)
    	   for(String s:Tags)
       tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Surfing_History.Past_Tags_Viewed",s))); 	                    
       if(User!=null&&User.size()>0)
    	   for(String s:User)
       tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Surfing_History.Past_User_Viewed",s))); 	                    
       if(Problem!=null&&Problem.size()>0)
    	   for(String s:Problem)
       tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Surfing_History.Past_Problem_Category_Viewed",s))); 	                    
       if(Project!=null&&Project.size()>0)
    	   for(String s:Project)
       tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Surfing_History.Past_Project_View",s))); 	                    
      
       return true;  
      }
      public boolean upsertFollowing(ArrayList<String> following)
      {
    	  for(String s:following)
        	  tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Following",s)));
        	  return true; 
      }
      public boolean upsertFollower(ArrayList<String> follower)
      {
    	  for(String s:follower)
        	  tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Followers",s)));
        	  return true; 
      }
      public boolean upsertContributing(ArrayList<String> contributing)
      {
    	  for(String s:contributing)
        	  tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Contributing",s)));
        	  return true; 
      }
      //update single project
      // get single project
      // get all project

      Date now = new Date();
      public boolean insertProjects()
      {   ArrayList<String> tags = new ArrayList<String>();
          ArrayList<String> contri = new ArrayList<String>();
          ArrayList<String> comment = new ArrayList<String>();
          ArrayList<String> images = new ArrayList<String>();
      /*  ArrayList<Document> comment = new ArrayList<Document>();
         Document d = new Document();
            d.append("username","use")
             .append("comment","asd")
             .append("EPOCH_TIME",now);
             comment.add(d);*/
    	  Document doc = new Document()
    	  .append("title","tile")		  
    	  .append("description","des")
    	  .append("project_url","www.pro.com")
    	  .append("tags",tags)
    	  .append("likes","10")
    	  .append("Comments",comment)
    	  .append("Contributors",contri)
    	  .append("README", "rm")
    	  .append("private", "pvt")
    	  .append("zip_file","")
    	  .append("images",images);

    	  tc.updateOne(eq("username","sjsidjain"),new Document("$addToSet",new Document("Projects",doc)));	
    	  return true;
      }
     public void updateProject(String project)
     {   ArrayList<String> tags = new ArrayList<String>();
     ArrayList<String> contri = new ArrayList<String>();
     ArrayList<String> comment = new ArrayList<String>();
     ArrayList<String> images = new ArrayList<String>();
    	 ArrayList <Document> pro = (ArrayList<Document>)doc.get("Projects");
    	 int i=0;
    			 for(Document d:pro)
    			 {
    				 if(d.getString("title").equals(project))
    				 {
     tc.updateOne(eq("Project."+i+".title","tile"),new Document("$Set",new Document("Projects."+i+".title","tile")));	
    // tc.updateOne(eq("Project."+i+".title","tile"),new Document("$Set",new Document("Projects."+i+".title","tile")));	
    // tc.updateOne(eq("Project."+i+".title","tile"),new Document("$Set",new Document("Projects."+i+".title","tile")));	
    // tc.updateOne(eq("Project."+i+".title","tile"),new Document("$Set",new Document("Projects."+i+".title","tile")));	
    // tc.updateOne(eq("Project."+i+".title","tile"),new Document("$Set",new Document("Projects."+i+".title","tile")));	
      			       	    					
    				 }
    			 }	 
     }
     // GET DOCUMENTS  
      public String getName(Document d)
    {   
    	return doc.getString("name");
    }

      public String getBio(Document d)
      {   
      	return doc.getString("bio");
      }  

      public String getUsername(Document d)
      {   
      	return doc.getString("username");
      }
      @SuppressWarnings("unchecked")
  	public JSONObject getContactInformation(Document d,JSONObject obj)
      {
      	   Document innerdoc = (Document) doc.get("Contact_Information");
      	   obj.put("Phone no",innerdoc.get("Phone no"));
           obj.put("Email id",innerdoc.getString("Email id"));
           obj.put("Country", innerdoc.getString("Country"));
           obj.put("State",innerdoc.getString("State"));
           obj.put("City",innerdoc.getString("City")); 
           obj.put("Zipcode",innerdoc.get("Zipcode"));
           return obj;
      }
      @SuppressWarnings("unchecked")
      public JSONObject getSurfingHistory(Document doc,JSONObject obj)
   {    JSONObject innerobj = new JSONObject();
    	JSONArray list0 = new JSONArray();
    	JSONArray list1 = new JSONArray();
    	JSONArray list2 = new JSONArray();
    	JSONArray list3 = new JSONArray();
	
    	Document innerdoc = (Document)doc.get("Surfing_History");
        ArrayList<String> viewedTags = (ArrayList<String>)innerdoc.get("Past_Tags_Viewed");
        for(String s:viewedTags)
        	list0.add(s);
        innerobj.put("Past_Tags_Viewed",list0);
        
       	ArrayList<String> viewedUser = (ArrayList<String>)innerdoc.get("Past_User_Viewed");
        for(String s:viewedUser)
        	list1.add(s);
        innerobj.put("Past_User_Viewed",list1);
        
        ArrayList<String> viewedProblem = (ArrayList<String>)innerdoc.get("Past_Problem_Category_Viewed");
        for(String s:viewedProblem)
        	list2.add(s);
        innerobj.put("Past_Problem_Category_Viewed",list2);
        
        ArrayList<String> viewedProject = (ArrayList<String>)innerdoc.get("Past_Project_View");
        for(String s:viewedProject)
        	list3.add(s);
        innerobj.put("Past_Project_View",list3);
        obj.put("Surfing_History", innerobj);
        list0=null;list1=null;list2=null;list3=null;
        return obj;}
      
      @SuppressWarnings("unchecked")
  	  public JSONObject getFavouriteTag(Document d,JSONObject obj)
      {
      	JSONArray list = new JSONArray();
      ArrayList<String> favtag = (ArrayList<String>)doc.get("Favourite_Tags");
      for(String s:favtag)
      	list.add(s);
      obj.put("Favourite_Tags",list);
      return obj;
      }
      @SuppressWarnings("unchecked")
  	  public JSONObject getFollowing(Document d,JSONObject obj)
      {
      JSONArray list = new JSONArray();
      ArrayList<String> follow = (ArrayList<String>)doc.get("Following");
      for(String s:follow)
      list.add(s);
      obj.put("Following",list);
      return obj;
      }
      @SuppressWarnings("unchecked")
  	  public JSONObject getFollower(Document d,JSONObject obj)
      {
      JSONArray list = new JSONArray();
      ArrayList<String> follow = (ArrayList<String>)doc.get("Followers");
      System.out.println(follow);
      for(String s:follow)
      list.add(s);
      obj.put("Followers",list);
      return obj;
      }
      @SuppressWarnings("unchecked")
  	  public JSONObject getContributing(Document d,JSONObject obj)
      {
      JSONArray list = new JSONArray();
      ArrayList<String> contri = (ArrayList<String>)doc.get("Contributing");
      for(String s:contri)
      list.add(s);
      obj.put("Contributing",contri);
      return obj;
      }
	
      public JSONObject getAllProjects(Document doc,JSONObject obj)
      {
    	  JSONArray list = new JSONArray();
    	  ArrayList<Document> project = (ArrayList<Document>)doc.get("Projects");
          for(Document d: project){
        	  list.add(d);
          }
          obj.put("Projects",list);
          return obj;
      } 
       
      public JSONObject getSingleProject(Document doc, JSONObject obj, String title)
      {
    	  ArrayList<Document> required = (ArrayList<Document>)doc.get("Projects");
    	  for(Document d : required)
    		  if(d.getString("title").equals(title))
    			  obj.put("Project", d);
    	  return obj;
      }
 }
