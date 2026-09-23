import java.util.Scanner;

class SingleDigitException extends  Exception{
    public SingleDigitException(String message){
        super(message);
    }
}

public class Task4 {
    public static void main(String[] args) throws SingleDigitException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
////        String strNum = String.valueOf(num);
//       if( strNum.length>1)

        try {
            if (num<-9||num>9)
                throw new SingleDigitException("The number has more than one digit");
            System.out.println("the number has single digit only Validation passed");

        } catch (SingleDigitException e) {
            throw new RuntimeException(e.getMessage());
        }
        finally {
            System.out.println("Digit Validation Done");
        }
    }
}

