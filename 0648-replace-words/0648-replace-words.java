class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, Comparator.comparingInt(String::length));
         String[] words = sentence.split(" ");
         StringBuilder transformedSentence = new StringBuilder();
        for (String word : words) {
            boolean replaced = false;
            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    if (transformedSentence.length() > 0) {
                        transformedSentence.append(" ");
                    }
                    transformedSentence.append(root);
                    replaced = true;
                    break;
                }
            }
            if (!replaced) {
                if (transformedSentence.length() > 0) {
                    transformedSentence.append(" ");
                }
                transformedSentence.append(word);
            }
        }
        
        
        return transformedSentence.toString();
    }
}