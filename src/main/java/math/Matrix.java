package math;

/**
 * Matrix Class, We will take inspiration from the numpy and Pytorch
 */
public class Matrix {

    private double[][] data;
    private int rows;
    private int cols;

    public Matrix(double[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }

    public Matrix(int rows, int cols){
        this(new double[rows][cols]);
    }

    /**
     * Vector Multiplication Implementation in the Matrix.
     * I am a looser, Cant implement Tensor :(
     * @param v
     * @return
     */
    public Vector multiply(Vector v){
        double[] output = new double[rows];
        for(int y=0; y< rows; y++){
            output[y] = new Vector(data[y]).dot(v);

        }

        return new Vector(output);
    }
}
