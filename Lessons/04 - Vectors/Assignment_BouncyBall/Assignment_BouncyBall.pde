PVector ball;
PVector dir;
int speed;
float deltaTime; // this was called frameTime in the walkthrough. Only one of them is necessary
float time;

Ball[] balls;
int ballCount = 5000;

void setup()
{
	size(640, 480);
	ball = new PVector(100,5);
	dir = new PVector(2,2);
	speed = 10;

	balls = new Ball[ballCount];

	for(int i = 0; i < ballCount; i++)
	{
		balls[i] = new Ball();
	}
}

void draw()
{
  	long currentTime = millis();
  	deltaTime = (currentTime - time) * 0.05f; // we want this is seconds, fraction of a second

	background(0);

	dir.normalize();

	ball.x = ball.x + (dir.x * speed) * deltaTime;
	ball.y = ball.y + (dir.y * speed) * deltaTime;

	if(ball.x < 0)
	{
		dir.x = dir.x * -1;
	}
	if(ball.x > width)
	{
		ball.x = 0;
	}
	if(ball.y > height || ball.y < 0)
	{
		dir.y = dir.y * -1;
	}	
	ellipse(ball.x,ball.y,10,10);

	for(int i = 0; i < ballCount; i++)
	{
		balls[i].draw();
	}

	for(int i = 0; i < ballCount; i++)
	{
		balls[i].update();
	}

	time = currentTime;
}		




class Ball
{
	PVector pos;
	PVector vel;
	float c1, c2, c3;

	public Ball()
	{
		pos = new PVector();
		pos.x = random(0, width);
		pos.y = random(0, height);

		vel = new PVector(random(10, -10), random(10, -10));

		c1 = random(255);
		c2 = random(255);
		c2 = random(255);
	}

	void draw()
	{
		fill(c1, c2, c3);
		ellipse(pos.x, pos.y, 10, 10);
	}

	void update()
	{
		pos.x += vel.x;
		pos.y += vel.y;
		collision();
	}

	void collision()
	{
	if(pos.x < 0)
	{
		vel.x = vel.x * -1;
	}
	if(pos.x > width)
	{
		pos.x = 0;
	}
	if(pos.y > height || pos.y < 0)
	{
		vel.y = vel.y * -1;
	}
	}
}