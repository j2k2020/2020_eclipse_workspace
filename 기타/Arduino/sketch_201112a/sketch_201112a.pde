int xpos, ypos;
int xdir, ydir;
int padx, padWidth;
int pady, padHeight;

void setup(){
size(800,600);
xpos = ypos = 400;
xdir = ydir = 3;
padWidth = 150 ;
padHeight = 30;
stroke(color(#D324CB));
strokeWeight(3);

fill(color(#FFDC0F));
line(0,50,width,50);
}

void draw(){
background(200);
line(0,height-100,width,height-100);
ellipse(xpos, ypos, 20, 20);
ellipse(xpos, ypos, 1, 1);

xpos += xdir;
ypos += ydir;

padx = mouseX;
if( mouseY > height-100) pady = mouseY;
if( mouseY < height-100) pady = height-100;
rect( padx-padWidth/2, pady-padHeight/2, padWidth, padHeight,10);

//bounce check
if( xpos < 0 || xpos > width) xdir *= -1;
if( ypos < 0 || ypos > height) ydir *= -1;

if( mouseY > height-100 && xpos >= padx-padWidth/2 && xpos <= padx + padWidth/2 && ypos > mouseY-padHeight/2 )
ydir *= -1;
if( mouseY < height-100 && xpos >= padx-padWidth/2 && xpos <= padx + padWidth/2 && ypos > height-100-padHeight/2)
ydir *= -1;

println("xpos ypos :");
println(xpos," ",ypos);

//block check

}
