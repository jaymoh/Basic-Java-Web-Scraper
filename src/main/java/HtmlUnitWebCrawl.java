import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class HtmlUnitWebCrawl {
    public static void main(String[] args) throws IOException {
        //create chrome web client
        WebClient chromeWebClient = new WebClient(BrowserVersion.CHROME);

        //setup configurations for the web client
        chromeWebClient.getOptions().setUseInsecureSSL(true);
        chromeWebClient.getOptions().setCssEnabled(false);

        chromeWebClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        chromeWebClient.getOptions().setThrowExceptionOnScriptError(false);

        //fetch the blog page
        HtmlPage htmlPage = chromeWebClient.getPage("https://www.scrapingdog.com/blog/");

        //fetch the given elements using css query selector
        DomNodeList<DomNode> blogHeadings = htmlPage.querySelectorAll("div.blog-header a h2");

        //loop through the headings printing out the content
        for (DomNode domNode: blogHeadings) {
            System.out.println(domNode.asText());
        }

    }
}
