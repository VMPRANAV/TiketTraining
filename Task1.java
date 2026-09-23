
class MyList<I extends Number> {
    private int cap;
    private int[]arr;
    private int curr;
   ;
    public MyList(int cap){
        this.cap=cap;
       this.arr= new int[cap];
        this.curr=0;

    }
    public void add(int value){
        if(curr>=cap) expand();
        arr[curr++]=value;
    }
    public void deleteByValue(int value){
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
    public int getByIdx(int givIdx){
if(givIdx>=curr) {
    System.out.println("Index  not Exist");
    return -1;
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
        int[]newArray= new int[newCap];
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
int newArray[]= new int[newCap];
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
public  class Task1{
    public static void main(String[] args) {
        MyList<Number> myList= new MyList<Number>(100);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        System.out.println(myList.size()+" "+myList.getCap());
        myList.add(6);
        System.out.println(myList.size()+" "+myList.getCap());
        myList.printArray();
        myList.deleteByValue(6);
        System.out.println(myList.size()+" "+myList.getCap());
        myList.printArray();
        myList.deleteByValue(5);
        System.out.println(myList.size()+" "+myList.getCap());
        myList.deleteByIdx(0);

        System.out.println(myList.size()+" "+myList.getCap());
        myList.deleteByIdx(0);
        myList.printArray();
        myList.deleteByIdx(0);
        myList.printArray();
        myList.deleteByIdx(0);

        myList.printArray();

    }
}

