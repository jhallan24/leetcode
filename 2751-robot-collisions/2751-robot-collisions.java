class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        

class Robot {
    int position;
    int health;
    char direction;
    int index;

    Robot(int position, int health, char direction, int index) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.index = index;
    }
}


        int n = positions.length;
        List<Robot> robots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }

        
        Collections.sort(robots, Comparator.comparingInt(r -> r.position));

        Stack<Robot> stack = new Stack<>();

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot top = stack.peek();
                    if (top.health > robot.health) {
                        top.health -= 1;
                        robot = null;
                        break;
                    } else if (top.health < robot.health) {
                        robot.health -= 1;
                        stack.pop();
                    } else {
                        stack.pop();
                        robot = null;
                        break;
                    }
                }
                if (robot != null) {
                    stack.push(robot);
                }
            }
        }

        List<Integer> result = new ArrayList<>(Collections.nCopies(n, null));
        for (Robot robot : stack) {
            result.set(robot.index, robot.health);
        }

        result.removeIf(Objects::isNull);
        return result;
    }
}