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
	public static final double GCONSTANT = 6.67408E-11, ASTROUNIT = 149.6e6 * 1000, SCALINGFACTOR = 300000 / ASTROUNIT, OPPSCALINGFACTOR = 1/SCALINGFACTOR;
	private double initialTheta;
	public static double time;
	private Planet Earth, Mars;
	private Satellite SpaceShip;
	private Timer timer;
	private ArrayList<Planet> planets;
	
	
	//sets up the initial panel for drawing with proper size
	public SolarPanel(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
		
		time = 24*60;
		
		//Earth = new Planet((int)(((w/2 * OPPSCALINGFACTOR * 0))+100), (int) ((h/2 * OPPSCALINGFACTOR * 0)+100), 50, 5.97219E25, Color.blue);
		//Mars = new Planet((int)((w/2-200) * OPPSCALINGFACTOR), (int) (h/2 * OPPSCALINGFACTOR), 50, 5.97219E26, Color.red);
		Earth = new Planet((int)(500*OPPSCALINGFACTOR), (int)(500*OPPSCALINGFACTOR), 50, 5.97219E25, Color.blue);
		SpaceShip = new Satellite((int)(((w/2-300)*0 + 350) * OPPSCALINGFACTOR), (int) (((h/2+200)*0 + 400) * OPPSCALINGFACTOR), 25, 2.03E6, 7900);
		
		planets = new ArrayList<Planet>();
		planets.add(Earth);
		//planets.add(Mars);
		
		timer = new Timer(20, new ActionListen());
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
		g.setColor(Color.blue);
		Earth.drawPlanet(g);
		//Mars.drawPlanet(g);
		SpaceShip.drawSatellite(g);
		
		
	}
	
	public void update()
	{
		SpaceShip.getGravity(planets);
		System.out.println("hi");
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