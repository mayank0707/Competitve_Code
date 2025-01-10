import java.util.Arrays;

//Q. Move the zeroes to end in the given array->

//Solution- 

class MoveZeroToEnd {
    //Optimized method(Time Complexity O(n))
    void solution(int[] input){
        int len = input.length;

        int nonZeroIndex = 0; //Let the NonZeroIndex to copying the NonZeroValues to the required position

        for(int i=0;i<len;i++){
            if(input[i]!=0){
                input[nonZeroIndex]=input[i];
                nonZeroIndex++;
            }
        }

        for(int i=nonZeroIndex;i<len;i++){
            input[i] = 0;
        }

        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,0,5,0,-1,0};

        MoveZeroToEnd obj = new MoveZeroToEnd();
        obj.solution(arr);
    }
}
