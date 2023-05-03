
public class Satellite
{
	
	private int x, y;
	private double mass, velocity, direction, time, orbitRadius, acceleration, force, xVel, yVel;

	public Satellite(int x, int y, double mass)
	{
		this.x = x;
		this.y = y;
		this.mass = mass;
		xVel = 0;
		yVel = 0;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public double getMass()
	{
		return mass;
	}

	public void setMass(double mass)
	{
		this.mass = mass;
	}

	public double getVelocity()
	{
		return velocity;
	}

	public void setVelocity(double velocity)
	{
		this.velocity = velocity;
	}

	public double getDirection()
	{
		return direction;
	}

	public void setDirection(double direction)
	{
		this.direction = direction;
	}

	public double getTime()
	{
		return time;
	}

	public void setTime(double time)
	{
		this.time = time;
	}

	public double getOrbitRadius()
	{
		return orbitRadius;
	}

	public void setOrbitRadius(double orbitRadius)
	{
		this.orbitRadius = orbitRadius;
	}

	public double getAcceleration()
	{
		return acceleration;
	}

	public void setAcceleration(double acceleration)
	{
		this.acceleration = acceleration;
	}

	public double getForce()
	{
		return force;
	}

	public void setForce(double force)
	{
		this.force = force;
	}

	public double getxVel()
	{
		return xVel;
	}

	public void setxVel(double xVel)
	{
		this.xVel = xVel;
	}

	public double getyVel()
	{
		return yVel;
	}

	public void setyVel(double yVel)
	{
		this.yVel = yVel;
	}
	
	
	
	
	
	
}
