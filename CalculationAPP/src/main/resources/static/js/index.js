
document.addEventListener('DOMContentLoaded', () => {
    const display = document.getElementById('number');

    document.querySelectorAll('.buttons').forEach(button => {
        button.addEventListener('click', () => {
            display.value += button.textContent;
        });
    });

    document.querySelectorAll('.calc_button').forEach(button => {
        button.addEventListener('click', () => {
            display.value += ' ' + button.textContent + ' ';
        });
    });
});


