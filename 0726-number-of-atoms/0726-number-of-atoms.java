class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> atomCounts = parseFormula(formula);
        TreeMap<String, Integer> sortedAtoms = new TreeMap<>(atomCounts);
        
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedAtoms.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }
        
        return result.toString();
    }

    private Map<String, Integer> parseFormula(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentMap = new HashMap<>();
        
        int i = 0;
        while (i < formula.length()) {
            char ch = formula.charAt(i);
            
            if (ch == '(') {
                stack.push(currentMap);
                currentMap = new HashMap<>();
                i++;
            } else if (ch == ')') {
                int start = ++i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                if (!stack.isEmpty()) {
                    Map<String, Integer> topMap = stack.pop();
                    for (String atom : currentMap.keySet()) {
                        topMap.put(atom, topMap.getOrDefault(atom, 0) + currentMap.get(atom) * multiplicity);
                    }
                    currentMap = topMap;
                }
            } else {
                int start = i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String atom = formula.substring(start, i);
                
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                
                currentMap.put(atom, currentMap.getOrDefault(atom, 0) + count);
            }
        }
        
        return currentMap;
  
    }
}