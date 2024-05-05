document.addEventListener("DOMContentLoaded", function(){
    
    var canvas = document.querySelector("canvas");
    var c = canvas.getContext("2d");
    var arrayColor = ["#FFDE54","#E89364","#FF61C7","#55479C","#54E0FF"];

    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    const minRadius = 5;
    const maxRadius = 80;

    var mouse = {
        x: undefined,
        y: undefined
    }

    window.addEventListener("resize", function(){
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
        init();
    });

    document.addEventListener("mousemove", function(event){
        console.log(event);
        mouse.x = event.clientX;
        mouse.y = event.clientY;
    });

    document.addEventListener("mouseout", function(event){
        mouse.x = undefined;
        mouse.y = undefined;
    });

    function Circle(x, y, radius, color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.velocity = {
            x: Math.random()*4 - 2,
            y: Math.random()*4 - 2
        }
    }

    Circle.prototype.draw = function(){
        // ham khoi tao ve
         c.beginPath();

         // ham ve hinh tron
        c.arc(this.x, this.y, this.radius, 0, 2*Math.PI);
        // to mau hinh tron
        c.fillStyle = this.color;

        // Tao bong do
        c.shadowColor = this.color;
        c.shadowBlur = 20;

        // goi ham fill() de ve
        c.fill();

         // ham close ve
         c.closePath();

         // Ve test
        c.beginPath();
        c.font = "30px source sans pro";
        c.fillStyle = "tomato";
        c.textAlign = "center";
        c.shadowColor = "white";
        c.shadowBlur = 5;
        c.fillText("ThuongTX", mouse.x, mouse.y);
        c.fill();
        c.closePath();
        c.restore();
    }

    Circle.prototype.update = function(){
        this.x += this.velocity.x;
        this.y += this.velocity.y;

        if(mouse.x - this.x < 90 && mouse.x - this.x > -90 && mouse.y - this.y < 90 && mouse.y - this.y > -90){
            if(this.radius < maxRadius){
                this.radius += 8;
            }
        } else {
            if(this.radius > minRadius){
                this.radius -= 5;
                this.x += this.velocity.x*8;
                this.y += this.velocity.y*8;
            }
        }
        this.collision();
        this.draw();
    }

    Circle.prototype.collision = function(){
        if(this.x >= canvas.width  || this.x <= 0){
            this.velocity.x = -this.velocity.x;
        }
        if(this.y >= canvas.height  || this.y <= 0){
            this.velocity.y = -this.velocity.y;
        }
    }

    let arrayCircles;
    function init(){
        arrayCircles = [];
        let x;
        let y;
        let colorIndex;
        for(let i=0; i<500; i++){
            x = Math.random()*canvas.width;
            y = Math.random()*canvas.height;
            colorIndex =  Math.floor(Math.random()*arrayColor.length);
            arrayCircles.push(new Circle(x, y, minRadius, arrayColor[colorIndex]));
        }
    }

    function animate(){
        //ham nay la de qui goi lai lien tuc ham nay 60 lan trong 1s
        window.requestAnimationFrame(animate);

        c.clearRect(0,0,canvas.width, canvas.height);

        arrayCircles.forEach(element => {
            element.update(); 
        });
    }

    init();
    animate();

});
