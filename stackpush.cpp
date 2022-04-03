#include <iostream>
#include <conio.h>
using namespace std;

char mobil[2][5];
int topsmall = -1, topbig = -1;
int pilihan;
char inputstack, inputpush;
bool loop = true;

void menu(int pilihan);
void tampilkan();
void push(char elementpush);
void pop(char elementpop);

int main()
{
    char masukan;
    while (loop)
    {
        system("cls");
        cout << "Kode mobil kecil: A-E. Kode mobil besar: F-J" << endl;
        tampilkan();
        cout << "1. Masukkan Mobil" << endl;
        cout << "2. Ambil Mobil" << endl;
        cout << "3. Selesai" << endl;
        cout << "Masukkan Pilihan Anda = ";
        cin >> pilihan;
        menu(pilihan);
    }
}

void tampilkan()
{
    cout << "        _____________________" << endl;
    cout << "   __  | ";
    for (int i = 0; i <= topsmall; i++)
    {
        cout << mobil[0][i] << " , ";
    }
    cout << endl;
    cout << " _//]| | ";
    for (int j = 0; j <= topbig; j++)
    {
        cout << mobil[1][j] << " , ";
    }
    cout << endl;
    cout << "|____|-|_____________________|" << endl;
    cout << "  O      OO       OO      OO" << endl;
}

void menu(int pilihan)
{
    if (pilihan == 1)
    {
        cout << "Kode mobil yang ingin dimasukkan = ";
        cin >> inputstack;
        push(inputstack);
    }
    else if (pilihan == 2)
    {
        cout << "Ingin ambil mobil besar atau kecil ? (B/K) = ";
        cin >> inputpush;
        pop(inputpush);
    }
    else if (pilihan == 3)
    {
        cout << "Program selesai";
        loop = false;
    }
    else
    {
        cout << "pilihan salah";
        getch();
    }
}

void push(char elementpush)
{
    int idpush = int(elementpush);
    if ((idpush >= 65 && idpush <= 69) || (idpush >= 97 && idpush <= 101))
    {
        if (topsmall == 4)
        {
            cout << "kapasitas untuk mobil kecil sudah penuh";
            getch();
        }
        else
        {
            cout << "Menambahkan mobil " << elementpush << " di barisan mobil kecil";
            topsmall++;
            mobil[0][topsmall] = toupper(elementpush);
            getch();
        }
    }
    else if ((idpush >= 70 && idpush <= 74) || (idpush >= 102 && idpush <= 106))
    {
        if (topbig == 4)
        {
            cout << "kapasitas untuk mobil besar sudah penuh";
            getch();
        }
        else
        {
            cout << "Menambahkan mobil " << elementpush << " di barisan mobil besar";
            topbig++;
            mobil[1][topbig] = toupper(elementpush);
            getch();
        }
    }
    else
    {
        cout << "Mobil dengan kode " << elementpush << " tidak ada";
        getch();
    }
}

void pop(char elementpop)
{
    int idpop = int(elementpop);
    if (idpop == 75 || idpop == 107)
    {
        if (topsmall == -1)
        {
            cout << "Oops , tidak ada mobil di barisan mobil kecil";
            getch();
        }
        else
        {
            cout << "Mengambil mobil " << mobil[0][topsmall] << " dari barisan mobil kecil";
            topsmall--;
            getch();
        }
    }
    else if (idpop == 66 || idpop == 98)
    {
        if (topbig == -1)
        {
            cout << "Oops , tidak ada mobil di barisan mobil besar";
            getch();
        }
        else
        {
            cout << "Mengambil mobil " << mobil[1][topbig] << " dari barisan mobil besar";
            topbig--;
            getch();
        }
    }
    else
    {
        cout << "Input salah";
        getch();
    }
}