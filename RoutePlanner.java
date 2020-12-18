import java.util.Scanner;

public class RoutePlanner {

    public static String[][] routes(int n) {
        String[] routes = new String[n];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        for (int i = 0; i < n; i++) {
            routes[i] = sc.nextLine().toLowerCase();

        }
        // for(int i=0;i<n;i++)
        // {

        // System.out.println(routes[i]);

        // }
        System.out.println();

        String[][] rout = new String[n][5];

        for (int i = 0; i < routes.length; i++) {
            String[] splitArr = new String[5];
            splitArr = routes[i].split(", ");

            for (int j = 0; j < 5; j++) { // System.out.print(splitArr[j]);
                rout[i][j] = splitArr[j];
            }
        }
        for (int i = 0; i < routes.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print(rout[i][j] + "  ");
            }
            System.out.println();
        }
        return rout;

    }

    public static String[][] showDirectFlights(String[][] rout, int n) {

        String[][] answer = new String[n][5];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < 5; j++) {
                answer[i][j] = " ";
            }
        }
        System.out.println("Enter the name of a city, for show a list of other cities to which it has direct flights");
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String name = sc.next().toLowerCase();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (rout[i][0].equals(name)) {

                    System.out.print(rout[i][j] + "  ");
                    answer[i][j] = answer[i][j].concat(rout[i][j]);
                    count = 1;

                }
            }
            System.out.println();
        }
        if (count != 1) {
            System.out.println("invalid");
        }
        return answer;

    }

    public static void sorting(String[][] directFlight, int n) {
        String[] temp = new String[5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if(i<n-1)
                {
                if (directFlight[i][1].compareTo(directFlight[i + 1][1]) < 0) {
                    System.out.println(directFlight[i][1]+" ");
                    System.out.print(directFlight[i+1][1]+" ");
                 temp[j] = directFlight[i][j];
                 directFlight[i][j]= directFlight[i+1][j];
                directFlight[i + 1][j] = temp[j];
                // }
                // else
                // {
                //     System.out.println("bye");
                // }
            }
            }
        }
        // System.out.println(directFlight.length);
        // for (int i = 0; i < directFlight.length; i++) {
        // for (int j = 0; j < 5; j++) {

        // // if (directFlight[i][j].equals(" ")) {
        // // break;
        // // } else {
        // System.out.print(directFlight[i][j]);
        // //}
        // }
        // System.out.println();
        // }

    }

    public static void main(String[] args) {
        System.out.println("enter number of routes you want to enter");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] rout = routes(n);

        String[][] directFlight = showDirectFlights(rout, n);

        sorting(directFlight, n);

    }

}
