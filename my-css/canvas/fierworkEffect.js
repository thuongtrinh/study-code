
document.addEventListener("DOMContentLoaded", function(){

    var canvas = document.querySelector("canvas");
    var c = canvas.getContext("2d");

    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    window.addEventListener("resize", function(){
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
        init();
    });

    var Config = {
        size: 3,
        number: 20,
        fill: 0.1
    }
    var resetConf = document.querySelector("#reset");
    var sizeConf = document.querySelector("#size");
    var numberConf = document.querySelector("#number");
    var fillConf = document.querySelector("#fill");

    sizeConf.addEventListener("change", function(event){
        Config.size = sizeConf.value;
    });

    numberConf.addEventListener("change", function(event){
        Config.number = numberConf.value;
    });

    fillConf.addEventListener("change", function(event){
        Config.fill = fillConf.value;
    });

    resetConf.addEventListener("click", function(){
        Config.size = 3;
        Config.number = 20;
        Config.fill = 0.1;
        sizeConf.value = 3;
        numberConf.value = 20;
        fillConf.value = 0.1;
    });

    function Fierwork(x, y, radius, color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.maxY = Math.random()*(canvas.height/5);// + canvas.height/50;
        this.life = true;
        this.velocity = {
            x: Math.random()*6-3,
            y: Math.random()*3+3
        }
    }

    Fierwork.prototype.draw = function(c){
        c.beginPath();
        c.arc(this.x, this.y, this.radius, 0, Math.PI*2);
        c.fillStyle = this.color;
        c.fill();
        c.closePath();
        c.restore();
    }

    Fierwork.prototype.maximumY = function(){
        //alert(canvas.height/5);
        if(this.maxY > 135){
            alert(this.maxY);
        }
        if(this.y <= this.maxY || this.x <=0 || this.x >= canvas.width){
            this.life = false;
            for(let i=0; i<10; i++){
                arraySpark.push(new Spark(this.x, this.y, this.radius, this.color));
            }
        }
    }

    Fierwork.prototype.update = function(c){
        this.x += this.velocity.x;
        this.y -= this.velocity.y;
        this.maximumY();
        this.draw(c);
    }

    function Spark(x, y, radius, color){
        this.x = x;
        this.y = y;
        this.radius = radius/2;
        this.color = color;
        this.velocity = {
            x: Math.random()*3-1,
            y: Math.random()*3-1
        }
        this.friction = 0.015;
        this.timeLife = 150;
    }

    Spark.prototype.draw = function(c){
        c.beginPath();
        c.arc(this.x, this.y, this.radius, 0, Math.PI*2);
        c.fillStyle = this.color;
        c.fill();
        c.closePath();
        c.restore();
    }

    Spark.prototype.update = function(c){
        this.x += this.velocity.x;
        this.y -= this.friction;
        this.y -= this.velocity.y;
        this.draw(c);
        this.timeLife--;
    }

    var arrayFierwork = [];
    var arraySpark = [];
    var arrayColor = ["#FFDE54", "#E89364", "#FF61C7", "#55479C", "#54E0FF", "#FFFFFF", "#EFB900", "#63EA95", "#FF0932"];

    function init(){
        let radius;
        let xDistance;
        let yDistance;
        let codeColor;
        if(arrayFierwork.length < Config.number){
            radius = Math.ceil(Math.random()*Config.size);
            xDistance = canvas.width/2;
            yDistance = canvas.height + radius;
            codeColor = arrayColor[Math.floor(Math.random()*arrayColor.length)];
            arrayFierwork.push(new Fierwork(xDistance, yDistance, radius, codeColor));
        }
    }

    function animate(){
        let canvasHeight = canvas.height;
        let up = canvasHeight-200;
        window.requestAnimationFrame(animate);
        //c.clearRect(0,0,canvas.width,canvas.height);
        c.fillStyle = `rgba(0, 0, 0, ${Config.fill})`;
        c.fillRect(0,0,canvas.width,canvas.height);
        
        arrayFierwork.forEach((element, index)=>{
            if(!element.life){
                arrayFierwork.splice(index, 1);
            } else {
                element.update(c);
            }
        });

        arraySpark.forEach((element, index)=>{
            if(element.timeLife <=0 ){
                arraySpark.splice(index, 1);
           } else {
                element.update(c);
           }
        });
        init();
    }

    animate();
});
