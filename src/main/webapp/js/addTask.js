function addTask() {
    if (validate()) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8081/todo/addTask.do',
            data: JSON.stringify({
                task: $('#task').val(),
                description: $('#description').val()
            }),
            dataType: 'json'
        }).done(function (data) {
            document.forms.namedItem('form').reset();
            getTasks()
        }).fail(function (err) {
            console.log(err);
        });
    }
}