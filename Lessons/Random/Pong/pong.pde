void setup()
{
	size(640, 480);
	strokeWeight(5);
	background(0);
	stroke(255);
}

int frame = 0;

float ballX = 0;
float ballY = 0;
float ballRadius;
float ballSpeed;

float p1x1 = 0;
float p1x2 = 0;
float p1y1 = 0;
float p1y2 = 0;

float p2x1 = 0;
float p2x2 = 0;
float p2y1 = 0;
float p2y2 = 0;

float dy = 5;
float dx = 5;

Ball ball = new Ball(100,100,2,2);

class Ball { 
  float xPos, yPos, radius, speed; 

  Ball (float x, float y, float r, float s) {  
    xPos = x; 
    yPos = y;
    radius = r;
    speed = s; 
  }
  } 


void draw()
{
	background(0);
	rect(ball.xPos,ball.yPos,ball.radius,ball.radius);
	ball.xPos += dx;
	if(ball.xPos + ball.radius >= width)
		--dx;
	if(ball.xPos <= 0 )
		++dx;
}

