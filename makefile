#
# define compiler and compiler flag variables
#

default:
	javac -d bin/ -cp src src/Minesweeper/Main.java

run:
	java -cp bin Minesweeper.Main 

clean:
	$(RM) bin/Minesweeper/*.class
#javac -d bin/ -cp src/Minesweeper/*.java

#java -cp bin Minesweeper.Main 

