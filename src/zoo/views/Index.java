package zoo.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import zoo.pdf.MyReport;
import zoo.utils.ShowMessage;

@SuppressWarnings("serial")
public class Index extends JFrame {

	private JPanel contentPane;

	private JButton btnSalir;
	private JButton btnIngresar;
	private JButton btnVender;
	private JButton btnVer;

	/**
	 * Create the frame.
	 */
	public Index() {
		initComponents();
		configActions();
	}

	private void configActions() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int eleccion = ShowMessage.question("En realidad desea realizar cerrar la aplicacion");

				if (eleccion == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] items = { "Seleccione...", "Animal", "Visitante" };
				JComboBox<Object> jci = new JComboBox<Object>(items);
				jci.setSelectedIndex(0);

				// create a JOptionPane
				JOptionPane.showMessageDialog(null, jci, "Qué deseas ingresar?...", JOptionPane.QUESTION_MESSAGE);

				switch (jci.getSelectedItem() + "") {
				case "Visitante":
					FormVisitor formVisitor = new FormVisitor();
					formVisitor.setVisible(true);
					dispose();
					break;

				case "Animal":
					FormAnimal formAnimal = new FormAnimal();
					formAnimal.setVisible(true);
					dispose();
					break;

				default:
					break;
				}

			}
		});

		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TourSales sales = new TourSales();
				sales.setVisible(true);
				dispose();
			}
		});

		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Object[] items = { "Seleccione...", "Animales", "Visitantes", "Tours", "Reporte" };
				JComboBox<Object> jci = new JComboBox<Object>(items);
				jci.setSelectedIndex(0);

				// create a JOptionPane
				JOptionPane.showMessageDialog(null, jci, "Qué deseas ingresar?...", JOptionPane.QUESTION_MESSAGE);

				switch (jci.getSelectedIndex()) {
				case 1:
					AnimalInventory animalInventory = new AnimalInventory();
					animalInventory.setVisible(true);
					dispose();
					break;

				case 2:
					VisitorManagement management = new VisitorManagement();
					management.setVisible(true);
					dispose();
					break;

				case 3:
					AllTours allTours = new AllTours();
					allTours.setVisible(true);
					dispose();
					break;

				case 4:
					MyReport.generate();
					break;

				default:
					break;
				}

			}
		});

	}

	private void initComponents() {
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 300, 170);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		ImageIcon image = new ImageIcon("src/zoo/imgs/logo.png");

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(12, 12, 273, 155);
		panel_1.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(icon);

		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_RIGHT);

		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setParagraphAttributes(attribs, false);
		txtpnNombre.setFont(new Font("Dialog", Font.PLAIN, 26));
		txtpnNombre.setEditable(false);
		txtpnNombre.setText("ZOODI Administración Internacional de Zoológicos ");
		txtpnNombre.setBounds(0, 190, 300, 130);
		txtpnNombre.setBackground(contentPane.getBackground());
		contentPane.add(txtpnNombre);

		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);

		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtpnTitulo.setParagraphAttributes(attribs, false);
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setText("ZOODI, sucursal 1A");
		txtpnTitulo.setBounds(450, 50, 150, 60);
		txtpnTitulo.setBackground(contentPane.getBackground());
		contentPane.add(txtpnTitulo);

		btnSalir = new JButton("Salir");

		btnIngresar = new JButton("Ingresar");

		btnVender = new JButton("Vender");
		btnVender.setBounds(362, 215, 100, 25);
		contentPane.add(btnVender);
		btnIngresar.setBounds(474, 215, 100, 25);
		contentPane.add(btnIngresar);

		btnVer = new JButton("Ver Info");
		btnVer.setBounds(586, 215, 100, 25);
		contentPane.add(btnVer);
		btnSalir.setBounds(608, 281, 70, 25);
		contentPane.add(btnSalir);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 340, 750, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTextFooter = new JLabel("Desarrollado por Andrea Orozo y Juan Santa");
		lblTextFooter.setBounds(205, 15, 315, 15);
		panel.add(lblTextFooter);
	}
}
