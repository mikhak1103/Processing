void setup()
{
	size(640, 480);
	strokeWeight(5);
}

int count = 100;
float angle = 0;
float angle2 = 0;
int amp = 120;
float inc = TWO_PI/50;

void draw()
{
	background(255);
	for(int i = 0; i <= count; i += 1)
	{
		stroke(0,0,0);
		float x = width/count * i;		// x point updates every 6.4 pixels, 100 times
		float y = sin(angle) * amp;		// update the y point of the curve for each update of the angle | amp = height of curve
		point(x, y + 120);			// y position of the curve starts at the middle of the screen
		angle = angle + inc;			// update the interval speed of which the curve moves (inc)
	}

	for(int i = 0; i <= count; i += 1)
	{
		stroke(255,0,0);
		float x = width/count * i;		// x point updates every 6.4 pixels, 100 times
		float y = cos(angle2) * amp;		// update the y point of the curve for each update of the angle | amp = height of curve
		point(x, y + 360);			// y position of the curve starts at the middle of the screen
		angle2 = angle2 + inc;			// update the interval speed of which the curve moves (inc)
	}
}
