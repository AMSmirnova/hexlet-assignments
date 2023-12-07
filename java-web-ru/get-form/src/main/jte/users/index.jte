@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>

    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        <ul>
            @for(var user : page.getUsers())
                <li><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></li>
            @endfor
        </ul>
    @endif
    `
)
