package zoo.views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import zoo.controllers.VisitorController;
import zoo.models.Visitor;
import zoo.utils.ShowMessage;

@SuppressWarnings("serial")
public class FormVisitor extends JFrame {

//	private DeptLogistics logistics;
	private VisitorController visitorController;

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtIndentificacion;

	private JButton btnGuardar;

	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public FormVisitor() {
//		logistics = new DeptLogistics();
		visitorController = new VisitorController();
		initComponents();
		configActions();
	}

	private void configActions() {
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String identificacion = txtIndentificacion.getText();
				String nombre = txtNombre.getText();
				String direcion = txtDireccion.getText();
				String telefono = txtTelefono.getText();
				visitorController.addVisitor(new Visitor(identificacion, nombre, direcion, telefono));

				ShowMessage.info("El visitante ha sido ingresado");

				clean();

				VisitorManagement management = new VisitorManagement();
				management.setVisible(true);
				dispose();
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
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

		JPanel pnlInfo = new JPanel();
		pnlInfo.setBounds(20, 20, 450, 340);
		contentPane.add(pnlInfo);
		pnlInfo.setLayout(null);

		JLabel lblTitulo = new JLabel("NUEVO VISITANTE");
		lblTitulo.setBounds(60, 31, 320, 15);
		pnlInfo.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(60, 140, 120, 15);
		pnlInfo.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(200, 140, 180, 19);
		pnlInfo.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setBounds(60, 180, 120, 15);
		pnlInfo.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(200, 180, 180, 19);
		pnlInfo.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(60, 220, 120, 15);
		pnlInfo.add(lblTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(200, 220, 180, 19);
		pnlInfo.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblIdentificación = new JLabel("Indentificación");
		lblIdentificación.setBounds(60, 100, 120, 15);
		pnlInfo.add(lblIdentificación);

		txtIndentificacion = new JTextField();
		txtIndentificacion.setBounds(200, 100, 180, 19);
		pnlInfo.add(txtIndentificacion);
		txtIndentificacion.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(72, 283, 117, 25);
		pnlInfo.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(232, 283, 117, 25);
		pnlInfo.add(btnCancelar);

		JPanel pnlImg = new JPanel();
		pnlImg.setBounds(480, 20, 235, 340);
		contentPane.add(pnlImg);
		pnlImg.setLayout(null);

		ImageIcon image = new ImageIcon("src/zoo/imgs/visitor.jpeg");

		JLabel lblImg = new JLabel("");
		lblImg.setBounds(12, 12, 211, 313);
		pnlImg.add(lblImg);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT));
		lblImg.setIcon(icon);
	}

	protected void clean() {
		txtIndentificacion.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");

	}

}
