@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        <p>
            <a href="/">Home</a>
            <a href="/users">Users</a>
        </p>
        <p>
            <a href="https://github.com/AMSmirnova">github.com/AMSmirnova</a>
        </p>
        ${content}
    </body>
</html>