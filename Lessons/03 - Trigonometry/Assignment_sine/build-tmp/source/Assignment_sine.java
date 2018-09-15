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

public class Assignment_sine extends PApplet {

int frame = 0;
float multiplier = 0.002f;
int numberOfPoints = 100;

float inc = TWO_PI/25.0f;
float angle = 0;

public void setup()
{
	
	strokeWeight(5);
}

public void draw()
{
	background(255);

	//Draw animated point
	for(int i = 0 ; i <= numberOfPoints; i++)
	{
		stroke(0,0,0);
		float x = width/numberOfPoints * i;
		float y = sin(angle)*40.0f;

		point(x, y + height/5);
		angle = angle + inc;
	}

		//Draw animated point
	for(int i = 0 ; i <= numberOfPoints; i++)
	{
		stroke(255,0,0);
		float x = width/numberOfPoints * i;
		float y = cos(angle)*40.0f;

		point(x, y + height/2);
		angle = angle + inc;
	}
}





/*
sinv= motstående katet / hypotenusa 
cosv= närliggande katet / hypotenusa 
tanv= motstående katet / närliggande katet 
*/
  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment_sine" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
