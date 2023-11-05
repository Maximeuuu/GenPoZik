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
		// Configuration
		this.ctrl = ctrl;
		this.setLayout( new FlowLayout(FlowLayout.LEADING) );

		// Création des composants
		JPanel panelGrille = new JPanel( new GridLayout(3,1) );
		this.saisieCouleur1 = new SaisieRGB();
		this.saisieCouleur2  = new SaisieRGB();

		// Positionnement des composants
		panelGrille.add( new JLabel("Dégradé couleurs : ") );
		panelGrille.add( this.saisieCouleur1 );
		panelGrille.add( this.saisieCouleur2 );
		this.add( panelGrille );

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
