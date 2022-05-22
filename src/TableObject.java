import java.util.ArrayList;

public class TableObject {

    private String tableName;
    private ArrayList<Cocktail> tableCocktailArraylist = new ArrayList<>();

    public TableObject(String tableName, ArrayList<Cocktail> tableCocktailArraylist) {
        this.tableName = tableName;
        this.tableCocktailArraylist = tableCocktailArraylist;
    }

    public TableObject(String tableName) {
        this.tableName = tableName;
    }

    public TableObject() {

    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ArrayList<Cocktail> getTableCocktailArraylist() {
        return tableCocktailArraylist;
    }

    public void setTableCocktailArraylist(ArrayList<Cocktail> tableCocktailArraylist) {
        this.tableCocktailArraylist = tableCocktailArraylist;
    }

    @Override
    public String toString() {
        return tableName + " " + tableCocktailArraylist;
    }
}
