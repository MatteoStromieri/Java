import java.util.Arrays;
import java.util.Collection;

public class StrutturaDatiOrdinata<T extends Comparable>{

    public T[] array;

    public StrutturaDatiOrdinata() {
        array = (T[]) new Comparable[0];
    }

    // controllo che i1 <= i2 <= i3 ---
    public boolean checkOrder(){
        for( int i = 0; i - 1 < array.length ; i++){
            if(array[i].compareTo(array[i+1]) > 0){
                return false;
            }
        }
        return true;
    }

    public void addCollection(Collection<T> collection){
        T[] newArray = (T[]) new Comparable[array.length + collection.size()];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        int i = this.array.length;
        T[] collectionArray = (T[]) collection.toArray(new Comparable[collection.size()]);
        for( int j = 0; j < collectionArray.length ; j++){
            newArray[i] = collectionArray[j];
        }
        Arrays.sort(newArray);
        this.array = newArray;
    }

    public void addElement( T element ){
        T[] newArray = (T[]) new Comparable[this.array.length + 1];
        int i = 0;
        for(i = 0; i < this.array.length && this.array[i].compareTo(element) <= 0 ; i++){
            newArray[i] = this.array[i];
        }
        newArray[i] = element;
        System.arraycopy(this.array,i, newArray, i+1, this.array.length - i );
    }
}
