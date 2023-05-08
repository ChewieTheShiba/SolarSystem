import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Planet
{
	private int x, y, radius;
	private double mass, gravity, xVel, yVel;
	private ImageIcon sprite;
	private String name;
	
	public Planet(int x, int y, int radius, double mass, ImageIcon sprite, String name)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.mass = mass;
		this.sprite = sprite;
		this.name = name;
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
	
	

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
	
	
	
	public int getRadius()
	{
		return radius;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	public void drawPlanet(JPanel panel, Graphics2D g)
	{
		sprite.paintIcon(panel, g, (int)(x*SolarPanel.SCALINGFACTOR-radius), (int)(y*SolarPanel.SCALINGFACTOR-radius));
	}

}
