
public class JavaStringPoolDemo {

	public static void main(String[] args) {
	
		String hello = "Hello World!";
		String hello2 = "Hello World!";
		String helloObject = new String("Hello World!");
		StringBuilder helloStringBuilder = new StringBuilder("Hello World!");
		StringBuilder helloStringBuilder2 = helloStringBuilder;

		System.out.println("String 'hello': " + hello);
		System.out.println("String 'hello2': " + hello2);

		// Even if the Strings hello and hello2 have been declared apart 
    // from each other, they will share the same reference and thus
    // this will yield true.
		System.out.println("hello == hello2 : " + (hello == hello2));

		// They also share the same content so this will be true as well.
		System.out.println("hello.equals(hello2) : "
				+ hello.equals(hello2) + "\n");

		System.out.println("String 'hello': " + hello);
		System.out.println("String object 'helloObject': " + helloObject);

		// A String created as a new Object will always have a new reference,
    // so this will be false.
		System.out.println("hello == helloObject : "
				+ (hello == helloObject));

		// But it still has the same content, so this is true.
		System.out.println("hello.equals(helloObject) : "
				+ hello.equals(helloObject) + "\n");

		// A String is immutable, thus changing it...
		hello = "Hi World!";

		System.out.println("Modified hello String");
		System.out.println("String 'hello': " + hello);
		System.out.println("String 'hello2': " + hello2);

		// ...it will be created a new String with a new reference,
    // different from the previous one, so this will yield false.
		System.out.println("hello == hello2 : " + (hello == hello2));

		// And obviously in this case the content will be different as well,
    // so this is false too.
		System.out.println("hello.equals(hello2) : "
				+ hello.equals(hello2) + "\n");

		// A String can be used as a mutable object (and thus modified)
    // using the StringBuilder class.
		System.out.println("StringBuilder 'helloStringBuilder': "
				+ helloStringBuilder);
		System.out.println("StringBuilder 'helloStringBuilder2': "
				+ helloStringBuilder2);

		// The two objects helloStringBuilder and helloStringBuilder2 share
		// the same reference, so this is true.
		System.out
				.println("helloStringBuilder == helloStringBuilder2 : "
						+ (helloStringBuilder == helloStringBuilder2));

		// This is true as well since the content is also the same.
		System.out
				.println("helloStringBuilder.equals(helloStringBuilder2) : "
						+ (helloStringBuilder.equals(helloStringBuilder2))
						+ "\n");

		// Changing helloStringBuilder's content we are now modifying
		// not the reference anymore but the String itself...
		helloStringBuilder2.replace(0, helloStringBuilder.length(),
				"Hi World!");

		System.out.println("Modified helloStringBuilder2");
		System.out.println("StringBuilder 'helloStringBuilder': "
				+ helloStringBuilder);
		System.out.println("StringBuilder 'helloStringBuilder2': "
				+ helloStringBuilder2);

		// ...and, as a consequence of this, the two StringBuilder
    // objects will still share the same reference and thus
    // this will be true.
		System.out
				.println("helloStringBuilder == helloStringBuilder2 : "
						+ (helloStringBuilder == helloStringBuilder2));

		// They also have the same value and this will be true as well.
		System.out
				.println("helloStringBuilder.equals(helloStringBuilder2) : "
						+ (helloStringBuilder.equals(helloStringBuilder2)));

	}

}
