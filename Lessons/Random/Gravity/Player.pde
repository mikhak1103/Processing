class Player extends GameObject
{
  public Player(PVector pos, PVector vel, PVector colStroke, PVector colFill, PVector r, float health)
  {
    super(pos, vel, colStroke, colFill, r, health);
  }

  public void Update(float dt)
  {
  	fill(colFill.x, colFill.y, colFill.z);
    rect(pos.x, pos.y, r.x, r.y);
	Move();
  }

  public void Move()
  {
    super.Move();

    if(moveLeft && moveRight)
    {
    }
    else if(moveRight)
    {
      pos.x += vel.x;
    }
    else if(moveLeft)
      pos.x -= vel.x;

  	if(moveUp && moveDown)
  	{
  	}
  	else if(moveUp)
  		pos.y -= vel.y;
  	else if(moveDown)
  		pos.y += vel.y;


  	



  	}



  	public void gather()
  	{
  		println("gathering material!");
   	}

}








    /*
    if(falling)
    {
    vel.y += gravity;
    pos.y += vel.y;
	}

	*/