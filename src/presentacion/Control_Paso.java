package presentacion;
/**
 * Encargado de todolo relacionada a la edicion de la tabla de pasos en la 
 * plantilla
 */

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import datos.DAO_Paso;
import negocio.Servicio_Paso;


public class Control_Paso {

	Servicio_Paso sp;
	DAO_Paso daops = new DAO_Paso();
	String us;
	
	/**
	 * Constructor que recibe un sericio para estar conectado al DAO
	 * @param sp2: COn esto se pueden hacer operaciones en el DAO Paso
	 */
	public Control_Paso(Servicio_Paso sp2) {
		sp = sp2;
		sp = new Servicio_Paso(daops);
	}

	/**
	 * Abre una ventana con la plantilla antes seleccionada
	 * mostrando su contenido
	 * @param file2: es la plantila que tiene los datos
	 * @param nombre: es el nombre del archio, los archivos generados aprte de guardarlos en la base 
	 * tambien se generan en la carpeta del proyecto
	 * @throws IOException
	 */
	public void iniciar(File file2, String nombre) throws IOException {
		File file;
		file = file2;
		Tabla ventana = new Tabla(this, file,nombre);


		ventana.frmProceso.setVisible(true);
		
	}
	/**
	 * Este metodo esta diseñado para actualizar los pasos de una plantilla
	 * ya existente en la base de datos 
	 * @param Tabla: la tabla con los pasos de plantilla
	 * @param nombre: el nombre del archivo en la base
	 * @return : retorna un valor boolean para saber si se pudo o no actualizar
	 * @throws Exception
	 */
	public boolean editar1(JTable Tabla, String nombre) throws Exception {
		if(sp.editar1(Tabla, nombre) == true) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * Este es un metodo creado para las plantillas que aun no estan en la base de datos y
	 * estan como archivos externos, estos sos los que fueron importados, es mas ersatol, debido a que
	 * no necesita estar en la carpeta del sistema
	 * @param Tabla:tabla con los pasos de plantilla 
	 * @param importado: ubicacion de la plantilla en el equipo
	 * @return: regresa un valor booleano 
	 */
	public boolean editar(JTable Tabla, String importado) {
		if(sp.editar(Tabla, importado) == true) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * Exporta los datos de la tabla a un archivo tipo csv o xls
	 * @param frmProceso: el frm de la ventana
	 * @param Tabla: la tabla con los datos
	 */
	public void exportar(JFrame frmProceso, JTable Tabla) {
		sp.exportar(frmProceso, Tabla);
		
	}
	
	/**
	 * importa un archivo csv o xls de cualquier parte del equipo
	 * @return retorna un archivo con los datos para mostrarlos en la tabla
	 * @throws IOException
	 */
	public File importar() throws IOException {
		File file=null;
//		System.out.println("Gato4");
		file = sp.Importar();
//		System.out.println("Gato5");
		return file;
	}

	public void agregarComentario(String string, JTable tabla) {
		new Ventana_Comentario(string, tabla);
	}

	public void generador_PDF(JTable tabla) throws IOException {
		sp.generador_PDF(tabla);

		
	}

	/**
	 * Reisa si la plantilla existe en la base o es un archivo importado, se usa para decidir que metodo editar usar
	 * @param nombre: nombre de la plnatilla
	 * @return: un true si la plantilla esta en la base de datos
	 * @throws SQLException
	 */
	public boolean existe(String nombre) throws SQLException {
		if(sp.existe(nombre)) {
			return true;
		}else {
			return false;
		}
	}
	
}
