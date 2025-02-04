package gg.jte.generated.ondemand;
import hexlet.code.util.Utils;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.util.NamedRoutes;
public final class JteshowAllGenerated {
	public static final String JTE_NAME = "showAll.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,4,4,6,6,8,8,9,9,11,11,22,22,24,24,24,25,25,25,25,25,25,25,25,25,25,25,25,26,26,27,27,27,28,28,30,30,31,31,31,32,32,35,35,38,38,39,39,39,39,39,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    ");
				if (page.getUrlsAndChecks().keySet().isEmpty()) {
					jteOutput.writeContent("\r\n        <h2>Нет сохраненных ссылок</h2>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n        <table class=\"table table-hover table-bordered\">\r\n            <thead>\r\n            <tr>\r\n                <th scope=\"col\">ID</th>\r\n                <th scope=\"col\">Имя</th>\r\n                <th scope=\"col\">Последняя проверка</th>\r\n                <th scope=\"col\">Код ответа</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody class=\"table-group-divider\">\r\n            ");
					for (Url url : page.getUrlsAndChecks().keySet()) {
						jteOutput.writeContent("\r\n                <tr>\r\n                    <th scope=\"row\">");
						jteOutput.setContext("th", null);
						jteOutput.writeUserContent(url.getId());
						jteOutput.writeContent("</th>\r\n                    <td><a");
						var __jte_html_attribute_0 = NamedRoutes.urlPage(url.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_0);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(url.getName());
						jteOutput.writeContent("</a></td>\r\n                    <td>");
						if (page.getUrlsAndChecks().get(url).getCreatedAt() != null) {
							jteOutput.writeContent("\r\n                            ");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(Utils.formatDate(page.getUrlsAndChecks().get(url).getCreatedAt()));
							jteOutput.writeContent("\r\n                        ");
						}
						jteOutput.writeContent("\r\n                    </td>\r\n                    <td>");
						if (page.getUrlsAndChecks().get(url).getStatusCode() != 0) {
							jteOutput.writeContent("\r\n                            ");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(page.getUrlsAndChecks().get(url).getStatusCode());
							jteOutput.writeContent("\r\n                        ");
						}
						jteOutput.writeContent("\r\n                    </td>\r\n                </tr>\r\n            ");
					}
					jteOutput.writeContent("\r\n            </tbody>\r\n        </table>\r\n    ");
				}
				jteOutput.writeContent("\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
