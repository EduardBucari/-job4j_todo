function validateRegister() {
    let result = '';
    if ($('#email').val() === '') {
        result = result + 'Введите электронную почту' + '\n';
    }
    if ($('#username').val() === '') {
        result = result + 'Введите имя' + '\n';
    }
    if ($('#password').val() === '') {
        result = result + 'Введите пароль' + '\n';
    }
    if (result != '') {
        alert(result);
        return false
    }
    return true;
}