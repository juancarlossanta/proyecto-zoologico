package zoo.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import zoo.controllers.HabitatController;
import zoo.models.Animal;
import zoo.models.DomesticAnimal;
import zoo.models.WildAnimal;

@SuppressWarnings("serial")
public class AnimalInventory extends JFrame {

	private HabitatController animalController;

	private JPanel contentPane;
	private JTable table;
	private JPanel panelTabla;

	private JButton btnVer;
	private JButton btnVolver;

	private DefaultTableModel defaultTableModel;

	/**
	 * Create the frame.
	 */
	public AnimalInventory() {
//		logistics = new DeptLogistics();
		animalController = new HabitatController();
		initComponents();
		configActions();
	}

	private void configActions() {

		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!tieneFilaElegida(table)) {
					JOptionPane.showMessageDialog(null, "Por favor, elija un item.");
					return;
				}

				int id = (int) defaultTableModel.getValueAt(table.getSelectedRow(), 0);

				ViewAnimal.index = animalController.getIndexByAnimalId(id);

				ViewAnimal viewAnimal = new ViewAnimal();
				viewAnimal.setVisible(true);
				dispose();
			}
		});

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setVisible(true);
				dispose();
			}
		});

	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(40, 10, 670, 46);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);

		JLabel lblTitulo = new JLabel("INVENTARIO DE ANIMALES");
		lblTitulo.setBounds(12, 24, 646, 15);
		panelTitulo.add(lblTitulo);

		panelTabla = new JPanel();
		panelTabla.setBounds(40, 70, 670, 220);
		contentPane.add(panelTabla);
		panelTabla.setLayout(null);

		table = new JTable();
		table.setBounds(35, 58, 604, 204);
		panelTabla.add(table);

		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(40, 300, 670, 60);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);

		btnVer = new JButton("Ver");
		btnVer.setBounds(430, 20, 100, 25);
		panelBotones.add(btnVer);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(540, 20, 100, 25);
		panelBotones.add(btnVolver);

		cargarTabla();
	}

	private boolean tieneFilaElegida(JTable table) {
		return table.getSelectedRowCount() != 0 || table.getSelectedColumnCount() != 0;
	}

	private void cargarTabla() {

		String[] columnas = { "ID", "Nombre", "Fecha de Nacimiento", "Tipo" };

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 18, 646, 184);

		defaultTableModel = (DefaultTableModel) table.getModel();

		defaultTableModel.setColumnIdentifiers(columnas);

		panelTabla.add(scrollPane);

		Object[] objects = new Object[4];

		for (Animal animal : animalController.listAnimals()) {
			objects[0] = animal.getAnimalId();
			objects[1] = animal.getName();
			objects[2] = animal.getBirthdate();

			if (animal instanceof WildAnimal) {
				objects[3] = "Salvaje";
			} else if (animal instanceof DomesticAnimal) {
				objects[3] = "Domético";
			}

			defaultTableModel.addRow(objects);
		}

		table.setModel(defaultTableModel);
	}
}
