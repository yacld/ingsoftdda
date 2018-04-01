package datos;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import negocio.PDF;

public class DAO_Paso {
	
	private JFileChooser FileChooser = new JFileChooser();

	public boolean editar(JTable Tabla, String importado) {
		try {
			List<JTable> tb = new ArrayList<JTable>();
			tb.add(Tabla);
			// -------------------
			export_excel excelExporter = new export_excel(tb, new File(importado));
			if (excelExporter.export()) {
				//JOptionPane.showMessageDialog(null, "TABLA ACTUALIZADA CON EXITOS!");
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}
	
	public boolean exportar(JFrame frmProceso, JTable Tabla) {
		JFileChooser dialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Plantillas xls, csv", "xls", "csv");
		dialog.setFileFilter(filter);
		int opcion = dialog.showSaveDialog(frmProceso);
		
		if (opcion == JFileChooser.APPROVE_OPTION) {

			File dir = dialog.getSelectedFile();

			try {
				List<JTable> tb = new ArrayList<JTable>();
				tb.add(Tabla);
				// -------------------
				export_excel excelExporter = new export_excel(tb, new File(dir.getAbsolutePath()));
				if (excelExporter.export()) {
					JOptionPane.showMessageDialog(null, "TABLAS EXPORTADAS CON EXITO!");
					return true;
				}else{
					JOptionPane.showMessageDialog(null, "NO SE HA PODIDO EXPORTAR");
					return true;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public File importar() throws IOException {
//		System.out.println("Perro");
		FileChooser.showDialog(null, "Importar Plantilla ");
		File file =null;
//		System.out.println("Gato");
		file = FileChooser.getSelectedFile();
		//System.out.println(file.getPath());
		if (!file.getName().endsWith("xls") && !file.getName().endsWith("csv")) {


			JOptionPane.showMessageDialog(null, "Seleccione un archivo valido...", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
//			System.out.println("Gato6");
			return file;
		}
		return null;
	}

	public void generador_PDF(JTable tabla) throws IOException {
		PDF pdf = new PDF();
		pdf.Generador_PDF(tabla);
		
	}


	
	
	
}
