package hexlet.code.controller;

import hexlet.code.dto.BasePage;
import hexlet.code.dto.UrlPage;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlsRepository;
import hexlet.code.repository.ChecksRepository;
import hexlet.code.util.NamedRoutes;
import hexlet.code.util.Utils;
import io.javalin.http.Context;

import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;

import static hexlet.code.util.Utils.buildUrl;
import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlsController {
    public static void index(Context context) {
        BasePage page = new BasePage();
        consumeFlashMessages(context, page);
        context.render("index.jte", model("page", page));
    }

    public static void save(Context context) {
        String checkedUrl = context.formParam("url");
        try {
            URL url = URI.create(checkedUrl).toURL();
            String buildUrl = buildUrl(url);
            if (UrlsRepository.findByName(buildUrl).isEmpty()) {
                Url savingUrl = new Url(buildUrl);
                UrlsRepository.save(savingUrl);
                setFlashMessages(context, "Страница успешно добавлена", "success");
                context.redirect(NamedRoutes.allUrlsPage());
            } else {
                setFlashMessages(context, "Страница уже существует", "info");
                context.redirect(NamedRoutes.allUrlsPage());
            }
        } catch (Exception e) {
            setFlashMessages(context, "Некорректный URL", "danger");
            BasePage page = new BasePage();
            consumeFlashMessages(context, page);
            context.render("index.jte", model("page", page));
        }
    }

    public static void showAll(Context context) throws SQLException {
        Map<Url, UrlCheck> urlsAndChecks = UrlsRepository.findAllUrlsAndLastUrlsChecks();
        UrlsPage page = new UrlsPage(urlsAndChecks);
        consumeFlashMessages(context, page);
        context.render("showAll.jte", model("page", page));
    }

    public static void findById(Context context) throws SQLException {
        Long id = context.pathParamAsClass("id", Long.class).get();
        UrlPage page = new UrlPage(UrlsRepository.findById(id).get(),
                ChecksRepository.findByUrlId(id));
        consumeFlashMessages(context, page);
        context.render("showOne.jte", model("page", page));
    }

    public static void check(Context context) throws SQLException {
        Long urlId = context.pathParamAsClass("id", Long.class).get();
        Url savedUrl = UrlsRepository.findById(urlId).get();
        String urlName = savedUrl.getName();
        UrlCheck newCheck = Utils.getResponseBodyContext(urlName, urlId);
        ChecksRepository.save(newCheck);
        setFlashMessages(context, "Страница успешно проверена", "success");
        context.redirect(NamedRoutes.urlPage(urlId));
    }

    private static void setFlashMessages(Context context, String message, String type) {
        context.sessionAttribute("flash-message", message);
        context.sessionAttribute("message-type", type);
    }

    private static void consumeFlashMessages(Context context, BasePage page) {
        page.setFlashMessage(context.consumeSessionAttribute("flash-message"));
        page.setMessageType(context.consumeSessionAttribute("message-type"));
    }
}
