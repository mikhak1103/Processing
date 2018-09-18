PVector randomVector;
PVector playerVector;
PVector differenceVector;
float rx, ry, rm;
float distanceX;
float distanceY;
boolean clicked = false;
boolean scored = false;
float diff;
float dx, dy, dm;
float px, py, pm;
int points = 0;
int score = 0;
int totalClicks = 0;

void setup()
{
	size(640, 480);
	background(0);
	randomVector = new PVector(rx, ry);
	playerVector = new PVector(px, py);
	differenceVector = new PVector(dx, dy);
}

void draw()
{
	background(0);
		String scoreText = "Score: " + score;
		text(scoreText, 10, 10, 70, 80);  // Text wraps within text box
		String pointsText = "You scored " + points + " point(s)!";
		text(pointsText, 10, 40, 70, 80);  // Text wraps within text box
		String clicksText = "Total clicks: " + totalClicks;
		text(clicksText, 10, 70, 70, 80);  // Text wraps within text box
}


void mouseClicked()
{
	if(true && focused)
	{
		execute();
	}
}

void mouseReleased()
{
	clicked = false;
	points = 0;
}

void execute()
{
		clicked = true;

		randomVector.x = floor(random(width));
		randomVector.y = floor(random(height));
		rx = randomVector.x;
		ry = randomVector.y;

		px = mouseX;
		py = mouseY;

		playerVector.x = px;
		playerVector.y = py;

		differenceVector.x = playerVector.x - randomVector.x;
		differenceVector.y = playerVector.y - randomVector.y;
		diff = floor(differenceVector.mag());

		fill(255,0,0);
		ellipse(rx, ry, 10, 10);
		fill(255);
		ellipse(px, py, 10, 10);
		stroke(255);
		line(px, py, rx, ry);

		if(diff <= 10)
			points += 50;
		if(diff > 11 && diff < 50)
			points +=10;
		if(diff > 50 && diff < 200)
			points +=5;
		else 
			points+=0;

		System.out.print("Clicked at: " + px + ", " + py + "\n" + "Circle is at: " + rx + ", " + ry + "\n" + "The difference is: " + diff + "\n" + "\n" + 
							"You scored " + points + " point(s)!" + "\n" + "\n");
		score += points;
		totalClicks += 1;
}