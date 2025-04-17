using System;

class ShuffleFirstLast
{
    public static void Run()
    {
        Console.Write("Enter a string: ");
        string input = Console.ReadLine();

        if (string.IsNullOrEmpty(input) || input.Length < 2)
        {
            Console.WriteLine("String is too short to shuffle!");
            return;
        }
        char firstChar = input[0];
        char lastChar = input[input.Length - 1];

        string shuffledString = lastChar + input.Substring(1, input.Length - 2) + firstChar;

        Console.WriteLine($"Shuffled String: {shuffledString}");
    }
}
