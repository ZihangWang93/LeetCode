package com.example.EvaluationDivision;

import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i< equations.size(); i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            HashMap<String, Double> temp1 = graph.getOrDefault(s1, new HashMap<>());
            temp1.put(s2, values[i]);
            graph.put(s1, temp1);
            HashMap<String, Double> temp2 = graph.getOrDefault(s2, new HashMap<>());
            temp2.put(s1, 1.0 / values[i]);
            graph.put(s2, temp2);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }

        return result;
    }

    private double dfs(String s1, String s2, HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited) {
        if (!graph.containsKey(s1)) return -1.0;
        if (s1.equals(s2)) return 1.0;
        if (graph.get(s1).containsKey(s2)) return graph.get(s1).get(s2);

        visited.add(s1);
        for (String s : graph.get(s1).keySet()) {
            if (visited.contains(s)) continue;
            double temp = dfs(s, s2, graph, visited);
            if (temp == -1.0) {
                continue;
            }
            return temp * graph.get(s1).get(s);
        }

        return -1.0;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new LinkedList<>();
        List<String> q1 = new LinkedList<>();
        q1.add("x1");
        q1.add("x2");
        equations.add(q1);

        List<String> q2 = new LinkedList<>();
        q2.add("x2");
        q2.add("x3");
        equations.add(q2);

        List<String> q3 = new LinkedList<>();
        q3.add("x3");
        q3.add("x4");
        equations.add(q3);

        List<String> q4 = new LinkedList<>();
        q4.add("x4");
        q4.add("x5");
        equations.add(q4);

        List<List<String>> queries = new LinkedList<>();
        List<String> qu1 = new LinkedList<>();
        qu1.add("x1");
        qu1.add("x5");
        queries.add(qu1);

        double[] values = new double[]{3.0, 4.0, 5.0, 6.0};
        Solution s = new Solution();

        System.out.print(s.calcEquation(equations, values, queries));
    }
}
