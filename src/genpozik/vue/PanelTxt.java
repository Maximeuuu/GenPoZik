package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.Controleur;
import genpozik.vue.PanelSelection.CustomTabbedPaneUI;
import genpozik.vue.component.DynamicTabbedPane;
import genpozik.vue.component.TabItem;
import genpozik.vue.component.tabheader.ClosableTabHeader;
import genpozik.vue.event.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PanelTxt extends DynamicTabbedPane implements PanelSaisieListener, TabAddListener, TabCloseListener
{
	private Controleur ctrl;

	private List<SaisieTexte> ensSaisieTexte;

	/*public PanelTxt( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		//this.setPreferredSize( PanelSelection.DIMENSION_TAB );
		this.setLayout( new FlowLayout(FlowLayout.LEFT) );

		// Création d'un JScrollPane pour permettre le défilement
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(PanelSelection.DIMENSION_TAB);

		// Création des composants
		JPanel panelGrille = new JPanel( new GridLayout(4,1) );
		this.saisieTexteAuteur = new SaisieTexte(" 1. Auteur");
		this.saisieTexteTitre  = new SaisieTexte(" 2. Titre");
		this.saisieTexteDate   = new SaisieTexte(" 3. Date");

		// Positionnement des composants
		panelGrille.add( this.saisieTexteAuteur );
		panelGrille.add( this.saisieTexteTitre );
		panelGrille.add( this.saisieTexteDate );
		panelGrille.add( new JLabel("") ); //nécessaire car JScrollPane pas assez grand ?
		this.add( panelGrille );

		// Ajout du panelGrille dans le JScrollPane
        scrollPane.getViewport().add(panelGrille);

        // Ajout du JScrollPane au PanelTxt
        this.add(scrollPane);

		// Activation des composants
		this.saisieTexteAuteur.setPanelSaisieListener(this);
		this.saisieTexteTitre.setPanelSaisieListener(this);
		this.saisieTexteDate.setPanelSaisieListener(this);
	}*/

	public PanelTxt( Controleur ctrl )
	{
		this.ensSaisieTexte = new ArrayList<>();

		// Configuration
		this.ctrl = ctrl;
		this.setPreferredSize( PanelSelection.DIMENSION_TAB );
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		// Ajout des listeners
		this.setTabAddListener(this);
		this.setTabCloseListener(this);
	}

	public void valueChanged()
	{
		List<Texte> ensTexte = new ArrayList<>();
		for( SaisieTexte saisieTexte : this.ensSaisieTexte )
		{
			ensTexte.add( saisieTexte.getTexte() );
		}

		this.ctrl.majTxt( ensTexte );
	}

	@Override
	public void onClose(int tabIndex, Component component)
	{
		if( component instanceof SaisieTexte )
		{
			this.ensSaisieTexte.remove(component);
		}
		this.valueChanged();
	}

	private static int tabCounter = 1;
	
	@Override
	public TabItem onAdd(int tabIndex)
	{
		if( tabIndex >= 3 ){ return null;}
		int id = tabCounter++;
		
		// Création des composants
		SaisieTexte saisieTexte = new SaisieTexte();
		this.ensSaisieTexte.add( saisieTexte );

		// Activation des composants
		saisieTexte.setPanelSaisieListener(this);

		return new TabItem( new ClosableTabHeader(this, "Texte " + id), saisieTexte);
	}
}
