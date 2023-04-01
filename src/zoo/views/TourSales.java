package zoo.views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import zoo.controllers.SalesController;
import zoo.controllers.TourController;
import zoo.controllers.VisitorController;
import zoo.models.Sale;
import zoo.models.Tour;
import zoo.models.Visitor;
import zoo.utils.ShowMessage;
import zoo.utils.Today;

@SuppressWarnings("serial")
public class TourSales extends JFrame {

	public static Tour tour = null;

	private int cantidad;
	private double valorVenta;

	private SalesController salesController;
	private VisitorController visitorController;
	private TourController tourController;

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCedula;
	private JTextField txtNumeroBoletos;
	private JTextField txtTotal;
	private JComboBox<Object> cbxTipo;
	private JLabel lbltotalVenta;
	private JLabel lblDescuento;
	private JButton btnVender;
	private JButton btnCalcular;
	private JButton btnVolver;
	private JTextField txtTotalVenta;
	private JTextField txtDescuento;

	/**
	 * Create the frame.
	 */
	public TourSales() {
		salesController = new SalesController();
		visitorController = new VisitorController();
		tourController = new TourController();
		initComponents();
		configActions();

	}

	private void configActions() {
		txtCedula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				rellenarCampos();
			}
		});

		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!todoValido())
					return;
				calcularVenta();
				realizarVenta();
				ShowMessage.info("La venta se ha realizado con exito!");
				limpiar();
			}
		});

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!todoValido())
					return;
				calcularVenta();
			}

		});

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

		JPanel pnlInfoVisitante = new JPanel();
		pnlInfoVisitante.setBounds(12, 0, 726, 89);
		contentPane.add(pnlInfoVisitante);
		pnlInfoVisitante.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(397, 30, 70, 15);
		pnlInfoVisitante.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(485, 30, 150, 20);
		pnlInfoVisitante.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(397, 60, 70, 15);
		pnlInfoVisitante.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(485, 60, 150, 20);
		pnlInfoVisitante.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(30, 60, 70, 15);
		pnlInfoVisitante.add(lblTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(155, 60, 150, 20);
		pnlInfoVisitante.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblCedula = new JLabel("Identificación");
		lblCedula.setBounds(30, 30, 95, 15);
		pnlInfoVisitante.add(lblCedula);

		txtCedula = new JTextField();
		txtCedula.setBounds(155, 30, 150, 20);
		pnlInfoVisitante.add(txtCedula);
		txtCedula.setColumns(10);

		JPanel pnlInfoTicke = new JPanel();
		pnlInfoTicke.setBounds(22, 100, 426, 246);
		contentPane.add(pnlInfoTicke);
		pnlInfoTicke.setLayout(null);

		JLabel lblTipo = new JLabel("Tipo de boleto");
		lblTipo.setBounds(30, 12, 126, 30);
		pnlInfoTicke.add(lblTipo);

		cbxTipo = new JComboBox<Object>();
		cbxTipo.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "Seleccione...", "Tour de Mascotas", "Safari Salvaje",
						"Aves rapaces y aves exóticas", "Los delfines y vida acuática", "Tour por el acuario" }));
		cbxTipo.setBounds(211, 15, 180, 24);
		pnlInfoTicke.add(cbxTipo);

		JLabel lblNmeroDeBoletos = new JLabel("<html>Número de boletos</html>");
		lblNmeroDeBoletos.setBounds(30, 54, 126, 30);
		pnlInfoTicke.add(lblNmeroDeBoletos);

		txtNumeroBoletos = new JTextField();
		txtNumeroBoletos.setBounds(211, 54, 180, 19);
		pnlInfoTicke.add(txtNumeroBoletos);
		txtNumeroBoletos.setColumns(10);

		lbltotalVenta = new JLabel("Total venta: ");
		lbltotalVenta.setBounds(30, 130, 90, 15);
		pnlInfoTicke.add(lbltotalVenta);

		lblDescuento = new JLabel("Descuento: ");
		lblDescuento.setBounds(30, 160, 90, 15);
		pnlInfoTicke.add(lblDescuento);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(251, 150, 41, 24);
		pnlInfoTicke.add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(301, 153, 90, 19);
		pnlInfoTicke.add(txtTotal);
		txtTotal.setColumns(10);

		btnVender = new JButton("Vender");
		btnVender.setBounds(155, 209, 117, 25);
		pnlInfoTicke.add(btnVender);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(12, 209, 117, 25);
		pnlInfoTicke.add(btnCalcular);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(287, 209, 117, 25);
		pnlInfoTicke.add(btnVolver);

		txtTotalVenta = new JTextField();
		txtTotalVenta.setEditable(false);
		txtTotalVenta.setColumns(10);
		txtTotalVenta.setBounds(125, 130, 90, 19);
		pnlInfoTicke.add(txtTotalVenta);

		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(125, 160, 90, 19);
		pnlInfoTicke.add(txtDescuento);

		JPanel panel = new JPanel();
		panel.setBounds(497, 123, 241, 208);
		contentPane.add(panel);
		panel.setLayout(null);

		ImageIcon image = new ImageIcon("src/zoo/imgs/ticket.jpeg");

		JLabel lblImg = new JLabel("");
		lblImg.setBounds(40, 5, 174, 191);
		panel.add(lblImg);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT));
		lblImg.setIcon(icon);

		isThereDataTour();
	}

	private void isThereDataTour() {
		if (!(tour == null)) {
			cbxTipo.setSelectedItem(tour.getName());
			tour = null;
		}
	}

	private void rellenarCampos() {
		String cedula = txtCedula.getText();
		Visitor visitor = visitorController.searchVisitorByCedula(cedula);

		if (!visitor.getCedula().equals("")) {
			txtNombre.setText(visitor.getName());
			txtDireccion.setText(visitor.getAddress());
			txtTelefono.setText(visitor.getPhone());
			putFocus();
		} else {
			txtNombre.setText("");
			txtDireccion.setText("");
			txtTelefono.setText("");
		}
	}

	private void putFocus() {
		if (cbxTipo.getSelectedIndex() == 0) {
			cbxTipo.requestFocus();
		} else {
			txtNumeroBoletos.requestFocus();
		}
	}

	private void limpiar() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");

		cbxTipo.setSelectedIndex(0);
		txtNumeroBoletos.setText("");
		txtTotalVenta.setText("");
		txtDescuento.setText("");
		txtTotal.setText("");

		txtCedula.requestFocus();
	}

	private void calcularVenta() {

		Tour tour = tourController.getByName(cbxTipo.getSelectedItem() + "");

		cantidad = Integer.parseInt(txtNumeroBoletos.getText());

		valorVenta = cantidad * tour.getPrice();

		txtTotalVenta.setText("$" + valorVenta);
		txtDescuento.setText((int) (tour.getDiscount() * 100) + "%");
		txtTotal.setText(String.format("$ %.2f", valorVenta * (1 - tour.getDiscount())));
	}

	private void realizarVenta() {

		String cedula = txtCedula.getText();
		Visitor visitor = visitorController.searchVisitorByCedula(cedula);

		if (visitor.getCedula().equals("")) {

			visitor.setCedula(cedula);
			visitor.setName(txtNombre.getText());
			visitor.setAddress(txtDireccion.getText());
			visitor.setPhone(txtTelefono.getText());

			visitorController.addVisitor(visitor);
		}

		Date time = Today.getTime();
		Tour tour = tourController.getByName(cbxTipo.getSelectedItem() + "");

		Sale transaction = new Sale(time, tour, visitor, cantidad, valorVenta * (1 - tour.getDiscount()));
		salesController.addSale(transaction);

	}

	private boolean todoValido() {
		if (!camposLlenos()) {
			ShowMessage.warning("LLene todos los campos!");
			return false;
		} else if (!tieneSeleccionda()) {
			ShowMessage.warning("Seleccione un tipo de boleto!");
			return false;
		} else if (!numeroCorrecto()) {
			ShowMessage.warning("Ingrese un número válido");
			return false;
		}
		return true;
	}

	private boolean tieneSeleccionda() {
		return cbxTipo.getSelectedIndex() != 0 ? true : false;
	}

	private boolean numeroCorrecto() {
		boolean respueta = false;
		try {
			Integer.parseInt(txtNumeroBoletos.getText());
			respueta = true;
		} catch (Exception e) {

		}
		return respueta;
	}

	private boolean camposLlenos() {
		return !txtCedula.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtDireccion.getText().isEmpty()
				&& !txtTelefono.getText().isEmpty();
	}
}
