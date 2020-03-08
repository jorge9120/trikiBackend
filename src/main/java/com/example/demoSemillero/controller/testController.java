package com.example.demoSemillero.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class testController {
	int i=0;
	String m[][]= new String[3][3];
	
	@GetMapping(value="holaMundo", produces=MediaType.APPLICATION_JSON_VALUE)
	public String holaMundo() {
		return "hola Mundo";
	}
	
	@GetMapping(value="byeMundo", produces=MediaType.APPLICATION_JSON_VALUE)
	public String byeMundo() {
		return "chao Mundo";
	}
	
	@GetMapping(value="contar", produces=MediaType.APPLICATION_JSON_VALUE)
	public String contar() {
		i++;
		return "contando"+i;
	}
	
	@GetMapping(value="triqui", produces=MediaType.APPLICATION_JSON_VALUE)
	public String[][] triqui() {
		this.m[0][0] = "_";
		this.m[0][1] = "_";
		this.m[0][2] = "_";
		this.m[1][0] = "_";
		this.m[1][1] = "_";
		this.m[1][2] = "_";
		this.m[2][0] = "_";
		this.m[2][1] = "_";
		this.m[2][2] = "_";
		return m;
	}
	
	@GetMapping(value="llenarTriqui", produces=MediaType.APPLICATION_JSON_VALUE)
	public String[][] llenarTriqui(@PathParam("x") String x,@PathParam("y") String y,@PathParam("t") String t) {
		/*String t=turno.toString();
		String x=xval.toString();
		String y=yval.toString();*/
		System.out.println(x+" "+y+" "+t);
		if(m[Integer.parseInt(x)][Integer.parseInt(y)].equals("_")) 
		m[Integer.parseInt(x)][Integer.parseInt(y)]=t;
		
		return m;
		
	}
	
	@GetMapping(value="ganador", produces=MediaType.APPLICATION_JSON_VALUE)
	public String ganador() {
		
		if (this.m[0][0].equals("1") 
				&& this.m[0][1].equals("1") 
				&& this.m[0][2].equals("1")) {
			return "gana 1";
		}
		if (this.m[1][0].equals("1") 
				&& this.m[1][1].equals("1") 
				&& this.m[1][2].equals("1")) {
			return "gana 1";
		}
		if (this.m[2][0].equals("1") 
				&& this.m[2][1].equals("1") 
				&& this.m[2][2].equals("1")) {
			return "gana 1";
		}
		if (this.m[0][0].equals("1") 
				&& this.m[1][0].equals("1") 
				&& this.m[2][0].equals("1")) {
			return "gana 1";
		}
		if (this.m[0][1].equals("1") 
				&& this.m[1][1].equals("1") 
				&& this.m[2][1].equals("1")) {
			return "gana 1";
		}
		if (this.m[0][2].equals("1") 
				&& this.m[1][2].equals("1") 
				&& this.m[2][2].equals("1")) {
			return "gana 1";
		}
		if (this.m[0][0].equals("1") 
				&& this.m[1][1].equals("1") 
				&& this.m[2][2].equals("1")) {
			return "gana 1";
		}
		if (this.m[2][0].equals("1") 
				&& this.m[1][1].equals("1") 
				&& this.m[0][2].equals("1")) {
			return "gana 1";
		}
		
		
		
		if (this.m[0][0].equals("2") 
				&& this.m[0][1].equals("2") 
				&& this.m[0][2].equals("2")) {
			return "gana 2";
		}
		if (this.m[1][0].equals("2") 
				&& this.m[1][1].equals("2") 
				&& this.m[1][2].equals("2")) {
			return "gana 2";
		}
		if (this.m[2][0].equals("2")
				&& this.m[2][1].equals("2") 
				&& this.m[2][2].equals("2")) {
			return "gana 2";
		}
		if (this.m[0][0].equals("2") 
				&& this.m[1][0].equals("2") 
				&& this.m[2][0].equals("2")) {
			return "gana 2";
		}
		if (this.m[0][1].equals("2")
				&& this.m[1][1].equals("2") 
				&& this.m[2][1].equals("2")) {
			return "gana 2";
		}
		if (this.m[0][2].equals("2") 
				&& this.m[1][2].equals("2") 
				&& this.m[2][2].equals("2")) {
			return "gana 2";
		}
		if (this.m[0][0].equals("2") 
				&& this.m[1][1].equals("2") 
				&& this.m[2][2].equals("2")) {
			return "gana 2";
		}
		if (this.m[2][0].equals("2") 
				&& this.m[1][1].equals("2") 
				&& this.m[0][2].equals("2")) {
			return "gana 2";
		}
		
		boolean empate=this.termino(m);
		
		if(empate) {
			return "empate";	
		}
		return "sigue el juego";
		
	}
	
	public boolean termino(String [][]m) {
		for (int i = 0; i < this.m.length; i++) {
			for (int j = 0; j < this.m[i].length; j++) {
				if(m[i][j].equals("_")) {
					return false;
				}
			}
		}
		return true;
	}
	
}
