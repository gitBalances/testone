function cambiar_login(code) {
    document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
    document.querySelector('.cont_form_login').style.display = "block";
    document.querySelector('.cont_form_sign_up').style.opacity = "0";
    setTimeout(function () {
        document.querySelector('.cont_form_login').style.opacity = "1";
    }, 400);
    setTimeout(function () {
        document.querySelector('.cont_form_sign_up').style.display = "none";
    }, 200);
    sign_up_code=code;
    code = 1;
    login_code=code;
}

var login_code;
var sign_up_code;

function cambiar_sign_up(code) {
    document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
    document.querySelector('.cont_form_sign_up').style.display = "block";
    document.querySelector('.cont_form_login').style.opacity = "0";
    setTimeout(function () {
        document.querySelector('.cont_form_sign_up').style.opacity = "1";
    }, 100);
    setTimeout(function () {
        document.querySelector('.cont_form_login').style.display = "none";
    }, 400);
    login_code=code;
    code=1;
    sign_up_code = code;
}




function ocultar_login_sign_up() {
    document.querySelector('.cont_forms').className = "cont_forms";
    document.querySelector('.cont_form_sign_up').style.opacity = "0";
    document.querySelector('.cont_form_login').style.opacity = "0";
    setTimeout(function () {
        document.querySelector('.cont_form_sign_up').style.display = "none";
        document.querySelector('.cont_form_login').style.display = "none";
    }, 500);
}