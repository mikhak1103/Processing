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

public class Pong extends PApplet {

public void setup()
{
	
	strokeWeight(5);
	background(0);
	stroke(255);
}

int frame = 0;

float ballX = 0;
float ballY = 0;
float ballRadius;
float ballSpeed;

float p1x1 = 0;
float p1x2 = 0;
float p1y1 = 0;
float p1y2 = 0;

float p2x1 = 0;
float p2x2 = 0;
float p2y1 = 0;
float p2y2 = 0;

float dy = 5;
float dx = ball.speed = 5;

Ball ball = new Ball(100,100,2,2);

class Ball { 
  float xPos, yPos, radius, speed; 

  Ball (float x, float y, float r, float s) {  
    xPos = x; 
    yPos = y;
    radius = r;
    speed = s; 
  }
  } 


public void draw()
{
	background(0);
	rect(ball.xPos,ball.yPos,ball.radius,ball.radius);
	ball.xPos += dx;
	if(ball.xPos + ball.radius >= width)
		--dx;
	if(ball.xPos <= 0 )
		++dx;
}

  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Pong" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
