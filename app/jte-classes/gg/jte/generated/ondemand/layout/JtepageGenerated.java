package gg.jte.generated.ondemand.layout;
import hexlet.code.util.NamedRoutes;
import hexlet.code.dto.BasePage;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,32,32,32,32,32,32,32,32,32,32,33,33,33,33,33,33,33,33,33,42,42,43,43,43,43,44,44,44,47,47,49,49,49,65,65,65,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page) {
		jteOutput.writeContent("\r\n\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\"\r\n          content=\"width=device-width, initial-scale=1\">\r\n    <title>Main page</title>\r\n\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\"\r\n          rel=\"stylesheet\"\r\n          integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\"\r\n          crossorigin=\"anonymous\">\r\n</head>\r\n<body>\r\n\r\n    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n        <div class=\"container-fluid\">\r\n            <h3 class=\"navbar-brand\">Анализатор страниц</h3>\r\n            <button class=\"navbar-toggler\" type=\"button\"\r\n                    data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavAltMarkup\"\r\n                    aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n                <span class=\"navbar-toggler-icon\"></span>\r\n            </button>\r\n            <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\r\n                <div class=\"navbar-nav\">\r\n                    <a class=\"nav-link\"");
		var __jte_html_attribute_0 = NamedRoutes.mainPage();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\r\n                    <a class=\"nav-link\"");
		var __jte_html_attribute_1 = NamedRoutes.allUrlsPage();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Все сайты</a>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </nav>\r\n\r\n\r\n    <main class=\"flex-grow-1\">\r\n        <div class=\"p-5\">\r\n            ");
		if (page != null && page.getFlashMessage() != null) {
			jteOutput.writeContent("\r\n                <div class=\"alert alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getMessageType());
			jteOutput.setContext("div", null);
			jteOutput.writeContent(" alert-dismissible fade show\" role=\"alert\">\r\n                    <strong>");
			jteOutput.setContext("strong", null);
			jteOutput.writeUserContent(page.getFlashMessage());
			jteOutput.writeContent("</strong>\r\n                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n                </div>\r\n            ");
		}
		jteOutput.writeContent("\r\n            <div class=\"container-md\">\r\n                ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n            </div>\r\n        </div>\r\n    </main>\r\n\r\n    <footer class=\"footer text-center text-white bg-dark fixed-bottom\">\r\n        <div class=\"container-fluid\">\r\n                <p class=\"pt-2\">Данный сайт является учебным проектом.</p>\r\n                <p><a class=\"text-white\" href=\"https://github.com/maximl93\">Мой Git</a></p>\r\n        </div>\r\n    </footer>\r\n\r\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"\r\n            integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\"\r\n            crossorigin=\"anonymous\"></script>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
