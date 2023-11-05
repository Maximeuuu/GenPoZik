package genpozik.vue;

import genpozik.Controleur;
import javax.swing.*;
import java.awt.*;

public class PanelDouble extends JPanel
{
	private Controleur ctrl;
	private PanelApercu panelApercu;
	private PanelSelection panelSelection;

	public PanelDouble( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		this.setLayout( new BorderLayout() );
		//this.setPreferredSize( new Dimension(300,300) );

		// Creation des composants
		this.panelApercu = new PanelApercu( this.ctrl );
		this.panelSelection = new PanelSelection( this.ctrl );

		// Positionnement des composants
		this.add( this.panelApercu, BorderLayout.EAST );
		this.add( this.panelSelection, BorderLayout.WEST );
	}

	public void maj()
	{
		this.panelApercu.maj();
	}
}
