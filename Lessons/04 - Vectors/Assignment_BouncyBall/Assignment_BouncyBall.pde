PVector ball;
PVector dir;
int speed;
boolean red = false;

void setup()
{
	size(640, 480);
	ball = new PVector(100,5);
	dir = new PVector(2,2);
	speed = 10;
}

void draw()
{
	background(0);

	dir.normalize();

	ball.x = ball.x + (dir.x * speed);
	ball.y = ball.y + (dir.y * speed);

	if(ball.x > width || ball.x < 0)
	{
		dir.x = dir.x * -1;
		if(!red)
		{
			fill(255,0,0);
			red = true;
		}
		else if(red)
		{
			fill(255);
			red = false;
		}
	}
	if(ball.y > height || ball.y < 0)
	{
		dir.y = dir.y * -1;

	}	
	ellipse(ball.x,ball.y,10,10);
}		





