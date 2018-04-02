package negocio;

import java.awt.Graphics;
import java.util.LinkedList;


import javax.swing.JPanel;

import jxl.write.Font;

public class Diagrama extends JPanel{
	
//	String[] paso;
	LinkedList<int[]> posiciones;
	LinkedList<String[]> pasos;
	int x;
	int y;
	
	public Diagrama(String[] paso){
		this.x= 10;
		this.y=10;
		this.posiciones = new LinkedList<int[]>();
		this.pasos = new LinkedList<String[]>();
		int[] aux ={this.x,this.y};
		this.posiciones.addLast(aux);
//		this.paso = paso;
		this.pasos.addLast(paso);
	}
	
	@Override
	public void paint(Graphics g){//dibuja
		
		
//		int[] aux ={this.x,this.y};
//		this.posiciones.addLast(aux);
		for(int i = 0; i< this.pasos.size(); i++){
		
			String[] paso = this.pasos.get(i);
			int[] pos  = this.posiciones.get(i);
			int x = pos[0];
			int y = pos[1];
			//dibuja la figura
			switch(paso[4]){
			default: 
				g.drawOval(x, y, 50, 18);
				g.drawString(paso[1], x+5, y+4);
				break;
			case "Rombo":
				int[] x2 = {x+25,x+50,x+25,x};
				int[] y2  ={y,y+9,y+18, y+9};
				g.drawPolygon(x2,y2 , 4);
				g.drawString(paso[1], this.x+5, this.y+4);
				break;
			case "Rectangulo":
				g.drawOval(x, y, 50, 10);
				g.drawString(paso[1], x+5, y+4);
				break;
			case "Ovalo":
				g.drawOval(x, y, 50, 10);
				g.drawString(paso[1], x+5, y+4);
				break;
			}
		}
		
		
		
	}
	
	
	public void agregapaso(String[] paso){
		this.pasos.addLast(paso);
	}
	
	public void agregapos(){
		this.y+=25;
		if(this.y>=370){
			this.y =10;
			this.x = 60;
		}
		int[] pos = {this.x, this.y};
		this.posiciones.addLast(pos);
	}
	
}
