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
float deltaTime; // this was called frameTime in the walkthrough. Only one of them is necessary
float time;

Ball[] balls;
int ballCount = 5000;

public void setup()
{
	
	ball = new PVector(100,5);
	dir = new PVector(2,2);
	speed = 10;

	balls = new Ball[ballCount];

	for(int i = 0; i < ballCount; i++)
	{
		balls[i] = new Ball();
	}
}

public void draw()
{
  	long currentTime = millis();
  	deltaTime = (currentTime - time) * 0.05f; // we want this is seconds, fraction of a second

	background(0);

	dir.normalize();

	ball.x = ball.x + (dir.x * speed) * deltaTime;
	ball.y = ball.y + (dir.y * speed) * deltaTime;

	if(ball.x < 0)
	{
		dir.x = dir.x * -1;
	}
	if(ball.x > width)
	{
		ball.x = 0;
	}
	if(ball.y > height || ball.y < 0)
	{
		dir.y = dir.y * -1;
	}	
	ellipse(ball.x,ball.y,10,10);

	for(int i = 0; i < ballCount; i++)
	{
		balls[i].draw();
	}

	for(int i = 0; i < ballCount; i++)
	{
		balls[i].update();
	}

	time = currentTime;
}		




class Ball
{
	PVector pos;
	PVector vel;
	float c1, c2, c3;

	public Ball()
	{
		pos = new PVector();
		pos.x = random(0, width);
		pos.y = random(0, height);

		vel = new PVector(random(10, -10), random(10, -10));

		c1 = random(255);
		c2 = random(255);
		c2 = random(255);
	}

	public void draw()
	{
		fill(c1, c2, c3);
		ellipse(pos.x, pos.y, 10, 10);
	}

	public void update()
	{
		pos.x += vel.x;
		pos.y += vel.y;
		collision();
	}

	public void collision()
	{
	if(pos.x < 0)
	{
		vel.x = vel.x * -1;
	}
	if(pos.x > width)
	{
		vel.x = vel.x * -1;
	}
	if(pos.y > height || pos.y < 0)
	{
		vel.y = vel.y * -1;
	}
	}
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
