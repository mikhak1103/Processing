Ball[] balls;
int numberOfBalls = 100;

void setup()
{
	size(512, 512);
	balls = new Ball[numberOfBalls]; //declare size of array

	for(int i = 0; i < numberOfBalls; i++)
	{
		if(random(0 , 1) < 0.5)
		{
			balls[i] = new Apple();
		}
		else 
		{
			balls[i] = new Pear();
		}
	}
}

//------------------------------------------------

void draw()
{
	background(0);
	fill(255);
	for(int i = 0; i < numberOfBalls; i++)
	{
		for(int j = i + 1; j < numberOfBalls; j++)
		{
			boolean hasCollided = collision(balls[i].position.x,
											balls[i].position.y,
											balls[i].size/2,
											balls[j].position.x,
											balls[j].position.y,
											balls[j].size/2);
											
			if(hasCollided)
			{
				balls[i].velocity.x = 0;
				balls[j].velocity.x = 0;
				balls[i].velocity.y = 0;
				balls[j].velocity.y = 0;
			}
			
		}

		balls[i].update();
	}
//------------------------------------------------
	
	for(int i = 0; i < numberOfBalls; i++)
	{
		balls[i].draw();
	}
}

//------------------------------------------------




//-----------------------------------------

class Ball
{

	PVector position;
	PVector velocity;
	int size = 10;

	public Ball()
	{
		position = new PVector();
		position.x = random(0, width);
		position.y = random(0, height);

		velocity = new PVector();
		velocity.x = random(10) - 5; //(5, -5)
		velocity.y = random(10) - 5; //(5, -5)
	}

	public Ball(int x, int y)
	{
		position = new PVector(x, y);

		velocity = new PVector();
		velocity.x = random(10) - 5; //(5, -5)
		velocity.y = random(10) - 5; //(5, -5)
	}

	void checkCollision()
	{
		if(position.x > width || position.x < 0)
			velocity.x *= -1;
		if(position.y > height || position.y < 0)
			velocity.y *= -1;
	}

	void move()
	{
		if(keyPressed)
		if(keyCode == UP)
		background(255,0,0);		
	}

	void update()
	{
		position.x += velocity.x;
		position.y += velocity.y;
		checkCollision();
		move();
	}

	void draw()
	{
		ellipse(position.x - size/2, position.y - size/2, size, size);
	}

}

//-----------------------------------------

public class Apple extends Ball 
{
	public Apple()
	{
		super();
	}
	public Apple(int x, int y)
	{
		super(x, y);
	}
	void draw()
	{
		fill(255, 0, 0);
		super.draw();
	}
}

//-----------------------------------------

public class Pear extends Ball
{
	public Pear()
	{
		super();
	}
	public Pear(int x, int y)
	{
		super(x, y);
	}
	void draw()
	{
		fill(0, 255, 0);
		ellipse(position.x, position.y, size/2, size*2);
	}
}

//----------------------------

boolean collision(float x1, float y1, int size1, float x2, float y2, int size2)
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