public class TwoSum {
    List<Integer> numbers = new ArrayList<>();
    HashMap<Integer, Integer> maps = new HashMap<>();
    
    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if (!maps.containsKey(number)) {
            maps.put(number, 1);
            numbers.add(number);
        } else {
            maps.put(number, maps.get(number) + 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for (int i = 0;i < numbers.size(); i++) {
            int num1 = numbers.get(i);
            int residue = value - numbers.get(i);
            if ((num1 == residue && maps.get(num1) > 1) ||
            (num1 != residue && maps.containsKey(residue))) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
