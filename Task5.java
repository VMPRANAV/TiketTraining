import java.util.ArrayList;

class Bank{
 double charge;
 public Bank(){
     this.charge=0;
 }
    protected void  toCharge(double amt) {
        if (amt > 2000.00) {
 charge = 200+ amt*(0.4);
        }
        else{
            charge = 20.00;
        }
        System.out.println(" The amount charged here is "+ charge);
    }

}

class HDFC extends  Bank{
    public HDFC(){
        this.charge=0;
    }
    @Override
    protected   void toCharge(double amt){
        if (amt >= 2000.00) {
            charge = 5+ amt*(0.2);
        }
        else{
            charge = 50.00;
        }
        System.out.println(" The amount charged here is "+ charge);
    }

}
class ICC extends  Bank{
    public ICC(){
        this.charge=0;
    }
    @Override
    public  void toCharge(double amt){
        if (amt > 5000.00) {
            charge = 500+ amt*(0.5);
        }
        else{
            charge = 50.00;
        }
        System.out.println(" The amount charged here is "+ charge);
    }


}

public class Task5 {
    public static void main(String[] args) {
        HDFC hdfc= new HDFC();
        ICC icc= new ICC();
        hdfc.toCharge(2000.00);
        icc.toCharge(4999);


    }



}
