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
	private Planet Earth, Mars, Jupiter, Venus;
	private Satellite SpaceShip;
	private Timer timer;
	private ArrayList<Planet> planets;
	private JPanel panel;
	public static boolean placedShip;
	
	
	//sets up the initial panel for drawing with proper size
	public SolarPanel(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
		
		time = 24*60;
		
		placedShip = false;
		
		panel = new JPanel();
		
		Venus = new Planet((int)(400*OPPSCALINGFACTOR), (int)(500*OPPSCALINGFACTOR), 45, 4.867E25, new ImageIcon("assets/Venus.png"), "Venus");
		Earth = new Planet((int)(500*OPPSCALINGFACTOR), (int)(1000*OPPSCALINGFACTOR), 50, 5.97219E25, new ImageIcon("assets/Earth.png"), "Earth");
		Mars = new Planet((int)(900*OPPSCALINGFACTOR), (int)(500*OPPSCALINGFACTOR), 40, 6.39E24, new ImageIcon("assets/Mars.png"), "Mars");
		Jupiter = new Planet((int)(1800*OPPSCALINGFACTOR), (int)(1000*OPPSCALINGFACTOR), 56, 8.898E25, new ImageIcon("assets/Jupiter.png"), "Jupiter");
		
		planets = new ArrayList<Planet>();
		planets.add(Venus);
		planets.add(Earth);
		planets.add(Mars);
		planets.add(Jupiter);
		
		timer = new Timer(20, new ActionListen());
		timer.start();
		this.add(panel);
		this.addMouseListener(new MouseListen());
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
		for(Planet p : planets)
			p.drawPlanet(panel, g);
		
		g.setFont(new Font("Comic Sans", Font.PLAIN, 36));
			
		if(placedShip)
		{
			SpaceShip.drawSatellite(panel, g);
			if(!SpaceShip.getMessage().equals(""))
				g.drawString(SpaceShip.getMessage(), w/2-150, 30);
		}
		
		if(!placedShip && SpaceShip == null)
			g.drawString("Click to Place Ship", w/2-150, 25);
		else if(!placedShip)
			g.drawString(SpaceShip.getMessage() + ". Click to Place Ship", w/2-350, 25);
		
		
		
	}
	
	public void update()
	{
		if(placedShip)
			SpaceShip.getGravity(planets);
		
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
	
	private class MouseListen implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			if(!placedShip)
			{
				SpaceShip = new Satellite((int)(e.getPoint().getX() * OPPSCALINGFACTOR), (int) (e.getPoint().getY() * OPPSCALINGFACTOR), 58, 2.03E6, 7000, new ImageIcon("assets/Rocket.png"));
				placedShip = true;
			}
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}