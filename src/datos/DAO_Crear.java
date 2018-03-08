package datos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DAO_Crear {

	public File crear(String[] datos) throws IOException {
		JFileChooser dialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Plantillas xls, csv", "xls");
		dialog.setFileFilter(filter);
		int opcion = dialog.showSaveDialog(new JFrame());
		File name = dialog.getSelectedFile();
		
		if (opcion == JFileChooser.APPROVE_OPTION) {

			File dir = dialog.getSelectedFile();

			try {
				List<JTable> tb = new ArrayList<JTable>();
				
				// -------------------
				export_excel excelExporter = new export_excel(tb, new File(dir.getAbsolutePath()));
				if (excelExporter.export()) {
					JOptionPane.showMessageDialog(null, "TABLAS CREADA CON EXITO!");
					System.out.println("Esta es la direccion "+name);
					return name;
				}else{
					JOptionPane.showMessageDialog(null, "NO SE HA PODIDO CREAR");
					return null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
		return null;
       
	}



}
