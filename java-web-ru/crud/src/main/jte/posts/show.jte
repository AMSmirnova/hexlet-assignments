@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
    content = @`

    <p>
        ${page.getPost().getName()}
    </p>
    <div>
        ${page.getPost().getBody()}
    </div>
    
    <div>
        <a href="${NamedRoutes.postsPath()}">назад</a>
    </div>
    `
)