package presentatio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener {
	JPanel pan = new JPanel();
	private JButton boutonAtelier = new JButton("Atelier");
	private JButton boutonEnfant = new JButton("Enfant");

	public Fenetre() {

		this.setTitle("Colon");
		this.setSize(950, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instanciation d'un objet JPanel
		//this.setContentPane(new Panneau());
		//this.getContentPane().add(boutonAtelier, BorderLayout.SOUTH);
		boutonAtelier.setPreferredSize(new Dimension(500, 200));
		this.getContentPane().add(boutonEnfant, BorderLayout.WEST);
		boutonEnfant.setPreferredSize(new Dimension(500, 200));
		boutonAtelier.addActionListener(this);
		boutonEnfant.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == boutonAtelier) {
			this.setVisible(true);
			new FenetreAtelier().setVisible(true);
			this.setVisible(true);
		}
		if ((JButton) e.getSource() == boutonEnfant) {
			this.setVisible(true);
			new FenetreEnfant().setVisible(true);
		}
	}
}
