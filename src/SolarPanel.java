//all imports are necessary
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;

//must 'extend' JPanel 
//You can rename the class to anything you wish - default is 'PanelTemplate'
public class SolarPanel extends JPanel
{
	//variables for the overall width and height
	private int w, h;
	private final double GCONSTANT = 6.67408E-11;
	private double initialTheta, timeChange;
	private Planet Earth;
	private Satellite SpaceShip;
	private Timer timer;
	
	
	//sets up the initial panel for drawing with proper size
	public SolarPanel(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
		
		
		Earth = new Planet(w/2, h/2, 5.97219E24);
		SpaceShip = new Satellite(1200, 300, 2.03E6);
		
		timeChange = 0.001;
		
		timer = new Timer(30, new ActionListen());
		timer.start();
	}
	
	
	//all graphical components go here
	//this.setBackground(Color c) for example will change background color
	public void paintComponent(Graphics tg)
	{
		//this line sets up the graphics - always needed
		super.paintComponent(tg);
		Graphics2D g = (Graphics2D) tg;
		
		//all drawings below here:
		g.setColor(Color.black);
		g.fillOval(SpaceShip.getX()-25, SpaceShip.getY()-25, 50, 50);
		g.setColor(Color.blue);
		g.fillOval(Earth.getX()-50, Earth.getY()-50, 100, 100);
		System.out.println(SpaceShip.getX());
		System.out.println(SpaceShip.getY());

		System.out.println(Math.atan((SpaceShip.getY()-Earth.getY())/(SpaceShip.getX()-Earth.getX())));
		System.out.println(SpaceShip.getY()-Earth.getY());
		System.out.println(SpaceShip.getX()-Earth.getX());
		System.out.println(SpaceShip.getVelocity());
		System.out.println(SpaceShip.getForce());
		System.out.println(SpaceShip.getxVel());
		System.out.println(SpaceShip.getyVel());
		System.out.println(SpaceShip.getOrbitRadius());
		System.out.println(Math.sin(initialTheta));
		System.out.println(initialTheta);
		System.out.println(Earth.getGravity());
		System.out.println();
		
		//System.out.println();
		//System.out.println(SpaceShip.getX());
		//System.out.println(SpaceShip.getY());
		
	}
	
	public void update()
	{
		SpaceShip.setOrbitRadius((Math.sqrt(Math.pow(Earth.getX()-SpaceShip.getX(), 2)+Math.pow(Earth.getY()-SpaceShip.getY(), 2))));  
		SpaceShip.setVelocity(GCONSTANT * Earth.getMass() / SpaceShip.getOrbitRadius());
		SpaceShip.setTime(Math.sqrt((4*Math.PI*Math.PI*SpaceShip.getOrbitRadius()*SpaceShip.getOrbitRadius()*SpaceShip.getOrbitRadius())/(GCONSTANT*(Earth.getMass()+SpaceShip.getMass()))));
		
		//System.out.println("gggg\t" + ( * SpaceShip.getMass()));
		
		Earth.setGravity(GCONSTANT*(Earth.getMass())*(SpaceShip.getMass())/((SpaceShip.getOrbitRadius())*(SpaceShip.getOrbitRadius())));
		SpaceShip.setAcceleration(Earth.getGravity()/SpaceShip.getMass());
		SpaceShip.setForce(Earth.getGravity());
		SpaceShip.setOrbitRadius(SpaceShip.getOrbitRadius()-SpaceShip.getAcceleration()+SpaceShip.getVelocity());
		
		double xForce = Math.cos(initialTheta) * SpaceShip.getForce();
		double yForce = Math.sin(initialTheta) * SpaceShip.getForce();
		
		SpaceShip.setxVel(SpaceShip.getxVel() + xForce / SpaceShip.getMass());
		SpaceShip.setyVel(SpaceShip.getyVel() + yForce / SpaceShip.getMass());
		
		//System.out.println(SpaceShip.getOrbitRadius());
		
		
		//System.out.println(SpaceShip.getTime());
		
		//System.out.println("start\t" + SpaceShip.getVelocity());
		//System.out.println(SpaceShip.getOrbitRadius());
		//System.out.println(timeChange);
		//System.out.println("tChange\t" + 45);
		
		//if(SpaceShip.getX()-Earth.getX() != 0)
			initialTheta = Math.atan((SpaceShip.getY()-Earth.getY())/(SpaceShip.getX()-Earth.getX()));
		
		//else
			//initialTheta = Math.atan((SpaceShip.getY()-Earth.getY())/(0.0000001));
		
		System.out.println("tttttttt\t" + initialTheta);
		
		//System.out.println("xxxxx\t" + SpaceShip.getOrbitRadius());
		//System.out.println("yyyyyyyyy\t" + initialTheta);
		//System.out.println(Earth.getMass());
		//System.out.println(SpaceShip.getMass());
		//System.out.println(SpaceShip.getOrbitRadius());
		//System.out.println(Earth.getGravity());
		
		SpaceShip.setX(SpaceShip.getX()+(int)SpaceShip.getxVel());
		SpaceShip.setY(SpaceShip.getY() + (int)SpaceShip.getyVel());
		
		if(SpaceShip.getX() > 0 && SpaceShip.getY() > 0)
			repaint();
	}
	
	private class ActionListen implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			
			if(source.equals(timer))
			{
				update();
			}
			
		}
		
	}
}