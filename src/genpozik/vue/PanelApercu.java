package genpozik.vue;

import genpozik.Controleur;
import javax.swing.*;
import java.awt.Dimension;

public class PanelApercu extends JPanel
{
	private Controleur ctrl;
	private JLabel lblImageFond;
	private JLabel lblImageGeneree;

	public PanelApercu( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		this.setLayout( new OverlayLayout(this) );
		this.setPreferredSize( new Dimension(400,400) );

		// Creation des composants
		this.lblImageFond = new JLabel( new ImageIcon( Controleur.REP_IMAGE+"vide.png" ) );
		this.lblImageGeneree = new JLabel( new ImageIcon( this.ctrl.getImage() ) );

		// Positionnement des composants
		this.add( this.lblImageGeneree );
		this.add( this.lblImageFond );
	}

	public void maj()
	{
		this.lblImageGeneree.setIcon( new ImageIcon( this.ctrl.getImage() ) );
	}
}
