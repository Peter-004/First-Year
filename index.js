//Greeting the user
var greet = document.getElementById("timeofday");
let day = new Date();
let hr = day.getHours();


if(hr > 1 && hr < 12){
    greet.innerHTML = "Morning";
}
else if(hr > 11 && hr < 19){
    greet.innerHTML = "Afternoon";
}
else{
    greet.innerHTML = "Evening";
}

t0ggle = document.querySelector(".t0ggle");
menucontent = document.querySelector(".menucontents");

t0ggle.addEventListener("click", () => {
    t0ggle.classList.toggle("active");
    menucontent.classList.toggle("active");
})