package presentacion;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import org.apache.pdfbox.contentstream.operator.text.ShowText;

public class Ventana_Comentario extends JFrame implements ActionListener, ItemListener {
	
	JPanel panel;
	JLabel texto1;
	JLabel texto2;
	JTextArea comentario;
	JComboBox<String> paso;
	JButton Guardar;
	JButton Cancelar;
	String[] num_pasos;
	JTable tabla;
	
	public Ventana_Comentario(String arg0, JTable tabla) throws HeadlessException {
		super(arg0);
		this.tabla = tabla;
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		num_pasos = new String[tabla.getRowCount()];
		for(int i=0; i<num_pasos.length; i++){
			num_pasos[i]=(i+1)+"";
		}
		
		texto2 = new JLabel("Numero de paso");
		texto2.setBounds(150, 20, 50, 20);
		panel.add(texto2);
		
		paso = new JComboBox<>(num_pasos);
		paso.setBounds(250, 20, 50, 20);
		paso.addActionListener(this);
		panel.add(paso);
		
		texto1 = new JLabel((String) tabla.getModel().getValueAt(0, 1));
		texto1.setBounds(100, 60, 300, 20);
		texto1.setBorder(LineBorder.createBlackLineBorder());
		texto1.setBackground(Color.WHITE);
		panel.add(texto1);
		
		comentario = new JTextArea((String) tabla.getModel().getValueAt(0, 7));
		comentario.setLineWrap(true);
		comentario.setWrapStyleWord(true);
		comentario.setBounds(50, 150, 400, 200);
		panel.add(comentario);
		
		Guardar = new JButton("Guardar");
		Guardar.setBounds(100, 380, 100, 50);
		Guardar.addActionListener(this);
		panel.add(Guardar);
		
		Cancelar = new JButton("Cancelar");
		Cancelar.setBounds(300, 380, 100, 50);
		Cancelar.addActionListener(this);
		panel.add(Cancelar);
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals(Cancelar.getText())){
			dispose();
		}else{
			if(arg0.getActionCommand().equals(Guardar.getText())){
				tabla.getModel().setValueAt(comentario.getText(), paso.getSelectedIndex(), 7);
				JOptionPane.showMessageDialog(null, "Guardado");
				dispose();
			}else{
				texto1.setText((String) tabla.getModel().getValueAt(paso.getSelectedIndex(), 1));
				comentario.setText((String) tabla.getModel().getValueAt(paso.getSelectedIndex(), 7));
			}
		}
	}

}
