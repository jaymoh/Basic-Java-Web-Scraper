import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;

public class CrawlUsingJSOUP {
    public static void main(String[] args) throws IOException {
        //fetch the web page
        Document page = Jsoup.connect("https://www.scrapingdog.com/blog/").get();

        //selecting the blog headers from the page using css query
        Elements pageElements = page.select("div.blog-header a h2");

        //ArrayList to store the blog headings
        ArrayList<String> blogHeadings = new ArrayList<>();

        //loop through the fetched page elements adding them to the blogHeadings array list
        for (Element e:pageElements) {
            blogHeadings.add("Heading: " + e.text());
        }

        //print out the array list
        for (String s : blogHeadings) {
            System.out.println(s);
        }
    }
}
