<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            const filename = $('#filename').val();
            let alertMessage = "";
            if (filename === "") {
                alertMessage = "Необходимо выбрать файл";
            }
            if (alertMessage !== "") {
                alert(alertMessage);
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Загрузить фото для кандидата <c:out value="${param.name}"/></h2>
    <form action="<c:url value='/upload.do?id=${param.id}'/>" method="post" enctype="multipart/form-data" onsubmit="return validate();">
        <div class="checkbox">
            <input type="file" name="file" id="filename">
        </div>
        <button type="submit" class="btn btn-default">Загрузить</button>
    </form>
</div>

</body>
</html>
