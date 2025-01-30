@import hexlet.code.util.Utils
@import hexlet.code.dto.UrlsPage
@import hexlet.code.model.Url
@import hexlet.code.util.NamedRoutes
@param UrlsPage page

@template.layout.page(
    page = page,
    content = @`
    @if(page.getUrlsAndChecks().keySet().isEmpty())
        <h2>Нет сохраненных ссылок</h2>
    @else
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Имя</th>
                <th scope="col">Последняя проверка</th>
                <th scope="col">Код ответа</th>
            </tr>
            </thead>
            <tbody>
            @for(Url url : page.getUrlsAndChecks().keySet())
                <tr>
                    <td>${url.getId()}</td>
                    <td><a href="${NamedRoutes.urlPage(url.getId())}">${url.getName()}</a></td>
                    <td>@if(page.getUrlsAndChecks().get(url).getCreatedAt() != null)
                            ${Utils.formatDate(page.getUrlsAndChecks().get(url).getCreatedAt())}
                        @endif
                    </td>
                    <td>@if(page.getUrlsAndChecks().get(url).getStatusCode() != 0)
                            ${page.getUrlsAndChecks().get(url).getStatusCode()}
                        @endif
                    </td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
`)