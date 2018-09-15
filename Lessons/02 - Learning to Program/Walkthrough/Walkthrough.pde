void setup()
{
  size(640, 480);
  background(0,0,0);
}

void draw()
{
	strokeWeight(1);
	stroke(255,255,255);
	int x1 = 20;
	int y1 = 20;
	int x2 = 20;
	int y2 = height-10;


	for(int i = 0; i < height - 20; i = i + 10)
	{
		line(x1, y1 + i, x2 + i, y2);
	}


}