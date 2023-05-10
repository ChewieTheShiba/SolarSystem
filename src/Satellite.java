import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Satellite
{
	
	private int x, y, radius, ogx, ogy;
	private double mass, velocity, direction, time, orbitRadius, acceleration, force, xVel, yVel, OGYvel;
	private ArrayList<Point> orbit;
	private ImageIcon sprite;
	private String message;

	public Satellite(int x, int y, int radius, double mass, double yVel, ImageIcon sprite)
	{	
		this.x = x;
		this.y = y;
		ogx = x;
		ogy = y;
		this.radius = radius;
		this.mass = mass;
		message = "";
		orbit = new ArrayList<Point>();
		xVel = 0;
		this.sprite = sprite;
		//everything needs starting why velocity otherwise they just move in a line
		this.yVel = yVel;
		OGYvel = yVel;
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
	
	
	public void drawSatellite(JPanel panel, Graphics2D g)
	{
		sprite.paintIcon(panel, g, (int)(x*SolarPanel.SCALINGFACTOR-radius), (int)(y*SolarPanel.SCALINGFACTOR-radius));
	}
	
	public void getGravity(ArrayList<Planet> planets)
	{
		double tempXGrav = 0;
		double tempYGrav = 0;
		
		for(Planet p : planets)
		{

			double xDist = p.getX() - x;
			double yDist = p.getY() - y;
			double dist = Math.sqrt(xDist*xDist + yDist*yDist);
			
			double Gravity = SolarPanel.GCONSTANT * mass * p.getMass() / (dist*dist);
				
			double theta = Math.atan2(yDist, xDist);
				
			tempXGrav += Math.cos(theta) * Gravity;
			tempYGrav += Math.sin(theta) * Gravity;
			
			if(!p.getName().equals("Saturn"))	
			{	
				if(new Rectangle((int)(x*SolarPanel.SCALINGFACTOR)-radius, (int)(y*SolarPanel.SCALINGFACTOR)-radius, radius*2, radius*2).intersects((int)(p.getX()*SolarPanel.SCALINGFACTOR)-20, (int)(p.getY()*SolarPanel.SCALINGFACTOR)-20, 20, 20))
					message = "You Have Landed on " + p.getName();
			}		
			else
				if(new Rectangle((int)(x*SolarPanel.SCALINGFACTOR)-radius, (int)(y*SolarPanel.SCALINGFACTOR)-radius, radius*2, radius*2).intersects((int)(p.getX()*SolarPanel.SCALINGFACTOR)+50, (int)(p.getY()*SolarPanel.SCALINGFACTOR)-20, 20, 20))
					message = "You Have Landed on " + p.getName();

		}
		
		if(y*SolarPanel.SCALINGFACTOR < -500 || y*SolarPanel.SCALINGFACTOR > 1940 || x*SolarPanel.SCALINGFACTOR < -500 || x*SolarPanel.SCALINGFACTOR > 3060)
			message = "Your Crew Has Died";
		
		xVel += tempXGrav / mass * SolarPanel.time;
		yVel += tempYGrav / mass * SolarPanel.time;
		
		x += xVel * SolarPanel.time;
		y += yVel * SolarPanel.time;
		
		orbit.add(new Point((int)(x*SolarPanel.SCALINGFACTOR),(int)(y*SolarPanel.SCALINGFACTOR)));
		
		if(!message.equals(""))
		{
			SolarPanel.placedShip = false;
			sprite = new ImageIcon("");
		}
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void drawOrbit(Graphics2D g)
	{
		g.setColor(Color.pink);
		for(Point p : orbit)
			g.fillOval((int)p.getX(), (int)p.getY(), 5, 5);
	}
	
	
	
	
	
	
}
