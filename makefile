#
# define compiler 
#

default:
	javac -d bin/ -cp src src/Minesweeper/Main.java 
	javac -cp src:lib/junit.jar:lib/junit-4.12.jar -d test/ test/Minesweeper/MinesweeperTest.java 

run:
	java -cp bin Minesweeper.Main 

jtest:
	java -cp test:lib/junit.jar:lib/junit-4.12.jar:lib/hamcrest.jar org.junit.runner.JUnitCore Minesweeper.MinesweeperTest


clean:
	$(RM) bin/Minesweeper/*.class
	$(RM) test/Minesweeper/*.class

