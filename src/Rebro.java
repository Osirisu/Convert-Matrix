public class Rebro {
    private int name;
    private final int i;
    private final int j;

    public static int ID = 1;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getName() {
        return name;
    }
    public void setName(int name) {
        this.name = name;
    }

    Rebro(int i, int j){
        this.i = i;
        this.j = j;
    }
}
