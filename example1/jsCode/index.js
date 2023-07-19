function colorChange2(id, color) {
    document.getElementById(id).style.color=color;
}

function star() {
    document.getElementById("starId").innerHTML += "⭐";
}

function minus() {
    let s = document.getElementById("starId").innerHTML;
    if (s.length > 4) {
        document.getElementById("starId").innerHTML=s.substring(0,(s.length-1));
    }
}