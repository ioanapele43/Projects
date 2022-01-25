import processing.serial.*;

Serial mySerial;

String myString1;
int nl=10;
float myVal1;
int val=0;

void setup(){
    size(1000,600);
    String myPort=Serial.list()[0];
    mySerial=new Serial(this,myPort,9600);
}
void draw(){
   while(mySerial.available()>0){
    myString1=mySerial.readStringUntil(nl);
    
    if(myString1!=null){
       background(0);
       myVal1=float(myString1);
       textSize(25);
       text("Camera",10,20);
       rectMode(CENTER);
       
       fill(255,255,255);//alb
       rect(350,200,600,300);
        
       
        
if(myVal1==11){
          fill(179, 0, 0);//rosu
         rect(100,89,100,75);  
         text("a intrat in zona 11 ",10,450);
       }
       else if(myVal1==12){
         fill(255, 0, 0);//rosu
         rect(200,89,100,75); 
         text("a intrat in zona 12 ",10,450);
       }
       else if(myVal1==13){
          fill(255, 64, 0);//rosu
         rect(300,89,100,75);  
         text("a intrat in zona 13 ",10,450);
       }
       else if(myVal1==14){
         fill(255, 191, 0);//rosu
         rect(500,89,100,75); 
         text("a intrat in zona 14 ",10,450);
       }
       else if(myVal1==15){
         fill(255, 191, 0);//rosu
         rect(550,150,100,75); 
         text("a intrat in zona 15 ",10,450);
       }
       else if(myVal1==16){
         fill(255, 255, 0);//rosu
         rect(600,89,100,75);
         text("a intrat in zona 16 ",10,450);
       }
       else if(myVal1==21){
         fill(179, 0, 0);//rosu
         rect(100,164,100,75); 
         text("a intrat in zona 21 ",10,450);
       }
    else if(myVal1==22){
         fill(255, 0, 0);//rosu
         rect(200,164,100,75);
         text("a intrat in zona 22 ",10,450);
       }
        else if(myVal1==23){
         fill(255, 64, 0);//rosu
         rect(300,164,100,75); 
         text("a intrat in zona 23 ",10,450);
       }
       else if(myVal1==24){
         fill(255, 128, 0);//rosu
         rect(400,164,100,75); 
         text("a intrat in zona 24 ",10,450);
       }
       else if(myVal1==25){
         fill(255, 191, 0);//rosu
         rect(500,164,100,75); 
         text("a intrat in zona 25 ",10,450);
       }
       else if(myVal1==26){
         fill(255, 255, 0);//rosu
         rect(600,164,100,75); 
         text("a intrat in zona 26 ",10,450);
       }
         else if(myVal1==31){
         fill(179, 0, 0);//rosu
         rect(100,239,100,75);
         text("a intrat in zona 31 ",10,450);
       }
    else if(myVal1==32){
         fill(255,0,0);//rosu
         rect(200,239,100,75); 
         text("a intrat in zona 32 ",10,450);
       }
        else if(myVal1==33){
         fill(255, 64, 0);//rosu
         rect(300,239,100,75); 
         text("a intrat in zona 33 ",10,450);
       }
       else if(myVal1==34){
         fill(255, 128, 0);//rosu
         rect(400,239,100,75);
         text("a intrat in zona 34 ",10,350);
       }
       else if(myVal1==35){
         fill(255, 191, 0);//rosu
         rect(500,239,100,75); 
         text("a intrat in zona 35 ",10,450);
       }
       else if(myVal1==36){
         fill(255, 255, 0);//rosu
         rect(600,239,100,75);
         text("a intrat in zona 36 ",10,450);
       }

  else if(myVal1==41){
         fill(179, 0, 0);//rosu
          rect(100,315,100,75);
         text("a intrat in zona 41 ",10,450);
       }
  else if(myVal1==42){
         fill(255,0,0);//rosu
          rect(200,315,100,75); 
         text("a intrat in zona 42 ",10,450);
       }
        else if(myVal1==43){
         fill(255, 64, 0);//rosu
          rect(300,315,100,75); 
         text("a intrat in zona 43 ",10,450);
       }
       else if(myVal1==44){
         fill(255, 128, 0);//rosu
          rect(400,315,100,75);
         text("a intrat in zona 44 ",10,450);
       }
       else if(myVal1==45){
         fill(255, 191, 0);//rosu
          rect(500,315,100,75);
         text("a intrat in zona 45 ",10,450);
       }
       else if(myVal1==46){
         fill(255, 255, 0);//rosu
          rect(600,315,100,75);
         text("a intrat in zona 46 ",10,450);
       }
       else if (myVal1==0){
         fill(64, 255, 0);
          rect(350,200,600,300);
       }
    }
   }
}
