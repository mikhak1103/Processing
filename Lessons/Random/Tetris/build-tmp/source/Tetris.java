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

public class Tetris extends PApplet {

Ball[] balls;
Bullet[] bullets;
Player player;
int numBalls = 10;
boolean fire = false;
Bullet bullet;

public void setup()
{
	
	strokeWeight(1);

	balls = new Ball[numBalls];

	for(int i = 0; i < numBalls; i++)
	{
		balls[i] = new Ball();
	}
	
	player = new Player(50, 50);
	
}

public void draw()
{
	background(0,0,255);

	for(int i = 0; i < numBalls; i++)
	{
		balls[i].draw();
	}

	for(int i = 0; i < numBalls; i++)
	{
		balls[i].update();
	}

	player.draw();
	player.update();

	if(fire)
	{
	for(int i = 0; i < bullets.length; i++)
	{
		bullets[i].draw();
		bullets[i].update();
	}
	}
	

}





class Ball
{
	PVector position;
	PVector velocity;
	int size = 10;
	float c1, c2, c3;

	public Ball()
	{
		position = new PVector();
		position.x = random(0, width);
		position.y = random(0, height);

		velocity = new PVector();
		velocity.x = random(-10,10); //(5, -5)
		velocity.y = random(-10,10); //(5, -5)

		c1 = random(250, 255);
		c2 = random(250, 255);
		c3 = random(250, 255);
	}

	public void update()
	{
		position.x += velocity.x;
		position.y += velocity.y;
		collision();
	}

	public void draw()
	{
		fill(c1, c2, c3);
		ellipse(position.x, position.y, size, size);

	}

	public void collision()
	{
		if(position.x >= width)
			velocity.x *= -1;
		if(position.x <= 5)
			velocity.x *= -1;
		if(position.y >= height - 10 || position.y <= 10)
			velocity.y *= -1;
	}
}

class Player 
{
	PVector position;
	PVector velocity;	
	int  xSpeed = 2;
	int  ySpeed = 2;
	int size = 10;

	public Player(int x, int y)
	{
		position = new PVector(x, y);

		velocity = new PVector(x, y);
		velocity.x = xSpeed;
		velocity.y = ySpeed;
	}

	public void controls()
	{
		if(keyPressed)
		if(keyCode == UP)
		fire = true;
		else 
		fire = false;
	}

	public void collision()
	{
		if(position.x + size > width)
			position.x = width - size*1.1f;
	}

	public void draw()
	{
		fill(255,0,0);
		ellipse(position.x, position.y, size, size);
	}

	public void update()
	{
		collision();
		controls();
	}
}


class Bullet
{
PVector position;
PVector velocity;	
int  xSpeed = 2;
int  ySpeed = 2;
int size = 1;

	public Bullet()
	{
		position = new PVector();
		position.x = 50;
		position.y = 50;	
		velocity = new PVector();
		velocity.x = xSpeed;
		velocity.y = 0;		
	}

	public void draw()
	{
		fill(255);
		ellipse(position.x, position.y, size, size);
	}

	public void update()
	{
		position.x += velocity.x;
		position.y += velocity.y;		
	}
}



public void fire()
{
	for(int i = 0; i < bullets.length; i++)
	{
		bullet = new Bullet();
		bullets.append(bullet);
	}
}
  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Tetris" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
