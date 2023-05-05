# Tree-map
This is a Java program that counts the number of trees that are visible from at least one direction, given a 2D matrix of tree heights.

## Requirements
To run this program, you need to have the following:

- Java 8 or higher installed on your machine
- A text file containing the matrix of tree heights. The file should be named map.txt and should be located in the src/main/java directory.
## Usage
To run the program, simply execute the `main` method in the `Main` class. The program will read the matrix of tree heights from the map.txt file and output the number of visible trees.

## How it works
The program works by iterating over each cell in the matrix and checking if the tree in that cell is visible from at least one direction (left, right, up, or down). A tree is considered visible if there are no taller trees blocking its view in that direction.

The program uses four helper methods to check if a tree is visible from a particular direction:

- `isSeenFromLeftSide`: Checks if the tree is visible from the left side
- `isSeenFromRightSide`: Checks if the tree is visible from the right side
- `isSeenFromUp`: Checks if the tree is visible from the top
- `isSeenFromDown`: Checks if the tree is visible from the bottom
These helper methods use two additional helper methods to determine if a tree is visible horizontally or vertically:

- `isVisibleVertically`: Checks if the tree is visible in a vertical direction
- `isVisibleHorizontally`: Checks if the tree is visible in a horizontal direction
The program reads the matrix of tree heights from the map.txt file using the getArray method, which returns a 2D array of integers.

The program outputs the number of visible trees using the System.out.println method.

## Contributing
If you find a bug or have a suggestion for improvement, feel free to open an issue or submit a pull request.
