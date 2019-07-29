package com.example.EvaluationDivision;

import java.util.*;

public class SolutionTwo {
    HashMap<String, String> root;
    HashMap<String, Double> dis;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        root = new HashMap<>();
        dis = new HashMap<>();
        double[] result = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String s1 = findRoot(eq.get(0));
            String s2 = findRoot(eq.get(1));
            root.put(s1, s2);
            dis.put(s1, values[i] * dis.get(eq.get(1)) / dis.get(eq.get(0)));
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String s1 = q.get(0);
            String s2 = q.get(1);
            if (!dis.containsKey(s1) || !dis.containsKey(s2) || !findRoot(s1).equals(findRoot(s2))) result[i] = -1.0;
            else {
                result[i] = dis.get(s1) / dis.get(s2);
            }
        }

        return result;

    }

    private String findRoot(String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dis.put(s, 1.0);
            return s;
        }

        if (s.equals(root.get(s))) {
            return s;
        }

        String temp = root.get(s);
        String rootP = findRoot(temp);
        root.put(s, rootP);
        dis.put(s, dis.get(s) * dis.get(temp));
        return rootP;
    }
}
