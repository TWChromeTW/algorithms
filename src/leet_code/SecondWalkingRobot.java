//task number from leetcode 2069

package leet_code;

public class SecondWalkingRobot {

    private int width, height;
    private long totalDist = 0;
    private int perimeter;

    public SecondWalkingRobot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 2);
    }

    public void step(int num) {
        totalDist += num;
    }

    public int[] getPos() {
        int d = (int) (totalDist % perimeter);

        if (d < width) return new int[]{d, 0};

        d -= (width - 1);
        if (d < height) return new int[]{width - 1, d};

        d -= (height - 1);
        if (d < width) return new int[]{width - 1 - d, height - 1};

        d -= (width - 1);
        return new int[]{0, height - 1 - d};
    }

    public String getDir() {
        int d = (int) (totalDist % perimeter);

        if (totalDist > 0 && d == 0) return "South";

        if (d < width) return "East";
        if (d < width + height - 1) return "North";
        if (d < 2 * width + height - 2) return "West";
        return "South";
    }

}

/**
 * Your Robot object will be instantiated and called as such:
 * SecondWalkingRobot obj = new SecondWalkingRobot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */