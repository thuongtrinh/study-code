document.addEventListener("DOMContentLoaded", function(){
    var body = document.body;
    var arrayColor = ["#AAC6F0", "#AAF03C", "#BB87B4", "#2CCDDC", "#B77C8E"];

    setInterval(createStar, 50);

    function createStar(){
        var right = Math.floor(Math.random()*screen.width);
        var top = Math.floor(Math.random()*screen.height);

        var star = document.createElement("div");
        star.classList.add("star");
        star.style.background=arrayColor[Math.floor(Math.random()*6)];

        body.appendChild(star);
        setInterval(runStar, 50);
        star.style.top = top + "px";
        function runStar(){
            right +=3;
            star.style.right = right  + "px";
            if(right > screen.width){
                star.remove();
            }
        }

        setTimeout(function(){
            star.remove();
        }, 8000);
    }

});
