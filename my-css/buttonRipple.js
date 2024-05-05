document.addEventListener("DOMContentLoaded", function(){
    
    var button1 = document.querySelector("button:nth-child(1)");
    var button2 = document.querySelector("button:nth-child(2)");
    var hover = true;

    button1.addEventListener("click", function(event){
        createRipple(button1, event);
    });

    button2.addEventListener("mousemove", function(event){
        if(hover){
            hover = false;
            createRipple(button2, event);
            setTimeout(function(){
                hover = true;
            }, 100);
        }
    });

    function createRipple(button, event){
        let ripple1 = document.createElement("div");
        let x,y;
        x = event.clientX - button.offsetLeft;
        y = event.clientY - button.offsetTop;
        ripple1.classList.add("ripple");
        ripple1.style.left = x + "px";
        ripple1.style.top = y + "px";

        button.appendChild(ripple1);

        setTimeout(function(){
            ripple1.remove();
        }, 2000)
    }

});