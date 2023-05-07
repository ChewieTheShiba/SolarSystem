import java.awt.*;
import java.util.*;

public class Satellite
{
	
	private int x, y, radius;
	private double mass, velocity, direction, time, orbitRadius, acceleration, force, xVel, yVel, strongestGrav, xGrav, yGrav;
	private ArrayList<Point> orbit;
	private Planet strongest;

	public Satellite(int x, int y, int radius, double mass)
	{	
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.mass = mass;
		strongest = null;
		orbit = new ArrayList<Point>();
		xVel = 0;
		yVel = 0;
		xGrav = 0;
		yGrav = 0;
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
	
	
	public void drawSatellite(Graphics2D g)
	{
		g.setColor(Color.black);
		System.out.println(x);
		System.out.println(SolarPanel.SCALINGFACTOR);
		
		g.fillOval((int)(x*SolarPanel.SCALINGFACTOR)+1920/2-radius, (int)(y*SolarPanel.SCALINGFACTOR)+1080/2-radius, radius*2, radius*2);
	}
	
	public double getGravity(ArrayList<Planet> planets)
	{
		strongestGrav = 0;
		
		for(Planet p : planets)
		{

			double xDist = x - p.getX();
			double yDist = y - p.getY();
			double dist = Math.sqrt(xDist*xDist + yDist*yDist);
			
			double Gravity = SolarPanel.GCONSTANT * mass * p.getMass() / (dist*dist);
			
			if(Gravity > strongestGrav)
			{
				strongestGrav = Gravity;
				strongest = p;
				
				double theta = 0;
				
				if(xDist != 0)
					theta = Math.atan(yDist/xDist);
				else
					theta = Math.atan(yDist/0.000001);
				
				xGrav = Math.cos(theta) * Gravity;
				yGrav = Math.sin(theta) * Gravity;
			}
		}
			
		
	}
	
	
	
}
