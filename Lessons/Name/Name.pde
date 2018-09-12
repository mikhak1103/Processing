void setup()
{
  size(768, 432);
}

int boldness = 1;

int x = 0;
int y = 0;
int frames = 0;

void draw()
{
  
  background(128,128,255);
  stroke(255,0,0);
  strokeWeight(boldness);
  
  //M
  line(x + 20,30,x + 20,150);
  line(x + 20,30,x + 75,110);
  line(x + 75,110,x + 130,30);
  line(x + 130,30,x + 130,150);
  
  //I
  line(x + 155,30,x + 155,150);
  
  //C
  arc(x + 240, 90, 130, 120, -4.9, -HALF_PI);
  noFill();
  
  //H
  line(x + 280,30,x + 280,150);
  line(x + 280,90,x + 330,90);
  line(x + 330,30,x + 330,150);
  
  //A
  line(x + 400,30,x + 360,150);
  line(x + 380,90,x + 420,90);
  line(x + 400,30,x + 440,150);
  
  //E
  line(x + 460,30,x + 460,150);
  line(x + 460,30,x + 510,30);
  line(x + 460,95,x + 510,95);
  line(x + 460,150,x + 510,150);
  
  //L
  line(x + 540,30,x + 540,150);
  line(x + 540,150,x + 590,150);
  
  for(int i = 0; i < 10; i++)
  {
    x = frames * i;
  }
  
  frames++;
  
  if (x > width)
  frames=0;


  
  
  
  
  
  
}
