@import hexlet.code.dto.BasePage
@param BasePage page

@template.layout.page(
    page = page,
    content = @`
        <form class="row g-3" action="/urls" method="post">
            <div class="col-auto">
                <label for="inputUrl" class="sr-only"></label>
                <input type="text" class="form-control" required name="url" id="inputUrl" placeholder="Ссылка">
            </div >
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Проверить</button>
            </div>
        </form>
`)