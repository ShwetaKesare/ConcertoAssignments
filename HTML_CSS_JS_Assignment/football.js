var canvas = document.getElementById("mycanvas");
var ctx = canvas.getContext("2d"); 
ctx.lineWidth = 2;
ctx.strokeStyle="white"; 

function footballfield()
{
    middleline();
    middlecircle();
    leftrect();
    rightrect();
}
function middleline()
{
    ctx.beginPath();    
      ctx.moveTo(canvas.width / 2, 0);
      ctx.lineTo(canvas.width / 2, canvas.height);
      ctx.stroke();
      ctx.closePath();      
}

function middlecircle()
{
    var canvas = document.getElementById("mycanvas");
    var ctx = canvas.getContext("2d"); 
    ctx.beginPath();    
    ctx.lineWidth = 2;
    ctx.strokeStyle="white";     
    ctx.arc((canvas.width)/2,(canvas.height)/2,90,0,(Math.PI)*2,true);      
    ctx.stroke()  ;
    ctx.closePath();

    ctx.beginPath();    
    ctx.fillStyle="white";
    ctx.arc((canvas.width)/2,(canvas.height)/2,10,0,(Math.PI)*2,true);      
    ctx.fill();
    ctx.closePath();
}

function leftrect()
{
    var canvas = document.getElementById("mycanvas");
    var ctx = canvas.getContext("2d"); 
    ctx.lineWidth = 2;
    ctx.strokeStyle="white";     

    ctx.beginPath();    
    ctx.rect(0,(canvas.height / 4), 130, 320);
    ctx.stroke() ;
    ctx.closePath();

    ctx.beginPath();    
    ctx.rect(0, (canvas.height/2.6), 65, 160);
    ctx.stroke() ;
    ctx.closePath();

    ctx.beginPath(); 
    ctx.fillStyle="white"   ;
    ctx.arc((canvas.height/6), (canvas.height/2), 5, 0,Math.PI*2,true);
    ctx.fill() ;
    ctx.closePath();

    ctx.beginPath(); 
    ctx.strokeStyle="white"   ;
    ctx.arc(90,(canvas.height/1.95), 100, Math.PI*0.37,Math.PI*1.63,true);
    ctx.stroke() ;
    ctx.closePath();
}

function rightrect()
{
    var canvas = document.getElementById("mycanvas");
    var ctx = canvas.getContext("2d"); 
    ctx.lineWidth = 2;
    ctx.strokeStyle="white";     

    ctx.beginPath();    
    //ctx.rect(0,(canvas.height / 4), 130, 320);
    ctx.rect(canvas.width-130,(canvas.height / 4), 130, 320);
    ctx.stroke() ;
    ctx.closePath();

    ctx.beginPath();    
    //ctx.rect(0, (canvas.height/2.6), 65, 160);
    ctx.rect(canvas.width-65, (canvas.height/2.6), 65, 160);

    ctx.stroke() ;
    ctx.closePath();

     ctx.beginPath(); 
    ctx.fillStyle="white"   ;
    ctx.arc((canvas.width-(canvas.height/6)), (canvas.height/2), 5, 0,Math.PI*2,true);
    ctx.fill() ;
    ctx.closePath();

    ctx.beginPath(); 
    ctx.strokeStyle="white"   ;
    ctx.arc((canvas.width-90),(canvas.height/1.95), 100, Math.PI*0.63,Math.PI*1.37,false);
    ctx.stroke() ;
    ctx.closePath(); 
    
}

