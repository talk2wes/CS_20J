# Wesley Johanson	Pengo: wjohanso		talk2wes@gmail.com
# Filename: Makefile
# Assignment 5: Cinco

MAIN_JAVA=Program6
JAVA1=List

#RUN THE PROGRAM
$(MAIN_JAVA): $(MAIN_JAVA).class $(JAVA1).class
	java $(MAIN_JAVA)

#PROGRAM DEPENDENCIES
$(MAIN_JAVA).class:
	javac $(MAIN_JAVA).java

$(JAVA1).class:
	javac $(JAVA1).java

run: $(MAIN_JAVA).class
	java $(MAIN_JAVA)

clean:
	rm *.class
clear:
	clear

#CUSTOM MAKEFILE FUNCTIONS 
rerun: clear clean $(MAIN_JAVA).class $(MAIN_JAVA)
