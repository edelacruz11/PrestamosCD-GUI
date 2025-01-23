import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class BuscarReg extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private CD ventanaPadre;
	private JScrollPane scPanel;
	private JList<CDBean> listCDs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarReg dialog = new BuscarReg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarReg(JFrame frame) {
		ventanaPadre = (CD)frame;
		setTitle("Buscar Registro");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			scPanel = new JScrollPane();
			scPanel.setBounds(17, 21, 247, 220);
			contentPanel.add(scPanel);
			{
				listCDs = new JList();
				listCDs.setListData(new Vector<>(ventanaPadre.getCDs()));
				listCDs.setAutoscrolls(true);
				scPanel.setViewportView(listCDs);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setMnemonic('a');
				btnAceptar.setBounds(new Rectangle(258, 21, 90, 26));
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setMnemonic('c');
				btnCancelar.setBounds(new Rectangle(285, 58, 90, 26));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
			{
				JButton btnBorrar = new JButton("Borrar");
				btnBorrar.setMnemonic('b');
				btnBorrar.setBounds(new Rectangle(285, 95, 90, 26));
				buttonPane.add(btnBorrar);
			}
		}
	}

}
