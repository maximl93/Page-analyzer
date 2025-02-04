@import hexlet.code.util.NamedRoutes
@import hexlet.code.dto.BasePage
@param BasePage page

@template.layout.page(
    page = page,
    content = @`
    <div class="mx-auto">
        <h1>Анализатор страниц</h1>
        <p>Скопируйте ссылку в поле ввода и сохраните для дальнейшей проверки на SEO пригодность.</p>
        <form class="row row-cols-lg-auto g-3 align-items-center" action="${NamedRoutes.allUrlsPage()}" method="post">
            <div class="col-sm-7">
                <label class="visually-hidden" for="inputUrl"></label>
                <input type="text" class="form-control" required name="url" id="inputUrl" placeholder="Ссылка">
            </div >
            <div class="col-auto">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </form>
    </div>
`)