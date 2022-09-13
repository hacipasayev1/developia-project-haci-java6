package ders6.misal;

public class Book {
int id;
String name;
int price;
String author;
int pageCount;
String color;

Book(){
	this(56);
}
Book(int id){
	this(id,"xemse");
}
Book(int id,String name){
	this(id,name,"yasil");
}
Book(String author,int pageCount,String color){
	
}
}
