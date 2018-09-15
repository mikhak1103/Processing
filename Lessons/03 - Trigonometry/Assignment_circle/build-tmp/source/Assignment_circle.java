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

public class Assignment_circle extends PApplet {

public void setup()
{
	
	strokeWeight(5);
}

//variables

float radius = 100, angle = 0, count = 10, slice = PI*2/count, x ,y;

public void draw()
{
	background(0);
	strokeWeight(10);
	stroke(255);

	for(float i = 0; i < count; i++){
	float x = width/2 + sin(angle) * radius;		//sets the starting point in the middle, and spaces out the first point in the middle on the x-axis + 100;
	float y = height/2 + sin(angle) * radius;		//sets the starting point in the middle, and spaces out the first point in the middle on the y-axis + 100;
	point(x, y);
	angle += slice;
}
}
  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment_circle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
