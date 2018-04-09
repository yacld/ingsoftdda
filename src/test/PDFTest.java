package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.PDF;

class PDFTest {
	private PDF pdf;
	private JTable tabla;
	private JFrame frame;
	private File file;
	private String Name;
	

	@BeforeEach
	void setUp() throws Exception {
		tabla = new JTable();
		Name = "";
		pdf = new PDF(tabla, Name, file);
		frame = new JFrame("Frame");
		
	}

	@Test
	void testCaptureComponent() {
		frame.setBounds(0, 0, 400, 400);
		String retorno;
		retorno = pdf.captureComponent(frame);
		String esperado = frame.getName()+".png";
		assertEquals("Esto no salio, se esperaba el nombre correcto.",retorno,esperado);
	}
	
	@Test
	void testCaptureComponent1() {
		String retorno;
		retorno = pdf.captureComponent(frame);
		String esperado = null;
		assertEquals("Esto no salio, se esperaba algo de tipo nulo",retorno,esperado);
	}

}
