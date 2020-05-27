package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {

		private String username,fecha;
		
		
		public Usuario(String username, String fecha) {
			this.username = username;
			this.fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			
			
		}
		
		

		public String getFecha() {
			return fecha;
		}



		public void setFecha(String fecha) {
			this.fecha = fecha;
		}



		public String getUsername() {
			return username;
			
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
	}
	
