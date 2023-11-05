/*==============================================================================
Auteur        : Maxime Lemoine
Date création : 28/04/23
Dernière maj  : 05/11/23
Version       : 2
==============================================================================*/

package genpozik.vue;

import javax.swing.filechooser.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;

public class FileChooserImage extends JFileChooser
{
	public FileChooserImage()
	{
		super( FileSystemView.getFileSystemView().getDefaultDirectory() );

		/*Propriétés*/
		this.setDialogTitle("Charger image");
		this.setCurrentDirectory( new File("../data/") );

		/*filtrer les fichiers*/
		this.setFileSelectionMode( JFileChooser.FILES_ONLY );

		/*filtrer types de fichiers*/
		this.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (*.png, *.jpg, *.jpeg)", "jpg", "png", "jpeg");
		this.addChoosableFileFilter(filter);
	}
}
