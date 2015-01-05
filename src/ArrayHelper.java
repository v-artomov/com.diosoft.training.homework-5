import java.util.Arrays;

/**
 * Created by Artomov on 18.12.2014.
 *
 */

public class ArrayHelper {
    //
    // resource for delegating:
    private final ArrayHelperResource resource;
    //
    //
    public ArrayHelper(ArrayHelperResource resource) {
        this.resource = resource;
    }
    //
    // delegate 'println':
    public void println(Phone[] phones) {
        resource.println(phones);
    }
    //
    // delegate 'merge':
    public Phone[] merge(Phone[] leftArray, Phone[] rightArray) {
        return resource.merge(leftArray, rightArray);
    }
    //
    // delegate 'unique':
    public Phone[] unique(Phone[] phones) {
        return resource.unique(phones);
    }
}