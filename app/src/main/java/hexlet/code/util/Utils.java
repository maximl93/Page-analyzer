package hexlet.code.util;

import hexlet.code.model.UrlCheck;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(formatter);
    }

    public static String buildUrl(URL checkedUrl) {
        String result;
        if (checkedUrl.getPort() == -1) {
            result = String.format("%s://%s", checkedUrl.getProtocol(), checkedUrl.getHost());
        } else {
            result = String.format("%s://%s:%d", checkedUrl.getProtocol(), checkedUrl.getHost(), checkedUrl.getPort());
        }
        return result;
    }

    public static UrlCheck getResponseBodyContext(String checkingUrl, long urlId) {
        HttpResponse<String> response = Unirest.get(checkingUrl).asString();
        int status = response.getStatus();
        String responseBody = response.getBody();
        Document body = Jsoup.parse(responseBody);
        String title = body.title();
        String h1 = body.selectFirst("h1") != null ? body.selectFirst("h1").text() : null;
        String description = body.selectFirst("meta[name=description]") != null
                ? body.selectFirst("meta[name=description]").attr("content") : null;

        UrlCheck newCheck = new UrlCheck(status, urlId);
        newCheck.setH1(h1);
        newCheck.setTitle(title);
        newCheck.setDescription(description);
        return newCheck;
    }
}
