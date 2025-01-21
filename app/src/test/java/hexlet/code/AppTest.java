package hexlet.code;

import hexlet.code.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    private Javalin app;
    private String testedUrl = "url=https://www.example.com";

    @BeforeEach
    public void setUp() throws SQLException, IOException {
        app = App.getApp();
    }

    @Test
    public void mainPageTest() {
        JavalinTest.test(app, (server, client) -> {
            assertThat(client.get(NamedRoutes.mainPage()).code()).isEqualTo(200);
            assertThat(client.get(NamedRoutes.mainPage()).body().string()).contains("Анализатор страниц");
        });
    }

    @Test
    public void saveUrlSuccessTest() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.post(NamedRoutes.allUrlsPage(), testedUrl);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://www.example.com");
        });
    }

    @Test
    public void saveUrlFailTest() {
        String wrongUrl = "url=ps://www.exam";

        JavalinTest.test(app, (server, client) -> {
            var response = client.post(NamedRoutes.allUrlsPage(), wrongUrl);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Некорректный URL");
        });
    }

    //@Test
    //public void urlAlreadySavedTest() {
    //    JavalinTest.test(app, (server, client) -> {
    //        client.post(NamedRoutes.allUrlsPage(), testedUrl);
    //        var response = client.post(NamedRoutes.allUrlsPage(), testedUrl);
    //        assertThat(response.code()).isEqualTo(200);
    //        assertThat(response.body().string()).contains("Страница уже существует");
    //    });
    //}

    @Test
    public void showSavedUrlsPageTest() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.allUrlsPage());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Нет сохраненных ссылок");
        });
    }


    @Test
    public void showSavedUrlPageTest() {
        JavalinTest.test(app, (server, client) -> {
            client.post(NamedRoutes.allUrlsPage(), testedUrl);
            var response = client.get(NamedRoutes.urlPage(1));
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    public void urlNotFoundTest() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlPage(999));
            assertThat(response.code()).isEqualTo(500);
        });
    }
}
