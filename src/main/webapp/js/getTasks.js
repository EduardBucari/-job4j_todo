function getTasks() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/todo/getTasks.do',
        dataType: 'json'
    }).done(function (data) {
        let row = '';
        let checked = '';
        for (let item of data) {
            if (item.done !== true || $('#showAllTasks').is(':checked')) {
                checked = '';
                row += '<tr>';
                row += '<td>';
                row += '<div class="form-check">';
                if (item.done) {
                    checked = ' checked';
                }
                row += '<input class="form-check-input" type="checkbox" id="' + item.id
                    +'" onclick="changeTaskStatus(' + item.id + ',' + item.done + ')"' + checked +'>';
                row += '<label class="form-check-label" for="' + item.id +'">';
                row += item.task;
                row += '</label>';
                row += '</div>';
                row += '</td>';
                row += '<td>';
                row += item.description;
                row += '</td>';
                row += '<td>';
                row += item.user.name;
                row += '</td>';
                row += '</tr>';
            }
        }
        $('#tablerows').html(row);
    }).fail(function (err) {
        console.log(err);
    });
}