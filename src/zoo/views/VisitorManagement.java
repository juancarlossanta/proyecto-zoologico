package zoo.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import zoo.controllers.VisitorController;
import zoo.models.Visitor;

@SuppressWarnings("serial")
public class VisitorManagement extends JFrame {

	private VisitorController visitorController;

	private JPanel contentPane;
	private JPanel panelTabla;
	private JTable table;
	private JButton btnVolver;
	private DefaultTableModel defaultTableModel;

	/**
	 * Create the frame.
	 */
	public VisitorManagement() {
		visitorController = new VisitorController();
		initComponents();
		configActions();

	}

	private void configActions() {
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 726, 359);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("LISTADO DE VISITANTES");
		lblTitulo.setBounds(40, 30, 620, 20);
		panel.add(lblTitulo);

		panelTabla = new JPanel();
		panelTabla.setBounds(40, 60, 640, 210);
		panel.add(panelTabla);
		panelTabla.setLayout(null);

		table = new JTable();
		table.setBounds(12, 12, 556, 163);
		panelTabla.add(table);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(563, 300, 117, 25);
		panel.add(btnVolver);

		cargarTabla();
	}

	private void cargarTabla() {

		String[] columnas = { "ID", "Cédula", "Nombre", "Dirección", "Teléfono" };

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 616, 186);
		panelTabla.add(scrollPane);

		defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setColumnIdentifiers(columnas);

		Object[] objects = new Object[5];
		for (Visitor visitor : visitorController.listVisitors()) {
			objects[0] = visitor.getVisitorId();
			objects[1] = visitor.getCedula();
			objects[2] = visitor.getName();
			objects[3] = visitor.getAddress();
			objects[4] = visitor.getPhone();
			defaultTableModel.addRow(objects);
		}
		table.setModel(defaultTableModel);
	}
}
