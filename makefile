SHAPES = Shape.class Quadrilateral.class Square.class Rectangle.class Triangle.class Equilateral.class Right.class Scalene.class Circle.class

all: Hmwk4a.class

clean:
	rm *.class

Hmwk4a.class: Hmwk4a.java Background.class ShapeIO.class $(SHAPES)
	javac Hmwk4a.java

Background.class: Background.java ShapeIO.java $(SHAPES)
	javac Background.java

ShapeIO.class: ShapeIO.java $(SHAPES)
	javac ShapeIO.java

Shape.class: Shape.java
	javac Shape.java

Quadrilateral.class: Quadrilateral.java Shape.class
	javac Quadrilateral.java

Square.class: Square.java Quadrilateral.class Shape.class
	javac Square.java

Rectangle.class: Rectangle.java Quadrilateral.class Shape.class
	javac Rectangle.java

Triangle.class: Triangle.java
	javac Triangle.java

Equilateral.class: Equilateral.java Shape.class Triangle.class
	javac Equilateral.java

Right.class: Right.java Shape.class Triangle.class
	javac Right.java

Scalene.class: Scalene.java Shape.class Triangle.class
	javac Scalene.java

Circle.class: Circle.java Shape.class
	javac Circle.java
