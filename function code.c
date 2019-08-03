#include<stdio.h>
#include<conio.h>
/* Write a Function that takes a list of integers and prints a list that contains product
of every integer at each index except the integer at that index.*/
void get_products_of_all_ints_except_at_index(int[]);
void main(){
int a[4],i,j,b[4];
printf("Enter 4 integers ");
for(i=0;i<4;i++){
scanf("%d",&a[i]);
}
get_products_of_all_ints_except_at_index(&a[0]);
getch();
}
void get_products_of_all_ints_except_at_index(int *a){
int i,j,b[4];
for(i=0;i<4;i++){
        b[i]=1;
for(j=0;j<4;j++){
if(i!=j)
b[i]*=a[j];
}
}
for(i=0;i<4;i++)
printf("%d ",b[i]);
}
