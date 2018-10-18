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

public class GameOfLife extends PApplet {

int state = 0;
int cellSize = 10;
float fillPercentage = 15;
int columns;
int rows;
boolean paused;
GameObject[][] grid;
ArrayList<GameObject> gameObjects;
int fr = 60;
int generation = 0;
int neighbours;
boolean isMousePressed = false;

public void setup()
{
	
	ellipseMode(LEFT);
	gameObjects = new ArrayList<GameObject>();
	gameSetup();
}

public void draw()
{
	if(state == 0)
	{
		generation++;
		frameRate(fr);
		background(0);
		
		if(generation % 10 == 0)
		{
			if(!paused && !isMousePressed)
			{
				gameLoop();
			}
		}
		drawGrid();
	}
	
drawText();
println(gameObjects.size());
}


public void gameLoop()
{
	for(int x = 0; x < columns; x++)
	{
		for(int y = 0; y < rows; y++)
		{
			neighbours = calcNeighbours(x, y);
			compare(x, y);
		}
	}
}

public int calcNeighbours(int x, int y)
{
	neighbours = 0;
	for(int deltaX = -1; deltaX <= 1; deltaX++)
	{
		for(int deltaY = -1; deltaY <= 1; deltaY++)
			{
				if(((x+deltaX >= 0) && (x+deltaX < columns)) && ((y+deltaY >= 0) && (y+deltaY < rows)))
					if(!((deltaX==0)&&(deltaY == 0)))
					{ 
						if(grid[x+deltaX][y+deltaY].alive)
						{
							neighbours++;
						}
					}
			}
	}
	return neighbours;
}

public void compare(int x, int y)
{
	if(grid[x][y].alive)
	{
		if(neighbours < 2 || neighbours > 3)
		{
			if (grid[x][y].alive) 
			{
				grid[x][y].deathTime = 0;
			}
				grid[x][y].next = false;	
		}
	}
			
	else 
	{
		if(neighbours == 3)
		{
			grid[x][y].next = true;
		}
	}
}

public void drawGrid()
{
	for(int x = 0; x < columns; x++)
	{
		for(int y = 0; y < rows; y++)
		{
			grid[x][y].draw();
			grid[x][y].alive = grid[x][y].next;
		}

	}


}

public void drawText()
{
	rectMode(CENTER);
	fill(255, 255, 255, 50);
	rect(width/2,30,width/2,60);
	fill(255, 255, 255, 150);
	textSize(25);
	textAlign(CENTER);
	text("Press SPACE to pause the game.", width/2, 25);
	text("Press + or - to adjust the fps.", width/2, 50);

	rectMode(RADIUS);
	fill(255, 255, 255, 50);
	rect(0,height,85,25);
	fill(255,255,0);
	textSize(25);
	textAlign(LEFT);
	text("fps: " + fr, 0, height-5);
}


public void keyPressed() 
{

    if (keyCode == 109 && fr > 1) 
    {
    	fr-=1;
	}
	else if (keyCode == 107 && fr < 60)
	{
		fr+=1;
	}


    if (keyCode == 32 && state != 1) 
    {
    	state = 1;
    }
    else 
    {
    	state = 0;
    }
}



public void mousePressed() 
{
	isMousePressed = true;
	for(int x = 0; x < columns; x++)
	{
		for(int y = 0; y < rows; y++)
		{
			if(focused && mouseX > grid[x][y].x && mouseX < grid[x][y].x + grid[x][y].size && mouseY > grid[x][y].y && mouseY < grid[x][y].y + grid[x][y].size)
			{
				if(grid[x][y].alive)
				grid[x][y].alive = false;
				else 
				gameObjects.add(grid[x][y]);
			}
		}
	}
}

public void mouseReleased()
{
	isMousePressed = false;
}

//I atleast tried, haha.
public class GameObject 
{
	float x, y;	
	float size;		
	PVector col;

	boolean alive = false;
	boolean next = false;
	int deathTime = 255;

	public GameObject (float x, float y, float size) 
	{
		this.x = x;
		this.y = y;
		this.size = size;
		this.col = new PVector(0,255,0);
	}

	public void draw()
	{	
		if (alive) 
		{
			fill(col.x, col.y, col.z, 255);
		}
		else 
		{
			fill(255, 0, col.z, 255 - deathTime);		
			deathTime+=20;
		}
		ellipse(x, y, size, size);
	}
}
/*
Death 
- Overpopulation, 4 or more cells are alive
- Loneliness, 1 or fewer neighbours are alive

Birth
- Exactly 3 neighbours

Stasis (else)
- State remains the same
(1 or 2 alive neighbours)
*/
public void gameSetup()
{
	columns = (int) (width/cellSize);
	rows = (int) (height/cellSize);

	grid = new GameObject[columns][rows];
	stroke(50);

	for(int x = 0; x < columns; x++)
	{
		for(int y = 0; y < rows; y++)
		{
			grid[x][y] = new GameObject(x*cellSize, y*cellSize, cellSize);

			grid[x][y].alive = randomAlive();
			grid[x][y].next = grid[x][y].alive;
		}
	}
}

public boolean randomAlive()
{
	if(random(0, 100) < fillPercentage)
	{
		return true;
	}
	else 
	{
		return false;
	}
}
  public void settings() { 	size(800, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "GameOfLife" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
