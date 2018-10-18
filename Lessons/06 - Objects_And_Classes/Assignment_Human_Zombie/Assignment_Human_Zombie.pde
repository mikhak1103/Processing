Character[] characters;
int numberOfCharacters = 100;
int numZombies = 1;
int num = 0;

float time;
float deltaTime;

void setup()
{
	size(800,600);

	characters = new Character[numberOfCharacters];

	for(int i = 0; i < numberOfCharacters; i++)
	{
		if(i >= numZombies) //spawns 99 humans
		{
			characters[i] = new Human();
		}
		else //spawns 1 zombie
		{
			characters[i] = new Zombie();
		}
	}
	
}

void draw()
{

	long currentTime = second();
  	deltaTime = (currentTime - time) * 0.05f; // we want this is seconds, fraction of a second

	background(120,120,120);

	for(int i = 0; i < numberOfCharacters; i++)
	{
		for(int j = 0; j < numberOfCharacters; j++)
		{
			boolean hasCollided = collision(characters[i].position.x,
											characters[i].position.y,
											characters[i].size/2,
											characters[j].position.x,
											characters[j].position.y,
											characters[j].size/2);
											
			if(hasCollided && (characters[i] instanceof Zombie || characters[j] instanceof Zombie) && !(characters[j] instanceof Zombie))
			{
				characters[j] = new Zombie();
				characters[j].size = 12;
				textSize(26); 
				text("Yummy!", characters[i].position.x, characters[i].position.y); //says yummy every time they eat a human
				num+=1;
			}
		}
			characters[i].update();

	}

	for(int i = 0; i < numberOfCharacters; i++)
	{
		characters[i].draw();
	}
	
	time = currentTime;
	scoreScreen();
}




//-----------------------------


class Character
{

PVector position;
PVector velocity;
int size = 10;
int z1 = 0;
int z2 = 255;
int z3 = 0;
int h1 = 255;
int h2 = 0;
int h3 = 0;

public Character()
{
	position = new PVector();
	position.x = random(0, width);
	position.y = random(0, height);

	velocity = new PVector();
	velocity.x = random(-2,2); //(5, -5)
	velocity.y = random(-2,2); //(5, -5)
}

	void draw()
	{
		ellipseMode(CENTER);
		ellipse(position.x - size/2, position.y - size/2, size, size);
	}

	void move()
	{

	}

	void checkCollision()
	{
		if(position.x >= width)
			position.x = 20;
		if(position.x <= 5)
			velocity.x *= -1;
		if(position.y >= height - 5 || position.y <= 5)
			velocity.y *= -1;
	}

	void update()
	{
		position.x += velocity.x;
		position.y += velocity.y;
		checkCollision();
	}

}

public class Human extends Character
{
	public Human()
	{
		super();
	}

	void draw()
	{
		fill(h1,h2,h3);
		size=12;
		super.draw();
	}

	void callFirstDraw()
	{
		super.draw();
	}
} 

public class Zombie extends Human
{
	public Zombie()
	{
		super();
		velocity.x = random(-1, 1);
		velocity.y = random(-1, 1);
	}

	void draw()
	{
		fill(z1, z2, z3);
		createArm("left");
		createArm("right");
		super.callFirstDraw();
		// ellipse(position.x - size/2, position.y - size/2, size, size);

	}

	private void createArm(String leftOrRight)
	{
		PVector arm;
		PVector hand;

		arm = new PVector();
		arm.x = position.x;
		arm.y = position.y;

		hand = new PVector();
		hand.x = position.x;
		hand.y = position.y;

		if(leftOrRight == "left")
		{
			line(arm.x, arm.y, arm.x + 8, arm.y + 8);
		}
		if(leftOrRight == "right")
		{
			line(arm.x, arm.y, arm.x -18, arm.y -18);
		}

		

	}

}



boolean collision(float x1, float y1, int size1, float x2, float y2, int size2)
{
	int maxDistance = size1 + size2;

	if(abs(x1 - x2) > maxDistance || abs(y1 - y2) > maxDistance)
	{
		return false;
	}
	else if(dist(x1, y1, x2, y2) > maxDistance)
	{
		return false;
	}
	else 
	{
		return true;		
	}
}





void scoreScreen()
{
	fill(255);
	rect(25, 570, 250, 20);
	fill(0);
	textSize(20);
	text("Time elapsed: " + time, 50, 570, width/2, 50);
}