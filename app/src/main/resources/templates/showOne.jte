@import hexlet.code.dto.UrlPage
@param UrlPage page

@template.layout.page(
    page = page,
    content = @`
        <table class="table">
            <tr>
                <th>ID</th>
                <td>${page.getUrl().getId()}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${page.getUrl().getName()}</td>
            </tr>
            <tr>
                <th>Created</th>
                <td>${String.valueOf(page.getUrl().getCreatedAt())}</td>
            </tr>
        </table>
    `
)