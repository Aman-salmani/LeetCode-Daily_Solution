class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int arr[] = new int[k];
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        List<Map.Entry<Integer,Integer>>list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue()-a.getValue());
        for(int i = 0 ; i < k ; i++){
            arr[i] = list.get(i).getKey();
        }
        return arr;
    }
}