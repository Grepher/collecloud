package com.jargelo.dbz;

public class Saiyan {
	boolean tail = true;
	boolean tailInmunity;
	boolean ozaruControl;
	boolean pureHeart;
	long ki;
	long speed;
	int transformation;
	
	public String getTransformation() {
		String transformationAcronym = "";
		switch(transformation){
			case 0:
				transformationAcronym =  "SJ";
			break;
			case 1:
				transformationAcronym =  "SSJ1";
			break;
			case 2:
				transformationAcronym =  "SSJ2";
			break;
			case 3:
				transformationAcronym =  "SSJ3";
			break;
			case 4:
				transformationAcronym =  "SSJ4";
			break;
			case 5:
				transformationAcronym =  "SSJG";
			break;
			case 6:
				transformationAcronym =  "SSJGSSJ";
			break;
		}
		return transformationAcronym;
	}
	
	public void zenkai() {
		
	}
	
	public void ozaruTransformation() {
		if (tail == true) {
			ki = ki * 10;
		}
	}
	
	public void superSaiyanTransformation() {
		if (transformation < 1) {
			ki = ki * 50;
			speed = speed * 50;
		}
		transformation = 1;
	}
	
	public void superSaiyan2Transformation() {
		if (transformation < 2){
			if (transformation == 0) {
				ki = ki * 100;
				speed = speed * 100;
			} else {
				ki = ki * 2;
				speed = speed * 2;
			}
		}
		transformation = 2;
	}
	
	public void superSaiyan3Transformation() {
		if (transformation < 3){
			if (transformation == 0) {
				ki = ki * 400;
				speed = speed * 400;
			} else if (transformation == 1) {
				ki = ki * 8;
				speed = speed * 8;
			} else {
				ki = ki * 4;
				speed = speed * 4;
			}
		}
		transformation = 3;
	}
	
	public void superSaiyan4Transformation() {
		if (transformation < 4 && tail && ozaruControl){
			if (transformation == 0) {
				ki = ki * 2400;
				speed = speed * 2400;
			} else if (transformation == 1) {
				ki = ki * 48;
				speed = speed * 48;
			} else if (transformation == 2) {
				ki = ki * 24;
				speed = speed * 24;
			} else {
				ki = ki * 6;
				speed = speed * 6;
			}
		}
		transformation = 4;
	}
	
	public void superSaiyanGodTransformation() {
		if (transformation < 4 && pureHeart){
			if (transformation == 0) {
				ki = ki * 7200;
				speed = speed * 7200;
			} else if (transformation == 1) {
				ki = ki * 144;
				speed = speed * 144;
			} else if (transformation == 2) {
				ki = ki * 72;
				speed = speed * 72;
			} else if (transformation == 3) {
				ki = ki * 18;
				speed = speed * 18;
			} else {
				ki = ki * 3;
				speed = speed * 3;
			}
		}
		transformation = 5;
	}
	
	public void superSaiyanGodSuperSaiyanTransformation() {
		if (transformation < 4 && pureHeart){
			if (transformation == 0) {
				ki = ki * 7200;
				speed = speed * 7200;
			} else if (transformation == 1) {
				ki = ki * 144;
				speed = speed * 144;
			} else if (transformation == 2) {
				ki = ki * 72;
				speed = speed * 72;
			} else if (transformation == 3) {
				ki = ki * 18;
				speed = speed * 18;
			} else if (transformation == 4) {
				ki = ki * 3;
				speed = speed * 3;
			} else {
				ki = ki * 1;
				speed = speed * 1;
			}
		}
		transformation = 5;
	}
	
}
