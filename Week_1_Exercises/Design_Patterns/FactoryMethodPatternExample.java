/*
Exercise 2: Implementing the Factory Method Pattern
Scenario: 
You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named FactoryMethodPatternExample.
2.	Define Document Classes:
o	Create interfaces or abstract classes for different document types such as WordDocument, PdfDocument, and ExcelDocument.
3.	Create Concrete Document Classes:
o	Implement concrete classes for each document type that implements or extends the above interfaces or abstract classes.
4.	Implement the Factory Method:
o	Create an abstract class DocumentFactory with a method createDocument().
o	Create concrete factory classes for each document type that extends DocumentFactory and implements the createDocument() method.
5.	Test the Factory Method Implementation:
o	Create a test class to demonstrate the creation of different document types using the factory method.

*/

// Document.java
abstract class Document {
    private String name;

    public Document(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void open();
    public abstract void save();
    public abstract void close();
}

// WordDocument.java
class WordDocument extends Document {
    public WordDocument(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println("Opening Word document: " + getName());
    }

    @Override
    public void save() {
        System.out.println("Saving Word document: " + getName());
    }

    @Override
    public void close() {
        System.out.println("Closing Word document: " + getName());
    }
}

// PdfDocument.java
class PdfDocument extends Document {
    public PdfDocument(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println("Opening PDF document: " + getName());
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document: " + getName());
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document: " + getName());
    }
}

// ExcelDocument.java
 class ExcelDocument extends Document {
    public ExcelDocument(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println("Opening Excel document: " + getName());
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document: " + getName());
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document: " + getName());
    }
}

// DocumentFactory.java
abstract class DocumentFactory {
    public abstract Document createDocument(String name);
}

// WordDocumentFactory.java
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new WordDocument(name);
    }
}

// PdfDocumentFactory.java
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new PdfDocument(name);
    }
}

// ExcelDocumentFactory.java
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String name) {
        return new ExcelDocument(name);
    }
}
// DocumentFactoryTest.java
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument("Word Document");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument("PDF Document");
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument("Excel Document");
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}

