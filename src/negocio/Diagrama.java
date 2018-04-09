package negocio;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


import javax.swing.JPanel;

import jxl.write.Font;
/**
 * 
 * @author Yaeld
 *	Clase diagrama, extiende de JPanel (es un panel)
 *  contiene el metodo paint el cual dibuja en el panel
 */
public class Diagrama extends JPanel{
	
//	String[] paso;
	LinkedList<int[]> posiciones;
	LinkedList<String[]> pasos;
	int x;
	int y;
	/**
	 * constructor de la clase
	 * recibe un array con el primer paso a dibujar, este es el INICIO
	 * crea las listas que tendran los pasos y posiciones de la tabla
	 * @param paso
	 */
	public Diagrama(String[] paso){
		this.x= 180;
		this.y=10;
		this.posiciones = new LinkedList<int[]>();
		this.pasos = new LinkedList<String[]>();
		int[] aux ={this.x,this.y};
		this.posiciones.addLast(aux);
//		this.paso = paso;
		this.pasos.addLast(paso);
		this.setBackground(Color.white);
	}
	/**
	 * Metodo paint aqui se dibujan los pasos que estan en la lista
	 */
	@Override
	public void paint(Graphics g){//dibuja
		super.paint(g);
		for(int i = 0; i< this.pasos.size(); i++){
		
			String[] paso = this.pasos.get(i);
			int[] pos  = this.posiciones.get(Integer.parseInt(paso[0]));
			int[] posant  = this.posiciones.get(Integer.parseInt(paso[2]));
			int x = pos[0];
			int y = pos[1];
			//dibuja la figura
			switch(paso[4]){
			default: //hara el ovalo
				g.drawOval(x, y, 100, 30);
				g.drawString(paso[1], x+30, y+20);
				break;
			case "Rombo":
				int[] x2 = {x+50,x+100,x+50,x};
				int[] y2  ={y,y+15,y+30, y+15};
				g.drawPolygon(x2,y2 , 4);
				g.drawString(paso[1], x+30, y+20);
				break;
			case "Rectangulo":
				g.drawOval(x, y, 100, 30);
				g.drawString(paso[1], x+30, y+20);
				break;
			case "Ovalo":
				g.drawOval(x, y, 100, 30);
				g.drawString(paso[1], x+30, y+20);
				break;
			}
			int x1 = pos[0]+50;
			int y1 = pos[1];
			int x2 = posant[0]+50;
			int y2  =posant[1]+30;
			
			switch(paso[3]){
			default: //hara el simple
//				g.drawLine(x1, y1, x2, y2);
				break;
			case "Simple":
				g.drawLine(x1, y1, x2, y2);
				break;
			case "Condicion SI":
				g.drawLine(x1, y1, x2, y2);
				g.drawString("SI", (x1+x2)/2, (y1+y2)/2);
				break;
			case "Condicion NO":
				g.drawLine(x1, y1, x2, y2);
				g.drawString("NO", (x1+x2)/2, (y1+y2)/2);
				break;
			}
			
		}
		
		
		
	}
	
	/**
	 * metodo que agrega los pasos a la lista
	 * @param paso
	 */
	
	public void agregapaso(String[] paso){
		if(paso[2].equals("")){
			paso[2]=(Integer.parseInt(paso[0])-1) +"";
		}
		this.pasos.addLast(paso);
	}
	
	/**
	 * metodo que agrega la posicion de los pasos a la lista 
	 */
	public void agregapos(){
//		String[] aux = this.pasos.getLast();
		this.y+=50;
		int[] pos = {this.x, this.y};
		this.posiciones.addLast(pos);
	}
	/**
	 * metodo que agrega la posicion de los pasos que siguen un paso con una condicion a la lista 
	 * reciben un pequeño desvio de su posicion para la bifurcacion
	 * @param aux
	 * @param aux2
	 */
	public void agregaposcond(int aux, int aux2){
		
		this.y+=25;
		int[] pos = {this.x+aux, this.y+aux2};
		this.posiciones.addLast(pos);
	}
	
	
	
}
