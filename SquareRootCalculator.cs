using System;

class SquareRootCalculator
{
    public static void Run()
    {
        try
        {
            Console.Write("Enter a number: ");
            double number = Convert.ToDouble(Console.ReadLine());

            if (number < 0)
            {
                throw new ArgumentException("Cannot calculate the square root of a negative number.");
            }

            double sqrtValue = Math.Sqrt(number);
            Console.WriteLine($"Square root of {number} is: {sqrtValue}");
        }
        catch (FormatException)
        {
            Console.WriteLine("Invalid input! Please enter a valid numeric value.");
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
        catch (Exception)
        {
            Console.WriteLine("An unexpected error occurred.");
        }
    }
}
