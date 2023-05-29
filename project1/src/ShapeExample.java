import java.util.Scanner;

public class ShapeExample 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Radius: ");
		int radius=scanner.nextInt();
        Shape circle = new Circle(radius);
        
        System.out.println("Enter Radius: ");
        int side1=scanner.nextInt();
        System.out.println("Enter Radius: ");
        int side2=scanner.nextInt();
        System.out.println("Enter Radius: ");
        int side3=scanner.nextInt();
        Shape triangle = new Triangle(side1, side2, side3);

        // Polymorphism - calling interface methods on different implementations
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Circle perimeter: " + circle.calculatePerimeter());

        System.out.println("Triangle area: " + triangle.calculateArea());
        System.out.println("Triangle perimeter: " + triangle.calculatePerimeter());
    }
}
