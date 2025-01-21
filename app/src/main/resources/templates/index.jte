@import hexlet.code.dto.BasePage
@param BasePage page

@template.layout.page(
    page = page,
    content = @`
        <form class="row row-cols-lg-auto g-3 align-items-center" action="/urls" method="post">
            <div class="col-12">
                <label class="visually-hidden" for="inputUrl"></label>
                <input type="text" class="form-control" required name="url" id="inputUrl" placeholder="Ссылка">
            </div >
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Проверить</button>
            </div>
        </form>
`)