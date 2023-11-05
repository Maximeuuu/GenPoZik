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
		this.ctrl = ctrl;
		this.setLayout( new GridLayout(2,1) );

		// Création des composants
		this.saisieCouleur = new SaisieRGB( true );

		// Ajout des composants
		this.add( new JLabel("Couleur : ") );
		this.add( this.saisieCouleur );

		// Activation des composants
		this.saisieCouleur.setPanelSaisieListener(this);
	}

	public void valueChanged()
	{
		Color coul = this.saisieCouleur.getCouleur();
		this.ctrl.majFg( coul );
	}
}
