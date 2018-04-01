package negocio;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDF {
	
	public void Generador_PDF(JTable tabla) throws IOException{
		PDDocument document = new PDDocument();
		System.out.println(tabla.toString());
	      //Creacion de una pagina
	      PDPage page = new PDPage(PDRectangle.LETTER);
	      //Se agraga esa pagina al documento
	      document.addPage(page);
	      //Se crea un objeto que sera ocupado para la edicion de la pagina
	      PDPageContentStream contenido = new PDPageContentStream(document, page);
	      //insertar la imagen
	      PDImageXObject imagen = PDImageXObject.createFromFile("LOGO.png", document);
	      float scale = 0.2f;
	      System.out.println("Paso a lo siguiente "+imagen.getHeight());
	      contenido.drawImage(imagen, 50, 725, imagen.getWidth()*scale, imagen.getHeight()*scale);
	      
	      //Se tiene que iniciar con esta linea siempre para cada contenido
	      contenido.beginText();
	      //Se le pone el tipo de fuente de la letra y el tamaAo
	      contenido.setFont(PDType1Font.TIMES_ROMAN, 20);
	      //El espacion entre cada renglon
	      contenido.setLeading(15);
	      //En donde empesara el texto
	      contenido.newLineAtOffset(50, 725);
	      
	      //TEXTO	      
	      //Se ocupa una variable string la cual sera modificada
	      String texto = "                Empresa XXX de SA de CV";
	      contenido.showText(texto);//Esta linea agrega el texto a la pagina
	      contenido.newLine();//Da un salto de linea
	      contenido.newLine();//Salto de linea
	      
	      contenido.setFont(PDType1Font.TIMES_ROMAN, 12);//Se modifica el tamaAo
	      texto = "Procedimiento      No. de RevisiAn: ";
	      contenido.showText(texto);
	      contenido.newLine();
	      contenido.newLine();
	      
	      texto = "Norma ISO 9001:2008       Clausula: 8.2.2";
	      contenido.showText(texto);
	      contenido.newLine();
	      contenido.newLine();
	      
	      texto = "Procedimiento de Auditoria Interna";
	      contenido.showText(texto);
	      contenido.newLine();
	      contenido.newLine();
	      
	      Calendar fecha = new GregorianCalendar();//Esto es para la fecha
	      int mes = fecha.get(Calendar.MONTH)+1;//Dado que regresa un nuemero entero del 0a11 se tiene que sumar 1
	      texto = "Fecha: "+fecha.get(Calendar.DAY_OF_MONTH)+"/"+mes+"/"+fecha.get(Calendar.YEAR);
	      contenido.showText(texto);
	      contenido.newLine();
	      contenido.newLine();
	      
	      texto = "Codigo: ";
	      contenido.showText(texto);
	      contenido.newLine();
	      contenido.newLine();
	      
	      texto = "Contenido.";
	      contenido.showText(texto);
	      contenido.newLine();
	      
	      texto = "      1.- Objetivo";
	      contenido.showText(texto);
	      contenido.newLine();
	      
	      texto = "      2.- Alcanse";
	      contenido.showText(texto);
	      contenido.newLine();
	      
	      texto = "      3.- Responsabilidad y Autoridad";
	      contenido.showText(texto);
	      contenido.newLine();
	      
	      texto = "      4.- Diagrama de Flujo";
	      contenido.showText(texto);
	      contenido.newLine();
	      
	      texto = "      5.- Descripcion de actividades";
	      contenido.showText(texto);
	      contenido.newLine();
	      
	      texto = "      6.- Anexsos, documentos y referenciales";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "      7.- Registros";
	      contenido.showText(texto);
	      contenido.newLine();
	      
	      texto = "      8.- Control de cambios";
	      contenido.showText(texto);
	      contenido.newLine();
	      contenido.newLine();
	      
	      contenido.setLeading(8);
	      texto = "---------------------------------------------------------";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "|         Elaboro        |       Revision y Abrobo    2   |";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "---------------------------------------------------------";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "|                              |                                            |";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "|                              |                                            |";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "|                              |                                            |";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "|                              |                                            |";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "|                              |                                            |";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "|                              |                                            |";
	      contenido.showText(texto);
	      contenido.newLine();	
	      texto = "|                              |                                            |";
	      contenido.showText(texto);
	      contenido.newLine();
	      texto = "----------------------------------------------------------";
	      contenido.showText(texto);
	      contenido.newLine();
	      contenido.setLeading(15);//A falta de la experiencia en como hacer una tabla se procede con una forma burda
	      texto = "----------------------------------------------------------";
	      contenido.showText(texto);
	      contenido.newLine();
	      
	      contenido.endText();
	      contenido.close();
	      
	      document.save("Formato2.pdf");
	      document.close();

	}
	
}
