void setup()
{
	size(640, 480);
	strokeWeight(2);
}

int count = 200;

void draw()
{
	background(255);
	for(int i = 0; i <= count; i+=5)
	{
		line(0, i * height/count, i * width/count, height);
		if(i % 3 == 0) 	//whenever the modulus of i is 3, make the line black
		{				//i.e if i is 15 (third line) it is black.
			stroke(0,0,0);
		}
		else
		{
			stroke(148);
		}
	}
}







































/*

//draw scanlines vertically

int frame = 0;

void draw()
{
	background(0);
	stroke(255);
	for(int i = 0; i < height; i+=10)
	{
		line(0, (i + frame) % height, width, (i + frame) % height); 	
		//Modulus up to height returns its own value, e.g (479 % 480 = 479), 
		//after it reaches height it restarts at 0 and so on.
	}
	frame++;
}



//draw scanlines horizontally

int frame = 0;

void draw() 
{
	background(0);
	stroke(255);
	for(int i = 0; i < width; i+=10)
	{
		line((i + frame) % width, 0, (i + frame) % width ,height);
	}
	frame++;
}

*/