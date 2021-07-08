//编写Triple类，实例最多生成3个Triple类的实例，实例编号为0，1，2且可以通过getInstance(Triple t)来获取实例的编号
public class Triple {
    static Triple[] triples = new Triple[3];
    static int next = -1;

    static {
        for (int i = 0; i < 3; i++) {
            triples[i] = new Triple(i);
        }
    }

    private final int index;

    private Triple(int i) {
        index = i;
    }

    public static Triple getTriple() {
        return triples[++next % 3];
    }

    public static Triple getTriple(int i) {
        return triples[i];
    }

    public int getInstance() {
        return index;
    }
}
