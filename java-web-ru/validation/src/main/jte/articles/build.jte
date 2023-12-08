@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div>
            <label>
                Заголовок
                <input type="title" required name="title" />
            </label>
        </div>
        <div>
            <label>
                Статья
                <textarea type="content" required name="content"></textarea>

            </label>
        </div>
        <input type="submit" value="Опубликовать" />
    </form>
`
)