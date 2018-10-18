public class GameObject 
{
	float x, y;	
	float size;		
	PVector col;

	boolean alive = false;
	boolean next = false;
	int deathTime = 255;

	public GameObject (float x, float y, float size) 
	{
		this.x = x;
		this.y = y;
		this.size = size;
		this.col = new PVector(0,255,0);
	}

	void draw()
	{	
		if (alive) 
		{
			fill(col.x, col.y, col.z, 255);
		}
		else 
		{
			fill(255, 0, col.z, 255 - deathTime);		
			deathTime+=20;
		}
		ellipse(x, y, size, size);
	}
}