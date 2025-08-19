<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Comment</title>
</head>
<body>
    <h3>Add a Comment</h3>
    <form action="CreateCommentServlet" method="post">
        <input type="hidden" name="postId" value="<%= request.getParameter("postId") %>">

        <label>Comment:</label><br>
        <textarea name="content" rows="8" cols="30"></textarea><br>
        <input type="submit" value="Add a Comment">
    </form>

    <button><a href="home.html">Back to Home</a></button>
</body>
</html>
