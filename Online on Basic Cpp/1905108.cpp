#include<iostream>
#include<stdlib.h>
using namespace std;

class Random
{
    int *row,*col,max,min;


public:
   int mat[50][50];
    Random(int a,int b,int c,int d);

    ~Random()
    {
        free(row);
        free(col);
    }

    print();

    randomize();

    get( int a,int b);

    add(int n);

    add();

};

Random::Random(int a,int b,int c,int d)
{
    row=(int*)malloc(a*sizeof(int));
    col=(int*)malloc(b*sizeof(int));
    min=c;
    max=d;
    int mat[*row][*col];

}
Random::print()
{
    int i,j;

    for(i=0; i<*row; i++)
    {
        for(j=0; j<*col; j++)
        {
            cout<<mat[i][j]<<" ";
        }
        cout<<endl;
    }
}

Random::randomize()
{
    int i,j;

    for(i=0; i<*row; i++)
        for(j=0; j<*col; j++)
        {
            int ran=0;
            while(ran<min || ran>max)
            {
                ran=rand();
            }
            mat[i][j]=ran;

        }
}

Random::get( int a,int b)
{

    cout<<mat[a][b];
}
Random::add(int n)
{
    int i,j;

    for(i=0; i<*row; i++)
        for(j=0; j<*col; j++)
        {
            mat[i][j]=mat[i][j]+n;
        }
}
Random::add()
{
    int i,j,sum=0;

    for(i=0; i<*row; i++)
        for(j=0; j<*col; j++)
        {
            sum+=mat[i][j];
        }
    return sum;
}

int main()
{
    cout<<"Hello World"<<"\n";

    Random m(3,3,100,200);
    m.randomize();
    m.print();
    cout<<m.get(0,0)<<endl;
    m.add(100);
    m.print();
    cout<<m.add()<<endl;



    return 0;

}
