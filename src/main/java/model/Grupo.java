package model;

public class Grupo {
	private int time;
	private int grupo;
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	@Override
	public String toString() {
		return "Grupo [time=" + time + ", grupo=" + grupo + "]";
	}

}
