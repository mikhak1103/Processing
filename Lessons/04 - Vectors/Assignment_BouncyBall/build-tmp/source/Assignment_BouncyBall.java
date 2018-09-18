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

public class Assignment_BouncyBall extends PApplet {

PVector ball;
PVector dir;
int speed;
boolean red = false;

public void setup()
{
	
	ball = new PVector(100,5);
	dir = new PVector(2,2);
	speed = 10;
}

public void draw()
{
	background(0);

	dir.normalize();

	ball.x = ball.x + (dir.x * speed);
	ball.y = ball.y + (dir.y * speed);

	if(ball.x > width || ball.x < 0)
	{
		dir.x = dir.x * -1;
		if(!red)
		{
			fill(255,0,0);
			red = true;
		}
		else if(red)
		{
			fill(255);
			red = false;
		}
	}
	if(ball.y > height || ball.y < 0)
	{
		dir.y = dir.y * -1;

	}	
	ellipse(ball.x,ball.y,10,10);


	System.out.println("");
}		
  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment_BouncyBall" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
