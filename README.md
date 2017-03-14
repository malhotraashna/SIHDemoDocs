# SIHDemoDocs
For SIH Demo Programs and Concepts

prerequisite:
Eclipse Mars (preferred) or any other version of Eclipse,
Java 1.8 (Preferred) or 1.7 ,
Apache Tomat 8.x (preferred) or 7.x

open eclipse
Create a new Dynamic Web Project name it code
Deploy this project on Apache Tomcat 
Create SIH package inside Project code. You can also add this package while adding servlet in next step
Create new Servlet name it RestDemo and place it in SIH package
Create Simple Java class name it RestDemoBean
Add Code in both class
Start Tomcat Server
Open ARC
type this in URL:  http://localhost:8080/code/RestDemo
Select Post
In RAW Payload enter:  {"username":"sjsidjain"}
Then click Send
Expected output:  {"State":"Rajasthan","Email id":"sjsidjain213@gmail.com","Zipcode":302017.0,"Country":"India","City":"Jaipur","Phone no":9.799784767E9}

Required External Jar Files

 1.java-json.jar (http://www.java2s.com/Code/JarDownload/java-json/java-json.jar.zip)

2.jersey-bundle-1.8.jar (http://www.java2s.com/Code/JarDownload/jersey-bundle/jersey-bundle-1.8.jar.zip)

3.jsr311-api-1.1.1.jar (http://www.java2s.com/Code/JarDownload/jsr311/jsr311-api-1.1.1.jar.zip)

4.json-simple-1.1.1.jar (http://www.java2s.com/Code/JarDownload/json-simple/json-simple-1.1.1.jar.zip )

5.Download this jar from maven with following ID's

            <groupId>org.mongodb</groupId>
            <artifactId>mongodb-driver</artifactId>
            <version>3.2.2</version>


Structure of Project
RestDemo is main servlet class which will reply to all request received from any webpage
RestDemoBean this is the supporter bean of RestDemo.

**Methods to add in RestDemoBean.**
Everyone should Add atleast one of this method by End of 12-03-2017. Select any method out of these and add them RestDemoBean.

    1.updateSingleProject -> if we want to update any particular project in any document like If I want to update an exsisting project                                of username sjsidjain. 
    2. upsertEncyptPassword -> update or insert **encrypted** password
    3. extractZipFile -> for Extracting data out of zipfile uploaded by user
    4. Improve any exsisting method
    
    you can all also add any other method if you think it will be required
