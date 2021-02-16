import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

//implement PageProcessor
public class WebMagicCrawler implements PageProcessor {

    private Site site = Site.me();

    public static void main(String[] args) {
        //define the url to scrape
        //will run in a separate thread
        Spider.create(new WebMagicCrawler()).addUrl("https://www.scrapingdog.com/blog/").thread(5).run();
    }

    @Override
    public void process(Page page) {
        //fetch all blog headings storing them in a list
         List<String> rs = page.getHtml().css("div.blog-header a h2").all();

         //loop through the list printing out its contents
        for (String s:rs ){
            System.out.println("Heading "+ s);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
