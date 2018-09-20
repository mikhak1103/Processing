int a = 1;
float tpf;
float time;

PVector position;
PVector velocity;

void setup()
{
	size(640, 480);

	position = new PVector(width/2, height/2);
	velocity = new PVector(8,8);
}

void draw()
{
	background(0);
	fill(255);
  	long currentTime =millis();
  	tpf = (currentTime - time) * 0.001f; // we want this is seconds -> fraction of a second
  	drawBall();
  	time = currentTime;
}

void drawBall()
{
	ellipse(position.x, position.y, 20, 20);

	position.x = position.x + velocity.x;
	position.x = position.x + (velocity.x * tpf);	

	position.y = position.y + velocity.y;
	position.y = position.y + (velocity.y * tpf);	

	velocity.x = velocity.x + a * tpf;
	velocity.y = velocity.y + a * tpf;

	if(position.x + 10> width)
	{
		velocity.x =-velocity.x;
		velocity.x = (velocity.x * 0.9f);
		position.x = 0;
	}
	if(position.x  < 0)
	{
		velocity.x =- velocity.x;
		velocity.x = (velocity.x * 0.9f);
		position.x = 0;
	}
	if(position.y > height - 10)
	{
		velocity.y =- velocity.y;
		velocity.y = (velocity.y * 0.9f);
		position.y = height - 10;
	}
	if(position.y < 10)
	{
		velocity.y =- velocity.y;
		velocity.y = (velocity.y * 0.9f);
		position.y = 10;
	}
}