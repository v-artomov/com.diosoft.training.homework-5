import java.util.Arrays;

/**
 * Created by Artomov on 19.12.2014.
 */

public class ArrayHelperResource {
    //
    // print Phone[] array:
    public void println(Phone[] phones) {
        for (int i = 0; i < phones.length; i++) {
            /*
            if (phones[i] == null)
                System.out.println("null");
            else
            */
                System.out.println(phones[i].toString());
        }
    }
    //
    // returns merged leftArray and duplicates from (leftArray, rightArray):
    public Phone[] merge(Phone[] leftArray, Phone[] rightArray) {
        //
        //
        Phone[] res = Arrays.copyOf(leftArray, leftArray.length);
        //
        // find duplicates using equal method:
        int n;
        for (int i = 0; i < leftArray.length; i++)
            for (int j = 0; j < rightArray.length; j++) {
                if (leftArray[i].equals(rightArray[j])) {
                    n = res.length;
                    res = Arrays.copyOf(res, n + 1);
                    res[n] = rightArray[j];
                    break;
                }
            }
        return res;
    }
    //
    // returns Phone[] array without duplicates:
    public Phone[] unique(Phone[] phones) {
        // create temporary boolean array:
        //     False : NonDuplicate;
        //     True  : Duplicate;
        boolean[] binDups = new boolean[phones.length];
        Arrays.fill(binDups, false);
        //
        // search for duplicates:
        int dups = 0;
        for (int i = 0; i < phones.length; i++)
            for (int j = 0; j < phones.length; j++)
                if ((i != j) && (phones[i].equals(phones[j]))) {
                    binDups[j] = true;
                    dups++;
                }
        //
        // create resultant array:
        Phone[] res = new Phone[phones.length - dups];
        int j = 0;
        for (int i = 0; i < phones.length; i++) {
            if (binDups[i] == false) {
                res[j] = phones[i];
                j++;
            }
        }
        return res;
    }
}
