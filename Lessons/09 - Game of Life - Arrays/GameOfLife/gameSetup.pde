void gameSetup()
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

boolean randomAlive()
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