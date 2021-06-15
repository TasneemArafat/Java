package com.algorithmthree;

public class Rectangles extends GeometricObject{
	
private double width;
private double height;

//Constructor
public Rectangles () {
	
}

public Rectangles(double width, double height) {
	super();
	this.width = width;
	this.height = height;
}

public Rectangles(String color, boolean filled , double width, double height) {
	super(color, filled);
	this.width = width;
	this.height = height;
	// TODO Auto-generated constructor stub
}

public double getWidth() {
	return width;
}

public void setWidth(double width) {
	this.width = width;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getArea() {
	return (width*height);
}
public double getPerimeter() {
	return ((width+height)*2);
}
}
