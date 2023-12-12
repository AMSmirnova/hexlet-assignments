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
                @if (page.getCurrentPageNumber() > 1)
                    <a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPageNumber() - 1}">назад</a>
                @endif
                @if (page.getCurrentPageNumber() < page.getMaxPage())
                    <a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPageNumber() + 1}">вперед</a>
                @endif
            </div>
        </main>
    </div>

    `
)