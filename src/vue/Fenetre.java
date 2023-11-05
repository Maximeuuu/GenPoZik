package genpozik.vue;

import genpozik.Controleur;
import javax.swing.*;

public class Fenetre extends JFrame
{
	private PanelDouble panel;
	private Controleur ctrl;

	public Fenetre( Controleur ctrl )
	{
		// Configuration
		super();
		this.ctrl = ctrl;
		this.setSize( 800,600 );
		this.setTitle("GenPoZik");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Création du panel
		this.panel = new PanelDouble( this.ctrl );

		// Positionnement du panel
		this.add( this.panel );

		// Activation
		this.setVisible(true);
	}

	public void maj()
	{
		this.panel.maj();
	}
}
