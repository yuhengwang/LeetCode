class Logger {
    //use hashmap to record the print time
    HashMap<String, Integer> time = new HashMap<>();
    /** Initialize your data structure here. */
    public Logger() {
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!time.containsKey(message)) {
            //update the time
            time.put(message, timestamp);
            return true;
        }  else {
            int printtime = time.get(message);
            if (timestamp - printtime >= 10) {
                time.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
