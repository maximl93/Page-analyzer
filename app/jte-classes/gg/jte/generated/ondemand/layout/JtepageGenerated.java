package gg.jte.generated.ondemand.layout;
import hexlet.code.util.NamedRoutes;
import hexlet.code.dto.BasePage;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,36,36,36,36,36,36,36,36,36,36,39,39,39,39,39,39,39,39,39,48,48,49,49,49,49,50,50,50,52,52,54,54,54,65,65,65,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page) {
		jteOutput.writeContent("\r\n\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\"\r\n          content=\"width=device-width, initial-scale=1\">\r\n    <title>Main page</title>\r\n\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\"\r\n          rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\"\r\n          crossorigin=\"anonymous\">\r\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"\r\n            integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\"\r\n            crossorigin=\"anonymous\"></script>\r\n</head>\r\n<body>\r\n\r\n    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n        <div class=\"container-fluid\">\r\n            <h3 class=\"navbar-brand\">Анализатор страниц</h3>\r\n            <button class=\"navbar-toggler\" type=\"button\"\r\n                    data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\"\r\n                    aria-controls=\"navbarNav\" aria-expanded=\"false\"\r\n                    aria-label=\"Toggle navigation\">\r\n                <span class=\"navbar-toggler-icon\"></span>\r\n            </button>\r\n            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n                <ul class=\"navbar-nav\">\r\n                    <li class=\"nav-item\">\r\n                        <a class=\"nav-link\"");
		var __jte_html_attribute_0 = NamedRoutes.mainPage();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\r\n                    </li>\r\n                    <li class=\"nav-item\">\r\n                        <a class=\"nav-link\"");
		var __jte_html_attribute_1 = NamedRoutes.allUrlsPage();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Все сайты</a>\r\n                    </li>\r\n                </ul>\r\n            </div>\r\n        </div>\r\n    </nav>\r\n\r\n\r\n    <main>\r\n        ");
		if (page != null && page.getFlashMessage() != null) {
			jteOutput.writeContent("\r\n            <div class=\"alert alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getMessageType());
			jteOutput.setContext("div", null);
			jteOutput.writeContent("\" role=\"alert\">\r\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlashMessage());
			jteOutput.writeContent("\r\n            </div>\r\n        ");
		}
		jteOutput.writeContent("\r\n        <div>\r\n            ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n        </div>\r\n    </main>\r\n\r\n    <footer class=\"footer text-center text-white bg-dark fixed-bottom\">\r\n        <div class=\"container\">\r\n                <p class=\"pt-2\">Данный сайт является учебным проектом.</p>\r\n                <p><a class=\"text-white\" href=\"https://github.com/maximl93\">Мой Git</a></p>\r\n        </div>\r\n    </footer>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
