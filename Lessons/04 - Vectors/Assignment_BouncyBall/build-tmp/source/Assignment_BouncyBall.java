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

/*
PVector ball;
PVector dir;
int speed;
boolean red = false;

void setup()
{
	size(640, 480);
	ball = new PVector(100,5);
	dir = new PVector(2,2);
	speed = 10;
}

void draw()
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
}		

*/



PVector DotPos;
PVector DotMove;

PVector Velocity;
PVector Location;

int speed = 5;


public void setup()
{
  DotPos = new PVector(width/2, height/2);
  Location = new PVector(width/2, height/2);
  DotMove = new PVector (mouseX-DotPos.x, mouseY - DotPos.y);
  Velocity = new PVector (2.5f, -2);

  
}

public void draw ()
{



  background(140, 100, 158, 0);


  DotMove.normalize();
  Velocity.normalize();

  DotPos.x = DotPos.x + DotMove.x * speed; // ger nytt värde till dotposition som vi har satt till att vara i mitten
  DotPos.y = DotPos.y + DotMove.y * speed;
  //Location.add(Velocity);
  Location.x = Location.x + (Velocity.x * speed);
  Location.y = Location.y + (Velocity.y * speed);

  if ((Location.x > width) || (Location.x < 0))
  {
   Velocity.x = Velocity.x * -1;
  }

  if ((Location.y > height) || (Location.y < 0))
  {
   Velocity.y = Velocity.y * - 1;
  }
  ellipse (DotPos.x, DotPos.y, 15, 15);
  ellipse (Location.x, Location.y, 30, 30);
}
  public void settings() {  size (768, 768); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment_BouncyBall" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
