package genpozik.vue;

import genpozik.Controleur;
import javax.swing.*;

public class PanelApercu extends JPanel
{
	private Controleur ctrl;
	private JLabel lblImage;

	public PanelApercu( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.lblImage = new JLabel( new ImageIcon( this.ctrl.getImage() ) );

		this.add( this.lblImage );
	}

	public void maj()
	{
		this.lblImage.setIcon( new ImageIcon( this.ctrl.getImage() ) );
	}
}
