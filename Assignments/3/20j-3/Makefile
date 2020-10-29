MAIN_JAVA=Program3
JAVA1=IntegerSet

#RUN THE PROGRAM
$(MAIN_JAVA): $(JAVA1).class $(MAIN_JAVA).class 
	java $(MAIN_JAVA)

#PROGRAM DEPENDENCIES
$(MAIN_JAVA).class:
	javac $(MAIN_JAVA).java

$(JAVA1).class:
	javac $(JAVA1).java

clean:
	rm *.class
clear:
	clear

#CUSTOM MAKEFILE FUNCTIONS 
rerun: clear clean $(MAIN_JAVA).class $(JAVA1).class $(MAIN_JAVA)
