let hour = document.querySelector('#hr');
let mn = document.querySelector('#min');
let sec = document.querySelector('#sc');
let amp = document.getElementById('apm');

let h = document.querySelector('#h0ur');
let m = document.querySelector('#m1n');
let s = document.querySelector('#s3c');
    
setInterval(function(){
    let day = new Date();
    let hh = day.getHours() * 30;
    let mm = day.getMinutes() * 6;
    let ss = day.getSeconds() * 6;

    hour.style.transform =`rotateZ(${hh+(mm/12)}deg)`;
    mn.style.transform =`rotateZ(${mm}deg)`;
    sc.style.transform = `rotateZ(${ss}deg)`;

    let fizz = day.getHours();
    let buzz = day.getMinutes();
    let fuzz = day.getSeconds();
    
    h.innerHTML = fizz;
    s.innerHTML = fuzz;
    m.innerHTML = buzz;

    if(fizz >= 12){
        amp.innerHTML = 'PM'
        if(fizz > 12){
            h.innerHTML = `0${fizz - 12}`;
        }
    }
    if(fizz < 10){
        h.innerHTML = `0${fizz}`;
    }
    if(buzz < 10){
        m.innerHTML = `0${buzz}`;
    }
    if(fuzz < 10){
        s.innerHTML = `0${fuzz}`;
    }
    
});