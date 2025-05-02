/*******************************Offline 2****************************************/

#include<iostream>
#include<cstring>
#include<cmath>
#include "Book.cpp"

using namespace std;

class BookShop
{
    char name[100];
    Book* books; //List of books in the shop
    int size;  //maximum number of books the shop can keep
    int count; //tracks currently how many numbers in the shop
public:
    void setName(char* name)
    {
        /*The name of the bookshop to the given name*/
        strcpy(this->name,name);
    }

    BookShop() //Default constructor
    {
        /*Initialized with size 5 and name to empty string ""*/
        strcpy(name,"");
        size=5;
        count=0;
        books=new Book[size];
    }

    BookShop(char* name, int size) //Parameterized constructor
    {
        /*Initialized with the given name and size*/
        strcpy(this->name,name);
        this->size=size;
        count=0;
        books=new Book[size];
    }

    BookShop(const BookShop& bs) //Copy constructor
    {

        strcpy(this->name,bs.name);
        this->size=bs.size;
        count=0;
        books=new Book[size];

        for(count; count<size; count++)
            books[count]=bs.books[count];

    }

    ~BookShop() //Destructor
    {
        delete [] books;
    }

    void addBook(Book b)
    {
        /*Adding book b to the end of the list*/
        books[count]=b;
        count++;

    }

    void addBook(Book* ba, int count)
    {
        /*Adding the given array of books ba to the end of the list*/
        int i;
        for(i=0; i<count; i++)
        {
            if(ba[i].getISBN()>0)
            {
                books[this->count]=ba[i];
                this->count++;
            }
        }

    }

    Book getBookInfo(char* title)
    {
        //Returning the **first** book that has the given title. Assumung there is atleast one book in the list with the given title
        for(int i=0; i<size; i++)
        {
            if(strcmpi(books[i].getTitle(),title)==0)
                return books[i];
        }
    }
    void updateBookPrice(int isbn, int price)
    {
        /*Updating the price of the book with given isbn to the given price*/
        for(int i=0; i<size; i++)
        {
            if(books[i].getISBN()==isbn)
                books[i].setPrice(price);
        }
    }

    void removeBook(int isbn)
    {
        /*Removing the book with the given isbn from the list. After removing a book all the books below the removed book is shifted up*/
        for(int i=0; i<size; i++)
        {
            if(books[i].getISBN()==isbn)
            {
                for(int j=i; j<size-1; j++)
                {
                    books[j]=books[j+1];
                }
                books[size-1].setISBN(0);
                books[size-1].setTitle("");
                books[size-1].setPrice(0);
                count--;
            }

        }
    }
    int totalPrice()
    {
        /*Returning the sum of the prices of all the books in the list*/
        int sum=0;
        for(int i=0; i<count; i++)
            sum+=books[i].getPrice();

        return sum;
    }

    void print()
    {
        /*Printing the bookshop's name followed by information of all the books in the bookshop*/

        cout<<"Bookshop Name: "<<name<<endl;
        for(int i=0; i<count; i++)
            books[i].print();
    }

    BookShop mergeShop(BookShop b)
    {
        // Returning a new bookshop object that will contain all the books of this bookshop and the given bookshop b// Useing the title **MergedShop** of the new bookshop
        int s=this->count+b.count;
        BookShop n("Mergeshop",s);
        n.addBook(this->books,this->count);
        n.addBook(b.books,b.count);

        return n;
    }
};

int main()
{

    BookShop bs1;
    bs1.setName("Boimela");
    Book b1(101,"Teach Yourself C++",100);
    Book b2(102,"Teach Yourself C",200);
    Book b3(103,"Java For Dummies",300);
    bs1.addBook(b1);
    bs1.addBook(b2);
    bs1.addBook(b3);
    bs1.print(); /*Output:
					Bookshop Name: Boimela
					ISBN: 101, Title: Teach Yourself C++, Price: 100
					ISBN: 102, Title: Teach Yourself C, Price: 200
					ISBN: 103, Title: Java For Dummies, Price: 300
				 */
    cout<<endl;
    cout<<"Total price of books: "<<bs1.totalPrice()<<endl;	/*Output:
															   Total price of books: 600
															*/

    cout<<endl;
    bs1.removeBook(102);
    bs1.print(); /*Output:
					Bookshop Name: Boimela
					ISBN: 101, Title: Teach Yourself C++, Price: 100
					ISBN: 103, Title: Java For Dummies, Price: 300
				 */

    cout<<endl;
    bs1.updateBookPrice(101,500);
    bs1.print(); /*Output:
					Bookshop Name: Boimela
					ISBN: 101, Title: Teach Yourself C++, Price: 500
					ISBN: 103, Title: Java For Dummies, Price: 300
				 */

    cout<<endl;
    Book jfd=bs1.getBookInfo("Java For Dummies");
    jfd.print();  /*Output:
					 ISBN: 103, Title: Java For Dummies, Price: 300
				 */

    cout<<endl;
    Book ba[3]= {Book(201,"Operating Systems",1000),Book(202,"Compilers",2000),Book(203,"Computer Networks",1500)};
    BookShop bs2("Puthighor",5);
    bs2.addBook(ba,3);
    bs2.print();  /*Output:
					 Bookshop Name: Puthighor
					 ISBN: 201, Title: Operating Systems, Price: 1000
					 ISBN: 202, Title: Compilers, Price: 2000
					 ISBN: 203, Title: Computer Networks, Price: 1500
				 */

    cout<<endl;
    BookShop bs3=bs1.mergeShop(bs2);
    bs3.setName("Mullick Brothers");
    bs3.print(); /*Output:
					Bookshop Name: Mullick Brothers
					ISBN: 101, Title: Teach Yourself C++, Price: 500
					ISBN: 103, Title: Java For Dummies, Price: 300
					ISBN: 201, Title: Operating Systems, Price: 1000
					ISBN: 202, Title: Compilers, Price: 2000
					ISBN: 203, Title: Computer Networks, Price: 1500
				 */

}
