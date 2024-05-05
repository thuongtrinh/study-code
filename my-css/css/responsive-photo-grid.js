
function getRandomSize(min, max) {
    return Math.round(Math.random() * (max - min) + min);
}

var allImages = "";

for (var i = 0; i < 30; i++) {
    var width = getRandomSize(200, 400);
    var height = getRandomSize(200, 400);
    allImages += '<img src="https://placekitten.com/' + width + '/' + height + '" alt="pretty kitty">';
    // allImages += '<img src="https://loremflickr.com/' + width + '/' + height + '/nature" alt="pretty natural">';
}

$('#photos').append(allImages);

// function callback() {
//     $("#content").append('This is my gallery');
// };


$(document).ready(function () {
    // window.setTimeout(callback, 100);
    $('#photos').append(allImages);
});