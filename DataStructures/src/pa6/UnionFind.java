package pa6;

import java.util.ArrayList;

public class UnionFind {

    private ArrayList<ArrayList<Integer>> representatives;

    public UnionFind(int initialNumSets) {
        representatives = new ArrayList<>(initialNumSets);
        for (int i = 0; i < initialNumSets; i++) {
            representatives.add(new ArrayList<>());
            makeSet(i);
        }
    } // complete this constructor

    public void makeSet(int x) {
        ArrayList da = new ArrayList();
        da.add(x);
        representatives.set(x, da);
    } // complete this method

    public ArrayList<Integer> find(int x) {
        return representatives.get(x);
    } // complete this method

    private void append(ArrayList<Integer> arg1, ArrayList<Integer> arg2) {
        while (!arg2.isEmpty()) {
            int x = arg2.remove(arg2.size() - 1).intValue();
            representatives.set(x, arg1);
            arg1.add(x);
        }
    } // complete this method

    public void doUnion(int x, int y) {
        ArrayList<Integer> xSet = find(x);
        ArrayList<Integer> ySet = find(y);
        if (xSet != ySet) {
            if (xSet.size() >= ySet.size()) {
                append(xSet, ySet);
            } else {
                append(ySet, xSet);
            }
        }
    } // complete this method
}
