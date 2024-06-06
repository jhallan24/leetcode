class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
                if (hand.length % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        
        List<Integer> sortedCards = new ArrayList<>(cardCount.keySet());
        Collections.sort(sortedCards);

        
        for (int card : sortedCards) {
            while (cardCount.get(card) > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = card + i;
                    if (cardCount.getOrDefault(currentCard, 0) > 0) {
                        cardCount.put(currentCard, cardCount.get(currentCard) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    


        
    }
}