@import hexlet.code.dto.UrlsPage
@import hexlet.code.model.Url
@import hexlet.code.util.NamedRoutes
@param UrlsPage page

@template.layout.page(
    page = page,
    content = @`
    @if(page.getUrls().isEmpty())
        <h2>Нет сохраненных ссылок</h2>
    @endif
    @if(!page.getUrls().isEmpty())
        <table class="table table-striped">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Created</th>
            </tr>
            @for(Url url : page.getUrls())
                <tr>
                    <th scope="row">${url.getId()}</th>
                    <td><a href="${NamedRoutes.urlPage(url.getId())}">${url.getName()}</a></td>
                    <td>${String.valueOf(url.getCreatedAt())}</td>
                </tr>
            @endfor
        </table>

    @endif
`)