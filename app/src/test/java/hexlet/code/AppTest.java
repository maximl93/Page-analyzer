package hexlet.code;

import hexlet.code.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public final class AppTest {
    private Javalin app;
    private final String testedUrl = "url=https://www.example.com";
    public static MockWebServer mockServer;

    @BeforeEach
    public void setUp() throws SQLException, IOException {
        mockServer = new MockWebServer();
        mockServer.start(8080);
        app = App.getApp();
    }

    @AfterEach
    public void stop() throws IOException {
        mockServer.shutdown();
        app.stop();
    }

    @Test
    public void mainPageTest1() {
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
            assertThat(response.body().string()).contains("Некорректный URL");
        });
    }

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

    @Test
    public void checkUrlTest() throws IOException, SQLException {
        JavalinTest.test(app, (server, client) -> {
            String htmlBody = new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/example.html")));
            mockServer.enqueue(new MockResponse().setBody(htmlBody).setResponseCode(200));
            String url = mockServer.url("/").toString();
            client.post(NamedRoutes.allUrlsPage(), "url=" + url);
            client.post(NamedRoutes.urlCheck(1));
            var response = client.get(NamedRoutes.urlPage(1));

            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Example Domain");
        });
    }
}
