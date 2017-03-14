package com.jargelo.dev;

public class Corredor implements Runnable{
	private int edad;
	private int variaRecorrido;
	private int nInicial;
	private int nFinal;
	private boolean contarTodo;
	private int aumento;
	
	@Override
	public void run() {
		/*
		long longFinal = 1000000000;
		long longInicial = 1;
		correr(longInicial, longFinal);
		*/
		try{
			if(nInicial!=nFinal)
				switch(variaRecorrido){
				case 1:
					correr(nInicial, nFinal);
				break;
				case 2:
					correrSaltando(nInicial, nFinal);
				break;
				case 3:
					correrDeRegreso(nInicial, nFinal);
				break;
				}
		}catch(NullPointerException e){
			try{
				switch(variaRecorrido){
				case 1:
					correr();
				break;
				case 2:
					correrSaltando();
				break;
				case 3:
					correrDeRegreso();
				break;
				}
			}catch(NullPointerException e1){
				System.out.println("NO DECLARASTE EL TIPO DE CARRERA");
			}
		}
	}
	
	protected Corredor(){
		this.variaRecorrido = 1;
		this.contarTodo = false;
		int escala = 100;
		
		this.aumento = obtenerAumento(escala);
	}
	
	protected Corredor(int nInicial, int nFinal){
		this.variaRecorrido = 1;
		this.contarTodo = false;
		int escala = 100;
		
		this.nInicial = nInicial;
		
		this.nFinal = nFinal*escala;
		this.aumento = obtenerAumento(escala);
	}
	
	public Corredor(int edad, int nInicial, int nFinal){
		this.variaRecorrido = 1;
		this.contarTodo = false;
		//int escala = 100;
		int escala = 1;
		
		this.edad = edad;
		this.nInicial = nInicial;
		
		this.nFinal = nFinal*escala;
		//this.aumento = obtenerAumento(escala);
		this.aumento = 1;
	}
	
	public Corredor(int edad, int nInicial, int nFinal, boolean contarTodo){
		this.variaRecorrido = 1;
		//int escala = 100;
		int escala = 1;
		
		this.contarTodo = contarTodo;
		this.edad = edad;
		this.nInicial = nInicial;
		
		this.nFinal = nFinal*escala;
		//this.aumento = obtenerAumento(escala);
		this.aumento = 1;
	}
	
	protected Corredor(int edad, int escala, int nInicial, int nFinal, boolean contarTodo){
		this.variaRecorrido = 1;
		
		this.contarTodo = contarTodo;
		this.edad = edad;
		this.nInicial = nInicial;
		
		int escala1 = escala;
		this.nFinal = nFinal*escala1;
		this.aumento = obtenerAumento(escala);
	}
	
	protected int getTipoCarrera(){
		return variaRecorrido;
	}
	
	public void setTipoCarrera(int variaRecorrido){
		this.variaRecorrido = variaRecorrido;
	}
	
	protected int getEdad() {
		return edad;
	}

	protected void setEdad(int edad) {
		this.edad = edad;
	}
	
	protected int getNInicial(){
		return nInicial;
	}
	
	protected int getNFinal(){
		return nFinal;
	}
	
	protected void setNInicial(int nInicial){
		this.nInicial = nInicial;
	}
	
	protected void setNFinal(int nFinal){
		this.nFinal = nFinal;
	}

	public boolean getContarTodo() {
		return contarTodo;
	}

	public void setContarTodo(boolean contarTodo) {
		this.contarTodo = contarTodo;
	}
	
	protected int getAumento() {
		return aumento;
	}

	protected void setAumento(int aumento) {
		this.aumento = aumento;
	}
	
	public int obtenerRetraso(){
		try{
			// 20km/hr
			if(edad>=18&&edad<=24)
				//return 0;
				return 1000;
			// 18km/hr
			else if(edad>=25&&edad<=35)
				//return 1000;
				return 1100;
			// 15km/hr
			else if(edad>=36&&edad<=40)
				//return 2500;
				return 1250;
		}catch(NullPointerException e){
			
		}
		return 0;
	}
	
	public int obtenerAumento(int escala){
		try{
			// 20km/hr
			if(edad>=18&&edad<=24)
				return escala;
			// 18km/hr
			else if(edad>=25&&edad<=35)
				return Integer.parseInt(String.valueOf((int)(escala*.9)));
			// 15km/hr
			else if(edad>=36&&edad<=40)
				return Integer.parseInt(String.valueOf((int)(escala*.75)));
		}catch(NullPointerException e){
			
		}
		return 0;
	}
	
