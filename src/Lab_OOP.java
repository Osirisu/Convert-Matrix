import java.util.ArrayList;
import java.util.Arrays;

public class Lab_OOP {

    public static void main(String[]args){
        int[][] matrix = new int[5][];

        matrix[0] = new int[]{0,0,1,0,1};
        matrix[1] = new int[]{0,0,0,1,1};
        matrix[2] = new int[]{1,0,0,1,0};
        matrix[3] = new int[]{0,1,1,0,1};
        matrix[4] = new int[]{1,1,0,1,0};

        System.out.println("Матрица смежности:");
        output_aDouble_Array( matrix );

        matrix = envelopeBetween_AdjacencyAndIncidence( matrix );
    }

    public static boolean isAdjacencyMatrix(int[][]matrix){
        if (matrix.length == matrix[0].length)
        {
            for (int i = 0; i < matrix.length; ++i)
            {
                for (int j = 0; j < matrix.length; ++j)
                {
                    if ( !(matrix[i][j] == matrix[j][i]) )
                    {
                        return false;
                    }
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }

    public static int[][] envelopeBetween_AdjacencyAndIncidence(int[][]matrix){
        int[][] result;

        if ( isAdjacencyMatrix( matrix ) ){
            result = translationToMatrixI( matrix,findingEdges( matrix ) );
            System.out.println();
            System.out.println("Матрица инциденции:");
        }
        else{
            result = translationToMatrixS( matrix,findingEdges( matrix ) );
            System.out.println();
            System.out.println("Матрица смежности:");
        }

        output_aDouble_Array( result );
        return result;
    }
    public static int[][] envelopeBetween_AdjacencyAndIncidence(int[][]matrix,ListRebr listRebr){
        int[][] result;

        if ( isAdjacencyMatrix( matrix ) ){
            result = translationToMatrixI( matrix,listRebr );
            System.out.println();
            System.out.println("Матрица инциденции:");
        }
        else{
            result = translationToMatrixS( matrix,listRebr );
            System.out.println();
            System.out.println("Матрица смежности:");
        }

        return result;
    }
    public static ListRebr findingEdges(int[][] matrix){
        ListRebr listRebr;

        System.out.println();
        System.out.println("Рёбра:");

        if ( isAdjacencyMatrix(matrix) ){
            listRebr = find_Edges_inGraph_fromMatrixS( matrix );
        }
        else{
            listRebr = find_Edges_inGraph_fromMatrixI( matrix );
        }

        listRebr.outInto();
        return listRebr;
    }

    public static void output_aDouble_Array(int[][] arr){
        for (int[] a: arr){
            for(int b: a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
    public static void filling_aDoubleArray_withZeros(int[][] aDoubleArray){
        for (int[] ints : aDoubleArray) {
            Arrays.fill(ints, 0);
        }
    }

    public static ListRebr find_Edges_inGraph_fromMatrixS(int[][] matrixS){
        ListRebr listReb = new ListRebr();

        int colV = matrixS.length;
        for (int i = 1;i <= colV;++i){
            for (int j = 1;j <= colV;++j){
                if ( matrixS[i-1][j-1] == 1 ){
                    listReb.addReb( new Rebro(i,j) );
                }
            }
        }

        Rebro.ID = 1;
        return listReb;
    }
    public static int[][] translationToMatrixI(int[][]matrixS,ListRebr listReb){
        ArrayList<Rebro> rebros = listReb.getList();

        int colV = matrixS.length;
        int colR = rebros.size();

        int[][]result = new int[colV][colR];
        filling_aDoubleArray_withZeros( result );

        for (int i = 0;i < colV;++i){
            for (int j = 0;j < colR;++j){
                if ( (i+1) == rebros.get(j).getI() || (i+1) == rebros.get(j).getJ() ){
                    result[i][j] = 1;
                }
            }
        }

        return result;
    }

    public static ListRebr find_Edges_inGraph_fromMatrixI(int[][] matrixI){
        ListRebr listRebr = new ListRebr();

        for (int i = 0;i < matrixI[0].length;++i){
            int[] arr = new int[2];
            for (int j = 0,k = 0;j < matrixI.length;++j){
                if (matrixI[j][i] == 1){
                    arr[k] = j;
                    ++k;
                }
            }
            listRebr.addReb( new Rebro( arr[0]+1,arr[1]+1 ) );
        }

        Rebro.ID = 1;
        return listRebr;
    }
    public static int[][] translationToMatrixS(int[][] matrixI,ListRebr listRebr){
        int colV = matrixI.length;

        int[][] matrixS = new int[colV][colV];
        filling_aDoubleArray_withZeros( matrixS );

        ArrayList<Rebro> rebros = listRebr.getList();
        for(int i = 0;i <= colV;++i){
            matrixS[rebros.get(i).getI()-1][rebros.get(i).getJ()-1] = 1;
            matrixS[rebros.get(i).getJ()-1][rebros.get(i).getI()-1] = 1;
        }

        return matrixS;
    }
}