package hexlet.code.util;

import java.net.URL;

public class UrlBuilder {
    public static String buildUrl(URL checkedUrl ) {
        String result;
        if (checkedUrl.getPort() == -1) {
            result = String.format("%s://%s", checkedUrl.getProtocol(), checkedUrl.getHost());
        } else {
            result = String.format("%s://%s:%d", checkedUrl.getProtocol(), checkedUrl.getHost(), checkedUrl.getPort());
        }
        return result;
    }
}
