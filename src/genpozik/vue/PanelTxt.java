package genpozik.vue;

import genpozik.modele.Texte;
import genpozik.Controleur;
import genpozik.vue.component.DynamicTabbedPane;
import genpozik.vue.component.TabItem;
import genpozik.vue.component.tabheader.ClosableTabHeader;
import genpozik.vue.event.*;

import javax.swing.*;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class PanelTxt extends DynamicTabbedPane implements PanelSaisieListener, TabAddListener, TabCloseListener
{
	private Controleur ctrl;

	private List<SaisieTexte> ensSaisieTexte;

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
		final int MAX_TAB = 3;
		if( tabIndex >= MAX_TAB ){ return null; }
		int id = tabCounter++;
		
		// Création des composants
		SaisieTexte saisieTexte = new SaisieTexte();
		this.ensSaisieTexte.add( saisieTexte );

		// Activation des composants
		saisieTexte.setPanelSaisieListener(this);

		return new TabItem( new ClosableTabHeader(this, "Texte " + id), saisieTexte);
	}
}
