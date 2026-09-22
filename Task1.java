class MyList {
  private  int []arr;
  private int idx;
  private int cap;
  MyList(){
    this.arr= new int[cap];
    this.idx=0; 
  }

    public void add(int val){
if(idx==cap) expand();
    arr[idx]=val;
    }
public void delete(int givIdx){
     for(int i=0;i<cap;i++){
        if(i==givIdx){
arr[i]=0;
        }
        for(int j=givIdx;j<cap-1;j++){
         arr[j]=arr[j+1];
        }
     }
}
public int get(int givIdx){
   if (givIdx<0 || givIdx>=cap) return -1;
 return  arr[givIdx];
    }
}
}
public class Task1{
public static void main(String[] args) {
        
    }
    
}
