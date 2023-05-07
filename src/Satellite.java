import java.awt.*;
import java.util.*;

public class Satellite
{
	
	private int x, y, radius;
	private double mass, velocity, direction, time, orbitRadius, acceleration, force, xVel, yVel, strongestGrav;
	private ArrayList<Point> orbit;
	private Planet strongest;

	public Satellite(int x, int y, int radius, double mass, double yVel)
	{	
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.mass = mass;
		strongest = null;
		orbit = new ArrayList<Point>();
		xVel = 0;
		//everything needs starting why velocity otherwise they just move in a line
		this.yVel = yVel;
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
		
		g.fillOval((int)(x*SolarPanel.SCALINGFACTOR)-radius, (int)(y*SolarPanel.SCALINGFACTOR)-radius, radius*2, radius*2);
	}
	
	public void getGravity(ArrayList<Planet> planets)
	{
		strongestGrav = 0;
		double tempXGrav = 0;
		double tempYGrav = 0;
		
		for(Planet p : planets)
		{

			double xDist = p.getX() - x;
			double yDist = p.getY() - y;
			double dist = Math.sqrt(xDist*xDist + yDist*yDist);
			
			if(xDist > 0 && yVel > 0)
				yVel *= -1;
			else if(xDist < 0 && yVel < 0)
				yVel *= -1;
			
			if(yDist < 0 && xVel > 0)
				xVel *= -1;
			else if(yDist > 0 && xVel < 0)
				xVel *= -1;
			
			double Gravity = SolarPanel.GCONSTANT * mass * p.getMass() / (dist*dist);
			
			if(Gravity > strongestGrav)
			{
				strongestGrav = Gravity;
				strongest = p;
				
				double theta = Math.atan2(yDist, xDist);
				
				System.out.println("hiiiiiiiii\t" + yVel);
				System.out.println("\t" + xVel);
				System.out.println(Math.cos(theta) * Gravity);
				System.out.println("xxxxxxxxx" + x);
				System.out.println("yyyyyyyyy" + y);
				
				tempXGrav = Math.cos(theta) * Gravity;
				tempYGrav = Math.sin(theta) * Gravity;
			}
		}
		
		xVel += tempXGrav / mass * SolarPanel.time;
		yVel += tempYGrav / mass * SolarPanel.time;
		
		x += xVel * SolarPanel.time;
		y += yVel * SolarPanel.time;
	}
	
	
	
	
}
