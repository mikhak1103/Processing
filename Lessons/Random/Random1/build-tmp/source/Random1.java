import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Random1 extends PApplet {

public void setup()
{
	
	strokeWeight(5);
}

int frame = 0;

float x = 0;
float y = 0;

public void draw()
{


background(0);

int r1 = floor(random(255));
int r2 = floor(random(255));
int r3 = floor(random(255));
stroke(color(r1, r2, r3));
delay(500);

for(float i =10; i < width; i+=10)
{	
	for(float j =10; j < height; j+=10)
		{
			point(x + i, y + j);
		}
}
System.out.println(r1 + "," + r2 + "," + r3);


}




  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Random1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
