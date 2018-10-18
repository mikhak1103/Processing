public ArrayList<Shape> shapes;
private float dt, lt;
public Circle circ1, circ2;
public Circle player;
public Bullet bullet;
public int numBullets = 10;
public float lastPress;


public void setup()
{
	size(640, 480);
	 shapes = new ArrayList<Shape>();
	 player = new Circle(0, 0, 25, 255, 0, 0);
	 circ1 = new Circle(300, 200, 50, 255, 255, 255);
     circ2 = new Circle(350, 400, 50, 255, 255, 255);
     bullet = new Bullet(player.pos.x, player.pos.y, 10, 255, 0, 0);
     
     shapes.add(circ1);
     shapes.add(circ2);
     shapes.add(player);
     shapes.add(bullet);
     
}


public void draw()
{
  tickDeltaTime();
  background(0);
  
  for(int i = 0; i < shapes.size(); i++)
  {
    shapes.get(i).update(dt);
  }


  if(getAxisRaw("Horizontal") == 1)
  {
  	player.pos.x += 5;
  }
  else if(getAxisRaw("Horizontal") == -1)
  {
  	player.pos.x -= 5;
  }
  if(getAxisRaw("Vertical") == 1)
  {
  	player.pos.y += 5;
  }
  else if(getAxisRaw("Vertical") == -1)
  {
  	player.pos.y -= 5;
  }


for(int i = 0; i < shapes.size(); i++)
{
         if(player.intersectsCircle(shapes.get(i)) && shapes.get(i) != player)
         	print("hit");
         else
         	;

}


}

public void tickDeltaTime()
{
  dt = (millis() - lt) * 0.001;
  lt = millis();
}


public abstract class Shape
{
  public PVector pos;
  public PVector vel;
  public float r;

  public Shape(float x, float y)
  {
    pos = new PVector(x, y);
    vel = new PVector(2, 2);
  }
  
  public void update(float dt)
  {
  	ellipseMode(CENTER);
  }

 public boolean intersectsCircle(Shape other)
  {
    return dist(pos.x, pos.y, other.pos.x, other.pos.y) < r + other.r;
  }

}


public class Circle extends Shape
{
  
  float c1;
  float c2;
  float c3;
  
  public Circle(float x, float y, float d, float c1, float c2, float c3)
  {
    super(x, y);
    this.r = d * 0.5;
    this.c1 = c1;
    this.c2 = c2;
    this.c3 = c3;
  }
  
  public void update(float dt)
  {
    super.update(dt);
    fill(c1, c2, c3);
    ellipse(pos.x, pos.y, r * 2, r * 2);
  }
}

public class Bullet extends Shape
{
	float c1, c2, c3;

	public Bullet(float x, float y, float d, float c1, float c2, float c3)
	{
		super(x, y);
		this.r = d * 0.5;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}

	public void shoot()
	{
	if(space && millis() - lastPress > 200)
	{
	lastPress = millis();
	pos.x += 5;
	lastPress = millis();
	}
	}

	public void update(float dt)
	{
    fill(c1, c2, c3);
    ellipse(pos.x, pos.y, r * 2, r * 2);
    shoot();
    
	}
}

