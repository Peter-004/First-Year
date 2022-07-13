t0ggle = document.querySelector(".t0ggle");
menucontent = document.querySelector(".menucontents");

t0ggle.addEventListener("click", () => {
    t0ggle.classList.toggle("active");
    menucontent.classList.toggle("active");
})