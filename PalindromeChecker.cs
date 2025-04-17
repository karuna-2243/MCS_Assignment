using System;

class PalindromeChecker
{

    public static bool IsPalindromeRecursive(string str, int left, int right)
    {
        if (left >= right)
            return true; 

        if (str[left] != str[right])
            return false; 

        return IsPalindromeRecursive(str, left + 1, right - 1);
    }

    public static bool IsPalindromeIterative(string str)
    {
        int left = 0, right = str.Length - 1;
        while (left < right)
        {
            if (str[left] != str[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void Run()
    {
        Console.Write("Enter a number: ");
        string input = Console.ReadLine();

        if (!int.TryParse(input, out _))
        {
            Console.WriteLine("Invalid input! Please enter a valid number.");
            return;
        }

        bool isPalindromeRec = IsPalindromeRecursive(input, 0, input.Length - 1);
        Console.WriteLine($"Using Recursion: {input} is " + (isPalindromeRec ? "a Palindrome" : "not a Palindrome"));

        bool isPalindromeIter = IsPalindromeIterative(input);
        Console.WriteLine($"Using Iteration: {input} is " + (isPalindromeIter ? "a Palindrome" : "not a Palindrome"));
    }
}
