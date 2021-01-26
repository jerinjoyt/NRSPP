
public class Function_As_Data {

	protected static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

	}

	protected static class DataLoader {
		public final No_Arg_Interface<Person> load;

		public DataLoader(Boolean isDevelopment) {
			this.load = isDevelopment ? this::LoadFakePerson : this::LoadRealPerson;
		}

		private Person LoadRealPerson() {
			System.out.println("Loading person from server...");
			return new Person("Real Person", 30);
		}

		private Person LoadFakePerson() {
			System.out.println("Loading fake person...");
			return new Person("Fake", 25);
		}
	}

	public static void main(String[] args) {
		final Boolean devStatus = true;

		DataLoader dl = new DataLoader(devStatus);
		System.out.println(dl.load.apply());
	}

}

/*
 * So now that we've spent a good bit of time learning about Java's function
 * interfaces and how they allow us to assign functions to variables. Let's take
 * a look at a few things that just the simple shift in mindset alone allows us
 * to do. One thing that functional interfaces allow us to do is assign the
 * definition of a function dynamically at runtime. So to illustrate this let's
 * think about a real world example. Let's say that we're writing a program that
 * loads data from a server, let's say that it loads data about a person or
 * something like that. The only problem is that this process takes a long time
 * and during development or while running tests, it can really slow us down to
 * have to wait for our program to load this data every time. The good news is
 * that using the concept of functions as data that we've been learning about in
 * the past few videos. We can dynamically change the definition of the function
 * that loads our data based on the environment it's running in. And here's how.
 * 
 * So first let's define the classes we're going to use for this example. Let's
 * create a Person class, we'll just say protected class Person. And we're going
 * to give this Person a name property and we'll give them an age property as
 * well. And then we're just going to create a constructor public Person that
 * takes the name and age. (keyboard chuckling) And sets those member variables
 * for us. (keyboard chuckling) So that's really straightforward. Next let's
 * create a new class called DataLoader. So we'll say protected class
 * DataLoader. This would be the class that actually loads our data from the
 * server, if this were a real app. And what we're going to do for this example
 * is this class is going to have two private methods. The first one is going to
 * be called LoadPersonReal(). So it's going to say private person
 * LoadPersonReal(). And the second one is going to be a private method called
 * LoadPersonFake(). Now here's the deal with these two private methods.
 * LoadPersonReal() is going to contain the real logic for loading the person
 * from the server. And just for the sake of example here, we're going to have
 * this method just print out something here. So we'll say system.out.println()
 * And we'll just have it say something like loading person and we'll have it
 * return a new person. We'll just set their name as real person and their age
 * can be whatever we want it to be. This is just an example. And obviously, if
 * this were a real application this would contain some real loading logic. But
 * for now, this will do nicely. So that's LoadPersonReal(). The
 * LoadPersonFake() method is going to look like this. We're just going to have
 * it print out something here. (keyboard chuckling) We'll have it say something
 * like returning fake person object. (keyboard chuckling) And then we'll have
 * it return a new person with the name fake person, and the age can be whatever
 * we want it to be as well. So now that we have these two different methods one
 * which really loads data from the server. We'll want to call this method when
 * our app is running in production. And one which cuts out the time intensive
 * loading logic and just return to some fake data. We'll want to call this
 * method when our app is running in development. But here's the thing. We don't
 * want any of our code outside this data loader class to have to know about
 * these methods or worry about choosing between them. So here's what we can do.
 * We're going to create a public final member variable of our data loader class
 * that will choose which of these private methods to expose to the outside
 * world. Now since both of these methods here are functions that don't take any
 * arguments and return a person object, the type of this public final variable
 * is going to be the NoArgFunction interface we created previously. So we're
 * going to say NoArgFunction and it'll return a person. And we'll just call
 * this member variable loadPerson, like that. (keyboard chuckling) And now that
 * we've done that, here's where this whole idea of being able to treat
 * functions the same way as any other variable type comes in. Let's create a
 * constructor for our DataLoader class. So we'll say public DataLoader. And
 * this constructor is going to take a single argument that will tell it whether
 * or not our program is in development or in production mode. So this'll be a
 * Boolean and we'll call it isDevelopment. And now what we can do is inside
 * this constructor we can use this isDevelopment argument to choose between
 * whether this loadPerson here should be the real or fake loadPerson method. So
 * here's what that's going to look like. We're going to say this. loadPerson =
 * isDevelopment and we're going to use a ternary operator here. So if our app
 * is in development mode- (keyboard chuckling) We're going to set
 * isDevelopment= this::LoadPersonFake(). So that's the LoadPersonFake() method
 * that we defined down here. And if it's not in development mode, we're going
 * to set it to this::LoadPersonReal, which is the real method for loading
 * people from the server. And again, this double colon thing here is just how
 * we refer to an object or classes method as an object of type function,
 * instead of just using a dot like when we want to call the function. Okay, so
 * here comes the fun part. We can actually use this DataLoader class like this.
 * So inside our main method here, what we're going to do is we're going to say
 * final Boolean isDevelopment = true. And then we're going to create a new
 * DataLoader object. So DataLoader dataLoader = new DataLoader and we're going
 * to pass this isDevelopment, and we're going to pass this isDevelopment
 * constant to DataLoader as an argument. And just because of the way this
 * example is set up, we're going to have to make these both static classes.
 * (keyboard chuckling) And now what we can do is we can say system.out.println
 * and say dataLoader.loadPerson.apply. And if we run our code now we should see
 * that since our isDevelopment variable here is true. I t prints out returning
 * fake person object and well this thing here, isn't very helpful, but you get
 * the point. That's the fake person object that we're returning here. And if we
 * change this to false and run our program again. We'll see that it'll print
 * out loading person, which means that LoadPersonReal() is now being called
 * instead of LoadPersonFake(). So anyway, what we've just seen here is made
 * possible by the fact that in functional programming we're allowed to work
 * with functions in a very similar way to any other data type. Which is
 * basically what we did here inside the constructor of our DataLoader class. We
 * worked with functions just the same as any other data type in Java.
 */
