import junit.framework.TestCase;

public class ArrayHelperTest extends TestCase {

    public void testPrintln() throws Exception {
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
        // create resource delegate:
        ArrayHelperResource resource = new ArrayHelperResource();
        //
        // result:
        ArrayHelper AH = new ArrayHelper(resource);
        AH.println(leftArray);
    }

    public void testMerge() throws Exception {
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
        //
        // create resource delegate:
        ArrayHelperResource resource = new ArrayHelperResource();
        //
        // result:
        ArrayHelper AH = new ArrayHelper(resource);
        Phone[] merged = AH.merge(leftArray, rightArray);
        AH.println(merged);
    }

    public void testUnique() throws Exception {
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
        //
        // create resource delegate:
        ArrayHelperResource resource = new ArrayHelperResource();
        //
        // print result:
        ArrayHelper AH = new ArrayHelper(resource);
        Phone[] merged = AH.merge(leftArray, rightArray);
        Phone[] unique = AH.unique(merged);
        AH.println(unique);
    }
}