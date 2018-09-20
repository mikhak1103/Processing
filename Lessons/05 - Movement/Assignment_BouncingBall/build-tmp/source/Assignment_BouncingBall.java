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

public class Assignment_BouncingBall extends PApplet {

int a = 1;
float tpf;
float time;

PVector position;
PVector velocity;

public void setup()
{
	

	position = new PVector(width/2, height/2);
	velocity = new PVector(8,8);
}

public void draw()
{
	background(0);
	fill(255);
  	long currentTime =millis();
  	tpf = (currentTime - time) * 0.001f; // we want this is seconds -> fraction of a second
  	drawBall();
  	time = currentTime;
}

public void drawBall()
{
	ellipse(position.x, position.y, 20, 20);

	position.x = position.x + velocity.x;
	position.x = position.x + (velocity.x * tpf);	

	position.y = position.y + velocity.y;
	position.y = position.y + (velocity.y * tpf);	

	velocity.x = velocity.x + a * tpf;
	velocity.y = velocity.y + a * tpf;

	if(position.x + 10> width)
	{
		velocity.x =-velocity.x;
		velocity.x = (velocity.x * 0.9f);
		position.x = 0;
	}
	if(position.x  < 0)
	{
		velocity.x =- velocity.x;
		velocity.x = (velocity.x * 0.9f);
		position.x = 0;
	}
	if(position.y > height - 10)
	{
		velocity.y =- velocity.y;
		velocity.y = (velocity.y * 0.9f);
		position.y = height - 10;
	}
	if(position.y < 10)
	{
		velocity.y =- velocity.y;
		velocity.y = (velocity.y * 0.9f);
		position.y = 10;
	}
}
  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment_BouncingBall" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
