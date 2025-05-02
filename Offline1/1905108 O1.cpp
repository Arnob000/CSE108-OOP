#include <iostream>
#include<cmath>

using namespace std;

class Point
{
    // x and y coordinate
    int x, y;
public: //constructor(s) to initialize x and y
    Point()
    {
        x=0;
        y=0;
    }
    Point(int i,int j)
    {
        x=i;
        y=j;
    }
    //set and get functions for x and y

    setPoint(int a,int b)
    {
        x=a;
        y=b;
    }
    int getX()
    {
        return x;
    }
    int getY()
    {
        return y;
    }
    void print()
    {
        cout << "Coordinate: "<< x <<", " <<y <<endl;
    }
};


class Circle
{
    Point p;
    int radius;
public: // constructor to initialize p and radius
    Circle(int i,int j,int k)
    {
        p.setPoint(i,j);
        radius=k;
    }
    // Overload “update” functions
    update(int a,int b)
    {
        int i,j;
        i=p.getX()+a;
        j=p.getY()+b;
        p.setPoint(i,j);
    }
    update(int r)
    {
        radius=radius+r;
    }
    update(int a,int b,int c)
    {
        update(a,b);
        update(c);
    }
    void print()
    {
        cout << "Center ";
        p.print();
        cout << "Radius: " << radius << endl;
    }
};


class Line
{
    Point p1,p2;
public:
    //constructor
    Line(int a1, int b1, int a2, int b2)
    {
        p1.setPoint(a1,b1);
        p2.setPoint(a2,b2);
    }
    //lenth
    lenth()
    {
        int x,y;
        x=(p1.getX()-p2.getX())*(p1.getX()-p2.getX());
        y=(p1.getY()-p2.getY())*(p1.getY()-p2.getY());
        cout<<"Lenth= "<<sqrt(x+y)<<endl;
    }
};

int main()
{
    Point p(5,5);
    Circle c(2, 3, 5);

    cout << endl << "Point Display" <<endl;
    p.print();

    cout << endl << "Circle Display" <<endl;
    c.print();
    cout << endl;

    //First update
    cout << "First Update" << endl;
    // calling “update” function of Circle class to increase the center’s x coordinate by 5 and y coordinate by 5;
    c.update(5,5);
    c.print();
    cout <<endl;

    //Second update
    cout << "Second Update" << endl;
    // calling “update” function of Circle class to increase the radius by 6;
    c.update(6);
    c.print();
    cout << endl;

    //Third update
    cout << "Third Update" << endl;
    // calling “update” function of Circle class to increase the center’s x coordinate by 2 and y coordinate by 2 and the radius by 2;
    c.update(2,2,2);
    c.print();
    cout << endl;

    Line l(3,10,11,4);
    cout << endl << "Line Display" <<endl;
    l.lenth();

    return 0;
}
