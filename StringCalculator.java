

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        int calc = 0;
        int is_negative = 0;
        StringBuilder regex = new StringBuilder("\\\\n|,");
        String trash = "*$()+.?^|{}[]";
        if(numbers.charAt(0) == '/' && numbers.charAt(1) == '/' && numbers.charAt(3) == '\\' && numbers.charAt(4) == 'n' ){
            regex = new StringBuilder();
            regex.append(numbers.charAt(2));
            numbers = numbers.substring(5);
        } else if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/' && numbers.contains("\\n")) {
            String delimiters = numbers.substring(3,numbers.indexOf("\\n")-1);
            String[] delimiter = delimiters.split("]\\[");
            regex = new StringBuilder();
            for(String del : delimiter){
                for(int i=0; i<del.length(); i++){
                    if(trash.contains(String.valueOf(del.charAt(i)))){
                        regex.append("\\").append(del.charAt(i));
                    }
                    else{
                        regex.append(del.charAt(i));
                    }
                }
                regex.append("|");
            }
            regex = new StringBuilder(regex.substring(0, regex.length() - 1));
            numbers = numbers.substring(numbers.indexOf("\\n")+2);
        }
        Pattern pattern = Pattern.compile(String.valueOf(regex.toString()));
        String[] sum = pattern.split(String.valueOf(numbers));
        for (String nums : sum) {
            if(nums.isEmpty()){
                return -1;
            }
            int num;
            try{
                num = Integer.parseInt(nums);
            }catch(Exception e){
                return -1;
            }
            if(num < 0){
                if(is_negative == 0) System.out.println("Negative is not allowed");
                System.out.println(num);

                is_negative = 1;
            }
            if(num<=1000) calc += num;
        }
        if(is_negative == 0){
            return calc;
        }
        else{
            return -2;
        }
    }
    public static void main(String[] args) {
        StringCalculator SC = new StringCalculator();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть числа: ");
        String input = scan.nextLine();
        int sum = SC.add(input);
        if(sum == -1){
            System.out.println("Error");
        }else
        if(sum == -2){

        }else {
            System.out.println(sum);
        }
    }

}