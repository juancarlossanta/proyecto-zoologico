package zoo.views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import zoo.controllers.HabitatController;
import zoo.models.Animal;
import zoo.models.DomesticAnimal;
import zoo.models.WildAnimal;

@SuppressWarnings("serial")
public class ViewAnimal extends JFrame {

	public static int index = 0;
	public static boolean enEdicion = false;

	private HabitatController habitatController;
	private List<Animal> animals;

	private JLabel lblFoto;
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblHabitat;
	private JLabel lblTipo;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnVolver;
	private JButton btnEditar;
	private JButton btnEliminar;

	/**
	 * Create the frame.
	 */
	public ViewAnimal() {
		habitatController = new HabitatController();
		animals = habitatController.listAnimals();
		initComponents();
		configActions();

	}

	private void configActions() {
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index--;
				cargarDatos();
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index++;
				cargarDatos();
			}
		});

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalInventory animalInventory = new AnimalInventory();
				animalInventory.setVisible(true);
				dispose();
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enEdicion = true;
				FormAnimal animal = new FormAnimal();
				animal.setVisible(true);
				dispose();
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	private void initComponents() {
		setBounds(100, 100, 750, 420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 726, 286);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnAnterior = new JButton("<");
		btnAnterior.setBounds(12, 116, 44, 25);
		panel.add(btnAnterior);

		JPanel pnlImg = new JPanel();
		pnlImg.setBounds(69, 22, 324, 250);
		panel.add(pnlImg);
		pnlImg.setLayout(null);

		lblFoto = new JLabel("");
		lblFoto.setBounds(12, 12, 300, 200);
		pnlImg.add(lblFoto);

		JPanel pnlInfo = new JPanel();
		pnlInfo.setBounds(405, 22, 250, 250);
		panel.add(pnlInfo);
		pnlInfo.setLayout(null);

		lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(12, 40, 150, 15);
		pnlInfo.add(lblCdigo);

		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 80, 150, 15);
		pnlInfo.add(lblNombre);

		lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(12, 120, 150, 15);
		pnlInfo.add(lblEdad);

		lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(12, 200, 150, 15);
		pnlInfo.add(lblTipo);

		lblHabitat = new JLabel("Habitat: ");
		lblHabitat.setBounds(12, 160, 150, 15);
		pnlInfo.add(lblHabitat);

		btnSiguiente = new JButton(">");
		btnSiguiente.setBounds(670, 116, 44, 25);
		panel.add(btnSiguiente);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(579, 330, 117, 25);
		getContentPane().add(btnVolver);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(315, 330, 120, 25);
		getContentPane().add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(447, 330, 120, 25);
		getContentPane().add(btnEliminar);

		cargarDatos();
	}

	private void cargarDatos() {

		if (index == animals.size()) {
			index = 0;
		}

		if (index < 0) {
			index = animals.size() - 1;
		}

		Animal animal = animals.get(index);

		String texto = "Tipo: ";

		int years = calcularEdad(animal.getBirthdate());

		lblCdigo.setText("Código: " + animal.getAnimalId());
		lblNombre.setText("Nombre: " + animal.getName());
		lblEdad.setText("Edad: " + years + " años");
		lblHabitat.setText("Habitat: " + habitatController.getNameByAnimalId(animal.getAnimalId()));

		if (animal instanceof WildAnimal) {
			texto += "Salvaje";
		} else if (animal instanceof DomesticAnimal) {
			texto += "Doméstico";
		}

		lblTipo.setText(texto);

		putImage(animal.getUrlImg());

	}

	private int calcularEdad(Date birthdate) {
		LocalDate curDate = LocalDate.now();
		LocalDate dob = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if ((dob != null) && (curDate != null)) {
			return Period.between(dob, curDate).getYears();
		} else {
			return 0;
		}
	}

	private void putImage(String imgName) {
		ImageIcon image = new ImageIcon(imgName);

		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
		lblFoto.setIcon(icon);
	}
}
