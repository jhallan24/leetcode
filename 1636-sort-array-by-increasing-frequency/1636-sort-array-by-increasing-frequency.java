class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        
        Arrays.sort(numsArray, (a, b) -> {
            int freqCompare = freqMap.get(a).compareTo(freqMap.get(b));
            if (freqCompare == 0) {
                return b.compareTo(a);
            } else {
                return freqCompare;
            }
        });

        
        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }

    
    }
