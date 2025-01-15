package gg.jte.generated.ondemand;
import hexlet.code.dto.BasePage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,15,15,15,15,15,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BasePage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <form class=\"row g-3\" action=\"/urls\" method=\"post\">\r\n            <div class=\"col-auto\">\r\n                <label for=\"inputUrl\" class=\"sr-only\"></label>\r\n                <input type=\"text\" class=\"form-control\" required name=\"url\" id=\"inputUrl\" placeholder=\"Ссылка\">\r\n            </div >\r\n            <div class=\"col-auto\">\r\n                <button type=\"submit\" class=\"btn btn-primary mb-3\">Проверить</button>\r\n            </div>\r\n        </form>\r\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BasePage page = (BasePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
