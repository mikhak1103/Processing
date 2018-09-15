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

public class Assignment_extra extends PApplet {

public void setup()
{
	
	strokeWeight(2);
}

int count = 200;

public void draw()
{
	background(255);
	for(int i = 0; i <= count; i+=5)
	{
		line(0, i * height/count, i * width/count, height);
		if(i % 3 == 0) //whenever the modulus of i is 3, make the line gray
		{
			stroke(0,0,0);
		}
		else
		{
			stroke(148);
		}
	}
}







































/*

//draw scanlines vertically

int frame = 0;

void draw()
{
	background(0);
	stroke(255);
	for(int i = 0; i < height; i+=10)
	{
		line(0, (i + frame) % height, width, (i + frame) % height); 	
		//Modulus up to height returns its own value, e.g (479 % 480 = 479), 
		//after it reaches height it restarts at 0 and so on.
	}
	frame++;
}



//draw scanlines horizontally

int frame = 0;

void draw() 
{
	background(0);
	stroke(255);
	for(int i = 0; i < width; i+=10)
	{
		line((i + frame) % width, 0, (i + frame) % width ,height);
	}
	frame++;
}

*/
  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment_extra" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
