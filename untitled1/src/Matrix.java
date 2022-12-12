public class Matrix implements MatrixInterface{
    public int n, m;
    public double[][] a;
    Matrix(int x, int y){
        this.n = x;
        this.m = y;
        this.a = new double[x][y];
    }
    Matrix(Matrix arr){
        this.n = arr.get_DimColumn();
        this.m = arr.get_DimRaw();
        this.a = new double[this.n][this.m];
        for(int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.a[i][j] = arr.get_Element(i,j);
            }
        }
    }
    Matrix(ImmutableMatrix arr){
        this.n = arr.get_DimColumn();
        this.m = arr.get_DimRaw();
        this.a = new double[this.n][this.m];
        for(int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.a[i][j] = arr.get_Element(i,j);
            }
        }
    }
    Matrix(){
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
        return this.a[x][y];
    }
    public Object set(int x, int y, double number){
        this.a[x][y] = number;
        return this;
    }
    public Object set_Matrix(double[][] arr){
        this.n = arr.length;
        this.m = arr[0].length;
        this.a = arr;
        return this;
    }
    public Object set_Random(){
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                this.a[i][j] = Math.ceil(Math.random()*10);
            }
        }
        return this;
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
        Matrix ar = (Matrix) arr;
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

    public static Matrix Random_Column(int n){
        Matrix res = new Matrix(n,1);
        res.set_Random();
        return res;
    }

    public void add(Matrix A){
        if(this.n != A.n || this.m != A.m){
            System.out.print("Matrices has different dimensions!");
            return;
        }
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                this.a[i][j] += A.a[i][j];
            }
        }
    }

    public void add(ImmutableMatrix B){
        Matrix A = new Matrix(B);
        if(this.n != A.n || this.m != A.m){
            System.out.print("Matrices has different dimensions!");
            return;
        }
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                this.a[i][j] += A.a[i][j];
            }
        }
    }
    public void multiply(double k){
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                this.a[i][j] *= k;
            }
        }
    }



}

