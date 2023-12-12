@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page


@template.layout.page(
    content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все посты</h1>

            <table>
                @for(var post : page.getPosts())
                    <tr>
                        <td>
                            <a href="${NamedRoutes.postsPath()}/${post.getId()}">${post.getName()}</a>
                            
                        </td>
                        
                    </tr>
                @endfor
            </table>
            <div>
                <a href="${NamedRoutes.postsPath()}?page=${page.getPageNumber() - 1}">назад</a>
                <a href="${NamedRoutes.postsPath()}?page=${page.getPageNumber() + 1}">вперед</a>
            </div>
        </main>
    </div>

    `
)