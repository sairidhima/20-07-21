import java.util.Stack;


class Main {

    /**
     * 3.4 In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
     * different sizes which can slide onto any tower.The puzzle starts with disks sorted
     * in ascending order of size from top to bottom (i.e., each disk sits on top of an even
     * larger one). You have the following constraints:
     * (1) Only one disk can be moved at a time.
     * (2) A disk is slid off the top of one tower onto the next tower.
     * (3) A disk can only be placed on top of a larger disk.
     * Write a program to move the disks from the first tower to the last using stacks.
     * <p>
     * Solution:
     * To move N disks from tower A to tower B:
     * 1. move top N -1 disks from tower A to tower C
     * 2. move N'th disk from tower A to tower B
     * 3. move top N-1 disks from tower C to tower B
     *
     * @Runtime & spaces
     * runtime: O(2^n)
     * space: O(n)
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        int diskNumber = 3;
        Tower[] myTower = new Tower[3];
        for (int i = 0; i < 3; i++) {
            myTower[i] = new Tower(i);
        }
        for (int i = diskNumber - 1; i >= 0; i--) {
            myTower[0].add(i);
        }
        myTower[0].moveDisks(diskNumber, myTower[1], myTower[2]);
    }
}

class Tower {
    int index;
    Stack<Integer> disks;

    public Tower(int i) {
        // TODO Auto-generated constructor stub
        disks = new Stack<Integer>();
        index = i;
    }

    public void moveDisks(int diskNumber, Tower buffer, Tower destination)
            throws Exception {
        // TODO Auto-generated method stub
        if (diskNumber > 0) {
            moveDisks(diskNumber - 1, destination, buffer);
            moveTo(destination);
            buffer.moveDisks(diskNumber - 1, this, destination);
        } else
            return;
    }

    private void moveTo(Tower destination) throws Exception {
        // TODO Auto-generated method stub
        int t = disks.pop();
        destination.add(t);
        System.out.println("Now moving " + t + "from " + this.index + " to "
                + destination.index);
    }

    public void add(int val) throws Exception {
        // TODO Auto-generated method stub
        if ((!disks.isEmpty()) && disks.peek() < val) {
            throw new Exception("Error placing disk " + val);
        } else {
            disks.push(val);
        }
    }

}


