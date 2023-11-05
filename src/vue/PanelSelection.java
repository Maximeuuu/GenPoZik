package genpozik.vue;

import genpozik.Controleur;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class PanelSelection extends JTabbedPane //re-placer un JPanel contenant le JTabbedPane pour les pb de hauteur ?
{
	private Controleur ctrl;
// problème avec les dimensiosn verticales
	public static final Dimension DIMENSION_TAB = new Dimension(250,400);

	public PanelSelection( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		this.setPreferredSize( PanelSelection.DIMENSION_TAB ); //hauteur marche pas ?
		this.setUI( new CustomTabbedPaneUI() ); //HorizontalTabbedPaneUI
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		// Creation et positionnement des composants
		this.add( "1 - BG", new PanelBg(this.ctrl) );
		this.add( "2 - FG", new PanelFg(this.ctrl) );
		this.add( "3 - TXT", new PanelTxt(this.ctrl) );
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
