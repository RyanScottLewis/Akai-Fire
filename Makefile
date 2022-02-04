JAVA_MAIN           = us.rynet.akaifire.Main
JAVA_SOURCE_PATH    = src
JAVA_BUILD_PATH     = build
JAVA_CLASSES_PATH   = $(JAVA_BUILD_PATH)/classes
JAVA_SOURCES        = $(shell find $(JAVA_SOURCE_PATH) -name *.java)
JAVA_CLASSES        = $(JAVA_SOURCES:$(JAVA_SOURCE_PATH)/%.java=$(JAVA_CLASSES_PATH)/%.class)
JAVA_FLAGS          = -cp $(JAVA_SOURCE_PATH)/
JAVA_COMPILER_FLAGS = -d $(JAVA_CLASSES_PATH)/ -cp $(JAVA_SOURCE_PATH)/

.SUFFIXES: .java
.PHONY: all build run clean clobber

all: run

build: $(JAVA_CLASSES)

run: $(JAVA_CLASSES)
	java $(JAVA_FLAGS) $(JAVA_MAIN)

clean:
	rm -rf $(JAVA_CLASSES_PATH)

clobber:
	rm -rf $(JAVA_BUILD_PATH)

$(JAVA_CLASSES_PATH)/%.class: $(JAVA_SOURCE_PATH)/%.java $(JAVA_CLASSES_PATH)
	javac $(JAVA_COMPILER_FLAGS) $<

$(JAVA_CLASSES_PATH):
	mkdir -p $@
