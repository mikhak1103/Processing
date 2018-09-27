Ball[] balls;
Player player;
int numBalls = 10;


void setup()
{
	size(640, 480);
	strokeWeight(1);

	balls = new Ball[numBalls];

	for(int i = 0; i < numBalls; i++)
	{
		balls[i] = new Ball();
	}
	
	player = new Player(50, 50);
	
}

void draw()
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

	void update()
	{
		position.x += velocity.x;
		position.y += velocity.y;
		collision();
	}

	void draw()
	{
		fill(c1, c2, c3);
		ellipse(position.x, position.y, size, size);

	}

	void collision()
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

	void controls()
	{

	}

	void collision()
	{
		if(position.x + size > width)
			position.x = width - size*1.1;
	}

	void draw()
	{
		fill(255,0,0);
		ellipse(position.x, position.y, size, size);
	}

	void update()
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

	void draw()
	{
		fill(255);
		ellipse(position.x, position.y, size, size);
	}

	void update()
	{
		position.x += velocity.x;
		position.y += velocity.y;		
	}
}



void fire()
{
	for(int i = 0; i < bullets.length; i++)
	{
		
		
	}
}