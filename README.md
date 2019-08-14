# OCP8_II

## Chapter One
### Instance of
Check if the class is a type direct or indirect
Ex: 
Animal animal = new Cat(); 
animal instaceOf Cat -  it's true 
animal instanceOf Dog - it's false - even if Dog extends or implements Animal, it isn't referenced

### Overwrite and Overload
#### Overwrite
- Methods with same name and parameter's number
- Return with variants - can return child class
- Can throws more specific exceptions
- access modifiers must be more embracing than its super class, can be default case the inteface into the class

#### Overload
- Can change the number of parameters
- Can change the return type
- Can throws any exception
- The access modifier can be changed to whatever you want

### Inner Classes
#### Nested Class Member
- It is defined within another class
- The one is not static is called INNER CLASS
- It is defined  at the same leval as instance variables, it should not static
- Can has any access modifier
- Can extend any classes and implements interfaces
- Can be abstract or final
  Can be access members of the outer class including PRIVATE members
- Accessing values from inner class you should call this way InnerClassExample.this.weight
- In the class can has private interface and referenced for any inner classes
- For instantiating use the 'new' clause: innerClasseOne.new InnerClasseTwo();

#### Nested Class Static
- It can use any access modifier
- The enclosing class can refer to the fields an methods of the static nested class.
- To import the static inner class is neeeded to use import static
- Can be instantiate without the enclosing class declaration.

#### Nested Class Local
- They don't have an access modifier
- Can't be static or to have any static methods or variables
- Can have access to all field and methods of the enclosing class
- They don't have access to local variables of a method unless those variables are final or effectively final

#### Nested Classe Anonymous
- Pay attention when extends a class or implements an interface
- in both cases is used new operator when it is instantiate
- Can't implements and extends in the same time.
- it can be pass as parameter as well when there is only method there

## Chapter Two and Four - Designer Principals and Functional Programming
 1. Encapsulating - Set the variable as private access modifier
 2. Java Bean - Get and Set for instance variables
 
 ### Polimorfism
 When the instance can reference itself or other instance
 Super class can receive child, but the instance can call only methods that the super class has
 Child can receive an instance from super, but is necessary do the cast, but in run time throws a ClassCastException
 Because the super class doesn't have child methods, it's does't fill
 
 ### Functional Interface
- It must have only an abstract method
- The annotation is not required
- they are used in the lambda expressions in functional programming

## Chapter Three
### Comparable
- Interface
- The classes must implement it
- Must implements the method int compareTo

### Comparator
- it is a funcional interface
- method int compare(T1, T2);
- can create custom comparator with multi field

Multi field comparing
Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());
c = c.thenComparingInt(s -> s.getWeight());
return c.compare(s1, s2);
