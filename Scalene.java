import static java.lang.Math.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
public final class Scalene extends Triangle
{
private int rotateValue = 0;
  private double side1, side2, side3;


  public void setVertices()
  {
    // System.out.println("setVertices");
    if (!hasVertices)
    {
    double alpha = Math.acos(((side * side) + (side2 * side2) - (side3 * side3)) / (2 * side * side2));
    // System.out.println(alpha);
    // System.out.println(side);
    // System.out.println(side2);
    // System.out.println(side3);

    double X = side * Math.cos(alpha);
    double height = side * Math.sin(alpha);

    doubleVertexX[0] = (int) (centerX - (side2 / 2 - X));
    doubleVertexX[1] = (int) (centerX - (side2 / 2));
    doubleVertexX[2] = (int) (centerX + (side2 / 2));
    doubleVertexY[0] = (int) (centerY - height / 2);
    doubleVertexY[1] = (int) (centerY + height / 2);
    doubleVertexY[2] = (int) (centerY + height / 2);
    }
    for (int i = 0; i < 3; i++)
    {
      vertexX[i] = (int) (doubleVertexX[i] + .5);
      vertexY[i] = (int) (doubleVertexY[i] + .5);
    }
    hasVertices = false;
    polygon = new Polygon(vertexX, vertexY, 3);
  }

  public void paintComponent (Graphics2D g2)
	{

    g2.setPaint(Color.BLACK);
    g2.drawOval(centerX - 1, centerY - 1, 2, 2);

    g2.setPaint(color);
		g2.drawPolygon(vertexX, vertexY, 3);
    g2.fillPolygon(vertexX, vertexY, 3);
    if (this.isSelected)
    {
      g2.setPaint(Color.WHITE);
      g2.drawPolygon(vertexX, vertexY, 3) ;
      g2.setPaint(color);
    }

}

  public Scalene (int S1, int S2, int S3, int X, int Y, Color C)
  {
    side = S1;
    side2 = S2;
    side3 = S3;
    centerX = X;
    centerY = Y;
    color = C;
    numVertices = 3;
  }

  public Scalene()
  {
  }
  public Scalene(Scalene S)
  {
    side1 = S.side1;
    side2 = S.side2;
    side3 = S.side3;
  }
  public Scalene(double S1, double S2, double S3)
  {
    side1 = S1;
    side2 = S2;
    side3 = S3;
  }
  public void setSide1(double S1)
  {
    side1 = S1;
  }
  public void setSide2(double S2)
  {
    side2 = S2;
  }
  public void setSide3(double S3)
  {
    side3 = S3;
  }
  public double getSide1()
  {
    return side1;
  }
  public double getSide2()
  {
    return side2;
  }
  public double getSide3()
  {
    return side3;
  }
  public double perimeter()
  {
    return side1 + side2 + side3;
  }
  public double area()
  {
    double s = (side1 + side2 + side3) / 2.0;
    return Math.sqrt(((s - side1) * (s - side2) * (s - side3)) * s);
  }
  public String getName()
  {
    return "Scalene";
  }
  public void fromString (String str)
	{
		String [] parts = str.split (" ");
		try
		{
			centerX = Integer.parseInt(parts[0]);
			centerY = Integer.parseInt(parts[1]);
			if (Integer.parseInt(parts[2]) > 0)
			{
        side = Integer.parseInt(parts[2]);
        side2 = Integer.parseInt(parts[3]);
        side3 = Integer.parseInt(parts[4]);
				color = new Color(Integer.parseInt(parts[5]));
			}
			else
			{
				color = new Color(Integer.parseInt(parts[2]));
				numVertices = Integer.parseInt(parts[3]);
				for (int i = 0; i < numVertices; i++)
				{
					doubleVertexX[i] = Double.parseDouble(parts[4 + (2 * i)]);
					doubleVertexY[i] = Double.parseDouble(parts[5 + (2 * i)]);
          System.out.println(doubleVertexX[i] + " " + doubleVertexY[i]);
				}
				hasVertices = true;
			}
			setVertices();
		}
		catch (NumberFormatException e)
		{
			//System.out.println ("Numeric input error");
		}
	}
	public String toString ()
	{
		String string = new String ();
		string += centerX + " ";
		string += centerY + " ";
		string += color.getRGB() + " ";
		string += numVertices + " ";
		for (int i = 0; i < 3; i++)
		{
			string += doubleVertexX[i] + " ";
			string += doubleVertexY[i] + " ";
		}
    double tempSide;

    tempSide = Math.sqrt(Math.pow(vertexX[1] - vertexX[0], 2) + Math.pow(vertexY[1] - vertexY[0], 2));
    System.out.println(tempSide);
    tempSide = Math.sqrt(Math.pow(vertexX[2] - vertexX[1], 2) + Math.pow(vertexY[2] - vertexY[1], 2));
    System.out.println(tempSide);
    tempSide = Math.sqrt(Math.pow(vertexX[0] - vertexX[2], 2) + Math.pow(vertexY[0] - vertexY[2], 2));
    System.out.println(tempSide);
    return string;
  }

}
