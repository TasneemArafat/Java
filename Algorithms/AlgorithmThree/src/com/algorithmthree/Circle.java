package com.algorithmthree;
public class Circle extends GeometricObject{
	private double radius;
	
	public Circle() {
		
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(double radius,String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.pow(radius,2)*Math.PI;
	}
	
	public double getPerimeter() {
		return Math.PI*2*radius;
	}
	
	public double getDiameter() {
		return 2*radius;
	}
	
	public void printCircle() {
		System.out.println("Radius = "+getRadius()+" Area = "+getArea()+" Perimeter = "+getPerimeter()+" Diameter = "+ getDiameter());
	}
	
}
