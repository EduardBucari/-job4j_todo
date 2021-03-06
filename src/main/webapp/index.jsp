<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
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

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>

    <script type="text/javascript" src="js/validateAddTask.js"></script>

    <script type="text/javascript" src="js/addTask.js"></script>

    <script type="text/javascript" src="js/getTasks.js"></script>

    <script type="text/javascript" src="js/changeTaskStatus.js"></script>

    <script>
        $(document).ready(
            getTasks()
        );
    </script>

    <title>Tasks TODO</title>

</head>
<body>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <ul class="nav nav-pills nav-fill">
                    <li class="nav-item">
                        Новая задача
                    </li>
                    <c:if test="${user == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/login.jsp">Войти</a>
                        </li>
                    </c:if>
                    <c:if test="${user != null}">
                        <li class="nav-item">
                            <c:out value="Пользователь: ${user.name}"/>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/logout.do">Выйти</a>
                        </li>
                    </c:if>
                </ul>
            </div>
            <div class="card-body">
                <form id="form" name="form">
                    <div class="form-group">
                        <label for="task">Задача</label>
                        <input type="text" class="form-control" name="task" id="task">
                    </div>
                    <div class="form-group">
                        <label for="description">Описание</label>
                        <textarea class="form-control" name="description" id="description" rows="1"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="categories">Категория</label>
                        <div class="col-sm-2">
                            <select class="form-control" name="categories" id="categories" multiple>
                                <c:forEach items="${categories}" var="category">
                                    <option value='<c:out value="${category.id}"/>'><c:out value="${category.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <input type="hidden" name="userEmail" id="userEmail" value="<c:out value='${user.email}'/>">
                    <button type="submit" class="btn btn-primary" onclick="addTask()">Добавить</button>
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <div class="container">
                    <div class="row">
                        <div class="col align-self-start">
                            Список задач
                        </div>
                        <div class="col align-self-end">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="showAllTasks" onclick="getTasks()">
                                <label class="form-check-label" for="showAllTasks">
                                    Показать все задачи
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <div class="container">
                    <table class="table table-hover" id="table">
                        <thead>
                        <tr>
                            <th>Задача</th>
                            <th>Описание</th>
                            <th>Категория</th>
                            <th>Создана</th>
                            <th>Автор</th>
                        </tr>
                        </thead>
                        <tbody id="tablerows">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
