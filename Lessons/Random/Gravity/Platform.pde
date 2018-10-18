class Platform extends GameObject
{
  public Platform(PVector pos, PVector vel, PVector colStroke, PVector colFill, PVector r)
  {
    super(pos, vel, colStroke, colFill, r, health);

  }

  public void Update(float dt)
  {
    rect(pos.x, pos.y, r.x, r.y);
    if(pos.x > width)
      pos.x = 0;

    Move();
  }

  public void Move()
  {
    super.Move();
    pos.x += vel.x;

  }

}