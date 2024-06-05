class Solution {
    public List<String> commonChars(String[] words) {
        int[] result = new int[26];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        
        for (String word : words) {
            int[] currentCount = new int[26];
            for (char c : word.toCharArray()) {
                currentCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                result[i] = Math.min(result[i], currentCount[i]);
            }
        }
        
    
        List<String> commonChars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (result[i] > 0) {
                commonChars.add(Character.toString((char)(i + 'a')));
                result[i]--;
            }
        }
        
        return commonChars;
    }
    

    }
