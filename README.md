# Minesweeper


### Autor

Juan Pablo Calad Henao


### Running

You must have Java JDK 8 and we going to use make for build and run the project

## Install build-essential to run make commands
 > User$ sudo apt-get install build-essential

Now use the make commands. The `makefile` can takes 3 types of parameters:

- **without parameter**: the project is going to be compiled.
- **run**: once compiled you are able to run the project.
- **jtest**: once compiled you are able to run the test.
- **clean**: the project is going to be cleaned.

Example:

```
User$ make jtest
JUnit version 4.12
.....
Time: 0.005

OK (5 tests)

``` 
