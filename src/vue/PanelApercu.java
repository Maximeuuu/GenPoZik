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

		// Creation des composants
		this.lblImageFond = new JLabel( new ImageIcon( Controleur.REP_IMAGE+"vide.png" ) );
		this.lblImageFond.setPreferredSize( new Dimension(400,400) );
		this.lblImageGeneree = new JLabel( new ImageIcon( this.ctrl.getImage() ) );
		this.lblImageGeneree.setPreferredSize( new Dimension(400,400) );

		// Positionnement des composants

		this.add( this.lblImageGeneree );
		this.add( this.lblImageFond );
	}

	public void maj()
	{
		this.lblImageGeneree.setIcon( new ImageIcon( this.ctrl.getImage() ) );
	}
}
