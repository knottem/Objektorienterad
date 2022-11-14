import java.util.ArrayList;

class MedianFinder {

    ArrayList<Integer> numList;

    public MedianFinder() {
        numList = new ArrayList<>();
    }

    public void addNum(int num) {
        if (numList.size() == 0) {
            numList.add(0, num);
        } else {
            int i = 0;
            while(numList.get(i) <= num && i < numList.size() - 1) {
                i++;
            }
            if (numList.get(i) <= num) {
                numList.add(i + 1, num);
            } else {
                numList.add(i, num);
            }
        }
    }

    public double findMedian() {
        int size = numList.size();
        if (size % 2 == 1) {
            return (double) numList.get((size / 2));
        } else {
            return (double)(numList.get((size - 1) / 2) + numList.get((size + 1) / 2)) / 2;
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(10);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
    }
}