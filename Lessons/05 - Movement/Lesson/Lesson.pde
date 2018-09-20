float posX;
float posY;

float v = 10;
float direction = 0;

void setup()
{
	size(800, 600);
	posX = width/2;
	posY = height/2;
}

void draw()
{
	background(255);
	float dX = cos(direction) * v;
	float dY = sin(direction) * v;

	posX += dX;
	posY -= dY;

	ellipse(posX, posY, 10, 10);

	direction += 0.05f;

	if(direction > PI * 2)
	{
		direction -= PI * 2;
	}
}





/*
float posY;
float posX;
float vX = 1;
float vY = 20;
float a = 1;

float tpf;
float time;

void setup()
{
	size(640, 480);
	posX = width/2;
	posY = height/2;

	frameRate(60);

	tpf = 1f / 60f; //
}

void draw()
{
  long currentTime =millis();
  tpf = (currentTime - time) * 0.001f;


	background(0);
	stroke(255);

	posY = posY + (vY * tpf);

	ellipse(posX, posY, 10, 10);

	vY = vY + (a * tpf);

	if(posY >  height)
	{
		vY = -vY;
		posY = height -1;
		vY = (int) (vY * 0.9f);
	}
time = currentTime;
}

*/