package genpozik.vue;

import genpozik.vue.event.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SaisieRGB extends JPanel implements ChangeListener
{
	private static final Color COULEUR_DEFAUT = new Color(255,255,255,255);

	private PanelSaisieListener panelSaisieListener;

	private JSpinner spRouge;
	private JSpinner spVert;
	private JSpinner spBleu;
	private boolean opaciteActive;
	private JSpinner  spOpacite;

	public SaisieRGB( boolean opaciteActive )
	{
		// Configuration
		this.opaciteActive = opaciteActive;
		this.setLayout( new FlowLayout( FlowLayout.LEFT ) );

		// Création des composants
		this.spRouge = RGBSpinner(0);
		this.spVert  = RGBSpinner(0);
		this.spBleu  = RGBSpinner(0);
		if( opaciteActive ){ this.spOpacite = RGBSpinner(255); }

		// Positionnement des composants
		this.add( new JLabel("R:") ); this.add(this.spRouge);
		this.add( new JLabel("  V:") ); this.add(this.spVert);
		this.add( new JLabel("  B:") ); this.add(this.spBleu);
		if( opaciteActive ){ this.add( new JLabel("  O:") ); this.add(this.spOpacite); }

		// Activation des composants
		this.spRouge.addChangeListener( this );
		this.spVert.addChangeListener( this );
		this.spBleu.addChangeListener( this );
		if( opaciteActive ){ this.spOpacite.addChangeListener( this ); }
	}

	public SaisieRGB()
	{
		this( false );
	}

	private JSpinner RGBSpinner( int valeurInit )
	{
		SpinnerModel spinnerModel = new SpinnerNumberModel(valeurInit, 0, 255, 1);
		return new JSpinner( spinnerModel );
	}

	public Color getCouleur()
	{
		try
		{
			int rouge = (int) this.spRouge.getValue();
			int vert  = (int) this.spVert.getValue();
			int bleu  = (int) this.spBleu.getValue();
			if( !opaciteActive ){ return new Color( rouge, vert, bleu ); }

			int opacite = (int) this.spOpacite.getValue();
			return new Color( rouge, vert, bleu, opacite );
		}
		catch( Exception e ){}
		return COULEUR_DEFAUT;
	}

	public void setPanelSaisieListener( PanelSaisieListener listener )
	{
		this.panelSaisieListener = listener;
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		this.panelSaisieListener.valueChanged();
	}

}
