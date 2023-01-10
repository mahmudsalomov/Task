import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Box> boxList=new ArrayList<>();

        boxList.add(new Box(10, 10, 5));
        boxList.add(new Box(3, 3, 10));
        boxList.add(new Box(2, 2, 8));
        boxList.add(new Box(9, 5, 3));
        boxList.add(new Box(9, 9, 1));
        boxList.add(new Box(1, 1, 1));
        boxList.add(new Box(2, 2, 2));

        List<Integer> maxSequences = getMaxSequence(boxList);
        System.out.println(maxSequences);
        for (Integer maxSequence : maxSequences) {
            System.out.println(boxList.get(maxSequence));
        }
    }
    static class Box {

        int height, width, depth, area;
        Box(int h, int w, int d)
        {
            this.height = h;
            this.width = w;
            this.depth = d;
            this.area = width * depth;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "height=" + height +
                    ", width=" + width +
                    ", depth=" + depth +
//                    ", area=" + area +
                    '}';
        }

    }
    static List<Integer> getMaxSequence(List<Box> boxes)
    {
        List<List<Integer>> indexes=new ArrayList<>();

        boxes.sort((a, b) -> (b.height * b.width - a.height * a.width));

        System.out.println("Sorted boxes:");
        System.out.println(boxes);
        int[] maxHeight = new int[boxes.size()];
        for(int i = 0; i<boxes.size(); i++) maxHeight[i] = boxes.get(i).height;
        for(int i = 0;i<boxes.size();i++)
        {
            List<Integer> a=new ArrayList<>();

            Box curr = boxes.get(i);
            int val = 0;

            for(int j=0;j<i;j++)
            {
                Box temp = boxes.get(j);
                if(temp.width > curr.width && temp.depth > curr.depth){
                    if (val<maxHeight[j]) a.add(j);
                    val = Math.max(val, maxHeight[j]);
                }
            }

            if (i==boxes.size()-1) a.add(i);
            indexes.add(a);

            maxHeight[i] += val;
        }
        return maxSequenceIndexList(indexes);
    }



    public static List<Integer> maxSequenceIndexList(List<List<Integer>> list){
        int maxSize=list.get(0).size();
        int maxSizeIndex=0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).size()>maxSize) {
                maxSize=list.get(i).size();
                maxSizeIndex=i;
            }
        }
        return list.get(maxSizeIndex);
    }
}