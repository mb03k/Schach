document.getElementById("headerListButton").onclick = function() {
    openList();
}

document.getElementById("headerInstagramButton").onclick = function() {
    openInstagram();
}

document.getElementById("headerGithubButton").onclick = function() {
    openGithub();
}

function openList() {
    console.log("openList()");
}

function openInstagram() {
    window.open("https://www.instagram.com/mb21y_/");
}

function openGithub() {
    window.open("https://www.github.com/mb03k/");
}