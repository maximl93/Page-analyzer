@import hexlet.code.util.Utils
@import hexlet.code.util.NamedRoutes
@import hexlet.code.model.UrlCheck
@import hexlet.code.dto.UrlPage
@param UrlPage page

@template.layout.page(
    page = page,
    content = @`

        <table class="table table-bordered">
            <tr>
                <th>ID</th>
                <td>${page.getUrl().getId()}</td>
            </tr>
            <tr>
                <th>Имя</th>
                <td>${page.getUrl().getName()}</td>
            </tr>
            <tr>
                <th>Дата создания</th>
                <td>${Utils.formatDate(page.getUrl().getCreatedAt())}</td>
            </tr>
        </table>

        <h2>Поверки</h2>
    
        <form action="${NamedRoutes.urlCheck(page.getUrl().getId())}" method="post">
            <button type="submit" class="btn btn-primary">Запустить проверку</button>
        </form>

    @if(page.getChecks().isEmpty())
        <h2>Ссылка не проверялась</h2>
    @else
        <table class="table table-hover table-bordered mt-3">
            <thead>
            <tr>
                <th scope="row">ID</th>
                <th scope="row">Код ответа</th>
                <th scope="row">title</th>
                <th scope="row">h1</th>
                <th scope="row">description</th>
                <th scope="row">Дата проверки</th>
            </tr>
            </thead>
            <tbody class="table-group-divider">
            @for(UrlCheck check : page.getChecks())
                <tr>
                    <td>${check.getId()}</td>
                    <td>${check.getStatusCode()}</td>
                    <td>${check.getTitle()}</td>
                    <td>${check.getH1()}</td>
                    <td>${check.getDescription()}</td>
                    <td>${Utils.formatDate(check.getCreatedAt())}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif

    `
)