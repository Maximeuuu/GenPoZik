package genpozik.vue;

import genpozik.Controleur;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class PanelSelection extends JPanel
{
	private Controleur ctrl;
	private JTabbedPane panelTab;

	public PanelSelection( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.setPreferredSize( new Dimension(400,400) );

		this.panelTab = new JTabbedPane();
		this.panelTab.setUI( new CustomTabbedPaneUI() ); //HorizontalTabbedPaneUI
		//this.panelTab.setTabPlacement( JTabbedPane.RIGHT );
		this.panelTab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		this.panelTab.setPreferredSize( new Dimension(400,400) );

		this.panelTab.add( "1 - BG", new PanelBg( this.ctrl ) );
		this.panelTab.add( "2 - FG", new JLabel("Test2") );
		this.panelTab.add( "3 - TXT", new PanelTxt( this.ctrl ) );

		this.add( this.panelTab );
	}

	/**
	 * @author : ChatGPT
	 */
	 class CustomTabbedPaneUI extends BasicTabbedPaneUI {
		 /* //ne sert à rien
		 @Override
		 protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
			 return super.calculateTabAreaHeight(TOP, horizRunCount, maxTabHeight) - 5; // Ajustez cette valeur pour supprimer l'espacement
		 }

		 @Override
		 protected void installDefaults() {
			 super.installDefaults();
			 tabAreaInsets.left = 10;
			 tabAreaInsets.right = 10;
		 }

		 @Override
		 protected void layoutLabel(int tabPlacement, FontMetrics metrics, int tabIndex, String title, Icon icon,
									 Rectangle tabRect, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
			 super.layoutLabel(tabPlacement, metrics, tabIndex, title, icon, tabRect, iconRect, textRect, isSelected);

			 // Ajuster la position du texte pour le placer sous l'onglet
			 textRect.x = tabRect.x;
			 textRect.y = tabRect.y + tabRect.height + 5; // Ajustez cette valeur pour l'espacement souhaité
		 }
		 */
     }
 }
