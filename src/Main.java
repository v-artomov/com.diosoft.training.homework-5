/**
 * Created by Artomov on 18.12.2014.
 *
 * - Переписать свой Pojo в соответствии Builder паттерну
 * - Написать метод  Type[] merge(Type[] leftArray, Type[] rightArray) в отдельном классе (ArrayHelper)
 * - Создать ServiceDelegate для ArrayHelper
 * - написать позитивные тесты
 * - добавить удаление дубликатов в результирующем массиве (результате возвращаемом из метода merge)
 *
 */

public class Main {
    public static void main(String[] args) {
        //
        // create first 6 phone models (leftArray):
        Phone[] leftArray = new Phone[6];
        leftArray[0] = new Phone.Builder().vendor("LG").model("A100").build();
        leftArray[1] = new Phone.Builder().vendor("LG").model("A101").build();
        leftArray[2] = new Phone.Builder().vendor("LG").model("A102").build();
        leftArray[3] = new Phone.Builder().vendor("LG").model("A103").screenSize(22).build();
        leftArray[4] = new Phone.Builder().vendor("LG").model("A104").build();
        leftArray[5] = new Phone.Builder().vendor("LG").model("A105").build();
        //
        // create second 6 phone models (rightArray):
        Phone[] rightArray = new Phone[6];
        rightArray[0] = new Phone.Builder().vendor("SONY").model("SE15").build();
        rightArray[1] = new Phone.Builder().vendor("SONY").model("SE16").screenSize(17).build();
        rightArray[2] = new Phone.Builder().vendor("SONY").model("SE17").build();
        rightArray[3] = new Phone.Builder().vendor("LG").model("A103").screenSize(22).build(); // <-- DUPLICATE !
        rightArray[4] = new Phone.Builder().vendor("APPLE").model("iPhone5").build();
        rightArray[5] = new Phone.Builder().vendor("APPLE").model("iPhone6").build();

        // create resource delegate:
        ArrayHelperResource resource = new ArrayHelperResource();

        System.out.println("LEFT ARRAY:");
        resource.println(leftArray);

        System.out.println();
        System.out.println("RIGHT ARRAY:");
        resource.println(rightArray);

        System.out.println();
        System.out.println("MERGE:");
        ArrayHelper AH1 = new ArrayHelper(resource);
        Phone[] merged = AH1.merge(leftArray, rightArray);
        resource.println(merged);

        System.out.println();
        System.out.println("DELETE DUPLICATES FROM MERGE:");
        ArrayHelper AH2 = new ArrayHelper(resource);
        Phone[] unique = AH2.unique(merged);
        resource.println(unique);
    }
}
