package zoo.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import zoo.controllers.TourController;
import zoo.models.Extra;
import zoo.models.Habitat;
import zoo.models.Tour;
import zoo.utils.ShowMessage;

@SuppressWarnings("serial")
public class AllTours extends JFrame {

	private TourController tourController;

	private JPanel contentPane;
	private JPanel panelTabla;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private JButton btnVender;
	private JButton btnVolver;

	/**
	 * Create the frame.
	 */
	public AllTours() {
		tourController = new TourController();
		initComponents();
		configActions();

	}

	private void configActions() {

		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!tieneFilaElegida(table)) {
					ShowMessage.generic("Por favor, elija un item.");
					return;
				}

				int id = (int) defaultTableModel.getValueAt(table.getSelectedRow(), 0);

				TourSales.tour = tourController.getTourById(id);
				TourSales sales = new TourSales();
				sales.setVisible(true);
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
		panelTitulo.setBounds(30, 20, 690, 45);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);

		JLabel lblNewLabel = new JLabel("TODOS LOS PLANES");
		lblNewLabel.setBounds(10, 15, 670, 15);
		panelTitulo.add(lblNewLabel);

		panelTabla = new JPanel();
		panelTabla.setLayout(null);
		panelTabla.setBounds(30, 70, 690, 210);
		contentPane.add(panelTabla);

		table = new JTable();
		table.setBounds(12, 12, 636, 184);
		panelTabla.add(table);

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(null);
		panelBotones.setBounds(30, 285, 690, 55);
		contentPane.add(panelBotones);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(570, 15, 100, 25);
		panelBotones.add(btnVolver);

		btnVender = new JButton("Vender");
		btnVender.setBounds(460, 15, 100, 25);
		panelBotones.add(btnVender);

		cargarTabla();
	}

	protected boolean tieneFilaElegida(JTable table2) {
		return table.getSelectedRowCount() != 0 || table.getSelectedColumnCount() != 0;
	}

	private void cargarTabla() {

		String[] columnas = { "ID", "TOUR", "PRECIO", "DESCUENTO", "HABITATS", "EXTRAS" };

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 15, 670, 170);

		defaultTableModel = (DefaultTableModel) table.getModel();

		defaultTableModel.setColumnIdentifiers(columnas);

		panelTabla.add(scrollPane);

		Object[] objects = new Object[6];

		/*
		 * private int id;
		 * 
		 * private String name;
		 * 
		 * private double price;
		 * 
		 * private double discount;
		 * 
		 * private List<Habitat> habitats;
		 * 
		 * private List<Extra> extras;
		 * 
		 */

		for (Tour tour : tourController.listTours()) {
			objects[0] = tour.getId();
			objects[1] = tour.getName();
			objects[2] = tour.getPrice();
			objects[3] = (int) (tour.getDiscount() * 100) + "%";
			objects[4] = getHabitats(tour.getHabitats());
			objects[5] = getExtras(tour.getExtras());

			defaultTableModel.addRow(objects);
		}

		table.setModel(defaultTableModel);

	}

	private String getExtras(List<Extra> extras) {
		String list = "";
		for (Extra extra : extras) {
			list += (extra.getName() + ", ");
		}
		return list.length() > 2 ? (String) list.subSequence(0, list.length() - 2) : list;
	}

	private String getHabitats(List<Habitat> habitats) {
		String list = "";
		for (Habitat habitat : habitats) {
			list += (habitat.getName() + ", ");
		}
		return list.length() > 2 ? (String) list.subSequence(0, list.length() - 2) : list;
	}
}
