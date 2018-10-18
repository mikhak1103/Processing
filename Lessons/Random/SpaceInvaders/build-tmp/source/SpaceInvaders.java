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

public class SpaceInvaders extends PApplet {










































private float dt, lt;
public Player player;
public Enemy enemy;
public Bullet bullet;
public ArrayList<Player> players;
public ArrayList<Enemy> enemies;
public ArrayList<Bullet> bullets;


public void setup()
{
  
  players = new ArrayList<Player>();
  enemies = new ArrayList<Enemy>();
  bullets = new ArrayList<Bullet>();
  player = new Player(width/2, height - 50, 25, 255, 255, 255, 0, 0, 255);
  enemy = new Enemy(20, 20, 30, 255, 255, 255, 255, 0, 0);
  bullet = new Bullet(player.pos.x, player.pos.y, 5);
  enemies.add(enemy);
  
}

public void draw()
{

  tickDeltaTime();
  background(0);
  strokeWeight(5);
  stroke(255,255,255);
  line(0, 0, 0, height);
  line(width, 0, width, height);
  line(0, height, width, height);

  player.update(dt);

  for(int i = 0; i < enemies.size(); i++)
  {
    enemies.get(i).update(dt);
  }

  if(space)
    bullets.add(new Bullet(player.pos.x, player.pos.y, 5));

  for(int i = 0; i < bullets.size(); i++)
  {
    bullets.get(i).update(dt);
  }
}

public void tickDeltaTime()
{
  dt = (millis() - lt) * 0.001f;
  lt = millis();
}




public class Player
{
  public PVector pos;
  public PVector vel;
  float r, s1, s2, s3, c1, c2, c3;

  public Player(float x, float y, float d, float s1, float s2, float s3, float c1, float c2, float c3)
  {
    pos = new PVector(x, y);
    vel = new PVector(5, 5);
    this.r = d * 0.5f;
    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;
    this.c1 = c1;
    this.c2 = c2;
    this.c3 = c3;
  }

  public void update(float dt)
  {
    rectMode(RADIUS);
    strokeWeight(1);
    stroke(s1, s2, s3);
    fill(c1, c2, c3);
    rect(pos.x, pos.y, r, r * 1.5f);

    if(pos.x + r*2 > width && moveRight)
      moveRight = false;
    if(pos.x < r*2 && moveLeft)
      moveLeft = false;

    if(moveRight)
      pos.x += vel.x;
    else if(moveLeft)
      pos.x -= vel.x;
  }

}

public class Enemy
{
  public PVector pos;
  public PVector vel;
  
  public float r, s1, s2, s3, c1, c2, c3, d;
  public float numEnemies = 25;

  public Enemy(float x, float y, float d, float s1, float s2, float s3, float c1, float c2, float c3)
  {
    pos = new PVector(x, y);
    vel = new PVector(2,1);
    this.r = d * 0.5f;
    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;
    this.c1 = c1;
    this.c2 = c2;
    this.c3 = c3; 
  }



  public void update(float dt)
  {
    rectMode(RADIUS);
    strokeWeight(1);
    stroke(s1, s2, s3);
    fill(c1, c2, c3);

    for(float i = 0; i < width; i+=40)
    {
      for(float j = 0; j < height/3; j+=40)
      {
      rect(pos.x + i, pos.y + j, r, r);
      }
    }
    pos.y += vel.y;  
  }
}


class Bullet
{
  PVector pos;
  PVector vel;
  public float r, d;

  public Bullet(float x, float y, float d)
  {
    pos = new PVector(x, y);
    vel = new PVector(3,2);
    this.r = d * 0.5f;
  }

  public void update(float dt)
  {
    fill(255);
    strokeWeight(2);
    rectMode(RADIUS);

    rect(pos.x, pos.y, r, r);
    pos.y -= vel.y;
  }
}

boolean moveLeft;
boolean moveRight;
boolean moveUp;
boolean moveDown;
boolean space;

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

	if(key == 'd' || key == 'D')
	{
		moveRight = true;
	}
	else if(key == 'a' || key == 'A')
	{
		moveLeft = true;
	}
	if(key == 'w' || key == 'W')
	{
		moveUp = true;
	}
	if(key == 's' || key == 'S')
	{
		moveDown = true;
	}

	if(key == ' ')
	{
		space = true;
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

	if(key == 'd' || key == 'D')
	{
		moveRight = false;
	}
	else if(key == 'a' || key == 'A')
	{
		moveLeft = false;
	}	
	if(key == 'w' || key == 'W')
	{
		moveUp = false;
	}
	if(key == 's' || key == 'S')
	{
		moveDown = false;
	}

	if(key == ' ')
	{
		space = false;
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
  public void settings() {  size(600, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SpaceInvaders" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
