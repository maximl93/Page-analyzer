package gg.jte.generated.ondemand;
import hexlet.code.util.Utils;
import hexlet.code.util.NamedRoutes;
import hexlet.code.model.UrlCheck;
import hexlet.code.dto.UrlPage;
public final class JteshowOneGenerated {
	public static final String JTE_NAME = "showOne.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,4,4,6,6,9,9,14,14,14,18,18,18,22,22,22,28,28,28,28,28,28,28,28,28,32,32,34,34,47,47,49,49,49,50,50,50,51,51,51,52,52,52,53,53,53,54,54,54,56,56,59,59,61,61,61,61,61,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n\r\n        <table class=\"table table-bordered\">\r\n            <tr>\r\n                <th>ID</th>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            <tr>\r\n                <th>Имя</th>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\r\n            </tr>\r\n            <tr>\r\n                <th>Дата создания</th>\r\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(Utils.formatDate(page.getUrl().getCreatedAt()));
				jteOutput.writeContent("</td>\r\n            </tr>\r\n        </table>\r\n\r\n        <h2>Поверки</h2>\r\n    \r\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.urlCheck(page.getUrl().getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\r\n            <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\r\n        </form>\r\n\r\n    ");
				if (page.getChecks().isEmpty()) {
					jteOutput.writeContent("\r\n        <h2>Ссылка не проверялась</h2>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n        <table class=\"table table-hover table-bordered mt-3\">\r\n            <thead>\r\n            <tr>\r\n                <th scope=\"row\">ID</th>\r\n                <th scope=\"row\">Код ответа</th>\r\n                <th scope=\"row\">title</th>\r\n                <th scope=\"row\">h1</th>\r\n                <th scope=\"row\">description</th>\r\n                <th scope=\"row\">Дата проверки</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody class=\"table-group-divider\">\r\n            ");
					for (UrlCheck check : page.getChecks()) {
						jteOutput.writeContent("\r\n                <tr>\r\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(check.getId());
						jteOutput.writeContent("</td>\r\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(check.getStatusCode());
						jteOutput.writeContent("</td>\r\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(check.getTitle());
						jteOutput.writeContent("</td>\r\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(check.getH1());
						jteOutput.writeContent("</td>\r\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(check.getDescription());
						jteOutput.writeContent("</td>\r\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(Utils.formatDate(check.getCreatedAt()));
						jteOutput.writeContent("</td>\r\n                </tr>\r\n            ");
					}
					jteOutput.writeContent("\r\n            </tbody>\r\n        </table>\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
