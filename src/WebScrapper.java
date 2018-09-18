import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScrapper {
    public static void main(String[] args) {

    System.out.println(WebScrapper.numberOfWordOccurences("and","http://erdani.com/tdpl/hamlet.txt" ));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int numberOfWordOccurences(String word, final String url) {
        if (word.length() > url.length()) {
            return 0;
        }
        int counter = 0;
        String article = WebScrapper.urlToString(url);
        for (int i = 0; i <= article.length() - word.length(); i++) {
            if (word.equals(article.substring(i, i + word.length()))) {
                counter++;
            }
        }
        return counter;
    }



}

