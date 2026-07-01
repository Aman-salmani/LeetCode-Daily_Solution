class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        List<Integer>[]bucket = new List[nums.length+1];
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency]==null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer>ans = new ArrayList<>();
        for(int i = bucket.length-1 ; i >= 0 && ans.size() <k; i--){
            if(bucket[i] != null){
                ans.addAll(bucket[i]);
            }
        }
            int arr[] = new int[k];
            for(int i = 0 ; i < arr.length ; i++){
                arr[i] = ans.get(i);
            }
            return arr;
    }  
}