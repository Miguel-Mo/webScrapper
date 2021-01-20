package webScrapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {


		//pass the url as the input argument.
		try {
			while(true) {
			    Document document= Jsoup.connect("https://www.bolsamadrid.es/esp/aspx/Mercados/Precios.aspx?indice=ESI100000000&punto=indice").get();
			    Elements tabla = document.select("table#ctl00_Contenido_tblÍndice > tbody > tr[align=\"right\"]");
				Elements tabla2 = document.select("table#ctl00_Contenido_tblAcciones  > tbody > tr[align=\"right\"]");
				
				System.out.println(tabla.text()); 
				System.out.println(tabla2.text()); 
				
				File file =new File("bolsa.txt");
				
				// Creates a FileWriter
				FileWriter writer = new FileWriter(file,true);

				// Creates a BufferedWriter
				BufferedWriter buffer = new BufferedWriter(writer);
				
				if(!file.exists()){
					file.createNewFile();
					buffer.write(tabla.text()+"\n");
					buffer.write(tabla2.text()+"\n");
		    	  }else {
					buffer.write(tabla.text()+"\n");
					buffer.write(tabla2.text()+"\n");
		    	  }

				buffer.close();
				
				Thread.sleep(60000);
			}
			
		    
		}catch (IOException e){
		    e.getMessage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Use DOM methods to navigate a document
		//Elements tabla = document.getElementById("aspnetForm");
		

		
		//Then We can then get the values inside the container.
		//String tablaText=tabla.text();

	}

}
