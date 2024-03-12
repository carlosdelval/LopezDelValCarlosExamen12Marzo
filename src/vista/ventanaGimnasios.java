package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControladorAsistente;
import controladores.ControladorGimnasio;
import controladores.ControladorLocalidad;
import entidades.Asistente;
import entidades.Gimnasio;
import entidades.Localidad;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ventanaGimnasios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfFiltro;
	private JTextField jtfId;
	private JTextField jtfDni;
	private JTextField jtfNombre;
	private JTextField jtfApellido;
	private JTextField jtfFechaNacimiento;
	private JTextField jtfCuota;
	private JComboBox jcbGimnasio;
	private JComboBox jcbAsistentes;
	private JComboBox jcbLocalidad;
	private JButton jbtnFiltro;
	private JButton jbtnGuardar;
	private JCheckBox checkActivo;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaGimnasios frame = new ventanaGimnasios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanaGimnasios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblGestinDeAsistentes = new JLabel("Gestión de asistentes a gimnasios");
		lblGestinDeAsistentes.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblGestinDeAsistentes = new GridBagConstraints();
		gbc_lblGestinDeAsistentes.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeAsistentes.gridwidth = 10;
		gbc_lblGestinDeAsistentes.gridx = 0;
		gbc_lblGestinDeAsistentes.gridy = 0;
		contentPane.add(lblGestinDeAsistentes, gbc_lblGestinDeAsistentes);
		
		JLabel lblNewLabel = new JLabel("Gimnasio:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbGimnasio = new JComboBox();
		GridBagConstraints gbc_jcbGimnasio = new GridBagConstraints();
		gbc_jcbGimnasio.weightx = 1.0;
		gbc_jcbGimnasio.gridwidth = 7;
		gbc_jcbGimnasio.insets = new Insets(0, 0, 5, 0);
		gbc_jcbGimnasio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbGimnasio.gridx = 3;
		gbc_jcbGimnasio.gridy = 1;
		contentPane.add(jcbGimnasio, gbc_jcbGimnasio);
		
		JLabel lblFiltro = new JLabel("Filtro apellidos asistente:");
		GridBagConstraints gbc_lblFiltro = new GridBagConstraints();
		gbc_lblFiltro.gridwidth = 3;
		gbc_lblFiltro.anchor = GridBagConstraints.EAST;
		gbc_lblFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltro.gridx = 0;
		gbc_lblFiltro.gridy = 2;
		contentPane.add(lblFiltro, gbc_lblFiltro);
		
		jtfFiltro = new JTextField();
		GridBagConstraints gbc_jtfFiltro = new GridBagConstraints();
		gbc_jtfFiltro.gridwidth = 5;
		gbc_jtfFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFiltro.gridx = 3;
		gbc_jtfFiltro.gridy = 2;
		contentPane.add(jtfFiltro, gbc_jtfFiltro);
		jtfFiltro.setColumns(10);
		
		jbtnFiltro = new JButton("Filtrar asistentes");
		jbtnFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtfFiltro.getText() != null) filtraAsistente(jtfFiltro.getText());
			}
		});
		jbtnFiltro.setFont(new Font("Dialog", Font.BOLD, 9));
		GridBagConstraints gbc_jbtnFiltro = new GridBagConstraints();
		gbc_jbtnFiltro.gridwidth = 2;
		gbc_jbtnFiltro.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnFiltro.gridx = 8;
		gbc_jbtnFiltro.gridy = 2;
		contentPane.add(jbtnFiltro, gbc_jbtnFiltro);
		
		JLabel lblAsistentesFiltrados = new JLabel("Asistentes filtrados:");
		GridBagConstraints gbc_lblAsistentesFiltrados = new GridBagConstraints();
		gbc_lblAsistentesFiltrados.gridwidth = 3;
		gbc_lblAsistentesFiltrados.anchor = GridBagConstraints.EAST;
		gbc_lblAsistentesFiltrados.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsistentesFiltrados.gridx = 0;
		gbc_lblAsistentesFiltrados.gridy = 3;
		contentPane.add(lblAsistentesFiltrados, gbc_lblAsistentesFiltrados);
		
		jcbAsistentes = new JComboBox();
		GridBagConstraints gbc_jcbAsistentes = new GridBagConstraints();
		gbc_jcbAsistentes.insets = new Insets(0, 0, 5, 0);
		gbc_jcbAsistentes.gridwidth = 7;
		gbc_jcbAsistentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbAsistentes.gridx = 3;
		gbc_jcbAsistentes.gridy = 3;
		contentPane.add(jcbAsistentes, gbc_jcbAsistentes);
		jcbAsistentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcbAsistentes.getSelectedItem() != null) muestraDatosAsistente();;
			}
		});
		
		JLabel lblDatosDelAsistente = new JLabel("Datos del asistente");
		lblDatosDelAsistente.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblDatosDelAsistente = new GridBagConstraints();
		gbc_lblDatosDelAsistente.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosDelAsistente.gridx = 3;
		gbc_lblDatosDelAsistente.gridy = 5;
		contentPane.add(lblDatosDelAsistente, gbc_lblDatosDelAsistente);
		
		JLabel lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.gridwidth = 3;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 6;
		contentPane.add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 7;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 3;
		gbc_jtfId.gridy = 6;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI/NIE/Pasaporte:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.gridwidth = 3;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 7;
		contentPane.add(lblDni, gbc_lblDni);
		
		jtfDni = new JTextField();
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.gridwidth = 7;
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 3;
		gbc_jtfDni.gridy = 7;
		contentPane.add(jtfDni, gbc_jtfDni);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.gridwidth = 3;
		gbc_lblLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalidad.gridx = 0;
		gbc_lblLocalidad.gridy = 8;
		contentPane.add(lblLocalidad, gbc_lblLocalidad);
		
		jcbLocalidad = new JComboBox();
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.gridwidth = 7;
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 3;
		gbc_jcbLocalidad.gridy = 8;
		contentPane.add(jcbLocalidad, gbc_jcbLocalidad);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 3;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 9;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		jtfNombre.setColumns(10);
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 7;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 3;
		gbc_jtfNombre.gridy = 9;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.gridwidth = 3;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 10;
		contentPane.add(lblApellidos, gbc_lblApellidos);
		
		jtfApellido = new JTextField();
		jtfApellido.setColumns(10);
		GridBagConstraints gbc_jtfApellido = new GridBagConstraints();
		gbc_jtfApellido.gridwidth = 7;
		gbc_jtfApellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido.gridx = 3;
		gbc_jtfApellido.gridy = 10;
		contentPane.add(jtfApellido, gbc_jtfApellido);
		
		checkActivo = new JCheckBox("");
		GridBagConstraints gbc_checkActivo = new GridBagConstraints();
		gbc_checkActivo.insets = new Insets(0, 0, 5, 5);
		gbc_checkActivo.gridx = 2;
		gbc_checkActivo.gridy = 11;
		contentPane.add(checkActivo, gbc_checkActivo);
		
		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblActivo = new GridBagConstraints();
		gbc_lblActivo.anchor = GridBagConstraints.WEST;
		gbc_lblActivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblActivo.gridx = 3;
		gbc_lblActivo.gridy = 11;
		contentPane.add(lblActivo, gbc_lblActivo);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.gridwidth = 3;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 0;
		gbc_lblFechaNacimiento.gridy = 12;
		contentPane.add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		jtfFechaNacimiento = new JTextField();
		jtfFechaNacimiento.setColumns(10);
		GridBagConstraints gbc_jtfFechaNacimiento = new GridBagConstraints();
		gbc_jtfFechaNacimiento.gridwidth = 7;
		gbc_jtfFechaNacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaNacimiento.gridx = 3;
		gbc_jtfFechaNacimiento.gridy = 12;
		contentPane.add(jtfFechaNacimiento, gbc_jtfFechaNacimiento);
		
		JLabel lblCuotaMensual = new JLabel("Cuota mensual (€):");
		GridBagConstraints gbc_lblCuotaMensual = new GridBagConstraints();
		gbc_lblCuotaMensual.gridwidth = 3;
		gbc_lblCuotaMensual.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuotaMensual.gridx = 0;
		gbc_lblCuotaMensual.gridy = 13;
		contentPane.add(lblCuotaMensual, gbc_lblCuotaMensual);
		
		jtfCuota = new JTextField();
		jtfCuota.setColumns(10);
		GridBagConstraints gbc_jtfCuota = new GridBagConstraints();
		gbc_jtfCuota.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCuota.gridwidth = 7;
		gbc_jtfCuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuota.gridx = 3;
		gbc_jtfCuota.gridy = 13;
		contentPane.add(jtfCuota, gbc_jtfCuota);
		
		jbtnGuardar = new JButton("Guardar");
		jbtnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardaAsistente();
			}
		});
		GridBagConstraints gbc_jbtnGuardar = new GridBagConstraints();
		gbc_jbtnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_jbtnGuardar.gridx = 3;
		gbc_jbtnGuardar.gridy = 15;
		contentPane.add(jbtnGuardar, gbc_jbtnGuardar);
		
		cargaGimnasio();
		cargaLocalidad();
	}
	
	/*Métodos que cargan los gimnasios y las localidades*/
	
	private void cargaGimnasio() {
		List<Gimnasio> gimnasios = ControladorGimnasio.findAll();
		this.jcbGimnasio.removeAllItems();
		
		for (Gimnasio g : gimnasios) {
			this.jcbGimnasio.addItem(g);
		}
	}
	
	private void cargaLocalidad() {
		List<Localidad> localidades = ControladorLocalidad.findAll();
		this.jcbLocalidad.removeAllItems();
		
		for (Localidad l : localidades) {
			this.jcbLocalidad.addItem(l);
		}
	}
	
	
	
	/*Método que filtra los asistentes*/
	
	private void filtraAsistente(String filtro) {
		List<Asistente> asistentes = ControladorAsistente.filtro(filtro);
		this.jcbAsistentes.removeAllItems();
		
		for(Asistente a : asistentes) {
			this.jcbAsistentes.addItem(a);
		}
	}
	
	/*Método que muestra en pantalla los datos del asistente seleccionado.*/
	
	private void muestraDatosAsistente() {
		Asistente a = ((Asistente)jcbAsistentes.getSelectedItem());
		this.jtfId.setText("" + a.getId());
		this.jtfApellido.setText(a.getApellidos());
		this.jtfCuota.setText("" + a.getCuotaMensual());
		this.jtfDni.setText(a.getDniNiePasaporte());
		this.jtfNombre.setText(a.getNombre());
		String strFecha = (a.getFechaNacimiento() != null)? 
				sdf.format(a.getFechaNacimiento()) : "";
		this.jtfFechaNacimiento.setText(strFecha);
		this.checkActivo.setSelected(a.getActivo());
		this.jcbLocalidad.setSelectedIndex(a.getIdLocalidad());
	}
	
	/*Método que modifica los nuevos datos del asistente.*/
	
	private void guardaAsistente() {
		try {
			
			//Comprobaciones
			
			if (!isFechaValida()) {
				JOptionPane.showMessageDialog(null, "La fecha de nacimiento es "
						+ "posterior a hoy o no válida.");
				return;
			}
			
			if (!isCuotaFlotante()) {
				JOptionPane.showMessageDialog(null, "La cuota mensual no es flotante o está vacía.");
				return;
			}
			
			if (!isDniValid()) {
				JOptionPane.showMessageDialog(null, "El dni debe contener 8 números seguidos.");
				return;
			}
			
			Asistente a = (Asistente)jcbAsistentes.getSelectedItem();
			
			a.setActivo(this.checkActivo.isSelected());
			a.setApellidos(this.jtfApellido.getText());
			a.setNombre(this.jtfNombre.getText());
			a.setCuotaMensual(Float.parseFloat(this.jtfCuota.getText()));
			a.setDniNiePasaporte(this.jtfDni.getText());
			a.setIdGimnasio(((Gimnasio)this.jcbGimnasio.getSelectedItem()).getId());
			a.setIdLocalidad(((Localidad)this.jcbLocalidad.getSelectedItem()).getId());
			Date nuevaFecha = (!this.jtfFechaNacimiento.getText().trim().equals(""))?
					sdf.parse(this.jtfFechaNacimiento.getText()) : null;
			a.setFechaNacimiento(nuevaFecha);
			
			if (ControladorAsistente.update(a) == 1) {
				JOptionPane.showMessageDialog(null, "Guardado correctamente");
			}
			else {
				JOptionPane.showMessageDialog(null, "NO se ha podido guardar");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*Método que comprueba si el dni/nie/pasaporte son 8 dígitos seguidos*/
	
	private boolean isDniValid(){
		
		String dni = this.jtfDni.getText();
		if(dni.length() < 8) return false;
		Boolean comprueba = false;
		
		for (int i = 0; i < dni.length(); i++) {
			if(Character.isDigit(dni.charAt(i))) {
				comprueba = true;
				for (int j = i; j < 8; j++) {
					if(!Character.isDigit(dni.charAt(j))) comprueba = false;
				}
			}
		}
		
		return comprueba;
	}
	
	
	
	/*Método que comprueba si la cuota es un número flotante*/
	
	private boolean isCuotaFlotante() {
		
		try {
			Float.parseFloat(this.jtfCuota.getText());
		}
		catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	/*Método que comprueba si la fecha es correcta*/
	
	private boolean isFechaValida() {
		String strFechaCad = this.jtfFechaNacimiento.getText();
		
		if (strFechaCad.trim().equals("")) {
			return true;
		}
		
		Date fechaCad = null;
		try {
			fechaCad = sdf.parse(strFechaCad);
		}
		catch (Exception ex) {
			return false;
		}
		
		if ((new Date()).before(fechaCad)) {
			return false;
		}
		else {
			return true;
		}
	}
}
