import java.util.ArrayList;
import java.util.List;

class MyListGeneric<T>{
    private int cap;
    private T[]arr;
    private int curr;
    ;
    public MyListGeneric(int cap){
        this.cap=cap;
        this.arr= (T[]) new Object[cap];
        this.curr=0;

    }
    public void add(T value){
        if(curr>=cap) expand();
        arr[curr++]=value;
    }
    public void deleteByValue(T value){
        int deleteIdx=-1;
        for(int i=0;i<curr;i++){
            if(arr[i]==value){
                deleteIdx=i;
                break;

            }
        }
        if(deleteIdx==-1) {
            System.out.println("element not found");
            return;
        }

        move(deleteIdx);

        double gap= ((double)(cap-curr)/cap)*100;

        if(gap>=75){
            shrink();
        }


    }
    public void deleteByIdx(int givIdx){
        int deleteIdx=-1;
        if(givIdx>=curr) {
            System.out.println("Index  not Exist");
            return;
        }
        for(int i=0;i<curr;i++){
            if(i==givIdx){
                deleteIdx=i;
                break;

            }
        }
        if(deleteIdx==-1) {
            System.out.println("element not found");
            return;
        }
        move(deleteIdx);
        double gap= ((double) (cap-curr)/cap)*100;
        if(gap>=75){
            shrink();
        }


    }
    public T getByIdx(int givIdx){
        if(givIdx>=curr) {
            System.out.println("Index  not Exist");
            return null;
        }
        return arr[givIdx];
    }
    public int size(){
        return curr;
    }
    public int getCap(){
        return cap;
    }
    private void expand(){
        int newCap= cap+(cap/2);
        T[]newArray= (T[])new Object[newCap];
        for(int i=0;i<curr;i++){
            newArray[i]=arr[i];

        }

        this.cap=newCap;
        this.arr=newArray;

    }
    private void move(int deleteIdx) {
        for (int i = deleteIdx; i < curr - 1; i++) {
            arr[i] = arr[i + 1];
        }

        curr--;


    }
    private void shrink(){

        int newCap=cap/2;
        T[]newArray= (T[])new Object[newCap];
        for(int i=0;i<curr;i++){
            newArray[i]=arr[i];
        }
        this.cap=newCap;
        this.arr=newArray;

    }
    public void printArray() {
        for (int i = 0; i < curr; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }



}
public  class Task2 {
    public static void main(String[] args) {
MyListGeneric<Integer>lsInt= new MyListGeneric<>(100);
     lsInt.add(1);
        lsInt.add(2);
        lsInt.add(3);
        lsInt.add(4);
        lsInt.add(5);
        System.out.println(lsInt.size()+" "+lsInt.getCap());
        lsInt.add(6);
        System.out.println(lsInt.size()+" "+lsInt.getCap());
        lsInt.printArray();
        lsInt.deleteByValue(6);
        System.out.println(lsInt.size()+" "+lsInt.getCap());
        lsInt.printArray();
        lsInt.deleteByValue(5);
        System.out.println(lsInt.size()+" "+lsInt.getCap());
        lsInt.deleteByIdx(0);

        System.out.println(lsInt.size()+" "+lsInt.getCap());
        lsInt.deleteByIdx(0);
        lsInt.printArray();
        lsInt.deleteByIdx(0);
        lsInt.printArray();
        lsInt.deleteByIdx(0);

        lsInt.printArray();
     MyListGeneric<String>lsStr= new MyListGeneric<>(100);
        lsStr.add("Hello");
        lsStr.add("Hi");
        lsStr.add("Namaste");
        lsStr.add("Vanakam");
        lsStr.add("Hola");
        System.out.println(lsStr.size()+" "+lsStr.getCap());
        lsStr.printArray();
        lsStr.deleteByValue("Hi");
        System.out.println(lsStr.size()+" "+lsStr.getCap());
        lsStr.printArray();
        lsStr.deleteByValue("Namaste");
        lsStr.printArray();
        System.out.println(lsStr.size()+" "+lsStr.getCap());
        lsStr.deleteByIdx(2);
        lsStr.printArray();
        System.out.println(lsStr.size()+" "+lsStr.getCap());
        lsStr.deleteByIdx(1);
        lsStr.printArray();
        System.out.println(lsStr.size()+" "+lsStr.getCap());
        lsStr.deleteByIdx(0);
        lsStr.printArray();
        System.out.println(lsStr.size()+" "+lsStr.getCap());
        lsStr.deleteByIdx(0);
        lsStr.printArray();
        System.out.println(lsStr.size()+" "+lsStr.getCap());

    }
}

