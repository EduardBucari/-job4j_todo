function addTask() {
    if (validateAddTask()) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8081/todo/addTask.do',
            data: {
                task: $('#task').val(),
                description: $('#description').val(),
                userEmail: $('#userEmail').val(),
                'categories[]': $('#categories').val()
            }
        }).done(function (data) {
            document.forms.namedItem('form').reset();
            $('#categories').html($('#categories').val());
            getTasks();
        }).fail(function (err) {
            console.log(err);
        });
    }
}