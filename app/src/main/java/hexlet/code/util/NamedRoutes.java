package hexlet.code.util;

public class NamedRoutes {
    public static String mainPage() {
        return "/";
    }

    public static String allUrlsPage() {
        return "/urls";
    }

    public static String urlPage(long id) {
        return urlPage(String.valueOf(id));
    }

    public static String urlPage(String id) {
        return "/urls/" + id;
    }

    public static String urlCheck(long id) {
        return urlCheck(String.valueOf(id));
    }

    public static String urlCheck(String id) {
        return "/urls/" + id + "/checks";
    }
}
