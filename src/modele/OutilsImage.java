package genpozik.modele;

import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;

/**
 * Classe utilitaire permettant de traiter des images
 * @autor : Maximeuuu
 */
public final class OutilsImage
{
	/**
	 * Génère une ImageIcon redimensionnée à partir d'un fichier et d'une dimension
	 * @autor : Maximeuuu
	 */
	public static BufferedImage getResizeImage( Dimension dimension, BufferedImage imgOrigine )
	{
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		BufferedImage imgResize = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = imgResize.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.drawImage(imgOrigine, 0, 0, width, height, null);
		g2d.dispose();

		return imgResize;
	}

	/**
	 * Retourne ul'image fournie avec une nouvelle couleur
	 * @autor : Maximeuuu
	 */
	public static BufferedImage replaceColorInImage( BufferedImage image, Color couleur )
	{
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				Color pixelColor = new Color(image.getRGB(x, y));
				if (image.getRGB(x, y) != 0)// Ignore les pixels transparents
				{
					resultImage.setRGB(x, y, couleur.getRGB());
				}
			}
		}

		return resultImage;
	}

}
