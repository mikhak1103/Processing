Ball[] balls;
int numberOfBalls = 100;

void setup()
{
	size(512, 512);
	balls = new Ball[numberOfBalls];

	for(int i = 0; i < numberOfBalls; i++)
	{
		balls[i] = new Ball();
	}
}

void draw()
{
	background(0);
	fill(255);
	controls();
	for(int i = 0; i < balls.length; i++)
	{
		balls[i].draw();
		balls[i].update();
	}	
}





//-----------------------------------------

class Ball
{

	PVector position;
	PVector velocity;

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
		ellipse(position.x, position.y, 10, 10);
	}

}

//-----------------------------------------

void controls()
{

}

//-----------------------------------------