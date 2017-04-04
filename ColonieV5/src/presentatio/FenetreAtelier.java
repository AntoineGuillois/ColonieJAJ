package presentatio;

import javax.swing.JFrame;

public class FenetreAtelier extends JFrame {
	
	public FenetreAtelier() {

		this.setTitle("Atelier");
		this.setSize(950, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instanciation d'un objet JPanel
		this.setContentPane(new Panneau());
	}

}
