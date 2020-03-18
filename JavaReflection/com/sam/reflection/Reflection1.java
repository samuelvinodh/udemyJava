package com.sam.reflection;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection1 {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        System.out.println(personClass.getName());
        //Class person = null;
        Class<Person> person = null;
        try {
            //person = Class.forName("com.sam.reflection.Person");
            person = (Class<Person>) Class.forName("com.sam.reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(person.getName());
        System.out.println(person.getPackage());

        System.out.println(person.getSuperclass().getName());

        System.out.println("-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");

        /*Field[] fields = person.getFields();
        for(Field field: fields){
            System.out.println(field.getName()+ " - "+ field.getType());
        }*/

        Field[] fields = person.getDeclaredFields();
        for(Field field: fields){
            field.setAccessible(true);
            System.out.println(field.getName());
        }

        System.out.println("-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");

        /*Method[] methods = person.getMethods();
        for(Method method: methods){
            System.out.println(method.getName()+" return type"+method.getReturnType());
        }*/

        Method[] methods = person.getDeclaredMethods();
        for(Method method: methods){
            method.setAccessible(true);
            System.out.println(method.getName());
        }

        System.out.println("-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");

        Class[] interfaces = person.getInterfaces();
        for(Class c: interfaces){
            System.out.println(c.getName());
        }

        System.out.println("-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");

        Method[] methods1 = person.getMethods();
        for(Method method: methods1){
            if(method.isAnnotationPresent(MyAnnotation.class)){
                System.out.println(method.getName());
            }
        }

    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation{
    public String name();
}

class Employee{

}

class Person extends Employee implements Comparable<Person>, Serializable{
    private String name;
    private int age;
    //Only public fields will be returned in reflection
    //public String name;
    //public int age;

    /*private String returnName(){
        return "My name is: "+this.getName();
    }*/

    @MyAnnotation(name="MyAnnotation")
    public String returnName(){
        return "My name is: "+this.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return (this.getName()==o.getName() && this.getAge()==o.getAge())? 0 : 1;
    }
}
