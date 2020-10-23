package math;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Vector {
    private double[] data;

    public Vector(double... data){
        this.data = data;

    }

    public Vector(int... data){
        this(Arrays.stream(data).asDoubleStream().toArray());
    }

    public double[] Vector(int size){
        return new double[size];
    }

    public int dimension(){
        return data.length;
    }

    public double dot(Vector u){
        assertCorrectDimension(u.dimension());
        double sum = 0;
        for(int i=0; i<data.length; i++){
            sum += data[i]  * u.data[i];
        }

        return sum;
    }

    public void assertCorrectDimension(int inputDimension){
        if(dimension() != inputDimension){
            throw new  IllegalArgumentException("Different Dimension: Input is %d, Vec is %d");
        }

    }

    public Vector map(Function function){
        double[] result = new double[data.length];
        for(int i=0; i<data.length; i++){
            result[i] = function.apply(data[i]);
        }

        return new Vector(result);
    }

    public double[] getData(){
        return data;
    }

    /**
     * Introduce the Lombok Library
     * @return
     */
    @Override
    public String toString() {
        return "Vector{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    /**
     * Return the Index of the Largest Element in the Vector
     * The Algorithm needs to be Optimized
     * @return
     */
    public int indexOfTheLargestElementInTheVector(){
        int indexOfTheLargestElement =0;
        for (int i = 0; i < data.length; i++) {
            if(data[i] > data[indexOfTheLargestElement]){
                indexOfTheLargestElement = i;
            }

        }
        return indexOfTheLargestElement;
    }

    public Vector substraction(Vector vector){
        assertCorrectDimension(vector.dimension());

        double[] result = new double[data.length];

        for(int i=0; i<data.length; i++){
            result[i] = data[i] - vector.data[i];
        }

        return new Vector(result);

    }
}
