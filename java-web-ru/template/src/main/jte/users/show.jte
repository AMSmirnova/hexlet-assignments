@import exercise.dto.users.UserPage
@param UserPage page


<html lang="en">
    <head>

    </head>
    <body>
            <p>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
            <p>email: ${page.getUser().getEmail()}</p>
    </body>
</html>

