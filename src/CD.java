import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class CD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		mnMenuArchivo.add(mntmAnadirRegistro);
		
		JMenuItem mntmBuscarRegistro = new JMenuItem("Buscar Registro");
		mnMenuArchivo.add(mntmBuscarRegistro);
		
		JSeparator separator = new JSeparator();
		mnMenuArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnMenuArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
