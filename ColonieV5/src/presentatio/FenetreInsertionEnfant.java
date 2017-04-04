package presentatio;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import ad.DAOException;
import ad.EnfantDAOImpl;
import entite.Enfant;

public class FenetreInsertionEnfant extends JFrame {
	public final Enfant e = new Enfant();

	public FenetreInsertionEnfant() throws DAOException {

		this.setTitle("Insérer un nouvel enfant");
		this.setSize(950, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instanciation d'un objet JPanel
		this.setContentPane(new Panneau());
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		JTextField nom = new JTextField(" Entrer le nom");
		JTextField prenom = new JTextField("Entrer le prenom");
		JTextField numero = new JTextField("Entrer le numero");
		JTextField ageEnfant = new JTextField("Entrer l'age de l'enfant");
		this.add(nom);
		this.add(prenom);
		this.add(numero);
		this.add(ageEnfant);
		nom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				e.setNomEnfant(nom.getText());
			}

		});
		prenom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				e.setPrenomEnfant(prenom.getText());
			}

		});
		numero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				e.setNumeroEnfant((numero.getText()));
			}

		});
		ageEnfant.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				e.setAgeEnfant(Integer.parseInt(ageEnfant.getText()));
				try {
					EnfantDAOImpl.getInstance().ajoutEnfant(e);
					
				} catch (DAOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
	}
	
}
