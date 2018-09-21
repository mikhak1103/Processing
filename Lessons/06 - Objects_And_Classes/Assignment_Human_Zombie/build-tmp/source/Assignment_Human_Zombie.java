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

public class Assignment_Human_Zombie extends PApplet {

Character[] characters;
int numberOfCharacters = 100;
int numZombies = 1;
int num = 0;

public void setup()
{
	

	characters = new Character[numberOfCharacters];

	for(int i = 0; i < numberOfCharacters; i++)
	{
		if(i >= numZombies) //spawns 99 humans
		{
			characters[i] = new Human();
		}
		else //spawns 1 zombie
		{
			characters[i] = new Zombie();
		}
	}
}

public void draw()
{
	background(120,120,120);

	for(int i = 0; i < numberOfCharacters; i++)
	{
		for(int j = i + 1; j < numberOfCharacters; j++)
		{
			boolean hasCollided = collision(characters[i].position.x,
											characters[i].position.y,
											characters[i].size,
											characters[j].position.x,
											characters[j].position.y,
											characters[j].size);
											
			if(hasCollided && characters[i] instanceof Zombie && !(characters[j] instanceof Zombie))
			{
				characters[j] = new Zombie();
				textSize(26); 
				text("Yummy!", characters[i].position.x, characters[i].position.y);

			}
		}
			characters[i].update();

	}

	for(int i = 0; i < numberOfCharacters; i++)
	{
		characters[i].draw();
	}
	//text("Score: " + num, 10, 10, 70, 80);
}











//-----------------------------


class Character
{

PVector position;
PVector velocity;
int size = 10;
int z1 = 0;
int z2 = 255;
int z3 = 0;
int h1 = 255;
int h2 = 0;
int h3 = 0;

public Character()
{
	position = new PVector();
	position.x = random(0, width);
	position.y = random(0, height);

	velocity = new PVector();
	velocity.x = random(-2,2); //(5, -5)
	velocity.y = random(-2,2); //(5, -5)
}

	public void draw()
	{
		ellipse(position.x - size/2, position.y - size/2, size, size);
	}

	public void move()
	{

	}

	public void checkCollision()
	{
		if(position.x >= width)
			position.x = 20;
		if(position.x <= 0)
			velocity.x *= -1;
		if(position.y >= height || position.y <= 0)
			velocity.y *= -1;
	}

	public void update()
	{
		position.x += velocity.x;
		position.y += velocity.y;
		checkCollision();
	}

}

public class Human extends Character
{
	public Human()
	{
		super();
	}

	public void draw()
	{
		fill(h1,h2,h3);
		super.draw();
	}

	public void callFirstDraw()
	{
		super.draw();
	}
} 

public class Zombie extends Human
{
	public Zombie()
	{
		super();
		velocity.x = random(-1, 1);
		velocity.y = random(-1, 1);
	}

	public void draw()
	{
		fill(z1, z2, z3);
		super.callFirstDraw();
		// ellipse(position.x - size/2, position.y - size/2, size, size);

	}
}



public boolean collision(float x1, float y1, int size1, float x2, float y2, int size2)
{
	int maxDistance = size1 + size2;

	if(abs(x1 - x2) > maxDistance || abs(y1 - y2) > maxDistance)
	{
		return false;
	}
	else if(dist(x1, y1, x2, y2) > maxDistance)
	{
		return false;
	}
	else 
	{
		return true;		
	}
}
  public void settings() { 	size(800,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment_Human_Zombie" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}