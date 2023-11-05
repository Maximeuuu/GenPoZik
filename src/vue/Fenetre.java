package genpozik.vue;

import genpozik.Controleur;
import javax.swing.*;

public class Fenetre extends JFrame
{
	private PanelDouble panel;
	private Controleur ctrl;

	public Fenetre( Controleur ctrl )
	{
		super();

		this.ctrl = ctrl;

		this.setSize( 850,500 );
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel = new PanelDouble( this.ctrl );
		this.add( this.panel );

		this.setVisible(true);
	}

	public void maj()
	{
		this.panel.maj();
	}
}
