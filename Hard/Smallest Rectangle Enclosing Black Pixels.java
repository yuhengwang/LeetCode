public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int top = findTop(image, 0, x);
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, image[0].length - 1);
        int down = findDown(image, x, image.length - 1);
       // System.out.println(top + "\t" + left +"\t" + right + "\t" + down);
        return (down - top + 1) * (right - left + 1);
    }
    public int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (emptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (!emptyColumn(image, start)) {
            return start;
        } else {
            return end;
        }
    }
    public int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (emptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (!emptyRow(image, start)) {
            return start;
        } else {
            return end;
        }
    }
    public int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (emptyColumn(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (!emptyColumn(image, end)) {
            return end;
        } else {
            return start;
        }
    }
    public int findDown(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (emptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (!emptyRow(image, end)) {
            return end;
        } else {
            return start;
        }
    }
    public boolean emptyRow(char[][] image, int row) {
        for (int j = 0; j < image[row].length; j++) {
            if (image[row][j] == '1') {
                return false;
            }
        }
        return true;
    }
    public boolean emptyColumn(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }
}
