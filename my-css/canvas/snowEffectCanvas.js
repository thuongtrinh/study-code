document.addEventListener("DOMContentLoaded", function(){

    var canvas = document.querySelector("canvas");
    var c = canvas.getContext("2d");

    canvas.height = window.innerHeight;
    canvas.width = window.innerWidth;

    window.addEventListener("resize", function(){
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
    });

    function Snow(x, y, radius, color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.velocity = {
            x: Math.random()*4 - 2,
            y: Math.random()*3 + 2
        }
    }

    Snow.prototype.draw = function(){
        c.beginPath();
        c.arc(this.x, this.y, this.radius, 0, 2*Math.PI);
        c.fillStyle = this.color;
        c.fill();
        c.closePath();
        c.restore();
    }

    Snow.prototype.updatePosition = function(){
        this.x += this.velocity.x;
        this.y += this.velocity.y;
        this.snowOnEarth();
        this.draw();
    }

    Snow.prototype.snowOnEarth = function(){
        if(this.y >= canvas.height){
            this.velocity.y = 0;
        }
    }

    let arraySnow = [];
    function init(){
        let spaceX;
        let spaceY;
        let radius;

        radius = Math.ceil(Math.random()*4);
        spaceX = Math.random()*canvas.width;
        spaceY = -radius;
        arraySnow.push(new Snow(spaceX, spaceY, radius, "white"));
    }

    function animate(){
        window.requestAnimationFrame(animate);
        c.clearRect(0, 0, canvas.width, canvas.height);
        init();

        arraySnow.forEach(element => {
            element.updatePosition();
        });

        console.log(arraySnow.length);
        if(arraySnow.length >= 400){
            arraySnow.splice(0, 1);
        }
    }

    animate();
});
