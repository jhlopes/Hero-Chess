package character;

public class Damage {

	public Damage(DamageType damageType, int amount) {
		this.type = damageType;
		this.amount = amount;
	}

	public Damage(int wantedTargedCol, int wantedTargetRow) {
		this.targetCol = wantedTargedCol;
		this.targetRow = wantedTargetRow;
	}

	private int amount;
	private DamageType type;
	private int targetCol;
	private int targetRow;

	public int getAmount() {
		return amount;
	}

	public DamageType getType() {
		return type;
	}

	public void fillProperties(Damage damageProperties) {

		this.type = damageProperties.getType();
		this.amount = damageProperties.getAmount();
	}

	public int getTargetCol() {
		return this.targetCol;
	}

	public int getTargetRow() {
		return this.targetRow;
	}

}