	private void correr(){
		for(int i=1;i<=100;i+=1){
			try{
				Thread.sleep(obtenerRetraso());
			}catch(InterruptedException e){
				
			}
			if(contarTodo){
				if(i==1)
					System.out.println("Comenzó: "+Thread.currentThread().getName());
				System.out.println(i+" ["+Thread.currentThread().getName()+"]");
				if(i==100)
					System.out.println("Finalizó: "+Thread.currentThread().getName());
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void correr(long nInicial, long nFinal){
		//System.out.println(nFinal);
		if(aumento!=1)
			System.out.println("Yo ["+Thread.currentThread().getName()+"] corro a: "+aumento/5+" km/hr");
		for(long i=nInicial;i<=nFinal;i+=1*aumento){
			try{
				Thread.sleep(obtenerRetraso());
			}catch(InterruptedException e){
				
			}if(aumento==1&&contarTodo){
				if(i==nInicial)
					System.out.println("Comenzó: "+Thread.currentThread().getName());
				System.out.println(i+" ["+Thread.currentThread().getName()+"]");
				if(i==nFinal)
					System.out.println("Finalizó: "+Thread.currentThread().getName());
			}
		}
		if(!contarTodo)
			System.out.println("Finalizó: "+Thread.currentThread().getName());
	}
	
	private void correr(int nInicial, int nFinal){
		if(aumento!=1)
			System.out.println("Yo ["+Thread.currentThread().getName()+"] corro a: "+aumento/5+" km/hr");
		for(int i=nInicial;i<=nFinal;i+=1*aumento){
			try{
				Thread.sleep(obtenerRetraso());
			}catch(InterruptedException e){
				
			}if(aumento==1&&contarTodo){
				if(i==nInicial)
					System.out.println("Comenzó: "+Thread.currentThread().getName());
				System.out.println(i+" ["+Thread.currentThread().getName()+"]");
				if(i==nFinal)
					System.out.println("Finalizó: "+Thread.currentThread().getName());
			}
		}
		if(!contarTodo)
			System.out.println("Finalizó: "+Thread.currentThread().getName());
	}
	
	private void correrSaltando(){
		for(int i=2;i<=200;i+=2){
			try{
				Thread.sleep(obtenerRetraso());
			}catch(InterruptedException e){
				
			}
			if(contarTodo){
				if(i==2)
					System.out.println("Comenzó: "+Thread.currentThread().getName());
				System.out.println(i+" ["+Thread.currentThread().getName()+"]");
				if(i==200)
					System.out.println("Finalizó: "+Thread.currentThread().getName());
			}
		}
	}
	
	private void correrSaltando(int nInicial, int nFinal){
		if(aumento!=1)
			System.out.println("Yo ["+Thread.currentThread().getName()+"] corro a: "+aumento/5+" km/hr");
		for(int i=nInicial;i<=nFinal;i+=2*aumento){
			try{
				Thread.sleep(obtenerRetraso());
			}catch(InterruptedException e){
				
			}if(aumento==1&&contarTodo){
				if(i==nInicial)
					System.out.println("Comenzó: "+Thread.currentThread().getName());
				System.out.println(i+" ["+Thread.currentThread().getName()+"]");
				if(i==nFinal)
					System.out.println("Finalizó: "+Thread.currentThread().getName());
			}
		}
		if(!contarTodo)
			System.out.println("Finalizó: "+Thread.currentThread().getName());
	}
	
	private void correrDeRegreso(){
		for(int i=100;i>=1;i-=1){
			try{
				Thread.sleep(obtenerRetraso());
			}catch(InterruptedException e){
				
			}
			if(contarTodo){
				if(i==100)
					System.out.println("Comenzó: "+Thread.currentThread().getName());
				System.out.println(i+" ["+Thread.currentThread().getName()+"]");
				if(i==1)
					System.out.println("Finalizó: "+Thread.currentThread().getName());
			}
		}
	}
	
	private void correrDeRegreso(int nInicial, int nFinal){
		if(aumento!=1)
			System.out.println("Yo ["+Thread.currentThread().getName()+"] corro a: "+aumento/5+" km/hr");
		for(int i=nInicial;i>=nFinal;i-=1*aumento){
			try{
				Thread.sleep(obtenerRetraso());
			}catch(InterruptedException e){
				
			}if(aumento==1&&contarTodo){
				if(i==nInicial)
					System.out.println("Comenzó: "+Thread.currentThread().getName());
				System.out.println(i+" ["+Thread.currentThread().getName()+"]");
				if(i==nFinal)
					System.out.println("Finalizó: "+Thread.currentThread().getName());
			}
		}
		if(!contarTodo)
			System.out.println("Finalizó: "+Thread.currentThread().getName());
	}
	
}
