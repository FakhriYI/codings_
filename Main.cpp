/*
* NAMA : DANIEL ABRAHAM GLORIAWAN ADHI PUTRA
* NPM  : 13.2020.1.00900
*
*/

#include <iostream>

using namespace std;

int arr[100];
int jmlh;

void insert(int posisi, int value) {
  if(posisi > jmlh) {
    arr[posisi] = value;
    if(value == 0 ) {
      jmlh = posisi;
    } else {
      jmlh = posisi+1 ;
    }
  } else {
    insert(posisi+1, arr[posisi]);
    arr[posisi] = value;
  }

}

void input(int jml) {
  for(int i = 0; i < jml; i++) {
    printf("Masukan data[%d] = ", i);
    cin >> arr[i];
  }
}

void printArray() {
  printf("Nilai array = [ ");
  for(int i = 0; i < jmlh; i++) {
    printf("%d ", arr[i]);
    
  }
  printf("] \n");
}

int main(int argc, char const *argv[])
{
  printf("======== PROGRAM INSERT ARRAY ======== \n");
  printf("Masukan jumlah array = ");
  cin >> jmlh;
  input(jmlh);

  printArray();
  
  insert(10,90);
  insert(8,76);
  // insert(20,98);

  printArray();


  return 0;
}

//competitiv programming

