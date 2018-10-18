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

public class Gravity extends PApplet {

Player player;
ArrayList<Platform> platforms;
ArrayList<Area> areas;
private float dt, lt;
public float a = 10;
public float gravity = 0.2f;

public boolean falling = true;

public float health = 200;
public float healthDeficitSpeed = 0.1f;

boolean inForest;


public void setup()
{
  

  platforms = new ArrayList<Platform>();
  areas = new ArrayList<Area>();
  createArea(0, 0, 150, 175, 220,20,60, "Lava");
  createArea(width-300, 0, 300, 900, 0, 0, 255, "Ocean");
  createArea(width-150, 150, 50, 40, 255,255,0, "Island");
  createArea(width-100, 350, 40, 50, 255,255,0, "Island");
  createArea(300, 300, 75, 50, 0,191,255, "Lake");
  createArea(0, height-400, 500, 400, 34,139,34, "Forest");
  createPlayer();


  //spawnPlatforms();
}

public void draw()
{
  tickDeltaTime();
  background(0);
  createHealthBar();
  game(dt);


  //DrawText(20, width/2, 20, "Health: " + health);
 
}

public void game(float dt)
{
  rectMode(CORNER);
  for(int i = 0; i < platforms.size(); i++)
  {
    platforms.get(i).Update(dt);
  }

  for(int i = 0; i < areas.size(); i++)
  {
    areas.get(i).Update(dt);
  }

  player.Update(dt);
  fill(0,0,0);
  checkCollision();
  println(health);
}

public void pause()
{
  background(255);
  text("Paused", width/2, height/2);
}

public void mainMenu()
{
  background(255, 0, 0);
  text("Main Menu", width/2, height/2);
}

public void tickDeltaTime(){
  dt = (millis() - lt) * 0.001f;
  lt = millis();
}

public void spawnPlatforms(){
int num = 10;
  for(int i = 0; i < num; i++)
  {
    PVector pos = new PVector(random(width), random(height), 0);
    PVector vel = new PVector(2, 0, 0);
    PVector colStroke = new PVector(255, 255, 255);
    PVector colFill = new PVector(255, 255, 255);
    PVector r = new PVector(50, 10);

    Platform platform = new Platform(pos, vel, colStroke, colFill, r);
    platforms.add(platform);
  }
}

public void createArea(float x, float y, float rx, float ry, float c1, float c2, float c3, String type)
{
    PVector pos = new PVector(x, y);
    PVector colFill = new PVector(c1, c2, c3);
    PVector r = new PVector(rx, ry);
    Area area = new Area(pos, r, colFill, type);
    areas.add(area);
}


public void createPlayer()
{
  PVector pos = new PVector(width/2, 0, 0);
  PVector vel = new PVector(3, 3, 7);
  PVector colStroke = new PVector(255, 255, 255);
  PVector colFill = new PVector(255, 255, 255);
  PVector r = new PVector(20, 20, 0);

  player = new Player(pos, vel, colStroke, colFill, r, health);
}

public void checkCollision()
{
  for(int i = 0; i < platforms.size(); i++)
  {
    if(collisionPlayerPlatform(player, platforms.get(i)))
    {
      println("collided");
      falling = false;
    }
    else 
      falling = true;
  }


  for(int i = 0; i < areas.size(); i++)
  {
    if(collisionPlayerArea(player, areas.get(i)))
    {
      println("You just entered the " + areas.get(i).type + " area!");

      if(areas.get(i).type == "Lava" && health > 0)
      {
        reduceHealthTimer();
      }
      if(areas.get(i).type == "Lake" && health < 200)
      {
        health += 0.5f;
      }
    }

  }

collisionPlayerWalls();

  
}


public boolean collisionPlayerPlatform(Player player, Platform platform)
{
  return(player.pos.x < platform.pos.x + platform.r.x && player.pos.x + player.r.x > platform.pos.x && player.pos.y + player.r.y > platform.pos.y && player.pos.y < platform.pos.y + platform.r.y);
}

public boolean collisionPlayerArea(Player player, Area area)
{
  return(player.pos.x < area.pos.x + area.r.x && player.pos.x + player.r.x > area.pos.x && player.pos.y + player.r.y > area.pos.y && player.pos.y < area.pos.y + area.r.y);
}

public void collisionPlayerWalls()
{
  if(player.pos.x + player.r.x > width)
    player.pos.x = width - player.r.x;
  else if(player.pos.x < 0)
    player.pos.x = 0;
  if(player.pos.y + player.r.y > height)
  {
   player.pos.y = height - player.r.y;
   falling = false;
  }
  else if(player.pos.y < 0)
   ;

 else 
  falling = true;
}






class Area
{
  PVector pos, r, colFill;
  String type;

