package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		String shapeType = in.next();
		int red = in.nextInt();
		int green = in.nextInt();
		int blue = in.nextInt();
		boolean filled = in.nextBoolean();
		double x = 0;
		double y = 0;
		double halfH = 0;
		double halfW = 0;
		double[] xArray = new double[3];
		double[] yArray = new double[3];
		int N = 0;
		if (shapeType.equals("rectangle") || shapeType.equals("ellipse")) {
			x  = in.nextDouble();
			y  = in.nextDouble();
			halfW  = in.nextDouble();
			halfH  = in.nextDouble();
		} else if (shapeType.equals("triangle")) {
			while (in.hasNext() == true) {
				xArray[N] = in.nextDouble();
				yArray[N] = in.nextDouble();
				N++;
			}
		}
		StdDraw.setPenColor(red, green, blue);
		if (filled == true) {
			if (shapeType.equals("rectangle")) {
				StdDraw.filledRectangle(x, y, halfW, halfH);
			} else if (shapeType.equals("ellipse")) {
				StdDraw.filledEllipse(x, y, halfW, halfH);
			} else if (shapeType.equals("triangle")) {
				StdDraw.filledPolygon(xArray, yArray);
			}
		} else if (filled == false) {
			if (shapeType.equals("rectangle")) {
				StdDraw.rectangle(x, y, halfW, halfH);
			} else if (shapeType.equals("ellipse")) {
				StdDraw.ellipse(x, y, halfW, halfH);
			} else if (shapeType.equals("triangle")) {
				StdDraw.polygon(xArray, yArray);
			}
		}
	}
}
