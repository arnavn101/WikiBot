

// date 
// google text
// random fact
// question (who, what, when, why)
// open program



/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */

import java.awt.Desktop;
import java.util.ArrayList;


import java.io.File;
import java.io.IOException;
import java.net.URI;


import java.lang.ProcessBuilder;
import java.lang.Runtime; 
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.lang.String;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class Magpie2
{
    String response;
    public static String name; 
    String mom;
    String dad;
    String bro;
    String sis;
    String iq;
    String col;
    /**
     * Insert your own greeting for your unique chatbot 
     * @return a greeting
     */
    public String getGreeting()
    {
        response = "";

        return "Hello, let's talk.";
        
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) throws java.io.IOException
    {


        if (basicInteractions(statement))
            return response;
        else if(familyStatement(statement))
        {
            return response;
        }
        
        else if (command(statement))
            return response;
        else if(know(statement))
            return response;
        else if(searchChrome(statement))
            return response;
        else if(name(statement))
        {
            return response;
        }       
        else if (date(statement))
            return response;
        else if (wikipedia(statement))
            return response;
        else if (quora(statement))
            return response;
        else if(negativeStatement(statement))
        {
            return response;
        }
        else
        {
            response = getRandomResponse();
            return response;
        }

    }
    
   
    public boolean know(String statement){
     if (statement.indexOf("what do you know about me") >=0 || statement.indexOf("information about me") >=0  ){
         if(name==null){                
                System.out.println("I don't know your name is. You never told me");
                }
            else
                System.out.println("Your name: " + name);
         
             if(dad==null){                
                System.out.println("I don't know your dad's name. You never told me");
                }
            else
                System.out.println("Your Dad's name: " + dad);
         
         
         if(mom==null){                
                System.out.println("I don't know your mother's name. You never told me");
                }
            else
                System.out.println("Your mother's name: " + mom);
         
                if(bro==null){                
                System.out.println("I don't know your brother's name. You never told me");
                }
            else
                System.out.println("Your brother's name: " + bro);
                
                if(sis==null){                
                System.out.println("I don't know your sister's name. You never told me");
                }
            else
                System.out.println("Your sister's name: " + sis);
                
          if(iq==null){                
                System.out.println("I don't know your iq name. You never told me");
                }
            else
                System.out.println("Your iq: " + iq);
         
                if(col==null){                
                System.out.println("I don't know your favorite color. You never told me");
                }
            else
                System.out.println("Your favorite color: " + col);
         
            
            response = "\n\n";
            return true;
    }

    return false;
        }
        
    
    public boolean command(String statement) throws java.io.IOException{
        if (statement.indexOf("open") >= 0)
        {
        String statement_2 = statement.replaceFirst("open ", "");
        
        Runtime rt = Runtime.getRuntime();
        Runtime.getRuntime().exec("cmd /c start " + statement_2 + ".exe");
        response = "Program Opened Successfully";
        return true;
        
        
    }
     return false;
    }

    
        public boolean negativeStatement(String statement)
    {
        if (statement.indexOf("not") >= 0)
        {
            response = "Why so negative?";
            return true;
        } else if (statement.indexOf("is") > 0) {
            return false;
        } else if (statement.indexOf("no") >= 0) {
            response = "Why so negative?";
            return true;
        }
        return false;
    }

    
    
   
    
    public boolean familyStatement(String statement) throws java.io.IOException
    {
        if (statement.indexOf("mother") >= 0 || statement.indexOf("mom") >= 0)
        {
           
            if(mom==null){                
                System.out.println("What is your Mother's name? I don't know it yet");
                mom = MagpieRunner2.in.nextLine();
                response = "Wow. Your mom has a good name!!! I'll find a way to remember that name for a long time";
                }
            else
                response = "Your mother's name is " + mom;
            return true;
        }
        else if (statement.indexOf("father") >= 0 || statement.indexOf("dad") >= 0)
        {

            if(dad==null){                
                System.out.println("What is your father's name? I don't know it yet");
                dad = MagpieRunner2.in.nextLine();
                response = "Wow. Your father has a good name!!! I'll find a way to remember that name for a long time";
                }
            else
                response = "Your father's name is " + dad;
            return true;
        }
        else if (statement.indexOf("brother") >= 0 || statement.indexOf("bro") >= 0)
        {

            if(bro==null){                
                System.out.println("What is your brother's name? I don't know it yet");
                bro = MagpieRunner2.in.nextLine();
                response = "Wow. Your brother has a good name!!! I'll find a way to remember that name for a long time";
                }
            else
                response = "Your brother's name is " + bro;
            return true;
        }
        else if (statement.indexOf("sister") >= 0 || statement.indexOf("sis") >= 0)
        {

            if(sis==null){                
                System.out.println("What is your sister's name? I don't know it yet");
                sis = MagpieRunner2.in.nextLine();
                response = "Wow. Your sister has a good name!!! I'll find a way to remember that name for a long time";
                }
            else
                response = "Your sister's name is " + sis;
            return true;
        }
        
        else if (statement.indexOf("iq") >= 0) {
            if(iq==null) {
                response = "I'm smarter than you";
                iq = statement.substring(statement.lastIndexOf(" ")+1);
            } else {
                response = "Your iq is " + iq;
            }
            return true;
        }
        else if (statement.indexOf("favorite color") >= 0) {
            if (col == null) {
                response = "That's my favorite color too";
                col = statement.substring(statement.lastIndexOf(" ") + 1);
            } else {
                response = "Your favorite color is " + col;
            }
            return true;
        }
        return false;
    }
    
    public boolean shortStatement()
    {
        return false;
    }
    
     public boolean name(String statement){
        
       
        if (statement.indexOf("what is my name") >=0 || statement.indexOf("whats my name") >=0 || statement.indexOf("my name") >=0){
            
            if(name==null){
                
                System.out.println("What is your name? I do not know it :(");
                name = MagpieRunner2.in.nextLine();
                response = "That is a very nice name. I'll remember that forever!!!";
                }
            else
                response = "Your name is " + name;
            return true;
        }
         
        return false;
            
        
    }
    
    
    /**
     * Create our own method to respond to the keywords of your own choosing.
     * Replace the method name and construct your own if else block.
     * Put method call into the getResponse method
     */
    public String separateString(String response) {
        String responseFixed = response.replace("\n", "");
        for (int i = 40; i <= responseFixed.length(); i += 40) {
            int x = responseFixed.substring(0, i).lastIndexOf(" ") + 1;
            responseFixed = responseFixed.substring(0, x) + "\n" + responseFixed.substring(x, responseFixed.length());
        }
        return responseFixed;
    }
    public boolean wikipedia(String statement) throws java.io.IOException
    {
        
        if (statement.indexOf("fact") >= 0){
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Special:Random").get();
        Elements paragraphs = doc.select("p:not(:has(#coordinates))");
        Element firstParagraph = paragraphs.first();
         Jsoup.parse("A\nB").text();



        response = separateString(firstParagraph.text());
        return true;
    }
        return false;
    }
    
    public boolean basicInteractions(String statement){
        
        if (statement.indexOf("hello") >=0 || statement.indexOf("hi") >=0 || statement.indexOf("hey") >=0){
            response = "Hello There. How are you!!!";
            return true;}
        else if (statement.indexOf("how are you") >=0 || statement.indexOf("how do you do") >=0 || statement.indexOf("how is your day") >=0){
            response = "I am good! What about you";
            return true;}
        else if (statement.indexOf("what is your name") >=0 || statement.indexOf("whats your name") >=0 || statement.indexOf("your name") >=0){
            response = "I am the one and only WikiBot";
            return true;}
         
        else if (statement.indexOf("good") >=0 || statement.indexOf("nice") >=0 || statement.indexOf("awesome") >=0){
            response = "Thanks for your nice words :)";
            return true;}
        else if (statement.indexOf("thank you") >=0 || statement.indexOf("thx") >=0 || statement.indexOf("thanks") >=0){
            response = "No problemo";
            return true;}    
        return false;
            
        
    }
    /**
     * Create our own method to respond to the keywords of your own choosing.
     * Replace the method name and construct your own if else block.
     * Put method call into the getResponse method
     */
    public boolean quora(String statement) throws java.io.IOException
    {
        try{
            statement = statement.replace(' ', '-');
        
        if (statement.indexOf("what") >= 0 
        || statement.indexOf("who") >=0 || statement.indexOf("when") >=0 || statement.indexOf("how") >=0 || statement.indexOf("where") >=0){
        Document doc = Jsoup.connect("https://www.quora.com/" + statement).get();
        Elements paragraphs = doc.select("p:not(:has(#coordinates))");
        int a = 4;
        Elements e = doc.getElementsContainingOwnText("ad by");

        for (Element el : e) {
            el.text(el.ownText().replace("ad by", "Advertisement -> "));
        }
        
        Elements f = doc.getElementsContainingOwnText("Still have a question? Ask your own!");
        
        for (Element el : f) {
            el.text(el.ownText().replace("Still have a question? Ask your own", "\n\n Hope this answer helped you \n\n"));
        }
        
        for(Element p : paragraphs){
            System.out.println(separateString(p.text()));
            if (p.text().matches("Hope this answer helped you" )  || p.text().matches("promoted by" ))

                break;
            a++;

        }
        response = "\n\n";
        return true;
    }
        
    }
    catch (Exception e){
        System.out.println("\n\n");
    }
    return false;
    }
    
    /**
     * Create our own method to respond to the keywords of your own choosing.
     * Replace the method name and construct your own if else block.
     * Put method call into the getResponse method
     */
    public boolean date(String statement)
    {
        if (statement.indexOf("date") >= 0){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");  
        LocalDateTime now = LocalDateTime.now();  
        response = dtf.format(now); 
        return true;
    }
    return false;
    }
    
    /**
     * Create our own method to respond to the keywords of your own choosing.
     * Replace the method name and construct your own if else block.
     * Put method call into the getResponse method
     */
    public boolean creativeResponse4(String statement)
    {
        return false;
    }
    public boolean searchChrome(String statement) throws java.io.IOException{
        


        if(statement.indexOf("google") >=0){
            String statement_2 = statement.replaceFirst("google ", "");
            statement_2 = statement_2.replace(' ', '+');
           try {
               
            Desktop d=Desktop.getDesktop();

            
            d.browse(new URI("https://www.google.com/search?q=" + statement_2));
            
            response = "Googled successfully!!!";

    }     catch (Exception e) {
   
      e.printStackTrace();
    }
    return true;
        }
        return false;
    }
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }
}
