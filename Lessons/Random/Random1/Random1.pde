void setup()
{
	size(640, 480);
	strokeWeight(5);
}

int frame = 0;

float x = 0;
float y = 0;

void draw()
{


background(0);

int r1 = floor(random(255));
int r2 = floor(random(255));
int r3 = floor(random(255));
stroke(color(r1, r2, r3));
delay(500);

for(float i =10; i < width; i+=10)
{	
	for(float j =10; j < height; j+=10)
		{
			point(x + i, y + j);
		}
}
System.out.println(r1 + "," + r2 + "," + r3);
}




