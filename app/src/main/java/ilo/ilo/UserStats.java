package ilo.ilo;

public class UserStats {


    public int modulePercentCompleted(){
        return 0;
    }

    //compares overall scores of every user put into an array
    //returns ranking of user's overall score
    public int overallRanking(int[] arr, int userScore) {
        //sorts scores in the array
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //searches for the score to return rankings
        int first = 0, last = arr.length - 1;
        while (first <= last)
        {
            int m = first + (last-1)/2;
            //returns ranking
            if (arr[m] == userScore)
                return m+1;
            // If x greater, ignore left half
            if (arr[m] < userScore)
                first = m + 1;
                // If x is smaller, ignore right half
            else
                last = m - 1;
        }
        // if we reach here, then score was not present
        return -1;
    }

    //array contains scores of last 7 days
    //user score is from the last seven days
    public int weeklyRanking(int[] arr, int userScore){
        return overallRanking(arr, userScore);
    }
}
