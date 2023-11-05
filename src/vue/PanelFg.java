package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.Controleur;
import genpozik.vue.evenement.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelFg extends JPanel implements PanelSaisieListener
{
	private Controleur ctrl;

	private SaisieRGB saisieCouleur;
	//BtnSelectionImage
	//listeFormesBasiques

	public PanelFg( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		this.setPreferredSize( PanelSelection.DIMENSION_TAB );
		this.setLayout( new FlowLayout(FlowLayout.LEADING) );

		// Création des composants
		JPanel panelGrille = new JPanel( new GridLayout(2,1) );
		this.saisieCouleur = new SaisieRGB( true );

		// Positionnement des composants
		panelGrille.add( new JLabel("Couleur : ") );
		panelGrille.add( this.saisieCouleur );
		this.add( panelGrille );

		// Activation des composants
		this.saisieCouleur.setPanelSaisieListener(this);
	}

	public void valueChanged()
	{
		Color coul = this.saisieCouleur.getCouleur();
		this.ctrl.majFg( coul );
	}
}
