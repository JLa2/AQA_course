public class Matrix { 
    public static int processMatrix(String[][]matrix) throws MyArraySizeException, MyArrayDataException {
    if(matrix.length!=4 || matrix[0].length!=4) {
        throw new MyArraySizeException("Массив должен быть 4*4!");
    }
int sum=0;
for(int i=0; i<4; i++) {
    for(int j=0; j<4; j++) {
        try {
            sum+=Integer.parseInt(matrix[i][j]);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
        }
        }
    }
    return sum;
}
public static void main(String[] args) {
    String[][]matr={
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", "16"}
    };
    try {
        int result=processMatrix(matr);
        System.out.println("Сумма элементов: "+ result);
    }
    catch(MyArraySizeException | MyArrayDataException e) {
        System.out.println("Ошибка: "+e.getMessage());
    }
    try {
        int[]numbers={1, 2, 3};
        System.out.println(numbers[4]);
    } 
    catch(ArrayIndexOutOfBoundsException e) {
        System.out.println("Выход за гарницы массива"+e.getMessage());
    }
}
}