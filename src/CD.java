import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class CD extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private List<CDBean> CDs;
	private BuscarReg dlgBuscar;
	
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtGenero;
	private JTextArea txtPrestamo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CD frame = new CD();
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
	public CD() {
		
		CDs = new ArrayList<>();
		
		setSize(new Dimension(450,300));
		setResizable(false);
		setTitle("CDs Prestados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenuArchivo = new JMenu("Archivo");
		mnMenuArchivo.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnMenuArchivo);
		
		JMenuItem mntmAnadirRegistro = new JMenuItem("Añadir Registro");
		mntmAnadirRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titulo = null, autor = null, genero = null, descripcion = null;
				
				titulo = txtTitulo.getText();
				
				// Comprobamos que el titulo no sea nulo
				if (titulo.isBlank()) {
					JOptionPane.showMessageDialog(null,
							"El campo titulo no puede estar vacio");
					return;
				}
				
				autor = txtAutor.getText();
				genero = txtGenero.getText();
				descripcion = txtPrestamo.getText();
				CDs.add(new CDBean(titulo,autor,genero,descripcion));
				
				JOptionPane.showMessageDialog(null, "Se ha añadido el CD a la colección");
				Collections.sort(CDs);
			}
		});
		mnMenuArchivo.add(mntmAnadirRegistro);
		
		JMenuItem mntmBuscarRegistro = new JMenuItem("Buscar Registro");
		mntmBuscarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarBusqueda();
			}
		});
		mnMenuArchivo.add(mntmBuscarRegistro);
		
		JSeparator separator = new JSeparator();
		mnMenuArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respuesta = JOptionPane.showConfirmDialog(null,
						"Esta acción cerrará la aplicación, ¿desea continuar?",
						"Atención",
						JOptionPane.YES_NO_OPTION);
				if (respuesta != JOptionPane.YES_OPTION) {
					return;
				}
				System.exit(0);
			}
		});
		mnMenuArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLbltitulo = new JLabel("Titulo");
		lblLbltitulo.setBounds(20, 20, 50, 14);
		contentPane.add(lblLbltitulo);
		
		JLabel lblLblautor = new JLabel("Autor");
		lblLblautor.setBounds(20, 60, 50, 14);
		contentPane.add(lblLblautor);
		
		JLabel lblLblgenero = new JLabel("Género");
		lblLblgenero.setBounds(20, 100, 50, 14);
		contentPane.add(lblLblgenero);
		
		JLabel lblLblprestamo = new JLabel("Préstamo");
		lblLblprestamo.setBounds(20, 140, 100, 14);
		contentPane.add(lblLblprestamo);
		
		JLabel lblJlbcreditos = new JLabel("copyright 2025 - SoftPuig");
		lblJlbcreditos.setBounds(3, 225, 392, 14);
		contentPane.add(lblJlbcreditos);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(100, 17, 275, 21);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(100, 57, 275, 21);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(100, 97, 275, 21);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtPrestamo = new JTextArea();
		txtPrestamo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtPrestamo.setLineWrap(true);
		txtPrestamo.setBounds(100, 137, 275, 70);
		contentPane.add(txtPrestamo);
	}
	
	protected void mostrarBusqueda() {
		dlgBuscar = new BuscarReg(this);
		dlgBuscar.setVisible(true);
		}
	
	public List<CDBean> getCDs() {
		return CDs;
	}
	
	public void setRegDatos(int i) {
		CDBean cd = CDs.get(i);
		txtTitulo.setText(cd.getTitulo());
		txtAutor.setText(cd.getAutor());
		txtGenero.setText(cd.getGenero());
		txtPrestamo.setText(cd.getPrestamo());
		}
}
