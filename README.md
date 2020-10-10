# jBackLibrary
 It is a Java library to help us manage requests with the MySql database, in addition to some functions to improve the interface of Swing applications.

 
 **This README it's currenty incomplete**

## Features

- Requests whit MySql database.
- Call up reports made with the JasperReports library [*It is required to have the JasperReports libraries in the project*].
- Obtain the value of a whole number in the form of words. [*Useful when working with invoices and tickets*].
- Select and assign an image to a jLabel.
- Open PDF documents [*With the default application for these documents.*].
- Perform validations to input text fields.
- Assign small styles to components such as Tables, Lists.
- And more.

## Note

This library can be used for any purpose, personal projects, educational projects, and more.
Under the rules established by the GNU LGPL license.
Anyone who wants to make improvements to the library is welcome.

####  Download

Download the last version [JAR here]([jBack v0.1.zip](https://github.com/cpaucarc/jBackLibrary/files/5358396/jBack.v0.1.zip). 

## How to use?
**Table of Contents**

[TOCM]

[TOC]

### Working whit MYSQL database
```sql
SELECT * FROM country;
```

![image](https://user-images.githubusercontent.com/52868996/95621423-44484c80-0a37-11eb-8a96-7d7df6b69fe7.png)

> Database example called '*testdatabase'* whit a table *'country'* 

####  Creating the general controller
In a new Java class, we are going to create the general controller (in this case called `GeneralConnection`, but it can be called in any other way) with the data of the connection to the database.

This data can be in an external `.properties` file, and get it from our `GeneralConnection` class.

```java
import Database.Controller;

public class GeneralConecction {
    static Controller con;
	//Example database
    static String user = "root";
    static String psw = "1234";
    static String db = "testdatabase";
    static String host = "localhost";
        
    public static Controller getControl(){
        con = new Controller(user, psw, db, host);
		return con;
    }
}
```
#### Create an instance for use in any Class

When creating a new class, if we want to make queries to the database, we only have to create an instance of our Controller:


    Controller control = GeneralConecction.getControl();

#### Available methods
- ##### getData(String sql, int position)

Get a specific data, from a SQL query and a specific position.

```java
/* This method return a String  */
control.getData("SELECT * FROM country WHERE id = 1;", 2);
// Peru
```
- ##### getColumnData(String sql) o getData(String sql)

Returns the data of a column, by default it is the first column, so it is important to specify which column we want within the query.
```java
String[] countries = control.getColumnData("SELECT country_name FROM country;");
for (String country : countries){
	System.out.println(country);
 }
	// Peru
	// USA
	// Uruguay
	// Brazil
```
- ##### getRowData ()

Returns a specified amount of data from a single row.
```java
String[] countries = control.getRowData("SELECT * FROM country;", 3);        
for (String country : countries){
	System.out.println(country);
}
	// 1
	// Peru
	// 31.99
```

- ##### executeQuery(String sql)

Execute an SQL query, for example `INSERT`, `DELETE` and more.
It is a `void` function.
```java
control.executeQuery("INSERT INTO country VALUES (null, 'France', 66.99, 'French')");
```
- ##### existInDB(String sql)
Check if there is any arbitrary data registered in the database.
It is a `boolean` function.

```java
control.existInDB("SELECT * FROM country WHERE country_name = 'Peru'");
	// true
```
### Working whit UI Swing
#### Available Methods
- ###### Tables
![image](https://user-images.githubusercontent.com/52868996/95644533-e63e5800-0a7c-11eb-9288-806babcaf595.png)
> Example of UI change in tables

 ###### How to use?

```java
TableModel model = new TableModel();
Controller control = GeneralConecction.getControl();
String[] header = new String[]{"Id", "Country", "Population in Million", "Language"};

public NewJFrame() throws SQLException {

	Tables.setModel(jTable1, model, header);
	Tables.setModel(jTable2, model, header);
	Tables.setModel(jTable3, model, header);
	Tables.setModel(jTable4, model, header);

	control.fillTable(model, "SELECT * FROM country", 4);
	
	// Implementation of methods
	Tables.Light(jTable2);
	Tables.Dark(jTable3);
	Tables.TableCustom(jTable4,  new Color(73, 35, 120), new Color(255,255,255), new Color(156, 74, 255), new Color(255,255,255), 30, true);
}
```

### Working whit Java Components
### Working whit files
### Working whit other features

