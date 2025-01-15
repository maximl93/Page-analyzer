@import hexlet.code.util.NamedRoutes
@import hexlet.code.dto.BasePage
@import gg.jte.Content
@param Content content
@param BasePage page


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <title>Main page</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <h3 class="navbar-brand">Анализатор страниц</h3>
            <button class="navbar-toggler" type="button"
                    data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.mainPage()}">Главная</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${NamedRoutes.allUrlsPage()}">Все сайты</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <main>
        @if(page != null && page.getFlashMessage() != null)
            <div class="alert alert-${page.getMessageType()}" role="alert">
                ${page.getFlashMessage()}
            </div>
        @endif
        <div>
            ${content}
        </div>
    </main>

    <footer class="footer text-center text-white bg-dark fixed-bottom">
        <div class="container">
                <p class="pt-2">Данный сайт является учебным проектом.</p>
                <p><a class="text-white" href="https://github.com/maximl93">Мой Git</a></p>
        </div>
    </footer>
</body>
</html>