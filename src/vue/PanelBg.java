package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.Controleur;
import genpozik.vue.evenement.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBg extends JPanel implements PanelSaisieListener
{
	private Controleur ctrl;

	private SaisieRGB saisieCouleur1;
	private SaisieRGB saisieCouleur2;
	//BtnSelectionImage
	//directionDegrade
	//typeDegrade

	public PanelBg( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setLayout( new GridLayout(3,1) );

		// Création des composants
		this.saisieCouleur1 = new SaisieRGB();
		this.saisieCouleur2  = new SaisieRGB();

		// Ajout des composants
		this.add( new JLabel("Dégradé couleurs : ") );
		this.add( this.saisieCouleur1 );
		this.add( this.saisieCouleur2 );

		// Activation des composants
		this.saisieCouleur1.setPanelSaisieListener(this);
		this.saisieCouleur2.setPanelSaisieListener(this);
	}

	public void valueChanged()
	{
		Color coul1 =  this.saisieCouleur1.getCouleur();
		Color coul2 = this.saisieCouleur2.getCouleur();
		this.ctrl.majBg( coul1, coul2 );
	}
}
