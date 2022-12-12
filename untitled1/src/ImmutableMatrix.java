public class ImmutableMatrix implements MatrixInterface{
    private final int n, m;
    private final double[][] a;
    ImmutableMatrix(int x, int y){
        this.n = x;
        this.m = y;
        this.a = new double[x][y];
    }
    ImmutableMatrix(ImmutableMatrix arr){
        this.n = arr.get_DimColumn();
        this.m = arr.get_DimRaw();
        this.a = new double[this.n][this.m];
        for(int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.a[i][j] = arr.get_Element(i,j);
            }
        }
    }
    ImmutableMatrix(Matrix arr){
        this.n = arr.get_DimColumn();
        this.m = arr.get_DimRaw();
        this.a = new double[this.n][this.m];
        for(int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.a[i][j] = arr.get_Element(i,j);
            }
        }
    }
    ImmutableMatrix(){
        this.n = 0;
        this.m = 0;
        this.a = null;
    }
    public double[] get_Column(int y){
        double[] column = new double[this.n];
        for(int i = 0; i < this.n; i++){
            System.out.print(this.a[i][y] + " ");
            column[i] = this.a[i][y];
        }
        System.out.println("\n");
        return column;
    }
    public double[] get_Raw(int x){
        double[] raw = new double[this.m];
        for(int i = 0; i < this.m; i++){
            System.out.print(this.a[x][i] + " ");
            raw[i] = this.a[x][i];
        }
        System.out.println("\n");
        return raw;
    }
    public double get_Element(int x, int y){
        //System.out.print(this.a[x][y] + "\n");
        return this.a[x][y];
    }
    public Object set(int x, int y, double number){
        ImmutableMatrix res = new ImmutableMatrix(this.n, this.m);
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                res.a[i][j] = this.a[i][j];
            }
        }
        res.a[x][y] = number;
        return res;
    }
    public Object set_Matrix(double[][] arr){
        ImmutableMatrix res = new ImmutableMatrix(this.n, this.m);
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j <this.m; j++){
                res.a[i][j] = arr[i][j];
            }
        }
        return res;
    }
    public Object set_Random(){
        ImmutableMatrix res = new ImmutableMatrix(this.n, this.m);
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                res.a[i][j] = Math.ceil(Math.random()*10);
            }
        }
        return res;
    }
    public void print(){
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                System.out.print((this.a)[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public int get_DimColumn(){
        return this.n;
    }
    public int get_DimRaw(){
        return this.m;
    }
    public boolean equals(Object arr){
        if(arr.getClass()!=this.getClass()) return false;
        ImmutableMatrix ar = (ImmutableMatrix) arr;
        if(this.n != ar.n || this.m != ar.m)
            return false;
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                if(this.a[i][j] != ar.a[i][j]) return false;
            }
        }
        return true;
    }
    public int hash_Code(){
        return this.hashCode();
    }
}
