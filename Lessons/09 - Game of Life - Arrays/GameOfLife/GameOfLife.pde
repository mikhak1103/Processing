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

void setup()
{
	size(800, 800);
	ellipseMode(LEFT);
	gameObjects = new ArrayList<GameObject>();
	gameSetup();
}

void draw()
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


void gameLoop()
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

int calcNeighbours(int x, int y)
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

void compare(int x, int y)
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

void drawGrid()
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

void drawText()
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


void keyPressed() 
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



void mousePressed() 
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

void mouseReleased()
{
	isMousePressed = false;
}

//I atleast tried, haha.