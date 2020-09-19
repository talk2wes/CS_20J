FILENAME=Message.java

$(FILENAME):
	javac $(FILENAME)

clean: *.class
	rm *.class

run: $(FILENAME)
	javac $(FILENAME)
	java $(FILENAME)

crun: $(FILENAME)
	clear
	javac $(FILENAME)
	java $(FILENAME)
	@rm *.class
