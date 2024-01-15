ObjectContainers
Will submit the homework as a git commit, like last time. Please make sure you separate the homework code from the class exercises.

Requirements:

1. You need to store Persoane in a TreeSet. Define one comparator for age in reverse order. When used when creating the TreeSet, the comparator will sort the persons in the collection by age from highest to lowest.

Add Persons to the TreeSet; iterate through the treeset and print the name and the age;

2. You need to store some information about some persons: for one person, you need a list of his/her hobbies;

Define for Hobby a class that contains:

Name of hobby (String) – eq: cycling, swimming
Frequency (int) – how many times a week they practice it
List of Addresses where this hobby can be practiced (List<Adresa>)
Define an Address class that contains:

Street of this address (String)
Country in which the address exists (Country)
Define a Country class that contains:

Name of the country (String)
Code of the country (String)
You will use a HashMap

<Persoana, List<Hobby>>

NOTE: equals(), hashCode() from Person must be overriden.

Write a method that takes two argumets: <Persoana, List<Hobby>> and Person. The method will print the names of the hobbies and the countries where it can be practiced of the person passed as an argument, by looking for the hobbies of that person in the HashMap.

You can use the Person class defined previously or implement a new one.