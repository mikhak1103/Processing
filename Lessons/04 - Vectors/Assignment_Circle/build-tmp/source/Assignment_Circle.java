import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Assignment_Circle extends PApplet {

PVector circle;
PVector dir;
float speed;

boolean red = false;

public void setup() {
  
  
  background(255);
  circle = new PVector(100,100);
  dir = new PVector(0,0);
  speed = 3;
  stroke(255);
  noFill();
}

public void draw()
{
	background(0);


	dir.x = mouseX - circle.x; //Vector between the mouse's x and the circle's x
	dir.y = mouseY - circle.y; //Vector between the mouse's y and the circle's y

	dir.normalize(); 			//Lowers the speed at which the circle moves towards the mouse position

	circle.x = circle.x + (dir.x * speed);
	circle.y = circle.y + (dir.y * speed);	

	ellipse(circle.x,circle.y,16,16);
	

	if (red) {
		stroke(255,0,0);
	}
	else {
		stroke(255);
	}

}

public void mouseClicked() {
	red = !red;
}

/*
new Vector2(x,y);
Pvector(5.3)*5*dt;		//Processíng

//y is up in Unity
//magnitud är hypotenusan(?)

//lyftkraft == gravitation (flygplan) cancelleras av varandra
*/






/*
PVector v1, v2;

void setup() {
  noLoop();
  v1 = new PVector(40, 20);
  v2 = new PVector(25, 50); 
}

void draw() {
  ellipse(v1.x, v1.y, 12, 12);
  ellipse(v2.x, v2.y, 12, 12);
  v2.add(v1);
  ellipse(v2.x, v2.y, 24, 24);
}
*/








/*
class Circle 
{
	int x;
	int y;
	int radius;
	int speed;

	Circle(int xPos, int yPos, int cRadius, int cSpeed)
	{
		x = xPos;
		radius = cRadius;
		y = yPos;
		speed = cSpeed;
	}
}

Circle circle = new Circle(0, 0, 10, 1);
*/
  public void settings() {  size(500,500);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment_Circle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
