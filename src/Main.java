import java.util.Scanner;

public class Main {

    public static String calc(String input) throws Exception {
        input = input.replaceAll(" ", "");
        if (checkString(input)){
            Operators operator = getOperator(input);
            Integer firstNumb = Integer.valueOf(input.split(operator.toString())[0]);
            Integer secondNumb = Integer.valueOf(input.split(operator.toString())[1]);
            switch (operator){
                case PLUS:
                    return String.valueOf(firstNumb + secondNumb);
                case MINUS:
                    return String.valueOf(firstNumb - secondNumb);
                case MULTIPLY:
                    return String.valueOf(firstNumb * secondNumb);
                case DIVISION:
                    return String.valueOf(firstNumb / secondNumb);
            }
        }else {
            throw new Exception("Неверное верыжение!");
        }
        return null;
    }

    private static boolean checkString(String string) {
        for (Operators op : Operators.values()) {
            if (string.contains(op.getTitle())) {
                String[] onlyNumbs = string.split(op.toString());
                if (onlyNumbs.length == 2) {
                    if (Integer.valueOf(onlyNumbs[0]) >= 1 &&
                            Integer.valueOf(onlyNumbs[1]) >= 1 &&
                            Integer.valueOf(onlyNumbs[0]) <= 10 &&
                            Integer.valueOf(onlyNumbs[1]) <= 10) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Operators getOperator(String string){
        for (Operators op : Operators.values()){
            if (string.contains(op.getTitle())){
                return op;
            }
        }
        return null;
    }

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите выражение: ");
            String procedure = in.nextLine();
            try {
                System.out.println("Результат = " + calc(procedure));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}