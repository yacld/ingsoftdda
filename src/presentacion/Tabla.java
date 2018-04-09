package presentacion;


import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import datos.CSVUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import negocio.PDF;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Tabla {
	private TableRowSorter trsFiltro;
	// para exportar
	private JFileChooser FileChooser = new JFileChooser();
	private Vector columna = new Vector();
	private Vector filas = new Vector();
	private static int tabla_ancho = 0;
	private static int tabla_alto = 0;
	public JFrame frmProceso;
	private JTextField TexidPaso;
	private JTextField texNombre;
	private JTextField TexidPasoAnt;
	private JTable Tabla;
	private static DefaultTableModel modelo;
	private JTextField texFiltro;
	private String importado;
	Control_Paso cp;
	Control_Diagrama cd;
	File paso;
	private JTextField TexForma;
	private JTextField texConector;
	private JTextField texResponsable;

	public Tabla(Control_Paso control_Pasos, File paso) {
		cp = control_Pasos;
		this.paso = paso;
		cd = new Control_Diagrama();
		initialize();
	}

	private void initialize() {
		modelo = new DefaultTableModel();
		modelo.addColumn("ID Paso");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("ID Paso Anterior");
		modelo.addColumn("Conector");
		modelo.addColumn("Tipo de Forma");
		modelo.addColumn("Actor Responsable");
		modelo.addColumn("Comentarios");

		frmProceso = new JFrame();
		frmProceso.setTitle("Pasos");
		frmProceso.setBounds(100, 100, 900, 400);
		frmProceso.setResizable(false);
		frmProceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProceso.getContentPane().setLayout(null);

		TexidPaso = new JTextField();
		TexidPaso.setBounds(10, 27, 86, 20);
		frmProceso.getContentPane().add(TexidPaso);
		TexidPaso.setColumns(10);

		texNombre = new JTextField();
		texNombre.setBounds(10, 58, 86, 20);
		frmProceso.getContentPane().add(texNombre);
		texNombre.setColumns(10);

		TexidPasoAnt = new JTextField();
		TexidPasoAnt.setBounds(10, 89, 86, 20);
		frmProceso.getContentPane().add(TexidPasoAnt);
		TexidPasoAnt.setColumns(10);

		Tabla = new JTable();

		Tabla.setModel(modelo);
		Tabla.setEnabled(false);
		Tabla.setBounds(10, 120, 870, 200);
		Tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Tabla.doLayout();
		frmProceso.getContentPane().add(Tabla);
		try {
			CrearTabla(paso);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Si esto falla me doy un tiro");
		}
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.setBounds(20, 330, 100, 25);
		frmProceso.getContentPane().add(btnExportar);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(130, 330, 100, 25);
		frmProceso.getContentPane().add(btnInsertar);

		JButton btnPDF = new JButton("Crear PDF");
		btnPDF.setBounds(240, 330, 150, 25);
		frmProceso.getContentPane().add(btnPDF);
		
		JButton btnActualizar = new JButton("Guardar");
		btnActualizar.setBounds(400, 330, 100, 25);
		frmProceso.getContentPane().add(btnActualizar);
		
		JButton btnGenDiagrama = new JButton("Diagrama");
		btnGenDiagrama.setBounds(510, 330, 100, 25);
		frmProceso.getContentPane().add(btnGenDiagrama);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.setBounds(620, 330, 100, 25);
		frmProceso.getContentPane().add(btnImportar);
				
		JButton btnComentarios = new JButton("Nuevo Comentario");
		btnComentarios.setBounds(730, 330, 150, 25);
		frmProceso.getContentPane().add(btnComentarios);

		texFiltro = new JTextField();
		texFiltro.setBounds(770, 89, 80, 25);
		frmProceso.getContentPane().add(texFiltro);
		texFiltro.setColumns(10);
				
		JComboBox<?> cbBusqueda = new JComboBox();

		cbBusqueda.setModel(new DefaultComboBoxModel(
				new String[] {"IDPaso", "Nombre", "Descripcion", "ID Paso Anterior", "Conector", "Tipo de Forma", "Actor resposable" }));
		cbBusqueda.setBounds(600, 89, 150, 20);
		frmProceso.getContentPane().add(cbBusqueda);
		
		TexForma = new JTextField();
		TexForma.setBounds(270, 27, 100, 20);
		frmProceso.getContentPane().add(TexForma);
		TexForma.setColumns(10);
		
		texConector = new JTextField();
		texConector.setBounds(270, 58, 100, 20);
		frmProceso.getContentPane().add(texConector);
		texConector.setColumns(10);
		
		texResponsable = new JTextField();
		texResponsable.setBounds(270, 89, 100, 20);
		frmProceso.getContentPane().add(texResponsable);
		texResponsable.setColumns(10);
		
		JLabel lblIdpaso = new JLabel("idPaso");
		lblIdpaso.setBounds(117, 30, 46, 14);
		frmProceso.getContentPane().add(lblIdpaso);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(117, 61, 46, 14);
		frmProceso.getContentPane().add(lblNombre);
		
		JLabel lblIdpasoAnterior = new JLabel("idPaso anterior");
		lblIdpasoAnterior.setBounds(117, 92, 86, 14);
		frmProceso.getContentPane().add(lblIdpasoAnterior);
		
		JLabel lblTipoDeForma = new JLabel("Tipo de forma");
		lblTipoDeForma.setBounds(400, 30, 103, 14);
		frmProceso.getContentPane().add(lblTipoDeForma);
		
		JLabel lblConector = new JLabel("Conector");
		lblConector.setBounds(400, 61, 86, 14);
		frmProceso.getContentPane().add(lblConector);
		
		JLabel lblResponsable = new JLabel("Responsable");
		lblResponsable.setBounds(400, 92, 86, 14);
		frmProceso.getContentPane().add(lblResponsable);
		
		JTextArea AreaDescripcion = new JTextArea();
		AreaDescripcion.setBounds(600, 22, 250, 53);
		frmProceso.getContentPane().add(AreaDescripcion);
		
		
		btnInsertar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInsertarActionPerformed(evt);
			}

			private void btnInsertarActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				String[] datos = new String[7];
				datos[0] = TexidPaso.getText();
				datos[1] = texNombre.getText();
				datos[2] = AreaDescripcion.getText();
				datos[3] = TexidPasoAnt.getText();
				datos[4] = texConector.getText();
				datos[5] = TexForma.getText();
				datos[6] = texResponsable.getText();
				modelo.addRow(datos);
				TexidPaso.setText("");
				texNombre.setText("");
				AreaDescripcion.setText("");
				TexidPasoAnt.setText("");
				texConector.setText("");
				TexForma.setText("");
				texResponsable.setText("");
				//TexCodigo.requestFocus();

			}
		});
		
		btnComentarios.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInsertarActionPerformed(evt);
			}

			private void btnInsertarActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				new Ventana_Comentario("Comentarios", Tabla);
			}
		});
		
		btnPDF.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPDFActionPerformed(evt);
			}

			private void btnPDFActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				PDF pdf = new PDF(Tabla, cp.us, paso);
				pdf.Generador_PDF();
			}
		});

		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					btnImportarActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			private void btnImportarActionPerformed(ActionEvent evt) throws IOException {// GEN-FIRST:event_btnImportarTablaActionPerformed
				
				File file = null;
				file = cp.importar();
				//importado = file.getAbsolutePath();
//				System.out.println(importado);
				eliminar();
				CrearTabla(file);
				Tabla.setEnabled(false);
			}
			
			private void eliminar(){
		        DefaultTableModel tb = (DefaultTableModel) Tabla.getModel();
		        int a = Tabla.getRowCount()-1;
		        for (int i = a; i >= 0; i--) {          
		        	tb.removeRow(tb.getRowCount()-1);
		        }
		    }
			
		});
		
		/**
		 * Evento generarDiagrama
		 * Llama al metodo iniciar de control diagrama
		 */
		btnGenDiagrama.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					cd.iniciar(Tabla);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		btnExportar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExportarActionPerformed(evt);
			}
			
			private void btnExportarActionPerformed(ActionEvent evt) {
				cp.exportar(frmProceso, Tabla);
				Tabla.setEnabled(false);
			}
		});
		
		
		btnActualizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnActualizarActionPerformed(evt);
			}

			private void btnActualizarActionPerformed(ActionEvent evt) {
				if(cp.editar(Tabla,importado) == true) {
					JOptionPane.showMessageDialog(null, "TABLA ACTUALIZADA CON EXITO!");
					Tabla.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "HUBO PROBLEMAS AL ACTUALIZAR!");
					Tabla.setEnabled(false);
				}
				
			}
		});
		
		texFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				texFiltrokeyTyped(evt);
			}
			private void texFiltrokeyTyped(KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
		        // TODO add your handling code here:
		        texFiltro.addKeyListener(new KeyAdapter() {
		            public void keyReleased(final KeyEvent e) {
		                String cadena = (texFiltro.getText());
		                texFiltro.setText(cadena);
		                filtro();
		            }
					private void filtro() {
						// TODO Auto-generated method stub
						int columnaABuscar = 0;
				        if (cbBusqueda.getSelectedItem() == "IDPaso") {
				            columnaABuscar = 0;
				        }
				        if (cbBusqueda.getSelectedItem().toString() == "Nombre") {
				            columnaABuscar = 1;
				        }
				        if (cbBusqueda.getSelectedItem().toString() == "Descripcion") {
				            columnaABuscar = 2;
				        }
				        if (cbBusqueda.getSelectedItem().toString() == "ID Paso Anterior") {
				            columnaABuscar = 3;
				        }
				        if (cbBusqueda.getSelectedItem().toString() == "Conector") {
				            columnaABuscar = 4;
				        }
				        if (cbBusqueda.getSelectedItem().toString() == "Tipo de Forma") {
				            columnaABuscar = 5;
				        }
				        if (cbBusqueda.getSelectedItem().toString() == "Actor Responsable") {
				            columnaABuscar = 6;
				        }
				        //Con este código le indicamos que que busque en la columna que elijamos gracias al JComboBox.
				        trsFiltro.setRowFilter(RowFilter.regexFilter(texFiltro.getText(), columnaABuscar));
					}
		        });
		        trsFiltro = new TableRowSorter(Tabla.getModel());
		        Tabla.setRowSorter(trsFiltro);
		        Tabla.setEnabled(true);

		    }
		});
		
		
	}
	/**
	 * 
	 *Este codigo tiene que estar fuera del metodo inicializar para que funcione bien
	 *
	 **/
	private void CrearTabla(File file) throws IOException {
		importado = file.getAbsolutePath();
		if(importado.endsWith(".xls")){
			Workbook workbook = null;
			try {
				workbook = Workbook.getWorkbook(file);
				Sheet sheet = workbook.getSheet(0);
				columna.clear();
				for (int i = 0; i < sheet.getColumns(); i++) {
					Cell cell1 = sheet.getCell(i, 0);
					columna.add(cell1.getContents());
				}
				filas.clear();
				for (int j = 1; j < sheet.getRows(); j++) {
					Vector d = new Vector();
					for (int i = 0; i < sheet.getColumns(); i++) {
						Cell cell = sheet.getCell(i, j);
							d.add(cell.getContents());
					}
					d.add("\n");
					modelo.addRow(d);
				}
			} catch (BiffException e) {
				e.printStackTrace();
			}
		}else if(importado.endsWith(".csv")){
			Scanner scanner = new Scanner(new File(importado));
	        while (scanner.hasNext()) {
	            List<String> line = CSVUtils.parseLine(scanner.nextLine());
	            //System.out.println("Country [id= " + line.get(0) + ", code= " + line.get(1) + " , name=" + line.get(2) + "]");
	            modelo.addRow(line.toArray());
	        }
	        scanner.close();
		}
	}
	
}
