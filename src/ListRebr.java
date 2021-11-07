import java.util.ArrayList;

public class ListRebr {
    private final ArrayList<Rebro> listReb;//= new ArrayList<>();

    ListRebr(){
        listReb = new ArrayList<>();
    }

    public void addReb(Rebro rebro){
        if (rebro != null)
            if ( checkReb(rebro) ) {
                rebro.setName(Rebro.ID++);
                listReb.add(rebro);
            }
    }

    public boolean checkReb(Rebro rebro){
        for (Rebro r: listReb){
            if
            (
                    (r.getI() == rebro.getI() && r.getJ() == rebro.getJ())
                            ||
                    (r.getI() == rebro.getJ() && r.getJ() == rebro.getI())
            )
            {
                return false;
            }
        }

        return true;
    }

    public void outInto(){
        for(Rebro r : listReb){
            System.out.println("Ребро №" + r.getName() + " Вершина:" + r.getI() + " Вершина:" + r.getJ());
        }
    }

    public ArrayList<Rebro> getList(){
        return listReb;
    }
}