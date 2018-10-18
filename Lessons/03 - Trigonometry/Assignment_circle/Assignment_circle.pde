/*

void setup()
{
	size(640, 480);
	strokeWeight(5);
}

//variables

float radius = 200, angle = 0, count = 10, slice = PI*2/count, x ,y;

void draw()
{
	background(0);
	strokeWeight(10);
	stroke(255);

	for(float i = 0; i < count; i++){
	float x = width/2 + sin(angle) * radius;		//sets the starting point in the middle, and spaces out the first point in the middle on the x-axis + 100;
	float y = height/2 + cos(angle) * radius;		//sets the starting point in the middle, and spaces out the first point in the middle on the y-axis + 100;
	point(x, y);
	angle += slice;									//sets points in an interval of each 36 degrees (PI*2 = 360 degrees);
}
}


void spiral()
{

}

*/
float frame = 0;
float t;
int r = 1000;
float cx, x;
float cy, y;
float a = 0.005;
void setup() {
    size(400, 400);
    cx = width / 2;
    cy = height / 2;
 
}
 
void draw() {
	background(0);
	strokeWeight(5);
	stroke(255,0,0);
    for (int i = 0; i < 100; i++) {
        t = radians(i) * frame;
        x = cx + a * (t * r * cos(t));
        y = cy + a * (t * r * sin(t));
        point(x, y);
    }

    frame+=0.05;

    if(frame > 20)
    	frame = 0;
}


