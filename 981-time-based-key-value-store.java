class TimeMap {
    Map <String, List<TimeNode>> map= new HashMap<>();
    class TimeNode{
        protected String value;
        protected int timestamp;
        TimeNode(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            List<TimeNode> list = new ArrayList<>();
            list.add(new TimeNode(value, timestamp));
            map.put(key, list);
        }else{
            map.get(key).add(new TimeNode(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key ) || map.get(key).size()<=0) return "";
        String current = "";
        if(map.containsKey(key)){
                        List<TimeNode> list = map.get(key);
                        int left = 0;
                        int right = list.size()-1;
                        while(right>=left){
                            int mid = left + (right-left)/2;
                            if(list.get(mid).timestamp == timestamp) return list.get(mid).value;
                            else if(list.get(mid).timestamp>timestamp) right = mid - 1;
                            else { current = list.get(mid).value ;left = mid + 1;}
                        }

        }
        
        return current;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */