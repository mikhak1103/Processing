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

public class Walkthrough extends PApplet {

public void setup()
{
  
  background(0,0,0);
}

public void draw()
{
	strokeWeight(1);
	stroke(255,255,255);
	int x1 = 20;
	int y1 = 20;
	int x2 = 20;
	int y2 = height-10;


	for(int i = 0; i < height - 20; i = i + 10)
	{
		line(x1, y1 + i, x2 + i, y2);
	}


}
  public void settings() {  size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Walkthrough" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
