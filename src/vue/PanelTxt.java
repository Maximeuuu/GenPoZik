package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.Controleur;
import genpozik.vue.evenement.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelTxt extends JPanel implements PanelSaisieListener
{
	private Controleur ctrl;

	private SaisieTexte saisieTexteAuteur;
	private SaisieTexte saisieTexteTitre;
	private SaisieTexte saisieTexteDate;

	public PanelTxt( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		this.setPreferredSize( PanelSelection.DIMENSION_TAB );
		this.setLayout( new FlowLayout(FlowLayout.LEADING) );

		// Création des composants
		JPanel panelGrille = new JPanel( new GridLayout(3,1) );
		this.saisieTexteAuteur = new SaisieTexte("Auteur : ");
		this.saisieTexteTitre  = new SaisieTexte("Titre : ");
		this.saisieTexteDate   = new SaisieTexte("Date : ");

		// Positionnement des composants
		panelGrille.add( this.saisieTexteAuteur );
		panelGrille.add( this.saisieTexteTitre );
		panelGrille.add( this.saisieTexteDate );
		this.add( panelGrille );

		// Activation des composants
		this.saisieTexteAuteur.setPanelSaisieListener(this);
		this.saisieTexteTitre.setPanelSaisieListener(this);
		this.saisieTexteDate.setPanelSaisieListener(this);
	}

	public void valueChanged()
	{
		Texte texteA = this.saisieTexteAuteur.getTexte();
		Texte texteT = this.saisieTexteTitre.getTexte();
		Texte texteD = this.saisieTexteDate.getTexte();

		this.ctrl.majTxt( texteA, texteT, texteD );
	}
}
