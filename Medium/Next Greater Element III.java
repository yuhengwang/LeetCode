public class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> num = new ArrayList<>();
        int s = n;
        do {
            num.add(s % 10);
            s /= 10;
        } while (s > 0);
        Collections.reverse(num);
        num = nextPermutation(num);
        long res = toNum(num);
        if (res == n || res > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)res;
    }
    public long toNum(ArrayList<Integer> num) {
        Collections.reverse(num);
        long temp = 0;
        long coeff = 1;
        for (int i = 0; i < num.size(); i++) {
            temp = (long)num.get(i) * coeff + temp;
            coeff *= 10;
        }
        return temp;
    }
    public ArrayList<Integer> reverse(int index, ArrayList<Integer> num) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = num.size() - 1; i >= index; i--) {
            temp.add(num.get(i));
        }
        int s = index;
        for (int i = index; i < num.size(); i++) {
            num.set(index++, temp.get(i - s));
        }
        return num;
    }
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> num) {
        int index = -1;
        for (int i = num.size() - 2; i >= 0; i--) {
            if (num.get(i) < num.get(i + 1)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return num;
        }
        int index2 = -1;
        for (int i = num.size() - 1; i >= 0; i--) {
            if (num.get(i) > num.get(index)) {
                index2 = i;
                break;
            }
        }
        int temp = num.get(index);
        num.set(index, num.get(index2));
        num.set(index2, temp);
        //reverse after index
        num = reverse(index + 1, num);
        return num;
        
    }
       
}
