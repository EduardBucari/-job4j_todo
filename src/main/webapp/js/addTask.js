function addTask() {
    if (validateAddTask()) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8081/todo/addTask.do',
            data: {
                task: $('#task').val(),
                description: $('#description').val(),
                userEmail: $('#userEmail').val()
            },
            dataType: 'html'
        }).done(function (data) {
            document.forms.namedItem('form').reset();
            getTasks();
        }).fail(function (err) {
            console.log(err);
        });
    }
}