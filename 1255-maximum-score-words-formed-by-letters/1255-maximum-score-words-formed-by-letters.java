class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char letter : letters) {
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        }

        return backtrack(words, letterCount, score, 0);
    }

    private static int backtrack(String[] words, Map<Character, Integer> letterCount, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }

        int skipWordScore = backtrack(words, letterCount, score, index + 1);

        int useWordScore = 0;
        String word = words[index];
        boolean canUseWord = true;

        Map<Character, Integer> tempCount = new HashMap<>(letterCount);
        for (char c : word.toCharArray()) {
            tempCount.put(c, tempCount.getOrDefault(c, 0) - 1);
            if (tempCount.get(c) < 0) {
                canUseWord = false;
                break;
            }
        }

        if (canUseWord) {
            for (char c : word.toCharArray()) {
                useWordScore += score[c - 'a'];
            }
            useWordScore += backtrack(words, tempCount, score, index + 1);
        }

        return Math.max(skipWordScore, useWordScore);
    }
}

    
