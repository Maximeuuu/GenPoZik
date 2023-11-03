package genpozik.vue;

import genpozik.Controleur;
import javax.swing.*;
import java.awt.*;

public class PanelBg extends JPanel
{
	private Controleur ctrl;
	private JLabel lblImage;
	private JTextField txtCoul1;
	private JTextField txtCoul2;

	public PanelBg( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.setLayout( new GridLayout(1,2) );

		this.lblImage = new JLabel("mon image");
		this.txtCoul1 = new JTextField("Couleur 1 : ");
		this.txtCoul2 = new JTextField("Couleur 2 : ");

		JPanel panelTmp = new JPanel();
		panelTmp.setLayout( new GridLayout(2,1) );
		panelTmp.add( this.txtCoul1 );
		panelTmp.add( this.txtCoul2 );

		this.add( panelTmp );
		this.add( this.lblImage );
	}
}
