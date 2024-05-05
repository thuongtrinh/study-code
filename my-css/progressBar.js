document.addEventListener("DOMContentLoaded", function(){

    var progressBar = document.querySelectorAll(".progress-bar");
    var time = 1500;

    progressBar.forEach(element => {
        let label = element.children[0];
        let line = element.children[1];
        let spanPercent = line.children[0];
        
        let dataCount = label.getAttribute("data-count");

        let widthOnePercent = line.style.width.substr(0, line.style.width.length-2)/100;
        let runTime = calculateTime(time, dataCount);

        let count = 0;
        let countSpan = 0;
        let animationPercent = setInterval(() => {
            if(count < dataCount){
                countSpan += widthOnePercent;
                spanPercent.style.width = countSpan + "px";
                count++;
                label.innerHTML = count + "%";
                spanPercent.style.shadowBlur = "3";
                if(count > (dataCount/3*2) && count < dataCount-1){
                    spanPercent.style.background = "orange";
                    spanPercent.style.boxShadow="0px 0px 10px 1px orange"
                } else if(count == dataCount-1){
                    spanPercent.style.background = "rgb(11, 238, 11)";
                    spanPercent.style.boxShadow = "0px 0px 10px 1px rgb(11, 238, 11)"
                }
            } else {
                clearInterval(animationPercent);
            }
        }, runTime);
    });

    function calculateTime(time, width){
        return time/width;
    }
});