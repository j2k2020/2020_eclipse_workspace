import processing.serial.*;
Serial port;
void setup(){
  port=new Serial(this, "COM8",9600);
}
int x,y;
int buf[]=new int[5]; //java statement
void draw(){
  if(port.available()>0){
  int c=port.read();
  if(c==0x7E){ //0x7E=126
  int i=0;
  
  while((buf[i++]=port.read())!=0xFE){
    if(i==5) break;
  }
  //for(i=0;i<3;i++) { println(buf[i]);}
  x=(buf[1]<<8)+buf[2];
  println("x:"+x);
  
  y=(buf[3]<<8)+buf[4];
  println("y:"+y);
  
  }
  
  delay(100);
  }
}
