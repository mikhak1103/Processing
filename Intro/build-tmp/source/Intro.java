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

public class Intro extends PApplet {

public void setup()
{
  
}

public void draw()
{
  background(128,128,255);
  stroke(71);
  strokeWeight(13.9f);
  
  //M
  line(20,30,20,150);
  line(20,30,75,110);
  line(75,110,130,30);
  line(130,30,130,150);
  
  //I
  line(155,30,155,150);
  
  //C
  arc(240, 90, 130, 120, -4.9f, -HALF_PI);
  noFill();
  
  //H
  line(280,30,280,150);
  line(280,90,330,90);
  line(330,30,330,150);
  
  //A
  line(400,30,360,150);
  line(380,90,420,90);
  line(400,30,440,150);
  
  //E
  line(460,30,460,150);
  line(460,30,510,30);
  line(460,95,510,95);
  line(460,150,510,150);
  
  //L
  line(540,30,540,150);
  line(540,150,590,150);
  
  
  
  //m
  line(20,170,20,170);

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
public void setup()
{
	size(640, 480);
	printIn("Hello World");
	int number = 3;
	int anotherNumber = 5;

	number = number * anotherNumber;
	number = numbver * anotherNumber;

	String str = "CCCP";

	//i = i + 1;
	//i += 1;

	for(int i = 0; i < 12; i++)
	{
		line(i*20, 100, 200, 300);
	}
}

/*
	if(number > 128)
	{
		printIn(str + number);
	}
	else 
	{
		printIn("number: " + anotherNumber);	
	}
}
*/
  public void settings() {  size(768, 432); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Intro" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
