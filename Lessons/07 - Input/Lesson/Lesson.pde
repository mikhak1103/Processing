//Input and collision

PVector position;
float speed = 5;

void setup()
{
	size(1024, 1024);
	position = new PVector(width/2, height/2);
	ellipseMode(CENTER);
}

void draw()
{
	background(0);
	strokeWeight(3);
	stroke(255);
	fill(0);

	float xMovement = getAxisRaw("Horizontal") * speed;
	float yMovement = getAxisRaw("Vertical") * speed;

	position.x += xMovement;
	position.y += yMovement;

	ellipse(position.x, position.y, 50, 50);
}




