package fr.upem.magazine;

public class LikeEval implements Eval {
	private final boolean like;

	public LikeEval(boolean like) {
		this.like = like;
	}

	@Override
	public int score() {
		return this.like ? 50 : -50;
	}

	@Override
	public String toString() {
		return this.like ? "\uD83D\uDC4D" : "\uD83D\uDC4E";
	}
}
