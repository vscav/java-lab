package fr.umlv.fight;

public class Arena {

	static Robot fight(Robot first, Robot second) {		
		boolean firstRobotTurn = true;

		while (!first.isDead() && !second.isDead()) {
			if (firstRobotTurn) {
				first.fire(second);
			} else {
				second.fire(first);
			}
			firstRobotTurn = !firstRobotTurn;
		}
		
		 return !firstRobotTurn ? first : second;
	}

}
