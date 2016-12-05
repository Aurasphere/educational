# Java String Pool Demo
Program that shows the underlying working of the Java String Pool.
		
##Premise:
The operator "==" makes a comparison between primitives variable contents. 
Non-primitive types variables(Strings and Objects) contains references to that Object/String.
This implies that the comparison will be made on the reference itself and not on the content.

On the other hand, the "equals()" method makes a comparison between the real variable content, whether it is a primitive type, a String or an Object.

##String interning
Before instantiating a new String, the JVM checks that this isn't already on the String pool, a memory area used for storing them.
If the String is not there, a new String is created and a new reference to the String is returned. If the String is already there, the already existing reference will be returned.
