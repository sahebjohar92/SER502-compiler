# SER502-Spring2018-Team23
System which are used to build compiler and runtime : Linux, Windows, MacOS

Tools Used:

    Eclipse, Antlr, Git.

How to Install:

  Follow the below steps to install:
    
    1. Unzip the project in a new folder.
    2. Open the project in Eclipse using Files >> Open Project From File System. Browser your project folder here.

Building the language:

  The language can be build by building the jar file. The same can be done by following steps:
    
    1. Right click on the root project folder.
    2. Under the Java Option, select Runnable JAR File option. Click Next.
    3. Select the directory in which you want to export the jar in Export Destination option. Click Finish.

Running the language:

  1. Run via Eclipse:
  
    a. To enter a custom code, navigate to the package 'data' and change the inputFile.race . Paste your code in this file that you want to run for the language. You can also select sample codes available in the same package.
    b. Under the default package, right click on Main.java and click Run.
    c. The intermediate code of the program can be obtained by navigating to the file "inputFile.intermediate" in 'data' package.
    d. The output of the program can be obtained by navigating to the file "inputFile.output" in 'data' package.
    
  2. Run via JAR:
  
    a. In the terminal, navigate to the directory where the race.jar is available.
    b. Create a file inputFile.race and paste the code that needs to be run. Note that the file should be in the same directory where the race.jar is present.
    c. Run the command: "java -jar race.jar inputFile.race".
    d. The intermediate code of the program can be obtained by navigating to the file "inputFile.intermediate" in same directory.
    e. The output of the program can be obtained by navigating to the file "inputFile.output" in same directory.
  
  
Terminal Commands to run the compiler:
  
     Run the command: "java -jar race.jar inputFile.race".
