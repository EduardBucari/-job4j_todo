function validateAddTask() {
    let result = '';
    if ($('#task').val() === '') {
        result = result + 'Введите задачу' + '\n';
    }
    if ($('#description').val() === '') {
        result = result + 'Введите описание задачи' + '\n';
    }
    if (result != '') {
        alert(result);
        return false
    }
    return true;
}