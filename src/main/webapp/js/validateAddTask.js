function validateAddTask() {
    let result = '';
    if ($('#task').val() === '') {
        result = result + 'Введите задачу' + '\n';
    }
    if ($('#description').val() === '') {
        result = result + 'Введите описание задачи' + '\n';
    }
    if ($('#categories').val().length === 0) {
        result = result + 'Выберите хотя бы одну категорию' + '\n';
    }
    if (result != '') {
        alert(result);
        return false
    }
    return true;
}