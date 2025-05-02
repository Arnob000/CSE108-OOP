#include<iostream>
#include<cstring>
using namespace std;

class Vector
{
    char *name;
    int x,y,z;
public:
    Vector(char *n)  //Constructor
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=0;
        y=0;
        z=0;
    }
    Vector(char *n, int a, int b, int c)  //Constructor
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=a;
        y=b;
        z=c;
    }

    int setX(int a){x=a;}  //set functions
    int setY(int b){y=b;}
    int setZ(int c){z=c;}

    void setName(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
    }

    int getX(){return x;}   //get functions
    int getY(){return y;}
    int getZ(){return z;}

    char *getName(){return name;}

    ~Vector()          //Destructor
    {
        delete []name;
    }

    Vector(const Vector& v)  //copy constructor
    {
        int l = strlen(v.name);
        this->name = new char[l+1];
        strcpy(this->name,v.name);
        this->x=v.x;
        this->y=v.y;
        this->z=v.z;
    }

    print ()     //printing vector
    {
        cout<<name<<": "<<x<<"x";
        if(y>=0)cout<<"+"<<y<<"y";
        else cout<<y<<"y";
        if(z>=0)cout<<"+"<<z<<"z"<<endl;
        else cout<<z<<"z"<<endl;
    }

    Vector operator^(Vector a)  //member function for cross multiplication
    {
        Vector temp("Result1");
        temp.x=(y*a.z-z*a.y);
        temp.y=-(x*a.z-z*a.x);
        temp.z=(x*a.y-y*a.x);

        return temp;
    }

    int operator==(Vector a)  //member function for checking equality
    {
        if((x==a.x)&&(y==a.y)&&(z==a.z))
            return 1;
        else
            return 0;
    }

    Vector operator*(int a)  //member function for v1=v1*a;
    {
        x=x*a;
        y=y*a;
        z=z*a;

        return *this;
    }

     Vector operator*(Vector a)  //member function for v3=v1*v2;
    {
        Vector temp("Result1");
        temp.x=x*a.x;
        temp.y=y*a.y;
        temp.z=z*a.z;

        return temp;
    }

    friend Vector operator*(int a, Vector v);

};

Vector operator*(int a, Vector v)  //friend function for v2=a*v2;
{
    v.x=a*v.x;
    v.y=a*v.y;
    v.z=a*v.z;

    return v;
}

int main()
{
    Vector v1("v1", 1,2,3), v2("v2", 4, 5, -6), v3("Result1"),v4("Result2",-27,18,-3);

    v1.print();     ///Printing the components of vector v1
    v2.print();     ///Printing the components of vector v2

    v3=v1^v2;       ///Calculating the cross product of vector v1 and vector v2 (Considering ^ as cross product for this assignment)
    v3.print();     ///Printing the modified components of vector v3 (Name: Result1)

    if(v3==v4)      ///Checking for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    v1= v1*2;       ///Multiplying each component of vector v1 with the given value
    v1.print();     ///Printing the modified components of vector v1

    v2=2*v2;        ///Multiplying each component of vector v2 with the given value
    v2.print();     ///Printing the modified components of vector v2

    v3=v1*v2;       ///Multiplying each component of vector v1 with the corresponding component of vector v2.
    v3.print();     ///Printing the modified components of vector v3 (Name: Result1)

    if(v3==v4)      ///Checking for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    return 0;
}
