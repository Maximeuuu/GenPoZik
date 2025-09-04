package genpozik.modele;

import java.awt.Color;
import java.awt.Point;
import java.awt.Font;
/**
 * @author Maximeuuu
 * @date 03-11-23
 */
public class Texte
{
	private static final String TEXTE_DEFAUT = "";
	private static final int TAILLE_DEFAUT = 0;
	private static final Color COULEUR_DEFAUT = new Color(255,255,255);
	private static final Point POSITION_DEFAUT = new Point(0,0);

	private String texte;
	private int taille;
	private Color couleur;
	private Font font;
	private Point position; //pb avec Point ? remplacer par X et Y ?
	//police....

	public Texte( String texte, int taille, Color couleur, Point position )
	{
		this.texte = texte;
		this.taille = taille;
		this.couleur = couleur;
		this.position = position;
		this.font = new Font("Liberation", Font.PLAIN, taille );
	}

	public Texte( String texte )
	{
		this( texte, TAILLE_DEFAUT, COULEUR_DEFAUT, POSITION_DEFAUT );
	}

	public Texte()
	{
		this( TEXTE_DEFAUT );
	}

	public void setTexte( String texte ){ this.texte = texte; }
	public void setTaille( int taille ){ this.taille = taille; this.font = new Font("Liberation", Font.PLAIN, taille ); }
	public void setCouleur( Color couleur ){ this.couleur = couleur; }
	public void setPosition( Point position ){ this.position = position; }
	private void setFont( Font font ){ this.font = font; }

	public String getTexte(){ return this.texte; }
	public int getTaille(){ return this.taille; }
	public Color getCouleur(){ return this.couleur; }
	public Point getPosition(){ return this.position; }
	public Font getFont(){ return this.font; }


	/*public static Color stringToColor( String couleur ) //chatGPT
	{
		// Divisez la chaîne en composantes de couleur
		String[] components = couleur.split(",");

		if (components.length == 3) {
		    try {
		        int red = Integer.parseInt(components[0].trim());
		        int green = Integer.parseInt(components[1].trim());
		        int blue = Integer.parseInt(components[2].trim());

		        // Créez un objet Color avec les composantes de couleur
		        return new Color(red, green, blue);

		        // Maintenant, 'color' contient la couleur spécifiée dans la chaîne
		    } catch (NumberFormatException e) {
		        // Gérez l'erreur de conversion en cas d'entiers invalides
		        e.printStackTrace();
		    }
		}

		return new Color(0,0,0,0);
	}*/

	public String toString()
	{
		return "Texte : " + this.texte + " ["+this.taille+"] " + this.couleur + "(" + this.position + ")";
	}
}
