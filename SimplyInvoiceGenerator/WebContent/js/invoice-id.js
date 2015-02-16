var d = new Date();
function f(n) { return n < 10 ? '0' + n : n; }  
var random_num = Math.floor(Math.random() * (99999999999 -  10000000000)) + 10000000000;
random_num = "FW/" + d.getFullYear() + f(d.getMonth()+1) + f(d.getDate()) + "/" + d.getHours() + d.getMinutes() + d.getSeconds() + d.getMilliseconds();
document.getElementsByName("invoice-no")[0].value = random_num;