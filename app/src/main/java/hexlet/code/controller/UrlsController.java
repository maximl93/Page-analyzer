package hexlet.code.controller;

import hexlet.code.dto.BasePage;
import hexlet.code.dto.UrlPage;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlsRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.http.Context;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;

import static hexlet.code.util.UrlBuilder.buildUrl;
import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlsController {
    public static void index(Context context) {
        BasePage page = new BasePage();
        page.setFlashMessage(context.consumeSessionAttribute("flash-message"));
        page.setMessageType(context.consumeSessionAttribute("message-type"));
        context.render("index.jte", model("page", page));
    }

    public static void saveUrlInDB(Context context) {
        String checkedUrl = context.formParam("url");
        try {
            URL url = URI.create(checkedUrl).toURL();
            String buildUrl = buildUrl(url);
            if (UrlsRepository.findSavedUrlByName(buildUrl).isEmpty()) {
                Url savingUrl = new Url(buildUrl);
                UrlsRepository.save(savingUrl);
                context.sessionAttribute("flash-message", "Страница успешно добавлена");
                context.sessionAttribute("message-type", "success");
                context.redirect(NamedRoutes.allUrlsPage());
            } else {
                context.sessionAttribute("flash-message", "Страница уже существует");
                context.sessionAttribute("message-type", "info");
                context.redirect(NamedRoutes.allUrlsPage());
            }
        } catch (Exception e) {
            context.sessionAttribute("flash-message", "Некорректный URL");
            context.sessionAttribute("message-type", "danger");
            BasePage page = new BasePage();
            page.setFlashMessage(context.consumeSessionAttribute("flash-message"));
            page.setMessageType(context.consumeSessionAttribute("message-type"));
            context.render("index.jte", model("page", page));
        }
    }

    public static void showAllSavedUrls(Context context) throws SQLException{
        UrlsPage urlsPage = new UrlsPage(UrlsRepository.getAllUrls());
        urlsPage.setFlashMessage(context.consumeSessionAttribute("flash-message"));
        urlsPage.setMessageType(context.consumeSessionAttribute("message-type"));
        context.render("showAll.jte", model("page", urlsPage));
    }

    public static void showSavedUrl(Context context) throws SQLException {
        Long id = context.pathParamAsClass("id", Long.class).get();
        UrlPage page = new UrlPage(UrlsRepository.findSavedUrlById(id).get());
        context.render("showOne.jte", model("page", page));
    }
}
