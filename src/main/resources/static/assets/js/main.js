// JavaScript
const showMenu = (toggleId, navbarId, bodyId) => {
    const toggle = document.getElementById(toggleId),
        navbar = document.getElementById(navbarId),
        body = document.body;

    if(toggle && navbar) {
        toggle.addEventListener('click', () => {
            navbar.classList.toggle('expander');
            body.classList.toggle('expanded-sidebar'); // 바디에 클래스 추가/제거
        });
    }
};

showMenu('nav-toggle', 'navbar', 'body-pd');

/* LINK ACTIVE */
const linkColor = document.querySelectorAll('.nav__link');
function colorLink() {
    linkColor.forEach(l => l.classList.remove('active'));
    this.classList.add('active');
}
linkColor.forEach(l => l.addEventListener('click', colorLink));

/* COLLAPSE MENU */
const linkCollapse = document.getElementsByClassName('collapse__link');
for(let i = 0; i < linkCollapse.length; i++) {
    linkCollapse[i].addEventListener('click', function() {
        const collapseMenu = this.parentElement.querySelector('.collapse__menu');
        collapseMenu.classList.toggle('showCollapse');

        const rotate = this;
        rotate.classList.toggle('rotate');
    });
}