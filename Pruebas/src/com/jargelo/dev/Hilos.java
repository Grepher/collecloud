package com.jargelo.dev;

public class Hilos implements Runnable {

	public Hilos(int i, int j) {

	}

	public static void main(String args) {
		Thread[] hilos = new Thread[2500];
		for (int indice = 1; indice < 2501; indice++) {
			hilos[indice - 1] = new Thread(new Hilos((indice - 1) * 400 + 1, indice * 400 + 1));
			hilos[indice - 1].start();
		}
		System.out.println("Hilos generados");
	}

	@Override
	public void run() {

	}
}
