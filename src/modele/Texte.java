package genpozik.modele;

import java.awt.Color;
import java.awt.Font;
/**
 * @author Maximeuuu
 * @date 03-11-23
 */
public class Texte
{
	private String texte;
	private int taille;
	private Color couleur;
	private Font font;
	//posX, posY, police....

	public Texte( String texte, int taille, Color couleur )
	{
		this.texte = texte;
		this.taille = taille;
		this.couleur = couleur;
		this.font = new Font("Liberation", Font.PLAIN, taille );
	}

	public Texte( String texte )
	{
		this( texte, 0, new Color(255,255,255) );
	}

	public Texte()
	{
		this( "" );
	}

	public void setTexte( String texte ){ this.texte = texte; }
	public void setTaille( int taille ){ this.taille = taille; this.font = new Font("Liberation", Font.PLAIN, taille ); }
	public void setCouleur( Color couleur ){ this.couleur = couleur; }
	private void setFont( Font font ){ this.font = font; }

	public String getTexte(){ return this.texte; }
	public int getTaille(){ return this.taille; }
	public Color getCouleur(){ return this.couleur; }
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
		return "Texte : " + this.texte + " ["+this.taille+"] " + this.couleur;
	}
}
