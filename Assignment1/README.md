# Assignment 1
There are 2 parts: **Integer Iterator** and **Fifteen Puzzle**.

## 1. Integer Iterator
**To do task:** Implement 3 classes from the Interface IntegerIterator under integeriterators package which are:

* [x] ArrayIterator

* [x] PrimeNumbersIterator

* [x] RangeIterator

**Side note:** The interface IntegerIterator is an extension of Iterator<Integer>

## 2. Fifteen Puzzle
**To do task:** Finalize method in FifteenPuzzle Class

* [x] public FifteenPuzzle(String fileName) throws IOException, BadBoardException

* [x] public void makeMove(int tile, int direction) throws IllegalMoveException

* [x] public boolean isSolved() 

* [x] public String toString()

## Test Cases Provided
For this assignment, there are 40 test files from Test01.java to Test40.java.

In order to run all the test files at once, you should utilize the sh file named **_run_all.sh_**, the instruction is described as follow:
1. Go to the location where run_all.sh is located, the directory structure format looks like this:
```
Assignment1/
   ├── board1.txt 
   ├── ...
   ├── run_all.sh
   ├── src/
   │   ├── integeriterators/
   │   │   ├── ArrayIterator.java
   │   │   ├── IntegerIterator.java
   │   │   └── ...
   │   ├── testcases/
   │   │   ├── Test01.java
   │   │   ├── Test02.java
   │   │   └── ...
   │   ├── fifteenpuzzle/
   │   │   └── FifteenPuzzle.java
 ```
2. Run the script:
`./run_all.sh`

## Test Cases 1st Attempts:
Cannot pass test 29:
```
Running test 29:
Test29 ERROR
```
**Reason:**

* When reading a bad board which looks like this:
```
 1  2  3  4
```
At first I _**didn't check**_ if the board _**has enough numbers of row**_ (which in this case is 4). After checking and fixed the constructor to include the BadBoardException for number of rows:
```
if(line == null) throw new BadBoardException("Incorrect number of rows");
```
I can pass the Test29!
