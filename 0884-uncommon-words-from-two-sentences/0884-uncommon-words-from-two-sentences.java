class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
         String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
 HashMap<String, Integer> wordCount = new HashMap<>();
for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
List<String> result = new ArrayList<>();
for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                result.add(word);
            }
        }

        
        return result.toArray(new String[0]);
    
    }
}