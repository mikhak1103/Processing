boolean moveLeft;
boolean moveRight;

void keyPressed()
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
}

void keyReleased()
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
}

float getAxisRaw(String axis)
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

	return 0;
}