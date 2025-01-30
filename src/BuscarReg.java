import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

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
		
		ActionListener listenerDialogo = new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
			gestionarBotones(e);
			}
		};
			
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
				btnAceptar.setBounds(new Rectangle(285, 21, 90, 26));
				btnAceptar.setActionCommand("aceptar");
				btnAceptar.addActionListener(listenerDialogo);
				btnAceptar.setMnemonic('a');
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(new Rectangle(285, 58, 90, 26));
				btnCancelar.setActionCommand("cancelar");
				btnCancelar.addActionListener(listenerDialogo);
				btnCancelar.setMnemonic('c');
				buttonPane.add(btnCancelar);
			}
			{
				JButton btnBorrar = new JButton("Borrar");
				btnBorrar.setBounds(new Rectangle(285, 95, 90, 26));
				btnBorrar.setActionCommand("borrar");
				btnBorrar.addActionListener(listenerDialogo);
				btnBorrar.setMnemonic('b');
				buttonPane.add(btnBorrar);
			}
		}
	}
	
	protected void gestionarBotones(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "aceptar":
			int i = listCDs.getSelectedIndex();
			if (i >= 0) ventanaPadre.setRegDatos(i);
			break;
		case "cancelar":
			setVisible(false);
			dispose();
			break;
		case "borrar":
			int j = listCDs.getSelectedIndex();
			if (j >=0) {
				int respuesta = JOptionPane.showConfirmDialog(null,
						"Esta acción eliminará el CD ¿desea continuar?",
						"Atención", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_OPTION) {
					ventanaPadre.getCDs().remove(j);
					this.actualizarLista();
				}
			}
		}
	}
	
	public void actualizarLista() {
		listCDs.setListData(new Vector<>(ventanaPadre.getCDs()));
	}

}
