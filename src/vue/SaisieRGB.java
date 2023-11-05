package genpozik.vue;

import genpozik.vue.evenement.*;

import java.util.regex.Pattern;
import javax.swing.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
		this.setLayout( new GridLayout(1, 4) );

		// Création des composants
        this.spRouge = RGBSpinner();
        this.spVert  = RGBSpinner();
        this.spBleu  = RGBSpinner();
		if( opaciteActive ){ this.spOpacite = RGBSpinner(); }

		// Positionnement des composants
        this.add(this.spRouge);
        this.add(this.spVert);
        this.add(this.spBleu);
		if( opaciteActive ){ this.add(this.spOpacite); }

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

	private JSpinner RGBSpinner()
	{
		SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 255, 1);
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
		System.out.println("Changement dans panel SaisieRGB");
		this.panelSaisieListener.valueChanged();
	}

}
