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

public class Lesson extends PApplet {

//Input and collision

PVector position;
float speed = 5;

public void setup()
{
	
	position = new PVector(width/2, height/2);
	ellipseMode(CENTER);
}

public void draw()
{
	background(0);
	strokeWeight(3);
	stroke(255);
	fill(0);

	float xMovement = getAxisRaw("Horizontal") * speed;
	float yMovement = getAxisRaw("Vertical") * speed;

	position.x += xMovement;
	position.y += yMovement;

	ellipse(position.x, position.y, 50, 50);
}




boolean moveLeft;
boolean moveRight;
boolean moveUp;
boolean moveDown;

public void keyPressed()
{

	println(keyCode);

	//keyCodes

	if(key == CODED)
	{
		if(keyCode == RIGHT)
		{
			moveRight = true;
		}
		else if(keyCode == LEFT)
		{
			moveLeft = true;
		}
		if(keyCode == UP)
		{
			moveUp = true;
		}
		else if(keyCode == DOWN)
		{
			moveDown = true;
		}
	}

	//letters

	if(key == 'd')
	{
		moveRight = true;
	}
	else if(key == 'a')
	{
		moveLeft = true;
	}
	if(key == 'w')
	{
		moveUp = true;
	}
	if(key == 's')
	{
		moveDown = true;
	}
}

public void keyReleased()
{
	
	//keyCodes

	if(key == CODED)
	{
		if(keyCode == RIGHT)
		{
			moveRight = false;
		}
		else if(keyCode == LEFT)
		{
			moveLeft = false;
		}
		if(keyCode == UP)
		{
			moveUp = false;
		}
		else if(keyCode == DOWN)
		{
			moveDown = false;
		}
	}

	//letters

	if(key == 'd')
	{
		moveRight = false;
	}
	else if(key == 'a')
	{
		moveLeft = false;
	}	
	if(key == 'w')
	{
		moveUp = false;
	}
	if(key == 's')
	{
		moveDown = false;
	}
}

public float getAxisRaw(String axis)
{
	if(axis == "Horizontal")
	{
		if(moveLeft)
		{
			return -1;
		}
		if(moveRight)
		{
			return 1;
		}
	}

	if(axis == "Vertical")
	{
		if(moveUp)
		{
			return -1;
		}
		if(moveDown)
		{
			return 1;
		}		
	}

	return 0;
}
  public void settings() { 	size(1024, 1024); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lesson" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
