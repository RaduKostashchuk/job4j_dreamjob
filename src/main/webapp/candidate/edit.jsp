<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.store.DbStore" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
    <script>
        function validate() {
            const name = $('#nameInput').val();
            const cityName = $('#citySelect').val();
            let alertMessage = "";
            if (name === "") {
                alertMessage = "Имя кандидата не должно быть пустым\n";
            }
            if (cityName === "Выберите город") {
                alertMessage += "Необходимо выбрать город";
            }
            if (alertMessage !== "") {
                alert(alertMessage);
                return false;
            }
                return true;
            }
    $(document).ready(function () {
        $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dreamjob/city.do',
        dataType: 'json'
    }).done(function (data) {
        for (let city of data) {
        $('#citySelect option:last').after(`<option value=${city.id}>${city.name}</option>`)
        }
    }).fail(function (err) {
        console.log(err);
    });
    });
    </script>
    <title>Работа мечты</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    Candidate candidate = new Candidate(0, "");
    if (id != null) {
        candidate = DbStore.instOf().findCandidateById(Integer.parseInt(id));
    }
%>
<div class="container pt-2">
    <jsp:include page="/menubar.jsp"/>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новый кандидат
                <% } else { %>
                Редактирование кандидата
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidates.do?id=<%=candidate.getId()%>" method="post" onsubmit="return validate()">
                    <div class="form-group col-sm-5">
                        <label>Имя</label>
                        <input type="text" class="form-control" id="nameInput" name="name" value="<%=candidate.getName()%>">
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="citySelect">Город</label>
                        <select class="custom-select" id="citySelect" name="cityId">
                            <option selected>Выберите город</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
