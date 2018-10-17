
/**
 * Write a description of class WikiBot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WikiBot
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class WikiBot
     */
    public WikiBot()
    {
        // initialise instance variables
        
    }
    public  static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Special:Random").get();
        Elements paragraphs = doc.select("p");
        Element firstParagraph = paragraphs.first();
        System.out.println( firstParagraph.text() );

    }
        
    }
    

