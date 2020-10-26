EXECUTABLE=Program3
FILE1=IntegerSet

$(EXECUTABLE): $(FILE1).class 
	java $(FILE1)

$(FILE1).class:
	javac $(FILE1).java

clean:
	rm *.class

run: $(FILE1).class 
	java $(FILE1)

rerun: clean $(FILE1).class 
	java $(FILE1)
