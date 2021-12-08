import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        int x, y;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива X..Y через пробел ---> ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        String array[][] =new String[x][y];
        try {
            initArray(array, x, y, scanner);
            scanner.close();
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }

    private static void initArray (String[][] array, int x, int y, Scanner scanner) throws MyArraySizeException, MyArrayDataException {
        int summa = 0;
        int [][] arrayToInt = new int[x][y];
        if (x != 4 || y != 4) throw new MyArraySizeException("Задан неверный размер массива 4х4");
        System.out.printf("Массив: %s x %s\n ", x, y);
        for (int i = 0; i < x; i++) {
            for (int k = 0; k < y; k++) {
                System.out.println("Введите значение: " + (k + 1));
                System.out.print("Строка " + (i + 1) + " Столбец " + (k + 1) + " ---> ");
                array[i][k] = scanner.next();
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array.length; k++) {
                try {
                    arrayToInt[i][k] = Integer.parseInt(array[i][k]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверное значение в ячейке массива x = " + (i + 1) + " y = " + (k + 1));
                }
                summa += arrayToInt[i][k];
            }
        }
        System.out.println("Сумма всех значений массива: =  " + summa);
    }
}

class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String message) {
        super(message);
    }

}

class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super(message);
    }

}

