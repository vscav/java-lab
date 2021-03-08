package fr.umlv.fight;

public class Arena {

	static Robot fight(Robot first, Robot second) {
		boolean fightTurn = true;

		while (!first.isDead() && !second.isDead()) {
			if (fightTurn) {
				first.fire(second);
			} else {
				second.fire(first);
			}
			fightTurn = !fightTurn;
		}
		
		 return !fightTurn ? first : second;
	}

}
