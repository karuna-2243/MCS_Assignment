using System;

class DigitSumCalculator
{
    public static void Run()
    {
        Console.Write("Enter an integer: ");
        string input = Console.ReadLine();

        // Check if input is a valid number
        if (!int.TryParse(input, out int number))
        {
            Console.WriteLine("Invalid input! Please enter a valid integer.");
            return;
        }

        int sum = 0;

        // Sum each digit
        foreach (char digit in input)
        {
            sum += digit - '0'; // Convert char to int
        }

        Console.WriteLine($"Sum of digits: {sum}");
    }
}
