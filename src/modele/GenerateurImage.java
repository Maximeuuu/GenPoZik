package genpozik.modele;

import java.awt.image.BufferedImage;
import java.io.File;

public class GenerateurImage extends ProprietesImage
{
	private CompositionImage image;

	public GenerateurImage()
	{
		super();
		image = new CompositionImage( 400,400, this );
	}

	public void maj(){ this.image.maj(); }
	public BufferedImage getImage(){ return this.image.getAppercu(); }
	public void genererImage( File fichier ){ this.image.enregistrer( fichier ); }
}
