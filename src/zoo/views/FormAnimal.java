package zoo.views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import zoo.controllers.HabitatController;
import zoo.models.Animal;
import zoo.models.DomesticAnimal;
import zoo.models.WildAnimal;
import zoo.utils.ShowMessage;

@SuppressWarnings("serial")
public class FormAnimal extends JFrame {

	private HabitatController habitatController;

	private JPanel contentPane;
	private JTextField txtUrl;
	private JTextField txtNombre;
	private JDateChooser dcFecha;
	private JComboBox<Object> cbHabitat;
	private JComboBox<Object> cbTipo;
	private JComboBox<Object> cbUso;
	private JButton btnGuardar;
	private JPanel pnlInfo;
	private JPanel pnlImg;
	private JButton btnCancelar;
	private JLabel lblTipo;
	private JLabel lblTitulo;
	private JLabel lblImg;
	private JLabel lblCarateristica;
	private JSlider slider;
	private JTextField txtAuxId;

	/**
	 * Create the frame.
	 */
	public FormAnimal() {
		habitatController = new HabitatController();
		initComponents();
		configActions();
	}

	private void configActions() {
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblCarateristica.setVisible(false);
				cbUso.setVisible(false);
				slider.setVisible(false);

				switch (cbTipo.getSelectedIndex()) {
				case 1: // Doméstico
					lblCarateristica.setText("Uso");
					lblCarateristica.setVisible(true);
					cbUso.setVisible(true);
					break;

				case 2: // Salvaje
					lblCarateristica.setText("Nivel de peligrosidad");
					lblCarateristica.setVisible(true);
					slider.setVisible(true);
					break;

				default:
					break;
				}

			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Animal animal;
				String url, name, habitatName;
				Date datebirth;

				url = txtUrl.getText();
				name = txtNombre.getText();
				datebirth = dcFecha.getDate();
				habitatName = cbHabitat.getSelectedItem() + "";

				switch (cbTipo.getSelectedIndex()) {
				case 1:
					String service = cbUso.getSelectedItem() + "";
					animal = new DomesticAnimal(url, name, datebirth, service);
					break;

				case 2:
					char dangerLevel = (char) (slider.getValue() + '0');
					animal = new WildAnimal(url, name, datebirth, dangerLevel);
					break;

				default:
					animal = new Animal();
					break;
				}

				if (ViewAnimal.enEdicion) {
					animal.setAnimalId(Integer.valueOf(txtAuxId.getText()));
					habitatController.updateAnimal(ViewAnimal.index, animal);
					ShowMessage.info("El animal ha sido actualizado");

				} else {
					habitatController.addAnimal(habitatName, animal);
					ShowMessage.info("El animal ha sido ingresado");
					ViewAnimal.index = habitatController.getIndexOfAmongAll(animal.getAnimalId());
				}

				ViewAnimal viewAnimal = new ViewAnimal();
				viewAnimal.setVisible(true);
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
		setBounds(100, 100, 750, 470);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlInfo = new JPanel();
		pnlInfo.setBounds(20, 20, 450, 390);
		contentPane.add(pnlInfo);
		pnlInfo.setLayout(null);

		lblTitulo = new JLabel("NUEVO ANIMAL");
		lblTitulo.setBounds(40, 30, 350, 15);
		pnlInfo.add(lblTitulo);

		JLabel lblImagenurl = new JLabel("Imagen (URL)");
		lblImagenurl.setBounds(40, 80, 150, 15);
		pnlInfo.add(lblImagenurl);

		txtUrl = new JTextField();
		txtUrl.setBounds(200, 80, 180, 24);
		pnlInfo.add(txtUrl);
		txtUrl.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 120, 150, 15);
		pnlInfo.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(200, 120, 180, 24);
		pnlInfo.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(40, 160, 150, 15);
		pnlInfo.add(lblFechaDeNacimiento);

		dcFecha = new JDateChooser();
		dcFecha.setBounds(200, 160, 180, 24);
		pnlInfo.add(dcFecha);

		JLabel lblHabitat = new JLabel("Habitat");
		lblHabitat.setBounds(40, 200, 150, 15);
		pnlInfo.add(lblHabitat);

		cbHabitat = new JComboBox<Object>();
		cbHabitat.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Seleccione...", "Granja", "Jungla", "Laguna", "Aviario", "Acuario" }));
		cbHabitat.setBounds(200, 200, 180, 24);
		pnlInfo.add(cbHabitat);

		lblTipo = new JLabel("Tipo de animal");
		lblTipo.setBounds(40, 240, 150, 15);
		pnlInfo.add(lblTipo);

		cbTipo = new JComboBox<Object>();
		cbTipo.setModel(new DefaultComboBoxModel<Object>(new String[] { "Seleccione...", "Doméstico", "Salvaje" }));
		cbTipo.setBounds(200, 240, 180, 24);
		pnlInfo.add(cbTipo);

		lblCarateristica = new JLabel("texto");
		lblCarateristica.setBounds(40, 280, 150, 15);
		lblCarateristica.setVisible(false);
		pnlInfo.add(lblCarateristica);

		cbUso = new JComboBox<Object>();
		cbUso.setModel(new DefaultComboBoxModel<Object>(new String[] { "Seleccione...", "Compañía", "Consumo" }));
		cbUso.setBounds(200, 280, 180, 24);
		cbUso.setVisible(false);
		pnlInfo.add(cbUso);

		slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setValue(7);
		slider.setMaximum(10);
		slider.setBounds(200, 280, 180, 24);
		slider.setVisible(false);
		pnlInfo.add(slider);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(80, 350, 100, 25);
		pnlInfo.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(233, 350, 100, 25);
		pnlInfo.add(btnCancelar);

		txtAuxId = new JTextField();
		txtAuxId.setText((String) null);
		txtAuxId.setColumns(10);
		txtAuxId.setBounds(200, 40, 180, 24);
		txtAuxId.setVisible(false);
		pnlInfo.add(txtAuxId);

		pnlImg = new JPanel();
		pnlImg.setBounds(482, 20, 239, 390);
		contentPane.add(pnlImg);
		pnlImg.setLayout(null);

		ImageIcon image = new ImageIcon("src/zoo/imgs/animal.jpg");

		lblImg = new JLabel("");
		lblImg.setBounds(12, 37, 215, 314);
		pnlImg.add(lblImg);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT));
		lblImg.setIcon(icon);

		validarDatos();
	}

	private void validarDatos() {
		if (!ViewAnimal.enEdicion) {
			return;
		}

		Animal animalEnEdicion = habitatController.getCurrentAnimal(ViewAnimal.index);

		lblTitulo.setText("EDITAR ANIMAL");
		txtAuxId.setText(animalEnEdicion.getAnimalId() + "");
		txtUrl.setText(animalEnEdicion.getUrlImg());
		txtNombre.setText(animalEnEdicion.getName());
		dcFecha.setDate(animalEnEdicion.getBirthdate());

		if (animalEnEdicion instanceof DomesticAnimal) {
			cbTipo.setSelectedIndex(1);
			cbUso.setSelectedItem(((DomesticAnimal) animalEnEdicion).getService());
		} else {
			cbTipo.setSelectedIndex(2);
			slider.setValue(((WildAnimal) animalEnEdicion).getDangerLevel() - '0');
		}

		cbHabitat.setSelectedItem(habitatController.getHabiatByAnimal(animalEnEdicion));

	}
}
