# Task

You have bunch of empty boxes. To store them efficiently you are planning to place them inside each other. Each box has three dimensions (h, w, l), assume that you can place box A inside box B if all of its dimensions are smaller, i.e., hA<hB, wA<wB, and lA<lB. (You don't like to rotate your boxes!) Write a function that

Takes a list of tuples as input, where each tuple describes the dimensions of a box. No two boxes have exactly the same size.
Returns the longest sequence of boxes that you can place inside of each other in a nested fashion.
Example

Input:

[(10,10,5),(1,1,1),(2,2,8),(9,5,3)]

Output:

[(10,10,5),(9,5,3),(1,1,1)]
