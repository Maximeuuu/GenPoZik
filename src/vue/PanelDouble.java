package genpozik.vue;

import java.io.File;
import genpozik.Controleur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelDouble extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private PanelApercu panelApercu;
	private PanelSelection panelSelection;
	private JButton btnGenerer;

	public PanelDouble( Controleur ctrl )
	{
		// Configuration
		this.ctrl = ctrl;
		this.setLayout( new BorderLayout() );
		//this.setPreferredSize( new Dimension(300,300) );

		// Creation des composants
		this.panelApercu = new PanelApercu( this.ctrl );
		this.panelSelection = new PanelSelection( this.ctrl );
		this.btnGenerer = new JButton("Générer");

		// Positionnement des composants
		JPanel pnlTmp = new JPanel( new FlowLayout() );
		//pnlTmp.setPreferredSize( new Dimension(400,400) );
		pnlTmp.add( this.panelApercu );
		this.add( pnlTmp, BorderLayout.EAST );

		pnlTmp = new JPanel( new FlowLayout() );
		//pnlTmp.setPreferredSize( new Dimension(400,400) );
		pnlTmp.add( this.panelSelection );
		this.add( pnlTmp, BorderLayout.WEST);

		pnlTmp = new JPanel( new FlowLayout() );
		pnlTmp.add( this.btnGenerer );
		this.add( pnlTmp, BorderLayout.SOUTH );

		// Activation des composants
		this.btnGenerer.addActionListener( this );
	}

	@Override
	public void actionPerformed( ActionEvent e )
	{
		String fileName = JOptionPane.showInputDialog(null, "Saisissez un nom de fichier :");
        if (fileName != null && !fileName.isEmpty()) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showDialog(null, "Sauvegarder");
            if (result == JFileChooser.APPROVE_OPTION) {
                String selectedDirectory = fileChooser.getSelectedFile().getAbsolutePath();
                String filePath = selectedDirectory + "/" + fileName;
                System.out.println("Chemin du fichier sauvegardé : " + filePath);
				this.ctrl.genererImage( new File(filePath) );
            }
        }
	}

	public void maj()
	{
		this.panelApercu.maj();
	}
}
