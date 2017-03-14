package SIH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/RestDemo")
public class RestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
  //  private JSONParser parser = new JSONParser();
    protected JSONObject obj = new JSONObject();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StringBuilder sb = new StringBuilder();
	    try 
	    {
	      BufferedReader reader = request.getReader();
	      String line = null;
	      while ((line = reader.readLine()) != null)
	      { sb.append(line);
	      }
	    } catch (Exception e) { e.printStackTrace(); }
	
	    JSONParser parser = new JSONParser();
	    JSONObject joUser = new JSONObject();
            String username="";
	    String requiredProject = "";
        try
	    {
	    	//creating JSONObject out of JSON formatted String
	      joUser = (JSONObject) parser.parse(sb.toString());
	      username= joUser.get("username").toString();
	      //requiredProject = joUser.get("myProject").toString();
	    } catch (Exception e) { e.printStackTrace(); }

    //RestDemoBean rdb = new RestDemoBean();
    //Add Data In Database    
	//rdb.upsertUsername(username);
    //rdb.upsertContactInformation("97997","sjsid","","","",""); 
    //ArrayList<String> tags = new ArrayList<String>();
    //tags.add("aa");tags.add("bb");
    //rdb.upsertSurfingHistory(tags);
    //rdb.upsertFavouriteTag(tags);
    //rdb.upsertFollower(tags);
    //rdb.upsertFollowing(tags);
    //rdb.upsertContributing(tags);
    
    //Get Data From DataBase    
    //Document doc = rdb.getDocument(username);
    //rdb.getContactInformation(doc, obj);
    //rdb.getAllProjects(doc, obj);
    //rdb.getSingleProject(doc, obj, requiredProject);
	//rdb.getFavouriteTag(doc, obj);
	//rdb.getFollower(doc,obj);
	//rdb.getFollowing(doc, obj);
	//rdb.getContributing(doc,obj);
	//rdb.getSurfingHistory(doc,obj);
      //rdb.insertProjects();
    //PrintWriter out = response.getWriter();
	//out.println(obj.toJSONString());
	}

}