  public Area(PVector pos, PVector r, PVector colFill, String type)
  {
    this.pos = new PVector();
    this.pos.x = pos.x;
    this.pos.y = pos.y;

    this.r = new PVector();
    this.r.x = r.x;
    this.r.y = r.y;

    this.colFill = new PVector();
    this.colFill.x = colFill.x;
    this.colFill.y = colFill.y;
    this.colFill.z = colFill.z;

    this.type = type;
  }

  public void Update(float dt)
  {
    fill(colFill.x, colFill.y, colFill.z);
    rect(pos.x, pos.y, r.x, r.y);
  }
}



public void DrawText(float size, float x, float y, String s){
  PFont f;
  f = createFont("Arial", size, true);
  textFont(f, size);
  fill(255, 255, 255);

  text(s, x, y);
}

public void reduceHealthTimer()
{
health-= healthDeficitSpeed;
}

public void createHealthBar()
{

fill(0,255,0);
rectMode(CENTER);
rect(width/2, 10, health, 10);

}



abstract class GameObject
{

PVector pos, vel, colStroke, colFill, r;
boolean enabled;

  	public GameObject(PVector pos, PVector vel, PVector colStroke, PVector colFill, PVector r, float health){
    this.pos = new PVector();
    this.pos.x = pos.x;
    this.pos.y = pos.y;
    this.pos.z = pos.z;

    this.vel = new PVector();
    this.vel.x = vel.x;
    this.vel.y = vel.y;
    this.vel.z = vel.z;

    this.colStroke = new PVector();
    this.colStroke.x = colStroke.x;
    this.colStroke.y = colStroke.y;
    this.colStroke.z = colStroke.z;

    this.colFill = new PVector();
    this.colFill.x = colFill.x;
    this.colFill.y = colFill.y;
    this.colFill.z = colFill.z;

	this.r = new PVector();
    this.r.x = r.x;
    this.r.y = r.y;
    this.r.z = r.z;
  	}

	public void Update(float dt)
	{
    stroke(colStroke.x, colStroke.y,colStroke.z);
    fill(colFill.x, colFill.y, colFill.z);
	}

	public void Move()
	{

	}
}
boolean moveLeft;
boolean moveRight;
boolean moveUp;
boolean moveDown;
boolean space;
boolean spaceReleased;


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
		spaceReleased = false;
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
		spaceReleased = true;
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
class Platform extends GameObject
{
  public Platform(PVector pos, PVector vel, PVector colStroke, PVector colFill, PVector r)
  {
    super(pos, vel, colStroke, colFill, r, health);

  }

  public void Update(float dt)
  {
    rect(pos.x, pos.y, r.x, r.y);
    if(pos.x > width)
      pos.x = 0;

    Move();
  }

  public void Move()
  {
    super.Move();
    pos.x += vel.x;

  }

}
class Player extends GameObject
{
  public Player(PVector pos, PVector vel, PVector colStroke, PVector colFill, PVector r, float health)
  {
    super(pos, vel, colStroke, colFill, r, health);
  }

  public void Update(float dt)
  {
  	fill(colFill.x, colFill.y, colFill.z);
    rect(pos.x, pos.y, r.x, r.y);
	Move();
  }

  public void Move()
  {
    super.Move();

    if(moveLeft && moveRight)
    {
    }
    else if(moveRight)
    {
      pos.x += vel.x;
    }
    else if(moveLeft)
      pos.x -= vel.x;

  	if(moveUp && moveDown)
  	{
  	}
  	else if(moveUp)
  		pos.y -= vel.y;
  	else if(moveDown)
  		pos.y += vel.y;


  	



  	}



  	public void gather()
  	{
  		println("gathering material!");
   	}

}








    /*
    if(falling)
    {
    vel.y += gravity;
    pos.y += vel.y;
	}

	*/
  public void settings() {  size(900, 900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Gravity" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
