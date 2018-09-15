int numberOfLines = 32;

void setup()
{
  size(640, 480);
}

void draw()
{
	lineCord xAxis = new lineCord(0,0,0,height);
	drawCurve(xAxis);
}


void drawCurve(lineCord xAxis)
{	
	for(int i = 0; i < numberOfLines; i++)
	{
		if(i % 3 == 0)
		{
			stroke(0);	
		}
		else 
		{
			stroke(128);
		}

		lineX1 = xAxis.x1;
		lineY1 = i * height / numberOfLines;

		lineX2 = i * width / numberOfLines;
		lineY2 = height;

		line(0, i * height / numberOfLines, i * width/numberOfLines, height);
	}
}

public class lineCord {
	float x1;
	float y1;
	float x2;
	float y2;

	lineCord(float x1,float y1,float x2,float y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

}

/*
int x1 = 20;
int y1 = 20;
int x2 = 20;
int y2 = 470;

int c1;
int c2;
int c3;

//class constructor for Line
public class Line {
int pos;
int axis1;
int axis2;
int numOfLines;

public Line(int position, int ax1, int ax2, int numLines)
{
	pos = position;
    axis1 = ax1;
    axis2 = ax2;
    
    numOfLines = numLines;

}
    public void Draw()
    {
    	for(int i = 0; i < numOfLines; i = i + 10)
    	{
    	line(pos, pos + i, axis1 + i, axis2);
    }
    }
}
//--->

Line myLine = new Line(20,20,20,30);

//draw lines
void draw()
{
	/*
	strokeWeight(1);
	
	background(255,255,255);

	for (int i = 0; i < height - 20; i = i + 10) {
		line(x1, y1 + i, x2 + i, y2);
	for (int j = 0; j < height - 20; j = j + 10){
		line(width-20, 470 - j, (620)-j, 20);
	

		if(i % 3 == 0)
		{
			c1 = 0; c2 = 0; c3 = 0;
		}
		if(j % 3 == 0)
		{
			c1 = 0; c2 = 0; c3 = 0;
		}
		else
		{
			c1 = 144; c2 = 144; c3 = 144;
		}
		stroke(c1,c2,c3);
		
}
}
myLine.Draw();
}
*/