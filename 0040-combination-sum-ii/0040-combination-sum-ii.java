class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(tempList)); 
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > remain) break;  

            tempList.add(candidates[i]);
            backtrack(res, tempList, candidates, remain - candidates[i], i + 1); 
            tempList.remove(tempList.size() - 1); 
        }
    }

    
    }