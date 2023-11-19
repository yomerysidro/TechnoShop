let searchForm = document.querySelector('.search-form');
document.querySelector('#search-btn').onclick = () => {
    searchForm.classList.toggle('active');
    shoppingCart.classList.remove('active');
    loginForm.classList.remove('active');
    navBar.classList.remove('active');
}

let shoppingCart = document.querySelector('.shopping-cart');
document.querySelector('#cart-btn').onclick = () => {
    shoppingCart.classList.toggle('active');
    searchForm.classList.remove('active');
    loginForm.classList.remove('active');
    navBar.classList.remove('active');
}
let loginForm = document.querySelector('.login-form');
document.querySelector('#login-btn').onclick = () => {
    loginForm.classList.toggle('active');
    shoppingCart.classList.remove('active');
    searchForm.classList.remove('active');
    navBar.classList.remove('active');

}
let navBar = document.querySelector('.navbar');
document.querySelector('#menu-btn').onclick = () => {
    navBar.classList.toggle('active');
    searchForm.classList.remove('active');
    shoppingCart.classList.remove('active');
    loginForm.classList.remove('active');

}
window.onscroll = () => {
    searchForm.classList.remove('active');
    shoppingCart.classList.remove('active');
    loginForm.classList.remove('active');
    navBar.classList.remove('active');
}




document.addEventListener("DOMContentLoaded", function () {
    var userIcon = document.getElementById("user-icon");
    var dropdownMenu = userIcon.nextElementSibling;

    userIcon.addEventListener("click", function (event) {
        event.stopPropagation(); // Evita que el evento de clic se propague al documento
        dropdownMenu.classList.toggle("hidden");
    });

    // Cierra el menú si se hace clic en cualquier parte del documento
    document.addEventListener("click", function () {
        dropdownMenu.classList.add("hidden");
    });

    // No cierra el menú si se hace clic dentro del menú
    dropdownMenu.addEventListener("click", function (event) {
        event.stopPropagation();
    });
});