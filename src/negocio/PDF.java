package negocio;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import datos.DAO_Diagrama;

public class PDF {

	private DAO_Diagrama Panel_Diagrama;
	private String Nombre_Diagrama;
	private JTable tabla;
	private JPanel Panel;
	private String usuario;
	File paso;
	
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final static String HOSTNAME = "mydb-ealpha.cdtc5pclholt.us-west-1.rds.amazonaws.com";
	final static String DBNAME = "dbeadda";
	final static String CONNECTION_URL = "jdbc:mysql://"+HOSTNAME +":3306/"+DBNAME;
	final static String USERNAME = "masterUser";
	final static String PASSWORD = "equipoalpha";

	public PDF(JTable tabla, String usuario, File paso) {
		this.tabla = tabla;
		this.usuario = usuario;
		this.paso=paso;
	}



	public boolean Generador_PDF() {
		
		Panel_Diagrama = new DAO_Diagrama();
		Panel = Panel_Diagrama.generaDiagrama(tabla);
		Panel.setBounds(20, 20, 400, 400);
		
		try {
			Nombre_Diagrama = captureComponent(Panel);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		 ResultSet rs = null;
		
		PDFont font = PDType1Font.TIMES_ROMAN;
		float fontSize = 12.0f;
		int tab = 50;// Tamaño de la Tabulacion
		int num_de_lineas = 42;
		int lineas_hechas = 0;

		try {

			PDDocument document = new PDDocument();

			// Creacion de una pagina
			PDPage page = new PDPage(PDRectangle.LETTER);
			// Se agraga esa pagina al documento
			document.addPage(page);
			// Se crea un objeto que sera ocupado para la edicion de la pagina
			PDPageContentStream contenido = new PDPageContentStream(document, page);
			// insertar la imagen
			PDImageXObject imagen = PDImageXObject.createFromFile("LOGO.png", document);
			float scale = 0.2f;
			contenido.drawImage(imagen, tab, 725, imagen.getWidth() * scale, imagen.getHeight() * scale);

			// Se tiene que iniciar con esta linea siempre para cada contenido
			contenido.beginText();
			// Se le pone el tipo de fuente de la letra y el tamaAo
			contenido.setFont(font, 2 * fontSize);
			// El espacion entre cada renglon
			contenido.setLeading(15);
			// En donde empesara el texto
			contenido.newLineAtOffset((float) (2.5 * tab), 725);

			// TEXTO
			// Se ocupa una variable string la cual sera modificada
			String texto = "Empresa XXX de SA de CV";
			contenido.showText(texto);// Esta linea agrega el texto a la pagina
			contenido.newLine();// Da un salto de linea
			contenido.newLine();// Salto de linea
			lineas_hechas += 2;

			contenido.setFont(font, fontSize);// Se modifica el tamaAo
			contenido.newLineAtOffset((float) (-1.5 * tab), 0);
			StringTokenizer st = new StringTokenizer(paso.getAbsolutePath(), "\\");
			String Nombre="";
			while(st.hasMoreTokens()) {
				Nombre= st.nextToken();
			}
			texto = "Nombre del Proceso: "+Nombre.substring(0, Nombre.length()-4);
			contenido.showText(texto);
			contenido.newLine();
			contenido.newLine();
			lineas_hechas += 2;
			
			String todas_plantillas = "Select Nombre, Apellido from Usuario where Nick='"+usuario+"'";
			try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
	                PreparedStatement pstmt = connection.prepareStatement(todas_plantillas);){
				rs = pstmt.executeQuery();
				rs.next();
				texto = "Nombre del Asesor: "+rs.getString("Nombre")+" "+rs.getString("Apellido")+".";
			}
			contenido.showText(texto);
			contenido.newLine();
			contenido.newLine();
			lineas_hechas += 2;
			
			todas_plantillas = "Select ISO from Plantilla where Usuario='"+usuario+"' and Nombre='"+Nombre+"'";
			try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
	                PreparedStatement pstmt = connection.prepareStatement(todas_plantillas);){
				rs = pstmt.executeQuery();
				rs.next();
				texto = "Norma ISO: "+rs.getString("ISO");
			}
			contenido.showText(texto);
			contenido.newLine();
			contenido.newLine();
			lineas_hechas += 2;

			texto = "Procedimiento de Auditoria Interna.";
			contenido.showText(texto);
			contenido.newLine();
			contenido.newLine();
			lineas_hechas += 2;

			Calendar fecha = new GregorianCalendar();// Esto es para la fecha
			int mes = fecha.get(Calendar.MONTH) + 1;// Dado que regresa un nuemero entero del 0a11 se tiene que sumar 1
			texto = "Fecha: " + fecha.get(Calendar.DAY_OF_MONTH) + "/" + mes + "/" + fecha.get(Calendar.YEAR);
			contenido.showText(texto);
			contenido.newLine();
			contenido.newLine();
			lineas_hechas += 2;

			texto = "Pasos del proceso.";
			contenido.showText(texto);
			contenido.newLine();
			contenido.newLine();
			lineas_hechas += 2;

			for (int i = 0; i < tabla.getRowCount(); i++) {

				texto = "ID: " + tabla.getModel().getValueAt(i, 0) + " Nombre: " + tabla.getModel().getValueAt(i, 1);
				if (lineas_hechas < num_de_lineas) {
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas += 1;
				} else {
					contenido.endText();
					contenido.close();
					page = new PDPage(PDRectangle.LETTER);
					document.addPage(page);
					contenido = new PDPageContentStream(document, page);
					contenido.beginText();
					contenido.setFont(font, fontSize);
					contenido.setLeading(15);
					contenido.newLineAtOffset((float) (1 * tab), 725);
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas = 1;
				}
				contenido.newLineAtOffset((float) tab, 0);

				texto = "Descripcion: " + tabla.getModel().getValueAt(i, 2);
				if (lineas_hechas < num_de_lineas) {
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas += 1;
				} else {
					contenido.endText();
					contenido.close();
					page = new PDPage(PDRectangle.LETTER);
					document.addPage(page);
					contenido = new PDPageContentStream(document, page);
					contenido.beginText();
					contenido.setFont(font, fontSize);
					contenido.setLeading(15);
					contenido.newLineAtOffset((float) (2 * tab), 725);
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas = 1;
				}

				texto = "ID del Paso enterior: " + tabla.getModel().getValueAt(i, 3);
				if (lineas_hechas < num_de_lineas) {
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas += 1;
				} else {
					contenido.endText();
					contenido.close();
					page = new PDPage(PDRectangle.LETTER);
					document.addPage(page);
					contenido = new PDPageContentStream(document, page);
					contenido.beginText();
					contenido.setFont(font, fontSize);
					contenido.setLeading(15);
					contenido.newLineAtOffset((float) (2 * tab), 725);
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas = 1;
				}
				texto = "Tipo de conector: " + tabla.getModel().getValueAt(i, 4);
				if (lineas_hechas < num_de_lineas) {
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas += 1;
				} else {
					contenido.endText();
					contenido.close();
					page = new PDPage(PDRectangle.LETTER);
					document.addPage(page);
					contenido = new PDPageContentStream(document, page);
					contenido.beginText();
					contenido.setFont(font, fontSize);
					contenido.setLeading(15);
					contenido.newLineAtOffset((float) (2 * tab), 725);
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas = 1;
				}

				texto = "Tipo de Forma: " + tabla.getModel().getValueAt(i, 5);
				if (lineas_hechas < num_de_lineas) {
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas += 1;
				} else {
					contenido.endText();
					contenido.close();
					page = new PDPage(PDRectangle.LETTER);
					document.addPage(page);
					contenido = new PDPageContentStream(document, page);
					contenido.beginText();
					contenido.setFont(font, fontSize);
					contenido.setLeading(15);
					contenido.newLineAtOffset((float) (2 * tab), 725);
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas = 1;
				}

				texto = "Actor Responsable: " + tabla.getModel().getValueAt(i, 6);
				if (lineas_hechas < num_de_lineas) {
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas += 1;
				} else {
					contenido.endText();
					contenido.close();
					page = new PDPage(PDRectangle.LETTER);
					document.addPage(page);
					contenido = new PDPageContentStream(document, page);
					contenido.beginText();
					contenido.setFont(font, fontSize);
					contenido.setLeading(15);
					contenido.newLineAtOffset((float) (2 * tab), 725);
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas = 1;
				}

				contenido.newLineAtOffset((float) -1 * tab, 0);
			}

			contenido.newLine();
			lineas_hechas += 1;
			texto = "Comentarios.";
			if (lineas_hechas < num_de_lineas) {
				contenido.showText(texto);
				contenido.newLine();
				lineas_hechas += 1;
			} else {
				contenido.endText();
				contenido.close();
				page = new PDPage(PDRectangle.LETTER);
				document.addPage(page);
				contenido = new PDPageContentStream(document, page);
				contenido.beginText();
				contenido.setFont(font, fontSize);
				contenido.setLeading(15);
				contenido.newLineAtOffset((float) (1 * tab), 725);
				contenido.showText(texto);
				contenido.newLine();
				lineas_hechas = 1;
			}

			contenido.newLine();
			lineas_hechas += 1;

			for (int i = 0; i < tabla.getRowCount(); i++) {

				texto = "ID: " + tabla.getModel().getValueAt(i, 0) + " Nombre: " + tabla.getModel().getValueAt(i, 1);
				if (lineas_hechas < num_de_lineas) {
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas += 1;
				} else {
					contenido.endText();
					contenido.close();
					page = new PDPage(PDRectangle.LETTER);
					document.addPage(page);
					contenido = new PDPageContentStream(document, page);
					contenido.beginText();
					contenido.setFont(font, fontSize);
					contenido.setLeading(15);
					contenido.newLineAtOffset((float) (1 * tab), 725);
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas = 1;
				}

				contenido.newLineAtOffset((float) tab, 0);

				texto = "Comentario: " + tabla.getModel().getValueAt(i, 7);
				if (lineas_hechas < num_de_lineas) {
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas += 1;
				} else {
					contenido.endText();
					contenido.close();
					page = new PDPage(PDRectangle.LETTER);
					document.addPage(page);
					contenido = new PDPageContentStream(document, page);
					contenido.beginText();
					contenido.setFont(font, fontSize);
					contenido.setLeading(15);
					contenido.newLineAtOffset((float) (2 * tab), 725);
					contenido.showText(texto);
					contenido.newLine();
					lineas_hechas = 1;
				}

				contenido.newLineAtOffset((float) -1 * tab, 0);
			}

			contenido.endText();
			contenido.close();
			texto = "Diagrama.";
			page = new PDPage(PDRectangle.LETTER);
			document.addPage(page);
			contenido = new PDPageContentStream(document, page);
			contenido.beginText();
			contenido.setFont(font, fontSize);
			contenido.setLeading(15);
			contenido.newLineAtOffset((float) (1 * tab), 725);
			contenido.showText(texto);
			contenido.newLine();
			lineas_hechas = 1;
			contenido.endText();
			// contenido.close();

			// insertar la imagen

			/**
			 * Se crea una nueva pagina ya que no existe algun metodo que te diaga en que
			 * poscicion esta el ultimo texto que se escribio
			 */

			PDRectangle pageSize = page.getMediaBox();
			PDImageXObject imagen_Diagrama = PDImageXObject.createFromFile(Nombre_Diagrama, document);

			/**
			 * Todo lo que se encuentra abajo es para poder tenerminar el centro de la
			 * pagina y colocar la imagen lo mas centrado posible.
			 * 
			 **/

			float scale2 = 1.0f;
			float stringWidth = imagen_Diagrama.getWidth();
			float stringHeight = imagen_Diagrama.getWidth();
			int rotation = page.getRotation();
			boolean rotate = rotation == 90 || rotation == 270;
			float pageWidth = rotate ? pageSize.getHeight() : pageSize.getWidth();
			float pageHeight = rotate ? pageSize.getWidth() : pageSize.getHeight();
			float centerX = rotate ? (pageHeight - stringWidth) / 2f : (pageWidth - stringWidth) / 2f;
			float centerY = rotate ? (pageWidth - stringHeight) / 2f : (pageHeight - stringHeight) / 2f;
			contenido.drawImage(imagen_Diagrama, centerX, centerY, imagen.getWidth() * scale2,
					imagen.getHeight() * scale2);
			System.out.println(stringHeight + " " + stringWidth + " " + pageHeight + " " + pageWidth + " " + centerX
					+ " " + centerY);

			// contenido.endText();
			contenido.close();

			document.save("Formato.pdf");
			document.close();

			return true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}

	}

	/**
	 * 
	 * @param component
	 *            Metodo que se utiliza para crear la imagen, recibe un elemento
	 *            tipo component
	 * @return Regresa un string el cual es el nombre de la imagen en caso contrario
	 *         un null
	 */

	public String captureComponent(Component component) throws IllegalArgumentException {

		Rectangle rect = component.getBounds();

		try {
			String format = "png";
			String fileName = component.getName() + "." + format;
			BufferedImage captureImage = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
			component.paint(captureImage.getGraphics());

			ImageIO.write(captureImage, format, new File(fileName));

			return fileName;

		} catch (IOException ex) {
			System.err.println(ex);
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

}
