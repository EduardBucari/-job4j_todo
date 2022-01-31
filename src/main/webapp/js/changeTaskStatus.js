function changeTaskStatus(id, done) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8081/todo/changeTaskStatus.do',
        dataType: 'html',
        data: {id: id, done: done},
    }).done(function (data) {
        getTasks()
    }).fail(function (err) {
        console.log(err);
    });
}