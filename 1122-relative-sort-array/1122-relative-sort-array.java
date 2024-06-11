class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[]fre=new int[1001];
        for(int num:arr1){
            fre[num]++;
        }
        int i=0;
        for(int num:arr2){
            while(fre[num]>0){
                arr1[i]=num;
                fre[num]--;
                i++;
            }
        }
        for(int j=0;j<fre.length;j++){
            while(fre[j]>0){
                arr1[i]=j;
                fre[j]--;
                i++;
            }
        }
        return arr1;
        
    }
}