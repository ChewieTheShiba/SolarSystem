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
	public static final double GCONSTANT = 6.67408E-11, ASTROUNIT = 149.6e6 * 1000, SCALINGFACTOR = 30000 / ASTROUNIT;
	private double initialTheta, time;
	private Planet Earth;
	private Satellite SpaceShip;
	private Timer timer;
	
	
	//sets up the initial panel for drawing with proper size
	public SolarPanel(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
		
		time = 24*60*60;
		
		Earth = new Planet(0, 0, 50, 5.97219E24, Color.blue);
		SpaceShip = new Satellite((int)ASTROUNIT, 0, 25, 2.03E6);
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
		SpaceShip.drawSatellite(g);
		
		
	}
	
	public void update()
	{
		
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