void setup()
{
  size(768, 432);
}

int boldness = 1;

void draw()
{
  
  background(128,128,255);
  stroke(255,0,0);
  strokeWeight(boldness);
  
  //M
  line(20,30,20,150);
  line(20,30,75,110);
  line(75,110,130,30);
  line(130,30,130,150);
  
  //I
  line(155,30,155,150);
  
  //C
  arc(240, 90, 130, 120, -4.9, -HALF_PI);
  noFill();
  
  //H
  line(280,30,280,150);
  line(280,90,330,90);
  line(330,30,330,150);
  
  //A
  line(400,30,360,150);
  line(380,90,420,90);
  line(400,30,440,150);
  
  //E
  line(460,30,460,150);
  line(460,30,510,30);
  line(460,95,510,95);
  line(460,150,510,150);
  
  //L
  line(540,30,540,150);
  line(540,150,590,150);
  

  
  if (mousePressed == true)
  {
    boldness +=1;
  }
  else {
  boldness = 1;
  }
  
  
  
  
  
  
}
