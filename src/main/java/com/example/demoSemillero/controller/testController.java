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
	int m[][]= new int[3][3];
	
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
	public int[][] triqui() {
		this.m[0][0] = 0;
		this.m[0][1] = 0;
		this.m[0][2] = 0;
		this.m[1][0] = 0;
		this.m[1][1] = 0;
		this.m[1][2] = 0;
		this.m[2][0] = 0;
		this.m[2][1] = 0;
		this.m[2][2] = 0;
		return m;
	}
	
	@GetMapping(value="llenarTriqui", produces=MediaType.APPLICATION_JSON_VALUE)
	public int[][] llenarTriqui(@PathParam("x") String x,@PathParam("y") String y,@PathParam("t") String t) {
		/*String t=turno.toString();
		String x=xval.toString();
		String y=yval.toString();*/
		System.out.println(x+" "+y+" "+t);
		if(m[Integer.parseInt(x)][Integer.parseInt(y)]==0) 
		m[Integer.parseInt(x)][Integer.parseInt(y)]=Integer.parseInt(t);
		
		return m;
		
		
	}
	
	@GetMapping(value="ganador", produces=MediaType.APPLICATION_JSON_VALUE)
	public String ganador() {
		
		if (this.m[0][0]==1 
				&& this.m[0][1]==1 
				&& this.m[0][2]==1) {
			return "gana 1";
		}
		if (this.m[1][0]==1 
				&& this.m[1][1]==1 
				&& this.m[1][2]==1) {
			return "gana 1";
		}
		if (this.m[2][0]==1 
				&& this.m[2][1]==1 
				&& this.m[2][2]==1) {
			return "gana 1";
		}
		if (this.m[0][0]==1 
				&& this.m[1][0]==1 
				&& this.m[2][0]==1) {
			return "gana 1";
		}
		if (this.m[0][1]==1 
				&& this.m[1][1]==1 
				&& this.m[2][1]==1) {
			return "gana 1";
		}
		if (this.m[0][2]==1 
				&& this.m[1][2]==1 
				&& this.m[2][2]==1) {
			return "gana 1";
		}
		if (this.m[0][0]==1 
				&& this.m[1][1]==1 
				&& this.m[2][2]==1) {
			return "gana 1";
		}
		if (this.m[2][0]==1 
				&& this.m[1][1]==1 
				&& this.m[0][2]==1) {
			return "gana 1";
		}
		
		
		
		if (this.m[0][0]==2 
				&& this.m[0][1]==2 
				&& this.m[0][2]==2) {
			return "gana 2";
		}
		if (this.m[1][0]==2 
				&& this.m[1][1]==2 
				&& this.m[1][2]==2) {
			return "gana 2";
		}
		if (this.m[2][0]==2
				&& this.m[2][1]==2 
				&& this.m[2][2]==2) {
			return "gana 2";
		}
		if (this.m[0][0]==2 
				&& this.m[1][0]==2 
				&& this.m[2][0]==2) {
			return "gana 2";
		}
		if (this.m[0][1]==2 
				&& this.m[1][1]==2 
				&& this.m[2][1]==2) {
			return "gana 2";
		}
		if (this.m[0][2]==2 
				&& this.m[1][2]==2 
				&& this.m[2][2]==2) {
			return "gana 2";
		}
		if (this.m[0][0]==2 
				&& this.m[1][1]==2 
				&& this.m[2][2]==2) {
			return "gana 2";
		}
		if (this.m[2][0]==2 
				&& this.m[1][1]==2 
				&& this.m[0][2]==2) {
			return "gana 2";
		}
		
		boolean empate=this.termino(m);
		
		if(empate) {
			return "empate";	
		}
		return "sigue el juego";
		
	}
	
	public boolean termino(int [][]m) {
		for (int i = 0; i < this.m.length; i++) {
			for (int j = 0; j < this.m[i].length; j++) {
				if(m[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	
}
