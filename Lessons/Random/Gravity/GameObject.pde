abstract class GameObject
{

PVector pos, vel, colStroke, colFill, r;
boolean enabled;

  	public GameObject(PVector pos, PVector vel, PVector colStroke, PVector colFill, PVector r, float health){
    this.pos = new PVector();
    this.pos.x = pos.x;
    this.pos.y = pos.y;
    this.pos.z = pos.z;

    this.vel = new PVector();
    this.vel.x = vel.x;
    this.vel.y = vel.y;
    this.vel.z = vel.z;

    this.colStroke = new PVector();
    this.colStroke.x = colStroke.x;
    this.colStroke.y = colStroke.y;
    this.colStroke.z = colStroke.z;

    this.colFill = new PVector();
    this.colFill.x = colFill.x;
    this.colFill.y = colFill.y;
    this.colFill.z = colFill.z;

	this.r = new PVector();
    this.r.x = r.x;
    this.r.y = r.y;
    this.r.z = r.z;
  	}

	public void Update(float dt)
	{
    stroke(colStroke.x, colStroke.y,colStroke.z);
    fill(colFill.x, colFill.y, colFill.z);
	}

	public void Move()
	{

	}
}