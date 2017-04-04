package presentatio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ad.DAOException;

public class FenetreEnfant extends JFrame implements ActionListener{
	private JButton insererEnfant = new JButton("Inserer un enfant");

	public FenetreEnfant() {

		this.setTitle("Enfant");
		this.setSize(950, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instanciation d'un objet JPanel
		this.setContentPane(new Panneau());
		this.getContentPane().add(insererEnfant, BorderLayout.SOUTH);
		insererEnfant.setPreferredSize(new Dimension(300, 50));
		insererEnfant.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)  {
		if ((JButton) e.getSource() == insererEnfant) {
			this.setVisible(false);
			try {
				new FenetreInsertionEnfant().setVisible(true);
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
