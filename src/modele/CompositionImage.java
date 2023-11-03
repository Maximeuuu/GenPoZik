package genpozik.modele;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CompositionImage extends BufferedImage
{
	private int longueur;
	private int hauteur;
	private Graphics2D toile;
	private ProprietesImage proprietes;

	public CompositionImage( int longueur, int hauteur, ProprietesImage proprietes )
	{
		super(longueur, hauteur, BufferedImage.TYPE_INT_ARGB);
		this.longueur = longueur;
		this.hauteur = hauteur;
		this.toile = this.createGraphics();
		this.proprietes = proprietes;
	}

	public void maj()
	{
		this.toile = this.createGraphics();
		this.placerBackground();
		this.placerForeground();
		this.placerTexte();
		toile.dispose();
	}

	public BufferedImage getAppercu()
	{
		return this;
	}

	private void placerBackground()
	{
		if( this.proprietes.estImageBgMode() )
		{
			try
			{
				BufferedImage imageBg = ImageIO.read( this.proprietes.getCheminImageBg() );
				toile.drawImage(imageBg, 0, 0, null);
			}
			catch (IOException e){ e.printStackTrace(); }
		}
		else
		{
			// Définir le dégradé
			GradientPaint gradient = new GradientPaint(this.longueur, 0, this.proprietes.getCouleurBg1(), 0, this.hauteur, this.proprietes.getCouleurBg2());

			// Remplir le carré avec le dégradé
			toile.setPaint(gradient);
			toile.fillRect(0, 0, this.longueur, this.hauteur);
		}
	}

	private void placerForeground()
	{
		try
		{
			BufferedImage image = ImageIO.read(  this.proprietes.getCheminImageModeleFg() );
			image = OutilsImage.getResizeImage( new Dimension(this.longueur, this.hauteur), image);
			image = OutilsImage.replaceColorInImage( image, this.proprietes.getCouleurFg() );
			toile.drawImage(image, 0, 0, null);
		}
		catch (IOException e){ e.printStackTrace(); }
	}

	private void placerTexte()
	{
		this.placerTexte( this.proprietes.getAuteur(), 20,200 );
		this.placerTexte( this.proprietes.getTitre(), 200,200 );
		this.placerTexte( this.proprietes.getDate(), 300,20 );
	}

	private void placerTexte( Texte texte, int x, int y )
	{
		this.toile.setColor( texte.getCouleur() );
		this.toile.setFont( texte.getFont() );
		this.toile.drawString( texte.getTexte(), x, y);
	}

	private void enregistrer()
	{
		try {
            File outputImage = new File("image.png");
            ImageIO.write(getAppercu(), "png", outputImage);
            System.out.println("L'image a été enregistrée avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}