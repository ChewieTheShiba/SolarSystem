import java.awt.*;
import java.util.*;

public class Planet
{
	private int x, y, radius;
	private double mass, gravity, xVel, yVel;
	private Color color;
	
	public Planet(int x, int y, int radius, double mass, Color color)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.mass = mass;
		this.color = color;
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

	public double getGravity()
	{
		return gravity;
	}

	public void setGravity(double gravity)
	{
		this.gravity = gravity;
	}
	
	public void drawPlanet(Graphics2D g)
	{
		g.setColor(color);
		g.fillOval((int)(x*SolarPanel.SCALINGFACTOR)+1920/2-radius, (int)(y*SolarPanel.SCALINGFACTOR)+1080/2-radius, radius*2, radius*2);
	}

}
