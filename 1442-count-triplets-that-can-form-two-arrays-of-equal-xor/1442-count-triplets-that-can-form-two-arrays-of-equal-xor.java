class Solution {
    public int countTriplets(int[] arr) {
      int total=0;
        for(int i=0;i<arr.length;i++){
            int xor=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(xor==arr[j]){
                    total=total+j-i;
                }
                xor=xor^arr[j];
            }
        }
        return total;
    }
}