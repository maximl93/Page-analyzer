package gg.jte.generated.ondemand;
import hexlet.code.dto.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.util.NamedRoutes;
public final class JteshowAllGenerated {
	public static final String JTE_NAME = "showAll.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,7,7,8,8,10,10,11,11,18,18,20,20,20,21,21,21,21,21,21,21,21,21,21,21,21,22,22,22,24,24,27,27,28,28,28,28,28,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    ");
				if (page.getUrls().isEmpty()) {
					jteOutput.writeContent("\r\n        <h2>Нет сохраненных ссылок</h2>\r\n    ");
				}
				jteOutput.writeContent("\r\n    ");
				if (!page.getUrls().isEmpty()) {
					jteOutput.writeContent("\r\n        <table class=\"table table-striped\">\r\n            <tr>\r\n                <th scope=\"col\">ID</th>\r\n                <th scope=\"col\">Name</th>\r\n                <th scope=\"col\">Created</th>\r\n            </tr>\r\n            ");
					for (Url url : page.getUrls()) {
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
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(String.valueOf(url.getCreatedAt()));
						jteOutput.writeContent("</td>\r\n                </tr>\r\n            ");
					}
					jteOutput.writeContent("\r\n        </table>\r\n\r\n    ");
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
